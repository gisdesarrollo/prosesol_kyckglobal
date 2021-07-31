package com.prosesol.api.kyckglobal.models.dto;

import com.prosesol.api.kyckglobal.models.dao.LoadRequestDao;

public class LoadRequestDto {

    private LoadRequestDao loadRequest;

    public LoadRequestDao getLoadRequest() {
        return loadRequest;
    }

    public void setLoadRequest(LoadRequestDao loadRequest) {
        this.loadRequest = loadRequest;
    }
}
