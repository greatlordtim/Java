import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;


public class SlotMachinePart {
	Image img;
	int x;
	double y;
	String t;
	public SlotMachinePart(String s, int x, int y){
		ImageIcon i = new ImageIcon(s);
		t = s;
		img = i.getImage();
		this.x  = x;
		this.y = y;
	}
	public void moveY(int y){
	
		this.y +=y;
	}
	public void setY(){
		this.y = y;
	}
	public void drawIt(Graphics g){
		
			g.drawImage(img,this.x, (int) this.y,null);
			g.fillRect(this.x, (int) this.y+70, 70,5);
			
		
	}
	public String part(){
		return t;
	}
}
