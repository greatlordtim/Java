// Jimmy Liu
// February 6th 2013
// Web.java
// An example of adding mouse events.


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Web {

	JFrame frame;			// JFrame and JPanel must be global object instances
	MyPanel panel;
	
	public static void main(String[] args) {
		Web w = new Web();
		w.Run();
	}

	public void Run() {
		frame = new JFrame("My Third JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel and add to frame
		
		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);	// add panel to frame
		
		//////////////////////////////////////////////
		// >>> MANDATORY: must addMouseListener to JPanel
		frame.addMouseListener(panel);

		frame.setResizable(false);
		frame.setSize(600, 700);		// explicitly set size in pixels
		frame.setVisible(true);		// set to false to make invisible
		
	}

}	// end class SimpleJFrame2

// Create a JPanel class
class MyPanel extends JPanel implements MouseListener {

	private int xloc, yloc;		// x and y locations of oval
	private int width, height;	// width and height of JPanel
	private Color cOval;		// color of oval
	private int colorCount;		// color counter for oval
	private int verts = 0;
	private int[][] web = new int[2][21];
	
	public MyPanel() {
		xloc = yloc = 100;
		cOval = Color.red;
		colorCount = 0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	// execute the superclass method first
		width = getWidth();			// width of JPanel
		height = getHeight();		// height of JPanel
		
		// Set background color
		setBackground(Color.white);
		
		// Draw blue rectangle
		
		g.setColor(Color.black);
		g.fillRect(0, 102, width, height);

		g.setColor(Color.blue);

		for(int i = 0; i < 5; i ++) {
			g.fillRect(width*i/5 + 2, 0, width/5 - 2, 100);
		}
		
		// Draw Labels
		g.setColor(Color.red);

		for(int j = 1; j < 6; j ++) {
			g.setFont(new Font("Helvetica", Font.ITALIC, 60));	// font name, style, size
			g.drawString("" + j * 4, width*(j-1)/5 + 30, 70);
		}

		g.setColor(Color.white);

		for(int e = 0; e < web.length; e ++) {
			for(int r = 0; r < verts; r ++) {

				web[e][r] = 0;
			}
		}

		for(int f = 0; f < web.length; f ++) {
			for(int d = 0; d < verts; d ++) {

				web[f][d] = (int)(Math.random() * 500);
			}
		}
		
		// offset all y-axis points by 100 pixels
		int qwerty = 0;
		while(qwerty < 21) {

			web[1][qwerty] = web[1][qwerty] + 150;
			qwerty ++;
		}

		// offset all x-axis points by 100 pixels
		int q = 0;
		while(q < 21) {

			web[0][q] = web[0][q] + 50;
			q ++;
		}
		
		// draw the web
		for(int a = 0; a < web[0].length; a ++) {
			for(int b = 0; b < verts; b ++) {
				g.drawLine(web[0][a], web[1][a], web[0][b], web[1][b]);
			}
		}
		


	}	// end paintComponent

	public void mousePressed (MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

			if(y < 100) {
				if(x < width/5) {
					verts = 4;
					repaint();
				}
				if(x > width/5 && x < width*2/5) {
					verts = 8;
					repaint();
				}
				if(x > width*2/5 && x < width*3/5) {
					verts = 12;
					repaint();
				}
				if(x > width*3/5 && x < width*4/5) {
					verts = 16;
					repaint();
				}
				if(x > width*4/5 && x < width) {
					verts = 20;
					repaint();
				}
				System.out.println("mousePressed x = " + x + "   y = " + y + "   vertices = " + verts);
			}

	}
		 //repaint is inside the class jPanel	
	
	public void mouseClicked (MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
	
}	// end class MyPanel

// Exercises:
//	1. Use e.getX() and e.getY() in mousePressed to position the oval
//	2. Implement more colors from package java.awt and class Color


