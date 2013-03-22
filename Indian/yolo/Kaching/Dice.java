//Scott DeRuiter 
//June 28, 2002
//Dice.java
//This program creates a dice that can be used in other programs
import java.lang.Math;

public class Dice   {
	//  Data members
	private int numsides;
	private int rollcount;

	//  Default constructor for a die with 6 sides.
	public Dice ( )   {
		numsides = 6;
		rollcount = 0;
	}
	public void setSides(int x){
		numsides =  x;
	}

	//  A constructor that can have a different number of sides.
	public Dice ( int num )  {
		numsides = num;
		rollcount = 0;
	}

	//  Returns a random number from 1 to numsides.
	public int Roll ( )  {
		rollcount++;
		return (int)(1 + numsides * Math.random ( ));
	}
	
	//  A method to show the number of times the die has been rolled.
	public void PrintRollCount ( )   {
		System.out.println ( "\nThe dice has been rolled " + 
			rollcount + " times\n\n" );
	}

	//  Method just returns the rollcount.
	public int SendRollCount ( )   {
		return rollcount;
	}
}
