// Jimmy Liu
// September 28, 2012
// CylinderTester.java
// This program calculates the volume and surface area of a cylinder using the radius and height as input. 

public class CylinderTester {
	
	public static void main (String [] args){
		
		Cylinder mycan = new Cylinder();
		
		mycan.getDimension();  // input radius and height
		mycan.findSAandV(); // calculate surface area and volume
		mycan.printToScreen(); // print results
		
		Cylinder myothercan = new Cylinder(2.0, 5.0);
		myothercan.findSAandV();
		myothercan.printToScreen();

	} // end main
	
} // end CylinderTester
