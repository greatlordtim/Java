// Jimmy Liu
// Septermber 21. 2012
// Fractions.java
// This program recieves numbers and words and computes Fractions. 

import java.util.Scanner;

public class Fractions {
	public static void main (String [] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter your full name             -->   ");
	    String name = kb.nextLine();
		System.out.print("Enter the first numerator        -->   ");
		int b = kb.nextInt();
		System.out.print("Enter the first denominator      -->   ");
		int  c = kb.nextInt();
		System.out.print("Enter the second numerator       -->   ");
		int  d = kb.nextInt();
		System.out.print("Enter the second denominator     -->   ");
		int  e = kb.nextInt();
		System.out.println ();
		System.out.println("Nice job, " + name + ", here are the results for your two fractions:");
		System.out.println ();
		//end stuffies
		
        System.out.printf ("\t\t%d\t%d\t%d\n",b ,d ,b*d);	
        System.out.printf ("Product         --   x  --  =   ---  =  %7.3f\n",((double)b*d)/(c*e) );	
        System.out.printf ("\t\t%d\t%d\t%d\n",c ,e ,c*e);      
        	System.out.println ();
        	
            System.out.printf ("\t\t%d\t%d\t%d\n",b ,d ,b*e);	
        System.out.printf ("Quotient        --   /  --  =   ---  =  %7.3f\n",((double)b*e)/(c*d) );	
        System.out.printf ("\t\t%d\t%d\t%d\n",c ,e ,c*d);   
        	System.out.println ();
        	
            System.out.printf ("\t\t%d\t%d\t%d\n",b ,d ,(b*e)+(c*d));	
        System.out.printf ("Sum             --   +  --  =   ---  =  %7.3f\n",((double)(b*e)+(c*d))/(c*e) );	
        System.out.printf ("\t\t%d\t%d\t%d\n",c ,e ,c*e);   
        	System.out.println ();
        	
            System.out.printf ("\t\t%d\t%d\t%d\n",b ,d ,(b*e)-(c*d));	
        System.out.printf ("Difference      --   -  --  =   ---  =  %7.3f\n",((double)(b*e)-(c*d))/(c*e) );	
        System.out.printf ("\t\t%d\t%d\t%d\n",c ,e ,c*e);     
	
		
	} // end main
	
	
}  // end class Scanner
