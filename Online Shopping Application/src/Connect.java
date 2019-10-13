import java.awt.Image;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import res.getImage;


public class Connect {
  
   public Connection con = null;
   public Statement s = null;
   public ArrayList<String> al1 = new ArrayList<String>();
   public ArrayList<String> al2 = new ArrayList<String>();
   public ArrayList<String> al3 = new ArrayList<String>();
   public ArrayList<String> al4 = new ArrayList<String>();
   public ArrayList<String> al5 = new ArrayList<String>();
   public ArrayList<String> al6 = new ArrayList<String>();
   public ArrayList<String> al7 = new ArrayList<String>();
   public ArrayList<String> al8 = new ArrayList<String>();
   public ArrayList<Integer> al9 = new ArrayList<Integer>();
   public ArrayList<Integer> al10 = new ArrayList<Integer>();
   public static ArrayList<String> al11 = new ArrayList<String>();
   public static ArrayList<Integer> al12 = new ArrayList<Integer>();
   public static ArrayList<Integer> al13 = new ArrayList<Integer>();
   public static ArrayList<String> al14 = new ArrayList<String>();
   public static ArrayList<String> al15 = new ArrayList<String>();
   public static ArrayList<Integer> al16 = new ArrayList<Integer>();
   public static ArrayList<String> al17 = new ArrayList<String>();
   public static ArrayList<Integer> al18 = new ArrayList<Integer>();
   
   public static int threadCurrent = -1;
   public static int searchCurrent = -1;
   public static int listCurrent = -1;
   
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/";
   
   static final String USER = "root";
   static final String PASS = "incorrect";
   
