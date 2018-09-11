package study._2017.mine._171209;

import java.util.Scanner;

public class Theater {

	/** 2369. [AtCoder Beginner Contest 073] B. Theater
	 * Joisino is working as a receptionist at a theater.
	 * The theater has 100000 seats, numbered from 1 to 100000.
	 * According to her memo, N groups of audiences have come so far, and the
	 * i-th group occupies the consecutive seats from Seat Li to Seat Ri
	 * (inclusive).
	 * How many people are sitting at the theater now?
	 * 
	 * 
	 * Constraints
	 * 1. 1 ≤ N ≤ 1000
	 * 2. 1 ≤ Li ≤ Ri ≤ 100000
	 * 3. No seat is occupied by more than one person.
	 * 4. All input values are integers.
	 * 
	 * Input
	 * The first line of the input contains an integer T, the number of test
	 * sets (1 ≤ T ≤ 10).
	 * 
	 * Output
	 * For each test case, print “#T”(test case number), and the number of
	 * people sitting at the theater.
	 */
	private static void theater(int testcase, int n, int[][] group) {

		int people = 0;

		for (int i = 0; i < n; i++) {
			people += group[i][1] - group[i][0] + 1;
		}

		System.out.println("#" + testcase + " " + people);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 0; i < test; i++) {
			int n = sc.nextInt();
			int[][] group = new int[n][2];
			for (int j = 0; j < n; j++) {
				group[j][0] = sc.nextInt();
				group[j][1] = sc.nextInt();
			}

			theater(i + 1, n, group);
		}
		sc.close();
	}
}
