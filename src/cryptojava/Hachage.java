/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author hp
 */
public class Hachage {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] has = md.digest("hello babe".getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : has) {
            sb.append(String.format("%02x ", b));
        }
        System.out.println(sb.toString());
        System.out.println(has);
        
    }
}
