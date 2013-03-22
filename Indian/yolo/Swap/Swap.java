import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
public class Swap implements ActionListener{
	//implements ActionListener to be used for timer
	int[] numbers = new int[8]; // array holds the numbers to be put in order
	int turns; //holds the number of time it took
	boolean done; //tells when the program is done
	Scanner scan; //scanner object gets info from user
	int index1, index2; //holds the 2 numbers the user index to switch the index of
	int time; //holds the amount of time it takes to finish the program
	
	public void actionPerformed(ActionEvent evt){ //called every second, increase time by 1 (basically counting seconds)
		if (!done){
		time++;
		}	
	}
	
	public static void main(String[] args){
		Swap s = new Swap(); //Swap object
		s.Run(); // runs swap game
		
	}
	
	public Swap(){ //constructer initializes the numbers, sets turns to 1 (takes 1 turn no matter what to swap in the case of this game - the chance of the numbers being intialized in order is less than 1/40000)
		generateNumbers();
		turns = 1;
		done =  false;
		scan = new Scanner(System.in);
		index1 = 0;
		index2 = 0;
		Timer t = new Timer(1000, this); //makes timer object that calls actionPerformed every second
		t.start(); //starts timer
	}
	public void Run(){ //runs the program to deal with static/nonstatic issues
		
		System.out.println("Welcome to the Game of SWAP! Here is your array of 8 integers \n");
		printNumbers();
		while(!done){ //keeps doing these actions when done is false
			System.out.println();
			getSwaps();
			swapNumbers();
			done = recurseCheck(7);
			System.out.println();
			printNumbers();
			turns++;
			
		}
		System.out.println("\nGood work! Your array is in order and it took " + turns + " swaps, and it took " + time + " seconds!!!");
		
	}
	public void printNumbers(){ //prints out the array with indexies (the indexies printed are the actuall indexies + 1)
		System.out.println("1    2    3    4    5    6    7    8");
		System.out.printf( "%-4d %-4d %-4d 
		 %-4d %-4d %-4d %-4d %-4d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7]);
	}
	public void getSwaps(){ //get the indexes of the swaps to switch, rechecks for non valid swaps
		System.out.println();
		do{
			System.out.print("Enter an Index value to swap:        ");
			index1 = scan.nextInt();
		}while(!(index1 > 0 && index1 <= 8));
		do{
			System.out.print("Enter another Index value to swap:   ");
			index2 = scan.nextInt();
		}while(!(index2 > 0 && index2 <= 8));
	}
	
	public void generateNumbers(){ //generates numbers - makes sure that non of them are the same
		for (int i = 0; i <= 7; i ++){
			numbers[i] = (int)(100*Math.random()) + 1;
			for (int j = (i-1); j >=0; j--){
				if (numbers[j] == numbers [i]) 	numbers[i] = (int)(100*Math.random()) + 1;
			}
		}
	}
	public void swapNumbers(){ //swaps the numbers - creates two filler variables to do this.
		int a, b;
		a = numbers[index1 - 1];
		b = numbers[index2 - 1];
		numbers[index2-1] = a;
		numbers[index1-1] = b;
	}
	public boolean recurseCheck(int a){ //recursively checks if the array is in order
		if (numbers[a] < numbers[a-1]) return false;
		else if ((a-1) == 0) return true;
		else  return recurseCheck(a-1);
	}
}
