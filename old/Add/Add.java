// Jimmy Liu
// October 17, 2012
// Add.java
// This program asks users for rows and columsn, and prints out a table. 

// Class Variables
// 	row - The number of rows for the addition table.
// 	column - The number of columns for the addition table.
// 	loop - Printing rolls
// 	lop - Printing columns

// 	Class methods  
// 	GetRows() - Get number of rolls from user
// 	GetColumns() - Get number of columns from user
// 	PrintAddTable() - Prints out the table

import java.util.Scanner;
public class Add {
	private int row;     
	private int column; 
	private int loop; 
    private int lop; 
    private int derp;
    private int count;
    Scanner input = new Scanner ( System.in );
    
	// Initializes the values of the above data members.
    public Add () { 
    	row = 0;
    	column = 0;
   	    derp = 0;
    	count = 1;
    }


	// Prompt the user to enter the number of rows in their addition table.
	// This value should be chosen from 2 to 30, and if the user enters a value
	// outside of this range, they should be prompted again.
	public void GetRows ( ) {
		System.out.print ("Enter the number of rows to be shown ( 2- 30 )    ->     ");
		row = input.nextInt ();
		while ((row > 30) || (row < 2)) {
			System.out.print ("Enter the number of rows to be shown ( 2 -30 )  ->    ");
			row = input.nextInt ();
		}
	}
	
	
	public void GetColumns ( ) {
		System.out.print ("Enter the number of columns to be shown ( 2- 12 ) ->     ");
		column = input.nextInt ();
		while ((column > 12) || (column < 2)) {
			System.out.print ("Enter the number of columns to be shown ( 2 - 12 )  ->   ");
			column = input.nextInt ();
			}
	}
	public void PrintAddTable ( ) { 
		System.out.println ("Here is your table: ");
		System.out.println ("");
		System.out.print ("\t|");
	for (loop = 1; loop <= column; loop++) {
		System.out.printf ("\t%d", loop);
		}
	System.out.println ("");
	System.out.print ("------");
	for (loop = 1; loop <= column; loop++) {
		System.out.print ("---------");
		}
	System.out.println ("");
	for (lop = 1; lop <= row; lop++) { // for loop for printing columns
		while (derp < lop) { // for loop for printing actual numbers 
			// for (count = 1; count <= column; count++) { // for loop for making numbers larger
			System.out.printf ("%d\t|", lop);
			for (int c = 1; c <= column; c++) {
				System.out.print ("\t" + ( lop + c ) );
			}
			derp++;
			// row + column
			// end while loop by > column + 1
	 // end if statement () 
			
			
			//}
		} // while loop
		
	
	System.out.println ("");

		
		} // end lop
	
	}  // end printaddtable
	
} // end public class
