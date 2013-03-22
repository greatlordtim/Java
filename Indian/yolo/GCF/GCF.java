//Anindit Gopalakrishnan
//12/3/12
//GCF.java
//This program finds the GCF of 2 numbers



import java.util.Scanner;

public class GCF {
	int x,y,gcf; //x holds the first integer entered, y holds the second integer entered, gcf holds the gcf of the two numbers
	boolean exit = false; //exit holds the boolean value which tells the program to exit or not.
	Scanner scanner = new Scanner(System.in); //gets input from the user

	public static void main(String[] args){
		GCF gcf = new GCF();
		gcf.runIt();
		
	}
	public void runIt(){//runs the program - not in main due to static conflicts
		System.out.println();
		while(!exit){ //constantly asks for input and repeats when Exit is false
			getData();
			getnPrintGCF();
			if (!exit) System.out.println();//only prints an extra line if there is more to the program, if exiting does not
		}
	}
	public void getData( ){//gets data from the user and checks to make sure that it is valid
		int count = 0; //int count holds the number of times the user enters a wrong number - used so that the first time the loop does not print an error
		do {
			if (count > 0) System.out.println("ERROR: Not a positive integer"); 
			System.out.print("Enter first positive integer  (0 to exit)    -> ");
			x = scanner.nextInt(); //sets x
			exit = (x==0); //if x = 0, the program sets exit to be true
			count ++; 
		}while(x < 0); //while x is less than , it asks for input again
			
		if (!exit){ //only bothers to get the second integer if exit is false
			count = 0; //resets program
			do {
				if (count > 0) System.out.println("ERROR: Not a positive integer");
				System.out.print("Enter second positive integer (0 to exit)    -> ");
				y = scanner.nextInt();
				exit = (y==0);
				count++;
			}while(y<0);	
		}
	}
	public void getnPrintGCF(){
		if (!(exit)){//only prints gcf if exit is false 
			gcf = gcfIt(x,y);
			if (gcf!=1) System.out.println("The GCF of " + x + " and " + y + " is " + gcf);
			else if (gcf == 1) System.out.println(x + " and " + y + " are relatively prime");//relatively prime 
			
		}
	}
	public int gcfIt(int a, int b){ //returns the gcf of numbers a, b
		if (a == b ) return a;
		else if (a > b) return gcfIt((a-b), b);
		else return gcfIt(a, (b-a));
	
	}
}
