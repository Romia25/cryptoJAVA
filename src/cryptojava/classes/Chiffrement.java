/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava.classes;

import cryptojava.interfaces.IChiffrement;
import cryptojava.interfaces.ICryptoConfig;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author hp
 */
public class Chiffrement implements IChiffrement{

    @Override
    public Cipher getCipher(String keyFile) {
        KeyGeneration kl = new KeyGeneration();
        SecretKey key = kl.recupKey(keyFile);
        
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.transform);
            c.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException  ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean process(String fileToEncrypt, String fileDestination, Cipher cipher) {
        try {
            FileInputStream fis = new FileInputStream(fileToEncrypt);
            byte[] tampons = new byte[1024];
            FileOutputStream fos = new FileOutputStream(fileDestination);
            CipherOutputStream cos  = new  CipherOutputStream(fos, cipher);
            int taille_lu = 0;
            taille_lu = fis.read(tampons);
            while(taille_lu != -1){
                cos.write(tampons, 0, taille_lu);
                taille_lu = fis.read(tampons);
            }
            cos.close();
            fis.close();
            fos.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean runCipher( String fileToEncrypt, String fileDestination, String keyFile) {
        Cipher c = getCipher(keyFile);
        return 
                process(fileToEncrypt, fileDestination, c);
    }

    @Override
    public Cipher getCipher(char[] password) {
        
        KeyGeneration k2 = new KeyGeneration();
        SecretKey ke = k2.keyGen(password);
       
        
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.transform);
            c.init(Cipher.ENCRYPT_MODE, ke, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException  ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public boolean runCipher(char[] password, String fileToEncrypt, String fileDestination) {
        Cipher ci = getCipher(password);
        return process(fileToEncrypt, fileDestination, ci);
    }

   
    
}
