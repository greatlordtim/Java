//Anindit Gopalakrishnan
//October 31, 2012
//Kaching.java
//This program will allow the user to play a simple game of kaching.

//private int Atotal: keeps track of A's score. 
//private int Btotal: keepts track of B's score.
//private int dValue: holds the dice value on each turn.
//private boolean aWin: holds if a won or not. If a wins, then its true, if b wins, false.
//private Dice die: An object of the dice class which generates a random number 1-6
//String player: holds the name of the player that rolled the dice on the previous turn.
//String enter: filler string which allows the user to advance the game forward by pressing enter.
//Scanner scan: scanner object used to read user input.

//public Kaching: Initializes all numbers that the game starts with. For example, Atotal and Btotal are initialized to 1.
//public void PlayGame(): This generically plays the game, start, middle, and end, calling the methods needed to do so.

//public void PlayTurn(): This plays one turn of the game and decides who will play next.
//public boolean isPrime(int x): This boolean returns whether or not x is prime
//public void PrintWinner: This method prints the winner of the game.
import java.util.Scanner;
public class Kaching{
	private int Atotal, Btotal, dValue;
	private boolean Aturn, done;
	private boolean aWin;
	private Dice die;
	String player;
	String enter;
	Scanner scan;
	public static void main(String[] args){
		Kaching fun = new Kaching ( );
		fun.PlayGame ( );
	
	
	}
	public Kaching(){
		Atotal = 1;
		Btotal = 1;
		Aturn = true;
		done = false;
		die = new Dice();
		scan = new Scanner(System.in);
	}
	public void PlayGame(){
		System.out.print("\n\n---------------------------------------------------\n");
		while (!done){
			ShowStatus();
			PlayTurn();
		}
		PrintWinner();
	}
	public void ShowStatus(){
		System.out.println("A TOTAL IS:   "+ Atotal);
		System.out.println("B TOTAL IS:   "+ Btotal);
		if (Aturn){
			System.out.println("Player A, hit Enter to Continue:");
			player = "Player A";
		}	
		else {
			System.out.println("Player B, hit Enter to Continue:");
			player =  "Player B";
		}
		
	}
	public void PlayTurn(){
		enter = scan.nextLine();
		dValue = die.Roll();	
		System.out.println("---------------------------------------------------");
		System.out.println(player + ", your roll was:  " + dValue + "\n");
		if (Aturn){
			int holder = dValue + Atotal;
			boolean fail = ((holder%dValue) == 0); 
			if (dValue == 1){
				Aturn = false;
			}
			else if (fail){
				boolean isTooClose = ((Atotal-dValue) < 1);
				if (isTooClose){
				  	Atotal = 1;
				}
				else {
					Atotal -= dValue;
				}
				Aturn = false;
			}
			else if (isPrime(holder)){
				Atotal = holder;			
			}
		
			else{
			     Atotal = holder;
			     Aturn = false;
			}
			 if (holder >= 50 && !fail){
				Atotal = holder;
				aWin = true;
				done = true;
			}
			
		}
		else{
			int holder = dValue + Btotal;
			boolean fail = ((holder%dValue) == 0) ;
			if (dValue == 1){
				Aturn = true;
			}
			else if (fail){
				boolean isTooClose = ((Btotal-dValue) < 1);
				if (isTooClose){
				  	Btotal = 1;
				}
				else {
					Btotal -= dValue;
				}
				Aturn = true;
			}
			else if (isPrime(holder)){
				Btotal = holder;			
			}
			
			else{
			     Btotal = holder;
					Aturn = true;
			}
			 if (holder >= 50 && !fail){
				aWin = false;
				Btotal = holder;
				done = true;
			}
		}
		
	}
	public boolean isPrime(int x){
		boolean prime = true;
		for (int i = 2; i < x; i++){
			if ((x%i) == 0){
				prime = false;
				
			}
		} 
		return prime; 
	}
	public void PrintWinner(){
		if (aWin){
			System.out.println("A, you are a champion!");
		}
		else {
			System.out.println ("B, you are a champion!");
		}
		System.out.println("\nA TOTAL IS:   "+ Atotal);
		System.out.println("B TOTAL IS:   "+ Btotal  );
		System.out.println("---------------------------------------------------\n\n\n");

	}
}
