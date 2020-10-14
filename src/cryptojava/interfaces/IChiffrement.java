/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava.interfaces;

import javax.crypto.Cipher;

/**
 *
 * @author hp
 */
public interface IChiffrement {
    
    /**
     * a method to initialize the engine for ciphering
     * @param keyFile
     * @return 
     */
    public Cipher getCipher(String keyFile);
    
    /**
     * 
     * @param password
     * @return 
     */
    public Cipher getCipher(char [] password);
    
    
    public boolean process(String fileToEncrypt, String fileDestination, Cipher cipher);
    
    public boolean runCipher(String fileDestination,String fileToEncrypt,String keyFile);
    
    /**
     * 
     * @param password
     * @param fileToEncrypt
     * @param fileDestination
     * @return 
     */
    public boolean runCipher(char[] password,String fileToEncrypt,String fileDestination);
    
}
