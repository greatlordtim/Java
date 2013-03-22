

public class TwoDArray {
	int [][] table;
	int tabl2[][] =  {{0,1,2,3,4} , 
				  {5,6,7,8,9,10,11} ,
				  {12,13,14,15,16}
				};
	public static void main (String args[]) {		
		TwoDArray tda = new TwoDArray();
		tda.run();
	}
	public void run(){
		table = new int [5][5];
		for (int row = 0; row < 5; row++){
			for  (int col = 0; col < 5; col++){
				table[row][col] = row + col;
			}
		}
		PrintTable(table);
		System.out.println("\n\n\n\n");
		PrintTable(tabl2);
	}
	public void PrintTable( int [][] t){
		for (int row = 0; row < t.length; row++){
			for (int col = 0; col < t[row].length; col++){
				System.out.printf("%4d", t[row][col]);
			}
			System.out.println();
		}
	}
}
