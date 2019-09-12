/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.util;

/**
 *
 * @author chineduojiteli
 */
public interface ResponseCode {

    public final String SUCCESSFUL = "00";
    public final String REQUEST_IN_PROGRESS = "01";
    public final String FAILED = "02";
    public final String SERVICE_NOT_AVAILABLE = "03";
    public final String EMPTY_REQUEST = "04";

    //error codes due to json related exceptions
    public final String JSON_GENERATION_EXCEPTION = "10";
    public final String JSON_MAPPING_EXCEPTION = "11";

    //error codes due to invalid parameters
    public final String INVALID_PARAMETERS = "20";
    public final String INVALID_AMOUNT = "21";
    public final String INVALID_CHANNEL = "22";

    //error codes due to record not found
    public final String NO_RECORD_FOUND = "30";
    public final String NO_TRANSACTION_FOUND = "31";

    //error codes due to general exceptions
    public final String GENERAL_EXCEPTION = "40";
    public final String NIP_EXCEPTION = "41";
    
    public final String SYSTEM_MALFUNCTION="96";

}
