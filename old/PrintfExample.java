// Jimmy Liu
// September 19, 2012
// PrintfExample.java
// This program shows different ways to format using printf. 

public class PrintfExample {
	
	public static void main (String [] args) {
	
	double d1 = 1234.56789;
	int i = 987654321;
	int j = 21;	
	char ch = 'A';
	String str = new String("This class is awesome!");
	// String str = "This class is awesome!";
	
	System.out.printf("This is my integer %d\n", i); 
	System.out.printf("This is my integer %12d\n", i); 
	System.out.printf("This is my integer %12d\n", j); 
	System.out.printf("This is my integer %,12d\n", i); 	
	System.out.printf("Here is my float %,9.2f\n", d1); 	
	
	System.out.printf("My character is %c\n", ch);
	System.out.printf("My sentence is: %s\n", str);
	
	System.out.printf("%15d\t%15d\t", i, j);
	
	} // end main
	
} // end class PrintfExample
