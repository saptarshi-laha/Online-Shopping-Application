
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import res.getImage;


public class Main {
	
	private JFrame frame;
	private JButton b1, b2, b3;
	public static JTextField tf1;
	private JLabel lb2, lb4, lb5, lb6, lb7, lb9;
	private JList<String> jl1, jl2;
	private Connect c;
	public static JLabel lb8, lb1, lb3, lb23;
	public static Thread t1, t2;
	public static boolean running, searching;
	public static String searchString;
	public static int foundString = -1;
	public static String LoginID = null;
	
	private JFrame frame1;
	private JButton b4, b5, b6;
	private JTextField tf2;
	private JPasswordField pf1;
	private JLabel lb10, lb11;
	private JPanel p1;
	
	private JFrame frame2;
	private JButton b7;
	private JTextField tf3;
	private JPasswordField pf2, pf3;
	private JLabel lb12, lb13, lb14, lb15;
	private JPanel p2, p3;
	private UtilDateModel model1;
	private JDatePanelImpl dp1;
	private JDatePickerImpl dpi1;
	
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	
	private JFrame frame3;
	private JButton b8;
	private JTextField tf4;
	private JLabel lb16, lb17, lb18;
	private JPanel p4, p5;
	private UtilDateModel model2;
	private JDatePanelImpl dp2;
	private JDatePickerImpl dpi2;
	
	private DefaultListModel<String> listModel1;
	private DefaultListModel<String> listModel2;
		
	public static JButton b9;
	public static JLabel lb19, lb20, lb21, lb22;
	
	private JFrame frame4;
	private JButton b10, b11;
	private JList<String> jl3, jl4, jl5;
	private JScrollPane jsp3, jsp4, jsp5;
	private JLabel lb24, lb25, lb26, lb27; 
	private DefaultListModel<String> listModel3 = new DefaultListModel<String>();
	private DefaultListModel<String> listModel4 = new DefaultListModel<String>();
	private DefaultListModel<String> listModel5 = new DefaultListModel<String>();
	private ArrayList<Integer> al4 = new ArrayList<Integer>();
	public int finalPrice = -1;
		
	private ArrayList<String> al1 = new ArrayList<String>();
	private ArrayList<Integer> al2 = new ArrayList<Integer>();
	private ArrayList<Integer> al3 = new ArrayList<Integer>();
	
	private JFrame frame5;
	private JButton b12, b13;
	private JLabel lb28, lb29, lb30, lb31, lb32, lb33, lb34;
	private JComboBox<String> jcb1;
	private JFormattedTextField ftf1, ftf2, ftf3, ftf4, ftf5, ftf6, ftf7; 
		
	public class Run_Thread1 implements Runnable{

		
		public void run() {
			
			try{
				
				while(running){
				c.runFeatured();
				Thread.sleep(5000);
				}
				
			}
			catch(Exception e){
				
				JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
			    JOptionPane.showMessageDialog(null, "Please Restart The Application", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
			    System.exit(0);
				
			}
			
		}
		
		
		
	}
	
	public class Run_Thread2 implements Runnable{
		
			
		public void initiateSearch(String s1){
			
			Main.searchString = "";
			Main.searchString = s1;
						
		}
		
