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
	private char usermove;
	private File infile;
	private Scanner txt;
	Scanner input = new Scanner (System.in);
	
	
	public Mars () {
	infile = new File ("rocks.txt");
	steps = 0;
	}

public static void main (String [] args) {
	Mars mars = new Mars ();
	mars.RunGame();
	
	}
	
	public void RunGame() {
			Start();
			Status();
			Grid();
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
			locol = input.nextInt();
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
	
		//Read file

		//PrintGrid
		int num = 48;
		int num2 = 48;
		for(int row=0; row<26; row++) {          
        	for(int col=0; col<26; col++) {
        	array[row][col] = 45;
        	}
        }
        
		for(int row=0; row<26; row++) {          
        	for(int col=0; col<26; col++) {
        	
        	//row zero for x - axis 
        		if (row == 0) { 
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
	        	
	        	//row zero for y - axis 
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
	        	
	        	//Print out rocks
	        	try {
					txt = new Scanner (infile);
				} catch (FileNotFoundException e) {
					System.err.println("Error: Cannot open file rocks.txt");
					System.exit(1);
				}
				ice = txt.nextInt();
	        	if (numrocks > 0) {
	        		while (count < numrocks)
	        		{
	        			while (txt.hasNextLine()) {
	        				txt.nextLine();
	        				int c = txt.nextInt();
	        				int r = txt.nextInt();
	        				if (r == 19) {
		        				txt.nextLine();
		        				r = txt.nextInt();
	        				}
	        				if (derp < 15) {
		        				array[r][c] = 'H';
		        				}
		        			else {
			        			array[r][c] = 'I';
			        			}
		        			derp++;
		        			}
		        			
		        			count++;
		        		
	        		}
	        	}
	        	
	        	//Print out ice
	        	
        		
        		//User Location
        		if (locrow > -1) {
	        		array[locrow][locol] = 'R';
	        		}
        		
        		//Everything else
        		
        		
        		
        		//Print out table
        		System.out.printf("%2c", array[row][col]);
        	
        		
        		
        	}
        	
        	//Pat yourself on the back
        	System.out.println();
        	
        	
        	
        	
        }
        
        
        //Ask user for moves
        
        System.out.println();
        System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
        System.out.println("Enter a letter choice to move -> ");
        move = input.next();
        usermove = move.charAt(0);
        
        //Moving 
        
        while (steps < 30) {
        
	        if (usermove == 'a') {
		        locol = locol -1;
		        steps++;
		        //if ice
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = '-';
			       rocks++;
			   }
		        
		        
	        }
	        
	        if (usermove == 's') {
		        locrow = locrow +1;
		        steps++;
		         //if ice
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = '-';
			       rocks++;
			   }
			   
			   	
	        }
	        
	        if (usermove == 'd') {
		        locol = locol +1;
		        steps++;
		         //if ice
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = '-';
			       rocks++;
			   }
			   
	        }
	        
	        if (usermove == 'w') {
		        locrow = locrow -1;
		        steps++;
		         //if ice
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = '-';
			       rocks++;
			   }
			   	
	        }
	        
	        Status();
		    Grid();
	     }
	     
	    //Ending
	    
	    if (steps == 30) {
        System.out.println("THANK YOU FOR VISITING MARS, GOODBYE!!!!");
        System.exit(1);
        
        //Yay for horrible 1AM commits to Github
        }
         
    }
	
}
