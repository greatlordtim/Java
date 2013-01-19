// Jimmy Liu
// October 17, 2012
// LoopExample.java
// An example of counting from 1 to 10 using while and do-while loops
import java.util.Scanner;
public class Rolls {
    private int count, target; // These values represent how many times the
                               // dice has been rolled and the target value.
    private int targetcount;   // How many times the target has been hit.
    private int numsides;      // The number of sides for the dice.
    private int dicevalue;     // The number rolled (dice value).
    private int numrolls;      // Represents the number of times the dice
                               // will be rolled (where to stop).
    private int max, min;      // The maximum and minimum value rolled.
    
    Scanner input = new Scanner ( System.in ); //scanner
    
    // Sets the values of the above data members. 
    public Rolls (){
		count = 0;
		max = 0;
		min = 9000;

    }
    // Prompt the user to enter the desired information.
    public void GetInfo () {
    System.out.print ("Enter the number of sides of your dice (1-9001)                   ->   ");
    numsides = input.nextInt ();  
    System.out.print ("Enter the number of times you would like to roll the dic(1-9001)  ->   ");
    numrolls = input.nextInt ();
    System.out.print ("Enter the target value(1-number of sides)                         ->   ");
    target = input.nextInt (); 
    System.out.println ("");
    
    // Roll the dice the desired number of times, looking for the target,
    // keeping track of how many times the target is hit, and keeping track
    // of the max and min values rolled.
		}
    public void RollTheDice () {
        Dice die = new Dice (numsides); // defines dice
       
        
        
        while (count < numrolls) {
            dicevalue = die.Roll(); // rolls the dice
			if (dicevalue > max) {
				max = dicevalue;
			}
			if (dicevalue < min) {
				min = dicevalue;
			}
			
            count++;
            if (count%10==0) {
                System.out.println (dicevalue+"\t");
			} else 
					System.out.print (dicevalue+"\t");
        }	
   }
    
    
    public void ShowResults ( ){
        System.out.printf ("\n\nThe target of %d was rolled by %d times.", target, count); // if int use %d, float or double use %f
        System.out.printf ("\nMinimum value       ->   %d", min);
        System.out.printf ("\nMaximum value       ->   %d\n", max); //%d = integer
    }
}

/*
int count = 0;
while (count < 10) { 
System.out.print ("Hello World");
count++;
} 
*/