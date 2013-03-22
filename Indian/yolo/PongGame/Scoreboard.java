//Anindit Gopalakrishnan
//September 26, 2012
//Scoreboard.java
//This program will make a scoreboard.

import java.awt.*;
public class Scoreboard{
	int height;
	int width;
	int xCoordinate;
	int yCoordinate;
	int ballNumber;
	int scorePlayer = 0;
	int scoreComputer = 0;
	
	public Scoreboard(int xC, int yC, int x, int y ){
		xCoordinate = xC;
		yCoordinate = yC;
		height = x;
		width = y;
		ballNumber = 1;
		scorePlayer = 0;
		scoreComputer = 0;
		
	}
	public void drawScoreBoard(Graphics g){
		Font regularFont = new Font(Font.SERIF, Font.BOLD, 15);
		g.setFont(regularFont);
		g.drawString("Player: ", xCoordinate + 10, yCoordinate +18);
		g.drawString ("Computer: ", xCoordinate + 565, yCoordinate+ 18);
		
		for (int i = 0; i < 5;i++){
			g.drawOval(xCoordinate + 10 + (25*i), yCoordinate + 20, 20, 20);
		}
		for (int i = 0; i < 5; i++){
			g.drawOval(xCoordinate + 565 + (25*i), yCoordinate + 20, 20, 20);
		}
		for(int i = 0; i < scorePlayer; i++){
			g.fillOval(xCoordinate + 10 + (25*i), yCoordinate+20, 20, 20);
			
		}
		for (int i = 0; i<scoreComputer; i++){
			g.fillOval(xCoordinate + 565 + (25*i), yCoordinate+20, 20, 20);

		}
	
	}
	public void drawBigScore(Graphics g){
		Font scoreFont= new Font(Font.SERIF, Font.BOLD, 500);
		g.setFont(scoreFont); 
		g.drawString(Integer.toString(scorePlayer), xCoordinate + 50, yCoordinate -80);
		g.drawString (Integer.toString(scoreComputer), xCoordinate + 600, yCoordinate-80);
		g.fillRect(470, 275, 40, 10);

	
	}
	public void setScore (int playerScore, int computerScore){
		scorePlayer =playerScore;
		scoreComputer = computerScore;
	}
	
}
