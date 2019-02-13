package programmers.sort;

import java.util.Arrays;

public class HIndex {

	public int solution(int[] citations) {


		Integer[] descCitations = Arrays.stream(citations).boxed().sorted((a, b) -> Integer.compare(b, a))
				.toArray(Integer[]::new);

		int answer = 0;
		for (int i = 0; i < descCitations.length; i++) {
			
			// h-인덱스는 h번 이상 인용된 논문이 h편 이상이 되는 값이므로
			// 큰 수부터 내림차순으로 정렬된 인용횟수와 인덱스(논문편수)를 비교하여 조건이 깨질때 바로 이전이 h-인덱스가 됨
			if ((i + 1) <= descCitations[i]) {
				answer = i + 1;
			} else {
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 0, 6, 1, 5 };
		int rslt = new HIndex().solution(arr);
		System.out.println(rslt);
	}
}
