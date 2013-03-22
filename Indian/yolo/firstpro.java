/*
 *      firstpro.java
 *      
 *      Copyright 2012  <>
 *      
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 2 of the License, or
 *      (at your option) any later version.
 *      
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */

//Anindit Gopalakrishnan
//September 5, 2012
//firstpro.java
//This program will play the game pong once it is finished.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class firstpro implements Runnable{
	
	Thread t = new Thread(this);
	JFrame frame = new JFrame("This is a test frame");
	GPanel thisPanel = new GPanel();
	public static void main (String args[]) {		
		new firstpro();
	}
	public void run(){
		System.out.println("This worked");
	}
	public firstpro(){
		frame.setVisible(true);
		frame.setSize(400,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(thisPanel);
		frame.setResizable(false);
		t.start();
	}
}//ends class firstpro

  class GPanel extends JPanel implements MouseMotionListner{
	 int pPaddleY;
	
	public GPanel(){
		//pPaddleY = 80;
		this.addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(0,pPaddleY,5,45);
		
	}



	public void mouseMoved(MouseEvent e){
		pPaddleY = e.getY();
	}
	public void mouseDragged(MouseEvent e){
	}
	
}
 

