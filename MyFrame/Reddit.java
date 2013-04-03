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
import javax.imageio.*;
import java.awt.image.*;

public class Reddit {
	private MyColorPanel colors;
	private MyButtonPanel buttons;
	private JFrame frame;
	JButton jb;
	String inputLine;
	BufferedReader in;
	JLabel sentence, imagel;
	URL text, imageurl;
	int z = 0;
	int q = 0;
	ImageIcon image2;
	BufferedImage image;
	JPanel color1, color2, color3;
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
		frame.setSize(730, 600);

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

		public MyColorPanel() {	
			if (q == 0) {
				try {image = ImageIO.read(new URL("http://placehold.it/350x150"));} catch (Exception e) {}
				image2 = new ImageIcon(image);
				System.out.println("hi");
				q++;
			}
			getContent();
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
			imagel = new JLabel(image2);
			color2.add(imagel);

			JButton jb2 = new JButton("Go Back");
			color2.add(jb2);
			JBListener2 jblistener2 = new JBListener2();
			jb2.addActionListener(jblistener2);

			color1.addMouseListener(this);
			this.add(color1, "Panel 1");

			color2.addMouseListener(this);
			this.add(color2, "Panel 2");

			color3.addMouseListener(this);
			this.add(color3, "Panel 3");

			for (int p = 0; p < 15; p++) {
				JLabel jl1 = new JLabel("<html><div style=width:350px><p>" + "--> " + content[0][p] + "   [Score: " + content[1][p]+ "]" + "\n</p></div></html>");
				jl1.setForeground(Color.white);
				color1.add(jl1);
				jb = new JButton("View");
				final int buttonIndex = p;

				jb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae2) {
								try {image = ImageIO.read(new URL(content[2][buttonIndex] + ".jpg"));} catch (Exception t) {}
								ImageIcon image2 = new ImageIcon(image.getScaledInstance(650, 500, Image.SCALE_SMOOTH));
								image2.getImage().flush();
								imagel.setIcon(image2);
								cards.next(colors);
								color2.repaint();
        				}
    			}); //end action listener

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
			    System.out.println(inputLine.substring(i+8, a-1));
			    content[2][z] = inputLine.substring(i+8, a-1);
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



	} //end MyColorPanel

	public class JBListener2 implements ActionListener { //Action for viewing a picture
			public void actionPerformed(ActionEvent e) {
				cards.previous(colors);
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