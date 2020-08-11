package encrypt_decrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.*;

public class BlowfishAudioDec {
	private final static int IV_LENGTH = 16; 
    private final static int DEFAULT_READ_WRITE_BLOCK_BUFFER_SIZE = 1024;

    private final static String ALGO_RANDOM_NUM_GENERATOR = "SHA1PRNG";
    private final static String ALGO_SECRET_KEY_GENERATOR = "Blowfish";
    private final static String ALGO_AUDIO_ENCRYPTOR = "Blowfish/CBC/PKCS5Padding";

    public BlowfishAudioDec(String input_file,String dec_file,SecretKey key,AlgorithmParameterSpec paramSpec) throws Exception
    {
    	 
    	byte[] keyData = key.getEncoded();
        SecretKey key2 = new SecretKeySpec(keyData, 0, keyData.length, ALGO_SECRET_KEY_GENERATOR); //if you want to store key bytes to db so its just how to //recreate back key from bytes array

      
        BlowfishAudioDec.decrypt(key2, paramSpec, new FileInputStream(input_file), new FileOutputStream(dec_file));
         
    }
    
    
    
    public static void decrypt(SecretKey key, AlgorithmParameterSpec paramSpec, InputStream in, OutputStream out)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IOException {
        try {
        	
            // byte[] iv = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C,
            // 0x07, 0x72, 0x6F, 0x5A, (byte) 0x8E, 0x12, 0x39, (byte) 0x9C,
            // 0x07, 0x72, 0x6F, 0x5A };
            // AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            Cipher c = Cipher.getInstance(ALGO_AUDIO_ENCRYPTOR);
            c.init(Cipher.DECRYPT_MODE, key, paramSpec);
            out = new CipherOutputStream(out, c);
            int count = 0;
            byte[] buffer = new byte[DEFAULT_READ_WRITE_BLOCK_BUFFER_SIZE];
            while ((count = in.read(buffer)) >= 0) {
                out.write(buffer, 0, count);
            }
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
       

    } 
}

