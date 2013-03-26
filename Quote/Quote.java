// Jimmy Liu
// March 23, 2013
// Quote.java
// Display quotes

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quote {
	JFrame frame;
	
	public static void main(String[] args) {
		Quote ce = new Quote();
		ce.Run();
	}
	
	public void Run() {
		// Create a frame to hold everything
		frame = new JFrame ("Quotes");
		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(boxLayout);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.gray);
						
		JButton jl1 = new JButton("PRESS FOR A RANDOM QUOTE");
		jl1.setFont(new Font("Helvetica", Font.BOLD, 20));
		frame.add(jl1);
		frame.add(Box.createRigidArea(new Dimension(0,5)));

		JRadioButton red = new JRadioButton("Red");
		JRadioButton green = new JRadioButton("Green");
		JRadioButton blue = new JRadioButton("Blue");
		frame.add(red);
		frame.add(green);
		frame.add(blue);

		JSlider slider1 = new JSlider();
		frame.add(slider1);
    	slider1.setMajorTickSpacing(2);
    	slider1.setMinimum(16);
    	slider1.setMaximum(24);
    	slider1.setPaintTicks(true);
    	slider1.setPaintLabels(true);
    	slider1.setSnapToTicks(true);
		frame.setVisible(true);
	}
		
}	// end class ComponentExample