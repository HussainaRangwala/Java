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

public class AesImgDec {
	


	    KeyGenerator keyGenerator = null;
	    SecretKey secretKey = null;
	    Cipher cipher = null;

	    public AesImgDec(String input_file,String dec_file,SecretKey key) {
	        try {
	            
	            keyGenerator = KeyGenerator.getInstance("AES");
	            secretKey=key;
	            cipher = Cipher.getInstance("AES");
	            String decryptedFile=dec_file;
	            this.decrypt(input_file,decryptedFile);
	            
	        } catch (NoSuchPaddingException ex) {
	            System.out.println(ex);
	        } catch (NoSuchAlgorithmException ex) {
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
	    private void decrypt(String srcPath, String destPath) {
	        File encryptedFile = new File(srcPath);
	        File decryptedFile = new File(destPath);
	        InputStream inStream = null;
	        OutputStream outStream = null;
	        try {
	            /**
	             * Initialize the cipher for decryption
	             */
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            /**
	             * Initialize input and output streams
	             */
	            inStream = new FileInputStream(encryptedFile);
	            outStream = new FileOutputStream(decryptedFile);
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


	    public static void main(String[] args) {
	        
	    }

	    /*
	     
	     * Encrypts the file in srcPath and creates a file in destPath
	     */
}



