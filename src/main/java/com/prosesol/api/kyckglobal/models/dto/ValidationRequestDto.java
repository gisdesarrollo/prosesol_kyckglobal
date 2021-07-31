package com.prosesol.api.kyckglobal.models.dto;

import com.prosesol.api.kyckglobal.models.dao.ValidationRequestDao;

public class ValidationRequestDto {

    private ValidationRequestDao validation;

    public ValidationRequestDao getValidation() {
        return validation;
    }

    public void setValidation(ValidationRequestDao validation) {
        this.validation = validation;
    }
}
