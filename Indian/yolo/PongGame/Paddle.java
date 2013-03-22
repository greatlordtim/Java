//Anindit Gopalakrishnan
//September 19,2012
//PlayerPaddle.java
//This program will provide a player paddle for the Pong game.
import java.awt.Rectangle;
import java.awt.Graphics;
public class Paddle extends Rectangle{
	int paddleX;
	double paddleY;
	int paddleHeight;
	int paddleWidth;
	int drawXPos;
	int drawWidth;
	double moveSpeed;
	
	boolean corP = false;

	
	
	public Paddle (int X, double Y, int Width, int Height, int dWidth, int drawX, double mSpeed, boolean c){
		paddleX = X;
		paddleY = X;
		paddleWidth = Width;
		paddleHeight = Height;
		drawXPos = drawX;
		drawWidth = dWidth;
		moveSpeed = mSpeed;
		this.setBounds(paddleX, (int)paddleY, paddleWidth, paddleHeight);
		corP = c;
	
	}
	
	public Paddle (int X, double Y, int Width, int Height, int dWidth, int drawX){
		paddleX = X;
		paddleY = X;
		paddleWidth = Width;
		paddleHeight = Height;
		drawXPos = drawX;
		drawWidth = dWidth;
		this.setBounds(paddleX, (int)paddleY, paddleWidth, paddleHeight);
	
	}
	public void drawPaddle(Graphics g){
		g.fillRect(drawXPos, (int)paddleY, drawWidth, paddleHeight);
		
	}
	public void limitPaddleNorth(int y){
		if (paddleY == y || paddleY < y){
			paddleY = y;
		}
		
	}
	public void limitPaddleSouth(int y){
		if (paddleY+ paddleHeight == y ||  paddleY + paddleHeight > y){
			paddleY = y - paddleHeight;
		}
	}
	
	public void updateRectangle(){
		
		this.setBounds(paddleX, (int)paddleY, paddleWidth, paddleHeight);
	}
	public void trackBall(Ball ball){
		if (corP == true){
			if (ball.xMove > 0 && ball.xPos > 500){
				if (ball.yPos > paddleY){
					paddleY += moveSpeed;
				}
				else if (ball.yPos < paddleY){
					paddleY -= moveSpeed;
				}
			}
			else if (paddleY > 285-paddleHeight){
				paddleY -=moveSpeed;
			}
			else if (paddleY < 285-paddleHeight){
				paddleY += moveSpeed;
			}
		
		}
		else if (corP == false){
			if (ball.xMove < 0 && ball.xPos < 500){
				if (ball.yPos > paddleY){
					paddleY += moveSpeed;
				}
				else if (ball.yPos < paddleY){
					paddleY -= moveSpeed;
				}
			}
		
			else if (paddleY > 285-paddleHeight){
				paddleY -=moveSpeed;
			}
			else if (paddleY < 285-paddleHeight){
				paddleY += moveSpeed;
			}
			else if (paddleY > 285-paddleHeight){
				paddleY -=moveSpeed;
			}
			else if (paddleY < 285-paddleHeight){
				paddleY += moveSpeed;
			}
		
		}
			
	}
	




}
