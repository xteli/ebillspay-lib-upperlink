/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author chineduojiteli
 */
@Entity
@Table(name = "SystemAudit")
public class SystemAudit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Column(name = "UniqueRef", nullable = true)
    private String uniqueRef;
    @Column(name = "OperationName")
    private String operationName;
    @Column(name = "PlainRequest", columnDefinition = "TEXT")
    private String plainRequest;
    @Column(name = "EncryptedRequest", columnDefinition = "TEXT")
    private String encryptedRequest;
    @Column(name = "PlainResponse", columnDefinition = "TEXT")
    private String plainResponse;
    @Column(name = "EncryptedResponse", columnDefinition = "TEXT")
    private String encryptedResponse;
    @Column(name = "StatusCode")
    private String statusCode;
    @Column(name = "StatusMessage",columnDefinition = "TEXT")
    private String statusMessage;
    @Column(name = "IPAddress", nullable = true)
    private String ipAddress = "";
    @Column(name = "OperationDate", nullable = false, columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date operationDate;
    @Column(name = "ServiceResponse", columnDefinition = "TEXT")
    private String serviceResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getPlainRequest() {
        return plainRequest;
    }

    public void setPlainRequest(String plainRequest) {
        this.plainRequest = plainRequest;
    }

    public String getEncryptedRequest() {
        return encryptedRequest;
    }

    public void setEncryptedRequest(String encryptedRequest) {
        this.encryptedRequest = encryptedRequest;
    }

    public String getPlainResponse() {
        return plainResponse;
    }

    public void setPlainResponse(String plainResponse) {
        this.plainResponse = plainResponse;
    }

    public String getEncryptedResponse() {
        return encryptedResponse;
    }

    public void setEncryptedResponse(String encryptedResponse) {
        this.encryptedResponse = encryptedResponse;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getUniqueRef() {
        return uniqueRef;
    }

    public void setUniqueRef(String uniqueRef) {
        this.uniqueRef = uniqueRef;
    }

    public String getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(String serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

   
}
