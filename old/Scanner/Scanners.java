// Jimmy Liu
// Septermber 17. 2012
// Scanners.java
// This program gives a sample of using the Scanner Class.

import java.util.Scanner;

public class Scanners {
	
	public static void main (String [] args) {
	
	   Scanner kb = new Scanner(System.in);
		
		System.out.print("Input an integer -> ");
		int i = kb.nextInt();
		System.out.println ("Your integer is " + i);	
		
	} // end main
	
	
}  // end class Scanner
