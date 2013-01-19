// Jimmy Liu
// Januarary 7, 2013
// ASCIIToText.java
// This program takes in ASCII input and converts it to text, exporting a .txt file

//Class Variable
//	File iofile - File object of output.txt
//	File ASCII - File object of ASCII.txt
//	PrintWriter output - Printwriter object to write output.txt

//Class Methods
//	ReadIt() - Reads the file, converts ASCII to char, and saves as output.txt

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ASCIIToText {
    private File iofile;
    private File ASCII;
    private PrintWriter output;
    private Scanner input;

	public ASCIIToText () {	// Constructor
        ASCII = new File ("ASCII.txt");
        iofile = new File ("output.txt");
	}
	

public static void main (String [] args) {
    	ASCIIToText asc = new ASCIIToText ();
		asc.ReadIt();
	}	//End Main
    
public void ReadIt() { //Start ReadIt()
    try { //Open ASCII.txt
        input = new Scanner (ASCII);
    } catch (FileNotFoundException e) {
    		System.err.println("ERROR: Cannot open file ASCII.txt");
			System.exit(1);
		}
		 try { //Create output.txt
    		    output = new PrintWriter (iofile);
	    	} catch (IOException e) {
			System.err.println("ERROR: Cannot write to file output.txt");
			System.exit(1);
		}
        while(input.hasNext()) {
      		  int i  = input.nextInt();
      		  String aChar = new Character((char)i).toString(); //Convert ASCII to char
              output.print(aChar); //Write char to output.txt
       
     }
     output.close();
  } //End ReadIt()   
} //End Program