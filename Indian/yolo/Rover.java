//Anindit Gopalakrishnan
//1/17/13
//Rover.java
//This class holds the Rover object

import java.util.Scanner;
import java.util.Random;
public class Rover { 
	private int row, col, moves, hSamps, iSamps, aEs; /// row/ col - holds the position, moves holds the number of moves, hSamps - number of hSamples
	///iSamps - number of ice samples aes - number of alien encounters
	
	private Random rand; ///random number generated for the -1 option
	private char repchar;///char that represents - 'R' or '@'
	private boolean aliened;///says if the thing has been taken over by the alien
	private Scanner scan; ///scanner object to get user input
	public Rover(){ ///constructor object sets all the values to as if the game jsut started
		rand = new Random();
		repchar = 'R';
		aliened  = false;
		scan = new Scanner(System.in);
		moves = 0;
		hSamps=  0;
		iSamps  =0;
		aEs = 0;
		
	}
	public void initializeRover(){ ///initializes the rover
		int x,y,count;
		count = 0;
		do{
			if(count == 0) System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)     -> ");
			else System.out.print(          "ERROR: out of bounds, no such place on grid. Enter new number  -> ");
			x = scan.nextInt();
			count++;
		}while(!(x>=-1 && x<=24));
		count = 0;
		do{
			if(count == 0) System.out.print("Enter a grid column coordinate (0 - 24, -1 for random choice)  -> ");
			else System.out.print(          "ERROR: out of bounds, no such place on grid. Enter new number  -> ");
			y = scan.nextInt();
		}while(!(y>=-1 && y<=24));
		
		if (x==-1) row = random(); ///handles the random case
		else row = x;
		
		if (y==-1) col = random();///handles the random casxe 
		else col = y;
		
		//System.out.println(row + " " + col);
	}
	public int random(){
		return rand.nextInt(25);
	}
	public void addToCollection(Sample s){///allows the user to add to the collection
		if (s.type() == 'H') hSamps ++;

		else if (s.type() == 'I'){
			iSamps++;
		}
	}
	public int getMoves(){///returns moves
		return moves;
	}
	public int getHSamps(){///returns Hematite Samples
		return hSamps;
	}
	public void iHs(){///increments number of hSamps
		hSamps++;
	}
	public int getISamps(){///gets the Ice Samps
		return iSamps;
	}
	public void iIs(){///increments the ice samples
		iSamps++;
	}
	public int getRow(){///returns the row
		return row;
	}
	public int getCol(){///returns the column
		return col;
	}
	public int getAEs(){///returns number of alien encounters
		return aEs;
	}
	public void iAEs(){///adds to the alien encounters
		aEs++;
	}
	public char getRepChar(){///returns the alien
		return repchar;
	}
	
	public void checkAlien(Alien a){///chekcs if collided with the alien
		if ((row == a.getRow()) && (col == a.getCol())&&(aliened = false)) {
			repchar = '@';
			//a.setDraw(false);
			aliened = true;
			aEs++;
		}
	}
	public void incrementMove(){///increments the number of moves
		moves++;
	}

	public boolean doneMoving(){///returns if the moves is more than 30
		if (moves >= 30) return true;
		else return false;
	}
	public boolean Move (char c, Alien a){///moves based on the char as well as looking out for the alien
		boolean nullit = false;
		int sMY = col;
		int sMX = row;
		if (c == 'd'){
			col ++;
			
			if (col > 24) {///checks to make sure it doesnt go out of the board
				col = sMY;
				nullit = true;
			}
			
		}
		else if (c == 'a'){
			col --;
			if (col <0) {///out of bounds handling
				col = sMY;
				nullit = true;
			} 
		
		}
		else if (c == 'w'){
			row --;
			if (row < 0){///checs to make sure it doesnt go out of the board
				row = sMX;
				nullit = true;
			}
				
		}
		else if (c == 's'){
			row++;
			if (row > 24){
				row = sMX;
				nullit = true;
			}
		}
	
		if (nullit == false) {
			incrementMove();
			checkAlien(a);
			//System.out.println("have been falsed");
		}
		return nullit;		
	}
	
}
