package com.prosesol.api.kyckglobal.controllers.exception;

import com.prosesol.api.kyckglobal.models.ValidationResponse;
import com.prosesol.api.kyckglobal.models.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<?> handleValidationBadRequest(ValidationException ve){
        ValidationResponse validationResponse = new ValidationResponse();
        Map<String, Object> mapResponse = new HashMap<>();

        validationResponse.setValid("ERROR");
        validationResponse.setPartnerTransactionId(1);
        validationResponse.setMgiErrorCode("1002");
        validationResponse.setCustomErrorParams(HttpStatus.BAD_REQUEST.getReasonPhrase());
        validationResponse.setMessage(ve.getMessage());

        mapResponse.put("validationResponse", validationResponse);

        return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);

    }

}
