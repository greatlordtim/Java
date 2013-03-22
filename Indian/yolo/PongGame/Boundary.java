//Anindit Gopalakrishnan
//September 14, 2012
//Boundary.java
//This program will create a boundary object to be utilized in the 
//PongPanel class.

import java.awt.Rectangle;
import java.awt.Graphics;
public class Boundary extends Rectangle{
	int X;
	int Y;
	int W;
	int L;
	private int whichBound;
	final int NORTHSOUTH_BOUND = 0;
	final int EASTWEST_BOUND = 1;
	final int NORTHEAST_BOUND = 0;
	final int SOUTHWEST_BOUND = 1;
	 int whichThing;
	 
	
	public Boundary(int x, int y, int w, int l, int wBound, int boundType){
		X = x;
		Y = y;
		W= w;
		L = l;
		this.setBounds(X,Y,W,L);
		whichBound = wBound;
		whichThing = boundType;
	}
	public void drawBoundary(Graphics g){
		if (whichThing == SOUTHWEST_BOUND && whichBound == NORTHSOUTH_BOUND){
			g.fillRect(X,Y,W,5);
	
		}
		else{
			g.fillRect(X,Y,W,L);
		}
	}
	public int getBoundDirection(){
		return whichBound;
	}
	public int getWhichThing(){ 
		return whichThing;
	}
}
