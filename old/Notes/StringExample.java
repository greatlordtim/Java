// Mr Greenstein
// November 5, 2012
// StringExample.java
// A program to display examples of String declaration, intialization, and methods

public class StringExample {
	
	public static void main (String [] args) {
		
		//Constructing strings string is a object
		String str1 = new String ("name");
		String str2 = "name";
		
		// == vs. equals()
		if (str1 == str2)
			System.out.println("str1 and str2 are equal");
		else 
			System.out.println("str1 and str2 are NOT equal");
			
	if (str1.equals(str2))
			System.out.println("Strings str1 and stre2 are equal");
		else 
			System.out.println("Strings str1 and str2 are not equal");	
	// try: equalsIgnoreCase()
	
	// chatAT()
	String str3 = new String ("Hello World");
    String str4 = "Goodbye New Jersey?";
    char c1 = str3.charAt(6);
    System.out.println("str3.charAt(6) = " + c1);
    
    // length()
    int length4 = str4.length();
    System.out.println("length4 = " + length4);
    System.out.println("str4.charAt(length4 - 1) = " 
    			+ str4.charAt (length4 - 1 ));
    			
    // indexOf()
    int spaceIndex = str4.indexOf(' ');
    System.out.println ("spaceIndex = " + spaceIndex);
    
    //substring ()
    String sub1 = str4.substring(spaceIndex);
    System.out.println ("sub1 = *" + sub1 + "*");
    String sub2 = str4.substring (0, spaceIndex);
    System.out.println("sub2 = *" + sub2 + "*");
    
    // trim ()
    String str5 = "                    Vote on election day             ";
    System.out.println ("str5.trim() = *" + str5.trim() + "*");
    
    // toUpperCase()
    // toLowerCase()
	}
}
