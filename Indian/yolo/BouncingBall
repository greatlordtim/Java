//  Scott DeRuiter      5/2/02
//  BouncingBall.java
//  A ball bouncing around

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BouncingBall extends JApplet   {

	Display canvas;
	JButton stopButton, startButton;

	public void init()  {
		setBackground ( Color.black );
		canvas = new Display ( );
		getContentPane().add( canvas, BorderLayout.CENTER );
      
		JPanel bottom = new JPanel ( );
		bottom.setBackground ( Color.black );
		startButton = new JButton ( "Start" );
		startButton.addActionListener ( canvas );
		bottom.add ( startButton );
		stopButton = new JButton ( "Stop" );
		stopButton.addActionListener ( canvas );
		bottom.add ( stopButton );
		stopButton.setEnabled ( false );
      
		getContentPane().add ( bottom, BorderLayout.SOUTH );
	}

	public Insets getInsets ( ) {
		return new Insets ( 5, 5, 5, 5 );
	}
   
	public void stop ( ) {
		canvas.stopRunning ( );
	}

	class Display extends JPanel implements ActionListener, Runnable {

		private int xradius, yradius, x, y, width, height, xChange, yChange, move;
		private Thread runner;
		private boolean running;

		public Display ( )   {
			move = 4;
			xradius = yradius = 10;
			xChange = yChange = move;
			x = 4 * (int) ( 100 * Math.random ( ) );
			y = 0;
		}
	
		public void paintComponent ( Graphics g )  {
			super.paintComponent ( g );
			g.setColor ( Color.blue );
			g.fillOval ( x, y, 2 * xradius, 2 * yradius );
		}

		void startRunning() {
			if (running)
				return;
			runner = new Thread(this);
			running = true;
			runner.start();
		}
	      
		void stopRunning() {
			running = false;
		}

		public void run() {
			startButton.setEnabled ( false );
			stopButton.setEnabled ( true );

			while ( running )   {
				width = getWidth ( );
				height = getHeight ( );
				if ( x + xChange < 0 )
					xChange = move;
				if ( x + xChange > ( width - 2 * xradius ) )
					xChange = -move;
				if ( y + yChange < 0 )
					yChange = move;
				if ( y + yChange > ( height - 2 * yradius ) )
					yChange = -move;
				x = x + xChange;
				y = y + yChange;
				repaint ( );
				Thread.yield();
				Pause ( 20 );
			}
			running = false;

			startButton.setEnabled ( true );
			stopButton.setEnabled ( false );
		}

		public void Pause ( int milli )   {
			try   {
				Thread.sleep ( milli );
			}
			catch ( InterruptedException e )   { }
		}
	
		public void actionPerformed ( ActionEvent evt )   {
			String command = evt.getActionCommand ( );
			if ( command.equals ( "Start" ) )
				startRunning ( );
			else if ( command.equals ( "Stop" ) )
				stopRunning ( );
		}
	}
}

