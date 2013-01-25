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
		
		//long l = kb.nextLong();
		//float fl = kb.nextFloat();
		//double d = kb.nextDouble();
		
		kb.nextLine();  //flush buffer after nextDouble
		
		System.out.print ("Input a sentence -> ");
		String str = kb.nextLine();
		System.out.println ("Your sentence is: " + str);
		
	} // end main
	
	
}  // end class Scanner
