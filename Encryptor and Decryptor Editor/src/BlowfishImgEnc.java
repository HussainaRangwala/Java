package encrypt_decrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class BlowfishImgEnc {


	    KeyGenerator keyGenerator = null;
	    SecretKey secretKey = null;
	    Cipher cipher = null;

	    public BlowfishImgEnc(String input_file,String enc_file,SecretKey key) {
	        try {
	            
	            //keyGenerator = KeyGenerator.getInstance("Blowfish");
	            //secretKey = keyGenerator.generateKey();
	        	secretKey=key;
	            cipher = Cipher.getInstance("Blowfish");
	            String encryptedFile=enc_file;
	            this.encrypt(input_file,encryptedFile);
	            
	        } catch (NoSuchPaddingException ex) {
	            System.out.println(ex);
	        } catch (NoSuchAlgorithmException ex) {
	            System.out.println(ex);
	        }
	    }

	    public static void main(String[] args) {
	        /*String fileToEncrypt = "Tulips.jpg";
	        //String encryptedFile = "encryptedFile.jpg";
	        String decryptedFile = "decryptedFile.jpg";
	       
	         encryptFile = new ImgEnc();
	        System.out.println("Starting Encryption...");
	        encryptFile.encrypt(fileToEncrypt,
	                encryptedFile);
	        System.out.println("Encryption completed...");
	        System.out.println("Starting Decryption...");
	        encryptFile.decrypt(encryptedFile,decryptedFile);
	        System.out.println("Decryption completed...");*/
	    }

	    /*
	     
	     * Encrypts the file in srcPath and creates a file in destPath
	     */
	    private void encrypt(String srcPath, String destPath) {
	        File rawFile = new File(srcPath);
	        File encryptedFile = new File(destPath);
	        InputStream inStream = null;
	        OutputStream outStream = null;
	        try {
	            /**
	             * Initialize the cipher for encryption
	             */
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            /**
	             * Initialize input and output streams
	             */
	            inStream = new FileInputStream(rawFile);
	            outStream = new FileOutputStream(encryptedFile);
	            byte[] buffer = new byte[1024];
	            int len;
	            while ((len = inStream.read(buffer)) > 0) {
	                outStream.write(cipher.update(buffer, 0, len));
	                outStream.flush();
	            }
	            outStream.write(cipher.doFinal());
	            inStream.close();
	            outStream.close();
	        } catch (IllegalBlockSizeException ex) {
	            System.out.println(ex);
	        } catch (BadPaddingException ex) {
	            System.out.println(ex);
	        } catch (InvalidKeyException ex) {
	            System.out.println(ex);
	        } catch (FileNotFoundException ex) {
	            System.out.println(ex);
	        } catch (IOException ex) {
	            System.out.println(ex);
	        }
	    }

	    /**
	     * 
	     * @param srcPath
	     * @param destPath
	     *
	     * Decrypts the file in srcPath and creates a file in destPath
	     */
	   
}

