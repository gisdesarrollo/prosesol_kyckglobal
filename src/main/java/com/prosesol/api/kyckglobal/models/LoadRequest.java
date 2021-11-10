package com.prosesol.api.kyckglobal.models;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class LoadRequest implements Serializable {

    private static final long serialVersionUID = 21L;

    private String receiveAgentId;

    private String receiveCode;

    @NotNull(message = "Reference Number cannot be null")
    private String referenceNumber;

    @NotNull(message = "Send Date cannot be null")
    private Date sendDate;

    private String receiveISOCurrency;

    private String receiveISOCountry;

    private String receiveAccountNumber;

    private String sendISOCurrency;

    private String sendISOCountry;

    private Double sendFxRate;

    private Double sendAmount;

    private Double feeAmount;

    @NotNull(message = "receive Amount cannot be null")
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

    private String senderPhotoIdType;

    private String senderPhotoIdNumber;

    private String senderPhotoIdStateProvince;

    private String senderPhotoIdCountry;

    private String senderLegalIdType;

    private String senderLegalIdNumber;

    private String receiveFirstName;

    private String receiveMiddleName;

    private String receiveLastName;

    private String receiveAccountNumberExpStr;

    private String receiveAccountSwipe;

    private String purposeOfFunds;
    
    public String getReceiveAgentId() {
		return receiveAgentId;
	}

	public void setReceiveAgentId(String receiveAgentId) {
		this.receiveAgentId = receiveAgentId;
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

	public String getReceiveAccountNumber() {
		return receiveAccountNumber;
	}

	public void setReceiveAccountNumber(String receiveAccountNumber) {
		this.receiveAccountNumber = receiveAccountNumber;
	}

	public Double getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(Double receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public String getReceiveFirstName() {
		return receiveFirstName;
	}

	public void setReceiveFirstName(String receiveFirstName) {
		this.receiveFirstName = receiveFirstName;
	}

	public String getReceiveMiddleName() {
		return receiveMiddleName;
	}

	public void setReceiveMiddleName(String receiveMiddleName) {
		this.receiveMiddleName = receiveMiddleName;
	}

	public String getReceiveLastName() {
		return receiveLastName;
	}

	public void setReceiveLastName(String receiveLastName) {
		this.receiveLastName = receiveLastName;
	}

	public String getReceiveAccountNumberExpStr() {
		return receiveAccountNumberExpStr;
	}

	public void setReceiveAccountNumberExpStr(String receiveAccountNumberExpStr) {
		this.receiveAccountNumberExpStr = receiveAccountNumberExpStr;
	}

	public String getReceiveAccountSwipe() {
		return receiveAccountSwipe;
	}

	public void setReceiveAccountSwipe(String receiveAccountSwipe) {
		this.receiveAccountSwipe = receiveAccountSwipe;
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

    public Double getSendFxRate() {
        return sendFxRate;
    }

    public void setSendFxRate(Double sendFxRate) {
        this.sendFxRate = sendFxRate;
    }

    public Double getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(Double sendAmount) {
        this.sendAmount = sendAmount;
    }

    public Double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Double feeAmount) {
        this.feeAmount = feeAmount;
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

    public String getPurposeOfFunds() {
        return purposeOfFunds;
    }

    public void setPurposeOfFunds(String purposeOfFunds) {
        this.purposeOfFunds = purposeOfFunds;
    }
}
