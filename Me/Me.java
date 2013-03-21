// Me.java
// Author: Jimmy Liu
// March 20, 2013
// This program is about me. Not about you. It's about me. ME.

import java.awt.*;			
import java.awt.event.*;	
import javax.swing.*;	
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.net.*;

public class Me {
 
	private JFrame frame;
	private DrawingArea canvas;
	int slide = 1;
	BufferedImage image2;

	private String imageName = "sprite.png";
	
	public Me ( )   { }
	
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
			image2 = ImageIO.read(new File(imageName));
		} catch (IOException e) {System.err.println("File was not found"); System.exit(1);}
	} //end GetMyImage
	
	// canvas 
	class DrawingArea extends JPanel implements MouseListener {

		public DrawingArea ( )   {
			addMouseListener (this);
		}

		public void paintComponent ( Graphics g ) {
			Color colr = new Color(75,75,75,200);
			g.setColor(colr);
			g.setFont(new Font("Helvetica", Font.BOLD, 26));
			switch (slide) {
				case 1: // case 1: About me
					g.drawImage(image2.getSubimage(515, 5, 500, 500), 0, 0, 500, 500, this);
					g.fillRect(0, 300, 500, 200);
					g.setColor(Color.white);
					g.drawString("Hi, my name is Jimmy Liu", 20, 330);
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("I was born in the busy city of Beijing, China. I've moved to the United States", 20, 360);
					g.drawString("when I was very young, and have lived here since. I am currently 15 years", 20, 380);
					g.drawString("old, and my birthday is in Januarary. Let's learn a bit more about me", 20, 400);
				break;

				case 2: // case 2: What I love, computers
					g.drawImage(image2.getSubimage(2125, 5, 500, 500), 0, 0, 500, 500, this);
					g.fillRect(0, 300, 500, 200);
					g.setColor(Color.white);
					g.drawString("I love computers", 20, 330);
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("My love for computers started when I was 5, and my dad introduced me to", 20, 360);
					g.drawString("one. I love electronics, computers, and other eletronic gizmos. I also", 20, 380);
					g.drawString("love programming. My main focus is web devlopment, using languages", 20, 400);
					g.drawString("such HTML, CSS, Javascript, and PHP. I also utilize tools such as", 20, 420);
					g.drawString("Bootstrap, jQuery, node.js, and more.", 20, 440);
				break;

				case 3: // case 3: I love design
					g.drawImage(image2.getSubimage(2635, 5, 500, 500), 0, 0, 500, 500, this);
					g.fillRect(0, 300, 500, 200);
					g.setColor(Color.white);
					g.drawString("I love design", 20, 330);
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("My strange lust in typography and elegant organization makes me love", 20, 360);
					g.drawString("design. I believe that simplicity is the ultimate sophistacation. I", 20, 380);
					g.drawString("currently specialize in web and print design. My tools for design are", 20, 400);
					g.drawString("Adobe Photoshop and Dribbble for inspiration.", 20, 420);
				break;

				case 4: // case 4: What I love, brother
					g.drawImage(image2.getSubimage(1025, 5, 500, 500), 0, 0, 500, 500, this);
					g.fillRect(0, 300, 500, 200);
					g.setColor(Color.white);
					g.drawString("I love my brother", 20, 330);
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("My brother's name is Tommy, and he is currently 4 years old. He's ", 20, 360);
					g.drawString("quite cute, and I love him a lot. We love spending time together", 20, 380);
					g.drawString("and although I am far busier than he is, we always find time to do", 20, 400);
					g.drawString("so. My brother is the best!", 20, 420);
				break;

				case 5: // case 5: TV Show, house of cards
					g.drawImage(image2.getSubimage(5, 5, 500, 500), 0, 0, 500, 500, this);
					g.fillRect(0, 300, 500, 200);
					g.setColor(Color.white);
					g.drawString("I love House of Cards", 20, 330);
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("In terms of TV Shows, House of Cards would be one of my favorites.", 20, 360);
					g.drawString("It's a political drama produced by Netflix, and it's absoutely", 20, 380);
					g.drawString("brilliant. It's realistic show, with seeps of darkness from real", 20, 400);
					g.drawString("politics. Everybody should watch House of Cards", 20, 420);
				break;
			}
		}

		// Mouse methods
		public void mousePressed ( MouseEvent e )   {}
		public void mouseClicked ( MouseEvent e )    {
			slide++;
			if (slide == 6) { slide = 1; }
			repaint();
		}
		public void mouseReleased ( MouseEvent e )    {}
		public void mouseEntered ( MouseEvent e )    {}
		public void mouseExited ( MouseEvent e )    {}
		
	} //end Run
} //end program