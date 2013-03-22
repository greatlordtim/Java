import javax.swing.JFrame;
import java.awt.*;
public class Main {
	public static void main(String[] args){
		JFrame window = new JFrame("Connect Four");
		HeliPanel content = new HeliPanel();
    	window.addMouseListener(content);
    	window.setContentPane(content);
    	window.setSize(700,450);
    	window.setLocationRelativeTo(null);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setResizable(false);
    	window.setVisible(true);
    	
   	}
	
}
