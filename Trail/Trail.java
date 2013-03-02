// Jimmy Liu
// February 27, 2013
// Trail.java
// Yolo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Trail {
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	DerpPanel np;			// KeyListener, FocusListener panel with text field
	int[][] array = new int[1337][2];
	int move = 0;
	
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
						
		frame.setSize(500, 500);		// explicitly set size in pixels
		frame.setLocation(500,300);	// set location on my screen
		frame.setVisible(true);		// set to true to make visible
		
	} //end Run()
	
	class DerpPanel extends JPanel implements KeyListener {
		
		public DerpPanel() {
			frame.addKeyListener(this);
		} //end public DerpPanel
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(250, 250, 5, 5);
			array[0][0] = 250;
			array[1][0] = 250;




		} //end paintComponent

		public void moving(Graphics g) {
			super.paintComponent(g);
			switch (c) {

				case 'a': 
				int xloc = array[0][move];
				int yloc = array[1][move];
				super.paintComponent(g);
				g.fillRect((xloc - 5), yloc, 5, 5);

				break;

				case 'd':
				break;

				case 'w':
				break;

				case 'x':
				break;

				case 'q':
				break;

				case 'e':
				break;

				case 'z':
				break;

				case 'c':
				break;

			} //end switchcase
		}

		public void keyPressed (KeyEvent e) {

			
 
		} //end keyPressed

		public void keyReleased (KeyEvent e) {


		} //end keyReleased 

		public void keyTyped (KeyEvent e) {
			char c = e.getKeyChar();
			System.out.println("keyPressed, c= " + c);
			trail.moving(Graphics g);

		} //end keyTyped
		
	} //end DerpPanel
	
} //end Trail
	

