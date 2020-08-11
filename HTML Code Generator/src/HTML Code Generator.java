import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.*;
import javax.swing.filechooser.*;

import java.io.File;

class App_Image extends JWindow
{
    public App_Image(String filename, Frame f)
    {
        System.out.println("Helo");
        JLabel l = new JLabel(new ImageIcon(filename));
        
        f.add(l);
        pack();
        setLocation(1300,700);
        
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

public class CG1 extends JFrame implements MouseListener{
	
	static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JRadioButton rb;
    JCheckBox cb;
    JFileChooser fc;
    JPanel p1;
	JMenuBar mb;
	ButtonGroup group=new ButtonGroup();
	String method,image_name="";
	//JComboBox heading=new JComboBox(heading_string);
	int def_form_ans;
	final MobileContainerPanel mcp = new MobileContainerPanel();
	JTextField t1,t2,t3;
	JMenu m1,m2,m3,form,heading_item;
	JButton b1,convert;
	JPanel jp1,jp2;
	JMenuItem radio_button,checkbox,image,new_file,save,def_form,field_name,button,textbox,h1,h2,h3,h4,h5,h6;
	JTabbedPane jtb;
	JLabel fn; 
	String []s=new String[]{"GET","POST"};
	JComboBox type1=new JComboBox(s);
	String []s1=new String[]{"Button","Submit","Reset"};
	JComboBox type2=new JComboBox(s1);
	JTextField action=new JTextField(30);
	String name;
	JTextField bn=new JTextField(30);
	Object[] b_details={"Enter the name: ",bn,"Enter your Choice: ",type2};
	Object[] form_details={"Action: ",action,"Type: ",type1};
	//JTextField heading_field=new JTextField(30);
	//Object[] heading={"Enter the heading: ",heading_field};
	
	CG1()
	{
		//setLayout(null);
		
		
		new App_Image("C:\\Users\\Public\\Pictures\\Sample Pictures\\encryption.jpg",this);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		//jtb=new JTabbedPane();
		//jp1=new JPanel();
		//jp1.setBounds(10,30,900,600);
		//jp1.add(mcp);
		
		//jp1.setBackground(Color.white);
		//jtb.addTab("Untitled",jp1);
		//jtb.setBounds(10,30,900,600);
		
		//add(jtb);
		//jtb.setBackground(new Color(255,255,255));
		
		mb=new JMenuBar();
		mb.setBounds(0,0,1300,20);
		add(mb);
		
		
		m1=new JMenu("File");
		m2=new JMenu("Insert");
		m3=new JMenu("Exit");
		
		
		new_file=new JMenuItem("New");
		save=new JMenuItem("Save");
		form=new JMenu("Form");
		
		m1.add(new_file);
		m1.add(save);
		
		m2.add(form);

		def_form=new JMenuItem("Define form");
		form.add(def_form);
		form.addSeparator();
		field_name=new JMenuItem("Field Name");
		form.add(field_name);
		textbox=new JMenuItem("Text Box");
		form.add(textbox);
		button=new JMenuItem("Button");
		form.add(button);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		
		heading_item=new JMenu("Heading");
		m2.add(heading_item);
		
		radio_button=new JMenuItem("Radio Button");
		m2.add(radio_button);
		
		checkbox=new JMenuItem("Check Box");
		m2.add(checkbox);
		
		h1=new JMenuItem("h1");
		h2=new JMenuItem("h2");
		h3=new JMenuItem("h3");
		h4=new JMenuItem("h4");
		h5=new JMenuItem("h5");
		h6=new JMenuItem("h6");
		heading_item.add(h1);
		heading_item.add(h2);
		heading_item.add(h3);
		heading_item.add(h4);
		heading_item.add(h5);
		heading_item.add(h6);
		
		h1.addMouseListener(this);
		h2.addMouseListener(this);
		h3.addMouseListener(this);
		h4.addMouseListener(this);
		h5.addMouseListener(this);
		h6.addMouseListener(this);
		
		image=new JMenuItem("Image");
		m2.add(image);
		save.addMouseListener(this);
		image.addMouseListener(this);
		
		
		field_name.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent me)
			{
				String fn1=JOptionPane.showInputDialog(null,"Enter the field name: ");
				fn=new JLabel(fn1);
				
				fn.setBounds(100,90,300,30);
				
				//jp1.
				add(fn);
			
				mcp.addNext(fn);
				//System.out.println("Font: "+fn.getFont().getSize());
			}
			
		});
		m3.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent me)
					{
						System.exit(0);
						
					}
			
				});
		
		
		
		textbox.addMouseListener(this);
		button.addMouseListener(this);
		
		convert=new JButton("Display Html Code");
		convert.setBounds(200,570,200,30);
		
		
		
		//add(mb);
		
		jp1=new JPanel();
		jp1.setLayout(null);
		//jp1.setBounds(690,20,300, 650);
		//add(jp1);
		
		
		jp1.add(convert);
		JScrollPane scrollPane = new JScrollPane(jp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(730, 10, 560, 652);
		getContentPane().add(scrollPane);
		convert.addMouseListener(this);
		def_form.addMouseListener(this);
		radio_button.addMouseListener(this);
		checkbox.addMouseListener(this);
		
		getContentPane().add(mcp);
		setSize(1300,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
	
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource()==h1||me.getSource()==h1||me.getSource()==h2||me.getSource()==h3||me.getSource()==h4||me.getSource()==h5||me.getSource()==h6)
		{
			String heading=JOptionPane.showInputDialog("Enter the heading");
			//System.out.println(heading);
			if(me.getSource()==h1)
			{
				fn=new JLabel(heading);
				Font f=new Font("",0,60);
				fn.setFont(f);
				fn.setBounds(100,90,300,30);
				add(fn);
				mcp.addNext(fn);
				
			}
			
			if(me.getSource()==h2)
			{
				fn=new JLabel(heading);
				Font f=new Font("",0,50);
				fn.setFont(f);
				fn.setBounds(100,90,300,30);
				add(fn);
				mcp.addNext(fn);
			}
			
			if(me.getSource()==h3)
			{
				fn=new JLabel(heading);
				Font f=new Font("",0,40);
				fn.setFont(f);
				fn.setBounds(100,90,300,30);
				add(fn);
				mcp.addNext(fn);
			}
			if(me.getSource()==h4)
			{
				fn=new JLabel(heading);
				Font f=new Font("",0,30);
				fn.setFont(f);
				fn.setBounds(100,90,300,30);
				add(fn);
				mcp.addNext(fn);
			}
			if(me.getSource()==h5)
			{
				fn=new JLabel(heading);
				Font f=new Font("",0,20);
				fn.setFont(f);
				fn.setBounds(100,90,300,30);
				add(fn);
				mcp.addNext(fn);
			}
			if(me.getSource()==h6)
			{
				fn=new JLabel(heading);
				Font f=new Font("",0,10);
				fn.setFont(f);
				fn.setBounds(100,90,300,30);
				add(fn);
				mcp.addNext(fn);
			}
		}
		else if(me.getSource()==radio_button)
		{
			rb=new JRadioButton();
			String ans=JOptionPane.showInputDialog("Enter the radio button name");
			rb.setName(ans);
			rb.setText(ans);
			group.add(rb);
			add(rb);
			mcp.addNext(rb);
		} 
		else if(me.getSource()==checkbox)
		{
			cb=new JCheckBox();
			String ans=JOptionPane.showInputDialog("Enter the checkbox name");
			cb.setText(ans);
			cb.setName(ans);
			add(cb);
			mcp.addNext(cb);
		}
		else if(me.getSource()==image)
		{
			

			//class JFileChooserTest {
			  //public static void main(String[] args) {
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
			          image_name=selectedFile.getPath();
			          System.out.println(image_name);
			          System.out.println("\""+selectedFile.getName()+"\"");
			          //setContentPane(new JLabel(new ImageIcon(image_name)));
			          /*JPanel p=new JPanel(){
			              public void paint(Graphics g)
			              {
			                                 try
			                                 {
			                                         Image img=ImageIO.read(new File(image_name));
			                                         
			                                         g.drawImage(img,0,0,1024,1024,null);
			                                 }
			                                 catch(Exception e)
			                                 {
			                                         JOptionPane.showMessageDialog(null,"Unable to read image");
			                                 }
			              }
			                              };

			                 p.setSize(2000,2000);
			                 p.setLocation(0,0);
			                 //add(p);
			                 //mcp.addNext(p);
			                 getContentPane().add(p);  p.add(mcp);
			                 //add(mcp);
			                 //mcp.addNext(p);
			                 //String ans1=String.valueOf(p.getClass());
			 				//if(ans1.equals("class javax.swing.JaAnel"))
			 				//{
			 					//System.out.println(p.get);
			 					
			 				//}*/
			          		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource("\""+selectedFile.getPath()+"\"")));
			          		background.setBounds(0, 0, 700, 700);
			          		add(background);
			          		mcp.addNext(background);
			        }
			     }
			    });
			    
			    frame.add(button);
			    frame.pack();
			    frame.setVisible(true);
			
			
			
		}
		else if(me.getSource()==save)
		{
		String str="<html>\n"
				+ "	<body>\n"
				+ "<h1>Hello</h1>\n"
				+ "</body>\n"
				+ "</html>";
		try{
				String fname=JOptionPane.showInputDialog("Enter the File name: ");
				File f=new File("D:\\"+fname);
				if(!f.exists())
					f.createNewFile();
				int selectedIndex = jtb.getSelectedIndex();
				jtb.setTitleAt(selectedIndex, fname);
				BufferedWriter bw=new BufferedWriter(new FileWriter(f));
				bw.write(str);
				bw.close();
				JOptionPane.showMessageDialog(null,"Successfully Created");
		}
		catch(Exception e)
		{
		
			System.out.println(e);
		}
		}
		else if(me.getSource()==def_form)
		{
			
			JOptionPane.showConfirmDialog(null,form_details,"Form Details",JOptionPane.OK_CANCEL_OPTION);
			def_form_ans=1;
			method=(String)type1.getSelectedItem();
		}
		else if(me.getSource()==button)
		{
			int ans=JOptionPane.showConfirmDialog(null,b_details,"",JOptionPane.OK_CANCEL_OPTION);
			
			String str=(String)type2.getSelectedItem();
			if(str.equals("Button"))
			{
				b1=new JButton("Button");
			}
			else if(str.equals("Submit"))
				b1=new JButton("Submit");
			b1.setName(bn.getText());
			add(b1);
			b1.setBounds(200,200,100,30);
			mcp.addNext(b1);
		}
			
	}
	
	public void mouseClicked(MouseEvent me)
	{
	
	}
	public void mouseExited(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mousePressed(MouseEvent me){
		
		
		if(me.getSource()==textbox)
		{
			
			String str=JOptionPane.showInputDialog(null,"Enter the name for the text box: ");
			t1=new JTextField(30);
			t1.setName(str);
			t1.setBounds(100,90,200,30);

			add(t1);
			mcp.addNext(t1);
			
		}
		else if(me.getSource()==convert)
		{
			try{
			
			jp1.removeAll();
			convert=new JButton("Display Html Code"); //We need to add it again as all the components are removed from the jpanel
			convert.setBounds(200,570,200,30);
			jp1.add(convert);
			convert.addMouseListener(this);
			
			File f=new File("D:\\Hope.html");
			
			if(!f.exists())
				f.createNewFile();	
	
		int j=0,y=20;

		Component[] comp=getContentPane().getComponents();
		int locationx[]=new int[comp.length];
		int locationy[]=new int[comp.length];
		for(int i=0;i<comp.length;i++)  //Initializing the locationx and locationy array
		{
			locationx[i]=-1;
			locationy[i]=-1;
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
		bw.write("<html>\n"+"<body><br>\n");
		
		String lstr="<html>\n"+"<body><br>";
		JLabel l3=new JLabel("\t<html\t>\n<body\t>");
		
		l3.setBounds(20, y, 700, 20);
		jp1.add(l3);
		jp1.revalidate();
		jp1.repaint();
		y+=20;
		if(def_form_ans!=0)
		{

			JLabel l6=new JLabel("\t<form method="+method+" action="+action.getText()+"\t>\n");
			l6.setBounds(20,y,700,20);
			bw.write("\n<form method="+method+" action="+action.getText()+"><br>");
			jp1.add(l6);
		}
		y+=20;
		for(int i=0;i<comp.length;i++)
		{

			String ans1=String.valueOf(comp[i].getClass());
			if(ans1.equals("class javax.swing.JTextField")||ans1.equals("class javax.swing.JCheckBox")||ans1.equals("class javax.swing.JLabel")||ans1.equals("class javax.swing.JButton")||ans1.equals("class javax.swing.JRadioButton"))
			{locationx[i]=comp[i].getX();
			locationy[i]=comp[i].getY();
			
			if(ans1.equals("class javax.swing.JLabel"))
			{
				JLabel l1=(JLabel)comp[i];
				//System.out.println("*******Label value: "+l1.getText());
				
			}
			//System.out.println("Type: "+comp[i].getClass()+"X: "+locationx[i]+" Y: "+locationy[i]);

			
			}
			
		}
		Component temp;
		int temp1,temp2;
		for(int i=comp.length-1;i>0;i--)
		{
			for(j=0;j<i;j++)
			{
				if(locationy[j]!=-1)
				{
					if(locationy[j]>locationy[j+1])
					{
						if((locationy[j]-locationy[j+1])>6)
						{
						temp1=locationx[j];
						locationx[j]=locationx[j+1];
						locationx[j+1]=temp1;
						
						temp2=locationy[j];
						locationy[j]=locationy[j+1];
						locationy[j+1]=temp2;
						
						temp=comp[j];
						comp[j]=comp[j+1];
						comp[j+1]=temp;
						}
						
					}
					else if(locationy[j]==locationy[j+1])
					{
						if(locationx[j]>locationx[j+1])
						{
							
							temp1=locationx[j];
							locationx[j]=locationx[j+1];
							locationx[j+1]=temp1;
							
							temp2=locationy[j];
							locationy[j]=locationy[j+1];
							locationy[j+1]=temp2;
							
							temp=comp[j];
							comp[j]=comp[j+1];
							comp[j+1]=temp;
						}
					}
				}
			}
		}
		for(int i=0;i<comp.length;i++)
			System.out.println(comp[i].getClass()+"\t"+comp[i].getY());
		int newline=999; //represents y coordinate
		int newlinex=-1; //represents x coordinate
		//String type_class=" ";
		for(int i=0;i<comp.length;i++)
		{
			String ans1=String.valueOf(comp[i].getClass());
			//if(ans1.equals("class javax.swing.JTextField")||ans1.equals("class javax.swing.JCheckBox")||ans1.equals("class javax.swing.JLabel")||ans1.equals("class javax.swing.JButton")||ans1.equals("class javax.swing.JRadioButton"))
			{
			
			/*if(newline!=-1)
			{
				for(j=0;j<(comp[i].getY()-newline);j++)
				{
					bw.write("<br>");
				}
			}*/
			if(((newline==(comp[i].getY()))||(newline>(comp[i].getY()+1))||(newline>(comp[i].getY()+2))||(newline>(comp[i].getY()+3))||((newline+1)>=comp[i].getY())||((newline+2)>=comp[i].getY())||((newline+3)>=comp[i].getY()))&&(newlinex<comp[i].getX()))
				
				{
					//bw.write("<br>");
				    
					
				}
				else
					bw.write("<br>");
				
			/*if(!type_class.equals(" ")) //For generating blank lines
			{
				if(((newline==(comp[i].getY()))||(newline>(comp[i].getY()+1))||(newline>(comp[i].getY()+2))||(newline>(comp[i].getY()+3))||((newline+1)>=comp[i].getY())||((newline+2)>=comp[i].getY())||((newline+3)>=comp[i].getY()))&&(newlinex<comp[i].getX()))
				{	
					if(type_class.equals("class javax.swing.JTextField")||type_class.equals("class javax.swing.JCheckBox")||type_class.equals("class javax.swing.JLabel")||type_class.equals("class javax.swing.JButton")||type_class.equals("class javax.swing.JRadioButton"))
					{
						for(i=1;i<=(comp[i].getY()-newline);i++)
							bw.write("<br>");
					}
				}
			}*/
			if(ans1.equals("class javax.swing.JLabel"))
			{
				JLabel l1=(JLabel)comp[i];
				JLabel l4=new JLabel("");
				if(l1.getFont().getSize()==60)
				{
					bw.write("<h1>"+l1.getText()+"</h1>\n");
					l4=new JLabel("\t<h1\t>"+l1.getText()+"\t</h1\t>");
					
				}
				else if(l1.getFont().getSize()==50)
				{
					bw.write("<h2>"+l1.getText()+"</h2>\n");
					l4=new JLabel("\t<h2\t>"+l1.getText()+"\t</h2\t>");
					
				}
				else if(l1.getFont().getSize()==40)
				{
					bw.write("<h3>"+l1.getText()+"</h3>\n");
					l4=new JLabel("\t<h3\t>"+l1.getText()+"\t</h3\t>");
					
				}
				else if(l1.getFont().getSize()==30)
				{
					bw.write("<h4>"+l1.getText()+"</h4>\n");
					l4=new JLabel("\t<h4\t>"+l1.getText()+"\t</h4\t>");
					
				}
				else if(l1.getFont().getSize()==20)
				{
					bw.write("<h5>"+l1.getText()+"</h5>\n");
					l4=new JLabel("\t<h5\t>"+l1.getText()+"\t</h5\t>");
					
				}
				else if(l1.getFont().getSize()==10)
				{
					bw.write("<h6>"+l1.getText()+"</h6>\n");
					l4=new JLabel("\t<h6\t>"+l1.getText()+"\t</h6\t>");
					
				}
				else
				{
				bw.write(l1.getText()+"\n");
				
				l4=new JLabel(l1.getText()+"\n");
				
				}
				l4.setBounds(20,y,700,20);
				y+=20;
				
				jp1.add(l4);
			}
			else if(ans1.equals("class javax.swing.JTextField"))
			{
				JTextField t1=(JTextField)comp[i];
				
				bw.write("<input type=text name="+t1.getName()+">\n");
				JLabel l2=new JLabel("\t<input type=text name="+t1.getName()+"\t>\t<br\t>\n");
				l2.setBounds(20,y,700,20);
				y+=20;
				jp1.add(l2);
				
			}
			else if(ans1.equals("class javax.swing.JButton"))
			{
				
				JButton b2=(JButton)comp[i];
				String btype=b2.getText();
				String bname=b2.getName();
				bw.write("<input type="+btype+" value="+bname+">");
				JLabel l2=new JLabel("\t<input type="+btype+" value="+bname+"\t>"); 
				l2.setBounds(20,y,700,20);
				y+=20;
				jp1.add(l2);
			}
			else if(ans1.equals("class javax.swing.JRadioButton"))
			{
				JRadioButton rb1=(JRadioButton)comp[i];
				String ans=rb1.getName();
				JLabel l9=new JLabel("");
				if(rb1.isSelected())
				{
					bw.write("<input type=radio name=r1 value="+ans+"checked=\"checked\">"+ans);
					l9=new JLabel("\t<input type=radio name=r1 checked=checked value="+ans+"\t>"+ans); 
				}
				else
				{
					bw.write("<input type=radio name=r1 value="+ans+">"+ans);
					l9=new JLabel("\t<input type=radio name=r1 value="+ans+"\t>"+ans+"\t<br\t>"); 
				}
				l9.setBounds(20,y,800,20);
				y+=20;
				jp1.add(l9);
			}
			else if(ans1.equals("class javax.swing.JCheckBox"))
			{
				JCheckBox cb1=(JCheckBox)comp[i];
				String ans=cb1.getName();
				JLabel l9=new JLabel("");
				if(cb1.isSelected())
				{
					bw.write("<input type=checkbox name="+ans+" value="+ans+"checked=\"checked\">"+ans);
					l9=new JLabel("\t<input type=checkbox name="+ans+" checked=checked value="+ans+"\t>"+ans); 
				}
				else
				{
					bw.write("<input type=checkbox name="+ans+" value="+ans+">"+ans);
					l9=new JLabel("\t<input type=checkbox name="+ans+" value="+ans+"\t>"+ans+"\t<br\t>"); 
				}
				l9.setBounds(20,y,800,20);
				y+=20;
				jp1.add(l9);
			}
			//System.out.println(newline+"\t"+comp[i].getY()+"\t"+comp[i].getClass()+"\t"+(newline>(comp[i].getY()+2))+"\t"+(newline<comp[i].getY()));
			//type_class=String.valueOf(comp[i].getClass());
			newlinex=comp[i].getX();
			newline=comp[i].getY();
			}
		}
		if(def_form_ans!=0)
		{
			bw.write("</form>");
			JLabel l5=new JLabel("\t</form\t>");
			l5.setBounds(20,y,700,20);
			y+=20;
			jp1.add(l5);
		}
		bw.write("</body><br>\n</html>"); bw.close();
		l3=new JLabel("\t</body\t>\t<br\t>\n</html\t>");
		l3.setBounds(20, y, 700, 20);
		jp1.add(l3);
		
		jp1.updateUI();
	}
	
	catch(Exception e)
	{
		System.out.println(e);
		
	}
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		/*try {
		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}*/
		new CG1();
	}

}



   
  
/**
 * container with null layout to which you can add components and
 * move them around with the mouse. components can be re-ordered 
 * in a new layout with renewLayout method.
 */
class MobileContainerPanel extends JPanel
{
    List componentList;
    ComponentWrangler wrangler;
    final int PAD = 10;
  
    public MobileContainerPanel()
    {
        componentList = new ArrayList();
        wrangler = new ComponentWrangler();
        setLayout(null);
    }
  
    public void addNext(Component c)
    {
        componentList.add(c);
        String ans1=String.valueOf(c.getClass());
		if(ans1.equals("class javax.swing.JPanel"))
		{
			c.setBounds(0,0,700,700);
		}
		else
        {
        c.addMouseListener(wrangler);
        c.addMouseMotionListener(wrangler);
     
        Dimension d = c.getPreferredSize();
        Point p = getNextLocation(d);
        c.setBounds(p.x, p.y, d.width, d.height);
        }
        repaint();
    }
  
    private Point getNextLocation(Dimension d)
    {
        int maxX = 0, maxY = 0;
        Component c, last = null;
        Rectangle r;
        // find level of lowest component(s)
        for(int j = 0; j < componentList.size(); j++)
        {
            c = (Component)componentList.get(j);
            r = c.getBounds();
            if(r.y + r.height > maxY)
            {
                maxY = r.y + r.height;
                last = c;
            }
        }
        // find last (in row) of lowest components
        for(int j = 0; j < componentList.size(); j++)
        {
            c = (Component)componentList.get(j);
            r = c.getBounds();
            if(r.y + r.height == maxY && r.x + r.width > maxX)
            {
                maxX = r.x + r.width;
                last = c;
            }
        }
        // determine location of next component based on location of last
        Point p = new Point();
        if(last == null)                                // first component
        {
            p.x = PAD;
            p.y = PAD;
            return p;
        }
        r = last.getBounds();
        int x, y;
        if(r.x + r.width + PAD + d.width < getWidth())  // next in row
        {
            p.x = r.x + r.width + PAD;
            p.y = r.y;
        }
        else                                            // skip to new row
        {
            p.x = PAD;
            p.y = r.y + r.height + PAD;
        } 
        return p;
    }
   
    public void renewLayout()
    {
        removeAll();
        Component c;
        Dimension d;
        // set location of all components to offscreen positions
        for(int j = 0; j < componentList.size(); j++)
        {
            c = (Component)componentList.get(j);
            d = c.getSize();
            c.setBounds(-d.width, -d.height, d.width, d.height);
        }
        Point p;
        // add components and reset their location
        for(int j = 0; j < componentList.size(); j++)
        {
            c = (Component)componentList.get(j);
            add(c);
            d = c.getSize();
            p = getNextLocation(d);
            c.setBounds(p.x, p.y, d.width, d.height);
        }
        repaint();
    }
  
    public void clear()
    {
        removeAll();
        componentList.clear();
        repaint();
    }
  
    /**
     * select and drag components with the mouse
     */
    private class ComponentWrangler extends MouseInputAdapter
    {
        Component selectedComponent;
        Point offset;
        boolean dragging;
  
        public ComponentWrangler()
        {
            dragging = false;
        }
  
        public void mousePressed(MouseEvent e)
        {
            selectedComponent = (Component)e.getSource();
            
            offset = e.getPoint();
            dragging = true;
        }
  
        public void mouseReleased(MouseEvent e)
        {
            dragging = false;
        }
  
        public void mouseDragged(MouseEvent e)
        {
            if(dragging)
            {
                Rectangle r = selectedComponent.getBounds();
                r.x += e.getX() - offset.x;
                r.y += e.getY() - offset.y;
                selectedComponent.setBounds(r);  
            }
        }
    }
}


