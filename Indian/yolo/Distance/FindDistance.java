//Anindit Gopalakrishnan
//October 1, 2012
//Distance.java
//This is the given code for the lab Distance.java. The objective of this lab
//is to be able to enter 2 ordered pairs (x,y) and print the distance between them
//using the distance formula. This class contains the main method.
import java.util.Scanner;
public class FindDistance   {
      public static void main ( String [] args )    {
            Scanner input = new Scanner ( System.in);
            double xone, yone, xtwo, ytwo;
            System.out.print ( "\n\n\nEnter x1    -> " );
            xone = input.nextDouble ( );
            System.out.print ( "\nEnter y1   -> " );
            yone = input.nextDouble ( );
            System.out.print ( "\nEnter x2   -> " );
            xtwo = input.nextDouble ( );
            System.out.print ( "\nEnter y2   -> " );
            ytwo = input.nextDouble ( );
            Distance inputdist = new Distance ( xone, yone, xtwo, ytwo );
            System.out.println ( "\n\n" );
            inputdist.DisplayPoints ( );
            System.out.printf ( "\n\nThe vertical distance is :\t%10.2f",
                        inputdist.Vertical ( ) );
            System.out.printf ( "\nThe horizontal distance is:\t%10.2f\n",
                        inputdist.Horizontal ( ));
            inputdist.ShowDistance ( );
      }
}
