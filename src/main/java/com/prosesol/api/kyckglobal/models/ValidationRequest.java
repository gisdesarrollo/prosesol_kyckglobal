package com.prosesol.api.kyckglobal.models;


import java.io.Serializable;
import java.util.Date;

//@JacksonXmlRootElement(localName = "validationRequest")
public class ValidationRequest implements Serializable {

    private static final long serialVersionUID = 21L;

    private Date processDateTime;

    private String receiveAgent;

    private String receiveCode;

    private String receiveISOCurrency;

    private String receiveISOCountry;

    private Long receiveAccountNumber;

    private String sendISOCurrency;

    private String sendISOCountry;

    private double sendFxRate;

    private double sendAmount;

    private double feeAmount;

    private Double receiveAmount;

    private String senderFirstName;

    private String senderMiddleName;

    private String senderLastName;

    private String senderAddress1;

    private String senderAddress2;

    private String senderCity;

    private String senderStateProvince;

    private String senderCountry;

    private String senderZipPostalCode;

    private String senderPhoneNumber;

    private Date senderDateOfBirth;

    private String senderPhotoType;

    private String senderPhotoIdNumber;

    private String senderPhotoIdStateProvince;

    public Date getProcessDateTime() {
        return processDateTime;
    }

    public void setProcessDateTime(Date processDateTime) {
        this.processDateTime = processDateTime;
    }

    public String getReceiveAgent() {
        return receiveAgent;
    }

    public void setReceiveAgent(String receiveAgent) {
        this.receiveAgent = receiveAgent;
    }

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }

    public String getReceiveISOCurrency() {
        return receiveISOCurrency;
    }

    public void setReceiveISOCurrency(String receiveISOCurrency) {
        this.receiveISOCurrency = receiveISOCurrency;
    }

    public String getReceiveISOCountry() {
        return receiveISOCountry;
    }

    public void setReceiveISOCountry(String receiveISOCountry) {
        this.receiveISOCountry = receiveISOCountry;
    }

    public Long getReceiveAccountNumber() {
        return receiveAccountNumber;
    }

    public void setReceiveAccountNumber(Long receiveAccountNumber) {
        this.receiveAccountNumber = receiveAccountNumber;
    }

    public String getSendISOCurrency() {
        return sendISOCurrency;
    }

    public void setSendISOCurrency(String sendISOCurrency) {
        this.sendISOCurrency = sendISOCurrency;
    }

    public String getSendISOCountry() {
        return sendISOCountry;
    }

    public void setSendISOCountry(String sendISOCountry) {
        this.sendISOCountry = sendISOCountry;
    }

    public double getSendFxRate() {
        return sendFxRate;
    }

    public void setSendFxRate(double sendFxRate) {
        this.sendFxRate = sendFxRate;
    }

    public double getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(double sendAmount) {
        this.sendAmount = sendAmount;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Double getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(Double receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderMiddleName() {
        return senderMiddleName;
    }

    public void setSenderMiddleName(String senderMiddleName) {
        this.senderMiddleName = senderMiddleName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderAddress1() {
        return senderAddress1;
    }

    public void setSenderAddress1(String senderAddress1) {
        this.senderAddress1 = senderAddress1;
    }

    public String getSenderAddress2() {
        return senderAddress2;
    }

    public void setSenderAddress2(String senderAddress2) {
        this.senderAddress2 = senderAddress2;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderStateProvince() {
        return senderStateProvince;
    }

    public void setSenderStateProvince(String senderStateProvince) {
        this.senderStateProvince = senderStateProvince;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getSenderZipPostalCode() {
        return senderZipPostalCode;
    }

    public void setSenderZipPostalCode(String senderZipPostalCode) {
        this.senderZipPostalCode = senderZipPostalCode;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public Date getSenderDateOfBirth() {
        return senderDateOfBirth;
    }

    public void setSenderDateOfBirth(Date senderDateOfBirth) {
        this.senderDateOfBirth = senderDateOfBirth;
    }

    public String getSenderPhotoType() {
        return senderPhotoType;
    }

    public void setSenderPhotoType(String senderPhotoType) {
        this.senderPhotoType = senderPhotoType;
    }

    public String getSenderPhotoIdNumber() {
        return senderPhotoIdNumber;
    }

    public void setSenderPhotoIdNumber(String senderPhotoIdNumber) {
        this.senderPhotoIdNumber = senderPhotoIdNumber;
    }

    public String getSenderPhotoIdStateProvince() {
        return senderPhotoIdStateProvince;
    }

    public void setSenderPhotoIdStateProvince(String senderPhotoIdStateProvince) {
        this.senderPhotoIdStateProvince = senderPhotoIdStateProvince;
    }
}
