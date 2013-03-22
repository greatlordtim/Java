//Anindit Gopalakrishnan
//January 9th, 2012
//ASCIItoText.java
//This program will read a file that has lines of ascii numbers. It will
//then write the translated output to another file and will read from that
//and will print it.

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

//class variables:
//File output: the file that holds the output message of the program
//Scanner scan: the object that actually reads the file with the ascii values
//PrintWriter pw: writer which actually writes out the message on to the output file
//String message: the string which contains the entire message of the file
//File asciiFile: points to ASCII.txt

//class methods:
//public void run(): does all the running of the program due to static conflicts
//public ASCIItoText(): Generic contsructor; sets everything to values that doesn't cause errors :)
//public void readFile(): Reads and converts the file from the input files; stores all data into a string
//public void writeOut(String s): Writes out s to the Output.txt
public class ASCIItoText{
	File output; 
	Scanner scan;
	PrintWriter pw;
	String message;
	File asciiFile;
	
	public static void main(String [] args){
		ASCIItoText a = new ASCIItoText();
		a.run();
	}
	public void run(){
		readFile();
		writeOut(message); //writes out whatever is the string message
	}
	public ASCIItoText(){
		output = new File ("Output.txt");
		asciiFile = new File("ASCII.txt"); //creates a filler file to hold the locatino of ASCII.txt
		try {
			scan = new Scanner(asciiFile); //tries to put the scanner on ASCII.txt, but if not, prints error message and exits
		} catch(FileNotFoundException e){
			System.err.println("ERROR: Cannot open file ASCII.txt");
			System.exit(1);
		}
		message  = ""; //initializes message to a null String
	}
	public void readFile(){
		while(scan.hasNext()){
			message +=	(char)scan.nextInt();	//adds on each character one at a time to message 
		}
		scan.close();
	}
	public void writeOut(String s){
		try { //tries creating a PrintWriter writes out to Output.txt, if not, prints an error message and exits
			pw = new PrintWriter(output);
		}catch(IOException e){
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(2);
		}
		pw.print(s);
		pw.close(); //closes pw
		
	}
}
