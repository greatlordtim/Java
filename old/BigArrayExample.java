// Mr Greenstein
// December 2, 2012
// BigArrayExample.java
//    Topics:
//		1) Declaring Arrays and Memory Allocation
//		2) Initializing arrays
//		3) Length of arrays
//		4) Passing array as parameter

import java.util.Scanner;

public class BigArrayExample {


	public static void main (String[] args) {
		BigArrayExample ae = new BigArrayExample();
		ae.Run();
	}
	
	public void Run() {	
		
		//>> 1) Declaring arrays and Memory Allocation
		char [] alphabet;			// declare array
		alphabet = new char[26];	// allocate 26 storage locations
		int numInt = 100;
		int [] integers = new int [numInt];	// declare and allocate 100 storage locations

		//>> 2) Initializing arrays
		// Initialize alphabet array
		for (int i = 0; i < 26; i++)
			alphabet[i] = (char)('A' + i);
		// Initialize number array
		for (int i = 0; i < numInt; i++)
			integers[i] = i + 1;

		//>> 3) Length of array		
		// Print alphabet
		for (int i = 0; i < alphabet.length; i++)
			System.out.print(alphabet[i]);
		System.out.println();
		
		//>> 4) Passing array
		PrintArray(integers);
		ChangeIndex(19, -1, integers);
		ChangeIndex(39, -2, integers);
		ChangeIndex(59, -3, integers);
		ChangeIndex(79, -4, integers);
		PrintArray(integers);
				
	}	// end Run
	
	public void PrintArray(int[] arr) {
		// Print 100 values, 20 at a time
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%3d ", arr[i]);
			if (((i+1) % 20) == 0) System.out.println();
		}
		System.out.println();
	}	// end PrintArray
	
	public void ChangeIndex(int index, int value, int[] arr) {
		arr[index] = value;
	}	// end ChangeIndex
	
}	// end class ArrayExample
//
// Exercises:
//	A) Use String method "toCharArray()" and convert a string into an array of characters
//	B) Print out the array of characters from A) backwards


To Java Main Page