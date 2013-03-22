// Anindit Gopalakrishnan
//November 8, 2012
//Encrypt.java
//This program will let the user enter a sentece and then will encrypt the sentence
//13 times by increasing each letter by 2 everythime without changing any numbers
//or letters or symbols or cases.

import java.util.Scanner; 

public class Encrypt{
	String phrase; //holds the phrase 
	
	int length; //holds the length of the string
	Scanner scan;//Scanner object - gets input from user
	public Encrypt(){
		phrase  = "";
		length = 0;
		scan = new Scanner(System.in);
	}
	public static void main(String[] args){
		Encrypt e = new Encrypt();
		e.doProgram();
	}
	public void doProgram(){//actually runs the program because of static conflics
		getPhrase();
		for (int i = 0; i < 13; i++){//this loop encrypts an entire phrase 13 times
			System.out.print("\n");
			encryptPhrase((i+1));
		}
	}
	
	public void getPhrase(){//gets the phrase from the user
		System.out.print("Welcome to Encrypt.java. Please enter a word, phrase, or sentence. \n->  ");
		phrase = scan.nextLine();
		length = phrase.length();
	}

	public void encryptPhrase( int x){//this encrypts an entire line of the program calling the encryptChar method
		String phraseMaker = "";
		System.out.println("Encryption " + x + ":");
		for(int i = 0; i < length; i ++){
			char c = phrase.charAt(i);
			c = encryptChar(c);
			phraseMaker  += c;
		}
		phrase  = phraseMaker;
		System.out.println(phrase);
		
	}
		
	public char encryptChar(char c){//this method encrypts an individual char. It does not encrypt symbols, only letters.
		int hold = c;
		boolean inRange  = ((hold >=65) && (hold <= 90)) || ((hold >=97) && (hold <=122));
		if (!inRange){
			return c;
		}
		hold += 2;
		if (hold ==92 ){
			hold = 66;
		}
		else if (hold == 91){
			hold = 65;
		}
		else if (hold == 124){
			hold =  98;
		}
		else if (hold == 123){
			hold = 97;
		}
		c  = (char) hold;
		
		return c;
		
	}	
}
