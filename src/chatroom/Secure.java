package chatroom;

import java.math.BigInteger;
import java.security.*;

/**
 * A Secure object is used to hash passwords, using the SHA-512 algorithm.
 * @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
 */
public class Secure {
    
    /** 
     * Hashes the password, then restitues the hash as a String object.
     * @param pwd (String) : the password to be hashed
     * @return String
     */
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