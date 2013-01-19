//Jimmy Liu
//Janurary 10th, 2012
//Bingo.java
//This program generates a 2-D java board using two-demensional array

import java.util.*;

public class Bingo {
	private int i;
	
	public Bingo () {
	}
	
public static void main (String [] args) {
		Bingo bingo = new Bingo ();

		bingo.Title();
		bingo.RunIt();
	}	

public void Title() {
System.out.println ("-----------------------------");
System.out.println ("|   B    I    N    G    O   |	");
System.out.println ("-----------------------------");
}

public void RunIt() {
	int [][] table = new int [5] [6];
	int row, col;
	for( row = 0; row < table[0].length; row++)
	{
		for( col =0; col < table[0].length; col++)
		{
		table[row][col] = rand.nextInt( 50) + 1; //range 1 to 50
		}
	}

}
}