// Jimmy Liu
// February 27, 2013
// Trail.java
// Yolo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Trail {
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	NorthPanel np;			// KeyListener, FocusListener panel with text field
	
	public Trail () {
	
	}
	
	public static void main(String[] args) {
		Trail trail = new Trail();
		trail.Run();
	} //end public void
	
	
	public void Run() {
		frame = new JFrame("Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create North JPanel and add to JFrame
		np = new DerpPanel();
		frame.getContentPane().add(np, BorderLayout.CENTER);
						
		frame.setSize(300, 500);		// explicitly set size in pixels
		frame.setLocation(500,300);	// set location on my screen
		frame.setVisible(true);		// set to true to make visible
		
	} //end Run()
	
	class DerpPanel extends JPanel implements KeyListener {
		
		public DerpPanel() {
			
			
			
			
		} //end public DerpPanel
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		} //end paintComponent
		
	} //end DerpPanel
	
} //end Trail
	

