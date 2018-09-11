package study.code.ground;

import java.util.Arrays;
import java.util.Scanner;

public class P004_Dart {
	public static void main(String[] args) {
	
		/**
		 * 1
10 50 60 80 90
5
5 5
0 55
45 -50
-77 88
-85 0
		 */
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		int bull, trpSt, trpEnd, dbSt, dbEnd, n;
		for(int i = 0; i <testcase; i++) {
			
			bull = sc.nextInt(); //불 반지름
			trpSt = sc.nextInt(); //triple start 반지름
			trpEnd = sc.nextInt(); //triple end 반지름
			dbSt = sc.nextInt(); //double start 반지름
			dbEnd = sc.nextInt(); //double end 반지름
			n = sc.nextInt(); // 다트 던진 개수
			int[][] xyArray = new int[2][n];
			
			for(int j = 0 ; j < n ; j++) {
				xyArray[0][j] = sc.nextInt();
				xyArray[1][j] = sc.nextInt();
			}
			
			getTotalPoint(i+1, bull, trpSt, trpEnd, dbSt, dbEnd, xyArray, n);
		}
	}
	
	private static void getTotalPoint(int testcase, int bull, int trpSt, int trpEnd, int dbSt, int dbEnd, int[][] xyArray, int n) {
		System.out.println("-----------------------------------------------");
		System.out.println(Arrays.toString(xyArray[0]));
		System.out.println(Arrays.toString(xyArray[1]));
		System.out.println("-----------------------------------------------");
		
		
	}
}
