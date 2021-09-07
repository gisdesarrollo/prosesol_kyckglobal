package com.prosesol.api.kyckglobal.controllers;

import com.prosesol.api.kyckglobal.models.RelAfiliadoMoneygram;
import com.prosesol.api.kyckglobal.models.ValidationRequest;
import com.prosesol.api.kyckglobal.models.ValidationResponse;
import com.prosesol.api.kyckglobal.models.dto.ValidationRequestDto;
import com.prosesol.api.kyckglobal.services.IRelAfiliadoMoneygramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @Autowired
    private IRelAfiliadoMoneygramService relAfiliadoMoneygramService;

    @PostMapping("validation")
    public ResponseEntity<?> getResponseValidation(@RequestBody ValidationRequestDto validationRequestDto){

        Map<String, Object> mapResponse = new HashMap<>();

        ValidationRequest validationRequest = validationRequestDto.getValidation();
        ValidationResponse validationResponse = new ValidationResponse();

        RelAfiliadoMoneygram afiliadoMoneygram = relAfiliadoMoneygramService
                .getAfiliadoMoneygramByAfiliado(validationRequestDto.getValidation().getReceiveAccountNumber());

        if(afiliadoMoneygram == null){
            validationResponse.setValid("ERROR");
            validationResponse.setPartnerTransactionId(1);
            validationResponse.setMgiErrorCode("1001");
            validationResponse.setCustomErrorParams("Internal Server Error");
            validationResponse.setMessage("Afiliate not found");

            mapResponse.put("validationResponse", validationResponse);

            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        }

        if(validationRequestDto.getValidation().getSendAmount() == afiliadoMoneygram.getAfiliado().getServicio().getCostoTitular()
            && validationRequestDto.getValidation().getReceiveAccountNumber() == afiliadoMoneygram.getAfiliado().getId()){
            validationResponse.setValid("OK");
            validationResponse.setPartnerTransactionId(0);
            validationResponse.setMgiErrorCode("1000");
            validationResponse.setMessage("Process Terminated Successfully");

            mapResponse.put("validationResponse", validationResponse);
        }else{
            validationResponse.setValid("ERROR");
            validationResponse.setPartnerTransactionId(0);
            validationResponse.setMgiErrorCode("1002");
            validationResponse.setCustomErrorParams("Internal Server Error");
            validationResponse.setMessage("The amount is not equal to the total amount of the service");

            mapResponse.put("validationResponse", validationResponse);
        }
//        JacksonXmlModule module = new JacksonXmlModule();
//        module.setDefaultUseWrapper(false);
//        XmlMapper mapper = new XmlMapper(module);
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        try{
//            String xml = mapper.writer().writeValueAsString(validationRequest);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.CONTENT_TYPE, "application/xml");
//
//            HttpEntity<String> request = new HttpEntity<>(xml, headers);
//
//            ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
//            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//
//            XMLInputFactory factory = XMLInputFactory.newFactory();
//            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(result.getBody()));
//
//            while(reader.hasNext()){
//                int type = reader.next();
//
//                if(type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(reader.getLocalName())){
//                    validationResponse = mapper.readValue(reader, ValidationResponse.class);
//                }
//            }
//            mapResponse.put("validationResponse", validationResponse);
//
//
//        }catch (JsonProcessingException jse){
//            jse.printStackTrace();
//        }catch (IOException ioException){
//            ioException.printStackTrace();
//        }catch(XMLStreamException xmlStreamException){
//            xmlStreamException.printStackTrace();
//        }

        return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
    }

}
