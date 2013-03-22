import java.awt.*;
import java.util.ArrayList;

public class Token extends Rectangle{
	int rOb, x, radius;
	double y;
	double dropAmount = .5;
	boolean collided = false;
	ArrayList<Rectangle> collision = new ArrayList<Rectangle>();

	public Token (int rObdecider, int xP, int yP, int r){
		rOb = rObdecider;
		x = xP;
		y = yP;
		radius = r;
		this.setBounds(x, (int)y, radius, radius);
		
	}
	public Token(){
	
	}
	public void setStuff(int rObdecider, int xP, int yP, int r){
		rOb = rObdecider;
		x = xP;
		y = yP;
		radius = r;
		this.setBounds(x, (int)y, radius, radius);
		
	}
	public void drawToken(Graphics g){
		g.setColor(Color.BLACK);
		if (rOb == 0){
			g.setColor(Color.RED);
		}
	
		g.fillOval(x,(int) y, radius ,radius );
	
	}
	public void moveRight(int y){
		x += y;
		this.setBounds(x,(int)y,radius, radius);
	}
	public void moveLeft(int y){
		x-=y;
	}
	
	public int drop( int increment){
			if (collision.size() != 0){
				for (int i = 0; i < collision.size(); i++){
					if (this.intersects(collision.get(i))){
						System.out.println("d");
						collided = true;
						break;
					}
				}
			}
			if(collided){
				dropAmount = 0;
				increment ++;
				collided = false;
			}
			else{
				y += dropAmount;
				this.setBounds(x, (int)y, radius, radius);
				dropAmount += .1;
			}
	return increment;
	}
	
	public void AddRect(Rectangle r){
		collision.add(r);
	}
	
	
	
	





}
