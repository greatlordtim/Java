//Anindit Gopalakrishnan
//September 17, 2012
//Date.java
//This program will allow the user to input some information that regards
//to a date that the user went on. It will then compute the total cost.
import java.util.Scanner;
public class Date{
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		double mealCost;
		double beverageCost;
		double movieCost;
		double mealTax;
		double movieTax;
		double tip;
		double mealTotal;
		double movieTotal;
		double total;
		System.out.print("\nEnter the cost of a single entree          ->    $");
		mealCost = 2 * scan.nextDouble();
		System.out.print("Enter the cost of a single beverage        ->    $");
		beverageCost = 2 * scan.nextDouble();
		System.out.print("Enter the cost of a single movie ticket    ->    $");
		movieCost = 2 * scan.nextDouble();
		mealTax = .0875*(beverageCost + mealCost);
		movieTax = .0875 * movieCost;
		tip = 0.15*(beverageCost+mealCost + mealTax);
		mealTotal = mealCost + beverageCost + tip + mealTax;
		movieTotal = movieCost + movieTax;
		total = (mealTotal + movieTotal);
	
		System.out.printf("\n\nEntree Subtotal =           $%15.2f", mealCost);
	
		System.out.printf("\nBeverage Subtotal =         $%15.2f", beverageCost);
		System.out.printf("\nEntree and Beverage Tax =   $%15.2f", mealTax);
		System.out.printf("\nTip =                       $%15.2f", tip);
		System.out.printf("\nMeal Total =                $%15.2f", mealTotal);
		System.out.printf("\nMovie =                     $%15.2f", movieCost);
		System.out.printf("\nMovie Tax =                 $%15.2f", movieTax);
		System.out.printf("\nMovie Total =               $%15.2f", movieTotal);
		System.out.printf("\n\nYou spent $%1.2f on your date!\n\n" , total);
	
		//all printing by default is left justified.

		
	}//end main
	
}//end class
