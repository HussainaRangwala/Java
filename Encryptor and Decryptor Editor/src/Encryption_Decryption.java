package encrypt_decrypt;

import java.util.*;
import java.text.*;
import java.awt.font.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.*;

class App_Image extends JWindow
{
	public App_Image(String filename, Frame f)
    {
        
        JLabel l = new JLabel(new ImageIcon(filename));
        
        f.add(l);
        pack();
        setLocation(0,0);
        
        addMouseListener(new MouseAdapter()
            {
                public void mouseEntered(MouseEvent e)
                {
                    //setVisible(false);
                	System.out.println("Hello");
                    f.removeAll();
                    f.revalidate();
                    repaint();
                    //dispose();
                    
                }
            });
        //System.out.println(f.getLocation()+"\t"+f.getHeight()+"\t"+f.getWidth()+"\t"+f.getX()+"\t"+f.getY()+"\t");
        
        
    }
}

public class Encryption_Decryption extends JFrame implements MouseListener,ActionListener 
{
	String key="",check=" ";
	int width,height,i=1;
	private final static String ALGO_RANDOM_NUM_GENERATOR = "SHA1PRNG";
	JMenuBar mb;
	ButtonGroup bg;
	JMenu encrypt,decrypt,detail,about;
	JButton next,b_encrypt,b_clear,b_decrypt,browse,prev,next_pic;
	JTextField tf_key,tf_file;
	JComboBox cb_algo;
	JRadioButton text_rb,audio_rb,video_rb,image_rb; 
	JLabel choose,l_key,l_file,l_algo,l_sname,heading1,heading2,aes_pdf,des_pdf,tdes_pdf,blowfish_pdf,pdf_aes,pdf_des,pdf_tdes,pdf_blowfish;
	Font f;
	int flag=0;
	String algo;
	byte[] iv,iv1;
	JPanel p4,p;
	AlgorithmParameterSpec paramSpec,paramSpec1;
	Encryption_Decryption() throws Exception
	{
		this.setTitle("ENCRYPTION AND DECRYPTION SMART EDITOR");
		new App_Image("C:\\Users\\Public\\Pictures\\Sample Pictures\\encryption.jpg",this);
		//setLayout(null);
		JButton browse=new JButton("Browse");
		JButton b_encrypt=new JButton("Encrypt");
		JButton b_decrypt=new JButton("Decrypt");
		JButton b_clear=new JButton("Clear");
		JButton prev=new JButton("Previous");
		JButton next_pic=new JButton("next");
		
		mb=new JMenuBar();
        encrypt=new JMenu("Encrypt");
        decrypt=new JMenu("Decrypt");
        detail=new JMenu("Detail");
        about=new JMenu("About");
        mb.add(encrypt);
        mb.add(decrypt);
        mb.add(detail);
        mb.add(about);
        //mb.setBackground(new Color(255,255,255));
        text_rb=new JRadioButton("Text",true);
		image_rb=new JRadioButton("Image");
		audio_rb=new JRadioButton("Audio");
		video_rb=new JRadioButton("Video");
		bg=new ButtonGroup();
		bg.add(text_rb);
		bg.add(image_rb);
		bg.add(audio_rb);
		bg.add(video_rb);
		next=new JButton("Next");
		
		iv = new byte[16];  //For generating parameter key for AES algo
        SecureRandom.getInstance(ALGO_RANDOM_NUM_GENERATOR).nextBytes(iv); 
        paramSpec = new IvParameterSpec(iv);
        
        iv1 = new byte[8];//For generating parameter key for Blowfish algo 

        SecureRandom.getInstance(ALGO_RANDOM_NUM_GENERATOR).nextBytes(iv1); 
        paramSpec1 = new IvParameterSpec(iv1);
		
		addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
            	
                
                getContentPane().removeAll();
                getContentPane().revalidate();
                repaint();
                getContentPane().setBackground(new Color(255,255,255));
               
                setLayout(null);
            

                mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
                
                heading1=new JLabel("Welcome to the Encryption and Decryption Editor");
        		heading2=new JLabel("Secure your files and decrypt the files at a single place.");
        		heading1.setBounds(50,30,1100,60);
        		heading2.setBounds(240,100,1100,40);
        		Font f=new Font("",0,48);
        		Font f1=new Font("",0,30);
        		heading1.setFont(f);
        		heading2.setFont(f1);
        		add(heading1);
        		add(heading2);
        		//p1=new JPanel();
        		
        		
        		
        		JPanel p1=new JPanel(){
                    public void paint(Graphics g)
                    {
                                       try
                                       {
                                               Image img=ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\e1.jpg"));
                                               
                                               g.drawImage(img,0,0,400,400,null);
                                       }
                                       catch(Exception e)
                                       {
                                               //JOptionPane.showMessageDialog(null,"Unable to read image");
                                       }
                    }
        		};
        		p1.setBounds(180,240,400,400);
        		
        		getContentPane().add(p1);
        		JPanel p2=new JPanel(){
                    public void paint(Graphics g)
                    {
                                       try
                                       {
                                               Image img=ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\d1.jpg"));
                                               
                                               g.drawImage(img,0,0,400,400,null);
                                       }
                                       catch(Exception e)
                                       {
                                               //JOptionPane.showMessageDialog(null,"Unable to read image");
                                       }
                    }
        		};
        		p2.setBounds(600, 240, 400,400);
        		getContentPane().add(p2);
            }
        });
		encrypt.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				getContentPane().removeAll();
                getContentPane().revalidate();
                repaint();
                getContentPane().setBackground(new Color(255,255,255));
               
                setLayout(null);
            
                Font f=new Font("",0,20);
                mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
				choose=new JLabel("Choose one of the following type for encryption: ");
				
				
				choose.setBounds(300,200,600,30);
				choose.setFont(f);
				add(choose);
				text_rb.setFont(f);
				image_rb.setFont(f);
				audio_rb.setFont(f);
				video_rb.setFont(f);
				
				text_rb.setBounds(320,260,100,30);
				image_rb.setBounds(320,300,100,30);
				audio_rb.setBounds(320,340,100,30);
				video_rb.setBounds(320,380,100,30);
				add(text_rb);
				add(image_rb);
				add(audio_rb);
				add(video_rb);
				
				next.setBounds(380,450,100,30);
				add(next);
				check="encrypt";
			}
		});
		
		decrypt.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				
				getContentPane().removeAll();
                getContentPane().revalidate();
                repaint();
                getContentPane().setBackground(new Color(255,255,255));
               
                setLayout(null);
            
                Font f=new Font("",0,20);
                mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
				choose=new JLabel("Choose one of the following type for decryption : ");
				
				
				choose.setBounds(300,200,600,30);
				choose.setFont(f);
				add(choose);
				text_rb.setFont(f);
				image_rb.setFont(f);
				audio_rb.setFont(f);
				video_rb.setFont(f);
				
				text_rb.setBounds(320,260,100,30);
				image_rb.setBounds(320,300,100,30);
				audio_rb.setBounds(320,340,100,30);
				video_rb.setBounds(320,380,100,30);
				add(text_rb);
				add(image_rb);
				add(audio_rb);
				add(video_rb);
				
				next.setBounds(380,450,100,30);
				add(next);
				
                check="decrypt";
        	
			}
		});
		
		/*b_clear.addMouseListener(new MouseAdapter(){
		  public void MousePressed(MouseEvent me)
		  {
		  	
		  }
		   
		 
		 });*/
		//detail.addMouseListener(new MouseAdapter()
		//{
			/*public void mousePressed(MouseEvent me)
			{
				getContentPane().removeAll();
                getContentPane().revalidate();
                repaint();
                getContentPane().setBackground(new Color(255,255,255));
               
                setLayout(null);
                heading1=new JLabel("Comparison Between Different Algorithms");
        		heading1.setBounds(140,70,1100,60);
        		Font f=new Font("",0,48);
        		heading1.setFont(f);
        		add(heading1);

                mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
				    p4=new JPanel(){
                    public void paint(Graphics g)
                    {
                                       try
                                       {
                                               Image img=ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\comparison.jpg"));
                                               
                                               g.drawImage(img,60,60,900,730,null);
                                       }
                                       catch(Exception e)
                                       {
                                    	   System.out.println(e);
                                               //JOptionPane.showMessageDialog(null,"Unable to read image");
                                       }
                    }
        		};
        		p4.setBounds(60, 60, 900,730);
        		getContentPane().add(p4);
				
			}
		});*/
		
		detail.addMouseListener(new MouseAdapter()
				{
					public void mousePressed(MouseEvent me)
					{
						getContentPane().removeAll();
		                getContentPane().revalidate();
		                repaint();
		                getContentPane().setBackground(new Color(255,255,255));
		               
		                setLayout(null);
		                mb.setBounds(0,0,1200,20);
		                mb.setBackground(Color.WHITE);
		                add(mb);
						
						width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
						height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
						
						//JButton prev=new JButton("Previous");
						
						prev.setSize(100,30);
						prev.setLocation(80,360);
						add(prev);
						
						//JButton next_pic=new JButton("next");
						
						next_pic.setSize(100,30);
						next_pic.setLocation(1000,370);
						add(next_pic);
						
						p=new JPanel(){
				            public void paint(Graphics g)
				            {
				            	repaint();
				                getContentPane().setBackground(new Color(255,255,255));
				                               try
				                               {
				                                       Image img=ImageIO.read(new File(i+".jpg"));
				                                       
				                                       g.drawImage(img,width/5,height/6,width/2,550,null);
				                                       //g.drawImage(img,width/4,height/4,500,300,null);
				                               }
				                               catch(Exception e)
				                               {
				                            	   System.out.println(e);
				                                       //JOptionPane.showMessageDialog(null,"Unable to read image");
				                               }
				            }
						};
						p.setBounds(0, 0,width,height);
						getContentPane().add(p);
						
					}
			
				});
		
		about.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				getContentPane().removeAll();
				getContentPane().revalidate();
				repaint();
				getContentPane().setBackground(new Color(255,255,255));
           
				setLayout(null);
				mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
                
                heading1=new JLabel("Information About the Alogorithms");
                heading1.setBounds(180,70,1100,60);
        		Font f=new Font("",0,48);
        		heading1.setFont(f);
        		add(heading1);
        		Font f1=new Font("",0,20);
        		Map attributes = f1.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        		
				aes_pdf=new JLabel("AES Algorithm: ");
				des_pdf=new JLabel("DES Algorithm: ");
				tdes_pdf=new JLabel("Triple DES Algorithm: ");
				blowfish_pdf=new JLabel("Blowfish Algorithm: ");
				
				aes_pdf.setBounds(80,90,200,200);
				aes_pdf.setFont(f1);
				getContentPane().add(aes_pdf);
				
				pdf_aes = new JLabel("AES PDF");
				// To indicate the the link is clickable
				pdf_aes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				pdf_aes.setBounds(300,139,100,100);
				pdf_aes.setForeground(new Color(0,0,182,155));
				pdf_aes.setFont(f1.deriveFont(attributes));
				getContentPane().add(pdf_aes);
				
				des_pdf.setBounds(80,150,200,200);
				des_pdf.setFont(f1);
				getContentPane().add(des_pdf);
				pdf_des = new JLabel("DES PDF");
				// To indicate the the link is clickable
				pdf_des.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				pdf_des.setBounds(300,199,100,100);
				pdf_des.setForeground(new Color(0,0,182,155));
				pdf_des.setFont(f1.deriveFont(attributes));
				getContentPane().add(pdf_des);
				
				
				tdes_pdf.setBounds(80,210,200,200);
				tdes_pdf.setFont(f1);
				getContentPane().add(tdes_pdf);
				pdf_tdes = new JLabel("Triple DES PDF");
				// To indicate the the link is clickable
				pdf_tdes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				pdf_tdes.setBounds(300,259,200,100);
				pdf_tdes.setForeground(new Color(0,0,182,155));
				pdf_tdes.setFont(f1.deriveFont(attributes));
				getContentPane().add(pdf_tdes);
				
				
				blowfish_pdf.setBounds(80,270,200,200);
				blowfish_pdf.setFont(f1);
				getContentPane().add(blowfish_pdf);
				pdf_blowfish = new JLabel("Blowfish PDF");
				// To indicate the the link is clickable
				pdf_blowfish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				pdf_blowfish.setBounds(300,320,200,100);
				pdf_blowfish.setForeground(new Color(0,0,182,155));
				pdf_blowfish.setFont(f1.deriveFont(attributes));
				getContentPane().add(pdf_blowfish);
				
				
				
				pdf_aes.addMouseListener(new MouseAdapter() {
				        @Override
				        public void mouseClicked(MouseEvent e) {
				            try {
				                Desktop.getDesktop().open(
				                        new File("aes.pdf"));
				            } catch (IOException e1) {

				                e1.printStackTrace();
				            }
				        }
				    });
				pdf_des.addMouseListener(new MouseAdapter() {
			        @Override
			        public void mouseClicked(MouseEvent e) {
			            try {
			                Desktop.getDesktop().open(
			                        new File("des.pdf"));
			            } catch (IOException e1) {

			                e1.printStackTrace();
			            }
			        }
			    });
				
				pdf_tdes.addMouseListener(new MouseAdapter() {
			        @Override
			        public void mouseClicked(MouseEvent e) {
			            try {
			                Desktop.getDesktop().open(
			                        new File("tdes.pdf"));
			            } catch (IOException e1) {

			                e1.printStackTrace();
			            }
			        }
			    });
				
				pdf_blowfish.addMouseListener(new MouseAdapter() {
			        @Override
			        public void mouseClicked(MouseEvent e) {
			            try {
			                Desktop.getDesktop().open(
			                        new File("blowfish.pdf"));
			            } catch (IOException e1) {

			                e1.printStackTrace();
			            }
			        }
			    });
			
				
				
				
			}
            
		});
		next.addActionListener(this);
		prev.addActionListener(this);
		next_pic.addActionListener(this);
		browse.addActionListener(this);
		b_encrypt.addActionListener(this);
		b_decrypt.addActionListener(this);
		this.setSize(1200,730);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String type=" ";
		if(text_rb.isSelected())
		{
			type="text";
		}
		else if(image_rb.isSelected())
		{
			type="image";
		}
		else if(audio_rb.isSelected())
		{
			type="audio";
		}
		else
			type="video";
		if(ae.getActionCommand().equals("Previous"))
		{
			
				if(i==1)
					return;
				i--;
				p.repaint();
			
			
		}
		if(ae.getActionCommand().equals("next"))
		{
			getContentPane().setBackground(new Color(255,255,255));
			if(i==4)
				return;
			i++;
			p.repaint();
		}
		
		if(ae.getActionCommand().equals("Next"))
		{
			
			if(check.equals("encrypt"))
			{
				getContentPane().removeAll();
                getContentPane().revalidate();
                repaint();
                getContentPane().setBackground(new Color(255,255,255));
               
                setLayout(null);
            

                mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
                l_sname=new JLabel("Encryption");
                l_sname.setBounds(500,30,500,50);
                /*f=new Font(20,Font.BOLD,"Serif");*/
                f=new Font("Serif",Font.BOLD,40);
                l_sname.setFont(f);
                l_sname.setForeground(Color.RED);
                add(l_sname);

                l_file=new JLabel("File Name");
                l_file.setBounds(20,70,100,100);
                f=new Font("Utopia",Font.PLAIN,15);
                l_file.setFont(f);
                l_file.setForeground(Color.BLUE);
                add(l_file);

                tf_file=new JTextField(""); tf_file.setEditable(false);
                tf_file.setBounds(150,110,180,30);
                add(tf_file);
    		
                browse=new JButton("Browse");
                browse.setBounds(350,110,150,30);        		
                add(browse);
    		

                l_key=new JLabel("Encryption Key");
                l_key.setBounds(600,70,200,100);
                l_key.setFont(f);
                l_key.setForeground(Color.BLUE);
                add(l_key);

                tf_key=new JTextField("");	tf_key.setEditable(false);
                tf_key.setBounds(750,110,250,30);
                add(tf_key);

                l_algo=new JLabel("Encrypt Algorithm");
                l_algo.setBounds(350,210,250,100);
                l_algo.setFont(f);
                l_algo.setForeground(Color.BLUE);
                add(l_algo);

              
                if(type.equals("text"))
                {
                	String algo[]={"-----Select Algo-----","Ceaser Cipher Text","Substitution","AES","DES","Triple DES"};
                
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
                
                	add(cb_algo);
                }
                else if(type.equals("image"))
                {
                	String algo[]={"-----Select Algo------","DES","Triple DES","AES","Blowfish"};
                    
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
              
                	add(cb_algo);
                }
                else if(type.equals("audio"))
                {
                	String algo[]={"-----Select Algo------","DES","Triple DES","AES","Blowfish"};
                    
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
              
                	add(cb_algo);
                }
                else if(type.equals("video"))
                {
                	String algo[]={"-----Select Algo------","DES","Triple DES","AES","Blowfish"};
                    
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
              
                	add(cb_algo);
                }

                b_encrypt=new JButton("Encrypt");
                b_encrypt.setBounds(350,370,150,30);
                //b_encrypt.addActionListener(this);
                add(b_encrypt);

                //b_decrypt=new JButton("Decrypt");
                //b_decrypt.setBounds(300,300,150,30);
                //b_decrypt.addActionListener(this);
                //add(b_decrypt);

                b_clear=new JButton("Clear");
                b_clear.setBounds(530,370,150,30);
                //b_clear.addActionListener(this);
                add(b_clear);
                browse.addActionListener(this);
                b_encrypt.addActionListener(this);
                b_clear.addActionListener(this);
                //tf_file.requestFocus();
                //browse.addMouseListener(this);
			}
			else if(check.equals("decrypt"))
			{
				getContentPane().removeAll();
                getContentPane().revalidate();
                repaint();
                getContentPane().setBackground(new Color(255,255,255));
               
                setLayout(null);
            

                mb.setBounds(0,0,1200,20);
                mb.setBackground(Color.WHITE);
                add(mb);
                l_sname=new JLabel("Decryption");
                l_sname.setBounds(500,30,500,50);
                /*f=new Font(20,Font.BOLD,"Serif");*/
                f=new Font("Serif",Font.BOLD,40);
                l_sname.setFont(f);
                l_sname.setForeground(Color.RED);
                add(l_sname);

                l_file=new JLabel("File Name");
                l_file.setBounds(20,70,100,100);
                f=new Font("Utopia",Font.PLAIN,15);
                l_file.setFont(f);
                l_file.setForeground(Color.BLUE);
                add(l_file);

                tf_file=new JTextField(""); tf_file.setEditable(false);
                tf_file.setBounds(150,110,180,30);
                add(tf_file);
    		
                browse=new JButton("Browse");
                browse.setBounds(350,110,150,30);        		
                add(browse);
    		

                l_key=new JLabel("Decryption Key");
                l_key.setBounds(600,70,200,100);
                l_key.setFont(f);
                l_key.setForeground(Color.BLUE);
                add(l_key);

                tf_key=new JTextField("");	//tf_key.setEditable(false);
                tf_key.setBounds(750,110,250,30);
                add(tf_key);

                l_algo=new JLabel("Decrypt Algorithm");
                l_algo.setBounds(350,210,250,100);
                l_algo.setFont(f);
                l_algo.setForeground(Color.BLUE);
                add(l_algo);

                if(type.equals("text"))
                {
                	String algo[]={"-----Select Algo-----","Ceaser Cipher Text","Substitution","AES","DES","Triple DES"};
                
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
                
                	add(cb_algo);
                }
                else if(type.equals("image"))
                {
                	String algo[]={"-----Select Algo------","DES","Triple DES","AES","Blowfish"};
                    
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
              
                	add(cb_algo);
                }
                else if(type.equals("audio"))
                {
                	String algo[]={"-----Select Algo------","DES","Triple DES","AES","Blowfish"};
                    
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
              
                	add(cb_algo);
                }
                else if(type.equals("video"))
                {
                	String algo[]={"-----Select Algo------","DES","Triple DES","AES","Blowfish"};
                    
                	cb_algo=new JComboBox(algo);
                	cb_algo.setBounds(500,250,250,30);
              
                	add(cb_algo);
                }

                
                b_decrypt=new JButton("Decrypt");
                b_decrypt.setBounds(350,370,150,30);
                //b_encrypt.addActionListener(this);
                add(b_decrypt);

                //b_decrypt=new JButton("Decrypt");
                //b_decrypt.setBounds(300,300,150,30);
                //b_decrypt.addActionListener(this);
                //add(b_decrypt);

                b_clear=new JButton("Clear");
                b_clear.setBounds(530,370,150,30);
                //b_clear.addActionListener(this);
                add(b_clear);
                browse.addActionListener(this);
                b_decrypt.addActionListener(this);
                b_clear.addActionListener(this);
			}
		}
		
		if(ae.getActionCommand().equals("Browse"))
		{
			//System.out.println("Hello");
			JFrame.setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    JFrame frame = new JFrame("JComboBox Test");
		    frame.setLayout(new FlowLayout());
		    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //To close the inner window without closing the outer window
		    frame.setSize(200,200);
		    frame.setBounds(60,60,200,200);
		    JButton button = new JButton("Select File");
		    button.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		        JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
			          File selectedFile = fileChooser.getSelectedFile();
			          
			          //System.out.println("\""+selectedFile.getName()+"\"");
			          tf_file.setText(selectedFile.getName());
		        }
		     }
		   });
		    
		    
			
		    
		    frame.add(button);
		    frame.pack();
		    frame.setVisible(true);				
		}
		
		else if(ae.getActionCommand().equals("Encrypt"))
		{
			if(tf_file.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Enter the file to be encrypted");
				return;
			}
			String talgo=(String)cb_algo.getSelectedItem();
			if(talgo.equals("-----Select Algo------"))
			{
				JOptionPane.showMessageDialog(null, "Enter the algorithm name");
				return;
			}
			//System.out.println("Hello");
			
			String fname=JOptionPane.showInputDialog("Enter the file name for encrypted file: ");
			if(type.equals("text"))
			{
			
			
			fname=fname+".encrypted";
			if(talgo.equals("AES"))
			{
				try{
				Random r=new Random();
				char ch;
				key="";
				tf_key.setText(" ");
				for(int i=0;i<16;i++)
				{
					
					ch=(char)(65+r.nextInt(25));
					key+=ch;
				}
				//System.out.println(key);
				tf_key.setText(key);
				new CryptoUtil(key,tf_file.getText(),fname,"e");
				JOptionPane.showMessageDialog(null, "File encrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Encryption not possible");

				}
			}
			if(talgo.equals("DES"))
			{
				try{
				Random r=new Random();
				char ch;
				key="";
				tf_key.setText(" ");
				for(int i=0;i<8;i++)
				{
					
					ch=(char)(65+r.nextInt(25));
					key+=ch;
				}
				//System.out.println(key);
				tf_key.setText(key);
				new DES(key,tf_file.getText(),fname,"e");
				JOptionPane.showMessageDialog(null, "File encrypted successfully");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"Encryption not possible");

				}
			}
			if(talgo.equals("Triple DES"))
			{
				try{
				Random r=new Random();
				char ch;
				key="";
				tf_key.setText(" ");
				for(int i=0;i<24;i++)
				{
					
					ch=(char)(65+r.nextInt(25));
					key+=ch;
				}
				//System.out.println(key);
				tf_key.setText(key);
				new TripleDES(key,tf_file.getText(),fname,"e");
				JOptionPane.showMessageDialog(null, "File encrypted successfully");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"Encryption not possible");

				}
			}
			else if(talgo.equals("Ceaser Cipher Text"))
			{
				Random r=new Random();
				key="";
				tf_key.setText(" ");
				key=String.valueOf(r.nextInt(9)+1);
				//System.out.println(key);
				tf_key.setText(key);
				System.out.println(key);
				System.out.println("Int: "+Integer.parseInt(key));
				new Ceaser_Encrypt(tf_file.getText(),fname,Integer.parseInt(key)).encrypt();
				
			}
			else if(talgo.equals("Substitution"))
			{
				tf_key.setText(" ");
				new Substitution_Encrypt(tf_file.getText(),fname).encrypt();
			}
			}
			else if(type.equals("image"))
			{
				if(talgo.equals("Blowfish"))
				{
				try{
					fname+="enc.jpg";
					// create new key
					key=" ";
					tf_key.setText(" ");
					SecretKey secretKey = KeyGenerator.getInstance("Blowfish").generateKey();
					// get base64 encoded version of the key
					key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
					tf_key.setText(key);
					new BlowfishImgEnc(tf_file.getText(),fname,secretKey);
					JOptionPane.showMessageDialog(null,"Encrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Encryption not possible");

				}
				}
				if(talgo.equals("DES"))
				{
				try{
					fname+="enc.jpg";
					// create new key
					key=" ";
					tf_key.setText(" ");
					SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
					// get base64 encoded version of the key
					key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
					tf_key.setText(key);
					new DesImgEnc(tf_file.getText(),fname,secretKey);
					JOptionPane.showMessageDialog(null,"Encrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Encryption not possible");

				}
				}
				if(talgo.equals("Triple DES"))
				{
				try{
					fname+="enc.jpg";
					// create new key
					key=" ";
					tf_key.setText(" ");
					SecretKey secretKey = KeyGenerator.getInstance("DESede").generateKey();
					// get base64 encoded version of the key
					key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
					tf_key.setText(key);
					new TripleDesImgEnc(tf_file.getText(),fname,secretKey);
					JOptionPane.showMessageDialog(null,"Encrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Encryption not possible");

				}
				}
				else if(talgo.equals("AES"))
				{
					try{
					fname+="enc.jpg";
					// create new key
					key=" ";
					tf_key.setText(" ");
					SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
					// get base64 encoded version of the key
					key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
					tf_key.setText(key);
					new AesImgEnc(tf_file.getText(),fname,secretKey);
					JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
				}
				
			}
			else if(type.equals("video"))
			{
				if(talgo.equals("AES"))
				{
				try{
					fname+="enc.avi";
					// create new key
					key=" ";
					tf_key.setText(" ");
					SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
					// get base64 encoded version of the key
					
					key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
					tf_key.setText(key);
					new AesVideoEnc(tf_file.getText(),fname,secretKey,paramSpec);
					JOptionPane.showMessageDialog(null,"Encrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Encryption not possible");
				}
				}
				else if(talgo.equals("Blowfish"))
				{
					try{
						fname+="enc.avi";
						// create new key
						key=" ";
						tf_key.setText(" ");
						SecretKey secretKey = KeyGenerator.getInstance("Blowfish").generateKey();
						// get base64 encoded version of the key
						
						key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
						tf_key.setText(key);
						new BlowfishVideoEnc(tf_file.getText(),fname,secretKey,paramSpec1);
						JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
					
				}
				else if(talgo.equals("DES"))
				{
					try{
						fname+="enc.avi";
						// create new key
						key=" ";
						tf_key.setText(" ");
						SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
						// get base64 encoded version of the key
						
						key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
						tf_key.setText(key);
						new DesVideoEnc(tf_file.getText(),fname,secretKey,paramSpec1);
						JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
					
				}
				else if(talgo.equals("Triple DES"))
				{
					try{
						fname+="enc.avi";
						// create new key
						key=" ";
						tf_key.setText(" ");
						SecretKey secretKey = KeyGenerator.getInstance("DESede").generateKey();
						// get base64 encoded version of the key
						
						key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
						tf_key.setText(key);
						new TripleDesVideoEnc(tf_file.getText(),fname,secretKey,paramSpec1);
						JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
					
				}
			}
			else if(type.equals("audio"))
			{
				if(talgo.equals("AES"))
				{
				try{
					fname+="enc.mp3";
					// create new key
					key=" ";
					tf_key.setText(" ");
					SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
					// get base64 encoded version of the key
				
					key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
					tf_key.setText(key);
					new AesAudioEnc(tf_file.getText(),fname,secretKey,paramSpec);
					JOptionPane.showMessageDialog(null,"Encrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Encryption not possible");
				}
				}
				else if(talgo.equals("Blowfish"))
				{
					try{
						fname+="enc.mp3";
						// create new key
						key=" ";
						tf_key.setText(" ");
						SecretKey secretKey = KeyGenerator.getInstance("Blowfish").generateKey();
						// get base64 encoded version of the key
					
						key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
						tf_key.setText(key);
						new BlowfishAudioEnc(tf_file.getText(),fname,secretKey,paramSpec1);
						JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
				}
				else if(talgo.equals("DES"))
				{
					try{
						fname+="enc.mp3";
						// create new key
						key=" ";
						tf_key.setText(" ");
						SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
						// get base64 encoded version of the key
					
						key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
						tf_key.setText(key);
						new DesAudioEnc(tf_file.getText(),fname,secretKey,paramSpec1);
						JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
				}
				else if(talgo.equals("Triple DES"))
				{
					try{
						fname+="enc.mp3";
						// create new key
						key=" ";
						tf_key.setText(" ");
						SecretKey secretKey = KeyGenerator.getInstance("DESede").generateKey();
						// get base64 encoded version of the key
					
						key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
						tf_key.setText(key);
						new TripleDesAudioEnc(tf_file.getText(),fname,secretKey,paramSpec1);
						JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Encryption not possible");
					}
				}
				
			}
			new Compress(fname);
			
		}
		else if(ae.getActionCommand().equals("Decrypt"))
		{
			
			if(tf_file.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Enter the file to be decrypted");
				return;
			}
			String talgo=(String)cb_algo.getSelectedItem();
			if(talgo.equals("-----Select Algo------"))
			{
				JOptionPane.showMessageDialog(null, "Enter the algorithm name");
				return;
			}
			if(tf_key.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Enter the key");
				return;
			}
			String key=tf_key.getText();
			String fname=JOptionPane.showInputDialog("Enter the file name for decrypted file: ");
			if(type.equals("text"))
			{
			fname=fname+".decrypted";
			if(talgo.equals("AES"))
			{
				
				try{
					new CryptoUtil(key,tf_file.getText(),fname,"d");
					JOptionPane.showMessageDialog(null, "File decrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Decryption not possible");
				}
			}
			if(talgo.equals("DES"))
			{
				try{
					new DES(key,tf_file.getText(),fname,"d");
					JOptionPane.showMessageDialog(null, "File decrypted successfully");
				}
				catch(Exception e){JOptionPane.showMessageDialog(null,"Decryption not possible");}
			}
			if(talgo.equals("Triple DES"))
			{
				try{
					new TripleDES(key,tf_file.getText(),fname,"d");
					JOptionPane.showMessageDialog(null, "File decrypted successfully");
				}
				catch(Exception e){JOptionPane.showMessageDialog(null,"Decryption not possible");}
			}
			else if(talgo.equals("Ceaser Cipher Text"))
			{
				new Ceaser_Decrypt(tf_file.getText(),fname,Integer.parseInt(key)).decrypt();
			}
			else if(talgo.equals("Substitution"))
			{
				new Substitution_Decrypt(tf_file.getText(),fname).decrypt();
			}
			}
			else if(type.equals("image"))
			{
				if(talgo.equals("Blowfish"))
				{
				try{
					fname+="dec.jpg";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "Blowfish");
					new BlowfishImgDec(tf_file.getText(),fname,originalKey);
					JOptionPane.showMessageDialog(null, "File decrypted successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Decryption not possible");
				}
				}
				else if(talgo.equals("AES"))
				{
					try{
						fname+="dec.jpg";
						
						// decode the base64 encoded string
						byte[] decodedKey = Base64.getDecoder().decode(key);
						// rebuild key using SecretKeySpec
						SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
						new AesImgDec(tf_file.getText(),fname,originalKey);
						JOptionPane.showMessageDialog(null, "File decrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Decryption not possible");
					}
				}
				else if(talgo.equals("DES"))
				{
					try{
						fname+="dec.jpg";
						
						// decode the base64 encoded string
						byte[] decodedKey = Base64.getDecoder().decode(key);
						// rebuild key using SecretKeySpec
						SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
						new DesImgDec(tf_file.getText(),fname,originalKey);
						JOptionPane.showMessageDialog(null, "File decrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Decryption not possible");
					}
				}
				else if(talgo.equals("Triple DES"))
				{
					try{
						fname+="dec.jpg";
						
						// decode the base64 encoded string
						byte[] decodedKey = Base64.getDecoder().decode(key);
						// rebuild key using SecretKeySpec
						SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DESede");
						new TripleDesImgDec(tf_file.getText(),fname,originalKey);
						JOptionPane.showMessageDialog(null, "File decrypted successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Decryption not possible");
					}
				}
			}
			else if(type.equals("video"))
			{
				if(talgo.equals("AES"))
				{
				try{
				
				fname+="dec.avi";
				
				// decode the base64 encoded string
				byte[] decodedKey = Base64.getDecoder().decode(key);
				// rebuild key using SecretKeySpec
				SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			
				new AesVideoDec(tf_file.getText(),fname,originalKey,paramSpec);
				JOptionPane.showMessageDialog(null,"Decrypt Successfully");
				}
				catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");
				}
				}
				else if(talgo.equals("Blowfish"))
				{
					try{
					System.out.println(tf_file.getText());
					fname+="dec.avi";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "Blowfish");
				
					new BlowfishVideoDec(tf_file.getText(),fname,originalKey,paramSpec1);
					JOptionPane.showMessageDialog(null,"Decrypt Successfully");
					}
					catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");}
				}
				else if(talgo.equals("DES"))
				{
					try{
					System.out.println(tf_file.getText());
					fname+="dec.avi";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
				
					new DesVideoDec(tf_file.getText(),fname,originalKey,paramSpec1);
					JOptionPane.showMessageDialog(null,"Decrypt Successfully");
					}
					catch(Exception e){JOptionPane.showMessageDialog(null,"Decryption not possible");}
				}
				else if(talgo.equals("Triple DES"))
				{
					try{
					System.out.println(tf_file.getText());
					fname+="dec.avi";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DESede");
				
					new TripleDesVideoDec(tf_file.getText(),fname,originalKey,paramSpec1);
					JOptionPane.showMessageDialog(null,"Decrypt Successfully");
					}
					catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");}
				}
			}
			else if(type.equals("audio"))
			{
				if(talgo.equals("AES"))
				{
				try{
					System.out.println(tf_file.getText());
				fname+="dec.mp3";
				
				// decode the base64 encoded string
				byte[] decodedKey = Base64.getDecoder().decode(key);
				// rebuild key using SecretKeySpec
				SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			
				new AesAudioDec(tf_file.getText(),fname,originalKey,paramSpec);
				JOptionPane.showMessageDialog(null,"Decrypt Successfully");
				}
				catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");
				}
				}
				else if(talgo.equals("Blowfish"))
				{
					try{
						
					fname+="dec.mp3";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "Blowfish");
				
					new BlowfishAudioDec(tf_file.getText(),fname,originalKey,paramSpec1);
					JOptionPane.showMessageDialog(null,"Decrypt Successfully");
					}
					catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");
					}
				}
				else if(talgo.equals("DES"))
				{
					try{
						
					fname+="dec.mp3";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
				
					new DesAudioDec(tf_file.getText(),fname,originalKey,paramSpec1);
					JOptionPane.showMessageDialog(null,"Decrypt Successfully");
					}
					catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");
					}
				}
				else if(talgo.equals("Triple DES"))
				{
					try{
						
					fname+="dec.mp3";
					
					// decode the base64 encoded string
					byte[] decodedKey = Base64.getDecoder().decode(key);
					// rebuild key using SecretKeySpec
					SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DESede");
				
					new TripleDesAudioDec(tf_file.getText(),fname,originalKey,paramSpec1);
					JOptionPane.showMessageDialog(null,"Decrypt Successfully");
					}
					catch(Exception e){ JOptionPane.showMessageDialog(null,"Decryption not possible");
					}
				}
			}
		}
		else if(b_clear.getActionCommand()=="Clear")
		{
			tf_file.setText("");
			tf_key.setText("");
			cb_algo.setSelectedIndex(0);
		}
		
	}
	public void mouseReleased(MouseEvent me)
	{
		//System.out.println(me.);
		if(me.getSource()==browse)
		{
			
			JFrame.setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    JFrame frame = new JFrame("JComboBox Test");
		    frame.setLayout(new FlowLayout());
		    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //To close the inner window without closing the outer window
		    frame.setSize(200,200);
		    frame.setBounds(60,60,200,200);
		    JButton button = new JButton("Select File");
		    button.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		        JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
			          File selectedFile = fileChooser.getSelectedFile();
			          
			          System.out.println("\""+selectedFile.getName()+"\"");
		        }
		     }
		   });
		    frame.add(button);
		    frame.pack();
		    frame.setVisible(true);
		    
		}
	}
	public void mouseClicked(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{}
	public void mousePressed(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public static void main(String args[]) throws Exception
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		 
		
		new Encryption_Decryption();
	}
}