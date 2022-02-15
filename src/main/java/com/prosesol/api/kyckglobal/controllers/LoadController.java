package com.prosesol.api.kyckglobal.controllers;

import com.prosesol.api.kyckglobal.models.LoadRequest;
import com.prosesol.api.kyckglobal.models.LoadResponse;
import com.prosesol.api.kyckglobal.models.Pago;
import com.prosesol.api.kyckglobal.models.RelAfiliadoMoneygram;
import com.prosesol.api.kyckglobal.models.exception.LoadException;
import com.prosesol.api.kyckglobal.repository.AfiliadoRepository;
import com.prosesol.api.kyckglobal.services.IPagoService;
import com.prosesol.api.kyckglobal.services.IRelAfiliadoMoneygramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoadController {

    @Autowired
    private IRelAfiliadoMoneygramService relAfiliadoMoneygramService;

    @Autowired
    private IPagoService pagoService;
    
    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @PostMapping(value = "load", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLoadValidation(@Valid @RequestBody LoadRequest loadRequest){

        LoadResponse loadResponse = new LoadResponse();
        Pago pago = new Pago();

        // Validar datos necesarios
        requestLoad(loadRequest);

        // verificar si se está enviando el id desde el request
        if(loadRequest.getReceiveAccountNumber() == null){
            loadResponse.setValid("ERROR");
            loadResponse.setPartnerTransactionId(1);
            loadResponse.setMgiErrorCode("1001");
            loadResponse.setCustomErrorParams("Not Found");
            loadResponse.setMessage("The field 'Receive Account Number' cannot be empty");

            return new ResponseEntity<>(loadResponse, HttpStatus.OK);
        }

        RelAfiliadoMoneygram afiliadoMoneygram =
                relAfiliadoMoneygramService.getAfiliadoMoneygramByIdMoneygram(loadRequest.getReceiveAccountNumber());

        if(afiliadoMoneygram == null){
            loadResponse.setValid("ERROR");
            loadResponse.setPartnerTransactionId(1);
            loadResponse.setMgiErrorCode("1001");
            loadResponse.setCustomErrorParams("Not Found");
            loadResponse.setMessage("Account number not found");

            return new ResponseEntity<>(loadResponse, HttpStatus.OK);
        }

        pago.setMonto(loadRequest.getReceiveAmount());
        pago.setReferenciaBancaria(loadRequest.getReferenceNumber());
        pago.setFechaPago(loadRequest.getSendDate());
        pago.setEstatus("completed");
        pago.setTipoTransaccion("Moneygram");
        //pago.setAfiliado(afiliadoMoneygram.getAfiliado());

        pagoService.save(pago);
        afiliadoRepository.insertRelAfiliadosPagos(afiliadoMoneygram.getAfiliado(), pago.getId());
        loadResponse.setValid("PASS");
        loadResponse.setPartnerTransactionId(0);
        loadResponse.setMgiErrorCode("1000");
        loadResponse.setMessage("SUCCESS");

        return new ResponseEntity<>(loadResponse, HttpStatus.OK);
    }

    public void requestLoad(LoadRequest loadRequest){
        if(loadRequest.getReceiveAmount() == null){
            throw new LoadException("The receive amount field cannot be null");
        }else if(loadRequest.getReferenceNumber() == null){
            throw new LoadException("The reference number field cannot be null");
        }else if(loadRequest.getSendDate() == null){
            throw new LoadException("The send date field cannot be null");
        }else if(loadRequest.getReceiveAccountNumber() == null){
            throw new LoadException("The receive account number cannot be null");
        }
    }
}
