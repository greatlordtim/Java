// Jimmy Liu
// Septermber 26, 2012
// Quadratic.java
// This program takes in number inputs and computes quadratics. 

import java.util.Scanner;

public class Quadratic  {
public static void main (String [] args) {
      Scanner keyboard = new Scanner(System.in);
        System.out.print("a        -->   ");
	    double a = keyboard.nextDouble();
		System.out.print("b        -->   ");
		double b = keyboard.nextDouble();
		System.out.print("c        -->   ");
		double c = keyboard.nextDouble();
        
      System.out.printf("%.4fx^2 + %.4fx + %.4f = 0\n",a,b,c);
      double d = (-b + (Math.sqrt(Math.pow(b,2) -4*a*c)))/(2*a);
      double e = (-b - (Math.sqrt(Math.pow(b,2) -4*a*c)))/(2*a);
      System.out.printf("%.4f\n",d);
      System.out.printf("%.4f\n",e);
      
	}  // end main
	
}  // end Quadratic
