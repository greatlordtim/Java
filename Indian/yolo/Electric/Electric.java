//Anindit Gopalakrishnan
//October 10, 2012
//Electric.java
//This program will provide the class to create a n object that will be
//able to do many things. Among this, it will get data from a user, 
//calculate the cost of electricity, and print out the information.
//It will do all this in a nice, orderly manner.

//Class Variables:
//private Scanner scan: this is a scanner object used to get info from user
//private String whichBill: this is the string which holds the information that 
//			      			holds the type of bill it is. The value R stands for 
//                  		residential, I for industrial, and c for commercial
//private boolean validValue: this boolean holds a true/false value which returns
//                            whether or not if the string entered is valid.
//private double kwHoursPeak: This double holds the number of kilowatt hours used during 
//                            peak hours, or in general if not industrial.
//private double kwHoursOffPeak: This double holds the number of kilowatt hours used during
//                               of peak hours
//private double cost: This double holds the total cost for the electric bill. 
//private String fullBillName: This string holds the full name of the type of bill.
//private boolean industrial: this boolean holds the information that sets it to industrial or not.


//Class Methods: 
// public void GetData(): this method will get the data required to compute the bill
//                 		  cost. In the case of industrial being entered, a special 
//                 		  prompt will pop up for peak hours and off-peak hours.
// public void CalculateCost(): This method, when called, calculates the cost of the bill 
//                              based on the type of the bill.
//public void PrintInfo(): Thsi mthod, when called, prints the data gathered abd
//                         calculated.








import java.util.Scanner;
public class Electric{
	
	private Scanner scan;
	private String whichBill;
	private	boolean validValue = false;
	private double kwHoursPeak;
	private double kwHoursOffPeak;
	private double cost; 
	private String fullBillName;
	private boolean industrial = false;
	
	public Electric(){
		scan = new Scanner(System.in);
	}
	public void GetData(){
		System.out.print("\n\nEnter the type of electric bill, R for residential, C for comercial, I for industrial -> ");
		while (!validValue){
			whichBill =	scan.next();
			if (whichBill.equals("C") || whichBill.equals("I") || whichBill.equals("R")){
				validValue = true;
			}
			else {
				System.out.println("Error, please try again");
			}
		}
		if (whichBill.equals("C") || whichBill.equals("R")){
			System.out.print("Enter the number of kilowatt hours of electricity used                                -> "); 
			kwHoursPeak = scan.nextDouble();
			industrial = false;
			
		}
		else if (whichBill.equals("I")){
			System.out.print("Enter the number of kilowatt hours of electricity used during peak hours              -> ");
			kwHoursPeak = scan.nextDouble();
			System.out.print("Enter the number of kilowatt hours of electricity used during off-peak hours          -> ");
			kwHoursOffPeak = scan.nextDouble();
			industrial = true;
		}
	
			
	}
	public void CalculateCost(){
		if (whichBill.equals("R")){
			cost = 12 + 0.095*kwHoursPeak;	
			fullBillName = "Residential";
			
		}
		else if  (whichBill.equals("C")){
			fullBillName = "Commercial";
			boolean over1k = (1000-kwHoursPeak) < 0;
			if (over1k){
				double amountOver1k = kwHoursPeak - 1000;
				cost = 120 + (0.083*amountOver1k);
				
			}
			else {
				cost =120;
			
			}
		}
		else if (whichBill.equals("I")){
			fullBillName = "Industrial";
			boolean over1k = (1000-kwHoursPeak) < 0;
			if (over1k){
				double amountOver1k = kwHoursPeak - 1000;
				cost = 152 + (0.109*amountOver1k);
				
			}
			else {
				cost =152;
			
			}
			boolean over1kOffPeak = (1000-kwHoursOffPeak) < 0;

			if (over1kOffPeak){
				double amountOver1kOffPeak = kwHoursOffPeak - 1000;
				cost = cost + 108 + (0.047*amountOver1kOffPeak);
				
			}
			else {
				cost = cost + 108;
			
			}
			
		}	
		
	}
	public void PrintInfo(){
		if (!industrial){
			System.out.println("\n\n" + fullBillName + " Bill");
			System.out.printf("\nPeak Hours %13.2f", kwHoursPeak);
			System.out.printf("\nCost            $ %6.2f\n\n", cost);
		}
		else {
			System.out.println("\n\n" + fullBillName + " Bill");
			System.out.printf("\nPeak Hours %13.2f", kwHoursPeak);
			System.out.printf("\nOff-Peak Hours%10.2f", kwHoursOffPeak);
			System.out.printf("\nCost            $ %6.2f\n\n", cost);

		
		}
		
	
	}
	
	
	
	
	
}
