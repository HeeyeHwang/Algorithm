package swexpert;

import java.util.Scanner;
import java.util.stream.Stream;

public class D0218_View {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			sc.nextLine();

			String line = sc.nextLine();

			int rslt = solution(n, line);

			System.out.printf("#%d %d\n", i + 1, rslt);
		}

		sc.close();
	}

	public static int solution(int n, String line) {

		int[] array = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();

		int rslt = 0;
		for (int i = 2; i < n - 2; i++) {
			
			int ppre = array[i-2];
			int pre = array[i-1];
			int post = array[i+1];
			int ppost = array[i+2];
			
			if(ppre < array[i] && pre < array[i] &&  post < array[i] &&  ppost < array[i]) {

				int max = Math.max(Math.max(ppre, pre), Math.max(post, ppost));
				rslt += array[i] - max;
			}
			
		}

		return rslt;
	}
}
