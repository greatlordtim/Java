// Anindit Gopalakrishnan
// March 21, 2013
// Me.java 
//This program will have a mini slideshow about 

import java.awt.*;			// for classes Image, Graphics, Color
import java.awt.event.*;	// for classes KeyListener, MouseListener
import javax.swing.*;		// for class JFrame
import java.io.*;
import javax.imageio.*;


public class Me {
 
	private JFrame frame;
	private MePanel panel;		// JPanel to draw images
	////////////////////////////////////////////////////////
	// Declare image object
	Image[] images  = new Image[5];
	int showPic = 0;
	boolean allInitialized = true;
	
	public static void main (String[] args) {
		Me si = new Me();
		si.Run();
	}
 
	public void Run( )  {
		// Create the JPanel canvas
		panel = new MePanel();
		
		// Get the Image from a file
		GetMyImage();

		// Create the JFrame and add the JPanel
		frame = new JFrame("Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add( panel );
		frame.setBackground(Color.gray);
		frame.setSize(700, 520);
		frame.setLocation(300, 0);
		frame.setVisible(true);
	}

	public void GetMyImage() {
		///////////////////////////////////////////////////
		// Create a try-catch block for loading the image
		try{
			images[0] = ImageIO.read(new File("Jeffrey.jpg"));
			images[1] = ImageIO.read(new File("Kevin.jpg"));
			images[2] = ImageIO.read(new File("Allana.jpg"));
			images[3] = ImageIO.read(new File("Sindu.jpg"));
			images[4] = ImageIO.read(new File("Giselle.jpg"));

		}catch(IOException e){
			System.err.println("File was not found " );
			allInitialized = false;
			System.exit(1);
			
		}
	}
	
	// canvas 
	class MePanel extends JPanel implements MouseListener {
		public MePanel ( )   {
			addMouseListener (this);
		}

		public void paintComponent ( Graphics g ) {
			if (allInitialized) g.drawImage(images[showPic%5], 0, 0, 700 ,500, this);
		}

		// Mouse methods
		public void mousePressed ( MouseEvent e )   {
			showPic ++;
			repaint();
		}
		public void mouseClicked ( MouseEvent e )    {}
		public void mouseReleased ( MouseEvent e )    {}
		public void mouseEntered ( MouseEvent e )    {}
		public void mouseExited ( MouseEvent e )    {}
		
		// Key methods
		
	}
}