		public void run() {
			
			try{
				
				while(searching){
					
				if(Main.searchString.trim().equals("") == false){
					Main.foundString = c.runSearch(Main.searchString);
		
					
					if (Main.foundString >= 1){
						
						int temp = Main.foundString - 1;
						Connect.searchCurrent = Connect.al18.get(temp);
						
						Main.lb19.setText("Category : " + Connect.al17.get(temp));
						Main.lb20.setText("Item Name : " + Connect.al15.get(temp));
						Main.lb21.setText("Price : " + Connect.al16.get(temp));
						
						Image i = getImage.getImageFromRes(Main.lb8.getWidth(), Main.lb8.getHeight(),Connect.al18.get(temp).toString()+".jpg");
						
						Main.lb22.setIcon(new ImageIcon(i));
						
						
					}
					else if(Main.foundString == -1)
					{
						
						JOptionPane.showMessageDialog(null, "Item Not Found!", "Item Entry Not Present", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else if(Main.foundString == 0){
						
						JOptionPane.showMessageDialog(null, "Category Or Item Name Missing. Please Input Search String In The Format Category + (Explicit + Sign) + Item Name. Eg. Tops (Women) + Gray ", "Item Entry Not Present", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					searching = false;
				}
			}
				
				
			}
			catch(Exception e){
				
				JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
			    JOptionPane.showMessageDialog(null, "Please Restart The Application", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
			    System.exit(0);
				
			}
			
		}
		
		
		
	}
	
	public class Listen_Action implements ActionListener{
		@SuppressWarnings("unlikely-arg-type")
		public void actionPerformed(ActionEvent e){
			
			if (e.getActionCommand().equals("SRF")){
				
				frame1.setVisible(false);
				showRegisterForm();
				
			}
			
			else if(e.getActionCommand().equals("SFPF")){
				
				frame1.setVisible(false);
				showForgotPassForm();
				
			}
			
			else if(e.getActionCommand().equals("Login")){
				
				if (tf2.getText().equals("") == false && pf1.getPassword().equals("") == false){
				
				String s = new String(pf1.getPassword());
				boolean b = c.checkEntry(tf2.getText(), s);
				if (b){
					
					Main.LoginID = tf2.getText();
					frame1.setVisible(false);
					showShoppingForm();
					
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Wrong Username Or Password Entered", "Authentication Error!", JOptionPane.INFORMATION_MESSAGE);
					
				}
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Data Missing, Please Fill In The Login Form", "Authentication Error!", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
			else if(e.getActionCommand().equals("Register")){
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date selectedDate = ((Date) dpi1.getModel().getValue());
				String s = null;
				try{
				s = dateFormat.format(selectedDate);
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Date Not Valid Or Date Area Is Not Filled", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				Date dummyDate = new Date();
				String dummyDateStr = dateFormat.format(dummyDate);
				
				if(selectedDate.compareTo(dummyDate)>0){
					JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is In The Future!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
					return;
	        	}else if(s.compareTo(dummyDateStr)==0){
	        		JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is Today!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
					return;
	        	}
				
				String s1 = new String(pf2.getPassword());
				String s2 = new String(pf3.getPassword());
				if(tf3.getText().isEmpty() == false && s1.equals(s2) && selectedDate != null && s1.isEmpty() == false && !tf3.getText().contains(" ") && !s1.contains(" ")){
								
				int b = c.createEntry(tf3.getText(), s1, s);
				
				if(b == 0){
					
					JOptionPane.showMessageDialog(null, "User Information Successfully Added", "Registered!", JOptionPane.INFORMATION_MESSAGE);
					frame2.setVisible(false);
					frame1.setVisible(true);
					
				}
				else if(b == 1){
					
					JOptionPane.showMessageDialog(null, "The Username Has Already Been Taken! Please Try A Different Username", "Username In Use!", JOptionPane.INFORMATION_MESSAGE);
					
				}
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Fields Are Empty Or Passwords Do Not Match Or Spaces Are Present In Username Or Password Field, Please Refill Form With Correct Values", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			else if(e.getActionCommand().equals("Forgot Password")){
				
				lb18.setText("");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date selectedDate = ((Date) dpi2.getModel().getValue());
				String s1 = null;
				try{
				s1 = dateFormat.format(selectedDate);
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Date Not Valid Or Date Area Is Not Filled", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String s = c.retPass(tf4.getText(), s1);
				
				if (s != null){
					
					lb18.setText("Password : "+ s);
					
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "No Entry Found With Specified Values! Please Try Again", "Entry Absent!", JOptionPane.INFORMATION_MESSAGE);
					return;
					
				}
				
			}
			else if(e.getActionCommand().equals("Cart")){
				
				if(frame4.isVisible() == false){
				frame4.setVisible(true);
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Cart Window Is Already Open!", "Duplicate Form Creation", JOptionPane.INFORMATION_MESSAGE);
					return;
					
				}
				
			}
			else if(e.getActionCommand().equals("Thread_Add_Cart")){
				
				if (Connect.threadCurrent != -1){
				al4.add(Connect.threadCurrent);
				listModel3.addElement(lb23.getText().replace("Category : ", ""));
				listModel4.addElement(lb1.getText().replace("Item Name : ", ""));
				listModel5.addElement(lb3.getText().replace("Price : ", ""));
				jl3.setModel(listModel3);
				jl4.setModel(listModel4);
				jl5.setModel(listModel5);
				JOptionPane.showMessageDialog(null, "Item Successfully Added To Cart!", "Item Added", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Item Doesn't Exist On Screen Anymore! Please Use Search/List To Add", "Invalid Action", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
			}
			else if(e.getActionCommand().equals("Search_Add_Cart")){
				
				
				if (Connect.searchCurrent != -1){
					al4.add(Connect.searchCurrent);
					listModel3.addElement(lb19.getText().replace("Category : ", ""));
					listModel4.addElement(lb20.getText().replace("Item Name : ", ""));
					listModel5.addElement(lb21.getText().replace("Price : ", ""));
					jl3.setModel(listModel3);
					jl4.setModel(listModel4);
					jl5.setModel(listModel5);
					JOptionPane.showMessageDialog(null, "Item Successfully Added To Cart!", "Item Added", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						
						JOptionPane.showMessageDialog(null, "Item Doesn't Exist On Screen Anymore! Please Use Search/List To Add", "Invalid Action", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
				
			}
			else if(e.getActionCommand().equals("List_Add_Cart")){
	
				
				if (Connect.listCurrent != -1){
					al4.add(Connect.listCurrent);
					listModel3.addElement(jl1.getSelectedValue().toString().replace("Category : ", ""));
					listModel4.addElement(lb2.getText().replace("Item Name : ", ""));
					listModel5.addElement(lb4.getText().replace("Price : ", ""));
					jl3.setModel(listModel3);
					jl4.setModel(listModel4);
					jl5.setModel(listModel5);
					JOptionPane.showMessageDialog(null, "Item Successfully Added To Cart!", "Item Added", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						
						JOptionPane.showMessageDialog(null, "Item Doesn't Exist On Screen Anymore! Please Use Search/List To Add", "Invalid Action", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
			}
			
			else if(e.getActionCommand().equals("Remove_Cart")){
				
				if(jl4.getSelectedIndex() >=0){
					int temp = jl4.getSelectedIndex();
					listModel3.remove(temp);
					listModel4.remove(temp);
					listModel5.remove(temp);
					jl3.setModel(listModel3);
					jl4.setModel(listModel4);
					jl5.setModel(listModel5);
					al4.remove(temp);
					lb27.setIcon(new ImageIcon());
					}
				else{
					
					JOptionPane.showMessageDialog(null, "No Selected Value To Be Removed!", "Invalid Action", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
			else if(e.getActionCommand().equals("Proceed_Checkout")){
				
				finalPrice = -1;
				int total = 0;
				
				if(listModel5.getSize() > 0){
					
					
					
				for(int i = 0; i<listModel4.getSize(); i++){
					
					total = total + Integer.parseInt((String)listModel5.getElementAt(i));
										
				}
				finalPrice = total;
				frame.setVisible(false);
				frame4.setVisible(false);
				showPaymentGateway();
				
				}
				else{
					
					JOptionPane.showMessageDialog(null, "No Items Added To Cart, Cannot Proceed Through Gateway.", "Invalid Action", JOptionPane.ERROR_MESSAGE);
					
				}
				
				}
			else if(e.getActionCommand().equals("CONFIRM_PURCHASE")){
							
				if(ftf1.getText().length() == 5 && ftf2.getText().length() == 5 && ftf3.getText().length() == 5 && ftf4.getText().length() ==5 && ftf5.getText().length() == 2 && ftf6.getText().length() == 2 && ftf7.getText().length() == 3){
				Random r = new Random();
				int transID = r.nextInt(Integer.MAX_VALUE);
				
				c.addTotal(finalPrice);
				JOptionPane.showMessageDialog(null, "Payment Using Card Number : " + ftf1.getText().replace(",", "") + " " + ftf2.getText().replace(",", "") + " " + ftf3.getText().replace(",", "") + " " + ftf4.getText().replace(",", "") + "\nCard Type : " + (String)jcb1.getSelectedItem() + "\nExpiry Date : " + ftf5.getText() + " " + ftf6.getText() + "\nCVV Number : " + ftf7.getText() + "\nIs Successful.\nYour Transaction Number Is : " + transID + "\nSave The Transaction ID For Further Support.", "Payment Successful!", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Thank You For Using The Software!", "Greetings!", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);		
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Invalid Entry Of Card Details. Please Confirm And Re-Enter Values.", "Invalid Action", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else if(e.getActionCommand().equals("CANCEL_PURCHASE")){
				
				JOptionPane.showMessageDialog(null, "Thank You For Using The Software!", "Greetings!", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
				
			
			
		}
	}
	
	public void showPaymentGateway(){
		
		NumberFormat f1 = NumberFormat.getNumberInstance(); 
		f1.setMaximumIntegerDigits(4);
		
		NumberFormat f2 = NumberFormat.getNumberInstance(); 
		f2.setMaximumIntegerDigits(2);
		
		NumberFormat f3 = NumberFormat.getNumberInstance(); 
		f3.setMaximumIntegerDigits(3);
		
		Listen_Action la = new Listen_Action();
		
		this.frame5 = new JFrame();
		this.frame5.setTitle("Online Shopping | Payment Gateway");
		this.frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame5.setLayout(null);
		
		this.b12 = new JButton("Confirm Purchase");
		this.b13 = new JButton("Cancel Purchase");
		
		this.lb28 = new JLabel("Total Amount : INR " + finalPrice);
		this.lb29 = new JLabel("Select Credit Card Type : ");
		this.lb30 = new JLabel("Enter Credit Card Number : ");
		this.lb31 = new JLabel("Enter Expiry Date : ");
		this.lb32 = new JLabel("MM");
		this.lb33 = new JLabel("YY");
		this.lb34 = new JLabel("Enter CVV Number : ");
		
		this.jcb1 = new JComboBox<String>();
		
		this.ftf1 = new JFormattedTextField(f1);
		this.ftf2 = new JFormattedTextField(f1);
		this.ftf3 = new JFormattedTextField(f1);
		this.ftf4 = new JFormattedTextField(f1); 
		this.ftf5 = new JFormattedTextField(f2);
		this.ftf6 = new JFormattedTextField(f2); 
		this.ftf7 = new JFormattedTextField(f3); 
		
		this.lb28.setBounds(15,15,260,20);
		this.lb28.setForeground(Color.WHITE);
		this.frame5.add(lb28);
		
		this.jcb1.addItem("Visa");
		this.jcb1.addItem("Delta");
		this.jcb1.addItem("Visa Electron");
		this.jcb1.addItem("MasterCard");
		this.jcb1.addItem("EuroCard");
		this.jcb1.addItem("American Express");
		this.jcb1.addItem("Maestro");
		this.jcb1.addItem("Solo");
		this.jcb1.setForeground(Color.WHITE);
		this.jcb1.setBackground(Color.BLACK);
		
		this.lb29.setBounds(15, 50, 180, 20);		
		this.lb29.setForeground(Color.WHITE);
		this.frame5.add(lb29);
		
		this.jcb1.setBounds(200, 50, 150, 20);		
		this.frame5.add(jcb1);
		
		this.lb30.setBounds(15, 90, 180, 20);
		this.lb30.setForeground(Color.WHITE);
		this.frame5.add(lb30);
		
		this.ftf1.setBounds(180, 90, 40, 20);
		this.frame5.add(ftf1);
		
		this.ftf2.setBounds(225, 90, 40, 20);
		this.frame5.add(ftf2);
		
		this.ftf3.setBounds(270, 90, 40, 20);
		this.frame5.add(ftf3);
		
		this.ftf4.setBounds(315, 90, 40, 20);
		this.frame5.add(ftf4);
		
		this.lb31.setBounds(15, 160, 180, 20);
		this.lb31.setForeground(Color.WHITE);
		this.frame5.add(lb31);
		
		this.lb32.setBounds(220, 130, 40, 20);
		this.lb32.setForeground(Color.WHITE);
		this.frame5.add(lb32);
		
		this.lb33.setBounds(300, 130, 40, 20);
		this.lb33.setForeground(Color.WHITE);
		this.frame5.add(lb33);
		
		this.ftf5.setBounds(200, 160, 60, 20);
		this.frame5.add(ftf5);
		
		this.ftf6.setBounds(280, 160, 60, 20);
		this.frame5.add(ftf6);
		
		this.lb34.setBounds(15, 190, 180, 20);
		this.lb34.setForeground(Color.WHITE);
		this.frame5.add(lb34);
		
		this.ftf7.setBounds(200, 190, 60, 20);
		this.frame5.add(ftf7);
		
		this.b13.setBounds(15, 230, 180, 30);
		this.b13.setBackground(Color.BLACK);
		this.b13.setForeground(Color.WHITE);
		this.frame5.add(b13);
		
		this.b12.setBounds(205, 230, 180, 30);
		this.b12.setBackground(Color.BLACK);
		this.b12.setForeground(Color.WHITE);
		this.frame5.add(b12);
		
		this.b13.setActionCommand("CANCEL_PURCHASE");
		this.b12.setActionCommand("CONFIRM_PURCHASE");
		
		this.b13.addActionListener(la);
		this.b12.addActionListener(la);
		
		this.frame5.getContentPane().setBackground(Color.BLACK);
		
		Image frameIcon = getImage.getImageFromRes("icon.png");
		this.frame5.setIconImage(frameIcon);
		
		this.frame5.setVisible(true);
		this.frame5.setSize(400, 300);
		this.frame5.setResizable(false);
		
	}
	
	public void showCartForm(){
		
		Listen_Action la = new Listen_Action();
		
		this.frame4 = new JFrame();
		this.frame4.setTitle("Online Shopping | Cart");
		this.frame4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.frame4.setLayout(null);
		
		this.b10 = new JButton("Proceed To Checkout");
		this.b11 = new JButton("Remove Item");
		
		this.b11.setActionCommand("Remove_Cart");
		this.b10.setActionCommand("Proceed_Checkout");
		
		this.b11.addActionListener(la);
		this.b10.addActionListener(la);
		
		this.jl3 = new JList<String>(); 
		this.jl4 = new JList<String>();
		this.jl5 = new JList<String>();
		
		this.jsp3 = new JScrollPane();
		this.jsp4 = new JScrollPane();
		this.jsp5 = new JScrollPane();
		
		this.lb24 = new JLabel("Category");
		this.lb25 = new JLabel("Item Name");
		this.lb26 = new JLabel("Price");
		this.lb27 = new JLabel();		
		
		this.jsp3.setViewportView(jl3);
		this.jsp4.setViewportView(jl4);
		this.jsp5.setViewportView(jl5);
		
		this.lb27.setBounds(95, 20, 300, 300);
		this.lb27.setForeground(Color.WHITE);
		this.frame4.add(lb27);
		
		this.lb24.setBounds(50, 330, 60, 20);
		this.lb24.setForeground(Color.WHITE);
		this.frame4.add(lb24);
		
		this.lb25.setBounds(200, 330, 80, 20);
		this.lb25.setForeground(Color.WHITE);
		this.frame4.add(lb25);
		
		this.lb26.setBounds(390, 330, 80, 20);
		this.lb26.setForeground(Color.WHITE);
		this.frame4.add(lb26);
		
		this.jsp3.setBounds(20, 365, 120, 300);
		this.jl3.setBackground(Color.BLACK);
		this.jl3.setForeground(Color.WHITE);
		this.jsp3.setForeground(Color.WHITE);
		this.jsp3.setBackground(Color.BLACK);
		this.frame4.add(jsp3);
		this.jsp3.setEnabled(false);
		this.jl3.setEnabled(false);
		
		this.jsp4.setBounds(180, 365, 120, 300);
		this.jl4.setBackground(Color.BLACK);
		this.jl4.setForeground(Color.WHITE);
		this.jsp4.setForeground(Color.WHITE);
		this.jsp4.setBackground(Color.BLACK);
		this.frame4.add(jsp4);
		
		this.jsp5.setBounds(350, 365, 120, 300);
		this.jl5.setBackground(Color.BLACK);
		this.jl5.setForeground(Color.WHITE);
		this.jsp5.setForeground(Color.WHITE);
		this.jsp5.setBackground(Color.BLACK);
		this.frame4.add(jsp5);
		this.jsp5.setEnabled(false);
		this.jl5.setEnabled(false);
		
		this.b10.setBounds(250, 670, 210, 30);
		this.b10.setBackground(Color.BLACK);
		this.b10.setForeground(Color.WHITE);
		this.frame4.add(b10);
		
		this.b11.setBounds(30, 670, 210, 30);
		this.b11.setBackground(Color.BLACK);
		this.b11.setForeground(Color.WHITE);
		this.frame4.add(b11);
		
		this.frame4.getContentPane().setBackground(Color.BLACK);
		
		this.jl4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jl3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jl5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.jl4.addListSelectionListener(new ListSelectionListener(){
			
				public void valueChanged(ListSelectionEvent e) {
										
					if(jl4.getSelectedIndex() != -1){
						
						jl3.setSelectedIndex(jl4.getSelectedIndex());
						jl5.setSelectedIndex(jl4.getSelectedIndex());
						
						Image i = getImage.getImageFromRes(lb27.getWidth(), lb27.getHeight(),al4.get(jl3.getSelectedIndex()).toString()+".jpg");
						lb27.setIcon(new ImageIcon(i));
					}
					
				}	
			
		});
			
		Image frameIcon = getImage.getImageFromRes("icon.png");
		this.frame4.setIconImage(frameIcon);
		
		this.frame4.setVisible(true);
		this.frame4.setSize(500, 750);
		this.frame4.setResizable(false);		
		
	}
	
	public void showForgotPassForm(){
		
		Listen_Action la = new Listen_Action();
		
		this.frame3 = new JFrame();
		this.frame3.setTitle("Online Shopping | Forgot Password Form");
		this.frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame3.setLayout(new GridLayout(2,1));
		
		this.b8 = new JButton("Retrieve Password");
		this.b8.setBackground(Color.BLACK);
		this.b8.setForeground(Color.WHITE);
		this.b8.setActionCommand("Forgot Password");
		this.b8.addActionListener(la);
		this.lb16 = new JLabel("Username : ");
		this.lb16.setForeground(Color.WHITE);
		this.lb17 = new JLabel("Date Of Birth : ");
		this.lb17.setForeground(Color.WHITE);
		this.lb18 = new JLabel("");
		this.lb18.setForeground(Color.WHITE);
		this.lb18.setHorizontalAlignment(SwingConstants.CENTER);
		this.tf4 = new JTextField(20);
		
		this.model2 = new UtilDateModel();
		this.dp2 = new JDatePanelImpl(model2);
		this.dpi2 = new JDatePickerImpl(dp2);
		
		this.p4 = new JPanel();
		this.p4.setLayout(new GridLayout(2,2));
		this.p4.add(lb16);
		this.p4.add(tf4);
		this.p4.add(lb17);
		this.p4.add(dpi2);
		
		this.p4.setBackground(Color.BLACK);
		
		this.p5 = new JPanel();
		this.p5.setLayout(new GridLayout(2,1));
		this.p5.add(b8);
		this.p5.add(lb18);
		
		this.p5.setBackground(Color.BLACK);		
		this.frame3.getContentPane().setBackground(Color.BLACK);
		
		this.frame3.add(p4);
		this.frame3.add(p5);
		
		Image frameIcon = getImage.getImageFromRes("icon.png");
		this.frame3.setIconImage(frameIcon);
		
		this.frame3.setVisible(true);
		this.frame3.pack();
		this.frame3.setResizable(false);
		
	}
	
	public void showRegisterForm(){
		
		Listen_Action la = new Listen_Action();
		
		this.frame2 = new JFrame();
		this.frame2.setTitle("Online Shopping | Registration Form");
		this.frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame2.setLayout(new GridLayout(2,1));
		
		this.b7 = new JButton("Register");
		this.b7.setBackground(Color.BLACK);
		this.b7.setForeground(Color.WHITE);
		this.b7.setActionCommand("Register");
		this.b7.addActionListener(la);
		this.tf3 = new JTextField(20);
		this.pf2 = new JPasswordField(20);
		this.pf3 = new JPasswordField(20);
		this.lb12 = new JLabel("Username : ");
		this.lb12.setForeground(Color.WHITE);
		this.lb13 = new JLabel("Password : ");
		this.lb13.setForeground(Color.WHITE);
		this.lb14 = new JLabel("Confirm Password : ");
		this.lb14.setForeground(Color.WHITE);
		this.lb15 = new JLabel("Date Of Birth : ");
		this.lb15.setForeground(Color.WHITE);
		
		this.model1 = new UtilDateModel();
		this.dp1 = new JDatePanelImpl(model1);
		this.dpi1 = new JDatePickerImpl(dp1);
				
		this.p2 = new JPanel();
		this.p2.setBackground(Color.BLACK);
		this.p2.setLayout(new GridLayout(4,2));
		this.p2.add(lb12);
		this.p2.add(tf3);
		this.p2.add(lb13);
		this.p2.add(pf2);
		this.p2.add(lb14);
		this.p2.add(pf3);
		this.p2.add(lb15);
		this.p2.add(dpi1);
		
		this.p3 = new JPanel();
		this.p3.setBackground(Color.BLACK);
		this.p3.setLayout(new BorderLayout());
		this.p3.add(b7, BorderLayout.CENTER);
				
		this.frame2.add(p2);
		this.frame2.add(p3);
		
		Image frameIcon = getImage.getImageFromRes("icon.png");
		this.frame2.setIconImage(frameIcon);
		
		this.frame2.setVisible(true);
		this.frame2.pack();
		this.frame2.setResizable(false);
		
	}
	
	public void showLoginForm(){
		
		this.c = new Connect();
		Listen_Action la = new Listen_Action();
		
		this.frame1 = new JFrame();
		this.frame1.setTitle("Online Shopping | Login Form");
		this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame1.setLayout(new GridLayout(3,3));
		
		Border emptyBorder = BorderFactory.createEmptyBorder();		
		
		this.lb10 = new JLabel("Username : ");
		this.lb10.setForeground(Color.WHITE);
		this.lb11 = new JLabel("Password : ");
		this.lb11.setForeground(Color.WHITE);
		this.b5 = new JButton("<HTML><FONT color=\"#ffa500\"><U>Forgot Password</U></FONT></HTML>");
		this.b5.setBackground(Color.BLACK);
		this.b5.setHorizontalAlignment(SwingConstants.LEFT);
		this.b6 = new JButton("<HTML><FONT color=\"#ffa500\"><U>New User? Register Here!</U></FONT></HTML>");
		this.b6.setBackground(Color.BLACK);
		this.b6.setHorizontalAlignment(SwingConstants.LEFT);
		this.b5.setBorder(emptyBorder);
		this.b6.setBorder(emptyBorder);
		this.b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.b5.setActionCommand("SFPF");
		this.b6.setActionCommand("SRF");
		this.b5.addActionListener(la);
		this.b6.addActionListener(la);
		
		this.b4 = new JButton("Login");
		this.b4.setBackground(Color.BLACK);
		this.b4.setForeground(Color.WHITE);
		this.b4.setActionCommand("Login");
		this.b4.addActionListener(la);
		this.tf2 = new JTextField(20);
		this.pf1 = new JPasswordField(20);
		this.p1 = new JPanel();
		this.p1.setBackground(Color.BLACK);
		
		this.frame1.getContentPane().setBackground(Color.BLACK); 
		
		this.p1.setLayout(new GridLayout(2,1));
		this.p1.add(b5);
		this.p1.add(b6);
		
		this.frame1.add(lb10);
		this.frame1.add(tf2);
		this.frame1.add(lb11);
		this.frame1.add(pf1);
		this.frame1.add(p1);
		this.frame1.add(b4);
		
		Image frameIcon = getImage.getImageFromRes("icon.png");
		this.frame1.setIconImage(frameIcon);
		
		this.frame1.setVisible(true);
		this.frame1.pack();
		this.frame1.setResizable(false);
		
	}
	
	public void showShoppingForm(){
		
		Listen_Action la = new Listen_Action();
						
		this.frame = new JFrame();
		
		this.frame.setTitle("Online Shopping | Shopping Page");		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(null);
		
		this.b1 = new JButton("Add To Cart");
		this.b2 = new JButton("Add To Cart");
		Main.b9 = new JButton("Add To Cart");
		this.b1.setBackground(Color.BLACK);
		this.b2.setBackground(Color.BLACK);
		Main.b9.setBackground(Color.BLACK);
		this.b1.setForeground(Color.WHITE);
		this.b2.setForeground(Color.WHITE);
		Main.b9.setForeground(Color.WHITE);
		this.b3 = new JButton();
				
		Image cartImage = getImage.getImageFromRes(25, 25,"CART.png");
		this.b3.setIcon(new ImageIcon(cartImage));
		this.b3.setActionCommand("Cart");
		this.b3.setBackground(Color.BLACK);
		
		Main.tf1 = new HintTextField("Search.......(Category + Item Name) (Eg. Tops (Women) + Gray)");
							
		Main.lb1 = new JLabel("Item Name : ");
		Main.lb1.setForeground(Color.WHITE);
		Main.lb23 = new JLabel("Category : ");
		Main.lb23.setForeground(Color.WHITE);
		this.lb2 = new JLabel("Item Name : ");
		this.lb2.setForeground(Color.WHITE);
		Main.lb3 = new JLabel("Price : ");
		Main.lb3.setForeground(Color.WHITE);
		this.lb4 = new JLabel("Price : ");
		this.lb4.setForeground(Color.WHITE);
		this.lb5 = new JLabel("Application Developed By : Saptarshi Laha");
		this.lb5.setForeground(Color.WHITE);
		this.lb6 = new JLabel("Categories");
		this.lb6.setForeground(Color.WHITE);
		this.lb7 = new JLabel("Items");
		this.lb7.setForeground(Color.WHITE);
		Main.lb19 = new JLabel("Category : ");
		Main.lb19.setForeground(Color.WHITE);
		Main.lb20 = new JLabel("Item Name : ");
		Main.lb20.setForeground(Color.WHITE);
		Main.lb21 = new JLabel("Price : ");
		Main.lb21.setForeground(Color.WHITE);
		Main.lb8 = new JLabel();
		this.lb9 = new JLabel();
		Main.lb22 = new JLabel();
		
		this.jsp1 = new JScrollPane();
		this.jsp2 = new JScrollPane();
		
		this.jl1 = new JList<String>();
		this.jl2 = new JList<String>();
		
		this.jl1.setBackground(Color.BLACK);
		this.jl2.setBackground(Color.BLACK);
		this.jsp1.setBackground(Color.BLACK);
		this.jsp2.setBackground(Color.BLACK);
		
		this.jl1.setForeground(Color.WHITE);
		this.jl2.setForeground(Color.WHITE);
		this.jsp1.setForeground(Color.WHITE);
		this.jsp2.setForeground(Color.WHITE);
		
		
		this.jsp1.setViewportView(jl1);
		this.jsp2.setViewportView(jl2);
		
		this.jl1.addListSelectionListener(new ListSelectionListener(){
			
				public void valueChanged(ListSelectionEvent e) {
					
					lb9.setIcon(new ImageIcon());
					jl2.removeAll();
					al3.clear();
					al1.clear();
					al2.clear();
					
					Connect.listCurrent = -1;
					
					lb2.setText("Item Name : ");
					lb4.setText("Price : ");
					
					jl1.setEnabled(false);
					String listItems[] = c.resetList(jl1.getSelectedValue().toString());
					int ID[] = c.getIDList(jl1.getSelectedValue().toString());
					int PRICE[] = c.getPRICEList(jl1.getSelectedValue().toString());
					
					for(int i =0; i<listItems.length; i++){
						
						al1.add(listItems[i]);
						al2.add(ID[i]);
						al3.add(PRICE[i]);
						
					}
					
					listModel2 = new DefaultListModel<String>();
	            	
	            	for(int i=0; i<listItems.length; i++){
	            	            	
	            		listModel2.addElement(listItems[i]);
	            		
	            	}
	            	
	            	jl2.setModel(listModel2);
					
					jl1.setEnabled(true);
					
				}	
			
		});
		
		this.jl2.addListSelectionListener(new ListSelectionListener(){
			
				public void valueChanged(ListSelectionEvent e) {
					
										
					try{
						
						if(jl2.getSelectedIndex() != -1){
						lb2.setText("Item Name : "+al1.get(jl2.getSelectedIndex()));
						lb4.setText("Price : "+al3.get(jl2.getSelectedIndex()));
											
						Image i = getImage.getImageFromRes(lb9.getWidth(), lb9.getHeight(),al2.get(jl2.getSelectedIndex()).toString()+".jpg");
												
						Connect.listCurrent = al2.get(jl2.getSelectedIndex());
						
						lb9.setIcon(new ImageIcon(i));
						
						}
					}
					catch(Exception ex){
						
						JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
					    JOptionPane.showMessageDialog(null, "Please Restart The Application", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
					    System.exit(0);
						
					}
					
					jl2.setEnabled(true);
					
				}	
			
		});
		
		Main.tf1.setBounds(0, 0, 974, 30);
		this.frame.add(tf1);
		
		Main.tf1.addKeyListener(new KeyListener(){

			
			public void keyPressed(KeyEvent e) {
											
			}

			
			public void keyReleased(KeyEvent e) {
				
				
				Main.t2 = new Thread(new Run_Thread2());
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				searching = false;
				if(t2.isAlive()){
				t2.interrupt();
				}
				
				Run_Thread2 r2 = new Run_Thread2();
				
			  	Main.searching = true;
            	r2.initiateSearch(Main.tf1.getText());
            	t2.start();
				
				}
				else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE){
					
					if(Main.tf1.getText().equals(Main.searchString) == false){
					
					Connect.searchCurrent = -1;
						
					lb19.setText("Category : ");
					lb20.setText("Item Name : ");
					lb21.setText("Price : ");
					lb22.setIcon(new ImageIcon());
					
					}
										
				}	
				
			}

		
			public void keyTyped(KeyEvent e) {
								
			}
			
			
			
		});
		
		this.b3.setBounds(974, 0, 45, 30);
		this.frame.add(b3);
		
		Main.lb8.setBounds(15, 45, 200, 200);
		this.frame.add(lb8);
		
		Main.lb22.setBounds(500, 45, 200, 200);
		this.frame.add(lb22);
		
		Main.lb19.setBounds(715, 50, 400, 50);
		this.frame.add(lb19);
		
		Main.lb20.setBounds(715, 100, 400, 50);
		this.frame.add(lb20);
		
		Main.lb21.setBounds(715, 150, 400, 50);
		this.frame.add(lb21);
		
		Main.b9.setBounds(715, 215, 200, 30);
		this.frame.add(b9);
		
		Main.lb1.setBounds(230, 100, 400, 50);
		this.frame.add(lb1);
		
		Main.lb23.setBounds(230, 50, 400, 50);
		this.frame.add(lb23);
		
		Main.lb3.setBounds(230, 150, 400, 50);
		this.frame.add(lb3);
		
		this.b1.setBounds(230, 215, 200, 30);
		this.frame.add(b1);
		
		this.lb6.setBounds(75, 250, 150, 50);
		this.frame.add(lb6);
		
		this.lb7.setBounds(295, 250, 150, 50);
		this.frame.add(lb7);
		
		this.jsp1.setBounds(20, 290, 190, 400);
		this.frame.add(jsp1);
		
		this.jsp2.setBounds(230, 290, 190, 400);
		this.frame.add(jsp2);
		
		this.lb5.setBounds(360, 700, 400, 40);
		this.frame.add(lb5);
		
		this.lb9.setBounds(660, 270, 300, 300);
		this.frame.add(lb9);
		
		this.lb2.setBounds(670, 565, 400, 50);
		this.frame.add(lb2);
		
		this.lb4.setBounds(670, 590, 400, 50);
		this.frame.add(lb4);
		
		this.b2.setBounds(670, 640, 300, 30);
		this.frame.add(b2);
		
		this.b1.addActionListener(la);
		this.b1.setActionCommand("Thread_Add_Cart");
		this.b2.addActionListener(la);
		this.b2.setActionCommand("List_Add_Cart");
		this.b3.addActionListener(la);
		Main.b9.addActionListener(la);
		Main.b9.setActionCommand("Search_Add_Cart");
		
		this.frame.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent we) {
                Main.running = false;
            }
            public void windowActivated(WindowEvent we) {
               
            }
            public void windowClosing(WindowEvent we) {
                
            }
            public void windowDeactivated(WindowEvent we) {
                
            }
            public void windowDeiconified(WindowEvent we) {
                
            }
            public void windowIconified(WindowEvent we) {
                
            }
            public void windowOpened(WindowEvent we) {
                
            	showCartForm();
            	frame4.setVisible(false);
            	c.initiateThread();
            	Main.t1 = new Thread(new Run_Thread1());
            	Main.running = true;
            	t1.start();
            	
            	String s1[] = c.populateCat();
            	listModel1 = new DefaultListModel<String>();
            	
            	for(int i=0; i<s1.length; i++){
            	            		            		
            		listModel1.addElement(s1[i]);
            		
            	}
            	
            	jl1.setModel(listModel1);
            }
        });		
		
		  Main.b9.setVisible(false);
    	  Main.lb19.setVisible(false);
    	  Main.lb20.setVisible(false);
    	  Main.lb21.setVisible(false);
    	  Main.lb22.setVisible(false);
		
		Image frameIcon = getImage.getImageFromRes("icon.png");
		this.frame.setIconImage(frameIcon);
    	  
		jl1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.frame.getContentPane().setBackground(Color.BLACK); 
		this.frame.setVisible(true);
		this.frame.setSize(1024, 768);
		this.frame.setResizable(false);
					
	}
	
	}
