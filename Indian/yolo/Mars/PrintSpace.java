public class PrintSpace{
	private int row, col;
	private char repchar;
	private char specChar;
	public PrintSpace (int x, int y){
		repchar = ' ';
		row = x;
		col = y;
		specChar = "-";
	}
	
	public char setChar(Rover r, Alien a, Sample s	){
		boolean part1 = ((Math.abs((r.getRow() - row))) + Math.abs((r.getCol() - col))  <=3);
		if (part1){
			boolean p1 = (r.getRow() == row);
			boolean p2 = (r.getCol() == col);
			if (p1&&p2){
				repchar = r.getRepChar();
			}
			else if (
			else repchar = specChar;
		}
		else repchar = ' ';
		return repchar;
	}
	public void sSet(char c){
		sSet  = c;
	}
}
