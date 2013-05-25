import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.Scanner;


public class Final {
	private MyColorPanel colors; private MyHelloPanel hello; private MyKnowledgePanel knowledge; private MyUpgradePanel upgrade;
	private JFrame frame; //JFrame
	String inputLine; //JSON is here
	BufferedReader in;
	File newscore;
	PrintWriter out;
	
	int z, bulletx, random;
	int q = 0;
	int testint = 0;
	int level = 1;
	int player = 0;
	int oldscore;
	int cardlocation = 0;
	int set = 415;
	int bulletlocation = 14;
	int droplocation = 8;
	int score = 0;
	int dropspeed = 50;
	int randspeed = 750;
	int lives = 1;
	int resetlives = 1;

	boolean gameover = false;
	boolean read = true;
	boolean bulletupgrade = false;

	Color transparent;
	ButtonGroup answers;
	JRadioButton one, two, three, four;
	JButton jb, go;
	JLabel jl1, nope, question, questionscore;
	URL search;
	URL card;
	JPanel searchvocab, titlemenu, color2;
	JTextField jtf;
	Timer bullet, drop, rand, levelup;
	String token = new String("528uWf4NCb"); //Quizlet API Key
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
		upgrade = new MyUpgradePanel();
		
		// add the JPanels to the frame
		cards = new CardLayout();
		frame.setLayout(cards);
		frame.setFocusable(true);

		frame.getContentPane().add(colors, "Panel 1"); //GETTING CARDS
		frame.getContentPane().add(hello, "Panel 2"); //GAME
		frame.getContentPane().add(upgrade, "Panel 3");
		frame.getContentPane().add(knowledge, "Panel 4"); //CARDS

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
			spaceevaders.setAlignmentX(Component.CENTER_ALIGNMENT);
			spaceevaders.setFont(new Font("Helvetica", Font.BOLD, 30));
			spaceevaders.setForeground(Color.white);
			titlemenu.add(spaceevaders);