   public void checkAndAct(){
	   
	   
	try {
		String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'ONLINE_SHOPPING' AND table_name = 'PRODUCTDATA'";
		ResultSet rs = s.executeQuery(query);                  
		rs.next();
		boolean exists = rs.getInt("COUNT(*)") > 0;
				
		if (!exists) {
		    						
			String sql = "CREATE TABLE IF NOT EXISTS PRODUCTDATA (ID INT(10) NOT NULL PRIMARY KEY, PROD_CAT VARCHAR(100), PROD_NAME VARCHAR(100), PROD_PRICE INT(100))";
		    s.executeUpdate(sql);
			
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (1, \"One Piece (Women)\", \"Pink Patched\", 600)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (2, \"Tops (Women)\", \"Navy Blue\", 650)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (3, \"T-Shirt (Men)\", \"Galaxy Print\", 850)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (4, \"Tops (Women)\", \"Starry\", 900)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (5, \"Tops (Women)\", \"Blu-O-range\", 995)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (6, \"Caps\", \"Sea Green Blue\", 1000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (7, \"Caps\", \"Coal Black\", 1000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (8, \"Caps\", \"Batman\", 1000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (9, \"Tops (Women)\", \"Zebra Striped\", 1000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (10, \"Tops (Women)\", \"Rose Red\", 1100)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (11, \"One Piece (Women)\", \"Coal Black\", 1225)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (12, \"Skirt (Women)\", \"Light Pink\", 1250)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (13, \"Skirt (Women)\", \"Red Black Mini\", 1500)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (14, \"Full Set (Women)\", \"White Black Spots\", 1600)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (15, \"Shorts (Women)\", \"Gray\", 1600)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (16, \"Trousers (Women)\", \"Purple\", 1695)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (17, \"Trousers (Women)\", \"White\", 1800)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (18, \"Trousers (Women)\", \"Gray\", 1900)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (19, \"Trousers (Men)\", \"Black\", 1995)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (20, \"One Piece (Women)\", \"Blue\", 1995)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (21, \"Shirt (Men)\", \"Light Purple Striped\", 2000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (22, \"Full Set (Women)\", \"Purple Black\", 2000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (23, \"Tops (Women)\", \"Gray\", 2100)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (24, \"Trousers (Men)\", \"Gray\", 2300)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (25, \"T-Shirt (Men)\", \"Green\", 2400)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (26, \"Trousers (Women)\", \"Dark Flowers\", 2500)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (27, \"Shorts (Men)\", \"Cream\", 2500)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (28, \"Shorts (Men)\", \"Blue White Patched\", 2500)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (29, \"Skirt (Women)\", \"Black Mini\", 2500)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (30, \"Tops (Women)\", \"Embroidery\", 2800)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (31, \"Jacket (Men)\", \"Leather Black\", 2900)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (32, \"Shirt (Men)\", \"Black Scorpion\", 2995)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (33, \"Shirt (Men)\", \"Blue White\", 2995)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (34, \"Shirt (Men)\", \"Black\", 2995)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (35, \"Jacket (Men)\", \"Black Half\", 3000)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (36, \"Full Set (Women)\", \"Zebra Striped\", 3200)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (37, \"Trousers (Men)\", \"Peach\", 3295)";
		    s.executeUpdate(sql);
		    
		    sql = "INSERT INTO PRODUCTDATA(ID, PROD_CAT, PROD_NAME, PROD_PRICE) VALUES (38, \"Full Set (Women)\", \"Dove White\", 3335)";
		    s.executeUpdate(sql);
		    
		    
		   }
		
	} catch (Exception e) {
		
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	     JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	     System.exit(0);
	}
	   
	   	   
   }
   
   public Connect() {
 
   try{
      
      Class.forName("com.mysql.jdbc.Driver");

      con = DriverManager.getConnection(DB_URL, USER, PASS);
      
      s = con.createStatement();
      String sql = "CREATE DATABASE IF NOT EXISTS ONLINE_SHOPPING";
      s.executeUpdate(sql);
      sql = "USE ONLINE_SHOPPING";
      s.executeUpdate(sql);
            
      
      
      String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'ONLINE_SHOPPING' AND table_name = 'USERDATA'";
      ResultSet rs = s.executeQuery(query);                  
      rs.next();
      boolean exists = rs.getInt("COUNT(*)") > 0;
      
      if(!exists){
    	  sql = "CREATE TABLE IF NOT EXISTS USERDATA (ID INT(10) NOT NULL PRIMARY KEY auto_increment, USERNAME VARCHAR(500), PASSWORD VARCHAR(500), DATEOFBIRTH DATE, TOTAL INT(200))";
          s.executeUpdate(sql);
    	  
    	  sql = "INSERT INTO USERDATA(USERNAME, PASSWORD, DATEOFBIRTH, TOTAL) VALUES (\"root\", \"toor\", NULL, 0)";
		  s.executeUpdate(sql);
    	  
      }
      
      this.checkAndAct();
      
      }catch(Exception e){
  
     JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
     JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
     System.exit(0);
   }
   }

public boolean checkEntry(String s1, String s2) {
	
	al1.clear();
	al2.clear();
	
	try{
		
		String sql = "SELECT * FROM USERDATA";
		ResultSet rs = (con.prepareStatement(sql)).executeQuery();
		
		while (rs.next()){
			
			String UN = rs.getString("USERNAME");
			String PW = rs.getString("PASSWORD");
			al1.add(UN);
			al2.add(PW);
									
			}
		
			int temp = 0;
			int found = -1;
		
						
		for(int i=0; i<this.al1.size(); i++){
			
			if (s1.equals(al1.get(i))){
				
				temp = i;
				found = 1;
				}
				
		}
		
		if(s2.equals(al2.get(temp)) && found==1){
			
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);
	    
	}
	return false;
	
}

public int createEntry(String s1, String s2, String s3) {
		
	if(checkNoDuplicate(s1) == true){
	
	String sql = "INSERT INTO USERDATA(USERNAME, PASSWORD, DATEOFBIRTH, TOTAL) VALUES (\""+s1+"\",\"" +s2+"\",\""+s3+"\", 0)";
    try {
		s.executeUpdate(sql);
		return 0;
	} catch (Exception e) {
		
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);
	}
	}
	else{
		
		return 1;
		
	}
	
	return -1;
	
}

private boolean checkNoDuplicate(String s1) {
	
	al3.clear();
	
try{
		
		String sql = "SELECT * FROM USERDATA";
		ResultSet rs = (con.prepareStatement(sql)).executeQuery();
		
		while (rs.next()){
			
			String UN = rs.getString("USERNAME");
			al3.add(UN);
		}
		
		int temp = 0;
		
		for (int i = 0; i<this.al3.size(); i++){
			
			if (s1.equals(al3.get(i))){
				temp = 1;				
				}
						
		}
		
		if (temp == 1){
			return false;
		}
		else{
			return true;
		}
		
}
catch(Exception e){
	JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
	
}
	
	return false;
		
}

public String retPass(String s1, String s2) {
	
	al4.clear();
	al5.clear();
	al6.clear();
	String pwd = null;
	
try{
		
		String sql = "SELECT * FROM USERDATA";
		ResultSet rs = (con.prepareStatement(sql)).executeQuery();
		
		while (rs.next()){
			
			String UN = rs.getString("USERNAME");
			String DOB = rs.getString("DATEOFBIRTH");
			String PWD = rs.getString("PASSWORD");
			al4.add(UN);
			al5.add(DOB);
			al6.add(PWD);
		}
		
				
		for (int i = 0; i<this.al4.size(); i++){
			
			if (al4.get(i).equals(s1) && al5.get(i).equals(s2)){
								
				pwd = al6.get(i);
				
				}
			
		}
		
		
		
		if(pwd != null){
			
			
			return pwd;
			
		}
		else{
			
			return null;
			
		}
		
				
}
catch(Exception e){
	JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
	
}
	
	return null;
	
}

public String[] populateCat() {
	
	al7.clear();
		
	try{
			
			String sql = "SELECT * FROM PRODUCTDATA";
			ResultSet rs = (con.prepareStatement(sql)).executeQuery();
			
			while (rs.next()){
				
				String CATS = rs.getString("PROD_CAT");
				al7.add(CATS);
			}
			
						
			for (int i = 0; i < al7.size() - 1; i++) {
		        
		        for (int j = i + 1; j < al7.size(); j++) {
		        
		            if (!al7.get(j).equals(al7.get(i)))
		                continue;
		           
		            al7.remove(j);
		          
		            j--;
		           	         
		        } 
		    } 
			
			String CAT[] = new String[al7.size()];
			
			for(int i = 0; i<al7.size(); i++){
				
				CAT[i] = al7.get(i);
				
			}
			
			return CAT;
			
	} catch (Exception e){
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);
		
	}
			
	
	
