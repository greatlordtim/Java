// Jimmy Liu
// Januarary 16th, 2012
// Mars.java
// Does stuff
import java.util.*;
import java.io.*;

public class Mars {
    private char[][] array = new char[26][26];
    private int locrow, locol;
    private int steps;
    private int currow, curcol;
    private int ice, rocks, aliens;
    private String move = new String();
    private char usermove;
    private File infile;
    private Scanner txt;
    Scanner input = new Scanner(System. in );


    public Mars() {
        infile = new File("rocks.txt");
        steps = 0;
        try {
                    txt = new Scanner(infile);
                } catch (FileNotFoundException e) {
                    System.err.println("Error: Cannot open file rocks.txt");
                    System.exit(1);
        } //end trycatch

    }

    public static void main(String[] args) {
        Mars mars = new Mars();
        mars.Grid();
        mars.Start();
        mars.PrintIt();
        mars.MoveIt();
    }

    public void Grid() {

        //PrintGrid
        int num = 48;
        int num2 = 48;
        for (int row = 0; row < 26; row++) {
            for (int col = 0; col < 26; col++) {
                array[row][col] = 45;
            }
        }

        for (int row = 0; row < 26; row++) {
            for (int col = 0; col < 26; col++) {

                //row zero for x - axis 
               	if (row == 0) {
                    if (col == 0) {
                        array[row][col] = 32;
                    } else {
                        array[row][col] = (char) num;
                        if (num == 57) {
                            num = 48;
                        } else {
                            num++;
                        }
                    }
                }

                //row zero for y - axis 
                if (col == 0) {
                    if (row == 0) {
                        array[row][col] = 32;
                        num2 = 48;
                    } else {
                        array[row][col] = (char) num2;
                        if (num2 == 57) {
                            num2 = 48;
                        } else {
                            num2++;
                        }
                    }
                }

                //Print out rocks and ice
                while (txt.hasNext()) {
                    ice = txt.nextInt();

                    for (int count = 0; count < ice; count++) {
                        array[txt.nextInt()][txt.nextInt()] = 'I';
                    }

                    rocks = txt.nextInt();

                    for (int count = 0; count < rocks; count++) {
                        array[txt.nextInt()][txt.nextInt()] = 'H';
                    }

                }

                //Print Alien
                //array[(int)(Math.random() * 24)][(int)(Math.random() * 4)] = '@';

                //txt.close();

            } //end col
        } //end row
    } //end Grid()

    public void Start() {

        //Starting Game
        System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
        locrow = input.nextInt();
        while ((locrow < -1) || (locrow > 24)) {
            System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
            locrow = input.nextInt();
        }
        if (locrow == -1) {
            locrow = (int) Math.random();
        }
        System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
        locol = input.nextInt();
        while ((locol < -1) || (locol > 24)) {
            System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)	-> ");
            locol = input.nextInt();
        }
        if (locol == -1) {
            locol = (int) Math.random();
        }
        //Print out user location
        array[locrow][locol] = 'R';
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
    }
    
    public void PrintIt() {
    	System.out.printf("STATUS REPORT:  ROW: %d   COLUMN: %d \t\t\t %d OF 30 STEPS TAKEN	\n", currow, curcol, steps);
        System.out.printf("COLLECTED: %d  ICE SAMPLES,  %d HEMATITITE SAMPLES \t %d ALIEN ENCOUNTERS\n", ice, rocks, aliens);
        System.out.println();
    	for (int row = 0; row < 26; row++) {
            for (int col = 0; col < 26; col++) {
	            System.out.printf("%2c", array[row][col]);
	            }
	            System.out.println();
	    }
    	System.out.println();
    
    } //end PrintIt
    
    public void MoveIt() {
    		System.out.println();
            System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
            System.out.println("Enter a letter choice to move -> ");
            move = input.next();
            usermove = move.charAt(0);
    
            switch (usermove) {
            
	            case 'a':
	            array[locrow][locol] = 45;
	            locol = locol -1;
	            array[locrow][locol] = 'R';
	            //check borders
	            if (locrow == 0) { MoveIt(); }    
		        
		        steps++;
		        //check rocks
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = 45;
			       rocks++;
			    }
			    //check ice
			    if (array[locrow][locol] == 'I') {
			       array[locrow][locol] = 45;
			       ice++;
			    }
			    break;
			    
			    case 's':
			    array[locrow][locol] = 45;
	            locrow = locrow +1;
	            array[locrow][locol] = 'R';
	            //check borders
	            if (locrow == 0) { MoveIt(); }    
		        
		        steps++;
		        //check rocks
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = 45;
			       rocks++;
			    }
			    //check ice
			    if (array[locrow][locol] == 'I') {
			       array[locrow][locol] = 45;
			       ice++;
			    }
			    break;
			    
			    case 'd':
			    array[locrow][locol] = 45;
	            locol = locol +1;
	            array[locrow][locol] = 'R';
	            //check borders
	            if (locrow == 0) { MoveIt(); }    
		        
		        steps++;
		        //check rocks
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = 45;
			       rocks++;
			    }
			    //check ice
			    if (array[locrow][locol] == 'I') {
			       array[locrow][locol] = 45;
			       ice++;
			    }
			    break;
			    
			    case 'w':
			    array[locrow][locol] = 45;
	            locrow = locrow -1;
	            array[locrow][locol] = 'R';
	            //check borders
	            if (locrow == 0) { MoveIt(); }    
		        
		        steps++;
		        //check rocks
		        if (array[locrow][locol] == 'H') {
			       array[locrow][locol] = 45;
			       rocks++;
			    }
			    //check ice
			    if (array[locrow][locol] == 'I') {
			       array[locrow][locol] = 45;
			       ice++;
			    }
			    break;
			  
            } //endswitchcase
            
            while (steps != 30) {
				PrintIt();
				MoveIt();
			}  
    
    } //end MoveIt





} //end program