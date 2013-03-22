 public class Coordinate{
	char x, int y;
	boolean filled; 
	public Coordinate(char x1, int y1){
		x = x1;
		y = y1;
	}
	public char getX(){return x }
	public int getY(){return y}
	public void isFilled(){
		filled = false;
	}
}
