// Jimmy Liu
// Januaray 24, 2013
// SimpleJFram2.java
// An example of adding a JPanel to a JFrame and painting on the JPanel.

// Topis: JPanel and paintComponent()
// 1. how to create a class extending JPanel
// 2. painting in JPanel

import java.awt.*; // Abstract Window Toolkit
import javax.swing.*; // Swing library

public class SimpleJFrame2 {

	JFrame frame;
	MyPanel panel;
	
	public static void main (String [] args) {
		SimpleJFrame2 sjf = new SimpleJFrame2(); 
		sjf.Run();
	}
	
	public void Run() {
	
	// 1. Create the JFrame object 
	frame = new JFrame("My Second JFrame");
	
	// 2. Set the parameters of the JFrame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// 3. Create JPanel 
	panel = new MyPanel();
		
	// 4. Add JPanel to JFrame 
	frame.getContentPane().add(panel, BorderLayout.CENTER);
	
	// 5. Size and locate the JFrame
	frame.setSize(500, 500);
	frame.setLocation(200, 300);
	
	// 6. Make JFrame visible
	frame.setVisible(true); // false makes frame invisible
	
	
	}
} //end class SimpleJFrame2

class MyPanel extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();  //width of the JPanel
		int height = getHeight(); //height of JPanel
		
		// Set background color to white
		setBackground(Color.white);
	
	}


}