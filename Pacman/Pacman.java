// Pacman.java
// Author: Jimmy Liu
// 3 March, 2013
// This program creates a JFrame, and has two JPanels. Inside is a simplified Pacman game, where the user collects yellow blocks and tries to avoid 
// ghosts. The objective of the game is the collect all 6 cheeses.

// Class Variables
// 	DerpPanel: The main panel of this program. This panel contains all of the ghosts, cheese, and Pacman. This panel also contains the red documentation
//			   located below the blue frame.
//	GridPanel: The secondary panel that is set below DerpPanel. This panel has the blue border and gray bordered background.
//	lpane: This JLayeredPane allows me to create two panels and put one on top of another. This makes the program more efficient, not letting forcing me
//		   repaint the Grid over and over again.		
//	array: This array stores the ghosts and pacman. It is 10x10 in size, each unit represents a block in the program. Key: 1 = nothing, 3 = ghost, 
//         4 = pacman.
//	cheddar: This is the array for storing cheese. It is similar to array, but only for cheese. Key: 1 = nothing, 2 = cheese. 
//	move: This is for checking if it is the first time the program is running. If it is, run the if statement to fill array with Pacman, ghosts, and cheddar.
//	xloc, yloc: The x and y location of Pacman in the game. 
//	cheese: The number of cheese the user collects. Starts at 0.
//	gameover: Boolean to see if the user loses the game by getting caught by a monster. Default is false, if it is true, tell the user he has lost
//			  the game.

// Class Methods
// 	Run(): This sets up the JFrame, and adds two JPanels into the JFrame. Also sets up the JLayeredPanel, disables auto-background painting for DerpPanel,
//		   so that GridPanel can be seen. Start sets default frame size to 500x520. Also creates blue border around GridPanel. Finnaly fills up array for both
//		   cheese and array to 1. 
// 	GridPanel:
//		paintComponent: This paintComponent paints the gray grid in the program. This only runs once.
// 	DerpPanel:
//		paintComponent: This starts the program by determining Pacman, cheese, and ghost location. Has checking built in. Then, has painting by reading from
//					    both arrays. Finnaly, checks if user wins/loses, if so, displays correct mesasge.
//		Pacmann: This timer causes the Pacman animation. 
//		Mover: This timer causes the ghosts to move. Has checking built in.
//		keyTyped: This gets the key input from the user, and translates it into moving Pacman. Has border restrctions, cheese eating, ghost dying.

