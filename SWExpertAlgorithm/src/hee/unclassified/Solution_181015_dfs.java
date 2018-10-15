package hee.unclassified;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution_181015_dfs {

//	static int length;
	static char[] target;
	static Map<Character, Character> map;

	//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD&categoryId=AV14geLqABQCFAYD&categoryType=CODE
	//1219. [S/W 문제해결 기본] 4일차 - 길찾기
	
	static int[] one;
	static int[] two;
	static boolean[] oneVisited;
	static boolean[] twoVisited;
	
	static int length;
	static int test;
	static final int MAX = 3000;
	public static int findCourse() {
		
		Stack<Integer> stack = new Stack<Integer>();

		int start = 0;
		int end = 99;

		if(one[start] != 0) {
			stack.push(one[start]);
			oneVisited[start] = true;
		} else {
			stack.push(two[start]);
			twoVisited[start] = true;
		}

		int cnt = 0;
		while(!stack.isEmpty()) {
			
			cnt++;
			if(MAX < cnt) {
//				System.out.println("MAX값...!");
				break;
			}
			
//			if(stack.isEmpty()) {
//				System.out.println("Stack is Empty!!");
//				break;
//			}
			// 1

			int peek = stack.peek();
//			System.out.printf("peek element : %d \n", peek);
			
			if(peek == 99) {
				return 1;
			}
			
			if(oneVisited[peek] || one[peek] == 0) {

			} else {
//				System.out.printf("One Stack Push : %d \n", one[peek]);
				stack.push(one[peek]);
				oneVisited[peek] = true;
				continue;
			}
			
			if (twoVisited[peek] || two[peek] == 0) {
				
			} else {
//				System.out.printf("Two Stack Push : %d \n", two[peek]);
				stack.push(two[peek]);
				twoVisited[peek] = true;
				continue;
			}
			
			stack.pop();
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			one = new int[100];
			two = new int[100];
			oneVisited = new boolean[100];
			twoVisited = new boolean[100];
			
			test = sc.nextInt();
			length = sc.nextInt();
			sc.nextLine();
			String[] arr = sc.nextLine().split(" ");
			
			for(int j = 0 ; j < arr.length /2 ; j++) {
				
				int idx = Integer.parseInt(arr[2*j]);
				int val = Integer.parseInt(arr[2*j+1]);
				
				if(one[idx] == 0) {
					one[idx] = val;
				} else {
					two[idx] = val;
				}
			}
			
			System.out.printf("#%d %d\n", i+1, findCourse());
		}
		
		sc.close();
	}
	
	
	// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
	// [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
	public static int matchBracket() {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < target.length; i++) {

			if (stack.isEmpty()) {
				stack.push(target[i]);
				continue;
			} else {
				char peek = stack.peek();
				if (map.containsKey(peek) && map.get(peek).equals(target[i])) {
					stack.pop();
				} else {
					stack.push(target[i]);
				}
			}
		}

		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main_matchBracket(String[] args) {

		Scanner sc = new Scanner(System.in);

		map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');

		for (int i = 0; i < 10; i++) {
			length = sc.nextInt();
			sc.nextLine();
			target = sc.nextLine().toCharArray();

			System.out.printf("#%d %d\n", i + 1, matchBracket());
		}

		sc.close();
	}
}
