import java.lang.Math;

public class Cylinder extends Solid{
	double radius;
	double height;
	public Cylinder(){
		radius = height = 0;
	}
	
	// Sets the radius value of the Cylinder’s base given an integer value
	public void SetRadius(int radius) { this.radius = radius;}
	// Sets the radius value of the Cylinder’s base given a double value
	public void SetRadius(double radius) { this.radius = radius; }
	// Sets the height of the Cylinder given an integer value
	public void SetHeight(int height) { this.height = height; }
	// Sets the height of the Cylinder given a double value
	public void SetHeight(double height) { this.height= height; }
	// Calculates the Cylinder’s surface area
	public void CalcSurfaceArea() { super.setSurfaceArea(2*Math.PI*radius*(radius + height)); }
	// Calculates the Cylinder’s volume
	public void CalcVolume() { super.SetVolume(Math.PI *radius*radius*height );}





}
