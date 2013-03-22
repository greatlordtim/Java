//Anindit Gopalakrishnan
//1/17/13
//PrintSpace.java
//This class makes a printspace object, or an object that makes it easy to print the array.
public class PrintSpace{
	private int row, col;///holds the row and the column 
	private char repchar;///holds the char that represents it
	private char specChar;///special char - the "special" char that it can represent - either R. H, I, -, or @
	public PrintSpace (int x, int y){ ///constructor sets the initial rep char to ' ' because you want most of the array to be ' '
	///allows the user to set the x and y, and by default makes the specChar -
		repchar = ' ';
		row = x;
		col = y;
		specChar = '-';
	}
	
	public char setChar(Rover r	){///setsThe char to its plain ' ' or specchar state - spec char if the rover is in viewing distance
		boolean part1 = ((Math.abs((r.getRow() - row))) + Math.abs((r.getCol() - col))  <=3); ///kind of like distance formula, if a space is a combined
		///3 units away it should not be there
		if (part1){
			boolean p1 = (r.getRow() == row);
			boolean p2 = (r.getCol() == col);
			if (p1&&p2){
				repchar = r.getRepChar();
			}
			else repchar = specChar;
		}
		else repchar = ' ';
		return repchar;
	}
	public void sSet(char c){///allows to set the spec char
		specChar  = c;
	}
	public char getChar(Rover r){///this method is used to print the board at the end - if the rover is on it returns r
		if (r.getRow() == row && r.getCol() == col) return 'R';
		else return specChar;
	}
	public char getChar(){///this method returns specChar
		return specChar;
	}
	
	
}
