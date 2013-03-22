//Anindit Gopalakrishnan
//October 31, 2012
//Kaching.java
//This programw will allow the user to play a simple game of kaching.



import java.util.Scanner;
public class StatKaching{
	private int Atotal, Btotal, dValue;
	private boolean Aturn, done;
	private Dice die;
	String player;
	String enter;
	Scanner scan;
	long aTurnWins;
	long bTurnWins;
	int turns;
	int bWins;
	int aWins;
	
	public static void main(String[] args){
		StatKaching fun = new StatKaching ( );

		for (int i = 1; i < 1000001; i++){
			if ((i % 100000) == 0){
				fun.PrintStats(i);
			}
			fun.PlayGame ( );
			
		}
		fun.PrintStats(1000000);
		
		
	
	
	}
	public  StatKaching(){
		Atotal = 1;
		Btotal = 1;
		Aturn = true;
		done = false;
		die = new Dice();
		scan = new Scanner(System.in);
	}
	public void PrintStats(int x ){
		double pAWins = ((double) aWins/(aWins + bWins)) *100;
		double pBWins = ((double) bWins/(aWins + bWins)*100);
		double bTW =   bTurnWins / x;
		double aTW = aTurnWins / x;
		System.out.println ("Out of 1000000 plays, A won " + aWins + ", or " + pAWins + "% of the time");
		System.out.println ("Out of 1000000 plays, b win " + bWins + ", or " + pBWins + "% of the time");
		System.out.println(" When A won, an average of " + aTW + " was played.");
		System.out.println(" when B won, an average of " + bTW + " was played."); 
	
	}
	public void PlayGame(){
		Atotal = 1;
		Btotal = 1;
		Aturn = true;
		done = false;
		turns = 0;
		while (!done){
			
			PlayTurn();
		}
	}
	
	public void PlayTurn(){
		dValue = die.Roll();	
		turns ++;
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
			else if (holder >= 50){
				Atotal = holder;
				aWins ++;
				aTurnWins += turns;
				done = true;
			}
			else{
			     Atotal = holder;
			     Aturn = false;
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
			else if (holder >= 50){
				Btotal = holder;
				bWins ++;
				bTurnWins += turns;
				done = true;
			}
			else{
			     Btotal = holder;
					Aturn = true;
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
	
}
