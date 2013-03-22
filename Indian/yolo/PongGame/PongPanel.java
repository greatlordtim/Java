//Anindit Gopalakrishnan
//September 10, 2012
//PongPanel.java
//This will support the Pong.java class.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PongPanel extends JPanel implements MouseMotionListener, ActionListener, MouseListener {
	final int WINDOW_WIDTH = 1000;
	final int WINDOW_HEIGHT = (int) (WINDOW_WIDTH*3)/5;	
	final int GAME_SPEED_MS = 1;
	final int BALL_RADIUS = WINDOW_WIDTH/40;
	final int BALL_XPOS = WINDOW_WIDTH/2 - BALL_RADIUS/2;
	final int BALL_YPOS = WINDOW_HEIGHT/2 - BALL_RADIUS/2 - BALL_RADIUS/5;
	
	final int EAST_WEST_BOUNDARY_HEIGHT = WINDOW_HEIGHT;
	final int EAST_WEST_BOUNDARY_WIDTH = 4;
	
	final int NORTH_SOUTH_BOUNDARY_WIDTH = WINDOW_WIDTH;
	final int NORTH_SOUTH_BOUNDARY_HEIGHT = 4;
	
	final int EASTWEST_BOUND = 1;
	final int NORTHSOUTH_BOUND = 0;
	
	final int NORTHEAST_BOUND = 0;
	final int SOUTHWEST_BOUND = 1;
	
	final int JFRAME_ADJUSTMENT_Y = 31;
	final int JFRAME_ADJUSTMENT_X = 13;
	
	final int BOUNDARY_START_WEST_X = -100;
	final int BOUNDARY_START_WEST_Y = 0;
	
	final int BOUNDARY_START_NORTH_Y = -100;
	final int BOUNDARY_START_NORTH_X  = 0;
	
	final int BOUNDARY_START_SOUTH_Y = WINDOW_HEIGHT - JFRAME_ADJUSTMENT_Y - NORTH_SOUTH_BOUNDARY_HEIGHT;
	final int BOUNDARY_START_SOUTH_X = EAST_WEST_BOUNDARY_WIDTH;
	
	final int BOUDNARY_START_EAST_X = WINDOW_WIDTH - JFRAME_ADJUSTMENT_X - EAST_WEST_BOUNDARY_WIDTH;
	final int BOUNDARY_START_EAST_Y = NORTH_SOUTH_BOUNDARY_HEIGHT;
	
	final int GAME_ENDER = 5;
	
	boolean start = false;
	boolean goingOn = false;
	boolean drawGame = true;
	boolean win = false;
	boolean loose = false;	
	boolean setUpGame =true;
	
	Boundary northBounds = new Boundary
	(BOUNDARY_START_NORTH_X, BOUNDARY_START_NORTH_Y, 
	NORTH_SOUTH_BOUNDARY_WIDTH, 100+NORTH_SOUTH_BOUNDARY_HEIGHT, 
	NORTHSOUTH_BOUND, NORTHEAST_BOUND); 
	Boundary westBounds = new Boundary(BOUNDARY_START_WEST_X, BOUNDARY_START_WEST_Y, 
	100+EAST_WEST_BOUNDARY_WIDTH, EAST_WEST_BOUNDARY_HEIGHT, 
	EASTWEST_BOUND, SOUTHWEST_BOUND);
	Boundary eastBounds = new Boundary(BOUDNARY_START_EAST_X, BOUNDARY_START_EAST_Y,  
	100 + EAST_WEST_BOUNDARY_WIDTH, EAST_WEST_BOUNDARY_HEIGHT, 
	EASTWEST_BOUND, NORTHEAST_BOUND );
	Boundary southBounds = new Boundary(BOUNDARY_START_SOUTH_X, BOUNDARY_START_SOUTH_Y - 50, 
	NORTH_SOUTH_BOUNDARY_WIDTH, NORTH_SOUTH_BOUNDARY_HEIGHT+100, 
	NORTHSOUTH_BOUND, SOUTHWEST_BOUND);
	Scoreboard scoreBoard=  new Scoreboard(0, BOUNDARY_START_SOUTH_Y -46, WINDOW_WIDTH, 50);
	Ball ball = new Ball();
	Paddle playerPaddle = new Paddle(-90, 300, 100, 400, 5, 5);
	Paddle computerPaddle = new Paddle(980, 300, 100, 100, 5, 980, 1.5, true);
	static JFrame window;
	//ArrayList<Ball> ballArray = new ArrayList<Ball>();
    	
    	public void actionPerformed(ActionEvent evt) {
			if (start == true){
				repaint();
				ball.move();
				if (ball.restart == true){
					start = false;	
				}
				ball.checkCollisions();
				ball.updateRectangle();
				playerPaddle.limitPaddleNorth(4);
				playerPaddle.limitPaddleSouth(BOUNDARY_START_SOUTH_Y -  50);
				computerPaddle.limitPaddleNorth(4);
				computerPaddle.limitPaddleSouth(BOUNDARY_START_SOUTH_Y -  50);
				playerPaddle.updateRectangle();
				computerPaddle.updateRectangle();
				computerPaddle.trackBall(ball);
				playerPaddle.trackBall(ball);
				checkForGameEnd();
				goingOn = true;
			}
			
			
			else if (ball.restart == true){
				ball.clearBall();

				initializeBall(ball);
				goingOn = false;
				repaint();
				ball.restart = false;
				scoreBoard.setScore(ball.playerScore, ball.computerScore);
			}
			
      	}
    	public void mouseMoved(MouseEvent e){
			playerPaddle.paddleY = e.getY();
			playerPaddle.paddleY -= 50;
		}
		public void mouseDragged(MouseEvent e){
		}
		public void mouseClicked(MouseEvent e){
			if (goingOn == false){
				start = true;
					System.out.println("LIKE FAIL");
			}		
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){};
		
     
	public PongPanel(){
		//setUpPanel();
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		initializeBall(ball);
		Timer time = new Timer(GAME_SPEED_MS,this);
		time.start();
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		if (drawGame == true){
			northBounds.drawBoundary(g);
			eastBounds.drawBoundary(g);
			westBounds.drawBoundary(g);
			southBounds.drawBoundary(g);
			
			scoreBoard.drawScoreBoard(g);
			g.fillRect(0, BOUNDARY_START_SOUTH_Y, 3000, 5);
			g.fillRect(487, 0, 5, 520);  
			if (start == true){
				computerPaddle.drawPaddle(g);
				playerPaddle.drawPaddle(g);
				ball.drawBall(g);

			}
			else {
				scoreBoard.drawBigScore(g);
			}
		}
		else if (drawGame == false){
			if (win ==true){
				Font scoreFont= new Font(Font.SERIF, Font.BOLD, 300);
				g.setFont(scoreFont); 	
				g.drawString("YOU ", 150, 250);	
				g.drawString("WON!!!!!", 0,500);
			}
			else if (loose == true){
			
				Font scoreFont= new Font(Font.SERIF, Font.BOLD, 250);
				g.setFont(scoreFont); 		
				g.drawString("YOU ", 150, 250);	
				g.drawString("LOST :((", 0,500);	
			}
		}
	
		
	}
	public void initializeBall(Ball b){
		
		b.setBounds(BALL_RADIUS, BALL_XPOS, BALL_YPOS);
		b.iniMove(); 
		b.addPaddle(playerPaddle);
		b.addPaddle(computerPaddle);
		b.addBoundary(eastBounds);
		b.addBoundary(westBounds);
		b.addBoundary(southBounds);
		b.addBoundary(northBounds);
	}
	public void checkForGameEnd(){
		if (ball.playerScore == 5){
			drawGame = false;
			win = true;
			loose = false;
				
		}
		else if(ball.computerScore == 5){
			drawGame =false;
			win = false;
			loose = true;		
		}
	
	}

	
}
