//Anindit Gopalakrishnan
//October 1, 2012
//Distance.java
//This is a seperate class that is called by the FindDistance class. It's
//purpose is to create a "distance object" that can do several different things
//such as to print ordered pairs in a nice way and find the horizontal distance


// class variable declarations:
// private double x1: holds an user entered value for one x coordinate
// private double y1: holds an user entered value for the y coordinate which complements x1
// private double x2: holds an user entered value for the 2nd x coordinate
// private double x2: holds an user entered value for the y coordinate which complements x2

// class methods: 
// public double Vertical(): returns an amount for the vertical distance between the 2 points (y2-y1) : always positive! - 
//							 passed through Math.abs() function
// public double Horizontal(): returns an amount for the horizontal distance between the 2 points (x2-x1) : always positive! - 
//							   passed through the Math.abs function
// private double totalDistance(): returns an amount for the total distance between the points, as given by the distance formula:
// 								   sqrt((x2-x1)^2 + (y2-y1)^2), or, since we have already defined verticalDistance as (y2-y1)
//								   and horizontalDistance as (x2-x1), simply sqrt(verticalDistance^2 + horizontalDistance^2);
//								   The square root operation will come from the Math class.
// public void DisplayPoints(): this method prints the points entered in a nice, ordered pair format
// public void ShowDistance(): this method prints out the total distance as given by the distance formula using the double totalDistance

import java.lang.Math;
public class Distance{

	private double x1;
	private double y1;
	private double x2;
	private double y2;
	
	public Distance(double xCoordinate1, double  yCoordinate1, double xCoordinate2, double yCoordinate2){
		x1 = xCoordinate1;
		y1 = yCoordinate1;
		x2  = xCoordinate2;
		y2 = yCoordinate2;
	}
	
	public double Vertical(){
		double verticalDistance = y2+-y1;
		verticalDistance = Math.abs(verticalDistance);
		return verticalDistance; 
	}
	public double Horizontal(){
		double horizontalDistance = x2-x1;
		horizontalDistance = Math.abs(horizontalDistance);
		return horizontalDistance; 
	}
	private double totalDistance(){
		double verticalDistanceSquared = Math.pow (Vertical(), 2);
		double horizontalDistanceSquared = Math.pow (Horizontal(), 2);
		double theTotalDistance = Math.sqrt(verticalDistanceSquared + horizontalDistanceSquared);
		return theTotalDistance;
	}
	public void DisplayPoints(){
		System.out.printf("( %3.2f, %3.2f),  ( %3.2f, %3.2f)", x1, y1, x2, y2);
	}
	public void ShowDistance(){
		System.out.printf("\nTotal Distance: %-4.2f\n\n", totalDistance());
	}
	
	
	



}
