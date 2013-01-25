// Jimmy Liu
// September 6, 2012
// TestTypes.java
// This program will exercise print characters, computate math, and define variables. 

public class TestTypes {
	public static void main (String [] args) {
	 byte b; // -128 to 127 (8 bits or 1 byte)
	b = 21;         
// end byte

    short sh;
    sh = 3;
// end short
 
    int i;
    i = -34;
// end int

    long el;
    el = 287;
// end long

    float f;
    f = (float)-2.315;
// end float

    double d;
    d = 345.123;
// end double

    char s;
    char t;
    char a;
    char r;
    char m;
    char n;
    char z;
    
    s = 115;
    t = 116;
    a = 97;
    r = 114;
    m = 109;
    n = 110;
    z = 32;
    
// end char

    boolean bool;
    bool = true;

// end bool

long ans1 = (sh - i) * b;
System.out.println("ans1=" + ans1);

//end ans1

long ans2 = sh - i * el;
System.out.println("ans2=" + ans2);

//end ans2

long ans3 = el / (sh + i);
System.out.println("ans3=" + ans3);

//end ans3

double ans4 = f / d;
System.out.println("ans4=" + ans4);

//end ans4

double ans5 = d / (f - 2.13);
System.out.println("ans5=" + ans5);

//end ans5

double ans6 = (i+ans2*((ans1/(i+1)) - ans3 + ((ans4/f)-1)))/d;
System.out.println("ans6=" + ans6);

//end ans6

System.out.println("mighty" + z + s + t + a + r + m + a + n);

//end mighty starman

	} // end main
} //end class TestTypes
