// Jimmy Liu
// November 9, 2012
// Encrypt.java
// This program changes charcaters a user prints

import java.util.Scanner;

public class Encrypt {
	Scanner input = new Scanner (System.in);
	private String str1 = new String();
	private int count, derp;
	private char hello, i;
	private int length;
	
	
	public Encrypt () {
	count = 1;
	derp=0;
	 i = 2;
	
 	} 
 	
	
public void derp () {
	System.out.print ("Welcome to Encrypt.java. Please enter a word, phrase, or sentence.\n\n");
	System.out.print ("->	");
	str1 = input.nextLine();
	while (count <= 9) {
		 System.out.println ("\n\nEncryption" + count);
		 length = str1.length();
		 while (derp !=  length) {
			 hello=str1.charAt(derp);
			 if ((hello<65) || (hello>123)){
				 System.out.print (hello);
			 }
			 else {
			 hello = (char) (hello + i);
			 if (hello>=123) {
				 hello = (char) (hello - 5 );
				  System.out.print (hello);
			 }
			 else {
			 System.out.print (hello);
			 }
			 }
			 derp++;
			 i++;
			 i++;
		 }
		 derp=0;
		 count++;
	}
		
} 

public static void main (String [] args) {
	Encrypt encrypt = new Encrypt ( );
	encrypt.derp ( );
	}
	
}