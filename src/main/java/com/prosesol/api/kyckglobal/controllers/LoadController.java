package com.prosesol.api.kyckglobal.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.prosesol.api.kyckglobal.models.LoadRequest;
import com.prosesol.api.kyckglobal.models.LoadResponse;
import com.prosesol.api.kyckglobal.models.Pago;
import com.prosesol.api.kyckglobal.models.RelAfiliadoMoneygram;
import com.prosesol.api.kyckglobal.models.dto.LoadRequestDto;
import com.prosesol.api.kyckglobal.services.IPagoService;
import com.prosesol.api.kyckglobal.services.IRelAfiliadoMoneygramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoadController {

    @Autowired
    private IRelAfiliadoMoneygramService relAfiliadoMoneygramService;

    @Autowired
    private IPagoService pagoService;

    @PostMapping(value = "load", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLoadValidation(@Valid @RequestBody LoadRequest loadRequest){

        LoadResponse loadResponse = new LoadResponse();
        Pago pago = new Pago();

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
        pago.setEstatus("Completed");
        pago.setTipoTransaccion("Moneygram");
        pago.setAfiliado(afiliadoMoneygram.getAfiliado());

        pagoService.save(pago);

        loadResponse.setValid("PASS");
        loadResponse.setPartnerTransactionId(0);
        loadResponse.setMgiErrorCode("1000");
        loadResponse.setMessage("SUCCESS");

        return new ResponseEntity<>(loadResponse, HttpStatus.OK);
    }
}
