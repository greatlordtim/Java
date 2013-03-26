// Me.java
// Author: Jimmy Liu
// March 20, 2013
// This program is about me. Not about you. It's about me. ME.

// Class Methods:
// 	Run: Creates the JFrame and JPanel, set's it visable
//  GetMyImage: Gets the BufferedImage in a try catch loop. Catch's system errors, and prints out error
//  paintComponent: Get's the images, and has a switch statement that assigns a image per slide. Images are drawn out of the sprites using the getSubimage
//  class. Also sets a color called "colr", which is a gray with a 75% opacity. Font is set as Helvetica, for love of Swiss typography.

// Class Variables:
// 	image2: A buffered image sprite that includes all the images that is used in the program. 
// 	slide: A count of what slide the program is on. Default is one, click = +1, if reaches 6, reset to 1
// 	imageName: Name of the image (which is sprite.png)
//  timer: The

import java.awt.*;			
import java.awt.event.*;	
import javax.swing.*;	
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Me {
 
	private JFrame frame;
	private DrawingArea canvas;
	BufferedImage image2;
	int slide = 1;
	int w = 1;
	Timer timer;

	private String imageName = "sprite.png"; //create a variable for sprite image
	
	public Me()   { }
	
	public static void main (String[] args) {
		Me me = new Me();
		me.Run();
	}
 
	public void Run( )  {
		// Create the JPanel canvas
		canvas = new DrawingArea ( );
		canvas.setBackground(Color.gray);
		
		// Get the Image from a file
		GetMyImage();

		// Create the JFrame and add the JPanel
		frame = new JFrame("About Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas); //Add ContentPane 
		frame.setBackground(Color.gray);
		frame.setSize(500, 501); //500x500 JFrame
		frame.setLocation(300, 0);
		frame.setVisible(true); //set JFrame visable
	}

	public void GetMyImage() { //Fetch the sprite sheet png. If error, print out error.
		try { image2 = ImageIO.read(new File(imageName));} catch (IOException e) {System.err.println("File was not found"); System.exit(1);}
	} //end GetMyImage
	
	// canvas 
	class DrawingArea extends JPanel implements MouseListener {

		public DrawingArea ()   { 
			addMouseListener (this);
			Slider slider = new Slider();
            timer = new Timer(15, slider);
            timer.start();
			} //add mouse listener to panel

		public void paintComponent ( Graphics g ) {
			Color colr = new Color(75,75,75,200); //Creating a new beautiful color
			g.setColor(colr); 
			g.setFont(new Font("Helvetica", Font.BOLD, 26)); //Swiss typography
			switch (slide) {
				case 1: // case 1: About me
					g.drawImage(image2.getSubimage(515, 5, 500, 500), 0, 0, 500, 500, this); //get image from sprite
					g.fillRect(0, 300, 500, 200); //fill rectangle
					g.setColor(Color.white); 
					g.drawString("Hi, my name is Jimmy Liu", 20, 330); //draw my strings!
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("I was born in the busy city of Beijing, China. I've moved to the United States", 20, 360);
					g.drawString("when I was very young, and have lived here since. I am currently 15 years", 20, 380);
					g.drawString("old, and my birthday is in Januarary. Let's learn a bit more about me", 20, 400);
				break;

				case 2: // case 2: What I love, computers
					g.drawImage(image2.getSubimage(2125, 5, 500, 500), 0, 0, 500, 500, this); //get image from sprite
					g.fillRect(0, 300, 500, 200); //fill rectangle
					g.setColor(Color.white); 
					g.drawString("I love computers", 20, 330); //draw my strings!
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("My love for computers started when I was 5, and my dad introduced me to", 20, 360);
					g.drawString("one. I love electronics, computers, and other eletronic gizmos. I also", 20, 380);
					g.drawString("love programming. My main focus is web devlopment, using languages", 20, 400);
					g.drawString("such HTML, CSS, Javascript, and PHP. I also utilize tools such as", 20, 420);
					g.drawString("Bootstrap, jQuery, node.js, and more.", 20, 440);
				break;

				case 3: // case 3: I love design
					g.drawImage(image2.getSubimage(2635, 5, 500, 500), 0, 0, 500, 500, this); //get image from sprite
					g.fillRect(0, 300, 500, 200); //fill rectangle
					g.setColor(Color.white);
					g.drawString("I love design", 20, 330); //draw my strings!
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("My strange lust in typography and elegant organization makes me love", 20, 360);
					g.drawString("design. I believe that simplicity is the ultimate sophistacation. I", 20, 380);
					g.drawString("currently specialize in web and print design. My tools for design are", 20, 400);
					g.drawString("Adobe Photoshop and Dribbble for inspiration.", 20, 420);
				break;

				case 4: // case 4: What I love, brother
					g.drawImage(image2.getSubimage(1025, 5, 500, 500), 0, 0, 500, 500, this); //get image from sprite
					g.fillRect(0, 300, 500, 200); //fill rectangle
					g.setColor(Color.white);
					g.drawString("I love my brother", 20, 330); //draw my strings!
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("My brother's name is Tommy, and he is currently 4 years old. He's ", 20, 360); 
					g.drawString("quite cute, and I love him a lot. We love spending time together", 20, 380);
					g.drawString("and although I am far busier than he is, we always find time to do", 20, 400);
					g.drawString("so. My brother is the best!", 20, 420);
				break;

				case 5: // case 5: TV Show, house of cards
					g.drawImage(image2.getSubimage(5, 5, 500, 500), 0, 0, 500, 500, this); //get image from sprite
					g.fillRect(0, 300, 500, 200); //fill rectangle
					g.setColor(Color.white);
					g.drawString("I love House of Cards", 20, 330); //draw my strings
					g.setFont(new Font("Helvetica", Font.PLAIN, 14));
					g.drawString("In terms of TV Shows, House of Cards would be one of my favorites.", 20, 360);
					g.drawString("It's a political drama produced by Netflix, and it's absoutely", 20, 380);
					g.drawString("brilliant. It's realistic show, with seeps of darkness from real", 20, 400);
					g.drawString("politics. Everybody should watch House of Cards", 20, 420);
				break;
			}
			g.setColor(Color.white);
			g.fillRect(0, 475, w, 3);
		} //end paint compeoennt


		private class Slider implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				w++;
				if (w==500) {slide++;w = 1;
					if (slide==6) slide = 1;
				}
				repaint();
			} //end action performed
		} //end Slider

		public void mousePressed ( MouseEvent e )   {}
		public void mouseClicked ( MouseEvent e )    {slide++; if (slide == 6) slide = 1; w = 1;repaint();} //incremenets slide per click. If slide is 6, makes cycles back.
		public void mouseReleased ( MouseEvent e )    {}
		public void mouseEntered ( MouseEvent e )    {timer.start();}
		public void mouseExited ( MouseEvent e )    {timer.stop();}
	} //end Run
} //end program