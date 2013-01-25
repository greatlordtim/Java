// DogInheritance.java
// This program is a example of inheritance.
// Topics: 
//	- Subclass Dog
//	- Use of "this" reserved word for an object
//	- Extending the Dog class to Poodle
//	- Overriding methods

public class DogInheritance {
	public static void main (String [] args) {
		Dog dog1 = new Dog();		
		dog1.SetName("Rover");
		System.out.println("Come here " + dog1.GetName());
		Poodle dog2 = new Poodle();
		dog2.SetName("Rainbow Dash");
		Jeffrey dog3 = new Jeffrey();
		dog3.SetName("Jeffrey Zhang");
		System.out.println("Come here " + dog3.GetName());
		
	}
} // end class DogInheritance

class Dog {
	String name, noise, eats;
	
	public Dog () { eats = "beef"; }
	
	public void SetName(String name) { this.name = name; }

	public String GetName() { return name; }
}

class Poodle extends Dog {
	public Poodle () { eats = "Unicorn Meat"; }
}

class Jeffrey extends Dog {
	public Jeffrey () { eats = "POOP"; }
}
