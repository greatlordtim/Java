// Jimmy Liu
// November 9, 2012
// Encrypt.java
// This program encrypts a phrase 13 times until the original comes up again

// Class Variables	
// str1 - Phrase that the user provides
// str2 - New phrase after encryption
// hello - Changed character after encryption
// letter - Character from sentence

// Class Methods
// derp() - Runs the main program, encrypts the phrase, prints it out. 

import java.util.Scanner;

public class Encrypt {
	Scanner input = new Scanner (System.in);
	private String str1 = new String();
	private String str2 = new String();
	private char hello, letter;
	private int loop, number;
	
	
	public Encrypt () {
	loop = 1;
	number = 0;
	hello = 0;
	letter = 0;
	
 } 
 	

public void derp () {
	System.out.println ("Welcome to Encrypt.java. Please enter a word, phrase, or sentence.\n");
	System.out.print ("->\t");
	str1 = input.nextLine();
	while (loop <= 13){
		System.out.println("Encryption " + loop + ":");
		loop++;
		for ( int number = 0; number < str1.length(); number++) {
			letter = str1.charAt(number);
			if (((letter >= 65) && (letter <= 90)) || ((letter >= 97) && (letter <= 122))){
				if (letter == 'y' ) {
					hello = 'a';
				}
				else if (letter == 'Y') {
					hello = 'A';
				}
				else if (letter == 'Z') {
						hello = 'B';
				}
				else if (letter == 'z') {
					hello = 'b';
				}		
				else {
					hello = (char)((int)(str1.charAt(number))+2);
				}	
				
				str2 = str1.substring (0,number)+hello+str1.substring(number+1,str1.length());
				str1 = new String(str2);
			}
		}
		System.out.println("     " + str2 + "\n");
	
	}
}

public static void main (String [] args) {
	Encrypt encrypt = new Encrypt ( );
	encrypt.derp ( );
	}
	
}