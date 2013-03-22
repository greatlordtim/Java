import java.util.ArrayList;
import java.awt.*;

public class Barrier extends Rectangle{
	double x, y;
	int w,h;
	public Barrier(double x , double y , int w , int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		updateBounds();
	}
	void updateBounds(){
		setBounds((int)x, (int) y, w, h );
	}
	void updateY(double d){
		y = d;
	}
	void drawBarrier(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, w , h);
	}
}
