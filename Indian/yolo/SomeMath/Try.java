
import javax.swing.*;
import java.awt.GridLayout;

public class Try {
	public static void main (String args[]) {		
		String getString;
		String s = "";
		String vType = "";
		String vName = "";
		String vNumber = "";
		String equal = "=";
		String space = " ";
		String plus = "+";
		String system = "System.out.println(";
		String endSystem = ");";
		String printString = "";
		String quotes = "\"";
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(7,1));
		JLabel label;
		vNumber = "16";
		s = "(double)34 + (int)'V'/8";


		for(int i  = 0; i < 7; i++){
			if (i == 0){
				vType = "byte";
				vName = "b" + vNumber;

			}
			else if (i == 1){
				vType = "short";
				vName = "s" + vNumber;
				
			}
			else if (i == 2){
				vType = "int";
				vName = "i"+ vNumber;
			
			}
			else if (i == 3){
				vType = "long";
				vName = "l"+ vNumber;
			
			}
			else if (i == 4){
				vType = "char";
				vName =  "c"+ vNumber;
				
			
			}
			else if (i == 5){
				vType = "float";
				vName = "fl"+ vNumber;
			}
			else if (i == 6){
				vType = "double";
				vName = "d"+ vNumber;
			}
			getString = vType + space + vName + space + equal + space + s + ";";
			printString = system + quotes + s + space + quotes  + space + plus + space + vName + space + plus + space + quotes + space + "(" + vType + ")" + quotes + ");";
			System.out.println(getString);
			//System.out.println(printString);
			//System.out.println("(double)45/6 " + vName + " (vName)");
		}
		System.out.println("");
		for(int i  = 0; i < 7; i++){
			
			if (i == 0){
				vType = "byte";
				vName = "b" + vNumber;

			}
			else if (i == 1){
				vType = "short";
				vName = "s" + vNumber;
				
			}
			else if (i == 2){
				vType = "int";
				vName = "i"+ vNumber;
			
			}
			else if (i == 3){
				vType = "long";
				vName = "l"+ vNumber;
			
			}
			else if (i == 4){
				vType = "char";
				vName =  "c"+ vNumber;
				
			
			}
			else if (i == 5){
				vType = "float";
				vName = "fl"+ vNumber;
			}
			else if (i == 6){
				vType = "double";
				vName = "d"+ vNumber;
			}
			getString = vType + space + vName + space + equal + space + s + ";";
			printString = system + quotes + s + space + quotes  + space + plus + space + vName + space + plus + space + quotes + space + "(" + vType + ")" + quotes + ");";
			//System.out.println(getString);
			System.out.println(printString);
			//System.out.println("(double)45/6 " + vName + " (vName)");
		}
		
	}
}
