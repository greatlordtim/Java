//Anindit Gopalakrishnan
//January 17,2012
//Sample.java
//This program has the code needed to make a sample object.
public class Sample {
	
	private int row, col;///holds the row and column of a sample object
	private boolean hOrI, pickedUp;///hOrI - hematite or ice sample (true : hematite, false : ice) picked up - has it been picked
	private char rep;///char that represents
	
	public Sample (boolean b, int r, int c){///constructor allows for setting the type, row, and column
		row = r;
		col = c;
		hOrI = b;
		if (hOrI == true) rep = 'H';
		else rep = 'I';		
		pickedUp = false;
	} 
	public char type(){///returns the type of sample
		return rep;
	}
	public boolean checkCollision(int r, int c){///checks if it has been collided with anything - the r and c are supposed to represent the row and col
		boolean b = false;
		if ((r==row) && (c == col)) {
			b = true;
		}
		return b;
	}
	public boolean getPicked(){ ///returns of it has been picked up
		return pickedUp;
	}
	public int getRow(){ return row; } ///returns the current row
	public int getCol(){ return col; }///returns the current col
}
