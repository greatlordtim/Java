// Pacman.java
// Author: Jimmy Liu
// 3 March, 2013
// Yolo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Pacman {
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	DerpPanel np;			// KeyListener, FocusListener panel with text field
	GridPanel gp;
	int[][] array = new int[10][10];
	int move = 0;
	int xloc, yloc; //pacman x and y
	private JLayeredPane lpane = new JLayeredPane();

	
	public Pacman () {
	
	}
	
	public static void main(String[] args) {
		Pacman pacman = new Pacman();
		pacman.Run();
	} //end public void
	
	
	public void Run() {
		frame = new JFrame("Pacman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		 //create blue border
		
		// Create DerpPanel and add to JFrame
		

		gp = new GridPanel();
		

		np = new DerpPanel();
		
		//stand back, I'm doing science
        frame.setSize(new Dimension(500, 560));
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 500, 500);
        np.setBounds(0, 0, 500, 560);
        np.setOpaque(false);
        gp.setBounds(0, 0, 500, 500);
        gp.setOpaque(true);
        lpane.add(gp, new Integer(0), 0);
        lpane.add(np, new Integer(1), 0);
        frame.setVisible(true);
        gp.setBorder(BorderFactory.createLineBorder(Color.blue, 8));



		

		for(int i=0; i < 10; i++)
		{
			for(int j=0; j < 10; j++)
			{
				array[i][j] = 1;
			}
		}
		
	} //end Run()

	class GridPanel extends JPanel {

		public GridPanel() {

		} //end public GridPanel

		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
   			g.setColor(Color.lightGray);
			g2.setStroke(new BasicStroke(3));

			for (int col = 0; col < 10; col++)  {
        		for (int row = 0; row < 10; row++) {
					g2.drawRect(row * 48+10, col * 48+10, 48, 48);
        		}
   			 }

		} //end paintComponennt


	} //end GridPanel
	
	class DerpPanel extends JPanel implements KeyListener {
		
		public DerpPanel() {
			frame.addKeyListener(this); //hi
		} //end public DerpPanel
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//red bottom
			g.setColor(Color.red);
   			g.fillRect(0, 500, 560, 60);
   			g.setColor(Color.black);
   			g.setFont(new Font("Helvetica", Font.BOLD, 20));
   			g.drawString("Directions: Ohai", 20, 530);
   			//end red bottom

   			if (move==0) { //first turn pacman generate
   				xloc = 0 + (int)(Math.random() * ((9 - 0) + 1));
   				yloc = 0 + (int)(Math.random() * ((9 - 0) + 1));
   				array[xloc][yloc] = 4;

   				for (int z = 0; z < 6; z++) {
   					int cheesex = 0 + (int)(Math.random() * ((9 - 0) + 1));
   					int cheesey = 0 + (int)(Math.random() * ((9 - 0) + 1));
   					array[cheesex][cheesey] = 3;
				} //end while

				for (int z = 0; z < 6; z++) {
   					int ghostx = 0 + (int)(Math.random() * ((9 - 0) + 1));
   					int ghosty = 0 + (int)(Math.random() * ((9 - 0) + 1));
   					array[ghostx][ghosty] = 2;
				} //end while

   				move++;
   				
   			} //end pacman

   			




   			//printing array
   			for(int i=0; i < 10; i++) {
				for(int j=0; j < 10; j++) {
					int a = array[i][j];

					if (a == 4) { //pacman
						g.setColor(Color.black);
						g.fillRect((i+1) * 48, (j+1) * 48, 5, 5);
					}

					if (a == 3) { //ghost
						g.setColor(Color.blue);
						g.fillRect((i+1) * 48, (j+1) * 48, 5, 5);
					}

					if (a == 2) { //cheese
						g.setColor(Color.yellow);
						g.fillRect((i+1) * 48, (j+1) * 48, 5, 5);
					}

				}
			}


			/*if(move == 0) //if first move, draw square in the center
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
			}*/


			


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
				array[xloc-1][yloc] = 4;
				array[xloc][yloc]=1;
				xloc = xloc-1;
				repaint();
				
				break;

				case 'd':

				repaint();
				
				break;

				case 'w':

				repaint();
				
				break;

				case 's':

				repaint();
				
				break;

				case 'r':

				break;
			}
			repaint();	//repaint after movement

		} //end keyTyped
		
	} //end DerpPanel
	
} //end Trail
