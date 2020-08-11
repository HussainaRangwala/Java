package encrypt_decrypt;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Substitution_Encrypt
{
	String fname_r,fname_w;
	int key;

	Substitution_Encrypt(String f,String f1)
	{
		fname_r=f;
		//key=k;
		fname_w=f1;
	}//Substitutuion

	public void encrypt()
	{
		FileReader fr=null;
		FileWriter fw=null;
		try
		{
			fr=new FileReader(fname_r);
			fw=new FileWriter(fname_w);
			int c=0;
			while((c=fr.read())!=-1)
			{
				char ch=(char)c;
				/*if(ch==' '|| ch=='\t'|| ch=='\n')
				;*/
				/*JOptionPane.showMessageDialog(null,"1- "+Integer.toString(c)+"\n11 "+(char)c);*/
				/*if(ch==' '||ch=='\t'||ch=='\n')
					;
				else
				{
					c=c+key;
					//JOptionPane.showMessageDialog(null,"2- "+Integer.toString(c)+"\n22 "+(char)c);
					fw.write(c);
				}*/

				switch(ch)
				{
					case 'A':
					case 'a':
						fw.write('Q');	break;

					case 'B':
					case 'b':
						fw.write('W');	break;

					case 'C':
					case 'c':
						fw.write('E');	break;

					case 'D':
					case 'd':
						fw.write('R');	break;

					case 'E':
					case 'e':
						fw.write('T');	break;

					case 'F':
					case 'f':
						fw.write('Y');	break;

					case 'G':
					case 'g':
						fw.write('U');	break;

					case 'H':
					case 'h':
						fw.write('I');	break;

					case 'I':
					case 'i':
						fw.write('O');	break;

					case 'J':
					case 'j':
						fw.write('P');	break;

					case 'K':
					case 'k':
						fw.write('A');	break;

					case 'L':
					case 'l':
						fw.write('S');	break;

					case 'M':
					case 'm':
						fw.write('D');	break;

					case 'N':
					case 'n':
						fw.write('F');	break;


					case 'O':
					case 'o':
						fw.write('G');	break;

					case 'P':
					case 'p':
						fw.write('H');	break;

					case 'Q':
					case 'q':
						fw.write('J');	break;

					case 'R':
					case 'r':
						fw.write('K');	break;

					case 'S':
					case 's':
						fw.write('L');	break;


					case 'T':
					case 't':
						fw.write('Z');	break;

					case 'U':
					case 'u':
						fw.write('X');	break;

					case 'V':
					case 'v':
						fw.write('C');	break;

					case 'W':
					case 'w':
						fw.write('V');	break;

					case 'X':
					case 'x':
						fw.write('B');	break;

					case 'Y':
					case 'y':
						fw.write('N');	break;

					case 'Z':
					case 'z':
						fw.write('M');	break;

				}
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
				new Compress(fname_w);
				JOptionPane.showMessageDialog(null,"File encrypted successfully!!!\nName of file is: "+fname_w);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception2: "+e);
			}
		}
	}
}
