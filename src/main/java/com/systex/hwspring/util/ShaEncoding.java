package com.systex.hwspring.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaEncoding {
    public static String parseSHA256(String target){
        String shaStr = null ;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(target.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            shaStr=hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  shaStr;

    }
}
