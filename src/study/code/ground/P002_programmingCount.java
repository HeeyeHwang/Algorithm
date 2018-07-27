package study.code.ground;

import java.util.Arrays;
import java.util.Scanner;

public class P002_programmingCount {

	public static void main(String[] args) {
		
		/**
		 * 1
3 
5
7
6
		 */
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int n = sc.nextInt();
			int[] scores = new int[n];
			for(int j = 0 ; j < n ; j++) {
				scores[j] = sc.nextInt();
			}
			
			Arrays.sort(scores);
			proContest(i+1, n, scores);
		}
		
		sc.close();
	}
	
	private static void proContest(int testcase, int n, int[] scores) {

//		System.out.println(Arrays.toString(scores));
		
		int count = 0;
		int max = -1;
		int val = 0;
		for(int i = 0 ; i < n ; i++) {
			val = scores[i] + n - i;
			if(max < val) {
				max = val;
			}
		}

		for(int i = 0 ; i < n ; i++) {
			
			if(max <= scores[i] + n) {
				count++;
			}
		}
		
		System.out.println("Case #"+testcase);
		System.out.println(count);
	}
}
