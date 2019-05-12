package baekjoon;

import java.util.Scanner;

public class P2011_CryptographCode {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		if(n == null || n.isEmpty()) {
			System.out.println(0);
		} else {
			int rslt = solveThis(n);
			System.out.println(rslt);
		}
		
		sc.close();
	}

	public static int solveThis(String n) {

		if(n.charAt(0) == '0') {
			return 0;
		}
		
		
		int[] dp = new int[n.length()];
		
		int standard;
		int lastNum;
		for (int i = 0; i < n.length(); i++) {

			if(n.charAt(i) < 48 || n.charAt(i) > 57	) { // 0~9 ascii
				return 0;
			}
			
			standard = n.charAt(i) - '0'; // or Character.getNumericValue

			if (i == 0) {
				dp[i] = 1;
				continue;
			} else {
				lastNum = n.charAt(i-1) - '0';
			}
			
			if(standard == 0) {
				if(isProperAlphabet(lastNum, standard)) {
					
					if( i > 2) {
						if(n.charAt(i-2)-'0' >= 3) {
							dp[i] = dp[i-1];
						} else {
							dp[i] = dp[i-2]; //12031
						}
					} else {
						dp[i] = dp[i-1];
					}
					continue;
				} else {
					return 0;
				}
			} 

			if(isProperAlphabet(lastNum, standard)) {
				if( i == 1) {
					dp[i] = dp[i-1] + 1;
				} else {
					dp[i] = dp[i-1] + dp[i-2];
				}
			} else {
				dp[i] = dp[i-1];
			}
		
			dp[i] = dp[i] % 1000000;
		}

		return dp[n.length() -1];
	}

	private static boolean isProperAlphabet(int pre, int post) {

		if(pre == 0) {
			return false;
		}
		int alphabet = pre*10 + post; //= Integer.parseInt(String.format("%d%d", pre, post));
        return 1 <= alphabet && alphabet <= 26;
	}
}
