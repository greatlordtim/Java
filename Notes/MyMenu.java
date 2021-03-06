// Mr Greenstein
// April 14, 2013
// MyMenu.java
// This program is an example of swing menus.

// Topics:
//	1. Create a menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMenu {
	private JFrame frame;
	private MyDrawingPanel canvas;
	private String color, shape, fillOutline;
	
	public MyMenu() {
		color = "Blue";
	}
	
	public static void main (String[] args) {
		MyMenu mm = new MyMenu();
		mm.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(440, 470);

		// Initialize the drawing canvas
		canvas = new MyDrawingPanel();
		
		//////////////////////////////////////////////////////////////
		// Set up color menu and menu items
		JMenu shapeColorMenu = new JMenu("COLOR");
		JMenuItem blue = new JMenuItem("Blue");
		JMenuItem red = new JMenuItem("Red");
		JMenuItem green = new JMenuItem("Green");
		shapeColorMenu.add(blue); shapeColorMenu.add(red); shapeColorMenu.add(green);
		ChangeColor ccListener = new ChangeColor();
		blue.addActionListener(ccListener); red.addActionListener(ccListener); green.addActionListener(ccListener); 
		
		//////////////////////////////////////////////////////////////
		// Set up menu bar
		JMenuBar menus = new JMenuBar();
		menus.add(shapeColorMenu);
				
		//////////////////////////////////////////////////////////////
		// add the menu bar to the frame
		frame.getContentPane().add(menus, BorderLayout.NORTH);

		// add the JPanel to the frame
		frame.getContentPane().add(canvas, BorderLayout.CENTER);

		// make the frame visible
		frame.setVisible(true);
	}
	
	class MyDrawingPanel extends JPanel {
		public MyDrawingPanel() {
			setBackground(Color.white);
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (color.equals("Blue")) g.setColor(Color.blue);
			else if (color.equals("Red")) g.setColor(Color.red);
			else g.setColor(Color.green);	// color is "Green"
			g.fillRect(40, 35, 350, 350);
		}
	}	// end class MyDrawingPanel
	
	class ChangeColor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			color = e.getActionCommand();
			canvas.repaint();
		}
	}
		
}

// Extra:
//	- Add a menu to change shape to circle and oval
