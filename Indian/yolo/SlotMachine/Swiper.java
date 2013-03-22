import java.awt.*;
import java.awt.event.*;

public class Swiper {
	int x, y, swipeX, swipeY;;
	public Swiper(int x, int y){
		this.x = x;
		swipeX = this.x + 10;
		this.y = y;
		swipeY = this.y - 20;
	}
	public void drawSwiper(Graphics g){
		 g.setColor(Color.GRAY);
		 g.fillRect(x,y,50,80);
		 g.setColor(Color.BLACK);
			g.fillRect(20,20,10,40);
		g.fillRect(10,20,30,10);
	}
}
