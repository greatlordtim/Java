// Jimmy Liu
// September 28, 2012
// Cylinder.java
// This class of methods calculates the volume and surface area of a cylinder using the radius and height as inputs.

// Class variables
//     radius - radius of the cylinder
//     height - height of the cylinder
//     volume - volume of the cylinder
//     surfacearea - surface area of the cylinder

// Class methods
//     getDimension() - input radius and height from keyboard
//     findSAandV() - calculate the surface area and volume of cylinder
//     printToScreen() - promt results to screen

import java.util.Scanner;

public class Cylinder {
	
	private double radius, height, volume, surfacearea;
	
	public Cylinder() {  // Constructor
}

public Cylinder(double r, double h) { // overloaded constructor
   radius = r;
   height = h;
}

public void getDimension() {
    Scanner console = new Scanner (System.in);
    System.out.print("Enter the radius (a double)\t-->");
    radius = console.nextDouble();
    System.out.print("Enter the height (a double)\t-->");
    height = console.nextDouble();
}  // end getDemension
    
public void findSAandV()  {
	
	volume = Math.PI * Math.pow(radius, 2) * height;
	// surfacearea = 2.0 * Math.PI * radius * height +
	//    2.0 * Math.PI * Math.pow(radius, 2);
	surfacearea = calculateSA();
}  // end findSAandV

private double calculateSA() {
	double sa = 2.0 * Math.PI * radius * height +
	                   2.0 * Math.PI * Math.pow(radius, 2);
	                   return sa;
} // end calculateSA 

public void printToScreen()  {
     	System.out.println("\nCylinder information:");
     	System.out.printf("\nradius\t= %10.4f", radius);
     	System.out.printf("\nheight\t= %10.4f", height);
     	System.out.printf("\nvolume\t= %10.4f", volume);
     	System.out.printf("\nsurface area\t= %10.4f", surfacearea);
     	System.out.println("\n\n");
}  
} // end class Cylinder
