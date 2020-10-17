/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptojava;

import cryptojava.classes.Chiffrement;
import cryptojava.classes.Dechiffrement;
import cryptojava.classes.KeyGeneration;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author hp
 */
public class CryptoJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //KeyGeneration l = new KeyGeneration();
        //l.keyGeneration("C:\\Users\\hp\\Desktop\\LINDAdossier\\cours\\CRYPTOGRAPHIE\\CRYPTO-JAVA\\clé.txt");

        /*JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ret = jfc.showOpenDialog(null); // ne te rend la main que si tu ferme
        if(ret == JFileChooser.APPROVE_OPTION) { // validation
            System.out.println("Selected dir : " + jfc.getSelectedFile());
        }
        String Dest = jfc.getSelectedFile().toString();
        l.keyGeneration(Dest);*/
        
        
        Chiffrement chiff = new Chiffrement();
        //chiff.process("./ExposerSSI.pdf", "./vendu.txt", null);
        //chiff.runCipher( "./vendue.txt", "./vendu.txt", "./clé.txt");
        chiff.runCipher("linda".toCharArray(), "./vendue.txt", "vendito.txt");
        
        //Dechiffrement dec = new Dechiffrement();
        //dec.runCipher("./vendu.txt", "./vend.txt", "./clé.txt");
        
        Dechiffrement dec = new Dechiffrement();
        dec.runCipher("linda".toCharArray(), "vendito.txt", "benita.txt");

   }
    
}
    

