/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.util;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author xteli
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    private final String HEADERS = "Origin, Content-Type, Accept";
    private final String METHODS = "GET, POST, PUT, DELETE,OPTIONS,HEAD";

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Headers", HEADERS);
        responseContext.getHeaders().add("Access-Control-Allow-Methods", METHODS);
    }

}
