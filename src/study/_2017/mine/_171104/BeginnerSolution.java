package study._2017.mine._171104;

import java.util.Arrays;
import java.util.Scanner;

public class BeginnerSolution {


	private static void _2817problem() {
		/*
		 * A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의
		 * 수를 구하는 프로그램을 작성하시오.
		 * 
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 2개의 자연수 N(1 ≤ N ≤ 20)과 K(1 ≤ K ≤ 1000)가 주어진다.
		 * 
		 * 두 번째 줄에는 N개의 자연수 수열 A가 주어진다. 수열의 원소인 N개의 자연수는 공백을 사이에 두고 주어지며, 1 이상
		 * 100 이하임이 보장된다.
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 부분 수열의 합이 K가 되는
		 * 경우의 수를 출력한다.
		 * 
		 * 입력 예제 1 4 3 1 2 1 2
		 */
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 0; i < testCase; i++) {

			// scan
			int output = 0;
			int realValue = 0;
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(String.format("\nn : %d / k : %d", n, k));
			int[] aArray = new int[n];
			for (int j = 0; j < n; j++) {
				int element = sc.nextInt();
				System.out.println(String.format(" %d 번째 element : %d", j, element));
				if (element > k) {
					continue;
				} else if (element == k) {
					output++;
				} else { // element < k
					aArray[j] = element;
					realValue++;
				}
			}

			for (int j = 0; j < realValue; j++) {

			}

			System.out.println(Arrays.toString(aArray));

			// start
			// 최소 1개 이상의 수를 선택하기 때문에, 최소 1개부터 최대 n개까지의 합을 다 구해서 경우의 수를 구해야 한다.

		}

	}

	/**
	 * finished
	 */
	private static void _1961_rotateArray() {
		/*
		 * N x N 행렬이 주어질 때,
		 * 
		 * 시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.
		 * 
		 * 
		 * [제약 사항]
		 * 
		 * N은 3 이상 7 이하이다.
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에 N이 주어지고,
		 * 
		 * 다음 N 줄에는 N x N 행렬이 주어진다.
		 * 
		 * [출력]
		 * 
		 * 출력의 첫 줄은 '#t'로 시작하고,
		 * 
		 * 다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.
		 * 
		 * 입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for (int temp = 1; temp <= testcase; temp++) {

			int n = sc.nextInt();
			int[][] matrix = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			System.out.println("#" + temp);

			for (int i = 0; i < n; i++) {
				StringBuilder sb90 = new StringBuilder();
				StringBuilder sb180 = new StringBuilder();
				StringBuilder sb270 = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb90.append(matrix[n - j - 1][i]);
					sb180.append(matrix[n - i - 1][n - j - 1]);
					sb270.append(matrix[j][n - i - 1]);
				}
				System.out.println(sb90.append(" ").append(sb180.toString()).append(" ").append(sb270.toString()));
			}
		}

		sc.close();
	}


	private static void _1215problem() {
		/*
		 * "기러기" 또는 "level" 과 같이 거꾸로 읽어도 앞에서부터 읽은 것과 같은 문장이나 낱말을 회문(回文,
		 * palindrome)이라 한다.
		 * 
		 * 주어진 8x8 평면 글자판에서 가로, 세로를 모두 보아 제시된 길이를 가진 회문의 총 개수를 구하는 문제이다.
		 * 
		 * 
		 * 
		 * 위와 같은 글자판이 주어졌을 때, 길이가 5인 회문은 붉은색 테두리로 표시된 4개가 있으며 따라서 4를 반환하면 된다.
		 * 
		 * [제약 사항]
		 * 
		 * 각 칸의 들어가는 글자는 c언어 char type으로 주어지며 'A', 'B', 'C' 중 하나이다.
		 * 
		 * 글자 판은 무조건 정사각형으로 주어진다.
		 * 
		 * ABA도 회문이며, ABBA도 회문이다. A또한 길이 1짜리 회문이다.
		 * 
		 * 가로, 세로 각각에 대해서 직선으로만 판단한다.
		 * 
		 * 즉, 아래 예에서 노란색 경로를 따라가면 길이 7짜리 회문이 되지만 직선이 아니기 때문에 인정되지 않는다.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * [입력]
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 찾아야 하는 회문의 길이가 주어지며, 다음 줄에 테스트 케이스가 주어진다.
		 * 
		 * 총 10개의 테스트 케이스가 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 찾은 회문의 개수를 출력한다.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		//testcase = 10
		for(int temp = 0 ; temp < 1 ; temp++) {
			
			int count = 0;
			int palindromeLength = sc.nextInt();
			String[][] palinMatrix = new String[8][8];
			StringBuilder sb2 = new StringBuilder();



			for(int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					palinMatrix[i][j] = sc.next();
					if(j % 8 == 7) {
						continue;
					}
					System.out.println(String.format("i : %d , j : %d", i , j));
				}
			}
			System.out.println("end");
			
			for(int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					System.out.print(palinMatrix[i][j]);
				}
				System.out.println();
			}
			
			
			
			//length가 
			
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 8 - palindromeLength + 1 ; j++) {

					StringBuilder sb = new StringBuilder();

					for(int k = j ; k < palindromeLength + j ; k++) {
						sb.append(palinMatrix[i][k]);
					}
					
					String original = sb.toString();
					String reverse = sb.reverse().toString();

					System.out.println(String.format("original : %s , reverse : %s", original, reverse));
					
					if(original.equals(reverse)) {
						count++;
					}
				}
			}
			
		}
	}

	public static void main(String[] args) {

		BeginnerSolution._1961_rotateArray();
//		BeginnerSolution._1215problem();
	}
}
