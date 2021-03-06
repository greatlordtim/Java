// Jimmy Liu
// January 30, 2013
// Web.java
// This program paints a picture of Calvin using Paint, JFrames, and JPanel

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
    }
    
    public static void main(String[] args) {
        Mars mars = new Mars();
        mars.Grid();
        mars.Start();
        mars.MoveIt();
    }
    
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
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
    }

    public void Print() {

        //Print Status
        System.out.printf("STATUS REPORT:  ROW: %d   COLUMN: %d \t\t\t %d OF 30 STEPS TAKEN	\n", currow, curcol, steps);
        System.out.printf("COLLECTED: %d  ICE SAMPLES,  %d HEMATITITE SAMPLES \t %d ALIEN ENCOUNTERS\n", ice, rocks, aliens);
        System.out.println();
        System.out.printf("%2c", array[row][col]);
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
                else if (col == 0) {
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
                try {
                    txt = new Scanner(infile);
                } catch (FileNotFoundException e) {
                    System.err.println("Error: Cannot open file rocks.txt");
                    System.exit(1);
                }

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
             txt.close();

                //Print Alien
                //array[(int)(Math.random() * 24)][(int)(Math.random() * 4)] = '@';

                //txt.close();


                //User Location
                if (locrow > -1) {
                    array[locrow][locol] = 'R';
                }
      
      }




        //Ask user for moves\

     public void MoveIt {
        
        	//Print Prompt
        	System.out.println();
            System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
            System.out.println("Enter a letter choice to move -> ");
            move = input.next();
            usermove = move.charAt(0);
     }
     
}