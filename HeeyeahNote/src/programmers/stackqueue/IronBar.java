package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Stack;

public class IronBar {

	public static void main(String[] args) {

		String arrangement = "()(((()())(())()))(())";
		int rslt = solution(arrangement);
		System.out.printf("answer : %d", rslt);
	}

	public static int solution(String arrangement) {

		int answer = 0;
		char[] laser = arrangement.toCharArray();
		LinkedList<Character> list = new LinkedList<Character>();

		list.add(laser[0]);
		for (int i = 1; i < laser.length; i++) {
			char curr = laser[i];
			char bef = laser[i - 1];
			if (bef == '(' && curr == ')') {
				list.removeLast();
				list.add('*');
			} else {
				list.add(curr);
			}
		}

		Stack<Character> stack = new Stack<Character>();
		int idx = 0;
		while (idx < list.size()) {

			int laserCnt = 0;
			char c = list.get(idx);
			if (c == '(' || c == '*') {
				stack.push(c);
			} else {

				while (true) {
					char el = stack.pop();
					if (el == '*') {
						laserCnt++;
					} else if (el == '(') {
						break;
					}
				}
				for (int i = 0; i < laserCnt; i++) {
					stack.push('*');
				}
				answer = answer + laserCnt + 1;
			}
			idx++;
		}

		return answer;
	}
}
