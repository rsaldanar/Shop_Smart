/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.utility;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author rsaldana
 */
public class Utility {

    private static String hMacSha512 = "HmacSHA512";
    private static final String authKey = "asdhakjshdkjasdasmndajksdkjaskldga8odya9d8yoasyd98asdyaisdhoaisyd0a8sydoashd8oasydoiahdpiashd09ayusidhaos8dy0a8dya08syd0a8ssdsax";

    public static String StringToHash512(String inString) {
// sucursalModel.setDescripcionSucursal(Utility.StringToHash512(sucursalModel.getDescripcionSucursal()));
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(inString.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();// Por ser multi hilo se utiliza este tiepo de obj

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

   
    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static String KeyToHash512HMac(String data) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(authKey.getBytes(), hMacSha512);
        Mac mac = Mac.getInstance(hMacSha512);
        mac.init(secretKeySpec);
        System.out.println("datos brutos "+data);
        System.out.println(toHexString(mac.doFinal(data.getBytes())));
        
        return toHexString(mac.doFinal(data.getBytes()));
    }

}
