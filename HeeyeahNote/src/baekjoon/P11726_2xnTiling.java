package baekjoon;

import java.util.Scanner;

public class P11726_2xnTiling {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(tiling(n));
		sc.close();
	}
	
	private static int tiling(int n ) {
		
		// r[i] = r[i-1] + r[i-2] ( i > 1)
		// r[0] = 1, r[1] = 2
		
		int[] dp = new int[n];
		
		if(n == 1) {
			return 1;
		} else if ( n == 2) {
			return 2;
		}
		
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2 ; i < n ; i++) {
			
			dp[i] = dp[i-1] + dp[i-2];
			
			if(dp[i] > 10007) {
				dp[i] = dp[i] % 10007;
			}
		}
		
		return dp[n-1];
	}
}
