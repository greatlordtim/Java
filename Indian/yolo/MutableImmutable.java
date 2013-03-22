public class MutableImmutable{
	public static void main(String [] args){
		//Create mutable objects
		MyObject mo1 = new MyObject();
		MyObject mo2 = mo1; // two pointers one object.
		System.out.println("mo1 == mo2 is " + (mo1==mo2));
		System.out.println("mo1.a = " + mo1.a); // you can do this because a is public
		System.out.println("mo2.a = " + mo2.a);
		//% mo1 == mo2 true
		//mo1.a = 5;
		//mo2.a = 5;%
		mo1.a = 42;
		System.out.println("mo1 == mo2 is " + (mo1==mo2));
		System.out.println("mo1.a = " + mo1.a); // you can do this because a is public
		System.out.println("mo2.a = " + mo2.a);//alike above
		//% mo1 == mo2 true
		//mo1.a = 42;
		//mo2.a = 42;%
		//This means that a is mutable - when a is asigned something new the object 
		//itself is changed. since and b are pointed at the same objec,t mo2.b changes as well
		String strA = new String("This is first String");
		String strB = strA;
		//At this moment strA and strB and pointed at the same thing.
		System.out.println((strA == strB));
		System.out.println(strA.equals(strB));
		//%true
		//true%
		strA = "This is first String";
		System.out.println((strA == strB));
		System.out.println(strA.equals(strB));
		//%false
		//true%
		//Whenever you touch a string it changes
		
		
	}
}
class MyObject{ //class can only be used inside this class
	//this class cannot have a main program
	public int a;
	public MyObject(){
		a  = 5;
	}

}
