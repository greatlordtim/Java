//Anindit Gopalakrishnan 
//1/16/2012
//Mars.java
//This is the main program for the Mars game - coordinates the movements
//of all the pieces, and contains the board on which the game is played.
import java.util.Scanner;
public class Mars {
	Rover rover;
	Alien a;
	Scanner scan;
	PrintSpace[][] pss = new PrintSpace [25][25];
	Sample[] ice = new Sample[15]
	Sample[] hems = new Sample[19]
	public static void main(String[] args){
		Mars mars = new Mars();
		mars.runGame();
	}
	public void iniSpaces(){
		File f = new File("rocks.txt");
		scan = new Scanner(f);
		
	}
		public void runGame(){
		rover.initializeRover();
		
		while (!rover.doneMoving()){
			printStaples();
 			boolean b = true;
			while(b){
				System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
				System.out.print("Enter a letter choice to move -> ");
				//scan.nextLine();
				String s = scan.next();
				scan.nextLine();
				char c = s.charAt(0);
				 b = rover.Move(c, a);
				 System.out.print(b);
				 System.out.print(rover.getMoves());
			}
		}
	}
	public void drawBoard(){
		for(int row = 0; row < 25; row++){
			if (row >= 0 && row < 10) System.out.print(row + " ");
			else if (row >= 10 && row < 20) System.out.print((row-10) + " ");
			else System.out.print((row-20) + " ");
			for (int col  = 0; col < 24; col++){
				System.out.print(pss[row][col].setChar(rover) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public Mars(){
		for (int row = 0; row < 25; row++){
			for (int col = 0; col < 25; col++){
				pss[row][col] = new PrintSpace(row,col);
				pss[row][col].dSet(' ');
			}
		}
		rover=  new Rover();
		a = new Alien();
		scan = new Scanner(System.in);
	}
	public void printStaples(){
		System.out.printf("STATUS REPORT: Row: %2d     COLUMN: %2d%12d OF %2d STEPS TAKEN\n", rover.getRow(), rover.getCol(), rover.getMoves(), 30);
		System.out.printf("COLLECTED: %2d ICE SAMPLES, %2d HEMATITE SAMPLES%3d ALIEN ENCOUNTERS\n", rover.getISamps(), rover.getHSamps(), rover.getAEs()); 
		System.out.println("___________________________________________________________________");
		System.out.println("  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4");
		drawBoard();
	}
	
	
		
}
