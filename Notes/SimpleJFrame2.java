// Jimmy Liu
// Januaray 24, 2013
// SimpleJFram2.java
// An example of the simplest JFrame and the methods required to make it possible

// Topis: JFrame
// 1. how to create a JFrame object (window)
// 2. setting of JFrame
// 3. JFrame components - JLable, JButton

import java.awt.*; // Abstract Window Toolkit
import javax.swing.*; // Swing library

public class SimpleJFrame2 {
	public static void main (String [] args) {
	
	
	// 1. Create the JFrame object 
	JFrame frame = new JFrame("My Fist JFrame");
	
	// 2. Set the parameters of the JFrame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// 3. Create components 
	JLabel emptyLabel = new JLabel("Empty");
	JButton bigButton = new JButton("BIG");
	JButton littleButton = new JButton("little");
	
	// 4. Add components to JFrame 
	frame.getContentPane().add(emptyLabel, BorderLayout.NORTH);
	frame.getContentPane().add(bigButton, BorderLayout.CENTER);
	frame.getContentPane().add(littleButton, BorderLayout.SOUTH);
	
	// 5. Size and locate the JFrame
	frame.setSize(300, 100);
	frame.setLocation(200, 300);
	
	// 6. Make JFrame visible
	frame.setVisible(true); // false makes frame invisible
	
	
	}
}