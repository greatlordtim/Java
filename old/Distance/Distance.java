// Jimmy Liu
// October 1, 2012
// Distance.java
// This program computes the distance between two points

// Class variables
//     x1 - the x value of the first cordinate
//     x2 - the x value of the second cordinate
//     y1 - the y value of the first cordinate
//     y2 - the y value of the second cordinate

// Class methods
//     DisplayPoints() - prints results to screen
//     ShowDistance() - prints results to screen
//     Vertical() - returns the vertical distance between points
//     Horizontal() - returns the horizontal distance between points

        public class Distance   {
      	private double x1, y1, x2, y2;
        public Distance (double xone, double yone, double xtwo, double ytwo) {
        x1 = xone;
        x2 = xtwo;
      	y1 = yone;
      	y2 = ytwo; 
      	}
        public double Vertical() {
        	double v = Math.abs(y1-y2);
        	return v;
		}
		public double Horizontal() {
			double h = Math.abs(x1-x2);
			return h;
		}
		public void DisplayPoints() {
			System.out.printf("\n(%.2f, %.2f), (%.2f, %.2f)", x1, y1, x2, y2);
			}
		public void ShowDistance() {
			double dist = Math.sqrt(Math.pow(Horizontal(), 2)+ Math.pow(Vertical(), 2)) ;
            System.out.printf("\n Total Distance = %.2f\n", dist);
	 	}
} 
