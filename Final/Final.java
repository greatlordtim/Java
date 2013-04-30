import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.imageio.*;
import java.awt.image.*;

public class Final {
	private MyColorPanel colors; //Panel 1
	private MyHelloPanel hello;
	private JFrame frame; //JFrame
	String inputLine; //JSON is here
	BufferedReader in;
	int z;
	JLabel jl1;
	JButton jb;
	URL search; //URL of 
	URL card;
	int q = 0;
	int player = 0;
	JPanel searchvocab, titlemenu, color2;
	JTextField jtf;
	String token = new String("528uWf4NCb");
	int set = 415;
	String[][] searchresults = new String[2][300];
	String[][] flashcards = new String[2][300];
	int location[][] = new int[8][16];
	public CardLayout cards, menu; //Card Layout

	
	public static void main (String[] args) {
		Final space = new Final();
		space.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame("Space Evaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		// Create the colors panel and buttons panel
		colors = new MyColorPanel();
		hello = new MyHelloPanel();
		
		// add the JPanels to the frame
		cards = new CardLayout();
		frame.setLayout(cards);
		frame.setFocusable(true);

		frame.getContentPane().add(colors, "Panel 1"); //Define Frame location of colors
		frame.getContentPane().add(hello, "Panel 1");

		// make the frame visible
		frame.setVisible(true);

	}
	
	class MyColorPanel extends JPanel implements MouseListener {

		public MyColorPanel() {
			menu = new CardLayout();
			this.setLayout(menu);

			titlemenu = new JPanel();
			titlemenu.setLayout(new BoxLayout(titlemenu, BoxLayout.Y_AXIS));
			searchvocab = new JPanel();

			titlemenu.setBackground(Color.black);
			searchvocab.setBackground(Color.blue); 
			searchvocab.addMouseListener(this);

			this.add(titlemenu, "Panel 1");
			this.add(searchvocab, "Panel 2");

			JLabel spaceevaders = new JLabel("Space Evaders");
			spaceevaders.setForeground(Color.white);
			titlemenu.add(spaceevaders);

			JButton play = new JButton("Play");
			play.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					menu.next(colors);
				}
			});

			JButton settings = new JButton("Settings");
			JButton skip = new JButton("Skip");
			skip.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					cards.next(frame.getContentPane());
				}
			});

			titlemenu.add(play); titlemenu.add(settings); titlemenu.add(skip);

			jtf =  new JTextField("Subject or Title or Set ID(i.e. Java Facts)", 30);
			searchvocab.add(jtf);

			JButton jb1 = new JButton("Search Quizlet");
			searchvocab.add(jb1);
			jb1.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent ae2) {
        					getSearch();
        					for (int p = 0; p < 15; p++) { //While array has stuff, print it out
								jl1 = new JLabel("<html><div style=width:350px><p>" + "--> " + searchresults[1][p] + "\n</p></div></html>");
								jl1.setForeground(Color.white);
								searchvocab.add(jl1);
								jb = new JButton("Use Set");
								final int buttonIndex = p; //Button Index is pretty awesome

								jb.addActionListener(new ActionListener() { //Mad science here
										public void actionPerformed(ActionEvent ae2) {
											set = Integer.parseInt(searchresults[0][buttonIndex]);
				        					getCards();
				        					cards.next(frame.getContentPane());

				        				}
				    			}); //end action listener
								searchvocab.add(jb);
							} //end for statement
							revalidate();
					}
    			}); //end action listener
			}

		//Nothing to do here
		public void mousePressed(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) {}
		public void mouseExited(MouseEvent evt) {}
		public void mouseClicked(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {}

		public void getSearch() {
			try {search = new URL("https://api.quizlet.com/2.0/search/sets?client_id=" + token + "&whitespace=1&q=" + jtf.getText());}  catch (Exception f) {}
			try {in = new BufferedReader(new InputStreamReader(search.openStream())); } catch (Exception f) {}
        	ReadBigStringIn();
        	try {in.close();} catch (Exception f) {}
        	q++;

        	z = 0;
			//parse JSON "seach"
			for (int i = -1; (i = inputLine.indexOf("\"id\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    searchresults[0][z] = inputLine.substring(i + 6, a);
			    System.out.println(searchresults[0][z]);
			    z++;
			} //end "search" parse

			z= 0;
			for (int i = -1; (i = inputLine.indexOf("\"title\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    searchresults[1][z] = inputLine.substring(i + 10, a -1);
			    System.out.println(searchresults[1][z]);
			    z++;
			} //end "search" parse

		} //end get content

		public void getCards() {
			try {card = new URL("https://api.quizlet.com/2.0/sets/" + set + "?client_id=" + token + "&whitespace=1");}  catch (Exception f) {}
			try {in = new BufferedReader(new InputStreamReader(card.openStream())); } catch (Exception f) {}
        	ReadBigStringIn();
        	try {in.close();} catch (Exception f) {}

        	z = 0;
			//parse JSON "term"
			for (int i = -1; (i = inputLine.indexOf("\"term\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf("\",", i);
			    flashcards[0][z] = inputLine.substring(i + 9, a);
			    z++;
			} //end "term" parse

			z = 0;
			//parse JSON "definintion"
			for (int i = -1; (i = inputLine.indexOf("\"definition\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf("\",", i);
			    flashcards[1][z] = inputLine.substring(i + 15, a);

			    System.out.println(flashcards[0][z]);
				System.out.println(flashcards[1][z]);
				System.out.println();
			    z++;
			} //end "definition" parse

			System.out.println("--END OF SET--");
		} //end get content

		public String ReadBigStringIn() { //Read our txt int a string
			String line;
			StringBuilder everything = new StringBuilder();
		    try {while( (line = in.readLine()) != null) { everything.append(line); }} catch (Exception f) {}
		    inputLine = everything.toString();
		    return everything.toString();
		} //end ReadBigStringIn

	} //end MyColorPanel



	class MyHelloPanel extends JPanel implements KeyListener{

			public MyHelloPanel() {
				this.setBackground(Color.black); 
				frame.addKeyListener(this);

				for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 16; j++) {
                		location[i][j] = 0;
                	}	
                } //end for

               	for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 8; j++) {
                		location[i][j] = 1;
                	}	
                } //end for

			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
	            g.setColor(Color.white);
	            location[player][15] = 2;
	            //STUFF HERE

				for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 16; j++) {

                    	int a = location[i][j];
                    	if (a == 0) {
                    		g.setColor(Color.black);
                    		g.fillRect(i * 75, j * 37, 5, 5);
                    	}
                    	if (a == 1) {
                    		g.setColor(Color.white);
                    		g.fillRect(i * 75, j * 37, 5, 5);
                    	}
                    	if (a == 2) {
                    		g.setColor(Color.green);
                    		g.fillRect(i * 75, j * 37, 5, 5);
                    	}


                    }
                } //end for statement

        	} //end paintComponennt

        	public void keyPressed(KeyEvent e) {}

        	public void keyReleased(KeyEvent e) {} 

        	public void keyTyped(KeyEvent e) {
	        	char c = e.getKeyChar();
	        	System.out.println(c);
	        	if (c == 'a') {
	        		location[player][15] = 0;
	        		player--;
	        	}
	        	if (c == 'd') {
	        		location[player][15] = 0;
	        		player++;
	        	}
	        	repaint();
        	}

	} //end MyHelloPanel

} //end program