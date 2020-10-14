/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava.interfaces;

/**
 *
 * @author hp
 */
public interface ICryptoConfig {
    
    public static String algo = "AES";
    public static int keySize = 128;
    public static String transform = "AES/CBC/PKCS5Padding";
    public static String iv = "licenceL3Tdsi220";
    //
    public final String skftransform="PBEWithHmacSHA256AndAES_128";
    public final String kdf="PBKDF2WithHmacSHA1";
    public final int ieration=1000;
    public final byte [] salt="MO5-°HG3YEH255367gdsjhgd".getBytes();
}
