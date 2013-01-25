// Jeffrey Zhang
// November 8, 2012
// Encrypt.java
// This program uses string methods and character operators to modify 
// a sentence.

// class methods
//		getInfo()				Ask user to input a word, phrase, or sentence.
// 		PrintNewEncryption()	Prints out the word, phrase, or sentence 13 times. Each time
//								, it increases each letter in the word, phrase, or sentence 
//								by two letters. The last print reverts the newest phrase into
//								the phrase the user orginally inputed.

// class variables				 
//		sentence				The word, phrase, or sentence the user inputs.
//		newSentence				The new word, phrase, or sentence after each letter in it 
//								is changed.
//		letter					The variable used to change y and z to a and b, respectively.
import java.util.Scanner;

public class Encrypt {
	private Scanner console;
	private String sentence, newSentence;
	private char letter;
	public Encrypt(){
		sentence = "";
	}
	public void getInfo(){
		console = new Scanner (System.in);
		System.out.println("Welcome to Encrypt.java. Please enter a word, phrase, or sentence.");
		System.out.println();
		System.out.print("->\t");
		sentence = console.nextLine();
	}
	public void PrintNewEncryption ( )   {
		for (int loop = 1; loop <= 13; loop++){
			System.out.println("Encryption "+loop+":");
		
			for ( int i = 0; i < sentence.length(); i++) {
				char c = sentence.charAt(i);
				if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
					if (c == 'y' ) {
						letter = 'a';
					}
					else if (c == 'Y') {
						letter = 'A';
					}
					else if (c == 'Z') {
						letter = 'B';
					}
					else if (c == 'z') {
						letter = 'b';
					}
						
					else {
						letter = (char)((int)(sentence.charAt(i))+2);
					}
				
				
					newSentence = sentence.substring (0,i)+letter+sentence.substring(i+1,sentence.length());
					sentence = new String(newSentence);
				}
			}
			System.out.println("\t"+newSentence+"\n");
	
		}
	}
		
	public static void main (String [] args) {
		Encrypt encrypt = new Encrypt();
		encrypt.getInfo();
		encrypt.PrintNewEncryption();
	} // end main
} // end class Encrypt