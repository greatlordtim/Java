// Author: Jimmy Liu
// March 29, 2013
// Reddit.java
// Get the latest and cutest content from Reddit r/aww.

// Class Variables
// MyFrame colors, buttons, awesome, frame: Main frames of this program. 
// JButtons, JRadioButtons, JLabels: The componenets used in this program. Including JLabel's that print out Reddit API
// String inputLine: All of the JSON
// BufferedReader: The text (JSON) we get from the Reddit API calls
// URL Text: Get's Reddit API in JSON format.
// content: Very large array that stores all of the information after we parse it from JSON.
// seconds: API call and JSON parse counter

// Class Methods
// public ColorPanel: This is the main function of the program, it adds in all of the componenets of the program, and calls
// the Reddit API fuction.
// getContent: This gets the content from Reddit. It then parses the JSON it recieves into text, and then prints it on the screen
// ReadBigString: Reads mulitiple lines of text from a URL and puts it into one big string.
// Button Listener: This listens to buttons, and displays the pictures as the button is choosen. 

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
	private MyColorPanel colors; //Panel 1
	private MyButtonPanel buttons; //Panel 2
	private MyAwesomePanel awesome; //Panel 3
	private JFrame frame; //JFrame
	JButton jb;
	JRadioButton jradio, jradio2; //RadioButtons
	JLabel jl1, jl;
	String inputLine; //JSON is here
	BufferedReader in, in2; 
	JLabel sentence, imagel; //JLabel for printing content
	URL text, imageurl; //URL of API
	int z = 0; //Random ints, do not mind
	int q = 0;
	int u = 0;
	ImageIcon image2;
	BufferedImage image;
	JPanel color1, color2, color3, color4, yolo;
	String[][] content = new String[100][300]; //Very big array for storing data 
	double seconds;
	public CardLayout cards; //Card Layout

	
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

		awesome = new MyAwesomePanel();
		colors = new MyColorPanel();
		buttons = new MyButtonPanel();
		buttons.setBackground(Color.gray); //Background color gray
		awesome.setBackground(Color.white); //Background color for awesome as white
		
		// add the JPanels to the frame

		frame.getContentPane().add(awesome, BorderLayout.NORTH); //Define Frame
		frame.getContentPane().add(colors, BorderLayout.CENTER); //Define Frame location of colors
		frame.getContentPane().add(buttons, BorderLayout.SOUTH); //Define Frame location of button

		// make the frame visible
		frame.setVisible(true);

	}
	
	class MyColorPanel extends JPanel implements MouseListener {

		public MyColorPanel() {	
			if (q == 0) {
				try {image = ImageIO.read(new URL("http://placehold.it/350x150"));} catch (Exception e) {}
				image2 = new ImageIcon(image);
				q++;
			}
			getContent();
			cards = new CardLayout();
			this.setLayout(cards);
			color1 = new JPanel();
			color1.setBackground(Color.blue); //First Background as blue
			color2 = new JPanel();
			color2.setBackground(Color.green); //Second as Red
			color3 = new JPanel();
			color3.setBackground(Color.red); //Believe it or not, this is not actually used
			color4 = new JPanel();

			jl = new JLabel("What's hot on Reddit r/aww?\n"); //Very nice title!
			jl.setFont(new Font("Helvetica", Font.PLAIN, 22)); //Helvetica is a pretty font. Plain > Bold
			jl.setForeground(Color.white); //Make the font WHITE
			color1.add(jl);
			imagel = new JLabel(image2); // Images as ImageIcon
			color2.add(imagel);

			JButton jb2 = new JButton("Go Back"); //JButton for going back to Panel1
			color2.add(jb2);
			JBListener2 jblistener2 = new JBListener2(); //Create Listener
			jb2.addActionListener(jblistener2); //Add IT

			color1.addMouseListener(this); //NOT USED
			this.add(color1, "Panel 1");

			color2.addMouseListener(this); //NOT USED
			this.add(color2, "Panel 2");

			color3.addMouseListener(this); //NOT USED
			this.add(color3, "Panel 3"); 

			JSlider myslider = new JSlider(0, 1); //Useful slider for changing font
			color1.add(myslider);
			SliderChange sliderchange = new SliderChange();
			myslider.addChangeListener(sliderchange); //Add ChangeEvent 

			ButtonGroup bg = new ButtonGroup(); //Creat ea butotn group for JRadioButton
			jradio = new JRadioButton("Helvetica"); //HELVETICA YEAH
			jradio2 = new JRadioButton("Comic Sans"); //YUCK
			bg.add(jradio); //Add these to the button group
			bg.add(jradio2);
			color1.add(jradio);
			color1.add(jradio2);
			jradio.setForeground(Color.white); //Set foreground as white
			jradio2.setForeground(Color.white);

			RadioListener rl = new RadioListener(); //Radio Listener
			jradio.addActionListener(rl);
			jradio.isSelected();
			jradio2.addActionListener(rl);

			for (int p = 0; p < 15; p++) { //While array has stuff, print it out 
				//HTML hacks for formatting = awesome
				jl1 = new JLabel("<html><div style=width:350px><p>" + "--> " + content[0][p] + "   [Author: " + content[3][p]+ "]" + "   [Score: " + content[1][p]+ "]" + "\n</p></div></html>");
				jl1.setForeground(Color.white);
				color1.add(jl1);
				jb = new JButton("View");
				final int buttonIndex = p; //Button Index is pretty awesome

				jb.addActionListener(new ActionListener() { //Mad science here
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
			} //end for statement

		}
		//Nothing to do here
		public void mousePressed(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }

		public void getContent() {
			long startTime = System.nanoTime();
			try {text = new URL("http://www.reddit.com/r/aww/.json");}  catch (Exception f) {}
			try {in = new BufferedReader(new InputStreamReader(text.openStream())); } catch (Exception f) {}
        	ReadBigStringIn();
        	try {in.close();} catch (Exception f) {}
        	System.out.println("API LOAD: COMPLETE");

			// parse JSON "title"
			for (int i = -1; (i = inputLine.indexOf("\"title\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf("\", \"", i);
			    content[0][z] = inputLine.substring(i+10, a);
			    z++;
			} //end "title" parse

			z = 0;

			// parse JSON "score"
			for (int i = -1; (i = inputLine.indexOf("\"score\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    content[1][z] = inputLine.substring(i+9, a);
			    z++;
			} //end "score" parse

			z = 0;

			for (int i = -1; (i = inputLine.indexOf("\"url\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    content[2][z] = inputLine.substring(i+8, a-1);
			    z++;
			} //end "url" parse

			z = 0;

			for (int i = -1; (i = inputLine.indexOf("\"author\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    content[3][z] = inputLine.substring(i+11, a-1);
			    z++;
			} //end "author" parse

			System.out.println("JSON PARSE: COMPLETE");
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
			seconds = (double)duration / 1000000000.0;

		} //end get content


		public String ReadBigStringIn() { //Read our txt int a string
			String line;
			StringBuilder everything = new StringBuilder();
		    try {while( (line = in.readLine()) != null) { everything.append(line); }} catch (Exception f) {}
		    inputLine = everything.toString();
		    return everything.toString();
		} //end get content	



	} //end MyColorPanel

	public class JBListener2 implements ActionListener { //Action for viewing a picture
			public void actionPerformed(ActionEvent e) {
				cards.previous(colors);
			}
	}

	public class SliderChange implements ChangeListener { //For setting background blue or black
		public void stateChanged(ChangeEvent e) {
			switch (u) {
				case 0: color1.setBackground(Color.BLACK); u = 1;break; //Blue or black
				case 1: color1.setBackground(Color.blue); u = 0;break; //Blue or black
			}
		}
	}

	public class RadioListener implements ActionListener { //Action for viewing a picture
			public void actionPerformed(ActionEvent e) {
				if (jradio.isSelected()) {
					jl.setFont(new Font("Helvetica", Font.PLAIN, 22)); //HELVETICA
				}
				if (jradio2.isSelected()) {
					jl.setFont(new Font("Serif", Font.PLAIN, 22)); //OR SERIF
				}
			}
		}
	
	class MyButtonPanel extends JPanel implements ActionListener {
		private JButton lang1, lang2, lang3;
		private JTextField langField;
		
		public MyButtonPanel() {
			this.setLayout(new GridLayout(1, 1)); //Calling API here
			JLabel name = new JLabel(" Created by Jimmy Liu. Powered by Reddit API. It took " + seconds + " seconds to call the API.");
			this.add(name);
		}

		
		public void actionPerformed (ActionEvent a) {
			}
		}

		class MyAwesomePanel extends JPanel {
		
		public MyAwesomePanel() {
			this.setLayout(null);
			this.setPreferredSize(new Dimension(20, 20));
			JLabel label4 = new JLabel("Reddit Viewer");
			this.add(label4);
			label4.setBounds(0, 0, 100, 20);
			label4.setForeground(Color.black);
			this.add(label4);
		}
	}
}