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
    public ResponseEntity<?> getResponseValidation(@Valid @RequestBody ValidationRequestDto validationRequestDto){

        Map<String, Object> mapResponse = new HashMap<>();

        ValidationRequest validationRequest = validationRequestDto.getValidation();
        ValidationResponse validationResponse = new ValidationResponse();

        RelAfiliadoMoneygram afiliadoMoneygram = relAfiliadoMoneygramService
                .getAfiliadoMoneygramByIdMoneygram(validationRequestDto.getValidation().getRecieveAccountNumber());

        // Validar datos necesarios
        requestValidation(validationRequest);

        if(afiliadoMoneygram.getAfiliado().getId() == null){
            validationResponse.setValid("ERROR");
            validationResponse.setPartnerTransactionId(1);
            validationResponse.setMgiErrorCode("1001");
            validationResponse.setCustomErrorParams("Internal Server Error");
            validationResponse.setMessage("Afiliate not found");

            mapResponse.put("validationResponse", validationResponse);

            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        }

        if(validationRequestDto.getValidation().getSendAmount() == afiliadoMoneygram.getAfiliado().getServicio().getCostoTitular()){
            validationResponse.setValid("PASS");
            validationResponse.setPartnerTransactionId(0);
            validationResponse.setMgiErrorCode("1000");
            validationResponse.setMessage("SUCCESS");

        }else{
            validationResponse.setValid("ERROR");
            validationResponse.setPartnerTransactionId(0);
            validationResponse.setMgiErrorCode("1002");
            validationResponse.setCustomErrorParams("Internal Server Error");
            validationResponse.setMessage("The amount is not equal to the total amount of the service");

        }
        mapResponse.put("validationResponse", validationResponse);

        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    /**
     * Método que valida los datos necesarios
     * @param validationRequest
     * @throws ValidationException
     */
    public void requestValidation(ValidationRequest validationRequest){
        if(validationRequest.getRecieveAmount() == null){
            throw new ValidationException("The receive amount cannot be empty");
        }else if(validationRequest.getRecieveAccountNumber() == null){
            throw new ValidationException("The receive account number cannot be empty");
        }
    }
}
