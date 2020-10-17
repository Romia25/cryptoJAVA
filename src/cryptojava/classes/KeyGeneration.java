/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava.classes;

import cryptojava.interfaces.ICryptoConfig;
import static cryptojava.interfaces.ICryptoConfig.kdf;
import cryptojava.interfaces.IKeyGeneration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author hp
 */
public class KeyGeneration implements IKeyGeneration{

    @Override
    public SecretKey keyGen() {//doit etre private
        
        try {
            KeyGenerator kg = KeyGenerator.getInstance(ICryptoConfig.algo);
            kg.init(ICryptoConfig.keySize);
            return kg.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public boolean saveKey(String filePath, SecretKey key) {//doit etre private
        
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(key);
            oos.close();
            fos.close();
            return true;
                    } catch (IOException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    

    @Override
    public boolean keyGeneration(String filePath) {
        
        SecretKey k = keyGen();
        return saveKey(filePath, k);
    }

    @Override
    public SecretKey recupKey(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SecretKey key = (SecretKey) ois.readObject();
            return key;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    
    }

    @Override
    public SecretKey keyGen(char[] password) {
        
         SecretKey clepbe=null;
        //on appelle Transforme le mot de passe en tableau de Char
       
        //on appelle le KDF: PBEKeySpec pour construire une clé
          SecretKeyFactory kdfFactory;
        try {
            
             //char[] passwrd = password.toCharArray();
        PBEKeySpec pbe = new PBEKeySpec(password, ICryptoConfig.salt, ICryptoConfig.ieration, ICryptoConfig.keySize);
       
        //password="";
	for (int j = 0; j < password.length; j++) {
		password[j] = 0;
	}
        
            kdfFactory = SecretKeyFactory.getInstance(ICryptoConfig.kdf);
             SecretKey keyPBE = kdfFactory.generateSecret(pbe);
           clepbe=new SecretKeySpec(keyPBE.getEncoded(), ICryptoConfig.algo);
           return clepbe;
	
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
    }
    
}
