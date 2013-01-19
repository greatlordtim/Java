// Jimmy Liu
// October 17, 2012
// LoopExample.java
// An example of counting from 1 to 10 using while and do-while loops

import java.util.Scanner;
public class Add {
	private int row;    // The number of rows for the addition table.
	private int column; // The number of columns for the addition table.
	private int loop; // Printing rolls
    private int lop; // printing columns
    private int derp;
    private int count;
    
	// Initializes the values of the above data members.
    public Add () { 
    row = 0;
    column = 0;
    }


	// Prompt the user to enter the number of rows in their addition table.
	// This value should be chosen from 2 to 30, and if the user enters a value
	// outside of this range, they should be prompted again.
	public void GetRows ( ) {
	Scanner input = new Scanner ( System.in );
	System.out.print ("Enter the number of rows to be shown ( 2- 30 )    ->     ");
	row = input.nextInt ();
	while ((row > 30) || (row < 2)) {
		System.out.print ("Enter the number of rows to be shown ( 2 -30 )  ->    ");
		row = input.nextInt ();
	}
	}
	
	
	public void GetColumns ( ) {
	Scanner input = new Scanner ( System.in );
	System.out.print ("Enter the number of columns to be shown ( 2- 12 ) ->     ");
	column = input.nextInt ();
	while ((column > 12) || (column < 2)) {
		System.out.print ("Enter the number of columns to be shown ( 2 - 12 )  ->   ");
		row = input.nextInt ();
		}
	}
	public void PrintAddTable ( ) { 
	// heading lines
	System.out.println ("Here is your table: ");
	System.out.println ("");
	System.out.print ("     |     ");
	for (loop = 1; loop <= column; loop++) {
		System.out.printf ("     %d     ", loop);
		}
	System.out.println ("");
	for (loop = 1; loop <= column; loop++) {
		System.out.print ("------------");
		}
	System.out.println ("");
	// actual numbers
	for (lop = 1; lop <= row; lop++) { // for loop for printing columns
		while (derp < lop) { // for loop for printing actual numbers 
			// for (count = 1; count <= column; count++) { // for loop for making numbers larger
			System.out.printf ("%d    |      %d", lop, count); 
			derp++;
			//}
		} //while loop
		
	
	System.out.println ("");	
		
		
		} // end lop
	
	}  // end printaddtable
	
} // end public class
	

   