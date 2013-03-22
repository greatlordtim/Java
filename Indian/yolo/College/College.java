//Anindit Gopalakrishnan
//October 26, 2012
//College.java
//This program will allow the user to create a college scchedule, and pick a different
//math, english, and science.


import java.util.Scanner;
public class College{
	Scanner scan = new Scanner (System.in);
	int E;
	int M;
	int S;
	String schedulePrint = "";
	public static void main (String [] args){
		College UC = new College();
		System.out.println("\n\nWelcome to SCHEDULE CHOOSER");
		UC.getEnglish();
		UC.getMath();
		UC.getScience();
		UC.printSchedule();

	}
	College(){
		
	}

	public void getEnglish(){
		System.out.println("\nHere are four possible English classes:");	
		System.out.println("\t(1) The Literature of Physics - brought to you by professor Netow Issacs");
		System.out.println("\t(2) Sentence Structure and Syle - brought to you by professor G. R. Ammer");
		System.out.println("\t(3) The intricacies of Amazon lit - brought to by professer K. I. Ndle");
		System.out.println("\t(4) Writing for Sports Editors - brought to you by Lei Manning"); 
		System.out.print("\nChose One Class (1-4)     ->    ");
		E = scan.nextInt();
		switch(E){
			case 1:
				schedulePrint += "The Literature of Physics\n"; 
				break;
			case 2:
				schedulePrint += "Sentence Structure and Syle\n";
				break;
			case 3:
				schedulePrint += "The intricacies of Amazon lit\n";
				break;
			case 4:
				schedulePrint += "Writing for Sports Editors\n";
				break;
		}
	}
	public void getMath(){
		System.out.println("\nHere are four possible Math classes:");	
		System.out.println("\t(1) Algebra 3%2 - brought to you by professor Tham I. Fsun");
		System.out.println("\t(2) Trig and its uses in Lit - brought to you by professor Tea. C. I. Sboring");
		System.out.println("\t(3) Geometry of Poets - brought to by professor K. Daily");
		System.out.println("\t(4) Trancendental Algebra - brought to you by IDon T. Nkow"); 
		System.out.print("\nChose One Class (1-4)     ->    ");
		M = scan.nextInt();
		switch(M){
			case 1:
				schedulePrint += "Algebra 3%2\n"; 
				break;
			case 2:
				schedulePrint += "Trig and its uses in Lit\n";
				break;
			case 3:
				schedulePrint += "Geometry of Poets\n";
				break;
			case 4:
				schedulePrint += "Trancendental Algebra\n";
				break;
		}

	}
	public void getScience(){
		System.out.println("\nHere are four possible Science classes:");	
		System.out.println("\t(1) Chem for chefs - brought to you by professor Bob Daily");
		System.out.println("\t(2) Biology and its uses in a Classroom - brought to you by professor U. S. Eless");
		System.out.println("\t(3) The Physics of the Mind - brought to by professer Joe Fend");
		System.out.println("\t(4) Computer Science for Bards - brought to you by Lin Wa Shu"); 
		System.out.print("\nChose one Class (1-4)     ->    ");
		S = scan.nextInt();
		switch(S){
			case 1:
				schedulePrint += "Chem for chefs\n"; 
				break;
			case 2:
				schedulePrint += "iology and its uses in a Classroom\n";
				break;
			case 3:
				schedulePrint += "The Physics of the Mind\n";
				break;
			case 4:
				schedulePrint += "Computer Science for Bards\n";
				break;
		}
		


	}
	public void printSchedule(){
		System.out.print("\n\nTHANK YOU, HERE IS YOUR CLASS SCHEDULE:\n\n" + schedulePrint + "\n\n");
		
	}
}

