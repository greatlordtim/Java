import javax.swing.JFrame;
import java.awt.*;
public class Main {
	public static void main(String[] args){
		JFrame window = new JFrame("Snake");
		Snake content = new Snake();
    	window.setContentPane(content);
    	window.setSize(500,300);
    	window.addKeyListener(content.h);
    	window.setLocationRelativeTo(null);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setResizable(false);
    	window.setVisible(true);
    	
   	}
	
}
