//Slide.java


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Slide{
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	Panel MyPanel;			// KeyListener, FocusListener panel with text field
	int[][] array = new int[4][4];
	
	
	public Slide () {
	
	}
	
	public static void main(String[] args) {
		Slide game = new Slide();
		game.Run();
	} //end public void
	
	
	public void Run() {
		frame = new JFrame("Slide");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create North JPanel and add to JFrame
		MyPanel = new Panel();
		frame.getContentPane().add(np, BorderLayout.CENTER);
						
		frame.setSize(500, 600);		// explicitly set size in pixels
		frame.setLocation(500,300);	// set location on my screen
		frame.setVisible(true);		// set to true to make visible
	} //end Run()
	
	class MyPanel extends JPanel implements KeyListener {
		
		public MyPanel() {
			frame.addKeyListener(this);
		} //end public MyPanel
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		} //end paintComponent
		public void keyPressed (KeyEvent e) {

			
 
		} //end keyPressed

		public void keyReleased (KeyEvent e) {


		} //end keyReleased 

		public void keyTyped (KeyEvent e) {

		} 
	} 
} 