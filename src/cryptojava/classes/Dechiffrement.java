/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava.classes;

import cryptojava.interfaces.ICryptoConfig;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author hp
 */
public class Dechiffrement extends Chiffrement{

    @Override
    public Cipher getCipher(String keyFile) {
        KeyGeneration kl = new KeyGeneration();
        SecretKey key = kl.recupKey(keyFile);
        
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.transform);
            c.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException  ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Cipher getCipher(char [] password) {
        KeyGeneration kl = new KeyGeneration();
        SecretKey key = kl.keyGen(password);
        
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.transform);
            c.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException  ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
