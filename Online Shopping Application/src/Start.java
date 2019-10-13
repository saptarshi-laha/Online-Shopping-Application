import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;

import javax.swing.JOptionPane;


public class Start {

	public static void main(String[] args){
		
		Start.checkIfRunning();
		
		Main m = new Main();
		m.showLoginForm();
		
	}
	
	private static final int PORT = 10999;
	private static ServerSocket socket;    
	

	private static void checkIfRunning() {
	  try {
	    Start.socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
	    System.out.println(Start.socket.toString());
	   	 }
	  catch (BindException e) {
		  JOptionPane.showMessageDialog(null, "Error: Application Already Running. Please Close Any Instances Of The Application That Are Running & Restart The Application!", "Error: Double Instance!", JOptionPane.ERROR_MESSAGE);
		  System.exit(0);
	   	  }
	  catch (IOException e) {
		  JOptionPane.showMessageDialog(null, "Error: "+e, "Error: IO Exception Caught", JOptionPane.ERROR_MESSAGE);
		  System.exit(0);
	  }
	    
	}
	
}
