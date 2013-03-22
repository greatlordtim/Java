//Anindit Gopalakrishnan
//1/17/13
//Sample.java
//This class holds the Sample object, which can be either hematite or ice.
public class Sample {
	
	private int row, col; //these hold the row and col position of the sample
	private boolean hOrI, //hOri holds if its hematite or ice
	private char rep; //this holds the character that will represent the Sample ('H' or 'I')
	
	public Sample (boolean b, int r, int c){ //constructor allows you to set the row, hematite or ice sample, and the col
		row = r;
		col = c;
		hOrI = b;
		if (hOrI == true) rep = 'H'; // h if hematite
		else rep = 'I';	//i for ice 
	} 
	public char type(){//this returns if its hematite or ice
		return rep;
	}
	public boolean checkCollision(int r, int c){ //this checks if it has collided with a rover
		boolean b = false;
		if ((r==row) && (c == col)) {
			b = true;
		}
		return b;
	}
	
	public int getRow(){ return row; } //returns the row
	public int getCol(){ return col; } //return the col
}
