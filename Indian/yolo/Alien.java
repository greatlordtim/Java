import java.util.Random;
public class Alien{
	private int row, col;
	private Random rand;
	private char charrep;
	private boolean draw;
	public Alien(){
		rand = new Random();
		row = rand.nextInt(25);
		col = rand.nextInt(25);
		//row = 1;
		//col = 1;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	
	
}
