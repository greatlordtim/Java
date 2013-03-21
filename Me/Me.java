// Me.java
// Author: Jimmy Liu
// March 20, 2013
// This program is about me. Not about you. It's about me. ME.

import java.awt.*;			
import java.awt.event.*;	
import javax.swing.*;	
import java.io.*;
import javax.imageio.*; 

public class Me {
 
	private JFrame frame;
	private DrawingArea canvas;
	Image image;

	private String imageName = "calvin.jpg";
	
	public Me ( )   {

	}
	
	public static void main (String[] args) {
		Me me = new Me();
		me.Run();
	}
 
	public void Run( )  {
		// Create the JPanel canvas
		canvas = new DrawingArea ( );
		canvas.setBackground( Color.gray );
		
		// Get the Image from a file
		GetMyImage();

		// Create the JFrame and add the JPanel
		frame = new JFrame("About Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add( canvas );
		frame.setBackground(Color.gray);
		frame.setSize(500, 500);
		frame.setLocation(300, 0);
		frame.setVisible(true);
	}

	public void GetMyImage() {
		try {
			image = ImageIO.read(new File(imageName));
		} catch (IOException e) {System.err.println("File was not found"); System.exit(1);}
	}
	
	// canvas 
	class DrawingArea extends JPanel implements MouseListener {

		public DrawingArea ( )   {
			addMouseListener (this);
		}

		public void paintComponent ( Graphics g ) {

			g.drawImage(image, 5, 5, 30, 30, this);

		}

		// Mouse methods
		public void mousePressed ( MouseEvent e )   {}
		public void mouseClicked ( MouseEvent e )    {}
		public void mouseReleased ( MouseEvent e )    {}
		public void mouseEntered ( MouseEvent e )    {}
		public void mouseExited ( MouseEvent e )    {}
		
	}
}