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

public class Reddit {
	private MyColorPanel colors;
	private MyButtonPanel buttons;
	private JFrame frame;
	JTextField jt;
	String username, inputLine, karma, karma2;
	BufferedReader in;
	JLabel sentence;
	URL text;
	public CardLayout cards;
	
	public static void main (String[] args) {
		Reddit gpa = new Reddit();
		gpa.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame("Reddit Karma Checker");
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
	
	class MyColorPanel extends JPanel {
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

			JLabel jl = new JLabel("How much Reddit karma do you have?");
			jl.setFont(new Font("Helvetica", Font.PLAIN, 22));
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

	class JBListener implements ActionListener { //ACtion for JButton to get a new quote
			public void actionPerformed(ActionEvent e) {
					
        }
	}

}