//Anindit Gopalakrishnan
//2/4/13
//Web.java
//This program has the ability to draw webs with varying numbers of
//verticies.

//mousePressec

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class Web {
	JFrame frame = new JFrame("Web");
	Buttons panel = new Buttons();

	public static void main (String args[]) {		
		Web web = new Web();
		web.run();
	}
	public void run(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(new BorderLayout(600,100));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setButtons();
		frame.setSize(612,731);
		frame.setVisible(true);
		frame.setResizable(false);
		//WebDrawing w = new WebDrawing();
		//frame.
		//frame.getContentPane().add(w, BorderLayout.CENTER);
		
		//WebDrawing webs = new WebDrawing();
		//frame.getContentPane().add(webs, BorderLayout.CENTER);
	}
}
class Buttons extends JPanel implements MouseListener {
	int verticies;
	int web = 20;
	Button[] buttons;
	public Buttons(){
		verticies = 0;
		buttons = new Button[5];
		this.addMouseListener(this);
	}
	
	public void setButtons(){
			
		for(int i = 0 ; i < 5; i ++){
			buttons[i] = new Button(i*120, 0, 120,100,(i+1)*4);
		}

	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		
		Font f = new Font("Arial", Font.ITALIC, 40);
		g.setFont(f);
		for (int i = 0; i <5; i++){
			buttons[i].drawButton(g);
			//if (i <= 1) g.drawString((i+1)*4 + "", 40 + 120*i, 60) ;

			//else g.drawString((i+1)*4 + "", 20 + 120*i, 60) ;
		}
		g.setColor(Color.white);
		g.fillRect(0,0,getWidth(),3);
		g.fillRect(0,(97), getWidth(), 3);
		
		for (int i= 0; i < 5; i++){
			g.fillRect(120*i,0 , 3, 100);
		}
		//System.out.println(getWidth() + " " + getHeight());
		g.setColor(Color.white);
		if ((web >= 0) && (web < 4)){
			buttons[web].drawWeb(g);
		}
	}
	public void mousePressed(MouseEvent e){
		if ((e.getX() > 0) && (e.getX() < 120) && (e.getY() > 0) && (e.getY() < 100)) {
			System.out.println(e.getX() + " " + e.getY() + "vertecies: 4");
			verticies = 4;
			web = 0;
		}
		else if ((e.getX() > 120) && (e.getX() < 240) && (e.getY() > 0) && (e.getY() < 100)){
			System.out.println(e.getX() + " " + e.getY() + "vertecies: 8");
			verticies = 8;
			web =  1;
		}
		else if ((e.getX() > 240) && (e.getX() < 360) && (e.getY() > 0) && (e.getY() < 100)) {
			System.out.println(e.getX() + " " + e.getY() + "vertecies: 12");
			verticies = 12;
			web = 2;
		}
		else if ((e.getX() > 360) && (e.getX() < 480) && (e.getY() > 0) && (e.getY() < 100)) {
			System.out.println(e.getX() + " " + e.getY() + "vertecies: 16");
			verticies = 16;
			//buttons[3].drawWeb();
			web = 3;
		}
		else if ((e.getX() > 480) && (e.getX() < 600) && (e.getY() > 0) && (e.getY() < 100)) {
			System.out.println(e.getX() + " " + e.getY() + "vertecies: 20");
			verticies = 20;
			//buttons[4].drawWeb();
			web = 4;
		}
		repaint();
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
		//public int verticies(){ return vertex;}
}

class Button{
	int x, y, vertex, w, h;
	Point[] point;
	Random rand;
	public Button(int x, int y, int w, int h, int vertex){
		this.x  =x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.vertex = vertex;
		point = new Point[vertex];
		rand = new Random();
	}
	public void drawButton(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(x,y,w,h);
		g.setColor(Color.magenta);
		if (vertex <= 8) g.drawString(vertex+"", x + 45, 60); 
		else g.drawString(vertex+"", x + 30, 60);
		
		//g.drawString(vertex + "", x + 20, y + 60);
	}
	public void drawWeb(Graphics g){
		initializePoints();
		for (int i = (vertex-1); i >= 0 ; i--){
			for (int j = (i-1); j >= 0; j --) 
				g.drawLine((int)point[i].getX(), (int) point[i].getY(), (int) point[j].getX(); (int)point[j].getY()); 
		}
	}
	public void initializePoints(){
		if (vertex == 4){
			for (int i = 0; i < 2; i ++){
				for (int j = 0; j <= 2; j++){
					System.out.println(j+i);
					point[j+i] = getPt(j*300,i*300 + 100, (j+1)*300, (i+1)*300+100);
				}	 
			}
		}
		else if (vertex == 8){
			
			point[0] = getPt(0,100, 200,300);
			point[1] = getPt(200,100, 400,300);
			point[0] = getPt(400,100, 600,300);
			point[0] = getPt(0,300, 200,500);
			point[0] = getPt(200,300, 400,500);
			point[0] = getPt(400,300, 600,500);
			point[0] = getPt(0,500, 300,700);
			point[0] = getPt(300,500, 600,700);

		}
		else if (vertex == 12){
			for (int i = 0; i < 3; i ++){
				for (int j = 0; j < 4; i++){
					point[j+i] = getPt(j*150,i*200 + 100, (j+1)*150, (i+1)*200+100);
				}	 
			}
		}
		else if (vertex == 16){
			for (int i = 0; i < 4; i ++){
				for (int j = 0; j < 4; i++){
					point[j+i] = getPt(j*150,i*150 + 100, (j+1)*150, (i+1)*150+100);
				}	 
			}
		}
		else if (vertex == 20){
			for (int i = 0; i < 4; i ++){
				for (int j = 0; j < 5; i++){
					point[j+i] = getPt(j*120,i*150 + 100, (j+1)*120, (i+1)*150+100);
				}	 
			}
		}
	}
	public Point getPt(int x, int y, int x2, int y2){
		int ptX = rand.nextInt(x2) + x;
		System.out.println(x1);
		System.out.println(x2);
		int ptY = rand.nextInt(y2) + y;
		return new Point(ptX, ptY);
	}
	
}
