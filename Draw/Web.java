import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw {

    JFrame frame;
    MyPanel panel;

    int ArrayCount = 0;
    int[][] painted = new int[999999][3];

    public static void main(String[] args) {
        Draw sjf = new Draw();
        sjf.Run();
    }

    public void Run() {
        frame = new JFrame("Web");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyPanel();



        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.addMouseListener(panel);
        frame.addMouseMotionListener(panel);

        frame.setSize(500, 600);
        frame.setVisible(true);


    }



    class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
        public int width; //width of the panel
        public int height; //height of the panel
        public int choosepaint = 1; //decides which color to use
        public boolean dragging; //boolean to decide whether or not
        dragging is occuring
        public int endX; //the coordinates of the place
        where the user released the mouse
        public int endY; //the coordinates of the place
        where the user released the mouse
        public int X; //the coordinates of the place
        where the user clicked down
        public int Y; //the coordinates of the place
        where the user clicked down
        public int dragX; //the coordinates of the place
        where the user is dragging.
        public int dragY; //the coordinates of the place
        where the user is dragging.

        @Override
        public void paintComponent(Graphics g) { //draw the buttons, the
            currently being dragged line, and the saved lines.
            width = getWidth();
            height = getHeight();
            super.paintComponent(g);
            setBackground(Color.lightGray);

            g.setFont(new Font("Arial", Font.BOLD, 24));

            g.setColor(Color.black); //Draw First button
            g.fillRect(0, 0, width / 5, 100);

            g.setColor(Color.red);
            g.fillRect((width / 5) + 2, 0, width / 5, 100); //Draw Second
            Button

            g.setColor(Color.blue);
            g.fillRect((2 * width / 5) + 4, 0, width / 5, 100); //Draw Third
            Button

            g.setColor(Color.gray);
            g.fillRect((3 * width / 5) + 6, 0, width / 5, 100); //Draw Fourth
            Button

            g.setColor(Color.green);
            g.fillRect((4 * width / 5) + 8, 0, width / 5, 100); //Draw Fifth
            Button

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
            g.setColor(Color.red);
            //this is where the buttons have finished being drawn

            switch (choosepaint) { //set the color
                case 1:
                    g.setColor(Color.red);
                    break;
                case 2:
                    g.setColor(Color.blue);
                    break;
                case 3:
                    g.setColor(Color.gray);
                    break;
                case 4:
                    g.setColor(Color.green);
                    break;
            }

            g.drawLine(X - 7, Y - 27, dragX - 7, dragY - 27); //draw the line
            that the user is currently manipulating

            for (int i = 0; i < ArrayCount;) {
                // switch the color to the one stored in the array
                for that particular point
                switch (painted[i][2]) {
                    case 1:
                        g.setColor(Color.red);
                        break;
                    case 2:
                        g.setColor(Color.blue);
                        break;
                    case 3:
                        g.setColor(Color.gray);
                        break;
                    case 4:
                        g.setColor(Color.green);
                        break;
                    default:
                        g.setColor(Color.black);
                        break;
                } //end switch statement for color

                g.drawLine(painted[i][0] - 7, painted[i][1] - 27,
                painted[i + 1][0] - 7, painted[i + 1][1] - 27); //draw
                that stored line
                i = i + 2;

            }
        } // end paintComponent

        @Override
        public void mousePressed(MouseEvent e) {
            dragging = true; //the user is now dragging after he clicked down

            X = e.getX(); //the current point
            Y = e.getY(); //the current point

            if (Y < 123) { //if the user clicks inside the button, reset all
                values except
                for initial X to ensure no lines drawn.
                dragging = false;
                Y = endX = endY = dragX = dragY = 0;
                repaint();
            }

            if (Y <= 123) { //If the initial click is within bounds of the
                Buttons, change the color to the one selected

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
                    System.out.println("Color is
green");
                    choosepaint = 4;
                }
            } //end changing the color

            if (choosepaint == 5) { //if the user presses reset, everything
                goes away
                for (int row = 0; row < painted.length; row++) { //reset
                    the array(delete all its contents)
                    for (int col = 0; col < 3; col++) {
                        painted[row][col] = 0;
                    }
                }
                dragging = false; //no more dragging we reseted
                X = Y = endX = endY = dragX = dragY = 0; //reset
                everything back to zero
                repaint();
                choosepaint = 1; //reset the color.
            }

            if (Y > 123) { //If in the canvas, assign the coordinates of the
                first click
                painted[ArrayCount][0] = X;
                painted[ArrayCount][1] = Y;
                painted[ArrayCount][2] = choosepaint;
            }

        }@Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {
            dragging = false; //the dragging has stopped after user releases

            //this part cannot be put into mouseDragged as the mouse was
            not dragged.

            dragX = X; //if the user doesn't drag, prevents dragX to
            defaulting to(0, 0)
            dragY = Y; //if the user doesn't drag, prevents dragX to
            defaulting to(0, 0)

            endX = e.getX(); //get the endpoint
            endY = e.getY(); //get the endpoint

            if (Y < 123) { //if the action is happening inside the button
                panel, make sure to reset everything so nothing is drawn.
                dragging = false;
                Y = endX = endY = dragX = dragY = 0;
                repaint();
            } //TROUBLESHOOTING

            if (endY > 123) { //make sure the endpoint is outside of the
                constraint
                ArrayCount++;
                painted[ArrayCount][0] = endX;
                painted[ArrayCount][1] = endY;
                ArrayCount++;

                repaint();
            } else //if the line encroaches onto the buttons, stop it at
            126 and save that point {
                ArrayCount++;
                painted[ArrayCount][0] = endX;
                painted[ArrayCount][1] = 130;
                ArrayCount++;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {}@Override
        public void mouseExited(MouseEvent e) {}@Override

        public void mouseDragged(MouseEvent e) { //the dragging
            if (dragging) {
                dragX = e.getX();
                dragY = e.getY();

                if (dragY < 123) { //cannot draw into the buttons
                    dragY = 130;
                }
                if (Y < 123) {
                    dragging = false;
                    Y = endX = endY = dragX = dragY = 0;
                    repaint();
                }
                repaint();
            }
        }@Override
        public void mouseMoved(MouseEvent e) {}
    }
} //end the biggest class