package encrypt_decrypt;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


class DESed {
    private static final String ALGORITHM = "DES";
    private static final String TRANSFORMATION = "DES";
 
    public static void encrypt(String key, File inputFile, File outputFile)
    {
    	try{
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);}
    	catch(Exception e){}
    }
    
    public static void decrypt(String key, File inputFile, File outputFile)
    {
    	try{
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile); }
    	catch(Exception e){}
    }

    
    private static void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
        	
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
        
    }
}

public class DES {
    DES(String key,String input_f,String fname,String type) {
        File inputFile = new File(input_f);

         
        try {
        	if(type.equals("e"))
        	{
        		 File encryptedFile = new File(fname);
        		DESed.encrypt(key, inputFile, encryptedFile);
        		//new Compress(fname);
        	}
        	else
        	{
        		File decryptedFile = new File(fname);
        		DESed.decrypt(key, inputFile, decryptedFile);
        	}
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void main(String args[])
    {
    }
}

