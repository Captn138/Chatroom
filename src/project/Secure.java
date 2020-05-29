package project;

import java.math.BigInteger;
import java.security.*;

public class Secure {
    public String hash(String pwd) {
        MessageDigest md;
        String hashtext = "";
        try {
            md = MessageDigest.getInstance("SHA-512");
            byte[] digested = md.digest(pwd.getBytes());
            BigInteger bi = new BigInteger(1, digested);
            hashtext = bi.toString(16);
            while(hashtext.length() < 31) {
                hashtext = "0" + hashtext;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashtext;
    }
}


//https://www.geeksforgeeks.org/sha-512-hash-in-java/