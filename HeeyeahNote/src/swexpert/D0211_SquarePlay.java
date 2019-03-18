package swexpert;

import java.util.Scanner;

/**
 * TODO not yet solved XP
 * @author heeye
 */
public class D0211_SquarePlay {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int i = 0; i < testcase; i++) {
			int answer = squarePlay(sc.nextLong());
			System.out.printf("#%d %d\n", i + 1, answer);
		}

		sc.close();
	}

	static int squarePlay(long n) {

		int count = 0;
		long target = n;

		while (true) {

			if (target == 2) {
				break;
			}

			double value = Math.sqrt(target);
			count++;

			if (value % 1 == 0) {
				target = (int) value;
			} else {
				target++;
			}

		}

		return count;
	}
}
