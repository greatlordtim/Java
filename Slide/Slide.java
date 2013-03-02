//Slide.java


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Slide{
	
	JFrame frame;			// JFrame and JPanel must be global object instances
	MyPanel panel;			// KeyListener, FocusListener panel with text field
	File aFile;
	int inputInt;
	int[][] array = new int[4][4];
	
	
	public Slide () {
		aFile = new File("puzzle.txt");
		inputInt = 0;
	}
	
	public static void main(String[] args) {
		Slide game = new Slide();
		game.Run();
	} //end public void
	
	
	public void Run() {
		frame = new JFrame("Slide");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create North JPanel and add to JFrame
		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
						
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
			printButtons(g);
			printGrid(g);
		} //end paintComponent
		public void printButtons(Graphics g)
		{
			g.setColor(Color.black);
			g.drawRect(25, 10, 150, 100); //reset
			g.drawString("RESET", 90, 50);
			g.drawRect(175, 10, 150, 100); //random
			g.drawString("RANDOM", 225, 50);
			g.drawRect(325, 10, 150, 100); //alpha
			g.drawString("ALPHA", 375, 50);
			repaint();
		}
		public void printGrid(Graphics g)
		{
			Scanner input = null;
			try
			{
				input = new Scanner(aFile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found.");
			}
			if(input.hasNext())
			{
				for(int i=0; i < 4; i++)
				{
					for(int j=0; j < 4; j++)
					{
						inputInt = input.nextInt();
						g.drawRect(45+(i)*90, 140+(j)*90, 110, 110);
						if(inputInt != 0)
							g.drawString(""+inputInt, (i+1)*95, (j+2)*100);
					}
				}
				
			}
		}
		public void keyPressed (KeyEvent e) {

			
 
		} //end keyPressed

		public void keyReleased (KeyEvent e) {


		} //end keyReleased 

		public void keyTyped (KeyEvent e) {

		} 
	} 
} 