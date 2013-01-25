// Jimmy Liu
// November 9, 2012
// Transform.java
// This program changes charcaters a user prints

// Class Variable
// letter - char of the letter the user choses to replace
// number - char of what number of letter the user choses
// option - yes or no to continue 
// str1 - String the user inputs for the sentence

// Class Methods  
// derp() - Runs letter changing and for loop for yes/no.  

import java.util.Scanner;

public class Transform {
	private String str1;
	private char letter;
	private char number;
	private char option;
	Scanner input = new Scanner (System.in);
	public Transform () { 
		System.out.print("Enter a phrase ->  ");
		str1 = new String (input.nextLine());
	}

public void derp () {
	System.out.print("\nEnter a index value to change ->  ");
	number = input.nextLine().charAt(0);
	number -= 48;
	char c1 = str1.charAt(number);
	System.out.print("\nEnter the new letter, to replace the '");
	System.out.print (c1 + "' ->  ");
    letter = input.nextLine().charAt(0);
    System.out.print ("\nHere is your phrase:");
	str1 = str1.substring(0, number) + letter + str1.substring(number+1);
	System.out.println ("\n\t" + str1 + "\n");
	//	input.nextLine();
	
    
    
    System.out.print ("Would you like to replace another character? ");
    option = input.nextLine().charAt(0);
    if ((option == 'y') || (option == 'Y')) {
  		derp ( );
	}
	else {
		System.out.print ("\nGoodbye!\n");
	}
}
    
   
    
public static void main (String [] args) {
	Transform transform = new Transform ( );
	transform.derp ( );
	}
}	
	
