// Jimmy Liu
// March 23, 2013
// Quote.java
// Display quotes

// Class Methods

// Class Variables

// API Usage (Ilovequotes):
// format: return the result 'text', 'html', or 'json' format. The default is text.
// max_lines: maximum number of lines in the quote.
// min_lines: minimum number of lines in the quote.
// max_characters: maximum number of characters in the quote.
// min_characters: minimum number of characters in the quote.
// source: pulls quotes from one of the sources listed. Multiple sources should be space or "+" separated, ex: calvin+xfiles
// show_permalink: show the quote's permalink at the bottom of the text by default. Turn this off with "false" or "0".
// show_source: show the quote's source at the bottom of the text by default. Turn this off with "false" or "0".

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Quote {
	JFrame frame; JPanel panel1, panel2; JSlider slider2; JLabel jl; JComboBox comboBox1; ButtonGroup group; JRadioButton r, g, b;
	String inputLine;
	BufferedReader in;
	URL text;
	int cat = 0;
	
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
		panel2.setBackground(Color.lightGray);
		frame.add(panel1);
		frame.add(panel2);

						
		JButton jb = new JButton("PRESS FOR A RANDOM QUOTE");
		jb.setFont(new Font("Helvetica", Font.BOLD, 20));
		JButtonListener jblistener = new JButtonListener();
		jb.addActionListener(jblistener);
		panel1.add(jb);

		group = new ButtonGroup();
		r = new JRadioButton("Red");
		g = new JRadioButton("Green");
		b = new JRadioButton("Blue");
		r.setSelected(true);
		group.add(r);
		group.add(g);
		group.add(b);
		JRadioListener jrlistener = new JRadioListener();
		r.addActionListener(jrlistener);
		g.addActionListener(jrlistener);
		b.addActionListener(jrlistener);
		panel1.add(r);
		panel1.add(g);
		panel1.add(b);

		slider2 = new JSlider(16, 24, 16);
    	slider2.setMajorTickSpacing(2);
    	slider2.setPaintTicks(true);
    	slider2.setPaintLabels(true);
    	slider2.setSnapToTicks(true);
    	JSliderListener jlistener = new JSliderListener();
    	slider2.addChangeListener(jlistener);
    	panel1.add(slider2);

    	comboBox1 = new JComboBox();
		comboBox1.addItem("Calvin");
		comboBox1.addItem("Forest Gump");
		comboBox1.addItem("South Park");
		comboBox1.addItem("Star Wars");
		comboBox1.addItem("Futurama");
		comboBox1.addItem("Albert Einstein");
		ComboBoxListener cblistener = new ComboBoxListener();
		comboBox1.addActionListener(cblistener);
		panel1.add(comboBox1);

    	jl = new JLabel("Hello.");
    	jl.setFont(new Font("Helvetica", Font.PLAIN, 16));
    	jl.setForeground(Color.red);
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
			if (r.isSelected()) { jl.setForeground(Color.red); }
			if (g.isSelected()) { jl.setForeground(Color.green);}
			if (b.isSelected()) {jl.setForeground(Color.blue);}
		} //end actionPerformed
	} //end ActionListerne

	class JSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int slide = slider2.getValue();
			switch (slide) {
				case 16: jl.setFont(new Font("Helvetica", Font.PLAIN, 16)); break;
				case 18: jl.setFont(new Font("Helvetica", Font.PLAIN, 18)); break;
				case 20: jl.setFont(new Font("Helvetica", Font.PLAIN, 20)); break;
				case 22: jl.setFont(new Font("Helvetica", Font.PLAIN, 22)); break;
				case 24: jl.setFont(new Font("Helvetica", Font.PLAIN, 24)); break;
			}
		} //end actionPerformed
	} //end ActionListerne

	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int cmd = comboBox1.getSelectedIndex();
			switch (cmd) {case 0: cat = 0; break; case 1: cat = 1; break; case 2: cat = 2; break; case 3: cat = 3; break; case 4: cat = 4; break; case 5: cat = 5; break;
			}
		}
	}

	public void ReadURL() throws Exception {
		switch (cat) {
			case 0: text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=calvin"); break;
			case 1:	text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=forrestgump"); break;
			case 2: text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=south_park"); break;
			case 3:	text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=starwars"); break;
			case 4:	text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=futurama"); break;
			case 5: text = new URL("http://www.iheartquotes.com/api/v1/random?show_permalink=false&show_source=false&max_lines=3&source=albert_einstein"); break;
		}
        in = new BufferedReader(new InputStreamReader(text.openStream()));
        ReadBigStringIn();
        in.close();
		jl.setText("<html><div style=width:300px><p>" + inputLine + "</p></div></html>");
       // jl.setText(inputLine);

    } //end ReadURL

	public String ReadBigStringIn() throws IOException {
		String line;
		StringBuilder everything = new StringBuilder();
	    while( (line = in.readLine()) != null) { everything.append(line); }
	    inputLine = everything.toString();
	    return everything.toString();
	}
		
}	// end class ComponentExample