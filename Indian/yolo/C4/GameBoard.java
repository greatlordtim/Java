import java.awt.*;
import java.awt.event.*;
public class GameBoard {
	
	int x, y;
	int width, height;
	int numSpacesW, numSpacesH;
	
	public GameBoard(int xP, int yP){
		numSpacesW = 7;
		numSpacesH = 6;
		x = xP;
		y = yP;
		width = 7 *60;
		height = 6* 60;
	}
 	public void drawBoard(Graphics g){
		/*for (int i = 0; i < 42; i ++){
			//drawBlock(g, x+(i%7)*60, y+((i+1)/10)*60);
		//}*/
		for (int i = 0; i < 6; i++){
			drawRow(g,x,y+i*60);
		}
		Color color = new Color(0,250,250);
		g.setColor(Color.YELLOW);
		g.fillRect(x-10, y + 360, 510, 20);
		g.fillRect(x-10, y+380, 30,30);
		g.fillRect(x+470, y+380, 30, 30);
	}
	public void drawBlock(Graphics g, int x1, int y1){
		
		g.setColor (Color.BLUE);
		g.fillRect(x1,y1,10,60);
		g.fillRect(x1,y1,70,5);
		g.fillRect(x1+60,y1, 10,60);
		g.fillRect(x1, y1+55, 70, 5);
		drawCircle(g, x1+10, y1+5);
		/*int centerX = x1+35;
		int centerY = y1+30;
		
		int cX = centerX-25;
		int cY = centerY-25;
		g.fillOval(cX,cY,50,50);*/
	}
	public void drawRow(Graphics g, int x2, int y2){
		for (int i =0; i < 7; i ++){
			drawBlock(g, x2+i*70, y2);
		
		}
	}
	public void drawCircle(Graphics g, int x3, int y3){
	
		for (int i = 0; i < 25; i++){
			g.drawLine(x3, y3+i, x3+25-i, y3);
		}
		//x3 += 25;
		//y3 += 50;
		for (int i = 0; i<25; i++){
			g.drawLine (x3, y3+25+i, x3 +i, y3 + 50);
		}
		for (int i = 0; i < 25; i++){
			g.drawLine(x3+50, y3+25 - i, x3+50 - i, y3);  
		}
		for (int i = 0; i <  25; i++){
			g.drawLine(x3+50, y3+25+i, x3+50 - i, y3 + 50);
		}
		
	}
}
