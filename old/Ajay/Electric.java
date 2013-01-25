// Jimmy Liu
// October 17, 2012
// Electric.java
// This program computes data from the user, telling them about their electric bill, depending on their usage and customer type.

// Class Variables
// 	info - the type of customer the user is
// 	cost - how much it costs the customer
// 	offpeak - the ammount of offpeak usage for the customer
// 	elec - the peak or regular number of hours for the customer

// 	Class methods  
// 	GetData() - Get's the data from the user
// 	CalculateCost() - Calculate the cost
// 	PrintInfo() - Print the info on the screen

import java.util.Scanner;

public class Electric {
	char info;
	double cost;
	double offpeak, elec;
	public Electric() {  // Constructor
}

public void GetData () {
	Scanner input = new Scanner (System.in);
	System.out.print ("Enter the type of electric bill, R for residential, C for commercial, I for indusctrial --> ");
		info = input.nextLine().charAt(0);
	if ( (info == 'R') || (info == 'C')) {
		System.out.print ("Enter the number of kilowatt hours of electricity used --> ");
			elec = input.nextDouble (); }
	else if (info == 'I') {
    	System.out.print ("Enter the number of kilowatt hours of electricity used during peak hours --> ");
			elec = input.nextDouble ();
		System.out.print ("Enter the number of kilowatt hours of electricity used during off-peak hours --> ");
			offpeak = input.nextDouble (); 
		}
    else {
        System.out.printf ("Error, please try again. \n ");
        }
	}
	
	
public void CalculateCost () {
	if (info == 'R')
		cost = 12.00 * 0.095;
	if (info == 'C')
		cost = 120.00;
			if (elec > 1000)
				cost = cost + ((elec - 1000) * 0.083);
	if (info == 'I')
		cost = 152.00;
			if (elec > 1000)
				cost = cost + ((elec -1000) * 0.109);
	    if (offpeak > 0)
	    	cost = cost + 108;
	    		if (offpeak > 1000)
	    			cost = cost + ((offpeak - 1000) * 0.047);

}
public void PrintInfo () { 
	if (info == 'R') {
		System.out.printf ("\nResidential Billing\n\n");
		System.out.printf ("Peak hours: %16.2f\n", elec);
		System.out.printf ("Total Cost: $%15.2f\n", cost); }
	if (info == 'C'){
    	System.out.printf ("\nCommercial: Billing\n\n");
    	System.out.printf ("Peak hours: %16.2f\n", elec);
    	System.out.printf ("Total Cost: $%15.2f\n", cost);
	}
	if (info == 'I') {
    	System.out.printf ("\nIndustrial Billing\n\n");
    	System.out.printf ("Peak hours: %16.2f\n", elec);
    	System.out.printf ("Offpeak hours: %13.2f\n", offpeak);
    	System.out.printf ("Total Cost: $%15.2f\n", cost);	
	}
}
} //sexy code opopopop
