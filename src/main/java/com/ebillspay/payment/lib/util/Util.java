/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;

/**
 *
 * @author chineduojiteli
 */
public class Util {

    private String encKey;
    private static Client client;
    private static WebTarget target;
    static Invocation.Builder requestBuilder = null;
    private IvParameterSpec ivspec;
    private SecretKeySpec keyspec;
    private Cipher cipher;

    public Util(String encKey) {
        this.encKey = encKey;
    }

    public Util(String iv, String key) {
        ivspec = new IvParameterSpec(key.getBytes());
        keyspec = new SecretKeySpec(iv.getBytes(), "AES");
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public Util() {
    }

    //encryption methods with iv and key
    public String encrypt(String text) {

        if (text == null || text.length() == 0) {
            return null;
        }
        byte[] encrypted = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        } catch (Exception e) {
        }
        return bytesToHex(encrypted);
    }

    public String decrypt(String code) throws UnsupportedEncodingException {
        if (code == null || code.length() == 0) {
            return null;
        }
        byte[] decrypted = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            decrypted = cipher.doFinal(hexToBytes(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decrypted, "UTF-8");
    }

    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
            }
            return buffer;
        }
    }

    /**
     * A static method for other application to get configuration file object
     *
     * @return
     */
    public File getConfigFile() {
        return ConfigReader.getConfigurationFile();
    }

    public String getParameter(String parameterName) {
        String returnValue = "";
        if (parameterName == null) {
            parameterName = "";
        }

        File f = getConfigFile();
        try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
            String msg = "";
            while ((msg = bf.readLine()) != null) {
                try {
                    if (!msg.startsWith("#")) {
                        if (msg.toUpperCase().startsWith(parameterName.trim().toUpperCase() + "=")) {
                            returnValue = msg.substring(msg.indexOf("=") + 1).trim();
                        } else if (msg.toUpperCase().startsWith(parameterName.trim().toUpperCase() + "= ")) {
                            returnValue = msg.substring(msg.indexOf("= ") + 2).trim();
                        } else if (msg.toUpperCase().startsWith(parameterName.trim().toUpperCase() + " = ")) {
                            returnValue = msg.substring(msg.indexOf(" = ") + 3).trim();
                        } else if (msg.toUpperCase().startsWith(parameterName.trim().toUpperCase() + " =")) {
                            returnValue = msg.substring(msg.indexOf(" =") + 2).trim();
                        }
                    }
                } catch (Exception d) {
                }

            }
        } catch (Exception e) {
            System.out.println(":: Error occured reading parameters:::" + e.toString());
            e.printStackTrace();
        }
        return returnValue;
    }

    public static <T> T toPOJO(String requestStr, Class<T> entityClass) throws JsonMappingException, JsonGenerationException, IOException, UnrecognizedPropertyException {
        T entity = null;
        ObjectMapper om = new ObjectMapper();
        entity = (T) om.readValue(requestStr, entityClass);
        return entity;
    }

    public static <T> List<T> toPOJOList(String requestStr, Class<T> entityClass) throws JsonMappingException, JsonGenerationException, IOException, UnrecognizedPropertyException {
        ObjectMapper om = new ObjectMapper();
        CollectionType listType = om.getTypeFactory().constructCollectionType(ArrayList.class, entityClass);
        List<T> entityList = om.readValue(requestStr, listType);
        return entityList;
    }

    public String toXml(Object ob) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ob.getClass());
        Marshaller marshaller = jc.createMarshaller();
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(ob, stringWriter);
        String xml = stringWriter.getBuffer().toString();
        return xml;
    }

    public <F> F fromXml(Class<F> clazz, String xml) throws JAXBException {
        Unmarshaller unmarshaller = null;
        Source xmlSource = null;
        JAXBElement<F> unmarshal = null;
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml)));
            JAXBContext jc = JAXBContext.newInstance(clazz);
            unmarshaller = jc.createUnmarshaller();
            unmarshal = unmarshaller.unmarshal(xmlSource, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (unmarshal != null) ? unmarshal.getValue() : null;
    }

    public String encryptData(String data)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String endata = "";
        if ("".equals(data) || null == data) {
            return "";
        }
        byte byteKey[] = (byte[]) hex2byte(encKey);
        SecretKeySpec skeySpec = new SecretKeySpec(byteKey, "AES");
        Cipher cip = Cipher.getInstance("AES");
        cip.init(1, skeySpec);
        byte bytedata[] = cip.doFinal(data.getBytes("UTF-8"));
        endata = asHex(bytedata);
        return endata;
    }

    public String decryptData(String encrypted)
            throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if ("".equals(encrypted) || null == encrypted) {
            return "";
        }
        byte byteKey[] = (byte[]) hex2byte(encKey);
        byte byteEncData[] = hex2byte(encrypted);
        SecretKeySpec skeySpec = new SecretKeySpec(byteKey, "AES");
        Cipher cip = Cipher.getInstance("AES");
        cip.init(2, skeySpec);
        byte original[] = cip.doFinal(byteEncData);
        String originalString = new String(original, "UTF-8");
        return originalString;
    }

    public String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if ((buf[i] & 0xff) < 16) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString(buf[i] & 0xff, 16));
        }

        return strbuf.toString();
    }

    public static byte[] hex2byte(String s) {
        return hex2byte(s.getBytes(), 0, s.length() >> 1);
    }

    public static byte[] hex2byte(byte b[], int offset, int len) {
        byte d[] = new byte[len];
        for (int i = 0; i < len * 2; i++) {
            int shift = i % 2 == 1 ? 0 : 4;
            d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
        }
        return d;
    }

    public static Response sendRequest(String url, String request, String httpMethod, boolean isHeaderRequired, Map<String, String> requestHeaders, boolean isJson, boolean emptyBody) throws Exception {
        Response respObj = null;
        try {
            client = ClientBuilder.newClient();
            System.out.println(" ..:  Service Url : " + url);
            target = client.target(url);
            requestBuilder = target.request();
            //     if (!emptyBody) {
            requestBuilder = requestBuilder.accept(isJson ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML);
            //     }
            if (isHeaderRequired) {
                System.out.println("===============================================================");
                requestHeaders.forEach((name, value) -> {
                    System.out.println(" Header : [ " + name + " ] = [" + value + "] ");
                    requestBuilder = requestBuilder.header(name, value);
                });
                System.out.println("===============================================================");
            }
            System.out.println("About sending request to nip service : " + request);

            switch (httpMethod) {
                case "GET":
                    respObj = requestBuilder.get();
                    System.out.println(" ..: Status from Get Request to NIP Service : " + ((respObj != null) ? String.valueOf(respObj.getStatus()) : "N/A"));
                    break;
                case "POST":
                    respObj = requestBuilder.post(isJson ? Entity.json(request) : Entity.xml(request));
                    System.out.println(" ..: Status from Post Request to NIP Service : " + ((respObj != null) ? String.valueOf(respObj.getStatus()) : "N/A"));
                    break;
                case "PUT":
                    respObj = requestBuilder.put(isJson ? Entity.json(request) : Entity.xml(request));
                    System.out.println(" ..: Status from Put Request to NIP Service : " + ((respObj != null) ? String.valueOf(respObj.getStatus()) : "N/A"));
                    break;
            }
        } catch (ProcessingException ex) {
            ex.printStackTrace();
        }
        return respObj;
    }

    public String generateHash256Value(String text) {
        MessageDigest m = null;
        String hashText = null;
        try {
            m = MessageDigest.getInstance("SHA-256");
            try {
                m.update(text.getBytes("UTF-8"), 0, text.length());
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            hashText = new BigInteger(1, m.digest()).toString(16);
            if (hashText.length() < 64) { //must be 64 in length
                int numberOfZeroes = 64 - hashText.length();
                String zeroes = "";
                for (int i = 0; i < numberOfZeroes; i++) {
                    zeroes = zeroes + "0";
                }
                hashText = zeroes + hashText;
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        hashText = String.valueOf(hashText).toUpperCase();
        System.out.println("Hash Value Generated : " + hashText);
//        String hashInHex = bytesToHex(hashText.getBytes());
//        System.out.println("Hash Value in Hex Format : " + hashInHex);
        return hashText;
    }

    public String generateSha256(String originalString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            return sha256BytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String sha256BytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String bytesToHex(byte[] data) {
        if (data == null) {
            return null;
        }
        int len = data.length;
        String str = "";
        for (int i = 0; i < len; i++) {
            if ((data[i] & 0xFF) < 16) {
                str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
            } else {
                str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
            }
        }
        return str;
    }

    public String generateSessionID() {
        return new SimpleDateFormat("yyMMddHHmmss").format(new Date()) + new RandomGenerator().getRandomLong(99999999999D, 999999999999D);
    }

  //  public static void main(String ar[]) {
    //      System.out.println(new Util().generateHash256Value("0003020191002BU~0vn1CaZwq9OL"));
//        try {
//            System.out.println(new Util("a0c74ee5987324d9ecd30ce4a728f559").encryptData("visionaryleaderslikemrajao"));
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchPaddingException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidKeyException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalBlockSizeException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (BadPaddingException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        }
    //   }
}