	return null;
}

public void initiateThread() {
	
	al11.clear();
	al12.clear();
	al13.clear();
	al14.clear();
	al15.clear();
	al16.clear();
	al17.clear();
	al18.clear();
	
	try{
		
		String sql = "SELECT * FROM PRODUCTDATA";
		ResultSet rs = (con.prepareStatement(sql)).executeQuery();
		
		while (rs.next()){
			
			String CAT = rs.getString("PROD_CAT");
			String ITEM = rs.getString("PROD_NAME");
			int PRICE = Integer.parseInt(rs.getString("PROD_PRICE"));
			int ID = Integer.parseInt(rs.getString("ID"));
			al11.add(ITEM);
			al12.add(PRICE);
			al13.add(ID);
			al14.add(CAT);
			
			al15.add(ITEM);
			al16.add(PRICE);
			al17.add(CAT);
			al18.add(ID);
			
			
		}
				
		
} catch (Exception e){
	JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
	
}
	
}

public String[] resetList(String s) {
	
	al8.clear();
	al9.clear();
	al10.clear();
	
	try{
		
		String sql = "SELECT * FROM PRODUCTDATA";
		ResultSet rs = (con.prepareStatement(sql)).executeQuery();
		
		while (rs.next()){
			
			String CATS = rs.getString("PROD_CAT");
			String ITEM = rs.getString("PROD_NAME");
			int PRICE = Integer.parseInt(rs.getString("PROD_PRICE"));
			int ID = Integer.parseInt(rs.getString("ID"));
			
					if(CATS.equals(s)){
							al9.add(ID);
							al8.add(ITEM);
							al10.add(PRICE);
					}
		}
		
		String ITEM[] = new String[al8.size()];
		
		for(int i = 0; i<al8.size(); i++){
			
			ITEM[i] = al8.get(i);
			
		}
		
		return ITEM;
		
} catch (Exception e){
	JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
	
}
	
	return null;
	
	
}

public int[] getIDList(String s) {

	int ID[] = new int[al9.size()];
	
	for(int i = 0; i<al9.size(); i++){
		
		ID[i] = al9.get(i);
		
	}
	
	return ID;	
	
	
}

public int[] getPRICEList(String string) {
	
int PRICE[] = new int[al10.size()];
	
	for(int i = 0; i<al10.size(); i++){
		
		PRICE[i] = al10.get(i);
		
	}
	
	return PRICE;	
	
}

public void runFeatured() {
	
	Random r = new Random();
	int ID = r.nextInt(al11.size()-1);
	
	Main.lb1.setText("Item Name : "+al11.get(ID));
	Main.lb3.setText("Price : "+al12.get(ID));
	Main.lb23.setText("Category : "+al14.get(ID));
	
	Image i = getImage.getImageFromRes(Main.lb8.getWidth(), Main.lb8.getHeight(),al13.get(ID).toString()+".jpg");
	
	Main.lb8.setIcon(new ImageIcon(i));
	
	Connect.threadCurrent = al13.get(ID);
	
}

public int runSearch(String s) {
	
	Main.foundString = -1;
	
	String s1 = null, s2 = null;
	
	s1 = s.trim();
		
	int temp = -1;
	
		
	for(int i =0; i<s1.length(); i++){
		
		if(s1.charAt(i) == '+'){
			
			temp = i;
			
		}
		
	}
	
	if(temp != -1){
		
		s2 = s1.substring(temp+1);
		s1 = s1.substring(0,temp);
		
		s1 = s1.trim();
		s2 = s2.trim();
		
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");
		s1 = s1.replace("(", "");
		s1 = s1.replace(")", "");
		
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
	}
	else
	{
		
		return 0;
		
	}
	
	

	
	for(int i = 0; i<al15.size(); i++){
			
		
			if(s1.equals(((al17.get(i).replace(" ", "").toLowerCase()).replace("(", "")).replace(")", "")) && s2.equals(al15.get(i).replace(" ", "").toLowerCase())){
						return 1+i;
				
			}
			
								
		}
		
	return -1;
}

public void addTotal(int finalPrice) {
	
	
    try {
    	
    	String query = "SELECT TOTAL FROM USERDATA WHERE USERNAME = '" + Main.LoginID +"'";
		ResultSet rs = s.executeQuery(query);    
		rs.next();
		int previous = Integer.parseInt(rs.getString("TOTAL"));
    	
		previous = previous + finalPrice;
		
    	String sql = "UPDATE USERDATA SET TOTAL = " + previous + " WHERE USERNAME = '" + Main.LoginID +"'";
		s.executeUpdate(sql);
		
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);
		
	}
	
}


   
}