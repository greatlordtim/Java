// Jimmy Liu
// Novermber 1, 2012
// kaching.java
// This program plays the game kaching

// Documentation:

// Class variables:
// Atotal,Btotal: Stores the position for players A and B, respectively.
// Aturn,done: Booleans to determine if it is player A's turn, and if the game is done, respectively.
// Dice die: A six-sided die

// Class methods:
// PlayGame: Main game
// ShowStatus: Prints out status of the game
// MoveIt: Plays the game
// AddRoll: Roll add to players
// GetPosition: Get the position of the current player.
// SwitchTurn: Switches players turns

import java.util.Scanner;
public class kaching {
	private int Atotal;
	private int Btotal;
	private boolean Aturn;
	private boolean done;
	private Dice die;

	public kaching() {
		Atotal = 1;
		Btotal = 1;
		Aturn = true;
		done = false;
		die = new Dice();
	}
	public void PlayGame ( ) {
		ShowStatus(); //print out game status
		while (Atotal < 50 && Btotal < 50) {
			MoveIt(); //run the game
			if (Atotal >= 50)
			System.out.println("A, you are the CHAMPION!\n");
			else if (Btotal >= 50)
			System.out.println("B, you are the CHAMPION!\n");
			ShowStatus();
		}
		done = true;
	}
public void MoveIt ( ) {
		if (Aturn)
			System.out.println("PLAYER A, hit Enter to continue:");
		else
		System.out.println("PLAYER B, hit Enter to continue:");
	(new Scanner(System.in)).nextLine();
		int roll = die.Roll();
		System.out.println(roll);
		if (roll == 1)
		SwitchTurn(); // switches turns
		else {
			AddRoll(roll);
		
			if (GetPosition() % roll == 0) {
				AddRoll(-2*roll);
				SwitchTurn();
			} else {	
				int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47}; //checks number with primes
				boolean isprime = false;
				for (int i = 0; i < primes.length; i++) {
					if (GetPosition() == primes[i]) {
						isprime = true; // is prime prime or not
				}
				}
				
				if (!isprime) {
					SwitchTurn(); //notprime, switches turns
				}
		}
		}
}
public void ShowStatus ( ) {
		System.out.println("A TOTAL IS:  "+Atotal);
		System.out.println("B TOTAL IS:  "+Btotal);
	}

	private int GetPosition() {  //prints out position infomation
		if (Aturn)
			return Atotal;
		else
			return Btotal;
	}
		private void AddRoll(int roll) {
		if (Aturn) {
			Atotal += roll;
			if (Atotal < 1)
				Atotal = 1;
		} else {
			Btotal += roll;
			if (Btotal < 1)
				Btotal = 1;
		}
	    }

	private void SwitchTurn() {
		Aturn = !Aturn;
	}
	// public static here
	public static void main ( String [] args ) {
		kaching fun = new kaching ( );
			fun.PlayGame ( );
	}
}
//derp
