import javax.swing.*;
import java.awt.*;
public class SlotMachine{
	
	
	public static void main(String[] args){
		JFrame window = new JFrame("SPIN 2 WIN!!!!!!!!!!!!!!!");
   		ThePanel content = new ThePanel();
    	window.setContentPane(content);
    	window.setSize(600,160);
    	window.setLocationRelativeTo(null);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setResizable(false);
    	window.setVisible(true);
   
		
	
	}



}