			JButton play = new JButton("Play");
			play.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					menu.next(colors);
				}
			});
			play.setAlignmentX(Component.CENTER_ALIGNMENT);
			JButton skip = new JButton("Skip");
			skip.setAlignmentX(Component.CENTER_ALIGNMENT);
			skip.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					cards.next(frame.getContentPane());
				}
			});

			titlemenu.add(play); titlemenu.add(skip);

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
			    z++;
			} //end "search" parse

			z= 0;
			for (int i = -1; (i = inputLine.indexOf("\"title\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    searchresults[1][z] = inputLine.substring(i + 10, a -1);
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
			    z++;
			} //end "definition" parse
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
				try {alien = ImageIO.read(new File("alien.png"));} catch (IOException ex) {System.out.println("Image error");}
            	try {ship = ImageIO.read(new File("ship.png"));} catch (IOException ex) {System.out.println("Image error");} 
            	try {ammo = ImageIO.read(new File("ammo.png"));} catch (IOException ex) {System.out.println("Image error");} 
            	try {background = ImageIO.read(new File("background.png"));} catch (IOException ex) {System.out.println("Image error");}
            	newscore = new File("highscore.json");
            	transparent = new Color(0, true);
				this.setBackground(transparent);
				frame.addKeyListener(this);
				Shoot shoot = new Shoot();
				bullet = new Timer(35, shoot);
				Enemy enemy = new Enemy();
				drop = new Timer(dropspeed, enemy);
				Ran ran = new Ran();
				rand = new Timer(randspeed, ran);
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
				highscore();
				super.paintComponent(g);
	            g.setColor(Color.white);
	            location[player][15] = 2;
	  

				g.drawImage(background,0,0,getSize().width,getSize().height,this);
				for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 16; j++) {

                    	int a = location[i][j];
                    	if (a == 0) {
                    		g.setColor(transparent);
                    		g.fillRect(i * 100, j * 37+15, 5, 5);
                    	}
                    	if (a == 1) {
                    		g.setColor(Color.white);
                    		g.drawImage(alien, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 2) {
                    		g.setColor(Color.green);
                    		g.drawImage(ship, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 3) {
                    		g.setColor(Color.green);
                    		g.fillRect((i * 100) + 30, j * 37+15, 5, 15);
                    	}
                    	if (a == 4) {
                    		g.drawImage(ammo, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 5) {
                    		g.setColor(Color.green);
                    		g.drawImage(ship, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 6) {
                    		g.setColor(transparent);
                    		g.fillRect(i * 100, j * 37+15, 5, 5);
                    	}

					}
                } //end for statement
                g.setColor(Color.white);
                g.drawString("Score: " + score, 30, 610);
                if (score > oldscore)
                g.drawString("High Score: " + score, 120, 610);
            	else 
            	g.drawString("High Score: " + oldscore, 120, 610);
           		g.drawString("Lives: " + lives, 630, 610);
                g.drawString("Level: " + level, 710, 610);

                gameover = true;
                for (int j = 0; j < 8; j++) {
                	if (location[j][0] == 1) {
                		gameover = false;
                	}
                }

                if (gameover == true) {
                	bulletlocation = 14;
					droplocation = 8;
                	location[0][0] = 6;
                	bullet.stop();
                	drop.stop();
                	rand.stop();
                	g.setFont(new Font("Helvetica", Font.BOLD, 35));
                	g.drawString("YOU WIN :D", 150, 500);
				    cards.next(frame.getContentPane());
				}

        	} //end paintComponennt

        	private class Shoot implements ActionListener {
            	public void actionPerformed(ActionEvent e) {

	            		if (location[bulletx][bulletlocation - 1] == 1) {
	            			if (bulletupgrade == false) {
		            			location[bulletx][bulletlocation - 1] = 0;
		            			location[bulletx][bulletlocation] = 0; 
		            			score = score + 10;
		            		}
	            			else {
	            				location[bulletx][bulletlocation - 1] = 0;
	            				location[bulletx][bulletlocation - 2] = 0;
	            				location[bulletx][bulletlocation] = 0;
	            				score = score + 20;
	            			}
	            			bullet.stop();
	            			bulletlocation = 14;
	            			highscore();
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
            			lives--;
            			if (lives == 0) {
	            			cards.last(frame.getContentPane());
	            			drop.stop();
	            			rand.stop();
	            			lives = 1;
            			}
            			else {}
            		}
            		location[random][droplocation] = 4;
            		if (droplocation == 15) {
            			drop.stop();
            			location[random][droplocation] = 0;
            		}
            		repaint();
            	}
            }

            public void newlevel() {
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
                	level = level + 1;
                	dropspeed = dropspeed -5;
                	randspeed = randspeed - 75;
                	if (dropspeed == 0)
                	dropspeed = 10;
                	if (randspeed == 50) 
                	randspeed = 500;
                	drop.setDelay(dropspeed);
                	rand.setDelay(randspeed);
                	bullet.start();
                	rand.start();
                	repaint();
            }


            public void highscore() {

            	if (read == true) {
			        try {
						Scanner in = new Scanner(newscore);
						oldscore = in.nextInt();
					} catch (FileNotFoundException e) {}
					read = false;
				}

				if (score > oldscore) {
					try {
						out = new PrintWriter(newscore);
					} catch (IOException e) {System.out.println("hi");}
					out.print(score);
					out.close();
				}

            }

        	public void keyPressed(KeyEvent e) {}

        	public void keyReleased(KeyEvent e) {} 

        	public void keyTyped(KeyEvent e) {
	        	char c = e.getKeyChar();
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
	        		if (bullet.isRunning()) {}
	        		else {
	        		location[player][14] = 3;
	        		bulletx = player;
	        		bullet.start();
	        		}
	        	}
	        	if (c == '1') {
	        		lives++;
	        	}
	        	repaint();
        	}

	} //end MyHelloPanel

	class MyUpgradePanel extends JPanel {
		public MyUpgradePanel() {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JLabel titletext = new JLabel("Choose your upgrade");
			JButton speed = new JButton("Speed");
			JButton bullet1 = new JButton("Bullet");
			JButton life = new JButton("lives");
			speed.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					bullet.setDelay(15);
					cards.previous(frame.getContentPane());
					hello.newlevel();
				}
			});
			bullet1.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					bulletupgrade = true;
					cards.previous(frame.getContentPane());
					hello.newlevel();
				}
			});
			life.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					resetlives++;
					lives = resetlives;
					cards.previous(frame.getContentPane());
					hello.newlevel();
				}
			});
			this.add(titletext); this.add(speed); this.add(life); this.add(bullet1);
		}
	}

	class MyKnowledgePanel extends JPanel {

		public MyKnowledgePanel() {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
			questionscore = new JLabel("Score: " + score);
			this.add(questionscore);

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
					score = score + 50;
					lives = resetlives;
				}
				else {nope.setText("Wrong Answer"); score = score - 20; questionscore = new JLabel("Score: " + score);}
			}
			if (two.isSelected()) {
				if (two.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start();
					score = score + 50;
					lives = resetlives;
				}
				else {nope.setText("Wrong Answer"); score = score - 20; questionscore = new JLabel("Score: " + score);}
			}
			if (three.isSelected()) {
				if (three.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start(); 
					score = score + 50;
					lives = resetlives;
				}
				else {nope.setText("Wrong Answer"); score = score - 20; questionscore = new JLabel("Score: " + score);}
			}
			if (four.isSelected()) {
				if (four.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.previous(frame.getContentPane());
					rand.start(); 
					score = score + 50;
					lives = resetlives;
				}
				else {nope.setText("Wrong Answer"); score = score - 20; questionscore = new JLabel("Score: " + score);}
			}
		}  //end CheckAnsswers

	} //end MyKnowledgePanel

} //end program