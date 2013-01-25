// Jimmy Liu
// December 4, 2012
// Swap.java
// This program orders a list of numbers.

import java.util.Scanner;

public class Swap {
	private static int[] a;
	private static int c = 0;
	
	public static void main(String[] args) {
		Scanner heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy = new Scanner(System.in);
		a = new int[8];
        for (int i = 0; i < 8; i++) a[i] = (int) Math.ceil(Math.random()*100);
		System.out.println("Welcome to the Game of SWAP! Here is your array of 8 integers:");
		DoStuff();
		while (!CheckSorted()) {
			int q, w;
			q = w = 0;
			while (q > 8 || q < 1) {
				System.out.print("Enter an index value to swap:\t\t");
				q = heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy.nextInt();
			}
			while (w > 8 || w < 1) {
				System.out.print("Enter another index value to swap:\t");
				w = heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy.nextInt();
			}
			Swapper(q,w); c++; DoStuff();
		}
		System.out.println("Good work! Your array is in order, and it took "+c+" swaps.");
	}
	
	private static void DoStuff() {
        for (int i = 1; i <= 8; i++)
    		System.out.printf("%-4d",i);
		System.out.println();
		for (int i = 0; i < a.length; i++)
    		System.out.printf("%-4d",a[i]);
		System.out.println();
	}
	
	public static void Swapper(int i, int j) {
		i--; j--;
		int x = a[i];
		int y = a[i] = a[j];
		a[j] = x;
	}
	
	public static boolean CheckSorted() {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i-1]) return false;
		return true;
	}
}
