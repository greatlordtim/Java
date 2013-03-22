import java.util.Scanner;
public class MovingYarn{
	int rightLimit200;
	int leftLimit =0;
	public static void main(String[] args){
			Scanner scan = new Scanner(System.in);

		int spaces = 10;
		String s ="";
		while (true){
			for (int i= 0; i < spaces; i ++){
				System.out.print("");
				s = scan.nextLine();
			
				
			}
			System.out.print("o");
			if (s.equals("a")){
					if (spaces >= 0){
						spaces --;
					}
				}
				else if (s.equals("d")){
					if (spaces <= 20){
						spaces ++;
					}
				}
		}
	
	
	
	}
	
	




}
