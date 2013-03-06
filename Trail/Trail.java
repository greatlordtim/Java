// Jimmy Liu
// February 27, 2013
// Trail.java
// The trail starts fading after a X ammount of moves by the user.
// This program starts a JFrame and has a window, where the user uses his keyboard to control a "trail", and move it around. 

// Class Methods:
// Run: Creates a new JFrame called "frame" with the title "Trail". Adds a JPanel called "DerpPanel" to JFrame. Tells JFrame to exit when closing the
//       program. Set JFrame size to 500x500. Fill the array array "array" with 255, which is white. Set BorderLayout to center.
// paintComponent: If move =0, fill the center with the beginning trail. Otherwise, paints the current ones that are drawn, and assign the correct colors
//                 to the block. 
// keyTyped: A switch case is made for getting what the user presses and changing the array so that movement is recorded. Assign color to the new movement,
//           and repaint the canvas when it is ready.


// Class Variables: 
// move: Records the move number, so if it's the first one, we paint the middle square that starts
// x: The x location of the square
// y: The y location of the square
// array: Main array, 100x100 that records the color of the squares in the window. Since each square is 5x5, each array represents a square. It gets the 
//        color. Default color is 255, which is white, then changes it to 0 when it needs to be black.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Trail {
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	DerpPanel np;			// KeyListener, FocusListener panel with text field
	int[][] array = new int[100][100];

	int move = 0;
	int x = 49;
	int y =49;
	
	public Trail () {
	
	}
	
	public static void main(String[] args) {
		Trail trail = new Trail();
		trail.Run();
	} //end public void
	
	
	public void Run() {
		frame = new JFrame("Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create DerpPanel and add to JFrame
		np = new DerpPanel();
		frame.getContentPane().add(np, BorderLayout.CENTER);
						
		frame.setSize(500, 500);		// explicitly set size in pixels
		frame.setLocation(500,300);	// set location on my screen
		frame.setVisible(true);		// set to true to make visible
		for(int i=0; i < 100; i++)
		{
			for(int j=0; j < 100; j++)
			{
				array[i][j] = 255;
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
				g.fillRect(49*5,49*5,5,5); 
				//center square
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

				if (x==0) { //checks if going outside of grid
					repaint();
					break;
				}

				x--;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'd':

				if (x==99) { //checks if going outside of grid
					
					break;
				}

				x++;
				array[x][y] = 0;
				move++;
				break;

				case 'w':
				if (y==0) { //check if giong outside of grid
					
					break;
				}
				y--;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'x':

				if (y==99) { //checks if going outside of grid
					
					break;
				}
				y++;
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'q': 
				if(x>0&&y>0) //if inside, move. If outsidfe of grid, don't. 
				{	
					x--;
					y--;
				}
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'e':
				if(x<99&&y>0) //if inside, move. If outsidfe of grid, don't. 
				{
					x++;
					y--;
				}

				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'z':
				if(x>0&&y<100) //if inside, move. If outsidfe of grid, don't. 
				{	
					x--;
					y++;
				}
				array[x][y] = 0; //make it black
				move++; //increment move
				break;

				case 'c':
				if(x<99&&y<99) //if inside, move. If outsidfe of grid, don't. 
				{
					x++;
					y++;
				}
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
