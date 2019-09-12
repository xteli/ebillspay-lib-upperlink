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
    "debitAccountName",
    "debitAccountNumber",
    "debitBankVerificationNumber",
    "debitKYCLevel",
    "destinationInstitutionCode",
    "mandateReferenceNumber",
    "nameEnquiryRef",
    "narration",
    "paymentReference",
    "sessionID",
    "transactionFee",
    "transactionLocation"
})
@XmlRootElement(name = "FTDebitRequest")
public class FTDebitRequest {

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
    //sender details
    @XmlElement(name = "debitAccountName", required = false)
    private String debitAccountName;
    @XmlElement(name = "debitAccountNumber", required = false)
    private String debitAccountNumber;
    @XmlElement(name = "debitBankVerificationNumber", required = false)
    private String debitBankVerificationNumber;
    @XmlElement(name = "debitKYCLevel", required = false)
    private int debitKYCLevel;
    @XmlElement(name = "destinationInstitutionCode", required = false)
    private String destinationInstitutionCode;
    @XmlElement(name = "mandateReferenceNumber", required = false)
    private String mandateReferenceNumber;
    @XmlElement(name = "nameEnquiryRef", required = false)
    private String nameEnquiryRef;
    @XmlElement(name = "narration", required = false)
    private String narration;
    @XmlElement(name = "paymentReference", required = false)
    private String paymentReference;
    @XmlElement(name = "sessionID", required = false)
    private String sessionID;
    @XmlElement(name = "transactionFee", required = false)
    private BigDecimal transactionFee;
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

    public String getDebitAccountName() {
        return debitAccountName;
    }

    public void setDebitAccountName(String debitAccountName) {
        this.debitAccountName = debitAccountName;
    }

    public String getDebitAccountNumber() {
        return debitAccountNumber;
    }

    public void setDebitAccountNumber(String debitAccountNumber) {
        this.debitAccountNumber = debitAccountNumber;
    }

    public String getDebitBankVerificationNumber() {
        return debitBankVerificationNumber;
    }

    public void setDebitBankVerificationNumber(String debitBankVerificationNumber) {
        this.debitBankVerificationNumber = debitBankVerificationNumber;
    }

    public int getDebitKYCLevel() {
        return debitKYCLevel;
    }

    public void setDebitKYCLevel(int debitKYCLevel) {
        this.debitKYCLevel = debitKYCLevel;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }

    public String getMandateReferenceNumber() {
        return mandateReferenceNumber;
    }

    public void setMandateReferenceNumber(String mandateReferenceNumber) {
        this.mandateReferenceNumber = mandateReferenceNumber;
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

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public String getTransactionLocation() {
        return transactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
    }

    public FTDebitResponse getFTDebitResponse() {
        return new FTDebitResponse();
    }
}
