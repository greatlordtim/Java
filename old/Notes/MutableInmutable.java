// Jimmy Liu
// November 19, 2012
// MutableImmutable.java
// This program tests how mutable and immutable objects compare.

public class MutableInmutable {
	
	public static void main (String [] args) {
		
		//Create Mutable Objects
		MyObject mo1 = new MyObject();
		MyObject mo2 = mo1;
		System.out.println ("(mo1==mo2) is: " + (mo1==mo2));
		System.out.println ("mo1.a = " + mo1.a);
		System.out.println ("mo2.a = " + mo2.a);
		
		mo1.a = 42;
		System.out.println ("(mo1==mo2) is: " + (mo1==mo2));
		System.out.println ("mo1.a = " + mo1.a);
		System.out.println ("mo2.a = " + mo2.a);
		
		// Create immutable String Objects
		String strA = new String ("This is first string");
		String strB = strA;
		System.out.println ("(strA == strB) is :" + (strA == strB));
		System.out.println ("strA.equals(strB) is: " + strA.equals(strB));
		
		strA = "This is first string";
		System.out.println ("(strA == strB) is :" + (strA == strB));
		System.out.println ("strA.equals(strB) is: " + strA.equals(strB));
		
	}
	
} // end class MutableImmutable

// A mutable class
class MyObject {
	public int a;
	
	public MyObject () {
		a = 5;
	}
	
}
