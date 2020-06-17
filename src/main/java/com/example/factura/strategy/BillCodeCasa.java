package com.example.factura.strategy;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BillCodeCasa implements GenerateBillCodeStrategy {
    @Override
    public String generateCode(String code) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return "";
        }
        md.update(code.getBytes());
        byte[] digest = md.digest();
        String newCode = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        return newCode;
    }
}
