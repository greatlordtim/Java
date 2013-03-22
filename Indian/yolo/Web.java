//Anindit Gopalakrishnan
//2/4/13
//Web.java
//This program has the ability to draw webs with varying numbers of
//verticies.



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class Web {// this class holds the Jframe onto which everything is drawn
	JFrame frame = new JFrame("Web"); //the frame that holds everything
	Buttons panel = new Buttons();//the button panel that is the web and buttons that determines the 
	//number of vertecies
	ButtonPanel b ; //this holds the panel that changes the color of the web

	public static void main (String args[]) {		
		Web web = new Web(); 
		web.run(); 
	}
	public void run(){
	//
		//frame.getContentPane().getLayout().setVgap(0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets up the frame of the plan
		//frame.setLayout(new BorderLayout(600,100));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(b, BorderLayout.SOUTH);
		panel.setButtons();
		frame.setSize(612,771); // 612, 771 - these make the jframe exactly what we want (600,700)
		frame.setVisible(true);
		
		frame.setResizable(false);
		//WebDrawing w = new WebDrawing();
		//frame.
		//frame.getContentPane().add(w, BorderLayout.CENTER);
		
		//WebDrawing webs = new WebDrawing();
		//frame.getContentPane().add(webs, BorderLayout.CENTER);
	}
	class Buttons extends JPanel implements MouseListener{ //this class is the JPanel where the web is drawn
		int verticies; //holds the number of verticies
		int web = 20; //web is an index used in the buttons array
		int width = 600;
		int height = 700;
		Button[] buttons; //this is an array of all the buttons there are
		public Buttons(){ //constructor initializes things to basic values
			verticies = 0; 
			buttons = new Button[5]; // Button array holds the 5 buttons that are used to change the number of vertecies
			this.addMouseListener(this);
			//this.add(red);
			b = new ButtonPanel();
		}
		
		public void setButtons(){ //sets the buttons to their respective places atop the screen
		//numbers are hardcoded
				
			for(int i = 0 ; i < 5; i ++){
				buttons[i] = new Button(i*(width/5), 0, width/5,100,(i+1)*4);
			}

		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(0,0,600,700); //paints a black rectangle
			
			Font f = new Font("Arial", Font.ITALIC, 40);
			g.setFont(f);
			for (int i = 0; i <5; i++){
				buttons[i].drawButton(g); //draws the buttons - includes fonts
				//if (i <= 1) g.drawString((i+1)*4 + "", 40 + 120*i, 60) ;

				//else g.drawString((i+1)*4 + "", 20 + 120*i, 60) ;
			}
			g.setColor(Color.white);
			g.fillRect(0,0,getWidth(),3); //draws some seperation lines
			g.fillRect(0,(97), getWidth(), 3);
			
			for (int i= 0; i < 5; i++){//draws more seperation clines
				g.fillRect(120*i,0 , 3, 100);
			}
			//System.out.println(getWidth() + " " + getHeight());
			
			g.setColor(b.getColor()); //b.getColor - changes the Color based
			//on the other class - changes based on button
			
			if ((web >= 0) && (web <= 4)){ //web index is  changed based on which button is pressed
				buttons[web].drawWeb(g);
			}
		}
		public void mousePressed(MouseEvent e){
			if ((e.getX() > 0) && (e.getX() < 120) && (e.getY() > 0) && (e.getY() < 100)) { //first button
				System.out.println(e.getX() + " " + e.getY() + "vertecies: 4");
				verticies = 4;
				web = 0; //web only draws the button indexed at 0
				buttons[0].initializePoints(); //initializes the points for one button
				repaint();

			}
			else if ((e.getX() > 120) && (e.getX() < 240) && (e.getY() > 0) && (e.getY() < 100)){//2nd button
				System.out.println(e.getX() + " " + e.getY() + "vertecies: 8");
				verticies = 8;
				web =  1;
				buttons[1].initializePoints();

				repaint();

			}
			else if ((e.getX() > 240) && (e.getX() < 360) && (e.getY() > 0) && (e.getY() < 100)) { //third button
				System.out.println(e.getX() + " " + e.getY() + "vertecies: 12");
				verticies = 12;
				web = 2;
				repaint();
				buttons[2].initializePoints();

			}
			else if ((e.getX() > 360) && (e.getX() < 480) && (e.getY() > 0) && (e.getY() < 100)) {//fourth button
				System.out.println(e.getX() + " " + e.getY() + "vertecies: 16");
				verticies = 16;
				buttons[3].initializePoints();
				web = 3;
			repaint();

			}
			else if ((e.getX() > 480) && (e.getX() < 600) && (e.getY() > 0) && (e.getY() < 100)) {//5th button
				System.out.println(e.getX() + " " + e.getY() + "vertecies: 20");
				verticies = 20;
				buttons[4].initializePoints();
				web = 4;
				repaint();

			}
		}
		public void mouseClicked(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
			//public int verticies(){ return vertex;}
	}

	class Button{ //this class represents one of those buttons at the top of the screen
		int x, y, vertex, w, h;
		//x - xposition
		//y - y position
		//vertex - how many verticies
		//w- width
		//h - height
		Point[] point; //point array holds the number of points (for the web)
		Random rand; //random number generator for generating the points
		public Button(int x, int y, int w, int h, int vertex){ //constructor allows values to be set oustide of the class
			this.x  =x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.vertex = vertex;
			point = new Point[vertex]; //there only needs to be the number of points to equal number of vertecies
			rand = new Random();
		}
		public void drawButton(Graphics g){ //this method draws the button 
			g.setColor(Color.blue);
			g.fillRect(x,y,w,h);
			g.setColor(Color.magenta);
			if (vertex <= 8) g.drawString(vertex+"", x + 45, 60); //if its one digit, needs some compensation to put in center
			else g.drawString(vertex+"", x + 30, 60);
			
			//g.drawString(vertex + "", x + 20, y + 60);
		}
		public void drawWeb(Graphics g){ //this method draws the web
			//initializePoints();
			for (int i = (vertex-1); i >= 0 ; i--){  //nested for loop: starts at the last point that has been indexed, connects to all points "below" in
			//the indecies for the array, then moves down till all the lines are connected.
				for (int j = (i-1); j >= 0; j --) {
					
					g.drawLine((int)point[i].getX() , (int) point[i].getY(), (int) point[j].getX(), (int)point[j].getY()); 
					//System.out.println((int)point[i].getX() + " " +  (int) point[i].getY() + " " + (int) point[j].getX() + " " + (int)point[j].getY());
				}
			}
		}
		public void initializePoints(){ //this method is so long because I try to space outt he points
			int count = 0; //count counts the number of times the loop as went through
			
			if (vertex == 4){
				for (int i = 0; i < 2; i ++){
					for (int j = 0; j < 2; j++){
						System.out.println(j+i);
						point[count] = getPt(j*300,i*300 + 100, (j+1)*300, (i+1)*300+100); //divides the screen up into a 2x2 grid where points are initialized
						count++;
					}	 
				}
			}
			
			else if (vertex == 8){ // 8 is hardcoded because it is an irregular box that makes it look the best (3x3x2)
				
				point[0] = getPt(0,100, 200,300); //first 2 rows - 3 pts
				point[1] = getPt(200,100, 400,300);
				point[2] = getPt(400,100, 600,300);
				point[3] = getPt(0,300, 200,500);
				point[4] = getPt(200,300, 400,500);
				point[5] = getPt(400,300, 600,500);
				point[6] = getPt(0,500, 300,700); //last 2 rows - 2 pts
				point[7] = getPt(300,500, 600,700);

			}
			else if (vertex == 12){
				count = 0;
				//int count2 = 1;
				for (int i = 0; i < 3; i ++){
					for (int j = 0; j < 4; j++){
						System.out.println(count);

						point[count] = getPt(j*150,i*200 + 100, (j+1)*150, (i+1)*200+100); //divides the grid into a 4x3 grid
						count++;
						//count2++;
			
					}	 
				}
			}
			else if (vertex == 16){
				count = 0;
				for (int i = 0; i < 4; i ++){
					for (int j = 0; j < 4; j++){
						point[count] = getPt(j*150,i*150 + 100, (j+1)*150, (i+1)*150+100); //divides the frame into a 4x4 grid
						count++;
					}	 
				}
			}
			else if (vertex == 20){
				count = 0;
				for (int i = 0; i < 4; i ++){
					for (int j = 0; j < 5; j++){
						point[count] = getPt(j*120,i*150 + 100, (j+1)*120, (i+1)*150+100); //divides the frame into a 5x4 grid
						count++;
					}	 
				
				}
			}
			//what the girds actually mean is that one point is initialized in each of the "boxes" so the points are more spaced out and look cooler xD
		}
		public Point getPt(int x1, int y1, int x2, int y2){ //initializes a random number within the constrains of x1, y1, x2, and y2
			int ptX = rand.nextInt(x2-x1) + x1;
			
			int ptY = rand.nextInt(y2-y1) + y1;
			System.out.println(ptX + "  " + ptY);
			return new Point(ptX, ptY);
			//int ptX = rand.nextInt(600);
			//int ptY = rand.nextInt(600)+100;
			//return new Point(ptX, ptY);
		}
	}	

	class ButtonPanel extends JPanel{ //this class is that holds the buttons along the bottom of the web
		JButton red = new JButton("Red");
		JButton blue = new JButton("Blue");
		JButton white=  new JButton ("White");
		JButton purple = new JButton ("purple");
		JButton yellow = new JButton("Yellow");
		JButton green = new JButton("Green");
		JButton random = new JButton("Random");
		//these are all the buttons along the bottom
		Color color = Color.white;
		boolean repaint = false;
		class red implements ActionListener{ //actionlistener for the red button
			public void actionPerformed(ActionEvent evnt){
				System.out.println("hi");
			color = Color.red;
			panel.repaint();
			}
		}
		class blue implements ActionListener{ //actionlistender for the blue button
			public void actionPerformed(ActionEvent evnt){
			color = Color.blue;
			panel.repaint();
			}
		}
		class random implements ActionListener{ //this class picks a random color to make the web
			public void actionPerformed(ActionEvent evnt){
				Random r = new Random();
				switch(r.nextInt(6)){ 
					case 0: color = Color.red; break;
					case 1: color = Color.blue; break;
					case 2: color = Color.green; break;
					case 3: color = Color.yellow; break;
					case 4: color = Color.white; break;
					case 5: color = Color.magenta; break;
				}
				panel.repaint();
				
			}
		}
		class yellow implements ActionListener{ //yellow button 
			public void actionPerformed(ActionEvent evnt){
			color = Color.yellow;
			panel.repaint();
			}
		}
		class white implements ActionListener{ //white button
			public void actionPerformed(ActionEvent evnt){
				color = Color.white;
				panel.repaint();
			}	
		}
		class purple implements ActionListener{ //purple button
			public void actionPerformed(ActionEvent evnt){
			color = Color.magenta;
			panel.repaint();
			}
		}
		class green implements ActionListener{ //green button
			public void actionPerformed(ActionEvent event){
				color = Color.green;
				panel.repaint();
			}
		}
		
		public ButtonPanel(){// adds all the actionlisteners to the buttons so that when they are pressed they do whatever is in the class
			add(red);
			add(blue);
			add(white);
			add(purple);
			add(yellow);
			add(green);
			add(random);
			red.addActionListener(new red());
			blue.addActionListener(new blue());
			white.addActionListener(new white());
			purple.addActionListener(new purple());
			yellow.addActionListener(new yellow());
			green.addActionListener(new green());
			random.addActionListener(new random());
		}
		public void paintComponent(Graphics g){ //sets a black backround
			g.setColor(Color.black);
			g.fillRect(0,0,getWidth(),getHeight());
		}
		
		public Color getColor(){ //returns the color that was clicked
			return color;
		}
		public boolean Repaint(){
			return repaint;
		}
	}
}
