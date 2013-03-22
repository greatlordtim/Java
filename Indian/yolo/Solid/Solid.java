public abstract class Solid{
	
	private double surfaceArea, volume;
	public Solid(){
		surfaceArea = volume = 0;
	}
	
	// Set the Solid's Surface Area
	public void setSurfaceArea(double surfaceArea) { this.surfaceArea = surfaceArea; }
		// Set the Solid’s Volume
	public void SetVolume(double volume) { this.volume = volume;  }
	// Returns the Solid’s Surface Area
	public double GetSurfaceArea() { return surfaceArea; }
	// Returns the Solid’s Volume
	public double GetVolume() { return volume;  }
}
