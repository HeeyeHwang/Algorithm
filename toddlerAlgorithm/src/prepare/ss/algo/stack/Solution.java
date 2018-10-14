package prepare.ss.algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
	// [S/W 문제해결 기본] 4일차 - 괄호 짝짓기

	static int length;
	static char[] target;
	static Map<Character, Character> map;
	public static int matchBracket() {

		
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		map = new HashMap<Character, Character>();
		map.put('(',')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		
		for(int i = 0 ; i < 10 ; i++) {
			length = sc.nextInt();
			sc.nextLine();
			target = sc.nextLine().toCharArray();
			
			System.out.printf("#%d %d", i+1, matchBracket());
		}
		
		sc.close();
	}
}
