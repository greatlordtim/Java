// Mr Greenstein
// October 22, 2012
// LoopExample2.java
// An example of forloops and nested loops.

public class LoopExample2 {
	
   public static void main (String[] args) {
   	
   	// for loop example
   	
   	for (int col = 1; col < 10; col++) { // variables in for loop does not exist outside)
   		System.out.print (col);
   	}
   	System.out.println();
   	
   	// nexted for loops
   	for (int row = 1; row < 10; row++) {
   		for (int col = 1; col <= row; col++) {
   			System.out.print (col);
   			}
   			System.out.println();
		}
		
} // end main

} // end class LoopExample2
