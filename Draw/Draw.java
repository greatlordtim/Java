// Jimmy Liu
// Draw.java
// Feb. 13, 2013
// This program let's the user pick a color and draw straight lines on a canvas. It also has a reset function that clears the canvas. 

// Class Variables:
//   width: width of jPanel
//   height: height of jPanel
//   choosepaint: the color of the paint for canvas, default color is red
//   dragging: boolean that decides if the user is dragging his mouse or not
//   endX: Int of cordinates (x) where the user releases his mouse/stops dragging/stops painting
//   endY: Int of cordinates (y) where the user releases his mouse/stops dragging/stops painting
//   X: Int of cordinates (x) where the user first presses his mouse/starts drawing
//   Y: Int of cordinates (y) where the user first presses his mouse/starts drawing
//   dragX: coordinates of where the user is dragging (x)
//   dragY: coordinates of where the user is dragging (y)

// Class Methods: 
//   Run(): Creates a new JFrame with the name draw. Set default close operation to close. Define panel as JPanel, use BorderLayout
//	 manager to set it to Center, add mouseListerner and mouseMotionListerner to JPanel, set JFrame size to 500x600, and 
//   set visability of JFrame to true.
//
//   paintComponent(Graphics g): Get width of panel, and draw buttons + draw strings on them to represent the buttons on the user interface. 
//   Also sets the top margin and background as lightgray. A switch-case is in here to let users chose the color they would like to draw with, 
//   default color is Red. Lastly, it prints out the line the user is currently drawing, and stores it in a 2-d array
//
//   mousePressed(MouseEvent e): Get current color and print it out in Terminal. If Reset, print that out. If the user presses reset, reset
//   the canvas, and make sure user cannot drag during that time. 
//
//   mouseReleased(MouseEvent e): Make sure the default does not go back to 0, 0. Checks if the user is drawing on the button pane, if so, does not let 
//   it. Also make sure the user draws within the constraints.  
//
//   mouseDragged(MouseEvent e): If the mouse is currently dragging, get the coordinates. If Y coordinate is "off-plain", set it to maximum size. 
//   so that the user cannot draw on top of the buttons.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw {

    JFrame frame; //Create a JFrame to contain the program
    MyPanel panel; //Create a JPanel to contain drawing and buttons

    int ArrayCount = 0; 
    int[][] painted = new int[1337][3]; //create 2d array for storing drawings

    public static void main(String[] args) {
        Draw sjf = new Draw();
        sjf.Run();
    }

    public void Run() {
        frame = new JFrame("Draw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.addMouseListener(panel); //Add a mouseListener to the JPanel
        frame.addMouseMotionListener(panel); //Add a mouseMotionListener to the JPanel

        frame.setSize(500, 600); //creating a 500x600 JFrame 
        frame.setVisible(true);  //making the jFrame visable to the user
    }



    class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
        public int width; 
        public int height; 
        public int choosepaint = 1; //1 = red
        public boolean dragging;  
        public int endX; 
        public int endY; 
        public int X; 
        public int Y;
        public int dragX;
        public int dragY; 


        public void paintComponent(Graphics g) { //draw the buttons, the currently being dragged line, and the saved lines.
            width = getWidth(); //get window width
            height = getHeight(); //get window width
            super.paintComponent(g);
            setBackground(Color.lightGray); //background: set to light gray

            g.setFont(new Font("Helvetica", Font.BOLD, 24)); //pretty fonts :D

            g.setColor(Color.black); //Draw button (reset, first button)
            g.fillRect(0, 0, width / 5, 100);

            g.setColor(Color.red);
            g.fillRect((width / 5) + 2, 0, width / 5, 100); //Draw button (red, second button)

            g.setColor(Color.blue);
            g.fillRect((2 * width / 5) + 4, 0, width / 5, 100); //Draw button (blue, third button)

            g.setColor(Color.gray);
            g.fillRect((3 * width / 5) + 6, 0, width / 5, 100); //Draw button (gray, fourth button)

            g.setColor(Color.green);
            g.fillRect((4 * width / 5) + 8, 0, width / 5, 100); //Draw button (green, fifth button)

            //draw top margin
            g.setColor(Color.lightGray);
            g.fillRect(0, 0, width, 2);

            //Draw the Button Labels
            g.setColor(Color.white);
            g.drawString("RESET", (width / 10) - 45, 60);
            g.drawString("RED", (width / 5) + (width / 10) - 30, 60);
            g.drawString("BLUE", (width / 5) * 2 + (width / 10) - 30, 60);
            g.drawString("GRAY", (width / 5) * 3 + (width / 10) - 30, 60);
            g.drawString("GREEN", (width / 5) * 4 + (width / 10) - 35, 60);
            g.setColor(Color.red); //buttons and text are finished drawn

            switch (choosepaint) { //switch case for setting the color
                case 1:
                    g.setColor(Color.red); //red color
                    break;
                case 2:
                    g.setColor(Color.blue); //blue color
                    break;
                case 3:
                    g.setColor(Color.gray); //gray color
                    break;
                case 4:
                    g.setColor(Color.green); //green color
                    break;
            }

            g.drawLine(X - 7, Y - 27, dragX - 7, dragY - 27); //draw line the user is currently trying to draw

            for (int i = 0; i < ArrayCount;) {
               //chnage color to the one the user selects
                switch (painted[i][2]) {
                    case 1:
                        g.setColor(Color.red); //set red
                        break;
                    case 2:
                        g.setColor(Color.blue); //set blue
                        break;
                    case 3:
                        g.setColor(Color.gray); //set gray
                        break;
                    case 4:
                        g.setColor(Color.green); //set green
                        break;
                    default:
                        g.setColor(Color.black);
                        break;
                } 

                g.drawLine(painted[i][0] - 7, painted[i][1] - 27,
                painted[i + 1][0] - 7, painted[i + 1][1] - 27); //store lines + draw them
                i = i + 2;

            }
        } // end paintComponent

 
        public void mousePressed(MouseEvent e) { //start mousePressed event
            dragging = true; //user is now dragging

            X = e.getX(); //current X point
            Y = e.getY(); //current Y point

            if (Y < 123) { //make sure user does not draw any lines into buttons by resetting values when there
                dragging = false;
                Y = endX = endY = dragX = dragY = 0;
                repaint();
            }

            if (Y <= 123) { //Change the colors/reset if the user clicks on one of the buttons

                if (X <= (width / 5) + 5) {
                    System.out.println("RESET");
                    choosepaint = 5;
                }
                if (X <= 2 * width / 5 + 9 && X > width / 5 + 6) {
                    System.out.println("Color is Red");
                    choosepaint = 1;
                }
                if (X <= 3 * width / 5 + 11 && X > 2 * width / 5 + 9) {
                    System.out.println("Color is blue");
                    choosepaint = 2;
                }
                if (X <= 4 * width / 5 + 13 && X > 3 * width / 5 + 11) {
                    System.out.println("Color is gray");
                    choosepaint = 3;
                }
                if (X > 4 * width / 5 + 13) {
                    System.out.println("Color is green");
                    choosepaint = 4;
                }
            } //end changing the color

            if (choosepaint == 5) { //reset canvas if user presses reset
                for (int row = 0; row < painted.length; row++) { //byebye stuff on array
                    for (int col = 0; col < 3; col++) {
                        painted[row][col] = 0;
                    }
                }
                dragging = false; //reset no dragging
                X = Y = endX = endY = dragX = dragY = 0; //reset everything back to zero
                repaint();
                choosepaint = 1; //reset the color.
            }

            if (Y > 123) { //If in canvas, get first click
                painted[ArrayCount][0] = X;
                painted[ArrayCount][1] = Y;
                painted[ArrayCount][2] = choosepaint;
            }

        }

        public void mouseClicked(MouseEvent e) {}


        public void mouseReleased(MouseEvent e) {
            dragging = false; //the dragging has stopped after user releases this part cannot be put into mouseDragged as the mouse was not dragged.

            dragX = X; //if user does not drag mouse, do not change dragX to default 0.0
            dragY = Y; //if user does not drag mouse, do not change dragY to default 0.0

            endX = e.getX(); //get the endpoint
            endY = e.getY(); //get the endpoint

            if (Y < 125) { //if the action is happening inside the button panel, make sure to reset everything so nothing is drawn.
                dragging = false;
                Y = endX = endY = dragX = dragY = 0;
                repaint();
            }

            if (endY > 125) { //make sure the endpoint is outside of the constraint
                ArrayCount++;
                painted[ArrayCount][0] = endX;
                painted[ArrayCount][1] = endY;
                ArrayCount++;

                repaint();
            } else //if the line encroaches onto the buttons, stop it at 126 and save that point
            {
                ArrayCount++;
                painted[ArrayCount][0] = endX;
                painted[ArrayCount][1] = 130;
                ArrayCount++;
            }
        }


        public void mouseEntered(MouseEvent e) {} //nothing to do here

        public void mouseExited(MouseEvent e) {} //nothing to do here


        public void mouseDragged(MouseEvent e) { //the dragging
            if (dragging) {
                dragX = e.getX();
                dragY = e.getY();

                if (dragY < 125) { //cannot draw into the buttons
                    dragY = 130;
                }
                if (Y < 125) {
                    dragging = false;
                    Y = endX = endY = dragX = dragY = 0;
                    repaint();
                }
                repaint();
            }
        }
    
        public void mouseMoved(MouseEvent e) {} //nothing to do here
    }

} //end all classes



