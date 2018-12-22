package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2294_coin2 {

	static int n;
	static int k;
	static int[] coins;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		coins = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			coins[i] = sc.nextInt();
		}
		coin2();
		sc.close();
	}
	
	
	private static void coin2() {
	
		Arrays.sort(coins);
		int[] dp = new int[k+1]; // dp is defined as the minimum count making k for n's coins;
		
		dp[0] = 0;
		
		for(int i = 1 ; i <= k ; i++) {
			
			if(i < coins[0]) {
				dp[i] = 0;
				continue;
			}
			
			
//			System.out.println("==========================i : " + i +"원 만들기!=====");
			int min = Integer.MAX_VALUE;
			int own = Integer.MAX_VALUE;
			for(int j = 0 ; j < n ; j++) {
				
				int cost = coins[j];
				if(i-cost < 0) {
//					System.out.println("continue i-cost!!");
					continue; // or break;
				} else {
					
					if(i-cost == 0) {
//						System.out.printf("i-cost == 0 case. i : %d, cost :%d\n",i , cost);
						own = 1;
						break;
					} else {
						if(dp[i-cost] == 0) {
//							System.out.println("skip...");
							continue;
						} else {
							if(min > dp[i-cost] + 1) {
								min = dp[i-cost] + 1;
							}
//							System.out.println("final min . " +min);
						}
					}
					
				}
			}
			
			dp[i] =Math.min(own, min);
			
			if(dp[i] == Integer.MAX_VALUE) {
				dp[i] = 0;
			}
			
//			System.out.printf("\ndp[%d] : %s\n", i, Arrays.toString(dp));
		}
	
		
		if(dp[k] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}
