// Jimmy Liu
// January 30, 2013
// Calvin.java
// This program uses JFrames and paintComponent() to create a graphical picture
// resembling the cartoon character Calvin.
// 
// Class Methods
// 		Run()						opens the windom called "Calvin" and closes the window if 
//									the exit button is clicked on. Also sets background color,
//									size in pixels and makes the frame visible.
//		paintComponent(Graphic g)	uses a nested for loop to create the grid
//									used to draw Calvin on, using the graphics compenent.
// Class Variables					
//		col							used to refer to the column coordinate
//		row 						used to refer to the row coordinate
//		i							used to draw a red line every 5 spaces horizontally
//		j							used to draw a red line every 5 spaces vertically
//		k							used in the for loop to draw the round tect box
//									4 times
//		l							used to increase the size of the round rect
//									every time it is printed
//		w							used in another for loop to draw 4 more round 
//									rectangles
import java.awt.*;
import javax.swing.*;

public class Calvin {

	JFrame frame; // JFrame and JPanel must be global object instances
	MyPanel panel;

	public static void main(String[] args) {
		Calvin calvin = new Calvin();
		calvin.Run();
	}

	public void Run() {
		frame = new JFrame("Calvin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Put JPanel in frame

		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER); // put panel in
																// frame
		panel.setBackground(Color.white); // sets background color to white
		frame.setSize(500, 650); // explicitly set size in pixels
		frame.setVisible(true); // set to false to make invisible

	}

} // end class SimpleJFrame2

// Create a JPanel class
class MyPanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // execute the superclass method first
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.gray);
		//g2.setStroke(new BasicStroke(1));
		for (int col = 0; col < 55; col++)
			for (int row = 0; row < 40; row++) {
				g.drawRect(50 + row * 10, 50 + col * 10, 10, 10);
			}
		int i = 0;
		g.setColor(Color.red);
		while (i < 55) {
			g.drawLine(50, 50 + i * 10, 450, 50 + i * 10);
			i += 5;
		}
		int j = 0;
		while (j < 40) {
			g.drawLine(50 + j * 10, 50, 50 + j * 10, 600);
			j += 5;
		}
		g2.setStroke(new BasicStroke(2));
		g.setColor(Color.black);
		
		//draw lines
		g.drawLine(320, 200, 350, 120);
		g.drawLine(360, 230, 410, 190);
		g.drawLine(360, 240, 430, 250);
		g.drawLine(380, 280, 410, 280);
		g.drawLine(380, 330, 420, 320);
		g.drawLine(290, 190, 320, 90);
		g.drawLine(280, 190, 270, 90);
		g.drawLine(270, 90, 230, 190);
		g.drawLine(220, 200, 180, 110);
		g.drawLine(170, 120, 170, 220);
		g.drawLine(140, 260, 120, 180);
		g.drawLine(80, 250, 120, 290);
		g.drawLine(80, 280, 110, 320);
		g.drawLine(110, 320, 70, 320);

		//left eyebrow
		//g.drawArc(220, 210, 40, 20, 180, -150);

		//right eyebrow
		//g.drawArc(290, 210, 30, 30, 0, 135);

		//new eyebrows
		g.drawArc(220, 210, 40, 30 , 45 , 105);
        g.drawArc(280, 210, 40, 30, 0, 120);


		g.drawOval(180, 260, 80, 130);
		g.drawOval(260, 250, 80, 140);

		//draw Oval
		g.fillOval(230, 320, 20, 30);
		g.fillOval(270, 320, 20, 40);

		//bottom of face
		g.drawArc(10, 150, 280, 350, 180, 180);
		g.drawLine(230, 460, 260, 470);

		//nose code
		g.drawArc(230, 380, 50, 40, 35, -250);
		//g2.drawLine(380, 370, 380, 325);
		//g2.drawLine(110, 370, 110, 325);

		//draw CheekArcs
		g.drawArc(90, 370, 40, 60, 90, 180);
		g.drawArc(80, 370, 61, 60, -90, 41);
		g.drawArc(360, 370, 40, 60, 90, -210);
		g.setColor(Color.white);
		g.fillOval(90, 370, 48, 58);
		g.fillOval(350, 370, 48, 58);
		g.setColor(Color.black);
		int l = 0;
	
		for (int k = 0; k < 4; k++) {
			g.setColor(Color.white);
			g2.fillRoundRect(210 - k - 1, 500 + l - 1, 40 + k + k - 2, 20 - 0, 8, 8);
			g.setColor(Color.black);
			g2.drawRoundRect(210 - k, 500 + l, 40 + k + k, 20, 8, 8);
			l += 20;
		}
		l = 0;
		
		for (int w = 0; w < 4; w++) {
			g2.drawRoundRect(250 + w, 500 + l, 30 + 2 * w, 20, 8, 8);
			l += 20;
			
		}
		g.drawLine(220, 600, 220, 580);
		g.drawLine(240, 600, 240, 580);
		g.drawRoundRect(211, 580, 80, 20, 8, 8);
		g.setColor(Color.white);
		g.drawLine(50, 600, 450, 600);
	} // end paintComponent

} // end class MyPanel