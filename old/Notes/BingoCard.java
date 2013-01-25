 public class BingoCard {
 private int[][] myCard ;
 	 /** * Constructor for BingoCard objects 
 	  * * Initialize the 2-dim array myCard 
 	  * * Each column must have 5 different, randomly selected numbers 
 	  * * Col 1 numbers must be from 1 to 15 inclusive 
	  * * Col 2 numbers must be from 16 to 30 inclusive 
	  * * Col 3 numbers must be from 31 to 45 inclusive, ignore the free spot for now 
	  * * Col 4 numbers must be from 46 to 60 inclusive 
	  * * Col 5 numbers must be from 61 to 75 inclusive */ 
	public BingoCard() {
	myCard = new int[5][5]; 
	for(int r = 0; r < myCard.length; r++) { 
		for(int c = 0; c <myCard.length; c++) { 
		myCard[r][c] = (int)(r*15+1+Math.random()*15);
		 if(c > 0) {
			for(int prevsc = 0; prevsc < c; prevsc++) {
				 while(myCard[r][prevsc] == myCard[r][c]) { 
				 	myCard[r][c] = (int)(r*15+1+Math.random()*15) ; 
				 	}
				 } 
			}
		 }
	 }
  }
}
