//Anindit Gopalakrishnan
//3/1/13
//Trail.java
//This program will move a box around the screen and show its trail.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Trail extends JPanel {
	public static void main(String[] args){
		
		//Sets up the JFrame for the program
		JFrame frame = new JFrame("Trail");
		frame.setSize(512,531);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TrailPanel p = new TrailPanel();
		frame.getContentPane().add(p, BorderLayout.CENTER);
		frame.addKeyListener(p);
		frame.setVisible(true);

	}


}
class TrailPanel extends JPanel implements KeyListener{
	int[][] trailPoints = new int[80][2]; //this array holds all the trail points that have been drawn
	int[] color = new int [80]; //this array holds all the colors that are used for 
								//the varying shades of gray after the trail starts to fade
	Point movingPoint= new Point(250,250); //this is the head point of the trail
	int direction = 9000; //this is the direction that the head will move - different integers 
						  //code for different directions - 9000 isn't one, thats why i set it to that
						  //so it doesn't move on the first try
	boolean moving = false; //whether or not the trail is moving or not
	int ma = 5; //the move amount
	int counted = 0; // the number of blocks to draw for the trail
	public  TrailPanel(){
		for (int i = 0; i < 80; i++){ //initializes all the integers to 9000, so there won't be any nullPointer exceptions
			trailPoints[i][0] = 9000; 
			trailPoints[i][1] = 9000;
			color[79-i] =  i *255/80; //initializes the color array to the varying shades of gray
		}
		trailPoints[0][0] = 250; //initializes the "head" point to the center of the screen
		trailPoints[0][1] = 250;
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.white);
		
		g.setColor(Color.black);
		g.fillRect(0,0,500,4); //draws the boundary of the trail area
		g.fillRect(0,0,4,500);
		g.fillRect(496,0,4,500);
		g.fillRect(0,496,500,4);
		
		g.fillRect((int)movingPoint.getX(), (int)movingPoint.getY(), 5, 5); //draws the headPoint of the trail
		
		for (int i = 0; i < counted; i++){ //draws all the blocks that the trail is made of
			
				int c = color[79 - counted + i]; //sets the color to varying shades of gray right from the beginning
				g.setColor(new Color(c ,c, c ));
		
				g.fillRect(trailPoints[i][0], trailPoints[i][1], 5,5);
		}
		
		
	}

	public void keyPressed(KeyEvent e){
		char c = e.getKeyChar();
		moving = true;
		switch (c){ //sets the direction to the corresponding way the letter should make the trail move
			case 'a': direction = 0; break;
			case 'q': direction = 1; break;
			case 'w': direction = 2; break;
			case 'e': direction = 3; break;
			case 'd': direction = 4; break;
			case 'c': direction = 5; break;
			case 'x': direction = 6; break;
			case 'z': direction = 7; break;
			default: direction = 9000; moving = false; break; //if invalid key pressed, do these things
		}
		if (moving ){ //only if moving, do I want the blocks to actually move
			
			 move(direction);
		}
		
			
		repaint();
		
	}
	public void keyReleased(KeyEvent e){
	}
	public void keyTyped(KeyEvent e){
	}
	public void move(int m){
		Point tempPoint = new Point((int)movingPoint.getX(), (int)movingPoint.getY()); //there are cases where the trail does not move, so in those cases i want to check if it did or not
		switch (m) {
			case 0: 
				if ( (movingPoint.getX() -ma > 4 )) //checks if it doesnt go off the screen on the left
					movingPoint.setLocation(movingPoint.getX() - ma, movingPoint.getY());
				break;
			case 1:
				if((movingPoint.getY() -ma > 4)&&(movingPoint.getX() -ma > 4)) //checks for top and left
					movingPoint.setLocation(movingPoint.getX() - ma, movingPoint.getY() - ma);
				break;	
			case 2: 
				if((movingPoint.getY() -ma > 4 ))//checks for top
					movingPoint.setLocation(movingPoint.getX(), movingPoint.getY() - ma);
				break;
			case 3:
				if ((movingPoint.getX() +ma < 495) &&(movingPoint.getY() -ma > 4 )); //checks right and top
					movingPoint.setLocation(movingPoint.getX() + ma, movingPoint.getY() - ma);
				
				break;
			case 4: 
				if ((movingPoint.getX() +ma < 495)) //checks right
					movingPoint.setLocation(movingPoint.getX() + ma, movingPoint.getY());
					break;
			case 5:
				if ((movingPoint.getX() +ma < 495) && (movingPoint.getY()+ma < 495))//checks for right and bottom
					movingPoint.setLocation(movingPoint.getX() + ma, movingPoint.getY() + ma);
				break;	
			case 6: 
				if ((movingPoint.getY()+ma < 495)) //checks bottom
					movingPoint.setLocation(movingPoint.getX()  , movingPoint.getY()+ma);
				break;
			case 7:
				System.out.println(movingPoint.getX());
				if (((movingPoint.getX() -ma) > 3) && ((movingPoint.getY()+ma) < 495)); //checks left and bottom
					
					movingPoint.setLocation(movingPoint.getX() - ma, movingPoint.getY() + ma);
					System.out.println("hi");
				break;	
			case 9000: movingPoint.setLocation(movingPoint.getX(), movingPoint.getY());
		}
		if (tempPoint.getX() != movingPoint.getX() || tempPoint.getY() != movingPoint.getY()){//only if the point moved, do these things
			if (counted < 79) counted ++; //counted cant be more than 80, or it references a
										  //nonexistent part of the array

			trailPoints[counted][0] = (int) movingPoint.getX(); //adds the head point to the trailPoints array
			trailPoints[counted][1] = (int) movingPoint.getY();

			if (counted == 79){ //if the trail reaches 80, shift the whole array over so as to leave space for a new Point to be entered.
				for (int i = 0; i <79; i ++){
					trailPoints[i][0] = trailPoints[i+1][0]; 
					trailPoints[i][1] = trailPoints[i+1][1]; 

				}
			}
		}
	}
}
