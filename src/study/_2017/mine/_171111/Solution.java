package study._2017.mine._171111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private void _1208_flatten(int testcase, int dumpCount, int[] flattenArray) {
		
		int gap, max = 0, min = 0, maxIndex = 0, minIndex = 0;
		
		for(int i = 0 ; i <dumpCount ; i++) {
			max = 0;
			min = 101;
			
			for(int j = 0 ; j < flattenArray.length ; j++) {
				
				if(flattenArray[j] >= max) {
					max = flattenArray[j];
					maxIndex = j;
				}
				
				if(flattenArray[j] <= min) {
					min = flattenArray[j];
					minIndex = j;
				}
			}
//			System.out.println(String.format("##%d 덤프## %d 번째 인덱스 max : %d , %d번째 인덱스 min : %d", i+1,maxIndex, max, minIndex, min));
			flattenArray[maxIndex] = max -1;
			flattenArray[minIndex] = min +1;
//			System.out.println(String.format("처리한 후에 값은....%d // %d , gap : %d", flattenArray[maxIndex], flattenArray[minIndex], max-min -2));
		
		}
		
		max = 0;
		min = 101;
		for(int j = 0 ; j < flattenArray.length ; j++) {
			
			if(flattenArray[j] >= max) {
				max = flattenArray[j];
				maxIndex = j;
			}
			
			if(flattenArray[j] <= min) {
				min = flattenArray[j];
				minIndex = j;
			}
		}
		
		gap = max - min;
		
		System.out.println("#" + testcase + " " + gap);
	}
	
	
	private void _1974_sudoku_verification(int testcase, int[][] sudoku) {
	
		int result = 1;
		
		for(int i = 0 ; i < 9 ; i++) {
			boolean[] columnCheck = new boolean[9];
			boolean[] rowCheck = new boolean[9];
			boolean[] boxCheck = new boolean[9];
			
			int columnVal = 0;
			int rowVal = 0;
			int boxVal = 0;
			
			for(int j = 0 ; j < 9 ; j++) {
				columnVal = sudoku[i][j]; //한 행
				rowVal = sudoku[j][i]; //한 열
				boxVal = sudoku[ (i/3)*3 + j/3 ][ (i%3)*3 + (j%3) ]; //하나의 박스 00 03 06 30 33 36 60 63 66
				
				if(columnCheck[columnVal -1] || rowCheck[rowVal -1] || boxCheck[boxVal -1]) {
//					System.out.println(String.format(" j 값 : %d, checkArr[j] : %d", j, column));
					result = 0;
					break;
				} else {
//					System.out.println(column -1);
					columnCheck[columnVal -1] = true;
					rowCheck[rowVal -1] = true;
					boxCheck[boxVal -1] = true;
				}
			}
			
			if(result == 0) {
				break;
			}
		}
		
		System.out.println("#" + testcase + " " + result);
	}
	
	private static String getScoreLevel(int peopleCount, int rank) {
		
		String[] rankBoard = new String[]{"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		String scoreLv = null;
		int division = peopleCount / 10;
		int index =(rank - 1) / division;
		
		scoreLv = rankBoard[index];
		return scoreLv;
	}
	
	private void _1983_assistant_scoring(int testcase, int peopleCount, List<int[]> scoreList, int studentNumber) {

		List<Double> scoreBoardList = new ArrayList<Double>();
		Double kStudentScore = null;
		for (int i = 0; i < peopleCount; i++) {
			
			int[] personScore = scoreList.get(i);
			double totalScore = personScore[0] * 0.35 + personScore[1] * 0.45 + personScore[2] * 0.2;
		
			scoreBoardList.add(totalScore);

			if(studentNumber == i+1) {
				kStudentScore = totalScore; //k번째 학생의 총점
			}
		}

		Collections.sort(scoreBoardList); //TODO sorting 클래스 구현해보기

		int level = 0;
		int scoreLevel = peopleCount;
		for(int i = 0 ; i < scoreBoardList.size() ; i++) {
			if(kStudentScore.equals(scoreBoardList.get(i))) {
				level = scoreLevel;
			}
			
			scoreLevel--;
		}
		
		System.out.println("#" + testcase + " " + getScoreLevel(peopleCount, level));
		/*
		 * 
		 * 학기가 끝나고, 학생들의 점수로 학점을 계산중이다.
		 * 
		 * 학점은 상대평가로 주어지는데, 총 10개의 평점이 있다.
		 * 
		 * 
		 * 학점은 학생들이 응시한 중간/기말고사 점수 결과 및 과제 점수가 반영한다.
		 * 
		 * 각각 아래 비율로 반영된다.
		 * 
		 * 
		 * 10 개의 평점을 총점이 높은 순서대로 부여하는데,
		 * 
		 * 각각의 평점은 같은 비율로 부여할 수 있다.
		 * 
		 * 예를 들어, N 명의 학생이 있을 경우 N/10 명의 학생들에게 동일한 평점을 부여할 수 있다.
		 * 
		 * 입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고,
		 * 
		 * 학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때,
		 * 
		 * K 번째 학생의 학점을 출력하는 프로그램을 작성하라.
		 * 
		 * 
		 * [제약사항]
		 * 
		 * 1. N은 항상 10의 배수이며, 10이상 100이하의 정수이다. (10 ≤ N ≤ 100)
		 * 
		 * 2. K는 1 이상 N 이하의 정수이다. (1 ≤ K ≤ N)
		 * 
		 * 3. K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않는다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
		 * 
		 * 다음 줄부터 각 테스트 케이스가 주어진다.
		 * 
		 * 테스트 케이스의 첫 번째 줄은 학생수 N 과, 학점을 알고싶은 학생의 번호 K 가 주어진다.
		 * 
		 * 테스트 케이스 두 번째 줄 부터 각각의 학생이 받은 시험 및 과제 점수가 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
	}

	public static void main(String[] args) {

		/* _1983_assistant_scoring Main*/
//		Scanner sc = new Scanner(System.in);
//		int testcase = sc.nextInt();
//
//		for (int i = 0; i < testcase; i++) {
//			int peopleCount = sc.nextInt();
//			int student = sc.nextInt();
//			List<int[]> scoreList = new ArrayList<int[]>();
//
//			for (int j = 0; j < peopleCount; j++) {
//				int[] scoreArr = new int[3];
//				scoreArr[0] = sc.nextInt();
//				scoreArr[1] = sc.nextInt();
//				scoreArr[2] = sc.nextInt();
//				scoreList.add(scoreArr);
//			}
//
//			new D2level()._1983_assistant_scoring(i + 1, peopleCount, scoreList, student);
//		}
//		
//		sc.close();

		/* _1974_sudoku_verification Main*/
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int[][] sudoku = new int[9][9];
			
			for(int j = 0 ; j < 9 ; j++) {
				for(int k = 0 ;k < 9 ; k++) {
					sudoku[j][k] = sc.nextInt();
				}
			}
			
			new Solution()._1974_sudoku_verification(i+1, sudoku);
		}
		sc.close();
		
		/* _1208_flatten Main*/
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i = 0 ; i < 10 ; i++) {
//			int dumpCount = sc.nextInt();
//			int[] flattenArray = new int[100];
//			for(int j = 0 ; j < 100 ; j++) {
//				flattenArray[j] = sc.nextInt();
//			}
//			new Solution()._1208_flatten(i+1, dumpCount, flattenArray);
//		}
//		sc.close();
	}
}
