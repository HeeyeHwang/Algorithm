package baekjoon.dp;

import java.util.Arrays;

public class DynamicProgramming {

	/**
	 * https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182
	 * 
	 * 막대기 자르기
	 * 
	 */
	public int cutRod(int[] prices, int n) {

		int[] r = new int[prices.length]; // i 길이일 때
		int q = -1;
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {
				q = Math.max(q, prices[j] + r[i - j]);
			}
			r[i] = q;
		}

		return r[n];
	}

	/**
	 * 최장 공통 부분 수열 = Longest Common Subsequence
	 * 최장 공통 부분 수열(LCS) 문제는 두 개의 문자열에서 순서대로 겹치는 문자가 최대 몇 개인지 구하는 문제.
	 * 
	 * 
	 */
	public int lcs(String x, String y) {
		int i = x.length();
		int j = y.length();
		int[][] rslt = new int[i+1][j+1];
		
		for(int k = 0 ; k <= i ; k++) {
			for(int l = 0 ; l <= j ; l++) {
				
				if(k == 0 || l == 0) {
					rslt[k][l] = 0;
				} else if (x.charAt(k-1) == y.charAt(l-1)) {
					rslt[k][l] = rslt[k-1][l-1] + 1;
				} else {
					rslt[k][l] = Math.max(rslt[k-1][l], rslt[k][l-1]);
				}
			}
			
			System.out.println(Arrays.toString(rslt[k]));
		}
		
		return rslt[i][j];
	}
	
	
	public static void main(String[] args) {

		DynamicProgramming dp = new DynamicProgramming();

		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		System.out.println(dp.cutRod(prices, 2));
		System.out.println(dp.cutRod(prices, 3));
		System.out.println(dp.cutRod(prices, 4));
		System.out.println(dp.cutRod(prices, 7));
		
		
		System.out.println(dp.lcs("ABCBDAB", "BDCABA"));
	}
}