// Fork me here: https://github.com/lele0108/Java/tree/master/Pacman

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Pacman {

    JFrame frame; // JFrame and JPanel must be global object instances
    DerpPanel np; // KeyListener, FocusListener panel with text field
    GridPanel gp;
    int[][] array = new int[10][10];
    int[][] cheddar = new int[10][10];
    int move = 0;
    int xloc, yloc; //pacman x and y
    int cheese = 0;
    boolean gameover = false;
    private JLayeredPane lpane = new JLayeredPane();


    public Pacman() {

    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        pacman.Run();
    } //end public void


    public void Run() {
        frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gp = new GridPanel();
        np = new DerpPanel();

        //stand back, I'm doing serious science here
        //<3 stackoverflow <3
        frame.setSize(new Dimension(500, 560));
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 500, 500);
        np.setBounds(0, 0, 500, 560);
        np.setOpaque(false);
        gp.setBounds(0, 0, 500, 500);
        gp.setOpaque(true);
        lpane.add(gp, new Integer(0), 0);
        lpane.add(np, new Integer(1), 0);
        frame.setVisible(true);
        gp.setBorder(BorderFactory.createLineBorder(Color.blue, 8));

        //fill array up with normal
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = 1;
                cheddar[i][j] = 1;
            }
        }

    } //end Run()

    class GridPanel extends JPanel {

        public GridPanel() {

        } //end public GridPanel

        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(Color.lightGray);
            g2.setStroke(new BasicStroke(3));

            for (int col = 0; col < 10; col++) {
                for (int row = 0; row < 10; row++) {
                    g2.drawRect(row * 48 + 10, col * 48 + 10, 48, 48);
                }
            }

        } //end paintComponennt


    } //end GridPanel

    class DerpPanel extends JPanel implements KeyListener {

        public DerpPanel() {
            frame.addKeyListener(this);
            Mover mover = new Mover();
            Timer timer = new Timer(3000, mover);
            Pacmann pacmann = new Pacmann();
            Timer timer2 = new Timer(500, pacmann);
            timer.start();
            timer2.start();
        } //end public DerpPanel


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //red bottom
            g.setColor(Color.red);
            g.fillRect(0, 500, 560, 60);
            g.setColor(Color.black);
            g.setFont(new Font("Helvetica", Font.BOLD, 15));
            g.drawString("Directions: a = left, d = right, w = up, s = down, r = reset", 50, 520);
            //end red bottom

            if (move == 0) { //first turn pacman, cheese, ghost
                xloc = 0 + (int)(Math.random() * ((9 - 0) + 1));
                yloc = 0 + (int)(Math.random() * ((9 - 0) + 1));
                array[xloc][yloc] = 4;

                for (int z = 0; z < 6; z++) {
                    int cheesex = 0 + (int)(Math.random() * ((9 - 0) + 1));
                    int cheesey = 0 + (int)(Math.random() * ((9 - 0) + 1));

                    while ((cheesex == xloc) && (cheesey == yloc)) { //check duplicate pacman
                        cheesex = 0 + (int)(Math.random() * ((9 - 0) + 1));
                        cheesey = 0 + (int)(Math.random() * ((9 - 0) + 1));
                    }

                    while (array[cheesex][cheesey] == 3) { //check duplicate cheese
                        cheesex = 0 + (int)(Math.random() * ((9 - 0) + 1));
                        cheesey = 0 + (int)(Math.random() * ((9 - 0) + 1));

                        while ((cheesex == xloc) && (cheesey == yloc)) {
                            cheesex = 0 + (int)(Math.random() * ((9 - 0) + 1));
                            cheesey = 0 + (int)(Math.random() * ((9 - 0) + 1));
                        }
                    }
                    cheddar[cheesex][cheesey] = 2;
                } //end cheese

                for (int z = 0; z < 6; z++) {
                    int ghostx = 0 + (int)(Math.random() * ((9 - 0) + 1));
                    int ghosty = 0 + (int)(Math.random() * ((9 - 0) + 1));

                    while ((ghostx == xloc) && (ghosty == yloc)) { //check duplicate pacman
                        ghostx = 0 + (int)(Math.random() * ((9 - 0) + 1));
                        ghosty = 0 + (int)(Math.random() * ((9 - 0) + 1));
                    }



                    while (array[ghostx][ghosty] == 3) { //check duplicate ghost
                        ghostx = 0 + (int)(Math.random() * ((9 - 0) + 1));
                        ghosty = 0 + (int)(Math.random() * ((9 - 0) + 1));

                        while ((ghostx == xloc) && (ghosty == yloc)) {
                            ghostx = 0 + (int)(Math.random() * ((9 - 0) + 1));
                            ghosty = 0 + (int)(Math.random() * ((9 - 0) + 1));
                        }



                    }
                    array[ghostx][ghosty] = 3;
                } //end while

                move++;

            } //end pacman, cheese, and ghost generator






            //printing array
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int a = array[i][j];
                    int c = cheddar[i][j];

                    if (a == 4) { //pacman open
                        g.setColor(Color.blue);
                        g.fillArc(((i + 1) * 48) - 35, ((j + 1) * 48) - 35, 40, 40, 20, 320);
                    }

                    if (a == 5) { //pacman closed
                        g.setColor(Color.blue);
                        g.fillArc(((i + 1) * 48) - 35, ((j + 1) * 48) - 35, 40, 40, 0, 350);
                    }

                    if (c == 2) { //cheese
                        g.setColor(Color.yellow);
                        g.fillRect(((i + 1) * 48) - 30, ((j + 1) * 48) - 30, 35, 35);
                    }

                    if (a == 3) { //ghost
                        g.setColor(Color.red);
                        g.fillArc(((i + 1) * 48) - 35, ((j + 1) * 48) - 35, 40, 40, 0, 360);
                        g.setColor(Color.black);
                        g.fillArc(((i + 1) * 48) - 25, ((j + 1) * 48) - 25, 7, 7, 0, 360);
                        g.fillArc(((i + 1) * 48) - 10, ((j + 1) * 48) - 25, 7, 7, 0, 360);
                        g.fillRect(((i + 1) * 48) - 25, ((j + 1) * 48) - 10, 23, 3);
                    }

                }
            } //end for loop for printing

            if (gameover == true) { //check if game is over
                g.setFont(new Font("Helvetica", Font.BOLD, 50));
                g.setColor(Color.green);
                g.drawString("YOU LOSE :(", 100, 280);
            }

            if (cheese == 6) { //check if you win
                g.setFont(new Font("Helvetica", Font.BOLD, 50));
                g.setColor(Color.green);
                g.drawString("YOU WIN :)", 100, 280);
            }


        } //end paintComponent

        private class Pacmann implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pacman Animation");

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        int a = array[i][j];

                        if (a == 4) {
                            array[i][j] = 5;
                            repaint();
                        }

                        if (a == 5) {
                            array[i][j] = 4;
                            repaint();
                        }

                    }
                } //end for loops

            } //end public void

        } //end pacmann



        private class Mover implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ghost Move");

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        int a = array[i][j];

                        if (a == 3) { //ghost
                            int random = 1 + (int)(Math.random() * ((4 - 1) + 1));
                            switch (random) {
                                case 1:
                                    if (i == 0) //check if out of bounds
                                    break;
                                    array[i][j] = 1;
                                    if (array[i - 1][j] == 3) //check if another ghost
                                    break;
                                    array[i - 1][j] = 3;
                                    if (array[i - 1][j] == 4) //check for pacman
                                    gameover = true;
                                    break;

                                case 2:
                                    if (i == 9) //check for out of bounds
                                    break;
                                    if (array[i + 1][j] == 3) //check for ghosts
                                    break;
                                    if (array[i + 1][j] == 4) //check for pacman
                                    gameover = true;
                                    array[i][j] = 1;
                                    array[i + 1][j] = 3;
                                    break;

                                case 3:
                                    if (j == 0) //check for out of bounds
                                    break;
                                    if (array[i][j - 1] == 3) //check for other ghosts
                                    break;
                                    if (array[i][j - 1] == 4) //check for pacman
                                    gameover = true;
                                    array[i][j] = 1;
                                    array[i][j - 1] = 3;
                                    break;

                                case 4:
                                    if (j == 9) //check for out of bounds
                                    break;
                                    if (array[i][j + 1] == 3) //check for other ghosts
                                    break;
                                    if (array[i][j + 1] == 4) //check for pacman
                                    gameover = true;
                                    array[i][j] = 1;
                                    array[i][j + 1] = 3;
                                    break;

                            } //end switch case
                            repaint();
                        } //end ghost

                    } //end for
                } //end second for

            } //end public void
        } //end ghost




        public void keyPressed(KeyEvent e) {
            //nothing to do here
        } //end keyPressed

        public void keyReleased(KeyEvent e) {
            //nothing to do here
        } //end keyReleased 

        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            System.out.println("keyPressed, c= " + c);
            switch (c) { //Switch case for getting what direction the user wants to go

                case 'a':
                    if (xloc == 0) {
                        array[9][yloc] = 4;

                        if (cheddar[9][yloc] == 2) {
                            cheese++;
                            cheddar[9][yloc] = 1;
                        }

                        if (array[9][yloc] == 3) {
                            gameover = true;
                        }
                        array[xloc][yloc] = 1;
                        xloc = 9;

                        repaint();
                        break;
                    } //end if for wrapping

                    if (cheddar[xloc - 1][yloc] == 2) {
                        cheese++;
                        cheddar[xloc - 1][yloc] = 1;
                    }

                    if (array[xloc - 1][yloc] == 3) {
                        gameover = true;
                    }

                    array[xloc - 1][yloc] = 4;
                    array[xloc][yloc] = 1;
                    xloc = xloc - 1;
                    repaint();

                    break;

                case 'd':

                    if (xloc == 9) {
                        array[0][yloc] = 4;

                        if (cheddar[0][yloc] == 2) {
                            cheese++;
                            cheddar[0][yloc] = 1;
                        }

                        if (array[0][yloc] == 3) {
                            gameover = true;
                        }
                        array[xloc][yloc] = 1;
                        xloc = 0;

                        repaint();
                        break;

                    } //end if for wrapping
                    if (cheddar[xloc + 1][yloc] == 2) {
                        cheese++;
                        cheddar[xloc + 1][yloc] = 1;
                    }

                    if (array[xloc + 1][yloc] == 3) {
                        gameover = true;
                    }
                    array[xloc + 1][yloc] = 4;
                    array[xloc][yloc] = 1;
                    xloc = xloc + 1;
                    repaint();

                    break;

                case 'w':

                    if (yloc == 0) {
                        array[xloc][9] = 4;

                        if (cheddar[xloc][9] == 2) {
                            cheese++;
                            cheddar[xloc][9] = 1;
                        }

                        if (array[xloc][9] == 3) {
                            gameover = true;
                        }
                        array[xloc][yloc] = 1;
                        yloc = 9;

                        repaint();
                        break;
                    } //end if for wrapping

                    if (cheddar[xloc][yloc - 1] == 2) {
                        cheese++;
                        cheddar[xloc][yloc - 1] = 1;
                    }

                    if (array[xloc][yloc - 1] == 3) {
                        gameover = true;
                    }

                    array[xloc][yloc - 1] = 4;
                    array[xloc][yloc] = 1;
                    yloc = yloc - 1;
                    repaint();

                    break;

                case 's':

                    if (yloc == 9) {
                        array[xloc][0] = 4;

                        if (cheddar[xloc][0] == 2) {
                            cheese++;
                            cheddar[xloc][0] = 1;
                        }

                        if (array[xloc][0] == 3) {
                            gameover = true;
                        }
                        array[xloc][yloc] = 1;
                        yloc = 0;

                        repaint();
                        break;
                    } //end if for wrapping				

                    if (cheddar[xloc][yloc + 1] == 2) {
                        cheese++;
                        cheddar[xloc][yloc + 1] = 1;
                    }

                    if (array[xloc][yloc + 1] == 3) {
                        gameover = true;
                    }
                    array[xloc][yloc + 1] = 4;
                    array[xloc][yloc] = 1;
                    yloc = yloc + 1;
                    repaint();

                    break;

                case 'r':
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            array[i][j] = 1;
                            cheddar[i][j] = 1;
                        }
                    }
                    move = 0;
                    gameover = false;
                    cheese = 0;
                    break;
            }
            repaint(); //repaint after movement

        } //end keyTyped

    } //end DerpPanel

} //end Pacman