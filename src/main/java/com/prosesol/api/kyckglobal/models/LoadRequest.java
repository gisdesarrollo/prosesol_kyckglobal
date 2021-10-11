package com.prosesol.api.kyckglobal.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@JacksonXmlRootElement(localName = "loadRequest")
public class LoadRequest implements Serializable {

    private static final long serialVersionUID = 21L;

    @NotNull(message = "recieve Agent ID cannot be null")
    private String recieveAgentId;

    @NotNull(message = "recieve Code cannot be null")
    private String recieveCode;

    @NotNull(message = "Reference Number cannot be null")
    private String referenceNumber;

    @NotNull(message = "Send Date cannot be null")
    private Date sendDate;

    private String recieveISOCurrency;

    private String recieveISOCountry;

    @NotNull(message = "recieve Account Number cannot be null")
    private long recieveAccountNumber;

    private String sendISOCurrency;

    private String sendISOCountry;

    private double sendFxRate;

    @NotNull(message = "Send Amount cannot be null")
    private double sendAmount;

    private double feeAmount;

    @NotNull(message = "Recieve Amount cannot be null")
    private double recieveAmount;

    @NotNull(message = "Sender First Name cannot be null")
    private String senderFirstName;

    private String senderMiddleName;

    @NotNull(message = "Sender Last Name cannot be null")
    private String senderLastName;

    private String senderAddress1;

    private String senderAddress2;

    private String senderCity;

    private String senderStateProvince;

    private String senderCountry;

    private String senderZipPostalCode;

    private String senderPhoneNumber;

    private Date senderDateOfBirth;

    private String senderPhotoIdType;

    private String senderPhotoIdNumber;

    private String senderPhotoIdStateProvince;

    private String senderPhotoIdCountry;

    private String senderLegalIdType;

    private String senderLegalIdNumber;

    private String recieverFirstName;

    private String recieverMiddleName;

    private String recieverLastName;

    private String recieveAccountNumberExpStr;

    private String recieveAccountSwipe;

    private String purposeOfFunds;

    public String getrecieveAgentId() {
        return recieveAgentId;
    }

    public void setrecieveAgentId(String recieveAgentId) {
        this.recieveAgentId = recieveAgentId;
    }

    public String getrecieveCode() {
        return recieveCode;
    }

    public void setrecieveCode(String recieveCode) {
        this.recieveCode = recieveCode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getrecieveISOCurrency() {
        return recieveISOCurrency;
    }

    public void setrecieveISOCurrency(String recieveISOCurrency) {
        this.recieveISOCurrency = recieveISOCurrency;
    }

    public String getrecieveISOCountry() {
        return recieveISOCountry;
    }

    public void setrecieveISOCountry(String recieveISOCountry) {
        this.recieveISOCountry = recieveISOCountry;
    }

    public long getrecieveAccountNumber() {
        return recieveAccountNumber;
    }

    public void setrecieveAccountNumber(long recieveAccountNumber) {
        this.recieveAccountNumber = recieveAccountNumber;
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

    public double getrecieveAmount() {
        return recieveAmount;
    }

    public void setrecieveAmount(double recieveAmount) {
        this.recieveAmount = recieveAmount;
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

    public String getSenderPhotoIdType() {
        return senderPhotoIdType;
    }

    public void setSenderPhotoIdType(String senderPhotoIdType) {
        this.senderPhotoIdType = senderPhotoIdType;
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

    public String getSenderPhotoIdCountry() {
        return senderPhotoIdCountry;
    }

    public void setSenderPhotoIdCountry(String senderPhotoIdCountry) {
        this.senderPhotoIdCountry = senderPhotoIdCountry;
    }

    public String getSenderLegalIdType() {
        return senderLegalIdType;
    }

    public void setSenderLegalIdType(String senderLegalIdType) {
        this.senderLegalIdType = senderLegalIdType;
    }

    public String getSenderLegalIdNumber() {
        return senderLegalIdNumber;
    }

    public void setSenderLegalIdNumber(String senderLegalIdNumber) {
        this.senderLegalIdNumber = senderLegalIdNumber;
    }

    public String getrecieverFirstName() {
        return recieverFirstName;
    }

    public void setrecieverFirstName(String recieverFirstName) {
        this.recieverFirstName = recieverFirstName;
    }

    public String getrecieverMiddleName() {
        return recieverMiddleName;
    }

    public void setrecieverMiddleName(String recieverMiddleName) {
        this.recieverMiddleName = recieverMiddleName;
    }

    public String getrecieverLastName() {
        return recieverLastName;
    }

    public void setrecieverLastName(String recieverLastName) {
        this.recieverLastName = recieverLastName;
    }

    public String getrecieveAccountNumberExpStr() {
        return recieveAccountNumberExpStr;
    }

    public void setrecieveAccountNumberExpStr(String recieveAccountNumberExpStr) {
        this.recieveAccountNumberExpStr = recieveAccountNumberExpStr;
    }

    public String getrecieveAccountSwipe() {
        return recieveAccountSwipe;
    }

    public void setrecieveAccountSwipe(String recieveAccountSwipe) {
        this.recieveAccountSwipe = recieveAccountSwipe;
    }

    public String getPurposeOfFunds() {
        return purposeOfFunds;
    }

    public void setPurposeOfFunds(String purposeOfFunds) {
        this.purposeOfFunds = purposeOfFunds;
    }
}
