package com.prosesol.api.kyckglobal.models.dao;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(namespace = "xmlns:real=\"http://www.moneygram.com/RealTimeEP\"", localName = "validationResponse")
public class ValidationResponseDao implements Serializable {

    private static final long serialVersionUID = 21L;

    private String valid;

    private long partnerTransactionId;

    private String mgiErrorCode;

    private String customErrorParams;

    private String receiptCode;

    private String customReceiptParams;

    private String partnerErrorCode;

    private String message;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public long getPartnerTransactionId() {
        return partnerTransactionId;
    }

    public void setPartnerTransactionId(long partnerTransactionId) {
        this.partnerTransactionId = partnerTransactionId;
    }

    public String getMgiErrorCode() {
        return mgiErrorCode;
    }

    public void setMgiErrorCode(String mgiErrorCode) {
        this.mgiErrorCode = mgiErrorCode;
    }

    public String getCustomErrorParams() {
        return customErrorParams;
    }

    public void setCustomErrorParams(String customErrorParams) {
        this.customErrorParams = customErrorParams;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getCustomReceiptParams() {
        return customReceiptParams;
    }

    public void setCustomReceiptParams(String customReceiptParams) {
        this.customReceiptParams = customReceiptParams;
    }

    public String getPartnerErrorCode() {
        return partnerErrorCode;
    }

    public void setPartnerErrorCode(String partnerErrorCode) {
        this.partnerErrorCode = partnerErrorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
