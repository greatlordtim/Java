// Jimmy Liu
// January 7, 2013
// HelloWorldWriteRead.java
// This program writes "Hello World!" to a text file "output.txt",
// then it reads the file and prints the contents to the screen.

// Class Variables
// File iofile			-File object for "output.txt"
// PrintWriter output   -PrintWriter object to print text to file

// Class Methods
// WriteIt()			-Opens output.txt file and prints "Hello World!" to it.
// ReadIt()				-Reads the file output.txt and prints the contents to the screen

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloWorldWriteRead {
	private File iofile;
	private PrintWriter output;
	private Scanner input;
	
	public HelloWorldWriteRead() {
		iofile = new File("output.txt");
	}
	
	public static void main (String[] args) {
		HelloWorldWriteRead hww = new HelloWorldWriteRead();
		hww.WriteIt();
		hww.ReadIt();
	} 

	public void WriteIt() {
		try {
			output = new PrintWriter (iofile); //Opening File to Write to it
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(1);
	}
	output.println("Hello world!");
	output.close();
	}
	
	public void ReadIt() {
		try {
			input = new Scanner(iofile);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot pen file output.txt");
			System.exit(1);
		}
		while (input.hasNext()) {
			System.out.println(input.nextLine());
		}
		input.close();
	}
}
