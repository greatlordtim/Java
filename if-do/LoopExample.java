// Jimmy Liu
// October 17, 2012
// LoopExample.java
// An example of counting from 1 to 10 using while and do-while loops

public class LoopExample {
	public static void main (String [] args) {
		
		int count;
		
		// while example 
		count = 0;
		System.out.println("\nBefore the loop, count = " + count);
		while (count < 10) {
			// System.out.println("Inside the loop, count =" + count);
			count++; // adds by one, unary operator, same as count = count +1
			// System.out.println("Inside the loop, count =" + count);
		}
		System.out.println("After the loop, count = " + count);
		
		// do-while example
		count = 0;
		System.out.println("\nBefore do-while loop, count =" + count);
		do {
			count ++;
		} while (count < 10 ); // no semicolumn here and you will be screwed
		System.out.println("After do-while loop, count = " + count); // do it always
		
		
		// int i, count;
		// count = 0
		// i = ++count; // if ++ is after the count, then do it to i, then to count
		//System.out.println(count + "\t" + i );
		
	} // end main
	
} // end public 