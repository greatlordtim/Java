// Jimmy Liu
// May 24th, 2013
// Final.java
// This program is a recreation of Space Invaders, named Space Evaders. You shoot aliens and answer flash card questions from Quizlet

////////////////////**WARNING**////////////////////
//**Game will not work without internet access**//
////////////////////**WARNING**///////////////////

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
	private MyColorPanel colors; private MyHelloPanel hello; private MyKnowledgePanel knowledge; private MyUpgradePanel upgrade; //All of my JPanels
	private JFrame frame; //JFrame
	String inputLine; //JSON is here
	BufferedReader in; //BufferedReader for parsing JSON
	File newscore; //File for reading I/O
	PrintWriter out; //Outputing file
	
	int z, bulletx, random, spacex; //Ints for tracking purposes
	int q = 0;
	int t = 1;
	int o = 0;
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
	int u = 1;

	boolean gameover = false; //Is the game over? Seems like it's not yet
	boolean read = true; //Read the file yet?
	boolean bulletupgrade = false; //Bullet upgrade bought yet?

	Color transparent; //Transparent colors FTW
	ButtonGroup answers; 
	JRadioButton one, two, three, four;
	JButton jb, go;
	JLabel jl1, nope, question, questionscore;
	URL search;
	URL card;
	JPanel searchvocab, titlemenu, color2;
	JTextField jtf;
	Timer bullet, drop, rand, levelup, animate, explodeme, death;
	String token = new String("528uWf4NCb"); //Quizlet API Key. Do not change.
	String[][] searchresults = new String[2][300]; //Search result array
	String[][] flashcards = new String[2][300]; //Flashcard array
	int location[][] = new int[8][16]; //Game array
	public CardLayout cards, menu; //Card layout, one for frame, one for Quizlt search

	public static void main (String[] args) {
		Final space = new Final(); 
		space.Run(); //And....run the game!
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame("Space Evaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 650); //800x650

		// Create the colors panel and buttons panel
		colors = new MyColorPanel(); //Getting Cards
		hello = new MyHelloPanel(); //The actual game
		knowledge = new MyKnowledgePanel(); //Flashcards
		upgrade = new MyUpgradePanel(); //Upgrades in the game
		
		// add the JPanels to the frame
		cards = new CardLayout();
		frame.setLayout(cards);
		frame.setFocusable(true);

		frame.getContentPane().add(colors, "Panel 1"); //GETTING CARDS
		frame.getContentPane().add(hello, "Panel 2"); //GAME
		frame.getContentPane().add(upgrade, "Panel 3"); //Upgrades in the game
		frame.getContentPane().add(knowledge, "Panel 4"); //CARDS

		// make the frame visible
		frame.setVisible(true);

	}
	
	class MyColorPanel extends JPanel implements MouseListener {

		public MyColorPanel() {
			menu = new CardLayout();
			this.setLayout(menu); //Make the menu CardLayout

			titlemenu = new JPanel();
			titlemenu.setLayout(new BoxLayout(titlemenu, BoxLayout.Y_AXIS)); //BoxLayout for the title menu
			searchvocab = new JPanel();

			titlemenu.setBackground(Color.black); //Backgrond should be black
			searchvocab.setBackground(Color.blue);  //Let's make this blue
			searchvocab.addMouseListener(this); //Add a mouse listener just because

			this.add(titlemenu, "Panel 1"); //First panel, for title menu
			this.add(searchvocab, "Panel 2"); //Second panel, for searching for vocab

			JLabel spaceevaders = new JLabel("Space Evaders"); //Title of game
			spaceevaders.setAlignmentX(Component.CENTER_ALIGNMENT); //Center that text
			spaceevaders.setFont(new Font("Helvetica", Font.BOLD, 30));
			spaceevaders.setForeground(Color.white); //White colors
			titlemenu.add(spaceevaders);

			JButton play = new JButton("Play"); //Let's play this game
			play.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ae2) {
					menu.next(colors); //Changing slides
				}
			});
			play.setAlignmentX(Component.CENTER_ALIGNMENT);

			titlemenu.add(play); //Add the play button to the frame

			jtf =  new JTextField("Subject or Title or Set ID(i.e. Java Facts)", 30); //Title for searching
			searchvocab.add(jtf); //Add the JTextField

			JButton jb1 = new JButton("Search Quizlet"); //SEARCH THE QUIZLET
			searchvocab.add(jb1);
			jb1.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent ae2) {
        					getSearch();
        					for (int p = 0; p < 15; p++) { //While array has stuff, print it out
								jl1 = new JLabel("<html><div style=width:350px><p>" + "--> " + searchresults[1][p] + "\n</p></div></html>"); //HTML is easier to use for formatting
								jl1.setForeground(Color.white); 
								searchvocab.add(jl1); //add a vocab search button
								jb = new JButton("Use Set"); //Want to use this set?
								final int buttonIndex = p; //Button Index is pretty awesome

								jb.addActionListener(new ActionListener() { //Mad science here
										public void actionPerformed(ActionEvent ae2) {
											set = Integer.parseInt(searchresults[0][buttonIndex]); //Parse the search result
				        					getCards(); //Get the cards from online
				        					knowledge.fillCards(); //Fill the flashcards with the cards from online
				        					cards.next(frame.getContentPane()); //Game time!

				        				}
				    			}); //end action listener
								searchvocab.add(jb); 
							} //end for statement
							revalidate(); //Just to be sure...
					}
    			}); //end action listener
			}

		//Nothing to do here
		public void mousePressed(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) {}
		public void mouseExited(MouseEvent evt) {
			System.out.println("Get back in the game!"); //Mouse listener is being used here
		}
		public void mouseClicked(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {}

		public void getSearch() {
			try {search = new URL("https://api.quizlet.com/2.0/search/sets?client_id=" + token + "&whitespace=1&q=" + jtf.getText());}  catch (Exception f) {} //Search for words
			try {in = new BufferedReader(new InputStreamReader(search.openStream())); } catch (Exception f) {} //Try the BufferedReader
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
			try {card = new URL("https://api.quizlet.com/2.0/sets/" + set + "?client_id=" + token + "&whitespace=1");}  catch (Exception f) {} //Download the flash cards
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

			public BufferedImage alien1, alien2, alien3, alien4, alien5, alien6, ship, ammo, background, explode, die; //Images I use

			public MyHelloPanel() {
				//Get the images in the game
				try {alien1 = ImageIO.read(new File("alien1.png"));} catch (IOException ex) {System.out.println("Image error");}
				try {alien2 = ImageIO.read(new File("alien2.png"));} catch (IOException ex) {System.out.println("Image error");}
				try {alien3 = ImageIO.read(new File("alien3.png"));} catch (IOException ex) {System.out.println("Image error");}
				try {alien4 = ImageIO.read(new File("alien4.png"));} catch (IOException ex) {System.out.println("Image error");}
				try {alien5 = ImageIO.read(new File("alien5.png"));} catch (IOException ex) {System.out.println("Image error");}
				try {alien6 = ImageIO.read(new File("alien6.png"));} catch (IOException ex) {System.out.println("Image error");}
				try {explode = ImageIO.read(new File("explode.png"));} catch (IOException ex) {System.out.println("Image error");}
            	try {ship = ImageIO.read(new File("ship.png"));} catch (IOException ex) {System.out.println("Image error");} 
            	try {ammo = ImageIO.read(new File("ammo.png"));} catch (IOException ex) {System.out.println("Image error");} 
            	try {background = ImageIO.read(new File("background.png"));} catch (IOException ex) {System.out.println("Image error");}
            	try {die = ImageIO.read(new File("death.png"));} catch (IOException ex) {System.out.println("Image error");}
            	newscore = new File("highscore.json"); //highscore data storage file
            	transparent = new Color(0, true); //transparent color
				this.setBackground(transparent); //Make the background transparent for hte iamge
				frame.addKeyListener(this);
				Shoot shoot = new Shoot(); //For the user shooting
				bullet = new Timer(35, shoot); //Shooting timer
				Enemy enemy = new Enemy(); //Enemy dropping bombs
				drop = new Timer(dropspeed, enemy); //Drop timer
				Ran ran = new Ran(); //Random bomb dropping
				rand = new Timer(randspeed, ran); //Timer for that
				Animation animation = new Animation(); //Animation of the alients
				animate = new Timer(500, animation); //Timer for that
				animate.start(); //Start the animation
				Explosion explosion = new Explosion(); //Star the explosion
				explodeme = new Timer(300, explosion); //Timer up
				SpaceDeath spacedeath = new SpaceDeath(); //Space is dead
				death = new Timer(50, spacedeath); //DEATH!
				rand.start();

				//Fill white spaces in array
				for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 16; j++) {
                		location[i][j] = 0;
                	}	
                } //end for

                //Fill in aliens into array
               	for (int j = 0; j < 8; j++) {
                		location[j][0] = 1;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][1] = 10;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][2] = 10;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][3] = 12;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][4] = 12;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][5] = 1;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][6] = 10;
                }
                for (int j = 0; j < 8; j++) {
                		location[j][7] = 12;
                }

			}

			public void paintComponent(Graphics g) {
				highscore(); //Get the high score
				super.paintComponent(g);
	            g.setColor(Color.white);
	            if (death.isRunning()){} //Do not paint ship is death is running
	           	else
	            location[player][15] = 2;
	  

				g.drawImage(background,0,0,getSize().width,getSize().height,this); //Draw background
				for (int i = 0; i < 8; i++) {
                	for (int j = 0; j < 16; j++) {

                    	int a = location[i][j];
                    	if (a == 0) { //Nothing here
                    		g.setColor(transparent);
                    		g.fillRect(i * 100, j * 37+15, 5, 5);
                    	}
                    	if (a == 1) { //alien1
                    		g.setColor(Color.white);
                    		g.drawImage(alien1, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 2) { //Player's ship
                    		g.setColor(Color.green);
                    		g.drawImage(ship, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 3) { //Bullet player shoots
                    		g.setColor(Color.white);
                    		g.fillRect((i * 100) + 30, j * 37+15, 3, 15);
                    	}
                    	if (a == 4) { //Ammo droped by the aliens
                    		g.drawImage(ammo, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 5) { //Another player ship
                    		g.setColor(Color.green);
                    		g.drawImage(ship, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 6) { //Nothing to do here again
                    		g.setColor(transparent);
                    		g.fillRect(i * 100, j * 37+15, 5, 5);
                    	}
                    	if (a == 7) { //alien2
                    		g.setColor(Color.white);
                    		g.drawImage(alien2, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 8) { //explode
                    		g.setColor(Color.white);
                    		g.drawImage(explode, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 9) { //death
                    		g.setColor(Color.white);
                    		g.drawImage(die, i * 100 +20, j * 37+15, null);
                    	}
                    	if (a == 10) { //alien3
                    		g.setColor(Color.white);
                    		g.drawImage(alien3, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 11) { //alien4
                    		g.setColor(Color.white);
                    		g.drawImage(alien4, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 12) { //alien5
                    		g.setColor(Color.white);
                    		g.drawImage(alien5, i * 100 +20 , j * 37+15, null);
                    	}
                    	if (a == 13) { //alien6
                    		g.setColor(Color.white);
                    		g.drawImage(alien6, i * 100 +20 , j * 37+15, null);
                    	}


					}
                } //end for statement
                g.setColor(Color.white); 
                g.drawString("Score: " + score, 30, 610); //Keeping track of score
                if (score > oldscore)
                g.drawString("High Score: " + score, 120, 610); //Live updating high score
            	else 
            	g.drawString("High Score: " + oldscore, 120, 610); //Live updating high score
           		g.drawString("Lives: " + lives, 630, 610); //How lives do you have?
                g.drawString("Level: " + level, 710, 610); //What level are you on?

                gameover = true; //Is the game over true? seems like it?
                for (int j = 0; j < 8; j++) { //Search the array for aliens
                	if ((location[j][0] == 1) || (location[j][0] == 7)) {
                		gameover = false; //Gues sit's not?
                	}
                }

                if (gameover == true) { //if the game is over
                	bulletlocation = 14;
					droplocation = 8;
                	location[0][0] = 6;
                	bullet.stop();
                	drop.stop();
                	rand.stop();
                	animate.stop(); //stop timers
                	g.setFont(new Font("Helvetica", Font.BOLD, 35));
                	g.drawString("YOU WIN :D", 150, 500);
				    cards.next(frame.getContentPane()); //UPGRADES!
				}

        	} //end paintComponennt

        	private class Shoot implements ActionListener { //Shooting timer
            	public void actionPerformed(ActionEvent e) {

            			//Check if it hit a alien
	            		if ((location[bulletx][bulletlocation - 1] == 1) || (location[bulletx][bulletlocation - 1] == 7) || (location[bulletx][bulletlocation - 1] == 10) || (location[bulletx][bulletlocation - 1] == 11) || (location[bulletx][bulletlocation - 1] == 12) || (location[bulletx][bulletlocation - 1] == 13)) {
	            			if (bulletupgrade == false) {
		            			location[bulletx][bulletlocation - 1] = 8;
		            			location[bulletx][bulletlocation] = 0;
		            			explodeme.start();
		            			score = score + 10;
		            		}
	            			else { //Don't have a upgrade?
	            				location[bulletx][bulletlocation - 1] = 8;
	            				location[bulletx][bulletlocation - 2] = 8;
	            				location[bulletx][bulletlocation] = 0;
	            				explodeme.start();
	            				score = score + 20;
	            			}
	            			bullet.stop(); //stop the timer
	            			bulletlocation = 14;
	            			highscore();
	            		}
	            		else if (bulletlocation == 1) { //Didn't hit a alien?
	            			location[bulletx][bulletlocation] = 0;
	            			bulletlocation = 14;
	            			bullet.stop();
	            		}
	            		else { //Disables going out of the array
	            			location[bulletx][bulletlocation] = 0;
	            			bulletlocation--;
	            			location[bulletx][bulletlocation] = 3;
	            		}

            		repaint();

            	}
            }

            private class Ran implements ActionListener { //Random number generator for alein droppings
            	public void actionPerformed(ActionEvent e) {
            		random = 0 + (int)(Math.random() * ((7 - 0) + 1));
            		while (location[random][0] == 0) {
            			random = 0 + (int)(Math.random() * ((7 - 0) + 1));
            		}
            		for (int n = 0; n < 15; n++) {
            			//Checking where the aleins are 
            			if ((location[random][n] == 1) || (location[random][n] == 7) || (location[random][n] == 10) || (location[random][n] == 11) || (location[random][n] == 12) || (location[random][n] == 13))
            				droplocation = n + 1;
            		}
            		location[random][droplocation] = 4;
            		drop.start(); //Start the alien bomb drops!
            	}
            }

            private class Animation implements ActionListener { //Animate me
            	public void actionPerformed(ActionEvent e) {
            		switch (u) {
						case 1:  //First animatoins
	            		for (int i = 0; i < 8; i++) {
			                for (int j = 0; j < 8; j++) {
			                	if (location[i][j] == 1) //For different alien types
			                		location[i][j] = 7;
			                	if (location[i][j] == 10)
			                		location[i][j] = 11;
			                	if (location[i][j] == 12)
			                		location[i][j] = 13;
			                }
	                	} //end for
	                	u = 2;
	                	break;
 
	            		case 2: //Second animatoins
	            		for (int i = 0; i < 8; i++) {
			                for (int j = 0; j < 8; j++) {
			                	if (location[i][j] == 7) //For different alien types
			                		location[i][j] = 1;
			                	if (location[i][j] == 11)
			                		location[i][j] = 10;
			                	if (location[i][j] == 13)
			                		location[i][j] = 12;
			                	}	
	                	} //end for
	                	u = 1;
						break;

					}

					repaint();

            	}
            }

            private class Explosion implements ActionListener { //Explding when you kill alien
            	public void actionPerformed(ActionEvent e) {
            		for (int i = 0; i < 8; i++) {
			            for (int j = 0; j < 8; j++) {
			            	if (location[i][j] == 8)
			            		location[i][j] = 0;
			            		repaint();
			            }
			        }
            		explodeme.stop();
            	}
            }

            private class SpaceDeath implements ActionListener { //Your explosion when you die
            	public void actionPerformed(ActionEvent e) {
            		if (o < 10) {
            			switch (t) {
            				case 1: 
            				location[spacex][15] = 0; //Animations for dying
		            		repaint();
            				t = 2;
            				break;
            				case 2: 
            				location[spacex][15] = 9; //Animations2 for dying
            				repaint();
            				t = 1;
            				break;
            			}
            			o++;
            			System.out.println(o);
            		}
			        else {
			        	location[spacex][15] = 5; //Done? Let's get back to playing
            			death.stop();
            			rand.start();
            			o = 0;
            			t = 1;
            			repaint();
            		}
            	}
            }

            private class Enemy implements ActionListener { //Enemy bombings here
            	public void actionPerformed(ActionEvent e) {
            		location[random][droplocation] = 0;
            		droplocation++;
            		if (location[random][droplocation] == 2) { //checking if you have any lives left
            			lives--;
            			if (lives == 0) { //No lives? Time to answer a flashcard question
	            			cards.last(frame.getContentPane());
	            			rand.stop();
	            			lives = resetlives;
            			}
            			else { //Not hit anything? That's fine, continue game
            				rand.stop();
            				location[random][droplocation] = 9;
            				spacex = random;
            				death.start();
            				repaint();
            				drop.stop();
            			}
            		}
            		location[random][droplocation] = 4;
            		if (droplocation == 15) {
            			drop.stop();
            			location[random][droplocation] = 0;
            		}
            		repaint();
            	}
            }

            public void newlevel() { //Game over? Let's start a new lvel
            		for (int i = 0; i < 8; i++) {
		                for (int j = 0; j < 16; j++) {
		                	location[i][j] = 0;
		                }	
		            } //end for

		            //Filling array with aliens
	               	for (int j = 0; j < 8; j++) {
	                		location[j][0] = 1;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][1] = 10;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][2] = 10;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][3] = 12;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][4] = 12;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][5] = 1;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][6] = 10;
	                }
	                for (int j = 0; j < 8; j++) {
	                		location[j][7] = 12;
	                }
                	level = level + 1; //Increasing level
                	dropspeed = dropspeed -5; //Adding speed
                	randspeed = randspeed - 75; //Faster bomb drops
                	if (dropspeed <= 0) //Checks to make sure it does not go out of bounds
                	dropspeed = 10; //Again
                	if (randspeed <= 50) //Again
                	randspeed = 500; //Again
                	drop.setDelay(dropspeed); //Delay for bombs
                	rand.setDelay(randspeed);
                	bullet.start(); //start the timers up!
                	rand.start();
                	animate.start();
                	repaint(); //ready to pplay again
            }  


            public void highscore() { //Check for highscores

            	if (read == true) {
			        try {
						Scanner in = new Scanner(newscore); //Get the highscore from the file
						oldscore = in.nextInt();
					} catch (FileNotFoundException e) {}
					read = false;
				}

				if (score > oldscore) {
					try {
						out = new PrintWriter(newscore);
					} catch (IOException e) {System.out.println("hi");} //Write to file if highscore is beaten
					out.print(score);
					out.close();
				}

            }

        	public void keyPressed(KeyEvent e) {}

        	public void keyReleased(KeyEvent e) {} 

        	public void keyTyped(KeyEvent e) { //Actions of the user
	        	char c = e.getKeyChar();
	        	if (c == 'a') { //If you want to move left
	        		if (death.isRunning()) {} 
	        		else if (player == 0) {
	        			location[player][15] = 0;
	        			player = 7;
	        		}
	        		else {
	        			location[player][15] = 0;
	        			player--;
	        		}
	        	} 
	        	if (c == 'd') { //If you want to move right
	        		if (death.isRunning()) {}
	        		else if (player == 7) {
	        			location[player][15] = 0;
	        			player = 0;
	        		}
	        		else {
	        			location[player][15] = 0;
	        			player++;
	        		}
	        	}
	        	if (c == 32) { //Spacebar for shooting
	        		if (bullet.isRunning()) {}
	        		else if (death.isRunning()) {}
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

	class MyUpgradePanel extends JPanel { //Upgrades for the user
		public MyUpgradePanel() {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JLabel titletext = new JLabel("Choose your upgrade");
			JButton speed = new JButton("Speed");
			JButton bullet1 = new JButton("Bullet");
			JButton life = new JButton("lives");
			speed.addActionListener(new ActionListener() {  //Speed upgrade
				public void actionPerformed(ActionEvent ae2) {
					bullet.setDelay(15);
					cards.previous(frame.getContentPane());
					hello.newlevel();
				}
			});
			bullet1.addActionListener(new ActionListener() {  //Bullet speed upgrade
				public void actionPerformed(ActionEvent ae2) {
					bulletupgrade = true;
					cards.previous(frame.getContentPane());
					hello.newlevel();
				}
			});
			life.addActionListener(new ActionListener() {  //Life upgrade for the user
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

		public MyKnowledgePanel() { //Knowledge panel for flashcards
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //SEtting the layout as BoxLayout
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

		public void fillCards() { //Fill the panel with flashcards
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

		public void checkAnswer() { //Check if the answers are coorect
			if (one.isSelected()) {
				if (one.getText().equals("<html><div style=width:350px><p>" + flashcards[1][cardlocation] + "</p></div></html>")) {
					cardlocation++;
					fillCards();
					cards.show(frame.getContentPane(), "Panel 2");
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
					cards.show(frame.getContentPane(), "Panel 2");
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
					cards.show(frame.getContentPane(), "Panel 2");
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
					cards.show(frame.getContentPane(), "Panel 2");
					rand.start(); 
					score = score + 50;
					lives = resetlives;
				}
				else {nope.setText("Wrong Answer"); score = score - 20; questionscore = new JLabel("Score: " + score);}
			}
		}  //end CheckAnsswers

	} //end MyKnowledgePanel

} //end program