// Mr Greenstein
// November 5, 2012
// StringExample.java
// A program to display examples of String declaration, intialization, and methods

import java.util.Scanner;

public class Transform {
	private String str1;
	private char letter;
	private char number;
	private char option;
	private char c1;
	Scanner input = new Scanner (System.in);
	public Transform () { 
	c1 = 0;
	}

public void derp () {
	System.out.print("Enter a phrase ->  ");
	String str1 = new String (input.nextLine());
	System.out.print("\n\nEnter a index value to change ->  ");
	number = input.nextLine().charAt(0);
	System.out.print("\n\nEnter the new letter, to replace the '");
	char c1 = str1.charAt(number);
	System.out.print (c1 + "'");
    letter = input.nextLine().charAt(0);
    System.out.print ("Here is your phrase:\n");
	System.out.print (str1);
	//	input.nextLine();
	
    
    
    System.out.print ("Would you like to replace another character?");
    option = input.nextLine().charAt(0);
    if ((option == 'y') || (option == 'Y')) {
  		derp ( );
	}
	else {
		System.out.print ("Goodbye!");
	}
}
    
   
    
public static void main (String [] args) {
	Transform transform = new Transform ( );
	transform.derp ( );
	}
}	
	