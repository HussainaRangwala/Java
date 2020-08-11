package encrypt_decrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compress
{
	Compress(String fname_w)
	{
		byte[] buffer = new byte[1024];

    	try{
    		String fname=fname_w+".zip";
    		FileOutputStream fos = new FileOutputStream(fname);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry(fname_w);
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(fname_w);
  
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();

    		//remember close it
    		zos.close();

    		System.out.println("Done");

    	}catch(IOException ex){
    		
    	   ex.printStackTrace();
    	}
	}
    public static void main( String[] args )
    {
    	
    }
}
