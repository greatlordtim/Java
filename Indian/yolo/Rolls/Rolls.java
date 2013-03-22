//Anindit Gopalakrishnan
//October 18, 2012
//Rolls.java
//This program will make a "Rolls" Object which will be able roll a dice up to
//1000 times, and print some basic statistics.

//Class Variables: private int count: this is the loop control variable that controls the number of tiems it loops
//                 private int target: this int holds the value that the person tries to "get"
//                 private int targetcount: this int holds how many times the target is got
//                 private int numsides: this int holds how many sides the dice has. For each side the dice has, an integer within the range can be rolled.
//                 private int numrolls: this int holds how many times the dice will be rolled
//                 private int dicevalue: this int holds the speicific dice value rolled on each roll.
//                 private int max: this int holds the max roll that was rolled.
//                 private int min: this int holds the min roll that was rolled

//                 Dice die: this is a member of the Dice class which is a dice that can be rolled for data.
//Class Methods: public Rolls()(constructor) In this program, the constructor preforms the simple task of initializing all variables to a generic value that the program can run with if the user enters invalid numbers
//               public void GetInfo(): In this method, info is gotten from the user on how many dice rolls, the sides of the dice, and the target.
//               public void RollTheDice(): In this method, the dice is rolled. In addition, the results of each individual dice roll is printed in the form of a table with 10 columns.
//               public void ShowResults(): In this method, the data is displayed; how many times the target was rolled, the minimum, and the maximum 

import java.util.Scanner;

public class Rolls{
	
	private int count, target; 
	private int targetcount;
	private int numsides;
	private int dicevalue;
	private int numrolls;
	private int max, min;
	private Dice die;
	Scanner scan;
	
	//Sets the values of the above data members
	public Rolls(){
		count = 0;
		target = 1;
		targetcount = 0;
		numsides = 2;
		dicevalue = 1;
		numrolls = 1;
		max=1;
		min = 1;
		scan = new Scanner(System.in);
		die = new Dice();
	}
	public void GetInfo(){
		System.out.print("\n\nEnter the number of sides for your dice (2-100)                    ->  ");
		numsides = scan.nextInt();
		min = numsides;
		System.out.print("Enter the number of times you would like to roll the dice(1-10000) ->  ");
		numrolls = scan.nextInt();	
		System.out.print("Enter the target value(1-number of sides)                          ->  ");
		target = scan.nextInt();
		die = new Dice(numsides);	
	}
	public void RollTheDice(){
		while (count < numrolls){
			dicevalue = die.Roll();
			if (dicevalue > max){
				max = dicevalue;
			}
			if (dicevalue < min){
				min = dicevalue;
			}
			if (count % 10 == 0){
				
					System.out.printf("\n%-6d", dicevalue);
					
				
							
				
			}
			
			else {
					System.out.printf("%-6d", dicevalue);
			}
			if (dicevalue == target){
				targetcount++;
			}
			count ++;
		}
	
	}
	public void ShowResults(){
		System.out.println("\n\nThe target of     " + target + "     was rolled     " + targetcount + "     times.");  
		System.out.println("Minimum value          ->   " + min);
		System.out.println("Maximum value          ->   " + max);
	}


}
