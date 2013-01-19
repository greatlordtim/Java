// Jimmy Liu
// Januarary 16th, 2012
// Mars.java
// Does stuff

import java.util.*;
import java.io.*;

public class Mars {
	private char [][] array = new char [25] [25];
	private int locrow, locol;
	private int steps;
	private int currow, curcol;
	private int ice, rocks, aliens;
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
		while (steps != 31) {
			Status();
			Grid();
			steps++;
		}
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
		
	}
	
}
