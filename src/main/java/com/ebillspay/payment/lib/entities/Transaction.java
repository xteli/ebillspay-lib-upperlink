/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author chineduojiteli
 */
//@MappedSuperclass
@Entity
@Table(name = "Transaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "SessionID")
    private String sessionID;

    //debit account details
    @Column(name = "SourceAccountName")
    private String srcAccountName;
    @Column(name = "SourceAccountNumber")
    private String srcAccountNumber;
    @Column(name = "SourceBankCode")
    private String srcBankCode;
    @Column(name = "SourceBVN")
    private String srcBvn;
    @Column(name = "SourceKYC")
    private Integer srcKyc;

    //credit account details
    @Column(name = "BeneficiaryAccountName")
    private String beneficiaryAccountName;
    @Column(name = "BeneficiaryAccountNumber")
    private String beneficiaryAccountNumber;
    @Column(name = "BeneficiaryBankCode")
    private String beneficiaryBankCode;
    @Column(name = "BeneficiaryBVN")
    private String beneficiaryBvn;
    @Column(name = "BeneficiaryKYC")
    private Integer beneficiaryKyc;

    //fee account details
    @Column(name = "FeeBeneficiaryAccountName", nullable = true)
    private String feeBeneficiaryAccountName;
    @Column(name = "FeeBeneficiaryAccountNumber", nullable = true)
    private String feeBeneficiaryAccountNumber;
    @Column(name = "FeeBeneficiaryBankCode", nullable = true)
    private String feeBeneficiaryBankCode;
    @Column(name = "FeeBeneficiaryBVN", nullable = true)
    private String feeBeneficiaryBvn;
    @Column(name = "FeeBeneficiaryKYC", nullable = true)
    private Integer feeBeneficiaryKyc;

    //other details
    @Column(name = "Narration")
    private String narration;
    @Column(name = "RequestTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;
    @Column(name = "ResponseTime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseTime;
    @Column(name = "Channel")
    private int channel;

    //response codes
    @Column(name = "DebitResponseCode")
    private String debitResponseCode;
    @Column(name = "CreditResponseCode", nullable = true)
    private String creditResponseCode;
    @Column(name = "FeeResponseCode", nullable = true)
    private String feeResponseCode;

    @Column(name = "PaymentRef")
    private String paymentRef;

    //amount
    @Column(name = "DebitAmount")
    private BigDecimal debitAmount;
    @Column(name = "CreditAmount")
    private BigDecimal creditAmount;
    @Column(name = "FeeAmount", nullable = true)
    private BigDecimal feeAmount;

    @Column(name = "MandateReference")
    private String mandateRef;

    //reversal details
    @Column(name = "ReversalRef", nullable = true)
    private String reversalRef;
    @Column(name = "Reversed", nullable = true)
    private boolean isReversed = false;
    @Column(name = "RequiresReversal", nullable = true)
    private boolean requiresReversal = false;
    @Column(name = "ReversalDateTime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reversalDate;
    @Column(name = "ReversalResponseCode", nullable = true)
    private String reversalResponseCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getSrcAccountName() {
        return srcAccountName;
    }

    public void setSrcAccountName(String srcAccountName) {
        this.srcAccountName = srcAccountName;
    }

    public String getSrcAccountNumber() {
        return srcAccountNumber;
    }

    public void setSrcAccountNumber(String srcAccountNumber) {
        this.srcAccountNumber = srcAccountNumber;
    }

    public String getSrcBvn() {
        return srcBvn;
    }

    public void setSrcBvn(String srcBvn) {
        this.srcBvn = srcBvn;
    }

    public Integer getSrcKyc() {
        return srcKyc;
    }

    public void setSrcKyc(Integer srcKyc) {
        this.srcKyc = srcKyc;
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

    public String getSrcBankCode() {
        return srcBankCode;
    }

    public void setSrcBankCode(String srcBankCode) {
        this.srcBankCode = srcBankCode;
    }

    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    public void setBeneficiaryBankCode(String beneficiaryBankCode) {
        this.beneficiaryBankCode = beneficiaryBankCode;
    }

    public String getBeneficiaryBvn() {
        return beneficiaryBvn;
    }

    public void setBeneficiaryBvn(String beneficiaryBvn) {
        this.beneficiaryBvn = beneficiaryBvn;
    }

    public Integer getBeneficiaryKyc() {
        return beneficiaryKyc;
    }

    public void setBeneficiaryKyc(Integer beneficiaryKyc) {
        this.beneficiaryKyc = beneficiaryKyc;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    public String getFeeBeneficiaryAccountName() {
        return feeBeneficiaryAccountName;
    }

    public void setFeeBeneficiaryAccountName(String feeBeneficiaryAccountName) {
        this.feeBeneficiaryAccountName = feeBeneficiaryAccountName;
    }

    public String getFeeBeneficiaryAccountNumber() {
        return feeBeneficiaryAccountNumber;
    }

    public void setFeeBeneficiaryAccountNumber(String feeBeneficiaryAccountNumber) {
        this.feeBeneficiaryAccountNumber = feeBeneficiaryAccountNumber;
    }

    public String getFeeBeneficiaryBankCode() {
        return feeBeneficiaryBankCode;
    }

    public void setFeeBeneficiaryBankCode(String feeBeneficiaryBankCode) {
        this.feeBeneficiaryBankCode = feeBeneficiaryBankCode;
    }

    public String getFeeBeneficiaryBvn() {
        return feeBeneficiaryBvn;
    }

    public void setFeeBeneficiaryBvn(String feeBeneficiaryBvn) {
        this.feeBeneficiaryBvn = feeBeneficiaryBvn;
    }

    public Integer getFeeBeneficiaryKyc() {
        return feeBeneficiaryKyc;
    }

    public void setFeeBeneficiaryKyc(Integer feeBeneficiaryKyc) {
        this.feeBeneficiaryKyc = feeBeneficiaryKyc;
    }

    public String getDebitResponseCode() {
        return debitResponseCode;
    }

    public void setDebitResponseCode(String debitResponseCode) {
        this.debitResponseCode = debitResponseCode;
    }

    public String getCreditResponseCode() {
        return creditResponseCode;
    }

    public void setCreditResponseCode(String creditResponseCode) {
        this.creditResponseCode = creditResponseCode;
    }

    public String getFeeResponseCode() {
        return feeResponseCode;
    }

    public void setFeeResponseCode(String feeResponseCode) {
        this.feeResponseCode = feeResponseCode;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getMandateRef() {
        return mandateRef;
    }

    public void setMandateRef(String mandateRef) {
        this.mandateRef = mandateRef;
    }

    public String getReversalRef() {
        return reversalRef;
    }

    public void setReversalRef(String reversalRef) {
        this.reversalRef = reversalRef;
    }

    public boolean isIsReversed() {
        return isReversed;
    }

    public void setIsReversed(boolean isReversed) {
        this.isReversed = isReversed;
    }

    public boolean isRequiresReversal() {
        return requiresReversal;
    }

    public void setRequiresReversal(boolean requiresReversal) {
        this.requiresReversal = requiresReversal;
    }

    public Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public String getReversalResponseCode() {
        return reversalResponseCode;
    }

    public void setReversalResponseCode(String reversalResponseCode) {
        this.reversalResponseCode = reversalResponseCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.sessionID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (!Objects.equals(this.sessionID, other.sessionID)) {
            return false;
        }
        return true;
    }

}
