// BigArrayExample.java
// This program provides examples using arrays
// Topics: 
// 1) Declaring arryas and Memory Allocation
// 2) Initalizing arrays
// 3) Length of arrays
// 4) Passing arrays as parameters

public class BigArrayExample {
	public static void main(String [] args) {
		BigArrayExample ae = new BigArrayExample();
		ae.Run();
		}
	
	
	public void Run() {
	// 1) Declaring arrys and memory allocation
	char [] alphabet; //declar array
	alphabet = new char[26]; //allocating memory
	int numInt = 100;
	int [] integers = new int [numInt]; //declares and allocates memorey
	
	// 2) Initializing Array
	for (int i=0; i <26; i++) {
		alphabet [i] = (char)('A' + i);
		
	}
	
	// Initialize interger array
	for (int i = 0; i <numInt; i++) {
		integers[i] = i + 1; 
		
	}
	
	// 3) Length of Array
	//Print Alphabet
	
	for (int i = 0; i < alphabet.length; i++) {
		System.out.print(alphabet[i]);
		System.out.println();
	}
	
	// 4) Passing array as a parameter
	
	PrintArray(integers);
	ChangeIndex(19, -1, integers);                         
	ChangeIndex(39, -2, integers);
	ChangeIndex(59, -3, integers);
	PrintArray(integers);
	
	
	} // end Run
	
	public void PrintArray(int [] arr) {
		// Print 100 values, 20 at a time
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%4d", arr[i]);
			if (((i +1) % 20) ==0) System.out.println();
			}
			System.out.println();	
			
			
		}
		
	public void ChangeIndex(int index, int value, int[] arr) 
	{
		arr[index] = value;
	
	}
}

   // end class BigArrayExample

//Difference between array length and length between string