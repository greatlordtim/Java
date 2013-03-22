//
import java.awt.*;
import javax.swing.*;

public class SimpleJFrame2 {
	JFrame frame;
	MyPanel panel;
	public static void main (String args[]) {		
		//Create JFrame object
		SimpleJFrame2 sjf = new SimpleJFrame2();
		sjf.run();

	}
	public void run(){
		frame = new JFrame("My Second JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
class MyPanel extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		setBackground(Color.white);
		g.setColor(Color.blue);
		g.fillRect(10,10,width-20,height-20);
	}
}
