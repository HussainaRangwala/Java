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
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishAudioEnc{
// Default length with Default 128
     // key AES encryption
	private final static int IV_LENGTH = 16; 
    private final static int DEFAULT_READ_WRITE_BLOCK_BUFFER_SIZE = 1024;

    private final static String ALGO_RANDOM_NUM_GENERATOR = "SHA1PRNG";
    private final static String ALGO_SECRET_KEY_GENERATOR = "Blowfish";
    private final static String ALGO_AUDIO_ENCRYPTOR = "Blowfish/CBC/PKCS5Padding";

    public BlowfishAudioEnc(String input_file,String enc_file,SecretKey key,AlgorithmParameterSpec paramSpec) 
    {
    	try{
    	 byte[] keyData = key.getEncoded();
         BlowfishAudioEnc.encrypt(key, paramSpec, new FileInputStream(input_file), new FileOutputStream(enc_file));
    	}
    	catch(Exception e){System.out.println(e);
		}
    }
    
    
    public static void encrypt(SecretKey key, AlgorithmParameterSpec paramSpec, InputStream in, OutputStream out)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IOException {
        try {
            // byte[] iv = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C,
            // 0x07, 0x72, 0x6F, 0x5A, (byte) 0x8E, 0x12, 0x39, (byte) 0x9C,
            // 0x07, 0x72, 0x6F, 0x5A };
            // AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            Cipher c = Cipher.getInstance(ALGO_AUDIO_ENCRYPTOR);
            c.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            out = new CipherOutputStream(out, c);
            int count = 0;
            byte[] buffer = new byte[DEFAULT_READ_WRITE_BLOCK_BUFFER_SIZE];
            while ((count = in.read(buffer)) >= 0) {
                out.write(buffer, 0, count);
            }
        }
        catch(Exception e){System.out.println(e);
		}
        finally {
            out.close();
        }
    }

    

    public static void main(String[] args) {
       
    } 
}

