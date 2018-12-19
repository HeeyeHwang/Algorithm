package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P3190_Snake {
	
	/**
	 * 6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // box size
		int k = sc.nextInt(); // apple count
		sc.nextLine();
		String[] apples = new String[k];
		for(int i = 0 ; i < k ; i++) {
			apples[i] = sc.nextLine();
		}
		
		int l = sc.nextInt();
		sc.nextLine();
		String[] directions = new String[l];
		for(int i = 0 ; i <l ; i++) {
			directions[i] = sc.nextLine();
		}
		
		whenStopTheSnake(n, apples, directions);
		sc.close();
	}
	
	private static void whenStopTheSnake(int n, String[] apples, String[] directions) {

		
	}
}
