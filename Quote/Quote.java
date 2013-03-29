// Author: Jimmy Liu
// March 25, 2013
// Quote.java
// Display quotes from iheartquotes.com. Ability to choose catogories, font size, and font color

// Class Methods
//  Run: Creates all the elements needed by the program.  
//  JButtonListener: When button is pressed, goes on the internet and gets a new quote
//  JRadioListener: When radio button is changed, tells listener to use a case statement to switch font colors
//  JSliderListener: When slider is changed, gets the slider changed
//  ComboBoxListener: When combo box is changed, change the API where the quote is getting drawn from
//  ReadURL: NET for reading the API
//  ReadBigStringIn: Class for reading the string, using a stringbuilder to combine everything into one string

// Class Variables
//	JElements frame, panel1, panel2, slider2, jl, comboBox1, gropu, r, g, b,:
//	String inputLine: This is what the quote comes from. String for the quotes
//  BufferedREader in: This reads the .txt format generated from the URL API, and creates it into a string.
//  URL text: This is the URL for the API used to draw the URL's
//  int cat: What catogory the user wants to see quotes from

// API Usage (iheartquotes):
// 	format: return the result 'text', 'html', or 'json' format. The default is text.
// 	max_lines: maximum number of lines in the quote.
// 	min_lines: minimum number of lines in the quote.
// 	max_characters: maximum number of characters in the quote.
// 	min_characters: minimum number of characters in the quote.
// 	source: pulls quotes from one of the sources listed. Multiple sources should be space or "+" separated, ex: calvin+xfiles
// 	show_permalink: show the quote's permalink at the bottom of the text by default. Turn this off with "false" or "0".
// 	show_source: show the quote's source at the bottom of the text by default. Turn this off with "false" or "0".

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Quote {
	JFrame frame; JPanel panel1, panel2; JSlider slider2; JLabel jl, jl2; JComboBox comboBox1; ButtonGroup group; JRadioButton r, g, b;
	String inputLine;
	BufferedReader in;
	URL text;
	int cat = 0;
	double duration;
	
	public static void main(String[] args) { Quote quote = new Quote(); quote.Run(); }
	
	public void Run() {
		// Create a frame to hold everything
		frame = new JFrame ("Quotes");
		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS); //BoxLayout > GridLayout
		frame.setLayout(boxLayout);
		frame.setSize(800, 400); //Set Frame Size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.gray); //Background color gray
		frame.setVisible(true);
		frame.setResizable(false);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setPreferredSize(new Dimension(400,200));
		panel2.setPreferredSize(new Dimension(400,200));
		panel2.setBackground(Color.lightGray); //Second panel is lightgray
		frame.add(panel1);
		frame.add(panel2);

		JButton jb = new JButton("PRESS FOR A RANDOM QUOTE"); //RANDOMQUOTES!
		jb.setFont(new Font("Helvetica", Font.PLAIN, 23));
		JButtonListener jblistener = new JButtonListener(); //New Listener for the button
		jb.addActionListener(jblistener); //ADD ME
		jb.setPreferredSize(new Dimension(390, 80)); //Setting the size I want
		panel1.add(jb);
		jl2 = new JLabel(""); //Nothing to see here, this is API call timer
        jl2.setFont(new Font("Helvetica", Font.PLAIN, 10));
        jl2.setPreferredSize(new Dimension(360, 30));
        panel1.add(jl2); //ADD ME

		group = new ButtonGroup(); //Create a brand new button group
		r = new JRadioButton("Red"); g = new JRadioButton("Green"); b = new JRadioButton("Blue"); //Create new buttons
		r.setSelected(true); //Red is default selected
		group.add(r); group.add(g); group.add(b); //ADD ME
		JRadioListener jrlistener = new JRadioListener(); //Create new listener for buttons
		r.addActionListener(jrlistener); g.addActionListener(jrlistener); b.addActionListener(jrlistener); //ADD ME
		panel1.add(r); panel1.add(g); panel1.add(b); //ADD ME
		b.setPreferredSize(new Dimension(100, 150)); //This is good size

		comboBox1 = new JComboBox(); //Create new comoboBox
		comboBox1.addItem("Calvin"); 
		comboBox1.addItem("Forest Gump");
		comboBox1.addItem("South Park");
		comboBox1.addItem("Star Wars");
		comboBox1.addItem("Futurama");
		comboBox1.addItem("Albert Einstein");
		ComboBoxListener cblistener = new ComboBoxListener(); //New listener for ComoboBox
		comboBox1.addActionListener(cblistener); //ADD ME
		panel1.add(comboBox1); //ADD ME
 
		slider2 = new JSlider(16, 24, 16); //new JSlider
    	slider2.setMajorTickSpacing(2); //Per 2
    	slider2.setPaintTicks(true); //Draw the ticks
    	slider2.setPaintLabels(true); //Draw the labels
    	slider2.setSnapToTicks(true); //Make them snap
    	JSliderListener jlistener = new JSliderListener();
    	slider2.addChangeListener(jlistener);
    	panel1.add(slider2);
    	slider2.setPreferredSize(new Dimension(300, 80));

    	jl = new JLabel("Hello."); //New JLabel
    	jl.setFont(new Font("Helvetica", Font.PLAIN, 16)); //Font
    	jl.setForeground(Color.red);
    	jl.setBackground(Color.white);
        panel2.add(jl); //ADD ME

		panel1.revalidate(); //Prevents blank panel
        panel2.revalidate(); //More prevention
	}

	class JButtonListener implements ActionListener { //ACtion for JButton to get a new quote
		public void actionPerformed(ActionEvent e) {
			long startTime = System.nanoTime();
			try {ReadURL();} catch (Exception f) {} //Get the actual quote
			long endTime = System.nanoTime();
			long d = endTime - startTime;
			duration = (double)d /1000000000.0;
			jl2.setText("It took " + duration + " seconds to retreive the API");
		} //end actionPerformed
	} //end ActionListerne

	class JRadioListener implements ActionListener { //Setting font colors
		public void actionPerformed(ActionEvent e) {
			if (r.isSelected()) { jl.setForeground(Color.red); } //Red
			if (g.isSelected()) { jl.setForeground(Color.green);} //Green
			if (b.isSelected()) { jl.setForeground(Color.blue);} //Blu
		} //end actionPerformed
	} //end ActionListerne

	class JSliderListener implements ChangeListener { //Setting font size
		public void stateChanged(ChangeEvent e) {
			int slide = slider2.getValue();
			switch (slide) { //switch for font size
				case 16: jl.setFont(new Font("Helvetica", Font.PLAIN, 16)); break;
				case 18: jl.setFont(new Font("Helvetica", Font.PLAIN, 18)); break;
				case 20: jl.setFont(new Font("Helvetica", Font.PLAIN, 20)); break;
				case 22: jl.setFont(new Font("Helvetica", Font.PLAIN, 22)); break;
				case 24: jl.setFont(new Font("Helvetica", Font.PLAIN, 24)); break;
			}
		} //end actionPerformed
	} //end ActionListerne

	class ComboBoxListener implements ActionListener { //Get what catagory the user wants
		public void actionPerformed(ActionEvent e) {
			int cmd = comboBox1.getSelectedIndex();
			switch (cmd) {case 0: cat = 0; break; case 1: cat = 1; break; case 2: cat = 2; break; case 3: cat = 3; break; case 4: cat = 4; break; case 5: cat = 5; break;
			}
		}
	}

	public void ReadURL() throws Exception {
		switch (cat) { //Get from above, what catagory
			case 0: text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=calvin"); break;
			case 1:	text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=forrestgump"); break;
			case 2: text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=south_park"); break;
			case 3:	text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=starwars"); break;
			case 4:	text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=futurama"); break;
			case 5: text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=albert_einstein"); break;
		}
        in = new BufferedReader(new InputStreamReader(text.openStream())); //Open what we just draw from the internet
        ReadBigStringIn(); //Read what we draw and turn in into a string
        in.close();
		jl.setText("<html><div style=width:300px><p>" + inputLine + "</p></div></html>"); //Set it in the quote bar
	} //end ReadURL

	public String ReadBigStringIn() throws IOException { //Read our txt int a string
		String line;
		StringBuilder everything = new StringBuilder();
	    while( (line = in.readLine()) != null) { everything.append(line); }
	    inputLine = everything.toString();
	    return everything.toString();
	}
}	// end class Quote