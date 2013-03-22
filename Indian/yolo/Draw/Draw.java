//Anindit Gopalakrishnan
//Febuary 11, 2013
//Draw.java
//This program is a very basic paint program.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Draw{
	JFrame frame = new JFrame ("Paint"); //frame that holds all the components
	DrawPanel panel= new DrawPanel(); //panel on which things are drawn
	public static void main(String[] args){
		Draw d = new Draw();
		d.Run();
	}
	public void Run(){ //runs the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets up the frame of the plan
		frame.getContentPane().add(panel, BorderLayout.CENTER);	
		frame.setSize(512,631); // 612, 771 - these make the jframe exactly what we want (600,700)
		frame.setVisible(true);	
		frame.setResizable(false);
	
	}





}



class DrawPanel extends JPanel implements MouseMotionListener, MouseListener, KeyListener{
	Point[] pPs = new Point[10000000]; //this array holds the points that have been pressed
	Point[] mdPs = new Point[10000000]; //this array holds the points that have been created when the line has been dragged.
	Point tempDragged; //this point is the line that is being drawn, at the dragged end
	int pTBD; //this holds the number of points to be drawn - (pointsToBeDrawn)
	Color[] colors = new Color[10000000];
	 Button reset, red, blue, gray, green;
	 
	boolean drawing;
	int w= 94; //width of an individual button
	Color c = Color.red; //start with red
	public DrawPanel(){
		addMouseListener(this); //adds mouse listenders
		addMouseMotionListener(this); //adds stuff to the plaine
		pTBD = 0; //the point that is going to be drawn 
		drawing = false;//if its not drawing, false
		tempDragged = new Point(0, 0); //this point is the point that will be drawn
		reset = new Button(5,5,w,w,Color.black, "RESET");//makes the top buttons
		red = new Button(10 + w,5,w,w,Color.red, "RED");
		blue = new Button(15 + 2*w,5,w,w,Color.blue, "BLUE");
		gray = new Button(20 + 3*w,5,w,w,Color.gray, "GRAY");
		green = new Button(25 + 4*w,5,w,w,Color.green, "GREEN");
		
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(c); //changes the color each time
		g.fillRect(0,100,20,20); //
		g.setFont(new Font("Arial", 0, 20)); //sets font etc
		setBackgroud(Color.lightGray);
		g.drawString("Color Used", 20, 120);
		System.out.println(getWidth() +" " + getHeight());
		reset.drawButton(g);//draws all the buttons at the top
		red.drawButton(g);
		blue.drawButton(g);
		gray.drawButton(g);
		green.drawButton(g);
		g.setColor(c);
		if (pTBD > 0 && drawing == false){ //if not drawing, only draw points that were already drawn by the user.
			for (int i = 0; i < pTBD; i ++){
				g.setColor(colors[i]);	
				g.drawLine((int)pPs[i].getX(), (int)pPs[i].getY(), (int)mdPs[i].getX(), (int)mdPs[i].getY()); 
			}
		}
		else if (pTBD > 0 && drawing == true){//if drawing, draw the dragging like as well
			for (int i = 0; i < pTBD-1; i ++){
				g.setColor(colors[i]);
				g.drawLine((int)pPs[i].getX(), (int)pPs[i].getY(), (int)mdPs[i].getX(), (int)mdPs[i].getY()); 
			}
			g.setColor(colors[pTBD-1]);
			g.drawLine((int)pPs[pTBD-1].getX(), (int)pPs[pTBD-1].getY(), (int)tempDragged.getX(), (int)tempDragged.getY());
		}
	}	

	public void mousePressed(MouseEvent e){//if mouse is pressed, do thsese things
		Point p = new Point(e.getX(), e.getY());//current location
		if (reset.doAction(p) == 0) pTBD = 0;
		if (red.doAction(p) == 0) c = Color.red;
		if (blue.doAction(p) == 0) c = Color.blue;//change color 
		if (gray.doAction(p) == 0) c= Color.gray;
		if (green.doAction(p) == 0) c = Color.green;
		
		if (p.getY() > 100 ){ //if over a hundred, implement paint maneuvers
			repaint();
			tempDragged = new Point(e.getX(), e.getY());
			colors[pTBD] = c;
			drawing = true;
			pPs[pTBD] = p;
			pTBD++;
		}
		
		
		repaint();
	}
	public void mouseDragged(MouseEvent e){
		if (e.getY() > 100) tempDragged = new Point(e.getX(), e.getY());//resets the temporary dragging point
		else if (e.getY() <= 100) tempDragged = new Point(e.getX(), 101);//sets it to something else (so cant draw into the boxes)
		drawing = true;
		repaint();
	}
	public void mouseReleased(MouseEvent e){ //when the mouse is stopped dragging, it doesnt keep track of the tempdragged points.
		if (e.getY() > 100) {
			drawing = false;
			mdPs[pTBD-1] = tempDragged;
		}
		repaint();
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	
	
}
class Button { //this holds one of the buttons that are at the top of the screen to determine line Color
		int x, y, w, h;
 		//x - x Position
 		//y - y Position
 		//w - width
 		//h - height
 		Color c; //holds the color that the button will be
 		Rectangle r; //this rectangle will be used check if it has been clicked inside
 		String color;
 		
 		public Button(int X, int Y, int W, int H, Color C, String s){ //sets the values of the constructor
			x = X;
			y = Y;
			w = W;
			h = H;
			c = C;
			r = new Rectangle();
			r.setBounds(x, y+5, w, h);
			//System.out.print(r.getY() + " " + r.getX());
			color = s;
			//reset = new Button(0, 0, 
		}
		
		public void drawButton(Graphics g){ //draws the Button 
			g.setColor(c);
			g.fillRect(x,y,w,h);
			g.setFont(new Font("Arial", 0, 20));
			g.setColor(Color.white);
			g.drawString(color, x + 20, y + 60);
		}
		
		public int doAction(Point p){ //returns ints based on the various sceenarios - reset, change color, or nothign
			if (r.contains(p)) return 0;
			else return 1;
		}
}

