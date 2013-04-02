// Author: Jimmy Liu
// March 29, 2013
// MyFrame.java
// Stuff

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class MyFrame {
	private MyColorPanel colors;
	private MyButtonPanel buttons;
	private JFrame frame;
	JTextField jt;
	String username, inputLine;
	BufferedReader in;
	JLabel sentence;
	URL text;
	public CardLayout cards;
	
	public static void main (String[] args) {
		MyFrame gpa = new MyFrame();
		gpa.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

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
		//////////////////////////////////////////////////////////
		// Declare CardLayout and JPanel objects
		private JPanel color1, color2, color3;

		
		public MyColorPanel() {			// constructor
			////////////////////////////////////////////////////////
			// Initialize CardLayout and setLayout() to this panel
			cards = new CardLayout();
			this.setLayout(cards);

			////////////////////////////////////////////////////////
			// Create blue, green and red JPanels and set their backgrounds
			color1 = new JPanel();
			color1.setBackground(Color.blue);
			color2 = new JPanel();
			color2.setBackground(Color.green);
			color3 = new JPanel();
			color3.setBackground(Color.red);

			JLabel jl = new JLabel("How much Reddit karma do you have?");
			jl.setFont(new Font("Helvetica", Font.PLAIN, 18));
			jl.setForeground(Color.white);
			color1.add(jl);

		 	jt = new JTextField("Enter your username");
			color1.add(jt);

			JButton jb = new JButton("Check now");
			color1.add(jb);
			JBListener jblistener = new JBListener();
			jb.addActionListener(jblistener);

			sentence = new JLabel("");
			color2.add(sentence);

			////////////////////////////////////////////////////////
			// Add the MouseListener to *each* JPanel and add
			// each JPanel to MyColorPanel (this)
			color1.addMouseListener(this);
			this.add(color1, "Panel 1");

			color2.addMouseListener(this);
			this.add(color2, "Panel 2");

			color3.addMouseListener(this);
			this.add(color3, "Panel 3");

		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
	}
	
	class MyButtonPanel extends JPanel implements ActionListener {
		private JButton lang1, lang2, lang3;
		private JTextField langField;
		private String[] languages = { "English", "French", "German" };
		
		public MyButtonPanel() {
			////////////////////////////////////////////////////////
			// Change FlowLayout (default) to GridLayout
			// with 1 row and 4 columns.
			this.setLayout(new GridLayout(1, 4));
					
			lang1 = new JButton (languages[0]);
			lang1.addActionListener(this); 		
			this.add(lang1);
			lang2 = new JButton (languages[1]);
			lang2.addActionListener(this); 		
			this.add(lang2);
			lang3 = new JButton (languages[2]);
			lang3.addActionListener(this); 		
			this.add(lang3);
			langField = new JTextField(languages[0], 9);
			this.add(langField);
		}

		
		public void actionPerformed (ActionEvent a) {
			String command = a.getActionCommand();
			for (int i=0; i < 3; i++)
				if (command.equals(languages[i])) langField.setText(languages[i]);
		}
	}

	class JBListener implements ActionListener { //ACtion for JButton to get a new quote
			public void actionPerformed(ActionEvent e) {
					String search1 = "link_karma"; String search2 = "comment_karma";
					username = jt.getText();
					try {text = new URL("http://www.reddit.com/user/" + username + "/about.json");}  catch (Exception f) {}
					try {in = new BufferedReader(new InputStreamReader(text.openStream())); } catch (Exception f) {}
        			ReadBigStringIn(); 
        			System.out.println(inputLine);
        			try {in.close();} catch (Exception f) {}
        			cards.next(colors);
        			int t = inputLine.indexOf(search1);
        			int j = inputLine.indexOf(search2);
        			String karma = inputLine.substring(t + 13, t + 14);
        			String karma2 = inputLine.substring(j + 16, j + 18);
        			sentence.setText("Hey " + username + " looks like you have " + karma + " link karma and " + karma2 + " comment karma.");
        }
	}

	public String ReadBigStringIn() { //Read our txt int a string
		String line;
		StringBuilder everything = new StringBuilder();
	    try {while( (line = in.readLine()) != null) { everything.append(line); }} catch (Exception f) {}
	    inputLine = everything.toString();
	    return everything.toString();
	}
}