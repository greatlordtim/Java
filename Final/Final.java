import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.imageio.*;
import java.awt.image.*;

public class Final {
	private MyColorPanel colors; //Panel 1
	private JFrame frame; //JFrame
	String inputLine; //JSON is here
	BufferedReader in;
	int z;
	URL text, imageurl; //URL of API
	JPanel color1;
	String token = new String("528uWf4NCb");
	String question = new String("yolo");
	String[][] content = new String[100][300]; //Very big array for storing data
	public CardLayout cards; //Card Layout

	
	public static void main (String[] args) {
		Final space = new Final();
		space.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame("Space Evaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(730, 600);

		// Create the colors panel and buttons panel
		colors = new MyColorPanel();
		
		// add the JPanels to the frame

		frame.getContentPane().add(colors, BorderLayout.CENTER); //Define Frame location of colors

		// make the frame visible
		frame.setVisible(true);

	}
	
	class MyColorPanel extends JPanel implements MouseListener {

		public MyColorPanel() {
			getContent();
			cards = new CardLayout();
			this.setLayout(cards);
			color1 = new JPanel();
			color1.setBackground(Color.blue); //First Background as blue
		}

		//Nothing to do here
		public void mousePressed(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }

		public void getContent() {
			try {text = new URL("https://api.quizlet.com/2.0/search/sets?client_id=" + token + "&whitespace=1&q=" + question);}  catch (Exception f) {}
			try {in = new BufferedReader(new InputStreamReader(text.openStream())); } catch (Exception f) {}
        	ReadBigStringIn();
        	try {in.close();} catch (Exception f) {}

        	z = 0;
			//parse JSON "title"
			for (int i = -1; (i = inputLine.indexOf("\"id\":", i + 1)) != -1; ) {
			    int a = inputLine.indexOf(",", i);
			    content[0][z] = inputLine.substring(i + 6, a);
			    System.out.println(content[0][z]);
			    z++;
			} //end "title" parse


		} //end get content

		public String ReadBigStringIn() { //Read our txt int a string
			String line;
			StringBuilder everything = new StringBuilder();
		    try {while( (line = in.readLine()) != null) { everything.append(line); }} catch (Exception f) {}
		    inputLine = everything.toString();
		    return everything.toString();
		} //end get content	

	} //end MyColorPanel

} //end program