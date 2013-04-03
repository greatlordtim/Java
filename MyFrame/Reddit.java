// Author: Jimmy Liu
// March 29, 2013
// MyFrame.java
// Get Reddit Karma

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.util.regex.Pattern;

public class Reddit {
	private MyColorPanel colors;
	private MyButtonPanel buttons;
	private JFrame frame;
	JButton jb;
	String username, inputLine, karma, karma2;
	BufferedReader in;
	JLabel sentence;
	URL text, image;
	int z = 0;
	String[][] content = new String[4][100];
	public CardLayout cards;
	
	public static void main (String[] args) {
		Reddit gpa = new Reddit();
		gpa.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame("Java Reddit Reader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		// Create the colors panel and buttons panel
		colors = new MyColorPanel();
		buttons = new MyButtonPanel();
		buttons.setBackground(Color.gray);
		
		// add the JPanels to the frame
		frame.getContentPane().add(colors, BorderLayout.CENTER);
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);

		// make the frame visible
		frame.setVisible(true);
	}
	
	class MyColorPanel extends JPanel implements MouseListener {
		private JPanel color1, color2, color3;

		
		public MyColorPanel() {	

			cards = new CardLayout();
			this.setLayout(cards);
			color1 = new JPanel();
			color1.setBackground(Color.blue);
			color2 = new JPanel();
			color2.setBackground(Color.green);
			color3 = new JPanel();
			color3.setBackground(Color.red);

			JLabel jl = new JLabel("What's hot on Reddit r/aww?\n");
			jl.setFont(new Font("Helvetica", Font.PLAIN, 22));
			jl.setForeground(Color.white);
			color1.add(jl);

			color1.addMouseListener(this);
			this.add(color1, "Panel 1");

			color2.addMouseListener(this);
			this.add(color2, "Panel 2");

			color3.addMouseListener(this);
			this.add(color3, "Panel 3");
			getContent();

			JBListener jblistener = new JBListener();
			for (int p = 0; p < 15; p++) {
				JLabel jl1 = new JLabel("<html><div style=width:350px><p>" + "--> " + content[0][p] + "   [Score: " + content[1][p]+ "]" + "\n</p></div></html>");
				jl1.setForeground(Color.white);
				color1.add(jl1);
				jb = new JButton("View");
				jb.addActionListener(jblistener);
				color1.add(jb);
			}

		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }

		public void getContent() {
			try {text = new URL("http://www.reddit.com/r/aww/.json");}  catch (Exception f) {}
			try {in = new BufferedReader(new InputStreamReader(text.openStream())); } catch (Exception f) {}
        	ReadBigStringIn();
        	try {in.close();} catch (Exception f) {}

			// parse JSON "title"
			for (int i = -1; (i = inputLine.indexOf("\"title\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf("\", \"", i);
			    System.out.println(inputLine.substring(i+10, a));
			    content[0][z] = inputLine.substring(i+10, a);
			    z++;
			} //end "title" parse

			z = 0;

			// parse JSON "score"
			for (int i = -1; (i = inputLine.indexOf("\"score\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    System.out.println(inputLine.substring(i+9, a));
			    content[1][z] = inputLine.substring(i+9, a);
			    z++;
			} //end "score" parse

			z = 0;

			for (int i = -1; (i = inputLine.indexOf("\"url\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    System.out.println(inputLine.substring(i+8, a));
			    content[2][z] = inputLine.substring(i+8, a);
			    z++;
			} //end "score" parse

		}

		public String ReadBigStringIn() { //Read our txt int a string
			String line;
			StringBuilder everything = new StringBuilder();
		    try {while( (line = in.readLine()) != null) { everything.append(line); }} catch (Exception f) {}
		    inputLine = everything.toString();
		    return everything.toString();
		}	

		public void paintComponent ( Graphics g ) {

		}


	} //end panel

	class JBListener implements ActionListener { //Action for viewing a picture
			public void actionPerformed(ActionEvent e) {
				try {image = new URL(content[2][0]);} catch (Exception z) {}
			}
	}
	
	class MyButtonPanel extends JPanel implements ActionListener {
		private JButton lang1, lang2, lang3;
		private JTextField langField;
		
		public MyButtonPanel() {
			this.setLayout(new GridLayout(1, 1));
			JLabel name = new JLabel("Created by Jimmy Liu. Powered by Reddit API.");
			this.add(name);
		}

		
		public void actionPerformed (ActionEvent a) {
			}
		}
}