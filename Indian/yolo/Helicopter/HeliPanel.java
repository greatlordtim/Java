import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
public class HeliPanel extends JPanel implements ActionListener, MouseListener{	
	Helicopter heli = new Helicopter(20,100);
	double x = 1;

	Random rand = new Random();
	ArrayList<Barrier> barriers = new ArrayList<Barrier>();
	
	public void mouseExited(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){
	 
	}
	public void mouseClicked(MouseEvent e){
		
	}
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		

	}
	public void actionPerformed(ActionEvent evnt){
		heli.move(4);
		heli.move++;
		repaint();
		eliminateUnused();
		moveBarriers();
	}
	public HeliPanel(){
		this.addMouseListener(heli);
		generateBarriers();
		Timer t = new Timer(5
		, this);
		t.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBarriers(g);
		heli.drawShip(g);
		g.setColor(Color.BLACK);
		
	}
	public void generateBarriers(){
		for (int i = 0; i < 1000; i++){
			int y = rand.nextInt(300);
			Barrier b = new Barrier(50 + i*(400), y, 60, 90);
			barriers.add(b);
		}
	}
	public void moveBarriers(){
		for (int i = 0; i < barriers.size(); i++){
			barriers.get(i).x--;
		}
	}
	public void eliminateUnused(){
		for (int i = 0; i < barriers.size(); i ++){
			if (barriers.get(i).x < 0){
				barriers.remove(i);
			}
		}
	}
	public void drawBarriers(Graphics g){
		for ( int i = 0; i < barriers.size(); i++){
			barriers.get(i).drawBarrier(g);
		}
	}
}
