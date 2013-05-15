import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.image.*;

public class Final {
	private MyColorPanel colors; private MyHelloPanel hello; private MyKnowledgePanel knowledge;
	private JFrame frame; //JFrame
	String inputLine; //JSON is here
	BufferedReader in;
	
	int z, bulletx, random;
	int q = 0;
	int player = 0;
	int cardlocation = 0;
	int set = 415;
	int bulletlocation = 14;
	int droplocation = 8;
	int score = 0;
	Color transparent;
	ButtonGroup answers;
	JRadioButton one, two, three, four;
	JButton jb, go;
	JLabel jl1, nope, question;
	URL search; //URL of 
	URL card;
	JPanel searchvocab, titlemenu, color2;
	JTextField jtf;
	Timer bullet, drop, rand;
	String token = new String("528uWf4NCb");
	String[][] searchresults = new String[2][300];
	String[][] flashcards = new String[2][300];
	int location[][] = new int[8][16];
	public CardLayout cards, menu;

	public static void main (String[] args) {
		Final space = new Final();
		space.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame("Space Evaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 650);

		// Create the colors panel and buttons panel
		colors = new MyColorPanel();
		hello = new MyHelloPanel();
		knowledge = new MyKnowledgePanel();
		
		// add the JPanels to the frame
		cards = new CardLayout();
		frame.setLayout(cards);
		frame.setFocusable(true);

		frame.getContentPane().add(colors, "Panel 1"); //GETTING CARDS
		frame.getContentPane().add(hello, "Panel 2"); //GAME
		frame.getContentPane().add(knowledge, "Panel 3"); //CARDS

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
				        					knowledge.fillCards();
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

			public BufferedImage alien, ship, ammo, background;

			public MyHelloPanel() {
				try {alien = ImageIO.read(new File("alien.png"));} //Get my sprite sheet
            	catch (IOException ex) {System.out.println("Image error");} //Oh noeeesss! 404!
            	try {ship = ImageIO.read(new File("ship.png"));} //Get my sprite sheet
            	catch (IOException ex) {System.out.println("Image error");} //Oh noeeesss! 404!
            	try {ammo = ImageIO.read(new File("ammo.png"));} //Get my sprite sheet
            	catch (IOException ex) {System.out.println("Image error");} //Oh noeeesss! 404!
            	try {background = ImageIO.read(new File("background.jpeg"));} //Get my sprite sheet
            	catch (IOException ex) {System.out.println("Image error");} //Oh noeeesss! 404!
            	transparent = new Color(0, true);
				this.setBackground(transparent);
				frame.addKeyListener(this);
				Shoot shoot = new Shoot();
				bullet = new Timer(35, shoot);
				Enemy enemy = new Enemy();
				drop = new Timer(50, enemy);
				Ran ran = new Ran();
				rand = new Timer(1000, ran);
				rand.start();

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
	            g.drawImage(background,0,0,getSize().width,getSize().height,this);
				for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 16; j++) {

                    	int a = location[i][j];
                    	if (a == 0) {
                    		g.setColor(transparent);
                    		g.fillRect(i * 100, j * 37, 5, 5);
                    	}
                    	if (a == 1) {
                    		g.setColor(Color.white);
                    		//g.fillRect(i * 100, j * 37, 5, 5);
                    		g.drawImage(alien, i * 100, j * 37, null);
                    	}
                    	if (a == 2) {
                    		g.setColor(Color.green);
                    		//g.fillRect(i * 100, j * 37, 5, 5);
                    		g.drawImage(ship, i * 100, j * 37, null);
                    	}
                    	if (a == 3) {
                    		g.setColor(Color.green);
                    		g.fillRect((i * 100) + 10, j * 37, 5, 15);
                    	}
                    	if (a==4) {
                    		g.setColor(Color.yellow);
                    		//g.fillRect(i * 100, j * 37, 5, 5);
                    		g.drawImage(ammo, i * 100, j * 37, null);
                    	}

					}
                } //end for statement
                g.setColor(Color.white);
                g.drawString("Score:" + score, 30, 600);

        	} //end paintComponennt

        	private class Shoot implements ActionListener {
            	public void actionPerformed(ActionEvent e) {
            		if (location[bulletx][bulletlocation - 1] == 1) {
            			location[bulletx][bulletlocation - 1] = 0;
            			location[bulletx][bulletlocation] = 0;
            			bullet.stop();
            			bulletlocation = 14;
            			score = score + 10;
            			System.out.println(score);
            		}
            		else if (bulletlocation == 1) {
            			location[bulletx][bulletlocation] = 0;
            			bulletlocation = 14;
            			bullet.stop();
            		}
            		else {
            			location[bulletx][bulletlocation] = 0;
            			bulletlocation--;
            			location[bulletx][bulletlocation] = 3;
            		}
            		repaint();
            	}
            }

