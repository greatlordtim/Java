public class boolTest4 {
public static void main (String [] args) {
char math = 'A', biology = 'B', english = 'A';
//Average is a A if 2 of the 3 grades are As
boolean comb1 = (math == 'A') && (biology == 'A');
boolean comb2 = (math == 'A') && (english == 'A');
boolean comb3 = (biology == 'A') && (english == 'A');
if (comb1 || comb2 || comb3)
System.out.println("Aveerage is a A");
else
System.out.println("Average is not a A");

}
}


// String str = kb.nextLine();
//char ch - str.charAt(#);
//if (str == "I")
//charAt(n)

 //char ch = kb.nextLine().charAt(#);
