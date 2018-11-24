package baekjoon;

import java.util.Scanner;

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

		getLongestLength(n, seq);
		sc.close();
	}

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
