package study._2017.live.coding._171202;

import java.util.Scanner;

public class BaekFibonacci {

	private static int zeroCnt;
	private static int oneCnt;
	
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
		
		int fi=fibonacci(number);
		System.out.println(zeroCnt + " " + oneCnt);
	}
	
	private static int fibonacci(int n) {
		
		if(n == 0) {
			zeroCnt++;
//			System.out.println("zero!" + zeroCnt);
			return 0;
		} else if(n == 1) {
			oneCnt++;
//			System.out.println("one!" + oneCnt);
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
