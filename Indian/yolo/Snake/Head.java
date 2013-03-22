import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class Head implements KeyListener{
	int x, y, move, way;
	int count;
	ArrayList<Integer> directs = new ArrayList<Integer>();

	public Head(int x, int y){
		
		this.x = x;
		this.y = y;
		move = 1;
		 way = 1;
		 directs.add(way);
		//1 - down
		//2 - up
		//3 - left
		//4 - right
	}
	public void move(int x){
		if (x == 3){
			this.x -= move;
			System.out.println("L");
		}
		else if(x==4){
			this.x += move;
			System.out.println("R");
		}
		else if(x==1){
			y-=move;
			System.out.println("U");
		}
		else if (x==2){
			y+=move;
			System.out.println("D");
		}
	}
	public void realMove(){
		if (count%10 == 0){
				
		}
		
		count++;
		
		
	
		
	}

	public void drawHead(Graphics g){
		g.fillRect(x,y,10,10);
	}
	public void keyPressed(KeyEvent e){
		if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (way!=3) ){
			way = 4;
		} 	
		else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (way!=4) ){
			
			way = 3;
		}
		else if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (way!=1) ){
			
			way = 2;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			
			way = 1;
		}
		//if (way != directs.get(directs.size() - 1))
		directs.add(way);
			
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}


}
