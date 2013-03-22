//Anindit Gopalakrishnan
//January 10th, 2013
//Bingo.java
//This program will draw a bingo board onto the console with some 
//specifications: The B column must only have numbers 1-15, I 16-30, etc until
//o is 61-75. In addition, the middle of the board is a "FREE" space.

import java.util.Random;
public class Bingo{
	int [][] bingos = new int[5][5]; // this is the array that contains the numbers of the bingo board in the format [rows] [columns]
	Random rand; // this is a random number generator
	public static void main(String [] args){
		Bingo b = new Bingo();
		b.createBoard();
	
	
	}
	
	public Bingo(){ //iniitilaizes both the number generator as well as inputing values into the array
		rand = new Random();
		initializeArray();
		
	}

	public void createBoard(){//creates the board of the game (like a run() method for the case of this program)
		drawHeading(); 
		writeArray();
		System.out.println(); //extra line to make it look nice

	}
	public void drawHeading(){ //draws the heading of the bingo board
		System.out.println("\n-----------------------------");
		System.out.println("| B     I     N     G     O |");
		System.out.println("-----------------------------");
		
	}
	public void initializeArray(){ //initializes the array to have numbers that work for the game
		for (int col = 0; col < 5; col ++){ //the way i initialize numbers is column by column - as those are supposed to share characteristics
			for (int row = 0; row < 5; row ++){ //i initizialize each row of a column 
				if (col == 0) bingos[row][col] = number(1,15, col, row); //1,15 specifies the range of the random numbers that can be generated 
				else if (col == 1) bingos[row][col] = number(16,30, col, row); //in addition, lines like these check to make sure no rows before it in the column have the same number (if there is, reinitialize)
				else if (col == 2) {
					if (row == 2)  bingos[row][col] = 0; //this takes care of the critical (3,3) spot (free spot) - initializes it to 0 - will be an unique 0, which can easily be checked for later
					else bingos[row][col] = number(31,45,col,row);
				}
				else if (col == 3) bingos[row][col] = number(46,60,col,row);
				else if (col == 4) bingos[row][col] = number(61, 75, col, row);
			}
		}
	}
	public int number(int f, int l, int c , int r){ //this method generates a random number. in addition, it makes sure that no numbers within the column are the same
		//int f - lowest bound of random number to be generated
		//int l - high bound of random number to be generated
		//int c - column that is being worked in within bingos
		//int r - row of the number that is being generated within bingos
		boolean redo = true; //tells when to stop generating numbers
		int checker = 0; //if checker increments, it means that there is a same number within the array
		int rg = 0; //the integer which holds the randomly generated number at the time
		while(redo){
			rg = (rand.nextInt(((l-f)+1)) + f); // generates a random number within the bounds specified

			checker = 0; //checker is set to 0 
			for (int i = 1; i <= r; i++){ 
				if (bingos[r-i][c] == rg){ //checks each previous row if s the same as rg
					checker ++; //if it is, checker increments
				}
			}
			if (checker ==0){ //if checker has not been incremented, it means that there were no same numbers. then, redo is set to false and it exits the loop
				redo = false;
			}
		}
		return  rg; //returns rg 
	
	}
	public void writeArray(){
		
		for (int row = 0; row < 5; row ++){ //this time starts with row - prints across
			System.out.print("  ");  //offsets by 2 spaces
			for (int col = 0; col < 5; col++){ // prints it column by column
				if (bingos[row][col] == 0){ // remember, when set to zero it means to print free
					System.out.printf("%7s", "FREE");
				}
				else{
					if (col  ==3 && row == 2) System.out.printf("%5d", bingos[row][col]); //because free was an irregular figure, it means that the number right after it must be printed specially
					else if (col ==0) System.out.printf("%2d",bingos[row][col]); // the first one only should be moved over by 2, because that's the number of spaces
					else System.out.printf("%6d", bingos[row][col]); //moves over 6 everytime
				} 
			}
			System.out.println(); //moves it down to a new line everytime
		}
	}
}
