// Jimmy Liu
// September 6, 2012
// TestTypes.java
// This program will exercise primitive data types, println, and print. 

public class TestTypes {
	public static void main (String [] args) {
	 byte b; // -128 to 127 (8 bits or 1 byte)
	b = -120;
	System.out.println(b);           
	System.out.println("b=" + b);
	System.out.print("b=" + b);
// end byte
	
	short sh; //..from -32768 to 32767(2 bytes)
	int i; // -2147483658 to 2147483648 (4 bytes)
	long l;  // (8 bytes.
//end short int long
    
    sh = 3;
    i = 213;
    l = 3080231;
    //long ans;
    long ans = sh * i +l;
    System.out.println("ans=" + ans);
//end print

    char ch; // ASCII characters
    ch = 'A';
    System.out.println("ch=" + ch);
//end char

    boolean bool; //true or false
    bool = true;
    System.out.println("bool=" + bool);
//end boolean

    float f; // (4 bytes)
    double d; // (8 bytes)
    
    f = (float) 3.1415926;
    d = -23.2234e-4;
    
// end float
    double q = f/d;
    System.out.println("q=" + q);
    
// end test
	} // end main
} //end class TestTypes
