import java.util.*;
public class Bingo {


public static void main(String[] args) 
{
int board[][]= new int [5][5];
Random rand = new Random( );
int row, col;
for( row = 0; row < board[0].length; row++)
{
for( col =0; col < board[0].length; col++)
{
board[row][col] = rand.nextInt( 50) + 1; //range 1 to 50
}

}

for( row = 0; row < board[0].length; row++)
{
for( col =0; col < board[0].length; col++)
{
System.out.print( board[row][col]+" " );
}
System.out.println( );
}


}
}