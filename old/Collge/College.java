// Jimmy Liu
// October 17, 2012
// College.java
// Get's schedule options from user, prints out their chosen schedule

//  Class Variables
// 	english - the english class the user choses
// 	math - the math class the user choses
// 	science - the science class the user choses

// 	Class Methods  
// 	GetRows() - Get input from the users for classes
// 	Print() - Prints out classes

import java.util.Scanner;
public class College {
	private char english;     
	private char math; 
	private char science; 
    Scanner input = new Scanner ( System.in );
    public College () { 
    	english = 0;
    	math = 0;
   	    science = 0;
    }
public void GetRows ( ) {
		Scanner input = new Scanner ( System.in );
		System.out.printf ("Welcome to SCHEDULE CHOOSER\n\n");
		System.out.printf ("Here are four possible English classes:\n");
		System.out.printf ("\t (1)	Lit\n");
		System.out.printf ("\t (2)	Lit Honors\n");
		System.out.printf ("\t (3)	Lit AP\n");
		System.out.printf ("\t (4)	Lit with Romney\n");
		System.out.printf ("\nChoose One Class (1-4)  -> ");
	    english = input.nextLine().charAt(0);
	    System.out.printf ("\nHere are four possible Math classes:\n");
	    System.out.printf ("\t (1)	Math class\n");
		System.out.printf ("\t (2)	Advanced Math Class\n");
		System.out.printf ("\t (3)	Super Math Class\n");
		System.out.printf ("\t (4)	Herp Math Class\n");
		System.out.printf ("\nChoose One Class (1-4)  -> ");
		math = input.nextLine().charAt(0);
		System.out.printf ("\nHere are four possible Science classes:\n");
	    System.out.printf ("\t (1)	Ms. Lerner\n");
		System.out.printf ("\t (2)	Ms. Lerner again\n");
		System.out.printf ("\t (3)	Ms. Lerner D:\n");
		System.out.printf ("\t (4)	More Ms. Lerner\n");
		System.out.printf ("\nChoose One Class (1-4)  -> ");
		science = input.nextLine().charAt(0);
	}
public void Print ( ) {
		System.out.printf ("\n\nTHANK YOU, HERE IS YOUR CLASS SCHEDULE:\n\n");
		switch (english) {
			case '1': System.out.print ("Lit\n"); break;
			case '2': System.out.print ("Lit Honors\n"); break; 
			case '3': System.out.print ("Lit AP\n"); break;
			case '4': System.out.print ("Lit with Romney\n"); break;
		}
		switch (math) {
			case '1': System.out.print ("Math class\n"); break;
			case '2': System.out.print ("Advanced Math Class\n"); break; 
			case '3': System.out.print ("Super Math Class\n"); break;
			case '4': System.out.print ("Herp Math Class\n"); break;
		}
		switch (science) {
			case '1': System.out.print ("Ms. Lerner\n"); break;
			case '2': System.out.print ("Ms. Lerner again\n"); break; 
			case '3': System.out.print ("Ms. Lerner D:\n"); break;
			case '4': System.out.print ("More Ms. Lerner\n"); break;
		}
		System.out.println("");
	
	}



	public static void main (String [] args) {

	College college = new College ( );
	college.GetRows ( );
	college.Print ( );
}
}



