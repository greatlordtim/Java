//Anindit Gopalakrishnan
//January 17, 2013
//Alien.java
//This program has the code needed to make an alien object
import java.util.Random;
public class Alien{
	private int row, col; ///holds the row and column
	private Random rand;///random number generatro
	private char charrep;///char which represents alien
	private boolean draw;///to draw or not to draw
	public Alien(){///initializes rover to a random place on the board
		rand = new Random();
		row = rand.nextInt(25);
		col = rand.nextInt(25);
		//row = 1;
		//col = 1;
	}
	public int getRow(){///returns the row of the alian
		return row;
	}
	public int getCol(){///returns toe column of the alien
		return col;
	}
	
	
}
