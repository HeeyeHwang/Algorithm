package swexpert;

import java.util.Scanner;
import java.util.Stack;


/**
 * TODO not yet solved XP
 * @author heeye
 */
public class D0211_MatchBracket {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			
			int length = sc.nextInt();
			sc.nextLine();
			
			String brackets = sc.nextLine();
			
			int rslt = solution(length, brackets);
			System.out.printf("#%d %d\n", i+1, rslt);
		}
		
		sc.close();
	}
	
	public static int solution(int length, String brackets) {
		
		char[] bracketArr = brackets.toCharArray();

		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < bracketArr.length ; i++) {
			
			
			
		}
		
		
		return 0;
	}
}
