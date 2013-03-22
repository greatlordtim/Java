import java.awt.*;
import java.awt.event.*;
public class  Button extends Rectangle implements MouseListener{
	int diameter;
	double radius;
	double littleRadius;
	double littleDiameter;
	double littleXPos;
	double littleYPos;
	double tryThis;
	int whichColor;
	int xPos;
	int yPos;
	boolean end = false;
	boolean changeColor;
	
	public void mouseClicked(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
		if (this.contains(e.getX(), e.getY())){
			changeColor = true;
			end = true;
		}
	}
	public void mouseReleased(MouseEvent e){
		//changeColor = false;
	}
	public void mouseEntered(MouseEvent e){}
	public Button(int xP , int yP, int d){
		diameter = d;
		radius = d/2;
		littleRadius = 4*radius/5;
		littleDiameter = 2*littleRadius;
		xPos = xP;
		yPos = yP;
		tryThis =50;
		double centerX = xPos + radius;
		double centerY = yPos + radius;
		littleXPos = centerX - littleRadius;
		littleYPos = centerY - littleRadius;
		this.setBounds((int)littleXPos, (int) littleYPos, (int) littleDiameter, (int) littleDiameter);
		System.out.println(78.0/84);
	}
	public void drawButton(Graphics g){
		g.fillOval(xPos, yPos, diameter, diameter);
		Color color = new Color(175,0,0);
		if (changeColor == true){
			g.setColor(color);
		}
		else {
			setColor(g);
		}

		g.fillOval((int)littleXPos, (int)littleYPos, (int) littleDiameter, (int) littleDiameter);
		
		g.drawLine(xPos+diameter + 30, 0, xPos + diameter + 30, 350 );
		
	}
	public void setColor(Graphics g){
		//g.setColor(Color.YELLOW);
		if (whichColor > 0 && whichColor <50){
			g.setColor(Color.YELLOW);
			System.out.println(whichColor);
		}
		else if (whichColor > 50&&whichColor<100){
			g.setColor(Color.RED);
			if (whichColor == 99){
			whichColor =0;
			}
		}
		
			
	}
	public void addSetColor(){
		whichColor++;
	}
	

}
