import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class HintTextField extends JTextField {  
 
	private static final long serialVersionUID = -2750994348100415408L;
	
	Font gainFont = new Font("Tahoma", Font.PLAIN, 11);  
	Font lostFont = new Font("Tahoma", Font.ITALIC, 11);  
  
  public HintTextField(final String hint) {  
  
    setText(hint);  
    setFont(lostFont);  
    setForeground(Color.GRAY);  
  
    this.addFocusListener(new FocusAdapter() {  
  
      public void focusGained(FocusEvent e) {  
        
    	  if(!(Main.tf1.getText().isEmpty())){
    	  Main.b9.setVisible(true);
      	  Main.lb19.setVisible(true);
      	  Main.lb20.setVisible(true);
      	  Main.lb21.setVisible(true);
      	  Main.lb22.setVisible(true);
    	  }
    	  else{
    		  
    		  Main.b9.setVisible(false);
          	  Main.lb19.setVisible(false);
          	  Main.lb20.setVisible(false);
          	  Main.lb21.setVisible(false);
          	  Main.lb22.setVisible(false);
    		  
    	  }
    	  
    	  if (getText().equals(hint)) {  
          setText("");  
          setFont(gainFont);
          
        } else {  
          setText(getText());  
          setFont(gainFont);  
        }  
      }  
  
     
      public void focusLost(FocusEvent e) {  
    	  
    	  if(!(Main.tf1.getText().isEmpty())){
        	  Main.b9.setVisible(true);
          	  Main.lb19.setVisible(true);
          	  Main.lb20.setVisible(true);
          	  Main.lb21.setVisible(true);
          	  Main.lb22.setVisible(true);
        	  }
        	  else{
        		  
        		  Main.b9.setVisible(false);
              	  Main.lb19.setVisible(false);
              	  Main.lb20.setVisible(false);
              	  Main.lb21.setVisible(false);
              	  Main.lb22.setVisible(false);
        		  
        	  }
    	  
        if (getText().equals(hint)|| getText().length()==0) {  
          setText(hint);  
          setFont(lostFont);  
          setForeground(Color.GRAY);  
        } else {  
          setText(getText());  
          setFont(gainFont);  
          setForeground(Color.BLACK);  
        }  
      }  
    });  
  
  }  
}  
