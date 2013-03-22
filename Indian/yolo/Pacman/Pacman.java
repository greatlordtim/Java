//Anindit Gopalakrishnan
//3/4/13
//Pacman.java
//This progra will play a simple game of pacman
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class Pacman {
	
	public static void main(String[] args){
		//initializes frame, adds keylistener adds panel
		JFrame frame = new JFrame("Pacman");
		frame.setSize(594,643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PacPanel p = new PacPanel();
		frame.getContentPane().add(p);
		frame.addKeyListener(p.pacman); //pacman
		frame.setResizable(false);
		frame.setVisible(true);

		
	}
	

}

class PacPanel extends JPanel implements ActionListener{
	PacGuy pacman; //this is the pacman  object that the user can move around
	Chese[] cheses = new Chese[6]; //is the array that holds all the cheses
	int[] winloss = new int[6]; //used to see if the game has been won or lost
	int animator = 0;//counts up and is used for animation
	Monster[] monsters = new Monster[6]; //holds all the monster objects
	Timer timer; //timer that runs everythign
	int direction = 0; //the direction that
	boolean lost = false; //this boolean chekcs if you lost
	boolean won = false; //this boolean checks if he won

	

	
	public void actionPerformed(ActionEvent e){
		
			animator++;//increments animator cause it is %2
			for (int i = 0; i < 6; i++){
				if (animator%10 == 0) monsters[i].moveIntelligently(pacman); //only move only 10 ticks
			}
			repaint(); //repaint every tick
		
	}
	
	public PacPanel (){ //initialiazes all the stuff for the game
		addKeyListener(pacman);	
 		int [][] test = new int[10][10]; //array used to make sure no overlaps
 		for (int i = 0; i < 6; i++){
		
			winloss[i] = 2;	 //sets the fact that u lost
			
			
		} 
		for (int i = 0; i < 10; i++){ //initializes the whole test array to 0 (1 will represebt an a)
			for (int j = 0; j < 10; j++){ 
				test[i][j] = 0;
			}
		}
		for (int i = 0; i < 6; i++){ //initializes the cheses
			if (i == 0){
				cheses[i] = new Chese();
				int row = (cheses[i].x - 17)/55;
				int col = (cheses[i].y - 17)/55;
								System.out.println(row + " " + col);

				test[row][col] = 1;
			}
			else {
				boolean didntwork = false;
				int row, col;
				do{
					cheses[i] = new Chese();
					row = (cheses[i].x - 17)/55;
					col = (cheses[i].y - 17)/55;
					if (test[row][col] != 1)
						didntwork = false;
					else{
						didntwork = true;
					}
				
				}while(didntwork);
				test[row][col] = 1;
							
			}
		
		}
		for (int i = 0; i < 6; i ++){//initializes the monsters
			boolean didntwork = false;
			int row, col;

			do{
				monsters[i] = new Monster();
				row = (monsters[i].x - 17)/55;
				col = (monsters[i].y - 17)/55;
				if (test[row][col] != 1)
					didntwork = false;
				else{
					didntwork = true;
				}
			
			}while(didntwork);
			test[row][col] = 1;

		}
		boolean didntwork = false;
		int row, col;
		do{ //initializes the pacman 
			pacman = new PacGuy();
			row = (pacman.x - 17)/55;
			col = (pacman.y - 17)/55;
			if (test[row][col] != 1)
				didntwork = false;
			else{
				didntwork = true;
			}
			
		}while(didntwork);
		test[row][col] = 1;
		
	
		timer  = new Timer (20, this); //timer initialize
		lost = false;
		won = false;
		timer.start(); //starts the timer
		

	}
	
	public void reset(){ //reset s the game
		addKeyListener(pacman);	
		for (int i = 0; i < 6; i++){
			
			
			winloss[i] = 2;
		}
		int [][] test = new int[10][10];
		for (int i = 0; i < 6; i++){ //resets the win array
		
			winloss[i] = 2;	
			
			
		}
		for (int i = 0; i < 10; i++){ //resets the test array
			for (int j = 0; j < 10; j++){
				test[i][j] = 0;
			}
		}
		for (int i = 0; i < 6; i++){ //restet the chese array
			if (i == 0){
				cheses[i].reset3();
				int row = (cheses[i].x - 17)/55;
				int col = (cheses[i].y - 17)/55;
				test[row][col] = 1;
			}
			else {
				boolean didntwork = false;
				int row, col;
				do{
					cheses[i].reset3();
					row = (cheses[i].x - 17)/55;
					col = (cheses[i].y - 17)/55;
					if (test[row][col] != 1)
						didntwork = false;
					else{
						didntwork = true;
					}
				
				}while(didntwork);
				test[row][col] = 1;				
			}
		
		}
		for (int i = 0; i < 6; i ++){//resets the monster array
			boolean didntwork = false;
			int row, col;
			do{
				monsters[i].reset2();
				row = (monsters[i].x - 17)/55;
				col = (monsters[i].y - 17)/55;
				if (test[row][col] != 1)
					didntwork = false;
				else{
					didntwork = true;
				}
			
			}while(didntwork);
			test[row][col] = 1;
		}
		boolean didntwork = false;
		do{ //resets the pacman
			pacman.reset1();
			int row = (pacman.x - 17)/55;
			int col = (pacman.y - 17)/55;
			if (test[row][col] != 1)
				didntwork = false;
			else{
				didntwork = true;
			}
		
		}while(didntwork);
		
		timer  = new Timer (20, this); //resets the timer
		lost = false; //resets the win/loss
		won = false;
		timer.start();
		direction = 0;
		
	} // hallo there this is a comment
	
	public void paintComponent(Graphics g){ //paint component draws everything
		super.paintComponent(g);
		g.setColor(Color.black); //draws background
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(Color.blue);

		g.fillRect(0,0, 570, 17); //draws the boundaries

		for (int i = 0; i < 11; i++){
			g.fillRect(15 + i*55, 15, 2, 550);
			g.fillRect(15, 15+i*55, 555,2);
		}
		g.setColor(Color.blue);

		g.fillRect(0,0,15,570); //draws te boundaries
		g.fillRect(567,0, 15, 570);
		g.fillRect(0,567, 585, 15);
		g.setColor(Color.red);
		g.fillRect(0,582, 585, 30); //draws the instructions
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 15));
		g.drawString("Directions: a = left, d = right, w = up, s = down, r = reset ", 60, 602);
		
		pacman.drawPac(g, animator); //draws the pacman
		
		for (int i = 0; i < 6; i ++){ //checks to see if the cheses have beeneaten
			cheses[i].isEaten(pacman);
			
			if (cheses[i].b == false) winloss[i] = 0;
			cheses[i].drawChese(g);
		}
		
		for (int i = 0; i < 6; i++){ //draws the monsters and checks to see if the pacman has been eaten
						monsters[i].ate(pacman);

			monsters[i].drawMonster(g);

		}
		for (int i =0; i< 6; i++){ //checkst see if the monsters won
			if (monsters[i].attack == true) {
				lost = true;
				won = true;
			}
			
		}
		if (lost ==  true){ // does stuff if you lost
			g.setColor(Color.red.darker());
			g.setFont(new Font("Times New Roman", Font.BOLD, 50));
			g.drawString("YOU LOST:(", 200 ,300);
			timer.stop();
		}
		else if (winloss[0] == winloss[1] && winloss[1] == winloss[2] && winloss[2] == winloss[3] && winloss[3] == winloss[4] && winloss[4] == winloss[5]){ //checks to see if you won
			if (winloss[0] == 0){
				g.setColor(Color.green); //draws the win message
				g.setFont(new Font("Times New Roman", Font.BOLD, 50));
				g.drawString("YOU WON!!!!", 200 ,300);
				timer.stop();
				won = true;
				lost = true;
			}
			
		}	
		
	}
	
	
	
	class PacGuy implements KeyListener{ //pacman class
		int x, y, move;
		Random r = new Random();
		public PacGuy(){ //initializes to a random spot
			move = 55;
			x = 17 + r.nextInt(10)*move;
			y=  17 + r.nextInt(10)*move;
			
		}
		public void reset1(){ //resets the pacman
			move = 55;
			x = 17 + r.nextInt(10)*move;
			y=  17 + r.nextInt(10)*move;
		}
		public void drawPac(Graphics g, int animator){ //draws the pacman gradually opening and closing
			int ani = animator%40;
			if (ani > 20) ani = 40-ani;
			g.setColor(Color.yellow);
			g.fillOval(x, y, 50, 50);
			g.setColor(Color.black);
			//checks to see which direction and draws the pacman accordingly
			if (direction == 0) g.fillArc(x, y, 50, 50, 360-ani*2, ani*4);
			else if (direction == 2) g.fillArc(x, y, 50, 50, 90 - ani*2, ani *4);
			else if (direction == 1) g.fillArc(x, y, 50, 50, 180 - ani*2, ani *4);
			else if (direction == 3) g.fillArc(x, y, 50, 50, 270 - ani*2, ani *4);

		}
		
		
		public void keyPressed(KeyEvent e){ //moving
			
			int c = e.getKeyCode();
			System.out.println(c);
			if (!lost || !won){ //allows for both arrow keys AND WASD controlling
				switch(c){
					case KeyEvent.VK_UP: if (y > 30) y -= move; 
							  else y = 512; direction  =2; break;
					case KeyEvent.VK_LEFT: if (x > 30) x -=move;
							  else x = 512; direction = 1; break;
					case KeyEvent.VK_DOWN: if (y < 500)y +=move;
							  else y = 17; direction = 3; break;
					case KeyEvent.VK_RIGHT: if (x < 500) x +=move; 
							  else x = 17; direction = 0; break;
					case KeyEvent.VK_W: if (y > 30) y -= move; 
							  else y = 512; direction = 2; break;
					case KeyEvent.VK_A: if (x > 30) x -=move;
							  else x = 512; direction  = 1;  break;
					case KeyEvent.VK_S: if (y < 500)y +=move;
							  else y = 17; direction = 3; break;
					case KeyEvent.VK_D: if (x < 500) x +=move; 
							  else x = 17; direction = 0; break;
				}
				repaint();
			}	
			if (c == KeyEvent.VK_R) { //reset
				timer.stop();
				reset();
			}
		}
		

		public void keyReleased(KeyEvent e){
		}
		public void keyTyped(KeyEvent e){}
	
	}
	
	class Chese{ 
		int x, y, move;
		boolean b;
		Random r = new Random();
		public Chese(){ //sets it to a random location
			move = 55;
			x = 17 + r.nextInt(10)*move;
			y=  17 + r.nextInt(10)*move;
			b = true;
		}
		public boolean equals(Chese c){ //checks to see if a chese = another chese (used to see if they are on the same spot
			if (x == c.x && y == c.y) return true;
			else return false;
		}
		public void reset3(){ //resets the chese to another random location
			move = 55;
			x = 17 + r.nextInt(10)*move;
			y=  17 + r.nextInt(10)*move;
			b = true;
			
		}
		public void drawChese(Graphics g){ //draws the cheses
			g.setColor(Color.white);
			if (b) g.fillRect(x+10, y+10, 30, 30);
		}
		public void isEaten(PacGuy pg){ //checks to see if the pacman ate the chese
			if ((pg.x == x) &&(pg.y == y)) b = false;
		
		}
	
	}
	class Monster{
		int x, y, move;
		Random r; 
		boolean attack = false; //boolean to see if it ate the pacman
		public Monster(){ //initializes it to a random place
		r = new Random();

			move = 55;
			x = 17 + r.nextInt(10)*move;
			y=  17 + r.nextInt(10)*move;
			attack = false;
		}
		public void reset2(){ //resetst he montster
			move = 55;
			x = 17 + r.nextInt(10)*move;
			y=  17 + r.nextInt(10)*move;
			r = new Random();
			attack = false;
		}
		public boolean equals(Monster c){ //used to check iof they are on the same spot
			if (x == c.x && y == c.y) return true;
			else return false;
		}
		public void drawMonster(Graphics g){ //draws monster + its wierd face
			g.setColor(Color.red);
			 g.fillOval(x, y, 50, 50);
			g.setColor(Color.black);
			//g.fillOval(x + 5, y + 5, 5, 5);
			//g.fillOval(x+40, y + 5, 5 ,5);
			g.fillOval(x + 10, y + 10, 10, 10);
			g.fillOval(x+35, y + 10, 10 ,10);
			g.fillRect(x + 10, y + 35, 30, 4);
				
		}
		public void ate(PacGuy pg){ //checks to see if it ate the pacguy
			if ((pg.x == x) &&(pg.y == y)) attack = true;
		
		}
		public void moveRandomly(){ //moves truly randomly
			int toMove = r.nextInt(2);
			if (toMove == 0){
				int direction = r.nextInt(4);
				
			}
		
		}
		public void moveIntelligently(PacGuy p){ //moves intelligently - gets the location of the monster
		//there will be 2 directions that will get it closer, and picks a random number to get either one fo those directions
		//for example, if the pacman is up and to the left, the monster will either move up or to the left
			int toMove = r.nextInt(2);
			if (toMove == 0){
				int direction;
				if (x < p.x && y < p.y) direction  = r.nextInt(2)+2;
				else if (x == p.x && y < p.y) direction = 2; 
				else if (x > p.x && y < p.y) direction = r.nextInt(2) + 1;
				else if (x > p.x && y == p.y) direction = 1;
				else if (x > p.x && y > p.y) direction = r.nextInt(2);
					
				else if (x == p.x && y>p.y) direction = 0;
				else if (x<p.x && y>p.y) {
					int asdf = r.nextInt(1) ;
					
					if (asdf == 0) direction = 0;
					else direction = 3;
				
				}
				
				else if (x<p.x && y == p.y) direction = 3;
				else direction = 20;
				
				switch(direction){
					case 0: if (y > 30) y -= move;  //up
							  else y = 512; break;
					case 1: if (x > 30) x -=move; //left
							  else x = 512;  break;
					case 2: if (y < 500)y +=move; // down
							  else y = 17; break;
					case 3: if (x < 500) x +=move; //right
							  else x = 17; break;
				}
			}
			
				
			
		}
	}
}