            private class Ran implements ActionListener {
            	public void actionPerformed(ActionEvent e) {
            		random = 0 + (int)(Math.random() * ((7 - 0) + 1));
            		while (location[random][0] == 0) {
            			random = 0 + (int)(Math.random() * ((7 - 0) + 1));
            		}
            		for (int n = 0; n < 15; n++) {
            			if (location[random][n] == 1)
            				droplocation = n + 1;
            		}
            		location[random][droplocation] = 4;
            		drop.start();
            	}
            }

            private class Enemy implements ActionListener {
            	public void actionPerformed(ActionEvent e) {
            		location[random][droplocation] = 0;
            		droplocation++;
            		if (location[random][droplocation] == 2) {
            			cards.last(frame.getContentPane());
            			drop.stop();
            			rand.stop();
            		}
            		location[random][droplocation] = 4;
            		if (droplocation == 15) {
            			drop.stop();
            			location[random][droplocation] = 0;
            		}
            		repaint();
            	}
            }

        	public void keyPressed(KeyEvent e) {}

        	public void keyReleased(KeyEvent e) {} 

        	public void keyTyped(KeyEvent e) {
	        	char c = e.getKeyChar();
	        	System.out.println(c);
	        	if (c == 'a') {
	        		if (player == 0) {
	        			location[player][15] = 0;
	        			player = 7;
	        		}
	        		else {
	        			location[player][15] = 0;
	        			player--;
	        		}
	        	}
	        	if (c == 'd') {
	        		if (player == 7) {
	        			location[player][15] = 0;
	        			player = 0;
	        		}
	        		else {
	        			location[player][15] = 0;
	        			player++;
	        		}
	        	}
	        	if (c == 32) {
	        		if (bullet.isRunning()) {
	        			//No spamming
	        		}
	        		else {
	        		location[player][14] = 3;
	        		bulletx = player;
	        		bullet.start();
	        		}
	        	}
	        	repaint();
        	}

	} //end MyHelloPanel

	class MyKnowledgePanel extends JPanel {

		public MyKnowledgePanel() {
			question = new JLabel();
			answers = new ButtonGroup();
			one = new JRadioButton(); two = new JRadioButton(); three = new JRadioButton(); four = new JRadioButton();
			go = new JButton("Go");
			this.add(question);
			this.add(one); this.add(two); this.add(three); this.add(four);
			this.add(go);
			nope = new JLabel();
			nope.setFont(new Font("Helvetica", Font.BOLD, 35));
			this.add(nope);
			answers.add(one); answers.add(two); answers.add(three); answers.add(four);
			go.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					checkAnswer();
				}
			});
		}

		public void fillCards() {
			question.setText("<html><div style=width:350px><p>" + flashcards[0][cardlocation] + "</p></div></html>");
			int randomize = 1 + (int)(Math.random() * ((4 - 1) + 1));
			switch (randomize) {
				case 1: 
					one.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>");
					two.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 1] + "</p></div></html>");
					three.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 2] + "</p></div></html>");
					four.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 3] + "</p></div></html>");
					break;
				case 2: 
					one.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 1] + "</p></div></html>");
					two.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 3] + "</p></div></html>");
					three.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>");
					four.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 2] + "</p></div></html>");
					break;
				case 3: 
					one.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 3] + "</p></div></html>");
					two.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 2] + "</p></div></html>");
					three.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 1] + "</p></div></html>");
					four.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>");
					break;
				case 4: 
					one.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 2] + "</p></div></html>");
					two.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>");
					three.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 3] + "</p></div></html>");
					four.setText("<html><div style=width:350px><p>" + flashcards[1][cardlocation + 2] + "</p></div></html>");
					break;

			}
			nope.setText("");
		} //end filCards

		public void checkAnswer() {
			if (one.isSelected()) {
				if (one.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start(); 
				}
				else nope.setText("Wrong Answer");
			}
			if (two.isSelected()) {
				if (two.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start(); 
				}
				else nope.setText("Wrong Answer");
			}
			if (three.isSelected()) {
				if (three.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start(); 
				}
				else nope.setText("Wrong Answer");
			}
			if (four.isSelected()) {
				if (four.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start(); 
				}
				else nope.setText("Wrong Answer");
			}
		}  //end CheckAnsswers

	} //end MyKnowledgePanel

} //end program