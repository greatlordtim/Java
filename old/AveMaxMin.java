//Jimmy Liu
//January 10, 2012
//AveMaxMin.java
//This program takes in text from numbers.txt, takes average, max, min, and outputs to output.txt

//Class Variable
//	File infile: File numbers.txt
//	File outfile: File output.txt 
//	PrintWriter output: PrintWriter for output.txt
//	total: int total addition of numbers
//	count: double total count of numbers

//Class Methods
//	Average(): Takes the averages of the numbers
//	Max(): Takes the maximum of the numbers
//	Min(): Takes the minimum of the numbers

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AveMaxMin {
	private File infile;
	private File outfile;
	private PrintWriter output;
    private Scanner input;
    private double count;
    private int total;
    
    public AveMaxMin () {	// Constructor
        infile = new File ("numbers.txt");
        outfile= new File ("output.txt");
        try { //Create output.txt
    		    output = new PrintWriter (outfile);
	    	} catch (IOException e) {
			System.err.println("ERROR: Cannot write to file output.txt");
			System.exit(1);
		}
	}

public static void main (String [] args) {
		AveMaxMin amm = new AveMaxMin ();
		amm.Average();
		amm.Max();
		amm.Min();
	}	//End Main
	
public void Average() {
	try { //Open numbers.txt
        input = new Scanner (infile);
    } catch (FileNotFoundException e) {
    		System.err.println("ERROR: Cannot open file numbers.txt");
			System.exit(1);
		}
		while(input.hasNextInt()) {
			int i  = input.nextInt();
			total = i + total;
			count++;
			}
		count = total / count;
		System.out.printf("Average: %.3f\n", count);
		output.printf("Average: %.3f\n", count);
		}
	
public void Max() {
	try { //Open numbers.txt
        input = new Scanner (infile);
    } catch (FileNotFoundException e) {
    		System.err.println("ERROR: Cannot open file numbers.txt");
			System.exit(1);
		}
		int i  = input.nextInt();
		while(input.hasNextInt()) {
		int j = input.nextInt();
			if (j > i) {
				i = j;
				}
			}
		System.out.println ("Maximum: " + i);
		output.println("Maximum: " + i);
		}
		
public void Min () {
	try { //Open numbers.txt
        input = new Scanner (infile);
    } catch (FileNotFoundException e) {
    		System.err.println("ERROR: Cannot open file numbers.txt");
			System.exit(1);
		}
		int i  = input.nextInt();
		while(input.hasNextInt()) {
		int j = input.nextInt();
			if (j < i) {
				i = j;
				}
			}
		System.out.println ("Minimum: " + i);
		output.println("Minimum: " + i);
		output.close();
		}
}
