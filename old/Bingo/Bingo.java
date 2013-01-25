//Jimmy Liu
//Janurary 10th, 2012
//Bingo.java
//This program generates a 2-D java board using two-demensional array

import java.util.*;

public class Bingo {
	private int i;
	private String[][] table = new String[5][5];
	
	public Bingo () {
	}
	
	public static void main (String [] args) {
		Bingo bingo = new Bingo ();
		bingo.Title();
		bingo.RunIt();
		bingo.GetNum();
	}	

	public void Title() {
	System.out.println ("-----------------------------");
	System.out.println ("|B I N G O|	");
	System.out.println ("-----------------------------");
	}

	public void RunIt() {
		for (int row = 0; row < 5; row++)
			for (int col = 0; col < 5; col++)
				table[row][col] = Math.random(1);        
			PrintTable ( table );                                                                                                                                                                                                                             
	}
	
	public void PrintTable ( String [][] t ) {
		for (int row = 0; row < t.length; row++) {
			for (int col = 0; col < t[row].length; col++)
				System.out.printf ("%4d", t[row][col]);
			System.out.println();
		}
	}
	
	public void GetNum () {
		switch (INPUTSOMETHINGHERE) 
		{
			case 1;
		}
	}
}
