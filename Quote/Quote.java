// Jimmy Liu
// March 23, 2013
// Quote.java
// Display quotes

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Quote {
	JFrame frame;
	JPanel panel1, panel2;
	JLabel jl;
	String inputLine;
	StringBuilder everything = new StringBuilder();
	BufferedReader in;

	    String line;
	
	public static void main(String[] args) {
		Quote quote = new Quote();
		quote.Run();
	}
	
	public void Run() {
		// Create a frame to hold everything
		frame = new JFrame ("Quotes");
		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS);
		frame.setLayout(boxLayout);
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.gray);
		frame.setVisible(true);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setPreferredSize(new Dimension(400,200));
		panel2.setPreferredSize(new Dimension(400,200));
		panel2.setBackground(Color.green);
		frame.add(panel1);
		frame.add(panel2);

						
		JButton jb = new JButton("PRESS FOR A RANDOM QUOTE");
		jb.setFont(new Font("Helvetica", Font.BOLD, 20));
		JButtonListener jblistener = new JButtonListener();
		jb.addActionListener(jblistener);
		panel1.add(jb);

		JRadioButton red = new JRadioButton("Red");
		JRadioButton green = new JRadioButton("Green");
		JRadioButton blue = new JRadioButton("Blue");
		JRadioListener jrlistener = new JRadioListener();
		red.addActionListener(jrlistener);
		panel1.add(red);
		panel1.add(green);
		panel1.add(blue);

		JSlider slider = new JSlider();
    	slider.setMajorTickSpacing(2);
    	slider.setMinimum(16);
    	slider.setMaximum(24);
    	slider.setPaintTicks(true);
    	slider.setPaintLabels(true);
    	slider.setSnapToTicks(true);
    	panel1.add(slider);

    	jl = new JLabel("Hello.");
    	jl.setFont(new Font("Helvetica", Font.PLAIN, 16));
        panel2.add(jl);
	}

	class JButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {ReadURL();}
			catch (Exception f) {}
		} //end actionPerformed
	} //end ActionListerne

	class JRadioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Radio Changed");
		} //end actionPerformed
	} //end ActionListerne

	class JSliderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Slider Changed");
		} //end actionPerformed
	} //end ActionListerne

	public void ReadURL() throws Exception {
        URL text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=1&source=calvin");
        in = new BufferedReader(new InputStreamReader(text.openStream()));
        ReadBigStringIn();
        in.close();
        jl.setText(inputLine);

    } //end ReadURL

	public String ReadBigStringIn() throws IOException {
	    while( (line = in.readLine()) != null) {
	       everything.append(line);
	    }
	    inputLine = everything.toString();
	    return everything.toString();
	}
		
}	// end class ComponentExample