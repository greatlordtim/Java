//Anindit Gopalakrishnan
//November 5, 2012
//StringExample.java
//This program will display examples of String declaration, intialization, and methods.

public class StringExample{
	public static void main(String[] args){
		String str1 = new String("name");
		String str2 = "name";
		if (str1 == str2){
			System.out.println("They r =");
		}	
		else {
			System.out.println("They r !=");
		}
		if (str1.equals(str2)){
			System.out.println("You win");
		}
		else {
			System.out.println("I loose");
		}
		String str4 = "Good Bye New Jersey?";
		 
		 
		 
		 int spaceIndex = str4.indexOf(' ');
		 String sub1 = str4.substring(spaceIndex);
		 System.out.println("sub1 = *" + sub1 + "*");
		 String sub2 = str4.substring(0,spaceIndex);
		 System.out.println("sub2 = *" + sub2 + "*");
		
		String str5 = ("                                    Vote on election day                          ");
		System.out.println("str5.trim = *" + str5.trim() + "*"); 
		String str6 = ("Anindit");
		str7 = str6 - 't';
	}
}
