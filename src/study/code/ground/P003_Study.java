package study.code.ground;

import java.util.Arrays;
import java.util.Scanner;

public class P003_Study {

	public static void main(String[] args) {
		/*
		 * N개 과목중에 K개 과목만 골라서 공부.
		 * 공부한 과목은 항상 동일한 점수
		 * 점수 총합을 최대화하려고 K개의 과목을 골라야함
		 * 1
4 2
20 50 30 30

		 */
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int j = 0; j < testcase; j++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] scores = new int[n];
			for(int i = 0; i < n; i++) {
				scores[i] = sc.nextInt();
			}
			
			getTotalScore(j+1, scores, n, k);
		}
	}
	
	private static void getTotalScore(int testcase, int[] scores, int n, int k) {
		
		Arrays.sort(scores);
		
		int value= 0;
		for(int i = 0; i < k; i++) {
			value = value + scores[n-1-i];
		}
		
		System.out.println("Case #" + testcase);
		System.out.println(value);
	}
}
