package swexpert;

import java.util.Scanner;

public class D0221_CropHarvest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int i = 0; i < testcase; i++) {

			int n = sc.nextInt();
			int[][] field = new int[n][n];

			sc.nextLine();

			for (int j = 0; j < n; j++) {
				field[j] = sc.nextLine().chars().map(value -> value - '0').toArray();
			}

			solution(i + 1, n, field);
		}

		sc.close();
	}

	public static void solution(int testcase, int n, int[][] field) {

		int rslt = 0;

		for (int i = 0; i < n; i++) {

			int flag = 0;
			if (i > n / 2) {
				flag = n - i - 1;
			} else {
				flag = i;
			}

			for (int j = n / 2 - flag; j <= n / 2 + flag; j++) {

				rslt += field[i][j];
			}
		}

		System.out.printf("#%d %d\n", testcase, rslt);
	}
}
