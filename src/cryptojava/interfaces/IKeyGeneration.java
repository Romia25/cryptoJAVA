/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava.interfaces;

import javax.crypto.SecretKey;

/**
 *
 * @author hp
 */
public interface IKeyGeneration {
    
    /*method for key generation
    param : algo --the algorithm for which one needs to do generation
            keySize --as we deal with crypto-sym one must precise length of key
    */
    public SecretKey keyGen();
    
    /**
     * 
     * @param password
     * @return 
     */
    public SecretKey keyGen(char[] password);
    
    
    /**
     * method that allowed one to save a key in a file
     * @param filePath the way through the file where one would store key
     * @param key key to be store
     * @return boolean that let konw if the action is a success or not
     */
    public boolean saveKey(String filePath, SecretKey key);
    
    
    public SecretKey recupKey(String filePath);
    
    /**
     * 
     * @param filePath
     * @return 
     */
    public boolean keyGeneration(String filePath);
    
    
}
