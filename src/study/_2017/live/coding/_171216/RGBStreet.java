package study._2017.live.coding._171216;

import java.util.Arrays;
import java.util.Scanner;

/*recursive + 완전검색 */

public class RGBStreet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] cost = new int[n][3];
		int[][] dp = new int[n][4];
		for(int i = 0 ; i < n ; i++) {
		
			cost[i][0] = sc.nextInt();
			cost[i][1] = sc.nextInt();
			cost[i][2] = sc.nextInt();
			System.out.println(Arrays.toString(cost[i]));
		}

		rgbStreet(n, cost, dp);
	}
	
	private static void rgbStreet(int houseCnt, int[][] costMap, int[][] dp) {
		
		
		for(int i = 0 ; i < houseCnt ; i++) {
			
			for(int j = 0 ; j < 3 ; j++) {
				if(i == 0) {
					dp[i][j] = costMap[i][j];
				} else {
					System.out.println(String.format("i : %d / j : %d / j+1 | 3 : %d / j+2 | 3 : %d", i, j, (j+1) %3, (j+2) %3));
					System.out.println("a :" + costMap[i][(j+1) % 3]);
					System.out.println("b :" + costMap[i][(j+2) %3]);
					dp[i][j] = dp[i-1][j] + Math.min(costMap[i][(j+1) % 3], costMap[i][(j+2) %3]);
					System.out.println("dp[i-1][j] :"+ dp[i-1][j]);
					System.out.println("최소값" +Math.min(costMap[i][(j+1) % 3], costMap[i][(j+2) %3]));
				}
//				System.out.println(dp[i][j]);
			}
			
			dp[i][3] = minimum(dp[i][0], dp[i][1], dp[i][2]);
			//최소값
			System.out.println(Arrays.toString(dp[i]));
			System.out.println(String.format("i 값 : %d , 최소값 : %d", i, dp[i][3]));
		}
		
	}
	
	private static int minimum(int a, int b, int c) {
		
		int min = a;
		min = Math.min(a, b);
		min = Math.min(min, c);
		
		return min;
	}
}
