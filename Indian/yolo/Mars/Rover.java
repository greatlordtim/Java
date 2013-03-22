import java.util.Scanner;
import java.util.Random;
public class Rover {
	private int row, col, moves, hSamps, iSamps, aEs;
	private Random rand;
	private char repchar;
	private boolean aliened;
	private Scanner scan;
	public Rover(){
		rand = new Random();
		repchar = 'R';
		aliened  = false;
		scan = new Scanner(System.in);
		moves = 0;
		hSamps=  0;
		iSamps  =0;
		aEs = 0;
		
	}
	public void initializeRover(){
		int x,y,count;
		count = 0;
		do{
			if(count == 0) System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice)     -> ");
			else System.out.print(          "ERROR: out of bounds, no such place on grid. Enter new number  -> ");
			x = scan.nextInt();
			count++;
		}while(!(x>=-1 && x<=24));
		count = 0;
		do{
			if(count == 0) System.out.print("Enter a grid column coordinate (0 - 24, -1 for random choice)  -> ");
			else System.out.print(          "ERROR: out of bounds, no such place on grid. Enter new number  -> ");
			y = scan.nextInt();
		}while(!(y>=-1 && y<=24));
		
		if (x==-1) row = random();
		else row = x;
		
		if (y==-1) col = random();
		else col = y;
		
		//System.out.println(row + " " + col);
	}
	public int random(){
		return rand.nextInt(25);
	}
	public void addToCollection(Sample s){
		if (s.type() == 'H') hSamps ++;

		else if (s.type() == 'I'){
			iSamps++;
		}
	}
	public int getMoves(){
		return moves;
	}
	public int getHSamps(){
		return hSamps;
	}
	public int getISamps(){
		return iSamps;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	public int getAEs(){
		return aEs;
	}
	public char getRepChar(){
		return repchar;
	}
	public void checkAlien(Alien a){
		if ((row == a.getRow()) && (col == a.getCol())) {
			repchar = '@';
			a.setDraw(false);
			aliened = true;
			aEs++;
		}
	}
	public void incrementMove(){
		moves++;
		System.out.print("hi");
	}
	public boolean doneMoving(){
		if (moves >= 30) return true;
		else return false;
	}
	public boolean Move (char c, Alien a){
		boolean nullit = false;
		int sMY = col;
		int sMX = row;
		if (c == 'd'){
			col ++;
			
			if (col > 24) {
				col = sMY;
				nullit = true;
			}
			
		}
		else if (c == 'a'){
			col --;
			if (col <0) {
				col = sMY;
				nullit = true;
			} 
		
		}
		else if (c == 'w'){
			row --;
			if (row < 0){
				row = sMX;
				nullit = true;
			}
				
		}
		else if (c == 's'){
			row++;
			if (row > 24){
				row = sMX;
				nullit = true;
			}
		}
			
		if (nullit == false) {
			incrementMove();
			checkAlien(a);
			//System.out.println("I AM A FREAKIN BAWS AND I SUCK ");
		}
		return nullit;		
	}
	
}
