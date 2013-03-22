import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFour extends JPanel implements ActionListener, KeyListener{
	int slotsHoriz, slotsVert;
	GameBoard board=  new GameBoard(20, 70);
	Token testToken = new Token();
	//ImageIcon icon = ImageIcon("Block.png");
	boolean drop = false;
	Token[] tokenArray = new Token[42];
	Rectangle r = new Rectangle(20,425, 490,5);
	int focusToken = 0;
	public void actionPerformed(ActionEvent evt){
		repaint();
		dropToken();
	}
	void setUpToken(){
		
		for (int i = 0; i < (42); i++){
				
			if ((i % 2) == 0){
				tokenArray[i] = new Token(0, 29, 10, 52);
				System.out.println("I initizialized " + i);
			}
			else {
				tokenArray[i] = new Token(1, 29, 10, 52);
				System.out.println("I initizialized " + i);

			}
		}
	}

	void addOne(int x){
		for (int i= 0; i < 42; i++){
			tokenArray[x].AddRect(tokenArray[i]);
		}
		tokenArray[x].AddRect(r);
	}
	
	void addTokens(){
		
		for (int i = 0; i < 42; i++){
			addOne(i);
		}
	}
	public ConnectFour(){
		this.addKeyListener(this);
		Timer t = new Timer(5,this);
		t.start();
		setUpToken();
		addTokens();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int i = 0; i < (focusToken+1); i++){
			tokenArray[i].drawToken(g);
		}
		board.drawBoard(g);
		//g.drawImage(icon.getImage(), 20, 20, icon.getImageObserver());
		
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			tokenArray[focusToken].moveRight(70);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			tokenArray[focusToken].moveLeft(70);
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			drop = true;
		}
	}
 	public void keyReleased(KeyEvent e){}
 	public void keyTyped(KeyEvent e){

		
	}
	public void dropToken(){
		if (drop){
			int filler = focusToken;
			focusToken = tokenArray[focusToken].drop( focusToken);		
			if (filler != focusToken){
				drop = false;
			}
		}
	}


}
