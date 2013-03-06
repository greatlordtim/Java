// Pacman.java
// Author: Jimmy Liu
// 3 March, 2013
// Yolo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pacman {
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	DerpPanel np;			// KeyListener, FocusListener panel with text field
	int[][] array = new int[10][10];

	
	public Pacman () {
	
	}
	
	public static void main(String[] args) {
		Pacman pacman = new Pacman();
		pacman.Run();
	} //end public void
	
	
	public void Run() {
		frame = new JFrame("Pacman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create DerpPanel and add to JFrame
		np = new DerpPanel();
		frame.getContentPane().add(np, BorderLayout.CENTER);
						
		frame.setSize(500, 500);		// explicitly set size in pixels
		frame.setLocation(500,300);	// set location on my screen
		frame.setVisible(true);		// set to true to make visible
		for(int i=0; i < 10; i++)
		{
			for(int j=0; j < 10; j++)
			{
				array[i][j] = 1;
			}
		}
		
	} //end Run()
	
	class DerpPanel extends JPanel implements KeyListener {
		
		public DerpPanel() {
			frame.addKeyListener(this); //hi
		} //end public DerpPanel
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(move == 0) //if first move, draw square in the center
			{
				g.fillRect(49*5,49*5,5,5); //center square
			}


			
			for(int i=0; i < 100; i++)
			{
				for(int j=0; j < 100; j++)
				{
					if(array[i][j] < 255)
					{
						Color myColor = new Color(array[i][j], array[i][j], array[i][j]); //sets color
						g.setColor(myColor);
						g.fillRect((i)*5, (j)*5, 5, 5); //fill the rectangle, 5x5
					}
				}
			}


			


		} //end paintComponent

		

		public void keyPressed (KeyEvent e) {
			//nothing to do here
		} //end keyPressed

		public void keyReleased (KeyEvent e) {
			//nothing to do here
		} //end keyReleased 

		public void keyTyped (KeyEvent e) {
			char c = e.getKeyChar();
			System.out.println("keyPressed, c= " + c);
			switch (c) { //Switch case for getting what direction the user wants to go
				case 'a': 
				x--;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'd':
				x++;
				array[x][y] = 0;
				move++;
				break;

				case 'w':
				y--;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'x':
				y++;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'q':
				x--;
				y--;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'e':
				x--;
				y++;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'z':
				x++;
				y--;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'c':qeqeq
				x++;
				y++;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

			}
			
			for(int i=0; i < 100; i++) //fading effect for squares
			{
				for(int j=0; j < 100; j++)
				{
					if(array[i][j] < 255) //if not white
					{
						array[i][j]+=5; //add 5 rgb to it
					}
				}
			}
			repaint();	//repaint after movement

		} //end keyTyped
		
	} //end DerpPanel
	
} //end Trail
