import javax.swing.JFrame;
import java.awt.*;
public class Main {
	
	
	public static void main(String[] args){
		JFrame window = new JFrame("Connect Four");
		ConnectFour content = new ConnectFour();
    	window.addKeyListener(content);
    	window.setContentPane(content);
    	window.setSize(800,500);
    	window.setLocationRelativeTo(null);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setResizable(false);
    	window.setVisible(true);
    	
   	}
	
}
