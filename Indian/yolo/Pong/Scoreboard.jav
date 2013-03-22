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
	int scorePlayer;
	int scoreComputer;
	JLabel player;
	JLabel computer;
	public Scoreboard(int xC, int yC, int x, y ){
		xCoordinate = xC;
		yCoordinate = yC;
		height = x;
		width = y;
		ballNumber = 1;
		scorePlayer = 0;
		scoreComputer = 0;
		player = new JLabel("Player Score:");
		computer = newJLabel("Computer Score:");
	}
	public void drawScoreBoard(Graphics g){
		g.fillRect(xCoordinate, yCoordinate, width, 5);
		g.drawString("Player: ", xCoordinate + 10, yCoordinate -10);
		g.drawString ("Computer: ", xCoordinate + 700, yCoordinate- 10);
		for(int i = 0; i < scorePlayer; i++){
			g.fillOval(xCoordinate + 10 + (20*i), yCoordinate+20, 20, 20);
		}
		for (int i = 0; i<scoreComputer; i++0{
			g.fillOval(xCoordinate + 700 + (20*i), yCoordinate+20, 20, 20);

		}
	
	}
	
	public void enterScore (int playerScore, int computerScore){
		scorePlayer =playerScore;
		scoreComputer = computerScore;
	}
	
}
