/// Mr Greenstein
// November 22, 2012
// DogInheritance2.java
// This program is an example of inheritance.
// Topics:
//		1) Use of "super" reserved word for constructors
//		2) Overload method
//		3) Making superclass "abstract"

public class DogInheritance {
 	public static void main (String [] args) {
 		Tabby t = new Tabby();
 		t.printS();
 	}	// end main
 }	// end class DogInheritance
 

abstract class Dog {// and abstract class cannot be instantiated
	protected String name, noise, eats;
	protected String activity;

	public Dog() { eats = "beef"; }
	
	public void SetName (String name) { this.name = name; }

	public void SetNoise () { noise = "Howl"; }
	
	public void SetNoise (String noise) { this.noise = noise ; }//this is a self referential pointer
	
	public void Noise () { System.out.println(noise + " " + noise); }
	
	public void CallDog () { System.out.println("Come here " + name); }
	
	public void WhatToEat () { System.out.println("Would you like some " + eats + "?"); }

	public void FavoriteActivity ()
		{ System.out.println("Let's go out to play " + activity); }

}
abstract class Cat{
	String sound, activity, lazinessLevel, clawLength, eats;
	public Cat(){
		sound = "purrr";
		activity  = "ripping thread to shread";
		lazinessLevel = "Very Lazy";
		clawLength  = "Over 9,000";
		eats = "milk and cookies";
	}
	public void printS(){
		System.out.println(sound + activity + lazinessLevel + clawLength + eats);
	}
}
class Poodle extends Dog {
	public Poodle () {
		super(); //super gives the ability to call methods and/or constructors from the super class
		//super points to the PARENT CLASS
		eats = "filet minion"; 
		//activity = "fetch";
	}
	
	public void SetNoise() { noise = "Whoosh"; }
	public void SetNoise(String noise){
		this.noise = noise;
	}
	
}	// end class Poodle

// Exercise:
//		- Create an abstract class "Cat"
//		- Create a constructor and two methods for Cat class
//		- Create a subclass for Cat (e.g. "Persian")
//		- Override one of the Cat methods in your subclass


	class Tabby extends Cat{
		public Tabby(){
			super();
			lazinessLevel = "not very";
			clawLength = "less that u";
			
		}
		public void printS(){
			System.out.println("fun");
		}
	}
