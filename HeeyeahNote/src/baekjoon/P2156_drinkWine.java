package baekjoon;

import java.util.Scanner;

public class P2156_drinkWine {

	/**
	 * 2156번 포도주 시식 ( https://www.acmicpc.net/problem/2156 ) <br/>
	 * 주어진 예시<br/>
	 * 입력 6 6 10 13 9 8 1 / 출력 33 <br/>
	 * 반례<br/>
	 * 입력 8 7 7 0 5 7 7 0 3 / 출력 31 (오답 29 가능성)<br></br>
	 * i번째를 선택했을 때 최대로 마실 수 있는 포도주의 양을 rslt에 인덱스별로 저장하는데, 오답이 나와서 확인해보니 이전의 값과
	 * 비교를 하지 않아서였다. <br/>
	 * rslt[i] 값을 정한 후 rslt[i-1] 값과 비교해서 현재의 값이 더 작으면, i번째를 선택하지 않은 이전의 값이 최대라는
	 * 뜻이기 때문에 rslt[i] = rslt[i-1] 로 저장해줘야 한다. <br/>
	 * 그리고 i가 0, 1번째 까지는 for문 로직을 타지 않아도 명확하기 때문에 for문 밖으로 빼줘도 될듯하다. <br/>
	 * 
	 * @param wines
	 *            wine에 담긴 양
	 * @param n
	 *            와인 잔 수
	 * @return
	 */
	public int drinkWine(int[] wines, int n) {

		int[] rslt = new int[n + 1];

		for (int i = 0; i <= n; i++) {

			if (i == 0) {
				rslt[i] = wines[i];
				continue;
			} else if (i == 1) {
				rslt[i] = Math.max(wines[i], wines[i] + wines[i - 1]);
			} else if (i == 2) {
				rslt[i] = Math.max(wines[i] + wines[i - 1], wines[i] + rslt[i - 2]);
			} else {
				rslt[i] = Math.max(wines[i] + wines[i - 1] + rslt[i - 3], wines[i] + rslt[i - 2]);
			}

			if (rslt[i] < rslt[i - 1]) {
				rslt[i] = rslt[i - 1];
			}
		}

		return rslt[n];
	}

	public static void main(String[] args) {
		P2156_drinkWine dp = new P2156_drinkWine();

		Scanner sc = new Scanner(System.in);

		int wineCnt = sc.nextInt();

		int[] wines = new int[wineCnt + 1];
		for (int i = 0; i < wineCnt; i++) {
			wines[i] = sc.nextInt();
		}

		System.out.println(dp.drinkWine(wines, wineCnt));
		sc.close();
	}
}
