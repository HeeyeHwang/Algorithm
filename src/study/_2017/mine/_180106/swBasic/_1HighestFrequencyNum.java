package study._2017.mine._180106.swBasic;

import java.util.Scanner;

public class _1HighestFrequencyNum {

	public static void main(String[] args) {
		/*
		 * 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
		 * 
		 * 이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번
		 * 나타나는 값을 의미한다.
		 * 
		 * 다음과 같은 수 분포가 있으면,
		 * 
		 * 10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
		 * 
		 * 최빈수는 8이 된다.
		 * 
		 * 최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).
		 * 
		 * [제약 사항]
		 * 
		 * 학생의 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하의 값이다.
		 * 
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄부터는 점수가 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			int testcaseNum = sc.nextInt();
			sc.nextLine();
			String score = sc.nextLine();
			String[] scores = score.split(" ");
			
			getHighestFrequency(testcaseNum, scores);
		}
		
		sc.close();
	}

	private static void getHighestFrequency(int testcase, String[] scores) {
		
		// 0 인덱스부터 100인덱스까지 점수라고 생각하고 체크
		int[] scoreBoard = new int[101];
		for (String scoreStr : scores) {
			int score = Integer.parseInt(scoreStr);
			scoreBoard[score]++;
		}

		int max = -1;
		int index = -1;
		for(int i = 0 ; i < 101 ; i ++) {
			if(max <= scoreBoard[i]) {
				max = scoreBoard[i];
				index = i;
			}
		}
		
		System.out.println("#" + testcase + " " + index);
	}
}
