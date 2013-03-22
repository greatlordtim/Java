//
import java.awt.*;
import javax.swing.*;

public class SimpleJFrame {

	public static void main (String args[]) {		
		//Create JFrame object
		JFrame frame = new JFrame("My First JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton bigButton = new JButton("BIG");
		JButton littleButtion = new JButton("little");
		JButton emptylabel = new JButton("emp");
		frame.getContentPane().add(emptylabel, BorderLayout.NORTH);
		frame.getContentPane().add(littleButtion, BorderLayout.SOUTH);
		frame.getContentPane().add(bigButton, BorderLayout.CENTER);
		frame.setSize(200,300);
		frame.setLocation(200,10);
		frame.setVisible(true);
	}
}
