//Anindit Gopalakrishnan
//September 10, 2012
//Pong.java
//This program will play a simple pong game.
import javax.swing.JFrame;
import java.awt.*;
public class Pong {
	
	
	public static void main(String[] args){
		JFrame window = new JFrame("My Pong Game");
   		PongPanel content = new PongPanel();
    	window.setContentPane(content);
    	window.setSize(content.WINDOW_WIDTH, content.WINDOW_HEIGHT);
    	window.setLocationRelativeTo(null);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setResizable(false);
    	window.setVisible(true);
    	
   	}
	
}
