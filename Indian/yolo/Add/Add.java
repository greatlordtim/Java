//Anindit Gopalakrishnan
//October 24 2012
//Add.java
//This program will create an addition table, with the width and
//height defined by the user. It can have up to 30 rows and 12 columns,
//but no fewer than 2 rows or columns.

//Class Methods:
//public Add(): In the constructer, I initialize row and column to the min.
//              values that work. I also initialize the scanner.
//public void GetRows(): In this mehtod, I get the number of rows that the user
//                       wants for his addition table using a while loop.
//public void GetColumns(): In this method, I get the number of colums that the user wants
//                          for his addition table using a do-while loop.
//public void PrintAddTable(): In this method, I use a series of for-loops to print the
//                             addition table.

//Class Variables:
//private int row: This int holds the number of rows that the user enters.
//private int column: this int holds the number of columns that the user enters.
//private int spaces: this int holds the width, in spaces, off the add table.
import java.util.Scanner;
public class Add{
	Scanner scan;
	private int row, column;
	public static void main ( String [] args ){
       Add table = new Add ( );
       table.GetRows ( );
       table.GetColumns ( );
       table.PrintAddTable ( );
	}
	public Add(){
	
		row = 2;
		column = 2;
		scan = new Scanner(System.in);
	
	}
	
 	public void GetRows(){
		System.out.println("\n\n");
		do{
			System.out.print("Enter the number of rows to be shown ( 2 - 30 )        ->   ");
			row = scan.nextInt();
		}
		while (!((row>=2) && (row <= 30)));
 
 	}
 	public void GetColumns(){
		do{
			System.out.print("Enter the number of columns to be shown ( 2 - 12 )     ->   ");
			column = scan.nextInt();
		
		}
		while(!((column>=2) && (column <= 12)));
	
	
	}
	public void PrintAddTable(){
		System.out.println("\nHere is your table: \n");
		System.out.print("     |     ");
		int count = 0;
		while (count<column){
			System.out.printf("%-5d", (count+1));
			count++;
		}
		int spaces = 11 + 5*(column-1) + 2;
		System.out.println();
		for (int i = 0; i < spaces; i++){
			System.out.print("-");
		
		}
		System.out.println();
		for(int i = 1; i <= row; i ++){
			
			System.out.printf("%-4d %s     ", i, "|") ;
			for (int j = 1; j <= column; j++){
				System.out.printf("%-5d", (j+i));
			}
			System.out.println();
		}	
		System.out.println("\n\n");
	
	}






}
