package com.prosesol.api.kyckglobal.controllers;

import com.prosesol.api.kyckglobal.models.RelAfiliadoMoneygram;
import com.prosesol.api.kyckglobal.models.ValidationRequest;
import com.prosesol.api.kyckglobal.models.ValidationResponse;
import com.prosesol.api.kyckglobal.models.dto.ValidationRequestDto;
import com.prosesol.api.kyckglobal.models.exception.ValidationException;
import com.prosesol.api.kyckglobal.services.IRelAfiliadoMoneygramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @Autowired
    private IRelAfiliadoMoneygramService relAfiliadoMoneygramService;

    @PostMapping("validation")
    public ResponseEntity<?> getResponseValidation(@Valid @RequestBody ValidationRequest validationRequest){

        //Map<String, Object> mapResponse = new HashMap<>();
        //ValidationRequest validationRequest = validationRequestDto;
    	String data = "0";
        ValidationResponse validationResponse = new ValidationResponse();
        RelAfiliadoMoneygram afiliadoMoneygram = null;
        
        // Validar datos necesarios
        requestValidation(validationRequest);
        
        
        //valida recieveAcountNumber
        String validaAcountNumber = validationRequest.getReceiveAccountNumber();
        String valid = validaAcountNumber.substring(10, 11);
        String posicionLeft = validaAcountNumber.substring(0, 10);
        String posicionRight = validaAcountNumber.substring(11, 20);
        if(valid.equals("0")) {
        	afiliadoMoneygram =getAfiliadoMoneygram(validationRequest.getReceiveAccountNumber());
        	if( afiliadoMoneygram == null || afiliadoMoneygram.getAfiliado().getId() == null){
                validationResponse.setValid("ERROR");
                validationResponse.setPartnerTransactionId(1);
                validationResponse.setMgiErrorCode("1010");
                validationResponse.setCustomErrorParams("Invalid Account");
                validationResponse.setMessage("Afiliate not found");

                //mapResponse.put("validationResponse", validationResponse);
                return new ResponseEntity<>(validationResponse, HttpStatus.OK);
            }
            Double costoTitular = afiliadoMoneygram.getAfiliado().getServicio().getCostoTitular();
            if(validationRequest.getSendAmount() == costoTitular){
                validationResponse.setValid("PASS");
                validationResponse.setPartnerTransactionId(0);
                validationResponse.setMgiErrorCode("1000");
                validationResponse.setMessage("SUCCESS");

            }else{
                validationResponse.setValid("ERROR");
                validationResponse.setPartnerTransactionId(0);
                validationResponse.setMgiErrorCode("9105");
                validationResponse.setCustomErrorParams(costoTitular.toString());
                validationResponse.setMessage("You need to pay your exact amount due which is "+costoTitular+" "
                							+ " USD");

            }

        }
        else {
        	String moneygramValid = posicionLeft + data + posicionRight;
        	afiliadoMoneygram =getAfiliadoMoneygram(moneygramValid);
        	
        	if( afiliadoMoneygram == null || afiliadoMoneygram.getAfiliado().getId() == null){
                validationResponse.setValid("ERROR");
                validationResponse.setPartnerTransactionId(1);
                validationResponse.setMgiErrorCode("1010");
                validationResponse.setCustomErrorParams("Invalid Account");
                validationResponse.setMessage("Afiliate not found");

                //mapResponse.put("validationResponse", validationResponse);
                return new ResponseEntity<>(validationResponse, HttpStatus.OK);
            }
        	 Double costoTitularInscripcion = afiliadoMoneygram.getAfiliado().getServicio().getCostoTitular() + afiliadoMoneygram.getAfiliado().getServicio().getInscripcionTitular() ;
             if(validationRequest.getSendAmount() == costoTitularInscripcion){
                 validationResponse.setValid("PASS");
                 validationResponse.setPartnerTransactionId(0);
                 validationResponse.setMgiErrorCode("1000");
                 validationResponse.setMessage("SUCCESS");

             }else{
                 validationResponse.setValid("ERROR");
                 validationResponse.setPartnerTransactionId(0);
                 validationResponse.setMgiErrorCode("9105");
                 validationResponse.setCustomErrorParams(costoTitularInscripcion.toString());
                 validationResponse.setMessage("You need to pay your exact amount due which is "+costoTitularInscripcion+" "
                 							+ " USD");

             }
        }
                //mapResponse.put("validationResponse", validationResponse);
        return new ResponseEntity<>(validationResponse, HttpStatus.OK);
    }

    /**
     * Método que valida los datos necesarios
     * @param validationRequest
     * @throws ValidationException
     */
    public void requestValidation(ValidationRequest validationRequest){
        if(validationRequest.getReceiveAmount() == null){
            throw new ValidationException("The receive amount cannot be empty");
        }else if(validationRequest.getReceiveAccountNumber() == null){
            throw new ValidationException("The receive account number cannot be empty");
        }
    }
    
    public RelAfiliadoMoneygram getAfiliadoMoneygram(String ReceiveAccountNumber) {
    	RelAfiliadoMoneygram afiliadoMoneygram = relAfiliadoMoneygramService
                .getAfiliadoMoneygramByIdMoneygram(ReceiveAccountNumber);

    	return afiliadoMoneygram;
    }
}
