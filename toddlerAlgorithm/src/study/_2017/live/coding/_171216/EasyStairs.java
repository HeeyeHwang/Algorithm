package study._2017.live.coding._171216;

import java.util.Scanner;

/**
 * Dynamic Programming !!!!!
 * @author Hee
 *
 */
public class EasyStairs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		easyStairsNumber(n);
		sc.close();
	}
	
	private static void easyStairsNumber(int n) {
		
		/*
		 * n 범위 : 1 ~ 100
		 * 
		 * 첫 수는 1 ~ 9 : 9가지 가능
		 * 0 - 1     	01
		 * 1 - 0, 2		10 12
		 * 2 - 1, 3		21 23	
		 * 3 - 2, 4		32 34
		 * .
		 * .
		 * .
		 * 8 - 7, 9
		 * 9 - 8
		 * 
		 * a : 0,9
		 * b : 1,2,3,4,5,6,7,8
		 * 
		 * n = 1 
		 * 1 /2 /3 /4 /5 /6 /7 /8 /9 = 9 - a : 1 b : 8 
		 * 
		 * n = 2
		 * 10 12 /21 23/ 32 34 /43 45 /54 56/ 65 67/ 76 78/ 87 89  / 98 - a : 2 b : 15 
		 * = 2*8 + 1
		 * = (2) + (2* 6) + (2) + (1)
		 * 
		 * n = 3
		 * 101 121 123 / 210 212 232 234 / 321 323 343 345 / .... / 876 878 898 / 987 989 - a : 2 b : 30
		 * = 4* 6 + 3*2 + 2 = 3 + 4*6 + 3 + 2
		 * = (1 + 2) + (2*2*6) + (2 + 1) + (1*2)
		 * 
		 * n = 4
		 * = 1010 1012 1210 1212 1232 1234 / 2101 2121 2123 2321 2323 2343 2345 / ... / 9878 9876 9898 - a : 2 b : 나머지
		 * 끝자리가 0이면 1개 늘어남, 끝자리가 2 ~ 8이면 2배, 끝자리가 9면 1개
		 * dp[1] = 9
		 * dp[2] = 17 = 
		 * dp[n+1] = dp[n]
		 */
		// n = 5라고 생각하면, 5번 돌면서 각 자리 경우의 수 찾아...?
		// 첫수는 1~9, 2번째부터는 0~9
		int count = 0;
		int generalNum = 0;
		int nineNum = 0;
		int[][] caseArray = new int[n+1][4]; // 시작 점이 1~9인걸로 다 저장해서 합침,
		//[x][0] = count [x][1] = 0이나 9 [x][2] = 1이나 8 [x][3] = 2 ~ 7 개수
		// 2 7 : 3 6 : 4 5 
		for(int i = 1 ; i <= n; i++) {
			
			if(i == 1) {
				caseArray[i][1] = 1;
				caseArray[i][2] = 2;
				caseArray[i][3] = 6;
				caseArray[i][0] = caseArray[i][1] + caseArray[i][2] + caseArray[i][3];
			} else {
				caseArray[i][1] = caseArray[i-1][1] + caseArray[i][2];
				caseArray[i][2] = 0;
				caseArray[i][3] = 3;
			}
			/**
			 *  	0 1 2 3 4 5 6 7 8 9 - 들어갈 수 있는 숫자
			 *  ------------------------
			 *    1|0 1 1 1 1 1 1 1 1 1	 | 이 방향이 자리 수
			 *    2|1 1 2 2 2 2 2 2 2 1
			 *    3|
			 *    .|	Dynamic Programming !!!!! ( 반드시 복습)
			 *    .|
			 *    .|
			 *    
			 */
		
		}
	}
}
