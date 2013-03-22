//11/15/2012
//This class will instantiate a helicopter object  The helicopter will be able to move up and down, 
//clicked to move up and nothing to move down.

import java.awt.*;
import java.awt.event.*;
public class Helicopter extends Rectangle implements  MouseListener{
 	private int x; //holds x position
 	private double y; //holds y position - double to accomodate for better moving
 	boolean dead = false; //holds if the helicopter is dead
 	boolean goUp= false;
 	int move = 1;
 	
	public Helicopter (int xP, double yP){
	  	setPosition(xP, yP);
	}
	void setPosition(int xP, double yP){ //sets position of the helicopter - 
		x = xP;
		y = yP;
		this.setBounds(x,(int)y,80,60); 
	}
	void move(double moveBy){ // moves the helicopter up or down based on moveBy, can be negative
		if (move%2 == 0){
		if (!goUp){
			y += moveBy;
		}
		else{
			y-=moveBy+.1;
		}}
	}

	void drawShip(Graphics g){
		/*g.fillRect(x,(int)y,10,30);
		g.fillRect(x+20, (int)y+15, 30, 15);
		g.fillOval(x+50, (int)y + 10, 38,30);*/
	g.setColor(Color.BLACK);
		g.fillRect(x, (int)y, 7, 20);
		g.fillRect(x+7, (int)y+13, 33, 7);
		g.fillOval(x+35, (int)y -2, 40,30);
		
		g.fillRect(x+54, (int)y-4, 5, 5);
		g.fillRect(x+30, (int)y-7, 50, 4);
		g.fillRect(x+45, (int) y+ 26, 3,5);
		g.fillRect(x+62, (int) y+ 26, 3,5);
		g.fillRect(x+33,(int) y + 30, 40,3);
		g.drawLine(x + 16, (int) y + 1, x - 9, (int)y + 9); 
		g.drawLine(x + 16, (int) y + 2, x - 9, (int)y + 10); 
		g.setColor(Color.WHITE);
		Font scoreFont= new Font(Font.SERIF, Font.BOLD, 15);
		g.setFont(scoreFont);
		g.drawString("SAI", x + 44,(int) y + 20);
		//g.drawRect(20,(int)y,20,20);
	

	}
	
	public void mouseExited(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){
	 	
	}
	public void mouseClicked(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
				goUp=true;
	}
	public void mouseReleased(MouseEvent e){
			goUp=false;

	}
	
	
}
