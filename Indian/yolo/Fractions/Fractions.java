//Anindit Gopalakrishnan
//September 20, 2012
//Fractions.java
//This program will use printf formatting to align numbers and print the
//product in decimal form.
import java.util.Scanner;
public class Fractions{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String name;
		int numerator1;
		int numerator2;
		int denominator1;
		int denominator2;
		double productNumerator;
		double productDenominator;
		double quotientNumerator;
		double quotientDenominator;
		double sumNumerator;
		double sumDenominator;
		double differenceNumerator;
		double differenceDenominator; 
		double quotient;
		double product;
		double sum;
		double difference;
		String fractionLine1 = "--";
		String fractionLine2 = "---";
		String multiplicationSign = "x";
		String divideSign = "/";
		String addSign = "+";
		String subtractSign = "-";
		String equalsSign = "=";
	
		System.out.print("\n\nEnter your full name here       ->  ");
		name = scan.nextLine();
		System.out.print("Enter the first numerator       ->  ");
		numerator1 = scan.nextInt();
		System.out.print("Enter the first denominator     ->  ");
		denominator1 = scan.nextInt();
		System.out.print("Enter the second numerator      ->  ");
		numerator2 = scan.nextInt();
		System.out.print("Enter the second denominator    ->  ");
		denominator2 = scan.nextInt();
		
		productNumerator = (numerator1*numerator2);
		productDenominator = (denominator1*denominator2);
		product = productNumerator/productDenominator;
		
		quotientNumerator = (numerator1*denominator2);
		quotientDenominator = (numerator2*denominator1);
		quotient = quotientNumerator/quotientDenominator;
		
		sumNumerator = (numerator1*denominator2) + (numerator2*denominator1);
		sumDenominator = (denominator1*denominator2);
		sum = sumNumerator/sumDenominator;
		
		differenceNumerator = (numerator1*denominator2) - (numerator2*denominator1);
		differenceDenominator = denominator1 * denominator2;
		difference = differenceNumerator/differenceDenominator;
		
		
		System.out.print("\n\nNice job, " + name + ", here are the results for your two fractions:");
		
		System.out.printf("\n\n%14d %13d %13d", numerator1, numerator2, (int)productNumerator);
		System.out.printf("\nProduct %6s %6s %6s %6s %6s %6s %6.3f" , fractionLine1, multiplicationSign, fractionLine1, equalsSign, fractionLine2, equalsSign, product);
		System.out.printf("\n%14d %13d %13d", denominator1, denominator2, (int)productDenominator);

		System.out.printf("\n\n%14d %13d %13d", numerator1, numerator2, (int)quotientNumerator);
		System.out.printf("\nQuotient%6s %6s %6s %6s %6s %6s %6.3f" , fractionLine1, divideSign, fractionLine1, equalsSign, fractionLine2, equalsSign, quotient);
		System.out.printf("\n%14d %13d %13d", denominator1, denominator2, (int)quotientDenominator);

		System.out.printf("\n\n%14d %13d %13d", numerator1, numerator2, (int)sumNumerator);
		System.out.printf("\nSum     %6s %6s %6s %6s %6s %6s %6.3f" , fractionLine1, addSign, fractionLine1, equalsSign, fractionLine2, equalsSign, sum);
		System.out.printf("\n%14d %13d %13d", denominator1, denominator2, (int)sumDenominator);

		System.out.printf("\n\n%14d %13d %13d", numerator1, numerator2, (int)differenceNumerator);
		System.out.printf("\nDifference%4s %6s %6s %6s %6s %6s %6.3f" , fractionLine1, subtractSign, fractionLine1, equalsSign, fractionLine2, equalsSign, difference);
		System.out.printf("\n%14d %13d %13d\n", denominator1, denominator2, (int)differenceDenominator);

		
		
		
		
		
	
	}

}
