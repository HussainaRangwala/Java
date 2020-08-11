package encrypt_decrypt;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Substitution_Decrypt
{
	String fname_r,fname_w;
	int key;

	Substitution_Decrypt(String f,String f1)
	{
		fname_r=f;
		//key=k;
		fname_w=f1;
	}//Substitutuion

	public void decrypt()
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
					case 'Q':
					case 'q':
						fw.write('A');	break;

					case 'W':
					case 'w':
						fw.write('B');	break;

					case 'E':
					case 'e':
						fw.write('C');	break;

					case 'R':
					case 'r':
						fw.write('D');	break;

					case 'T':
					case 't':
						fw.write('E');	break;

					case 'Y':
					case 'y':
						fw.write('F');	break;

					case 'U':
					case 'u':
						fw.write('G');	break;

					case 'I':
					case 'i':
						fw.write('H');	break;

					case 'O':
					case 'o':
						fw.write('I');	break;

					case 'P':
					case 'p':
						fw.write('J');	break;

					case 'A':
					case 'a':
						fw.write('K');	break;

					case 'S':
					case 's':
						fw.write('L');	break;

					case 'D':
					case 'd':
						fw.write('M');	break;

					case 'F':
					case 'f':
						fw.write('N');	break;


					case 'G':
					case 'g':
						fw.write('O');	break;

					case 'H':
					case 'h':
						fw.write('P');	break;

					case 'J':
					case 'j':
						fw.write('Q');	break;

					case 'K':
					case 'k':
						fw.write('R');	break;

					case 'L':
					case 'l':
						fw.write('S');	break;


					case 'Z':
					case 'z':
						fw.write('T');	break;

					case 'X':
					case 'x':
						fw.write('U');	break;

					case 'C':
					case 'c':
						fw.write('V');	break;

					case 'V':
					case 'v':
						fw.write('W');	break;

					case 'B':
					case 'b':
						fw.write('X');	break;

					case 'N':
					case 'n':
						fw.write('Y');	break;

					case 'M':
					case 'm':
						fw.write('Z');	break;

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
				JOptionPane.showMessageDialog(null,"File encrypted successfully!!!\nName of file is: "+fname_w);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception2: "+e);
			}
		}
	}
}

