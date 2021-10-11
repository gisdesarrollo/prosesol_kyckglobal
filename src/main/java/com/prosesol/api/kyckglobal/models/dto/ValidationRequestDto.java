package com.prosesol.api.kyckglobal.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prosesol.api.kyckglobal.models.ValidationRequest;

public class ValidationRequestDto {

    @JsonProperty("validationRequest")
    private ValidationRequest validationRequest;

    public ValidationRequest getValidation() {
        return validationRequest;
    }

    public void setValidation(ValidationRequest validationRequest) {
        this.validationRequest = validationRequest;
    }
}
