package swexpert;

import java.util.Scanner;

public class Solution_181017_square {

	static int N;
	static int M;
	
	public static int doubleSquare() {

		if(M == 0) {
			return 1;
		} else {
			M--;
			return N * doubleSquare();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = 0;
		for(int i = 0 ; i < 10 ; i++) {
			
			test = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.printf("#%d %d\n", i+1, doubleSquare());
		}
		
		
		sc.close();
	}
}
