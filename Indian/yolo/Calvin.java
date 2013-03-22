//Anindit Gopalakrishnan
//1/28/13
//Calvin.java
//This draws Calvin's face! :D - on a jpanel which is added to jframe.
import javax.swing.*;
import java.awt.*;

public class Calvin extends JPanel {//extends JPanel - means that the calvin class IS the JPanel

	public static void main (String args[]) {		
		JFrame frame = new JFrame("Calvin"); //Frame that holds all the content
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);
		frame.setSize(414,583); //extra used to compensate for the drawing of JFRAME
		Calvin c = new Calvin();
		frame.getContentPane().add(c,BorderLayout.CENTER); //adds calvin
		frame.setVisible(true);

	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.lightGray);
		
		for(int i = 0; i < 41; i++){ //these for loops draw the horizontal and vertical gray lines that make up the graph paper
			g.drawLine(10*i, 0, 10*i, 550);
		}
		for(int i = 0; i < 56; i++){
			g.drawLine(0, i*10, 400, i *10); 
		}
		
		g.setColor(Color.red); //these forloops draw the horizontal and vertical RED lines that make up some of the graph paper
		for(int i = 0; i < 9; i++){
			//g.drawLine(50*i-1, 0, 50*i-1,550);
			g.drawLine(50*i, 0, 50*i, 550);
			//g.drawLine(50*i+1, 0, 50*i+1, 550);
		}
		for(int i = 0; i < 12; i++){
			g.drawLine(0, 50*i, 400, 50*i);
		}
		//these Lines make up Calvin's hair
		g.setColor(Color.black);
		g.drawLine(20,270,60,270);
		g.drawLine(30,230,60,270);
		g.drawLine(70,130,90,210);
		g.drawLine(120,70,120,170);
		g.drawLine(130, 60,170,150);
		g.drawLine(30,200,70,240);
		g.drawLine(220,40,180,140);
		g.drawLine(220,40,230,140);
		g.drawLine(270,40,240,140);
		g.drawLine(300,70,270,150);
		g.drawLine(310,180,360,140);
		g.drawLine(310,190,380,200);
		g.drawLine(330,230,360,230);
		g.drawLine(330,280,370,270);
		
		g.drawLine(170,410,210,420); //this line makes up Calvin's mouth
		
		//g.drawLine(300,70,270,180);
		
		for(int i = 0; i < 4; i++){ //this for loop draws calvins rounded rectangle part of his shirt
			g.setColor(Color.white);
			g.fillRoundRect(160-i,(450+i*20),(40+3*i),20,5,5); //draws the white part
			g.setColor(Color.black);
			g.drawRoundRect(160-i,(450+i*20),(70+3*i),20,5,5); //draws the outlined part
			g.drawRoundRect(160-i,(450+i*20),(40+3*i),20,5,5);
		}
		g.drawRoundRect(160,530,78,20,5,5); //draws the bottom rectangle
		g.drawLine(170,530,170,550); //draws the lines that make up his arms
		g.drawLine(190,530,190,550);
		//draws the outline of the eyes 
		g.drawOval(210,200,80,140); 
		g.drawOval(130,210,80,130);
		//draws the pupil of the eyes
		g.fillOval(180,270,20,30);
		g.fillOval(220,270,20,40);
		//draws the eyebrows
		g.drawArc(170,160,40,20,-175,-140);
		g.drawArc(230,160,40,30,0,119);
		//draws the nose
		g.drawArc(180,330,50,40,45,-269);
		//draws the mouth segments
		g.drawArc(60,150,270,300,170,18);
		g.drawArc(60,150,270,300,211,118);
		g.drawArc(60,150,270,300,10,-18);
		//draws the ears
		g.setColor(Color.white);
		g.fillOval(40,320,50,60);
		g.fillOval(300,320,50,60);
		g.setColor(Color.black);
		g.drawArc(40,320,50,60,100,204);
		g.drawArc(300,320,50,60,80,-204);
		
		
	}
}
java.awt.event*

class MouseListner implements MouseListner{
	pubic
}
