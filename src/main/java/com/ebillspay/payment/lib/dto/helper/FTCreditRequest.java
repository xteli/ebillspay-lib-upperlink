/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.dto.helper;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author chineduojiteli
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "amount",
    "beneficiaryAccountName",
    "beneficiaryAccountNumber",
    "beneficiaryBankVerificationNumber",
    "beneficiaryKYCLevel",
    "channelCode",
    "destinationInstitutionCode",
    "nameEnquiryRef",
    "narration",
    "originatorAccountName",
    "originatorAccountNumber",
    "originatorBankVerificationNumber",
    "originatorKYCLevel",
    "paymentReference",
    "sessionID",
    "transactionLocation"
})
@XmlRootElement(name = "FTCreditRequest")
public class FTCreditRequest {

    @XmlElement(name = "amount", required = true)
    private BigDecimal amount;
    //beneficiary details
    @XmlElement(name = "beneficiaryAccountName", required = false)
    private String beneficiaryAccountName;
    @XmlElement(name = "beneficiaryAccountNumber", required = false)
    private String beneficiaryAccountNumber;
    @XmlElement(name = "beneficiaryBankVerificationNumber", required = false)
    private String beneficiaryBankVerificationNumber;
    @XmlElement(name = "beneficiaryKYCLevel", required = false)
    private int beneficiaryKYCLevel;

    @XmlElement(name = "channelCode", required = false)
    private int channelCode;

    @XmlElement(name = "destinationInstitutionCode", required = false)
    private String destinationInstitutionCode;
    @XmlElement(name = "nameEnquiryRef", required = false)
    private String nameEnquiryRef;
    @XmlElement(name = "narration", required = false)
    private String narration;

    //sender details
    @XmlElement(name = "originatorAccountName", required = false)
    private String originatorAccountName;
    @XmlElement(name = "originatorAccountNumber", required = false)
    private String originatorAccountNumber;
    @XmlElement(name = "originatorBankVerificationNumber", required = false)
    private String originatorBankVerificationNumber;
    @XmlElement(name = "originatorKYCLevel", required = false)
    private int originatorKYCLevel;

    @XmlElement(name = "paymentReference", required = false)
    private String paymentReference;
    @XmlElement(name = "sessionID", required = false)
    private String sessionID;
    @XmlElement(name = "transactionLocation", required = false)
    private String transactionLocation;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBeneficiaryAccountName() {
        return beneficiaryAccountName;
    }

    public void setBeneficiaryAccountName(String beneficiaryAccountName) {
        this.beneficiaryAccountName = beneficiaryAccountName;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getBeneficiaryBankVerificationNumber() {
        return beneficiaryBankVerificationNumber;
    }

    public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber) {
        this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
    }

    public int getBeneficiaryKYCLevel() {
        return beneficiaryKYCLevel;
    }

    public void setBeneficiaryKYCLevel(int beneficiaryKYCLevel) {
        this.beneficiaryKYCLevel = beneficiaryKYCLevel;
    }

    public int getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(int channelCode) {
        this.channelCode = channelCode;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }

    public String getNameEnquiryRef() {
        return nameEnquiryRef;
    }

    public void setNameEnquiryRef(String nameEnquiryRef) {
        this.nameEnquiryRef = nameEnquiryRef;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getOriginatorAccountName() {
        return originatorAccountName;
    }

    public void setOriginatorAccountName(String originatorAccountName) {
        this.originatorAccountName = originatorAccountName;
    }

    public String getOriginatorAccountNumber() {
        return originatorAccountNumber;
    }

    public void setOriginatorAccountNumber(String originatorAccountNumber) {
        this.originatorAccountNumber = originatorAccountNumber;
    }

    public String getOriginatorBankVerificationNumber() {
        return originatorBankVerificationNumber;
    }

    public void setOriginatorBankVerificationNumber(String originatorBankVerificationNumber) {
        this.originatorBankVerificationNumber = originatorBankVerificationNumber;
    }

    public int getOriginatorKYCLevel() {
        return originatorKYCLevel;
    }

    public void setOriginatorKYCLevel(int originatorKYCLevel) {
        this.originatorKYCLevel = originatorKYCLevel;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getTransactionLocation() {
        return transactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
    }

    public FTCreditResponse getFTCreditResponse() {
        return new FTCreditResponse();
    }

}
