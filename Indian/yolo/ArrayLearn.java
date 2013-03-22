
public class ArrayLearn {
	//declaring arrays and memory allocation
	//initializing arrays
	//length of arrays
	//passing Arrays as parameters
	
	public static void main (String args[]) {		
			ArrayLearn al = new ArrayLearn();
			al.Run();
	}
	public void Run(){
		//how to declare an array: 
		//{datatype} [] {name};
		//an array is actaully an array thing DEFINED by java
		//an array lookse like a continous piece of memory, slots
		//to put information into. A character array will have characters in
		//the "slots." the first slot is index 0, etc.
		//counting and indexing are very different - if u were to make an
		//alphabet, it would have z as index 25 <== IMPORTANT
		//{name} = new {datatype}[{INTEGER length of array}]
		//first line declaration, second line MUST be done or no array will be made
		//can combine 2 steps: {datatype} [] {name} = new {datatype}[{INTEGER length of array}]
		//example: char[] alphabet = new char[26];
		//THIS PART JUST ALLOCATES MEMORY - ALL THE DATAYPES IN THE PROGRAM ARE DEFINED AS
		//NULL AT THIS MOMENT!!!!
		char[] alphabet = new char[26]; // when defined, the pointer points to the first index (0).
		int numint = 100;
		int [] integers = new int [numint];
		//how to initialize arrays: 
		for (int i = 0; i < 26;  i ++){
			 alphabet[i] = (char)('a' + i);
		}
		for (int i = 0; i < numint; i ++){
			integers[i]  = i+ 1;
		}
		//length of an array - .length is a java built in function so no parends. theres no method - its a built in function and only
		//works with arrays.
		for (int i = 0; i < alphabet.length; i ++){
			System.out.print(alphabet[i] + " ");
		}
		//passing an array as a parameter: lets say u want to print out the integers but you want to do it in a method.
		System.out.println("\n");
		printArray(integers);
		changeIndex(19 , -1 , integers);
		changeIndex(39, -2 ,integers);
		changeIndex(59,-3,integers);
		System.out.println("\n");
		printArray(integers);
		System.out.println("\n");
		stringReverse("My name is Anindit and I am a nerd");


	}
	public void printArray(int[] iA){
		//something very subtle is going on right now. When I create a storage space like int i = 5;, whats really going on is
		//it creates a memory location called i and stores 5 in there. 
		//code like this would do this:
		//int i = 5;
		//Blah(i)
		//public Blah(int a){
		//if (a > 3) a =7; 
		//}
		//java takes the value of whatever you put in the parameter list and copies it into a PASS BY VALUE storage space. 
		//after the method, pass by value storage space gets thrown into the garbage. Copies info and leaves it alone
		//so when we come back to the program, i will still be 5. YOU DO NOT AFFECT THE PARAMETERS. HOWEVER WITH ARRAYS SOME
		//DIFFERENT STUFF HAPPENS. 
		//int[] i = new int [100];
		//lets just say that the storages are stored 1 - 100;
		//Blah(i);
		//public void Blah(int[] arr){
		//	arr[3] = -4; IN THIS CASE THE ARRAY ACTUALLY CHANGES!!!!!!!@!!!!!!#$!#$!@#~#@#%
		//when u do arrays, and when u parameter it, a pointer named a points to the same place that the reference was pointed to. 
		//so in this case, the POINTER dissapears!@#$!#$!#%!!!!@#%
		//THIS HAPPENS TO ALL OBJECT TYPES
		
			
		//}
		for (int i = 0; i < iA.length; i ++){
			System.out.printf("%4d" , iA[i]);
			if ((i+1)%20 == 0) System.out.println("\n");
		}
		
		
	}
	public void changeIndex(int index, int value, int[] a){
		a[index] = value;
	}
	public void stringReverse(String s){
		char[] a = s.toCharArray();
		for(int i = (a.length -1); i >= 0; i --){
			System.out.print(a[i]);
		}
	}
}
