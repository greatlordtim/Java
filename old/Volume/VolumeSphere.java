// Jimmy Liu
// Septermber 26, 2012
// VolumeSphere.java
// This program will take a double number from the keyboard and use it as the radius to calculate the volume of sphere

import java.util.Scanner;

public class VolumeSphere  {
	
	public static void main (String [] args) {
		
		double radius; // radius of the sphere
		double volume; // volume of the sphere
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the radius of the sphere -> ");
		radius = keyboard.nextDouble();
		
		// volume = (4.0/3.0) * 3.1415926 * radius * radius * radius;
		volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3); 
		
		System.out.println ("\n\nVolume = " + volume);
	}  // end main
	
}  // end VolumeSphere
