import java.awt.*;
import javax.swing.ImageIcon;
public class Strip{
	int x;
	double y;
	int flash = 0;
	SlotMachinePart[] slotsArray;
	int slotMachineY; 
	int slotMachineLow;
	double move;
	boolean doneSelecting = false;
				int sl = 0;


	public Strip(int x, int y, int m){
		this.x = x;
		this.y=  y;
		int height = 75;
		slotMachineY  = -45;
		slotsArray = new SlotMachinePart[8];
		slotsArray[0]= new SlotMachinePart("Cherries.png", x + 5, slotMachineY );
		slotsArray[1] = new SlotMachinePart("7.png", x + 5, slotMachineY + height);
		slotsArray[2] = new SlotMachinePart("Football.png", x + 5, slotMachineY + 2*height);
		slotsArray[3] = new SlotMachinePart("Orange.png", x + 5, slotMachineY + 3*height);
		slotsArray[4] = new SlotMachinePart("Six.png", x + 5, slotMachineY +  4*height);
		slotsArray[5] = new SlotMachinePart("Smiley.png", x + 5, slotMachineY + 5*height);
		slotsArray[6] = new SlotMachinePart("TennisBall.png", x + 5, slotMachineY + 6*height);
		slotsArray[7] = new SlotMachinePart("x.png", x + 5, slotMachineY + 7*height);
		slotMachineLow = (int)slotsArray[7].y+75;
		move = m;
	}
	public void drawImages(Graphics g){
		for (int i =0; i <8; i++){
		
			slotsArray[i].drawIt(g);
		
		}
	


	}
	public void rollStrip(){
		
		for (int i = 0; i < 8; i++){
			slotsArray[i].y+=move;
			if (move > 0){
				if (slotsArray[i].y >= slotMachineLow) slotsArray[i].y = slotMachineY;
			}
			else if (move < 0 ){
				if (slotsArray[i].y <= slotMachineY - 70) slotsArray[i].y = slotMachineLow - 70;
			}
		}
		
	
	}
	public void drawStrip(Graphics g){
		g.fillRect(x, (int) y, 5, 250);
		g.fillRect(x+75,(int) y, 5, 250);
		g.fillRect(x,(int)y, 75, 5);
		g.fillRect(x, (int)y+245, 75 ,5);
		drawImages(g);
	}
	public void stop(){
		if (move > 0.1) move = move/2;
		else {
			if (!doneSelecting){
				for (int i = 0; i < 8; i ++){
					if (move > 0){
						if((slotsArray[i].y <= 105) && (slotsArray[i].y >= 30)) sl = i;
						doneSelecting = true;
					}
					else {
						if((slotsArray[i].y >= -45) && (slotsArray[i].y <= 30)) sl = i;
						doneSelecting = true;

					}
				}
			}
			if (move > 0){
				if((slotsArray[sl].y <= 105) && (slotsArray[sl].y >= 30)) rollStrip();
				
			}
			else{
				if((slotsArray[sl].y >= -45) && (slotsArray[sl].y <= 30)) rollStrip(); 
			}
		}
	
	
	}
	public String theOne(){
		if (sl != 0){
			return slotsArray[sl].part();
		}
		else return null;
	
	
	}
}

