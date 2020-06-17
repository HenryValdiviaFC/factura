package com.example.factura.strategy;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BillCodePlana implements GenerateBillCodeStrategy {
    @Override
    public String generateCode(String code) {
        String sha1 = "";
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return "";
        }
        digest.reset();
        try {
            digest.update(code.getBytes("utf8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return "";
        }
        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        return sha1;
    }
}
