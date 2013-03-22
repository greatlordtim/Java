//Anindit Gopalakrishnan
//October 17, 2012
//Main.java
//This program creates an object of the Rolls type, and uses that to get
//information from the user to roll an imaginary dice.
public class Main{
	
	public static void main ( String [] args ){
       Rolls loop = new Rolls ( );
       loop.GetInfo ( );
       loop.RollTheDice ( );
       loop.ShowResults ( );
	}
}
