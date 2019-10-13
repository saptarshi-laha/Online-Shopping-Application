package res;
// TO BE PLACED INSIDE RESOURCES FOLDER!!!!

import java.awt.Image;
import java.awt.Toolkit;

public class getImage
{

	public static getImage gi = new getImage();
	
	public static Image getImageFromRes(int WIDTH, int HEIGHT, String filename){
	
	Image i = Toolkit.getDefaultToolkit().getImage(gi.getClass().getResource(filename));
	Image ifinal = i.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
	return ifinal;
	}

	public static Image getImageFromRes(String filename){

	Image i = Toolkit.getDefaultToolkit().getImage(gi.getClass().getResource(filename));
	return i;
	}

}