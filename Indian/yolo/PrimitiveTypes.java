//Anindit Gopalakrishnan
//September 7, 2012
//PrimitiveTypes.java
//This program will utilize some of the primitive types in the java programming language.

public class PrimitiveTypes {

	public static void main (String args[]) {		
		byte b = 21;
		short sh = 3;
		int i = -34;
		long el = 287;
		float f = (float) -2.315;
		double d = 345.123;
		char s = 's';
		char t = 't';
		char a = 'a';
		char r = 'r';
		char m = 'm';
		char n = 'n';
		boolean bool = true;
		long ans1 = (sh-i)*b;
		long ans2 = sh-i*el;
		long ans3 = el/(sh+i);
		double ans4 = f/d;
		double ans5 = d/(f-2.13);
		double hold1 = ans1/(i+1);
		double hold2 = (ans4/f - 1);
		double hold3 = i + ans2*(hold1 - ans3 + hold2);
		double ans6 = hold3/d;
		System.out.println("ans1 = " + ans1);
		System.out.println("ans2 = " + ans2);
		System.out.println("ans3 = " + ans3);
		System.out.println("ans4 = " + ans4);
		System.out.println("ans5 = " + ans5);
		System.out.println("ans6 = " + ans6);
		System.out.println("mighty " + s  + t  + a + r + m + a + n);
		
	
		
	}
}
