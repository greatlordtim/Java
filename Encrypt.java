// Jimmy Liu
// November 9, 2012
// Encrypt.java
// This program changes charcaters a user prints

import java.util.Scanner;

public class Encrypt {
	Scanner input = new Scanner (System.in);
	private String str1;
	private int count;
	public Encrypt () {
 	count = 1;
 	} 
	
public void derp () {
	System.out.print ("Welcome to Encrypt.java. Please enter a word, phrase, or sentence.\n\n");
	System.out.print ("->	");
	str1 = input.nextLine();
	while (count <= 9); {
		 System.out.print ("Encryption" + count+ "/n");
		 count++;
	}
		
} 

public static void main (String [] args) {
	Encrypt encrypt = new Encrypt ( );
	encrypt.derp ( );
	}
	
}