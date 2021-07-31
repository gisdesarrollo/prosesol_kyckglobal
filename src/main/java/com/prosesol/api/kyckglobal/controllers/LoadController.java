package com.prosesol.api.kyckglobal.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.prosesol.api.kyckglobal.models.dao.LoadRequestDao;
import com.prosesol.api.kyckglobal.models.dao.LoadResponseDao;
import com.prosesol.api.kyckglobal.models.dto.LoadRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Value("https://${api.kyckglobal.url}/apis/moneyGramLoadCashAcceptance")
    private String url;

    private static final String  TARGET_ELEMENT = "loadResponse";

    @PostMapping("load")
    public ResponseEntity<?> getLoadValidation(@RequestBody LoadRequestDto loadRequestDto){

        Map<String, Object> mapResponse = new HashMap<>();

        LoadRequestDao loadRequest = loadRequestDto.getLoadRequest();
        LoadResponseDao loadResponse = new LoadResponseDao();

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);

        RestTemplate restTemplate = new RestTemplate();

        try{

            String xml = mapper.writeValueAsString(loadRequest);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/xml");

            HttpEntity<String> request = new HttpEntity<>(xml, headers);

            ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(result.getBody()));

            while(reader.hasNext()){
                int type = reader.next();

                if(type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(reader.getLocalName())){
                    loadResponse = mapper.readValue(reader, LoadResponseDao.class);
                }
            }

            mapResponse.put("loadResponse", loadResponse);

        }catch (JsonProcessingException jse){
            jse.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch(XMLStreamException xmlStreamException){
            xmlStreamException.printStackTrace();
        }

        return new ResponseEntity<Map<String, Object>>(mapResponse, HttpStatus.OK);
    }
}
