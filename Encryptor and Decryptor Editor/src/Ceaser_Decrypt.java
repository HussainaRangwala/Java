package encrypt_decrypt;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Ceaser_Decrypt
{
	String fname_r,fname_w;
	int key;

	Ceaser_Decrypt(String f,String f1,int k)
	{
		fname_r=f;
		key=k;
		fname_w=f1;
	}//Ceaser

	public void decrypt()
	{
		FileReader fr=null;
		FileWriter fw=null;
		try
		{
			fr=new FileReader(fname_r);
			fw=new FileWriter(fname_w);
			System.out.println(fname_r);
			int c=0;
			while((c=fr.read())!=-1)
			{
				char ch=(char)c;
				c=c-key;
				
				/*if(ch==' '|| ch=='\t'|| ch=='\n')
				;*/
				/*JOptionPane.showMessageDialog(null,"1- "+Integer.toString(c)+"\n11 "+(char)c);*/
				/*if(ch==' '||ch=='\t'||ch=='\n')
					;
				else
				{*
					c=c-key;
					/*JOptionPane.showMessageDialog(null,"2- "+Integer.toString(c)+"\n22 "+(char)c);*/
					fw.write(c);
				/*}*/
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception: "+e);
		}
		finally
		{
			try
			{
				fr.close();
				fw.close();
				JOptionPane.showMessageDialog(null,"File decrypted successfully!!!\nName of file is: "+fname_w);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception2: "+e);
			}
		}
	}
}