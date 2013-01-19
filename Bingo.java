// Jimmy Liu
// Janurary 14, 2013
// Bingo.java
// This program generates a bingo board, with a free space in the middle

//Class Variables:
// 	Table - String array that has the main bingo board

//Class Methods:
//	Print() - Prints out the Bingo game 
//	Board() - Runs the main game
//		WriteTable() - Creates the Bingo board, with a FREE in the center
//		PrintTable() - Prints out the table WriteTable() has created
//		checknum()   - Boolean that checks to see if number is duplicated twice in a column
//		RandomNum()  - Generates a random number (String) using a switch statement depending on column #

public class Bingo {
	private String[][] table = new String[5][5]; 
	
	public Bingo () { //Constructor
	}
	
	public static void main (String [] args) {
	Bingo bingo = new Bingo(); 
	bingo.Print();
	bingo.Board();
	}
	
	public void Print () {
		System.out.println("---------------------------------");
		System.out.println("|    B     I     N     G     O  |");
		System.out.println("---------------------------------");
	}
	
	public void Board () { 
		WriteTable(table);
		PrintTable(table);
	}
	
	private void WriteTable (String table [] []) { 
		for (int row = 0; row < table.length; row++)   {
			for (int col = 0; col < table[row].length; col++) { //Write main table, 5x5
				if ((row == 2) && (col == 2)) { 	//If 2, 2 (3, 3) in middle, write FREE
					table [row][col] = "FREE"; 
				}
				else 
				table [row][col] = RandomNum(col); //Generate Random Number
			}
		}
	}
	
	public void PrintTable ( String [][] table )   {
		for (int row = 0; row < table.length; row++)   {
			for (int col = 0; col < table[row].length; col++) { 
				System.out.printf("%6s", table[row][col]);	//6 spacing between numbers, print out table
				}
			System.out.println ();
		}
	}
	
	private boolean checknum (int generate, int column) {
		for (int row = 0; row < table.length; row++)   { 
			for (int col = 0; col < table[row].length; col++) { 
				if((table[row][col] != "FREE") && (table[row][col] != null)) {
					if (generate == Integer.parseInt(table[row][col])&& column == col) {
						return true;
						}
				}
				
			}
		
		}
		return false;
	}
	
	private String RandomNum(int col) {
		int generate = 1;
		switch (col) {
		
		case 0: {
			generate = 1+(int)(Math.random() * (15)); 
			break;
			}
		
		case 1: {
			generate = 16+(int)(Math.random() * (15)); 
			break;
			}
		
		case 2: {
			generate = 31+(int)(Math.random() * (15)); 
			break;
			}
		
		case 3: {
			generate = 46+(int)(Math.random() * (15)); 
			break;
			}
		case 4: {
			generate = 61+(int)(Math.random() * (15)); 
			break;
			}
		}
		
		while (checknum(generate, col)) {
			return RandomNum(col);
		}
		return "" + generate;
	}
} // End Bingo
