package study._2017.mine._171104;

import java.util.Scanner;

public class D2Level {

	public void _1989_simplePalindrome(int testcase, String word) {
		/*
		 * "level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
		 * 
		 * 단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.
		 * 
		 * 
		 * [제약 사항]
		 * 
		 * 각 단어의 길이는 3 이상 10 이하이다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에 하나의 단어가 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		if (word == null)
			return;

		String reverse = new StringBuilder().append(word).reverse().toString();

		// System.out.println(String.format("original : %s / reverse : %s", word, reverse));
		if (word.equals(reverse)) {
			System.out.println("#" + testcase + " 1");
		} else {
			System.out.println("#" + testcase + " 0");
		}
	}

	public void _2005_pascal(int testcase, int number) {
		/*
		 * 크기가 N인 파스칼의 삼각형을 만들어야 한다.
		 * 
		 * 파스칼의 삼각형이란 아래와 같은 규칙을 따른다.
		 * 
		 * 1. 첫 번째 줄은 항상 숫자 1이다.
		 * 
		 * 2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.
		 * 
		 * N이 4일 경우,
		 * 
		 * 
		 * 
		 * N을 입력 받아 크기 N인 파스칼의 삼각형을 출력하는 프로그램을 작성하시오.
		 * 
		 * 
		 * [제약 사항]
		 * 
		 * 파스칼의 삼각형의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)
		 * 
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스에는 N이 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 각 줄은 '#t'로 시작하고, 다음 줄부터 파스칼의 삼각형을 출력한다.
		 * 
		 * 삼각형 각 줄의 처음 숫자가 나오기 전까지의 빈 칸은 생략하고 숫자들 사이에는 한 칸의 빈칸을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 * 
		 */
		System.out.println("#" + testcase);
		if(number == 1) {
			
			System.out.println(1);
		} else if(number == 2) {
			
			System.out.println(String.format("1\n1 1"));
		} else {
			
			System.out.println(String.format("1\n1 1"));
			recursive(2, number, new int[]{1, 1});
		}
	}

	public int[] recursive(int count, int number, int[] initArr) {
		
		int[] outArr = new int[initArr.length +1];
		outArr[0] = outArr[count] = 1;
		
		for(int i = 1 ; i < count ; i++) {
			outArr[i] = initArr[i-1] + initArr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < outArr.length ; i++) {
			sb.append(outArr[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
		count++;
		if(count < number) {
			recursive(count, number, outArr);
		}
		
		return outArr;
	}
	
	public static void main(String[] args) {
		
		/** >1989problem
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < testcase; i++) {
			String word = sc.nextLine();
			new D2Level()._1989_simplePalindrome(i + 1, word);
		}

		sc.close();
		*/
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int number = sc.nextInt();
			new D2Level()._2005_pascal(i+1, number);
		}
		
		sc.close();
	}
}
