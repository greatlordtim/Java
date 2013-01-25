// Mr Greenstein
// November 30, 2012
// RecurseIt.java
// This program provides examples of recursion.

public class RecurseIt {
	public static void main (String [] args) {
		RecurseIt ri = new RecurseIt();
		ri.CountDown(4);	
		System.out.println();
		ri.CountUp(4);
		System.out.println("Sum(4) = " + ri.Sum(90));
		}
	
	public void CountDown(int i) {
		System.out.print(i + " ");
		if (i > 1) {
			CountDown(i - 1);
		}
	}
	public void CountUp(int i) {
		if (i > 1) {
			CountUp(i - 1);
			}
		System.out.print(i + " ");
	}
	public int Sum(int i) {
		if (i == 1) {
			return (1);
		}
		else { 
			return (i + Sum(i - 1 ));
		}
	}	
}
