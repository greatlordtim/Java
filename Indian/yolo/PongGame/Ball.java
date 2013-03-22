//Anindit Gopalakrishnan
//September 12, 2012
//Ball.java
//This program will supply a Ball object along with integers to fit its
//role as a Ball object. It will be called by the PongPanel class.
import java.awt.Rectangle;
import java.awt.*;
import java.util.ArrayList;

//import java.lang.Math;

import java.util.Random;
public class Ball extends Rectangle{
	final double LIMITMAX = .4;
	final double LIMITMIN = .6;
	final double ABSMIN = .5;
	final int DIRECTION_CHOICE = 4;
	final int XPOSYPOS = 0;
	final int XNEGYPOS = 1;
	final int XPOSYNEG = 2;
	final int XNEGYNEG = 3; 
	final double XSPEEDLIMIT = 4;
	final double YSPEEDLIMIT = 2;
	int bRadius;
	double xMove;
	double yMove;
	double yPos;
	double xPos;
	Random rand = new Random();
	ArrayList<Paddle> playerArray = new ArrayList<Paddle>();
	ArrayList<Boundary> boundaryArray = new ArrayList<Boundary>();
	boolean collided = false;
	int x = 1;
	boolean restart = false;
	int playerScore = 0;
	int computerScore = 0;
	
	
	public Ball(int ballRadius, double xP, double yP){
		bRadius = ballRadius;
		xPos = xP;
		yPos = yP;
		this.setBounds((int)xPos, (int)yPos, bRadius, bRadius);
	}
	public Ball(){
		
	}
	public void setBounds(int ballRadius, double xP, double yP){
		bRadius = ballRadius;
		xPos = xP;
		yPos = yP;
		this.setBounds((int)xPos, (int)yPos, bRadius, bRadius);
	}
	public void updateRectangle(){
		this.setBounds((int)xPos, (int)yPos, bRadius, bRadius);
	}
	public void iniMove(){
		while(true){
			xMove = (rand.nextDouble()) ;
			yMove = (rand.nextDouble()) ;	
			if (xMove > (yMove + LIMITMAX)) {
				if (xMove < yMove + LIMITMIN){	
					if (xMove>ABSMIN){
						break;
					}
				}
			}
	
			
		}
		int decider = rand.nextInt(DIRECTION_CHOICE);
			System.out.println (decider);
		if (decider == XPOSYPOS){
				xMove = xMove;
				yMove = yMove;
			}
			else if (decider == XNEGYPOS){
				xMove = -xMove;
				yMove = yMove;
			}
			else if (decider == XPOSYNEG){
				xMove = xMove;
				yMove = -yMove;
			}
			else if (decider == XNEGYNEG){
				yMove = -yMove;
				xMove = -xMove;
			}
		
		//System.out.println(xMove);
		//System.out.println(yMove);
	}
	public void reverseMoveX(){
		xMove = -1 * xMove;
	}
	public void reverseMoveY(){
		yMove = -1 * yMove;
	}
	public void xMoveIncrease(double x){
		xMove+=x;
	}
	public void yMoveIncrease (double y){
		yMove+=y;
	}
	public void move(){
		yPos += yMove;
		xPos += xMove;
	}
	public void drawBall(Graphics g){
		g.fillOval((int)xPos, (int)yPos, (int)bRadius, (int) bRadius);
	}
	/*public void checkCollisions(Boundary b, PlayerPaddle p){
		if (b.getBoundDirection() == b.NORTHSOUTH_BOUND && ballTracker.intersects(b)){
			yMove = -yMove;
			if (b.getWhichThing() == b.NORTHEAST_BOUND){
				
				yPos = 10 + yPos;
				
			}
			else if (b.getWhichThing == b.SOUTHWEST_BOUND){
				yPos = yPos - 10;
			}
		}
		if (b.getBoundDirection() == b.EASTWEST_BOUND && ballTracker.intersects(b)){
			xMove = -xMove;
			if (b.whichThing == b.NORTHEAST_BOUND){
				
				xPos = -10 + xPos;
			}
			else if (b.getWhichThing == b.SOUTHWEST_BOUND){
				xPos = xPos + 10;
			}		
		}
		if (ballTracker.intersects(p)){
			xMove = -xMove;
		
		}
	}*/
	public void checkCollisions(){
		for (int i = 0 ; i < boundaryArray.size(); i++){
			Boundary b = boundaryArray.get(i);
			if (this.intersects(b)  ){
				if (b.getBoundDirection() == b.NORTHSOUTH_BOUND ){
					yMove = -yMove;
					collided = true;
					if (b.getWhichThing() == b.NORTHEAST_BOUND){
					
						yPos = 10 + yPos;
					
				
					}
					else if (b.getWhichThing() == b.SOUTHWEST_BOUND){
						yPos = yPos - 10;
					
					}
				}
				if (b.getBoundDirection() == b.EASTWEST_BOUND){
					xMove = -xMove;
					collided = true;
					if (b.getWhichThing() == b.NORTHEAST_BOUND){
						xPos = -10 + xPos;
						System.out.println("YO WON");
						restart = true;	
					playerScore++;
					}
					else if (b.getWhichThing() == b.SOUTHWEST_BOUND){
						xPos = xPos + 10;
						System.out.println("YO LOST");
						restart = true;	
						
						computerScore ++;


					
					}
				}
			}
		
		}
			for (int i = 0; i < playerArray.size(); i++){
				Paddle p = playerArray.get(i);
					if (this.intersects(p)){
						collided = true;

						if (p.corP == false){
							xMove = -xMove;
							xPos = xPos + 10;
						}
						else if (p.corP == true){
							xMove = -xMove;
							xPos = xPos-10;
						}
					}
			}
			if (collided == true){
				if (xMove > 0 && xMove < XSPEEDLIMIT){
					xMove += .05;
				}
				else if (xMove < 0 && xMove > -XSPEEDLIMIT){
					xMove -=.05;
				}
				if (yMove > 0 && yMove < YSPEEDLIMIT){
					yMove += .03;
				}
				else if (yMove<0 && yMove > -YSPEEDLIMIT){
					yMove -=.03;
				}
				x++;
				//System.out.println(xMove + " " + yMove);
				collided = false;
			}
		}
	public void addBoundary(Boundary b){
			boundaryArray.add(b);
	}
	public void addPaddle(Paddle b){	
			playerArray.add(b);
	}
	public void clearBall(){
		playerArray.clear();
		boundaryArray.clear();
		collided = false;
		x = 1;
	}
		
		
}
