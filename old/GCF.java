// Jimmy Liu
// December 8, 2012
// GCF.java
// This program takes in two numbers and prints out their GCF and does stuff.

// Class Variable
// first - First number to calculate GCF
// second - Second number to  calculatate GCF

// Class Methods
// GCF() - Calculates GCF of the two numbers you input

import java.util.Scanner;

public class GCF {
	Scanner input = new Scanner (System.in);
	public double first, second;
	public static void main (String [] args) {
		Derp derp = new Derp ();
		derp.Print();
	}
}

class Derp {
	public int first, second;
	Scanner input = new Scanner (System.in);
	public Derp () {
		first = 0;
		second = 0;
	}

	public void Print () {
	System.out.print("Enter first positive integer (0 to exit)	->	");
	first = input.nextInt();
	if (first == 0) {
		System.exit(0); 
	}
	while (first < 0) {
	System.out.print ("ERROR: Not a positive integer");
	System.out.println();
	System.out.print("Enter first positive integer (0 to exit)	->	");
	first = input.nextInt();
	}
	
	System.out.print("Enter second positive integer (0 to exit)	->	"); 
	second = input.nextInt(); 
	if (second == 0) {
		System.exit(0); 
	}
	while (second < 0) {
	System.out.print ("ERROR: Not a positive integer");
	System.out.println();
	System.out.print("Enter first positive integer (0 to exit)	->	");
	second = input.nextInt();
	}
	
	int hi = GCF(first, second);
	if (hi == 1)  {
		System.out.print (first + " and " + second + " are relatively prime");
		System.out.println ();
	}
	else {
		System.out.print("The GCF of " + first + " and " + second + " is " + hi);
		System.out.println ();
	}
	}
	public int GCF (int a, int b) {
		if (a > b) return GCF(a - b, b);
		else if (b > a) return GCF(a, b-a);
		else return a;
	}
}