/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.util;

import java.io.File;

/**
 *
 * @author chineduojiteli
 */
public class ConfigReader {
    
     private static File CONFIG_FILE;
    //test
   // static String fileName = "C:\\Paysuite Services\\config\\app_test.properties";
    //live
     static String fileName = "C:\\Ebillspay Payment Utility\\config\\app.properties";

    /*
     Singleton class for loading configuraiton file
     */
    private ConfigReader() {

    }

    public static File getConfigurationFile() {
        String filePath = "";
        if (CONFIG_FILE == null) {
            try {
                if ("".equals(filePath)) {
                    filePath = new File(fileName).getAbsolutePath();
                }
                CONFIG_FILE = new File(filePath);
            } catch (Throwable e) {
                System.err.println("Error in loading configuration file : " + e.getMessage());
                throw new ExceptionInInitializerError(e);
            }
        }
        return CONFIG_FILE;
    }
}
