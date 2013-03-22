//HelloWorldWriteRead.java
//This program writes "Hello world!" to a text file "output.txt". 
//then it reads the file and prits the contents to the screen

import java.io.File;
import java.io.IOException; //Exception is synonomus with error.
//dangerous programming: dealing with files, do something different - something not
//assured to go correctly
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

//try-catch - if it works, do the stuff under try, if it doesn't work, do the catch
public class HelloWorldWriteRead {
	private Scanner scan;
    private	File iofile; //file object for "output.txt"
	private  PrintWriter output;// -PrintWriter object to print text to a file
	public static void main (String args[]) {		
		HelloWorldWriteRead hwwr = new HelloWorldWriteRead();
		hwwr.WriteIt();
		hwwr.ReadIt();
	}
	public HelloWorldWriteRead(){
		iofile = new File("Output.java"); //ctually create a file
	}
	public void WriteIt(){ // Opents output.txt file and prints "Hello World" to it
		try{
			output = new PrintWriter(iofile); //opens a file to write to it
		}
		catch(IOException e) { //e contains the information if there is an error
			System.err.println("ERROR: Cannot open file output.txt");//prints out the error - works just like System.out.println
			System.exit(1);//Gracefull way to exit the program, but does not exit when the
			//program is working properly. 1 - something was wrong when exit, 0 - nothing wrong  (Anything other than 0 means
			//there is a problem)
		}
		output.println("public class Output{");
		output.println("public static void main(String[] args)");
		output.println("{int a = 1; System.out.println(a);}");
		output.println("}");
		output.close(); //guarantees that your data will not  be comprimised
	}
	public void ReadIt(){
		try{
			scan = new Scanner(iofile);
		} catch(FileNotFoundException e){
			System.err.println("ERROR: Cannot open file output.txt");
		}
		while(scan.hasNext()){
			System.out.println(scan.nextLine());
		}
		scan.close();
	}
}
