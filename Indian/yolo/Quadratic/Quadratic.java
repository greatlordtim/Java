//Anindit Gopalakrishnan
//September 26, 2012;
//Quadratic.java
//This program will take the inpit from the user to create a quadratic 
//print out the equation, and compute the 2 roots.

import java.util.Scanner;
import java.lang.Math;

public class Quadratic{ 
	public static void main(String[] args){
		Scanner scan   = new Scanner(System.in);
		double a;
		double b;
		double c;
		double underSquareRoot;
		double quadraticPlusLine;
		double quadraticMinusLine;
		double quadraticBottom;
		double x1;
		double x2;
		System.out.println("This program will allow a user to enter and solve a quadratic equation in standard form.");
		while(true){
		
		
			System.out.print("Enter your value for a:   a = ");
			a = scan.nextDouble();
			System.out.print("Enter your value for b:   b = ");
			b = scan.nextDouble();
			System.out.print("Enter your value for c:   c = ");
			c = scan.nextDouble();
			System.out.println("Your equation is: \n");
			System.out.printf("%1.4fx^2 + %1.4fx + %1.4f = 0 \n\n" , a, b, c);
			
		
		
		
		underSquareRoot = Math.pow(b,2) - 4*a*c;
		quadraticPlusLine = -b + Math.sqrt(underSquareRoot);
		quadraticMinusLine = -b - Math.sqrt(underSquareRoot);
		quadraticBottom = 2*a;
		
		x1 = quadraticPlusLine/ quadraticBottom;
		x2 = quadraticMinusLine/quadraticBottom;


		System.out.printf("The roots of this equations are: %1.4f, %1.4f\n\n\n\n\n", x1, x2);
	
	}
}
}
