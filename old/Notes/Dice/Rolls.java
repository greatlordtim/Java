// Jimmy Liu
// October 17, 2012
// LoopExample.java
// An example of counting from 1 to 10 using while and do-while loops
public class Rolls {
	private int count, target; // These values represent how many times the
         	                   // dice has been rolled and the target value.
	private int targetcount;   // How many times the target has been hit.
	private int numsides;      // The number of sides for the dice.
	private int dicevalue;     // The number rolled (dice value).
	private int numrolls;      // Represents the number of times the dice
    	                       // will be rolled (where to stop).
	private int max, min;      // The maximum and minimum value rolled.
	
	// Sets the values of the above data members.
	public Rolls (){
}
	// Prompt the user to enter the desired information.
	public void GetInfo ( ) {
	System.out.print ("Enter the number of sides of your dice (1-9001)  ->");
	numsides = input.nextInt ();  
	System.out.print ("Enter the number of times you would like to roll the dic(1-9001) ->");
	numrolls = input.nextInt ();
	System.out.print ("Enter the target value(1-number of sides) ->");
	target = input.nextInt (); 
	// Roll the dice the desired number of times, looking for the target,
	// keeping track of how many times the target is hit, and keeping track
	// of the max and min values rolled.
}
	
	
	public void RollTheDice ( ) {
		Dice die = new Dice (numsides);
		int i = die.Roll();
		while (int != numrolls) {
			int i = die.Roll();
				System.out.print( i );
		}
		}
	// Print a table showing the results.
	
	
	public void ShowResults ( ){
		System.out.printf ("The target of %f was rolled by %f times.", target, asdf);
		System.out.printf ("Minimum value       ->   ",     )
        System.out.printf ("Maximum value       ->   ",     )
	}
}
