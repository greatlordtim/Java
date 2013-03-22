import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class ThePanel extends JPanel implements ActionListener{
	Random r =new Random();
	Button b;
	Strip s1, s2, s3;
	public void actionPerformed(ActionEvent evt){
		b.addSetColor();
		if (!b.end){
			s1.rollStrip();
			s2.rollStrip();
			s3.rollStrip();
		}
		else{
			s1.stop();
			s2.stop();
			s3.stop();
		}
		repaint();
	}
	public ThePanel(){
		b = new Button(20, 34,60);
		this.addMouseListener(b);
		Timer timer = new Timer(5, this);
		int move = r.nextInt(5)+1;
		int whichway = r.nextInt(2);
		if(whichway ==0){
			move*=(-1);
		}
		s1 = new Strip(150, 0, move);
		move = r.nextInt(5)+3;
		whichway = r.nextInt(2);
		if(whichway ==0){
			move*=(-1);
		}
		s2 = new Strip (295, 0, move);
		move = r.nextInt(5)+1;
		whichway = r.nextInt(2);
		s3 = new Strip(440, 0, move);
		timer.start();
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		b.drawButton(g);
		g.setColor(Color.BLACK);
		s1.drawStrip(g);
		s2.drawStrip(g);
		s3.drawStrip(g);
		
	}



}
