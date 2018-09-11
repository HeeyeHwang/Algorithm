package study._2017.live.coding._171209;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	private static int zeroCnt;
	private static int oneCnt;
	private static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int number = sc.nextInt();
			fibonacciFunction(number);
		}
		
		sc.close();
	}
	
	private static void fibonacciFunction(int number) {
	
		zeroCnt = 0;
		oneCnt = 0;
		count = 0;
		int[] save = new int[40];
		for(int i = 0 ; i < 40 ; i++) {
			save[i] = -1;
		}
		
		int fi=fibonacci(number, save);
		System.out.println(zeroCnt + " " + oneCnt);
	}
	
	private static int fibonacci(int n, int[] save) {
		
		if(n == 0) {
			save[n] = 0;
			zeroCnt++;
//			System.out.println("zero!" + zeroCnt);
			return 0;
		} else if(n == 1) {
			save[1] = 1;
			oneCnt++;
//			System.out.println("one!" + oneCnt);
			return 1;
		} else {

			if(save[n] < 0) {
				save[n] = fibonacci(n-1, save) + fibonacci(n-2, save);
				System.out.println(n+"~~ count : " + Arrays.toString(save));
			}
			
			return save[n];
		}
	}
}
