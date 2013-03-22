//11/15/2012
//This class will have create an HPart that will make up the helicopter.
//The parts will be allowed to individually break, and will also be able to
//draw themselves.


import java.awt.*;

public class HPart extends Rectangle{
	private int x; //this holds the x position of the helicopter Part;
	private int w; //this holds the width of the helicopter part;
	private int h; //this holds the height of the helicopter part;
	private double y; //this holds the y position of the helicopter part, the only variable that will actually change
	private boolean exists; //this holds whether or not the part exists or has been destroyed;
	
	public HPart(int X, double Y, int W, int H){ //constructer initializes width, height, x position, y position, exists
		x = X;
		y = Y;
		w = W;
		h = H;
		this.setBounds(x,y,w,h);
		exists = true;
	}
	public void move(int a){ //this moves the y position by a units (a can be negative)
		y+= a;
	}
	public void setPos(int Y){ //this sets the position of the y
		y = Y;
	}
	public void drawPart(Graphics g){ //if exists is true, then it draws the part
		if (exists){
			g.fillRect(x,y,w,h);
		}
			
	
	}
	public void exists(boolean b){//this allows you to set whether exists is false or true
	
	
		exists = b;
	}


}
