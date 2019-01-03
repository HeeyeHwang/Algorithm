package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class IronBar {

	public static void main(String[] args) {
		
		String arrangement = "()(((()())(())()))(())";
		solution(arrangement);
	}
	
	public static int solution(String arrangement) {
        int answer = 0;
        
        char[] laser = arrangement.toCharArray();
        LinkedList<Character> queue = new LinkedList<Character>();
        Stack<Character> ss = new Stack<Character>();

        int laserCnt = 0;
        queue.push(laser[0]);
        for(int i = 1 ; i < laser.length ; i++) {
        	char curr = laser[i];
        	char bef = laser[i-1];
        	if(bef == '(' && curr == ')') {
        		System.out.println("this");
        		queue.removeLast();
        		queue.add('*');
        		laserCnt++;
        	} else {
        		queue.add(curr);
        	}
        }
        System.out.println(queue);

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < queue.size() ; i++) {
        	
        	char curr = queue.get(i);
        	
        	if(curr == '(') {
        		stack.push(curr);
        	} else if (curr == '*'){
        		
        	} else {
        		stack.pop();
        	}
        }

        
        return answer;
    }
}
