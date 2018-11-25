package baekjoon;

import java.util.Scanner;

public class P9461_WaveSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		int[] inArr = new int[testcase];
		for(int i = 0 ; i < testcase ; i++) {
			inArr[i] = sc.nextInt();
		}

		for(int i = 0 ; i < testcase ; i++) {
			waveSequence(inArr[i]);
		}
		
		sc.close();
	}
	
	private static void waveSequence(int n ) {
		// dp[i] = dp[i-2] + d[i-3] ( i >= 3)
		// 		 = 1 ( i < 3 )
		
		long[] dp = new long[n];
		
		for(int i = 0 ; i < n ; i++) {
			
			if( i < 3) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i-2] + dp[i-3];
			}
		}
		
		System.out.println(dp[n-1]);
	}
}
