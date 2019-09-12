/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author chineduojiteli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtilityRequest {

    private int channelCode;

    private String sessionId;
    //for debit
    private String debitAmount;
    private String srcBankCode;
    private String srcAcctNumber;
    //for credit
    private String creditAmount;
    private String beneficiaryBankCode;
    private String beneficiaryAcctNumber;

    //for fee
    private String feeAmount;
    private String feeBeneficiaryBankCode;
    private String feeBeneficiaryAcctNumber;

    //for querying of transactions
    private String startDate;
    private String endDate;
    private String paymentRef;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(int channelCode) {
        this.channelCode = channelCode;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getSrcBankCode() {
        return srcBankCode;
    }

    public void setSrcBankCode(String srcBankCode) {
        this.srcBankCode = srcBankCode;
    }

    public String getSrcAcctNumber() {
        return srcAcctNumber;
    }

    public void setSrcAcctNumber(String srcAcctNumber) {
        this.srcAcctNumber = srcAcctNumber;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    public void setBeneficiaryBankCode(String beneficiaryBankCode) {
        this.beneficiaryBankCode = beneficiaryBankCode;
    }

    public String getBeneficiaryAcctNumber() {
        return beneficiaryAcctNumber;
    }

    public void setBeneficiaryAcctNumber(String beneficiaryAcctNumber) {
        this.beneficiaryAcctNumber = beneficiaryAcctNumber;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeBeneficiaryBankCode() {
        return feeBeneficiaryBankCode;
    }

    public void setFeeBeneficiaryBankCode(String feeBeneficiaryBankCode) {
        this.feeBeneficiaryBankCode = feeBeneficiaryBankCode;
    }

    public String getFeeBeneficiaryAcctNumber() {
        return feeBeneficiaryAcctNumber;
    }

    public void setFeeBeneficiaryAcctNumber(String feeBeneficiaryAcctNumber) {
        this.feeBeneficiaryAcctNumber = feeBeneficiaryAcctNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

}
