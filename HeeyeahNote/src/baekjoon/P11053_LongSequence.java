package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class P11053_LongSequence {

	/*



	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] seq = new int[n];
		for (int i = 0; i < n; i++) {
			seq[i] = sc.nextInt();
		}

		getLongestLength2(n, seq);
		sc.close();
	}
	
	/**
	 * dp[x] 는 x index의 값을 마지막으로 하는 수열의 최장 길이 값.
	 * dp[x]를 어떻게 정의하냐에 따라 다른 것 같다.
	 * @param n
	 * @param seq
	 */
	public static void getLongestLength2(int n, int[] seq) {
		
		int[] dp = new int[n];

		int max = 1;
		dp[0] = 1;
		for(int i = 1 ; i < n ; i++) {
			dp[i] = 1;
			
			for(int j = 0 ; j < i ; j++) {
			
				// seq[i] > seq[j] 는 `증가`하는 부분 수열이니 당연한 조건이고
				// dp[i] = Max ( dp[j] + 1, dp[i] ) 
				// 이건, 이전 값의 best와 현재 증가하는 값 + 1을 비교했을 때, 가장 긴!
				// ( j는 현재 current node라고 생각하고 , dp[i]는 j가 돌았던 이전의 값 중 max값 )
				if(seq[i] > seq[j] ) { 
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}

	/**
	 * 1st try. 2 1 2 와 같은 반례엔 답이 안나옴.
	 * @param n
	 * @param seq
	 */
	public static void getLongestLength(int n, int[] seq) {

		int[] rslt = new int[n];

		int max = -1;
		for (int i = 0; i < n; i++) {

			if (i == 0) {
				rslt[i] = 0;
				max = seq[i];
			} else {
				if (max < seq[i]) {
					rslt[i] = rslt[i - 1] + 1;
					max = seq[i];
				} else {
					rslt[i] = rslt[i - 1];
				}
			}
		}
		
		if(rslt[n-1] == 0) {
			rslt[n-1] = 1;
		}

		System.out.println(rslt[n-1]);
	}
}
