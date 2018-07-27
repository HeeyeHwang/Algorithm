package study._2017.mine._171202;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private int correctCase = 0;
	
	/** 1535
	 * 세준이는 성형수술을 한 후에 병원에 너무 오래 입원해 있었다. 이제 세준이가 병원에 입원한 동안 자기를 생각해준 사람들에게
	 * 감사하다고 말할 차례이다.
	 * 
	 * 세준이를 생각해준 사람은 총 N명이 있다. 사람의 번호는 1번부터 N번까지 있다. 세준이가 i번 사람에게 인사를 하게 되면
	 * L[i]만큼의 체력을 잃게 되고, J[i]만큼의 기쁨을 얻게 된다. 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
	 * 
	 * 세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다. 세준이의 체력은 100이고, 기쁨은 0이다. 만약 세준이의 체력이
	 * 0이 되거나, 음수가 되면, 죽게되서 아무런 기쁨을 못 느낀 것이 된다. 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을
	 * 작성하시오.
	 * 
	 * 입력 첫째 줄에 사람의 수 N(<=20)이 들어온다. 둘째 줄에는 각각의 사람에게 인사를 할 때, 잃는 체력이 1번 사람부터
	 * 순서대로 들어오고, 셋째 줄에는 각각의 사람에게 인사를 할 때, 얻는 기쁨이 1번 사람부터 순서대로 들어온다.
	 * 				3
		health L[]  1 21 79
		happy  J[]  20 30 25
	 * 출력 첫째 줄에 세준이가 얻을 수 있는 최대 기쁨을 출력한다.
	 */
	private void _baek_1535_hi(int[] L, int[] J, int peopleCnt) {
		
		int health = 100;
		int happy = 0;
		
		for( int i = 1 ; i < 1 << peopleCnt ; i++) {
			
			int happySum = 0;
			int healthSum = 100;
			for( int j = 0 ; j < peopleCnt ; j++) {
				
				if( (i & (1 << j)) > 0) {
					healthSum -= L[j];
					happySum  += J[j];
				}
			}
			
			if( healthSum > 0 ) {
				if(happy < happySum) {
					happy = happySum;
				}
			} else {
//				System.out.println("죽었어여! X( .... i값 : " + i);
				continue;
			}
			
//			System.out.println(String.format("현재 health : %d, happy : %d", healthSum, happy));
		}
		
		System.out.println(happy);
	}
	
	/**
	 * 상근이가 1학년 때, 덧셈, 뺄셈을 매우 좋아했다. 상근이는 숫자가 줄 지어있는 것을 보기만 하면, 마지막 두 숫자 사이에 '='을
	 * 넣고, 나머지 숫자 사이에는 '+' 또는 '-'를 넣어 등식을 만들며 놀고 있다. 예를 들어,
	 * "8 3 2 4 8 7 2 4 0 8 8"에서 등식 "8+3-2-4+8-7-2-4-0+8=8"을 만들 수 있다.
	 * 
	 * 상근이는 올바른 등식을 만들 수 있는 경우의 수를 만드려고 한다. 상근이는 아직 학교에서 음수를 배우지 않았고, 20을 넘는 수는
	 * 모른다. 따라서, 왼쪽부터 계산할 때, 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다. 예를 들어,
	 * "8+3-2-4-8-7+2+4+0+8=8"은 올바른 등식이지만, 8+3-2-4-8이 음수이기 때문에, 상근이가 만들 수 없는
	 * 등식이다.
	 * 
	 * 숫자가 주어졌을 때, 상근이가 만들 수 있는 올바른 등식의 수를 구하는 프로그램을 작성하시오.
	 * 
	 * 입력 첫째 줄에 숫자의 개수 N이 주어진다. (3 ≤ N ≤ 100) 둘째 줄에는 0 이상 9 이하의 정수 N개가 공백으로 구분해
	 * 주어진다.
	 * 
	 * 출력 첫째 줄에 상근이가 만들 수 있는 올바른 등식의 개수를 출력한다. 이 값은 263-1 이하이다.
	 */ //그....... 가지치기 해줘야 함, sum 저장해서...? + 피보나치 풀어보기
	private void _5557_baek_1st_grade(int numberCnt, int[] numbers) {

		dfs(numbers[0], numbers, 1, numbers.length);
		System.out.println(correctCase);
	}

	private void dfs(int mediumSum, int[] numbers, int index, int length) {

		if(length == index + 1) {
			if(mediumSum == numbers[length -1]) {
//				System.out.println("counting success");
				correctCase++;
			} else {
//				System.out.println("what number ? " + mediumSum);
			}
			return;
		}
		//이 코드는 필요가 없음, 위에서 return 해주기 때문에!
//		else if (length < index +2) {
//			System.out.println(String.format("length(%d) < index(%d) +2", length, index));
//			return;
//		}
	
		int value = mediumSum;
		int left  = mediumSum - numbers[index];
		int right = mediumSum + numbers[index];
		
//		System.out.println(String.format("value : %d / left : %d / right : %d / index : %d", value, left, right, index));
		if( left >= 0 && left <= 20 ) {
			dfs(left, numbers, index + 1, length);
		}
		
		if( right >= 0 && right <= 20 ) {
			dfs(right, numbers, index + 1, length);
		}
	}
	
	
	public static void main(String[] args) {
	
		/* 1535 안녕 (baekjoon)*/
/*		Scanner sc = new Scanner(System.in);
		int peopleCnt = sc.nextInt();
		int[] L = new int[peopleCnt];
		int[] J = new int[peopleCnt];

		for(int i = 0 ; i < peopleCnt*2 ; i++) {
			if(i / peopleCnt == 0) {
				L[i] = sc.nextInt();
			} else {
				J[i%peopleCnt] = sc.nextInt();
			}
		}

		new Main()._baek_1535_hi(L, J, peopleCnt);
		
		sc.close();
*/
		/* 5557 1학년 (baekjoon)*/
		Scanner sc = new Scanner(System.in);
		int numberCnt = sc.nextInt();
		int[] numbers = new int[numberCnt];
		for(int i = 0 ; i < numberCnt ; i++) {
			numbers[i] = sc.nextInt();
		}
		
//		System.out.println(Arrays.toString(numbers));
		new Main()._5557_baek_1st_grade(numberCnt, numbers);
		sc.close();
	}
}
