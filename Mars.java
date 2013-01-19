// Jimmy Liu
// Januarary 16th, 2012
// Mars.java
// Does stuff

import java.util.*;
import java.io.*;

public class Mars {
	private char [][] array = new char [26] [26];
	private int locrow, locol;
	private int steps;
	private int currow, curcol;
	private int ice, rocks, aliens;
	private String move = new String();
	private File infile;
	Scanner input = new Scanner (System.in);
	
	public Mars () {
	infile = new File ("rocks.txt");
	}

public static void main (String [] args) {
	Mars mars = new Mars ();
	mars.RunGame();
	}
	
	public void RunGame() {
		Start();
		//while (steps != 31) {
			Status();
			Grid();
		//	steps++;
		//}
	}
	
	public void Start() {
		//Starting Game
		System.out.print ("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
		locrow = input.nextInt();
		while ((locrow < -1) || (locrow > 24)) {
			System.out.print ("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
			locrow = input.nextInt();
		}
		if (locrow == -1) {
			locrow = (int) Math.random();
		}
		System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
		locol = input.nextInt();
		while ((locol < -1) || (locol > 24)) {
			System.out.print ("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
			locrow = input.nextInt();
		}
		if (locol == -1) {
			locol = (int) Math.random();
		}
		System.out.println();
		System.out.println ("----------------------------------------------------------------------------");
	} 
	
	public void Status() {
		//Print Status
		System.out.printf ("STATUS REPORT:  ROW: %d   COLUMN: %d \t\t\t %d OF 30 STEPS TAKEN	\n", currow, curcol, steps);
		System.out.printf ("COLLECTED: %d  ICE SAMPLES,  %d HEMATITITE SAMPLES \t %d ALIEN ENCOUNTERS\n", ice, rocks, aliens);
		System.out.println();
	} 

	public void Grid() {
		//PrintGrid
		int num = 48;
		int num2 = 48;
		for(int row=0; row<26; row++) {          
        	for(int col=0; col<26; col++) {
        	
        		if (row == 0) { //row zero for x - axis 
        			if (col==0) {
	        			array[row][col] = 32;
        			}
        			else {
	        		array[row][col] = (char) num;
	        			if (num == 57) {
	        				num = 48;
	        			}
	        			else {
	        				num++;
	        			}
	        		}	
	        	}
	        	

	        	else if (col == 0) {
		        		if (row == 0) {
	        			array[row][col] = 32;
	        			num2 = 48;
        			}
        			else {
	        		array[row][col] = (char) num2;
	        			if (num2 == 57) {
	        				num2 = 48;
	        			}
	        			else {
	        				num2++;
	        			}
	        		}
		        }
	        	
	        	
        		
        		else {
        		array[row][col] = 45;
        		}
        	
        	System.out.printf("%2c", array[row][col]);
        	
        }
        System.out.println();
        }
        System.out.println();
        System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
        System.out.println("Enter a letter choice to move -> ");
        move = input.next();
        while ((move != "a.equals(s)") || (move != "d.equals(s)") || (move != "w.equals(s)") || (move !="s.equals(s)")) {
        System.out.println("Enter a letter choice to move -> ");
	    move = input.next();
        }
			        
	}
	
}
