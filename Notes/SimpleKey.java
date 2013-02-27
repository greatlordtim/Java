// Mr Greenstein
// February 20, 2013
// SimpleKey.java
// An example of key (keyboard) events, action events, and focus events.

// Topics:	Implement KeyListener
//	1. implement a KeyListener
//	2. implement an ActionListener
//	3. implement a FocusListener

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleKey {

	JFrame frame;			// JFrame and JPanel must be global object instances
	NorthPanel np;			// KeyListener, FocusListener panel with text field
	SouthPanel sp;			// ActionListener, FocusListener panel with text field
	
	public SimpleKey () {
	}
	
	public static void main(String[] args) {
		SimpleKey sjf = new SimpleKey();
		sjf.Run();
	}

	public void Run() {
		frame = new JFrame("SimpleKey");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create North JPanel and add to JFrame
		np = new NorthPanel();
		frame.getContentPane().add(np, BorderLayout.NORTH);
		
		// Create South JPanel and add to JFrame
		sp = new SouthPanel();
		frame.getContentPane().add(sp, BorderLayout.SOUTH);
						
		frame.setSize(300, 300);		// explicitly set size in pixels
		frame.setLocation(500,300);	// set location on my screen
		frame.setVisible(true);		// set to true to make visible
		
	}

	///////////////////////////////////////////
	// - implement an KeyListener
	// - implement a FocusListener
	//
	class NorthPanel extends JPanel {
		JTextField tf;			// Text field for input
	
		public NorthPanel() {
			tf = new JTextField("default text");
			add(tf);
			/////////////////////////////////
			// - add an KeyListener
			// - add a FocusListener
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
		
		//////////////////////////////////////////
		// Define	keyPressed (KeyEvent e)
		//			keyReleased (KeyEvent e)
		//			keyTyped (KeyEvent e)
		//
		
		//////////////////////////////////////////
		// Define focusGained (FocusEvent e)
		// Define focusLost (FocusEvent e)
		//
		
	}	// end class NorthPanel
	
	///////////////////////////////////////////
	// - implement an ActionListener
	// - implement a FocusListener
	//
	class SouthPanel extends JPanel {
		JTextField ta;			// Text field for input
	
		public SouthPanel() {
			ta = new JTextField("another string");
			add(ta);
			/////////////////////////////////
			// - add an ActionListener
			// - add a FocusListener
			//
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
		
		//////////////////////////////////////////
		// Define actionPerformed(ActionEvent e)
		//
		
		//////////////////////////////////////////
		// Define focusGained (FocusEvent e)
		// Define focusLost (FocusEvent e)
		//

	}	// end class SouthPanel
}	// end class SimpleKey

// Extra:
//	1. Add another panel with JButtons and ActionEvents