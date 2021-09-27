package com.prosesol.api.kyckglobal.models.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
