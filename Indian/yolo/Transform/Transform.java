//Anindit Gopalakrishnan
//November 7, 2012
//Transform.java
//This program will allow the user to enter a word and change it letter
//by letter.
import java.util.Scanner;
public class Transform {
	int index, length ;  
	private char oldChar;
	private String phrase, bS, aS , newChar, repeat;
	private boolean done, y, n;
	Scanner scan;
	public static void main (String[] args){
		Transform t = new Transform();
		t.getPhrase();
		t.runProgram();
		System.out.println("\n Goodbye!");	
	}
	void runProgram(){
		while(!done){
			changeLetter();	
		}
	}
	public Transform(){
		index = 0;
		length = 1;
		oldChar = ' ';
		bS = "";
		aS = "";
		newChar = "";
		repeat = "";
		scan = new Scanner(System.in);
	}
	void getPhrase(){
		System.out.print("Enter a phrase  -> ");
		phrase = scan.nextLine();
		length  = phrase.length();
	}
	void changeLetter(){
		boolean b, b1;
		do{
			System.out.print("\nEnter an index value to change -> " );
			index = scan.nextInt();
			scan.nextLine();
			 b = (index >= 0) && (index < length);
		}
		while(!b);
		bS = phrase.substring(0,index);
		aS = phrase.substring((index+1));
		oldChar =  phrase.charAt(index);
		System.out.print("\nEnter the new letter or character to replace the '" + oldChar + "'  -> ");
		newChar = scan.nextLine();
		if (newChar.equals("<sp>")){
			newChar = " ";
		}
		System.out.println ("\nHere is the new phrase: ");
		phrase = bS + newChar + aS;
		System.out.println  ("        " + phrase); 
		do{
			System.out.print ("\nWould you like to replace another letter? ( 'Y' for yes, 'N' for no ) " ); 
			repeat = scan.nextLine();	
			y = repeat.equalsIgnoreCase("y");
			n = repeat.equalsIgnoreCase("n");
			 b1 = (y || n);
		}
		while (!b1);
		
		if (y){
			done = false;
		}
		if (n){
			done = true;
		}
	}
}
