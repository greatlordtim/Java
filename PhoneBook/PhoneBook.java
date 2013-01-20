import java.util.Scanner;

public class PhoneBook {
	public String name, city, phone;
	private int areacode;
	Scanner input = new Scanner ( System.in );
	
public PhoneBook () {

	name = new String ("Thomas Jefferson");
	city = new String ("New York");
	phone = new String ("123-4567");
	areacode=408;
	
	
	
	}
public static void main (String [] args) {
	PhoneBook book = new PhoneBook ();
	book.GetInput();
	book.ProcessInputAndPrint();
	}
public void GetInput() {
	System.out.print ("Enter name as first last:");
	name = input.nextLine();
	System.out.print ("\nEnter city of residence:");
	city = input.nextLine();
	System.out.print ("\nEnter phone number (without area code):");
	phone = input.nextLine();
}
public void ProcessInputAndPrint() {
 System.out.print("\n\nThe phone number will be alphabetized under ");
 char derp = name.charAt(0);
 System.out.print (derp + ", under ");
 int derp1 = name.indexOf(' ');
 String derp2 = new String ();
 String derp3 = new String ();
 derp2 = name.substring(0, derp1);
 derp3 = name.substring(derp1);
 System.out.print (derp3 + " " + derp2 + " at ");
 if ((city.equals("Cupertino")) || (city.equals("San Jose"))){
	 System.out.print ("(408) " + phone + ".\n");
	 }
 else {
	System.out.print ("(650) " + phone + ".\n");
	 }





}


}