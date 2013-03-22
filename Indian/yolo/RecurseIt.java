
public class RecurseIt {
	public static void main (String args[]) {		
		RecurseIt r = new RecurseIt();
			int x = 4;

		r.countUp(7);
		int sumof4 = r.sum(4);
		System.out.println(sumof4);
	}
	public void countUp(int i ){
		if (i > 1){
			countUp(i-1);
			
		}
		
			System.out.println(i);
		
	}
	public int sum(int i){
		if (i > 0) i+=(sum(i-1));
		return i;
	}
}
