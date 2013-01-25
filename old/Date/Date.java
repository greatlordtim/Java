// Jimmy Liu
// Septermber 17. 2012
// Date.java
// This program gives a sample of using the Scanner Class.

import java.util.Scanner;

public class Date {
	public static void main (String [] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the cost of a single entree        -->   ");
		float e = kb.nextFloat();
		System.out.print("Enter the cost of a single beverage      -->   ");	
		float b = kb.nextFloat();
		System.out.print("Enter the cost of a movie ticket         -->   ");
		float m = kb.nextFloat();
		 System.out.println ();
        System.out.printf ("Entree subtotal =                        $ %.2f\n", 2 * e);
        System.out.printf ("Beverage subtotal =                      $ %.2f\n", 2 * b);
        System.out.printf ("Entree and Beverage Tax =                $ %.2f\n", 0.0875 * (2 * e+ 2 * b) );
        System.out.printf ("Tip =                                    $ %.2f\n", 0.15 * 1.0875 * (2 * e+ 2 * b) );
        System.out.printf ("Meal Total =                             $ %.2f\n", (2*e) + (2*b) + (0.0875 * (2*e+2*b)) + (0.15 * 1.0875 *  (2*e+2*b)) );
        System.out.printf ("Movie =                                   $ %.2f\n", 2 * m );
        System.out.printf ("Movie Tax =                              $ %.2f\n", 0.0875 * (2*m));
        System.out.printf ("Movie Total =                            $ %.2f\n", (2 * m) + (0.0875 * (2 * m)) );
         System.out.println ();
         System.out.printf ("You spent $%.2f", (0.0875 * (2*e+2*b+2*m) + (2*e+2*b+2*m) + (0.15 * 1.0875 * (2*e+2*b)) )); 
         System.out.println (" on your date!"); 
			} // end main
	
	
}  // end class Scanner
