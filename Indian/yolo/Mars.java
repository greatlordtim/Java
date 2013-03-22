//Anindit Gopalakrishnan 
//1/16/2012
//Mars.java
//This is the main program for the Mars game - coordinates the movements
//of all the pieces, and contains the board on which the game is played.
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
public class Mars {
	Rover rover;///rover object
	Alien a;///alien ovject
	Scanner scan;///scanner to get the moves
	Scanner scan1;///scanner to get from the file
	PrintSpace[][] pss = new PrintSpace [25][25];///the repchar of the printspaces will be printed
	Sample[] ice;///ice array
	Sample[] hems;///hematite array
	public static void main(String[] args){
		Mars mars = new Mars();
		mars.runGame();
	}
	public void iniSpaces(){///initializes all the printspaces to H or I or @ using the information from rocks.txt
		File f = new File("rocks.txt");
		try{
			scan = new Scanner(f);
		}
		catch(FileNotFoundException e){
			System.err.println("THERE WAS AN ERROR. EXITING PROGRAM");
			System.exit(1);
		}
		
		int length = scan.nextInt();
		ice = new Sample[length];
		for (int i = 0; i < length; i ++){///this gets the ICE information
			ice[i] = new Sample(false, scan.nextInt(), scan.nextInt()); 
			
		}
		length = scan.nextInt();
		hems = new Sample[length];
		for(int i = 0; i < length; i ++){///this gets the HEMATITE information
			hems[i] = new Sample(true, scan.nextInt(), scan.nextInt());
		}
		
		for(int i = 0; i < ice.length; i ++){///this puts the ice information into the printspace array
			int row = ice[i].getRow();
			int col = ice[i].getCol();
			pss[row][col].sSet('I');
		}
		for(int i = 0; i < hems.length; i ++){///this puts the hematite information into the printspace array
			int row = hems[i].getRow();
			int col = hems[i].getCol();
			pss[row][col].sSet('H');
		}
		pss[a.getRow()][a.getCol()].sSet('@');
		
	}
	public void runGame(){///runs the game
		rover.initializeRover();///initializes the rover with user input
		printStaples();///prints the board and general info

		while (!rover.doneMoving()){
			//if (rover.getMoves()<=30){
 			boolean b = true;///this makes sure that the move used is valid based on the move() boolean from the Rover class
				while(b){
					System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
					System.out.print("Enter a letter choice to move -> ");
					//scan.nextLine();
					String s = scan1.next();
					scan1.nextLine();
					char c = s.charAt(0);
					b = rover.Move(c, a);///b is set to be FALSE if there is no problem, true if there is a problem (see move method from rover class)
					 //System.out.print(b);
					 //System.out.print(rover.getMoves());
				
				}
				checkCollections();///important that this is done before staples are printed - if done the other way the h samples and i samples will update late

				printStaples();
			//}
		}
		drawFinal();
		System.out.println("Thanks for visiting!!");
		System.out.println("___________________________________________________________________");
	}
	public void checkCollections(){///this checks to see if the rover has picked up a sample or alien
		/*for (int i = 0; i < ice.length; i++){///checks through the ice array. if it comes up with a hit, it increments the ice samples and sets the special
			boolean b = (ice[i].checkCollision(rover.getRow(), rover.getCol()))&&(pss[ice[i].getRow()][ice[i].getCol()].getChar()!='-');
			if (b){
				rover.iIs();
				pss[ice[i].getRow()][ice[i].getCol()].sSet('-');
				ice[i] = null;
			}
		}
		for (int i = 0; i < hems.length; i++){
			boolean b = (hems[i].checkCollision(rover.getRow(), rover.getCol()))&&(pss[hems[i].getRow()][hems[i].getCol()].getChar()!='-');
			if (b){
				rover.iHs();
				pss[hems[i].getRow()][hems[i].getCol()].sSet('-');
			}
		}
		if (rover.getAEs() > 0){
			pss[a.getRow()][a.getCol()].sSet('-');	
	
		}*/
		if (pss[rover.getRow()][ rover.getCol()].getChar() == 'I') {
			rover.iIs();
			pss[rover.getRow()][ rover.getCol()].sSet('-');
		}
		
		else if(pss[rover.getRow()][rover.getCol()].getChar() == 'H'){
			rover.iHs();
			pss[rover.getRow()][ rover.getCol()].sSet('-');
		}
		
	}
	
	public void drawBoard(){///draws the board
		for(int row = 0; row < 25; row++){
			if (row >= 0 && row < 10) System.out.print(row + " ");
			else if (row >= 10 && row < 20) System.out.print((row-10) + " ");
			else System.out.print((row-20) + " ");
			for (int col  = 0; col < 25; col++){
				System.out.print(pss[row][col].setChar(rover) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public Mars(){///constructor initializes printspace array and everything else
		for (int row = 0; row < 25; row++){
			for (int col = 0; col < 25; col++){
				pss[row][col] = new PrintSpace(row,col);
				//pss[row][col].sSet(' ');
			}
		}
		rover=  new Rover();
		a = new Alien();
		scan1 = new Scanner(System.in);
		iniSpaces();
	}
	public void printStaples(){///prints all the information that needs to be printed at the end of every turn
		System.out.printf("STATUS REPORT: Row: %2d     COLUMN: %2d%12d OF %2d STEPS TAKEN\n", rover.getRow(), rover.getCol(), rover.getMoves(), 30);
		System.out.printf("COLLECTED: %2d ICE SAMPLES, %2d HEMATITE SAMPLES %2d ALIEN ENCOUNTERS\n", rover.getISamps(), rover.getHSamps(), rover.getAEs()); 
		System.out.println("___________________________________________________________________");
		System.out.println("  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4");
		drawBoard();
	}
	
	public void drawFinal(){///draws the final boardwith all the answers
		System.out.printf("FINAL REPORT:  Row: %2d     COLUMN: %2d%12d OF %2d STEPS TAKEN\n", rover.getRow(), rover.getCol(), rover.getMoves(), 30);

		System.out.printf("COLLECTED: %2d ICE SAMPLES, %2d HEMATITE SAMPLES%2d ALIEN ENCOUNTERS\n", rover.getISamps(), rover.getHSamps(), rover.getAEs()); 
		System.out.println("___________________________________________________________________");
		System.out.println("  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4");
		for(int row = 0; row < 25; row++){
			if (row >= 0 && row < 10) System.out.print(row + " ");
			else if (row >= 10 && row < 20) System.out.print((row-10) + " ");
			else System.out.print((row-20) + " ");
			for (int col  = 0; col < 25; col++){
				System.out.print(pss[row][col].getChar(rover) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
		
}
