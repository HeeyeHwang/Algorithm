package baekjoon;

import java.util.Scanner;

public class P2011_CryptographCode {


	static int[] dp;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		
		if(n == null || n.isEmpty()) {
			System.out.println(0);
		} else {
			solveThis(n);
			System.out.println(dp[n.length() -1]);
		}
		sc.close();
	}

	static int lastDigit1;
	static int lastDigit2;
	public static void solveThis(String n) {

		dp = new int[n.length()];

		char first = n.charAt(0);
		char last = n.charAt(n.length() -1);
		
		if(first == '0') {
			return;
		}
		
		if(last == '0') {
			int verify = Integer.parseInt(n.substring(n.length()-2, n.length()));
			if(verify != 10 && verify != 20) {
				System.out.println(verify);
				return;
			}
		}
		
		
		int lastDigit1 = 0;
		int lastDigit2 = 0;

		for (int i = 0; i < n.length(); i++) {

			int standard = n.charAt(i) - '0'; // or Character.getNumericValue
//			System.out.println("standard : " + standard);
			if (i == 0) {
				lastDigit1 = lastDigit2= standard;
				dp[i] = 1;
				continue;
			}


			if(lastDigit1 == lastDigit2) {
				int next =isProperAlphabet(lastDigit1, standard);
				if(next != -1) {
					lastDigit1 = next;
					lastDigit2 = standard;
					dp[i] = dp[i-1] * 2;
				} else {
					lastDigit1 = lastDigit2 = standard;
					dp[i] = dp[i-1];
				}
			} else {
				
				int proper = isProperAlphabet(lastDigit1, standard);
				int proper2 = isProperAlphabet(lastDigit2, standard);
				
//				System.out.println("proper : " + proper + " proper2 :" +proper2);
//				if (proper == -1 && proper2 == -1) {
//					dp[i] = dp[i - 1];
//					lastDigit1 = proper;
//					lastDigit2 = proper2;
//				} else 
					if (proper != -1) {
					dp[i] = dp[i - 1] + 2;
					lastDigit1 = proper;
					lastDigit2 = standard;
					
				} else if (proper2 != -1) {
					dp[i] = dp[i - 1] + 2;
					lastDigit1 = standard;
					lastDigit2 = proper2;
					
				} else {
					dp[i] = dp[i - 1];
					lastDigit1 = lastDigit2 = standard;
				}
				
			}

			dp[i] = dp[i] % 1000000;
//			System.out.printf("lastDigit1 : %d, lastDigit2 : %d, rslt : %s\n", lastDigit1, lastDigit2, Arrays.toString(dp));
		}

	}

	private static int isProperAlphabet(int pre, int post) {

		int alphabet = Integer.parseInt(String.format("%d%d", pre, post));
		if (1 <= alphabet && alphabet <= 26) {
			return alphabet;
		} else {
			return -1;
		}
	}
}
