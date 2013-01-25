// Mr Greenstein
// November 22, 2012
// DogInheritance.java
// This program is an example of inheritance.
// Topics:
//	1. Use "super: reserved word for constructors
//	2. Overload method
// 	3. Make superclass "abstract"
//	4. Protected and private

public class DogInheritance2 {
 	public static void main (String [] args) {
		// Example 1: Create Dog class and use it
/*
 		Dog dog1 = new Dog();
 		Dog dog2 = new Dog();
 		dog1.SetName( "Rover" );
 		dog1.SetNoise( "Woof" );
 		
 		dog1.CallDog();
 		dog1.Noise();
 		dog1.WhatToEat();
 		dog1.FavoriteActivity();
*/
		// Example 2: Create Poodle class that extends Dog and use it 		
 		Poodle noodle = new Poodle();
 		noodle.SetName("Frenchie");
 		noodle.SetNoise("Bark");
 		noodle.CallDog();
 		noodle.Noise();
 		noodle.WhatToEat();
 		noodle.FavoriteActivity();
 		
 		Jeffrey jeffrey = new Jeffrey();
 		jeffrey.SetName("Jeffrey");
 		jeffrey.SetNoise("OINK");
 		jeffrey.CallDog();
 		jeffrey.Noise();
 		jeffrey.WhatToEat();
 		jeffrey.JeffreyPlay();
 	}	// end main
 }	// end class DogInheritance
 
 
abstract class Dog {
	protected String name, noise, eats;
	protected String activity;
	
	public Dog() { 
		activity = "fetch";
		eats = "beef";
		 }
	
	public void SetName (String name) { this.name = name; }
	
	public void SetNoise (String noise) { this.noise = noise; }
	
	public void Noise () { System.out.println(noise + " " + noise); }
	
	public void CallDog () { System.out.println("Come here " + name); }
	
	public void WhatToEat () { System.out.println("Would you like some " + eats + "?"); }
	
	public void FavoriteActivity () { System.out.println("Let's go out to play " + activity); }
	
	public void JeffreyPlay () { System.out.println("Let's go " + activity); }
}


class Poodle extends Dog {
	public Poodle () { 
		super();
		super.SetNoise("pant");
		eats = "filet minion"; 
		//activity = "fetch";
		}
	
	public void SetNoise() { noise = "Whoosh"; }	// Override method
	public void SetNoise(String noise) { this.noise = noise; }
}	// end class Poodle

class Jeffrey extends Dog {
	public Jeffrey () {
		super();
		eats = "Hamster Food";
		activity = "Trolling and Annoying";
	}
	
	public void SetNoise() { noise = "Whoosh"; } 
}
// Exercise:
//		- Create another class (breed) that extends the Dog class
//		- Create a constructor and one method for that class
