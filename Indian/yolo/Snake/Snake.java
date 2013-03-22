import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Snake extends JPanel implements ActionListener{
	Head h;
	
	int x;
	public void actionPerformed(ActionEvent evt){
		
		repaint();
		h.realMove();
	}	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		h.drawHead(g);
		for(int i = 0; i < 50; i ++){
			g.drawLine( i*10, 0 ,  i*10, 300);
		}
		for (int i = 0; i < 30; i ++){
			g.drawLine(0,  i*10, 500, i *10);
		}
	}
	public Snake(){
		
		x = 0;
		h = new Head(250,150);
		Timer t = new Timer (10,this);
		t.start();
		
	
	}
}
