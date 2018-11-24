package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P13023_ABCDE {

	private static boolean answer;
	private static boolean[] visit;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int x = 0, y = 0;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			if (!map.containsKey(x)) {
				map.put(x, new ArrayList<Integer>());
			}
			if (!map.containsKey(y)) {
				map.put(y, new ArrayList<Integer>());
			}
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			dfs(map, i, 1);
			if (answer)
				break;
		}
		if (answer)
			System.out.println(1);
		else
			System.out.println(0);
		
		sc.close();
	}

	/**
	 * 제출 통과
	 * 
	 * @param map
	 * @param curr
	 * @param length
	 */
	private static void dfs(Map<Integer, List<Integer>> map, int curr, int length) {

		if (length == 5) {
			answer = true;
			return;
		}

		visit[curr] = true;
		
		for (Integer el : map.get(curr)) {
			if (!visit[el]) {
				dfs(map, el, length + 1);
			}
			if (answer)
				return;
		}
		visit[curr] = false;

	}

	/**
	 * 시간 초과
	 * 
	 * @param rel
	 * @param n
	 * @param m
	 * @return
	 */
	private static int printABCDERel(Map<Integer, List<Integer>> rel, int n, int m) {

		for (int j = 0; j < n; j++) {

			LinkedList<Integer> stack = new LinkedList<Integer>();
			boolean[] visited = new boolean[n];
			
			int startPoint = j;
			stack.push(startPoint);
			visited[startPoint] = true;
			
			while (!stack.isEmpty()) {

				boolean endFlag = true;
				int curr = stack.peek();

				List<Integer> regions = rel.get(curr);
				for (Integer el : regions) {
					if (!visited[el]) {
						stack.push(el);
						visited[el] = true;
						endFlag = false;
						break;
					}
				}

				if (stack.size() == 5) {
					return 1;
				}
				if (endFlag) {
					stack.pop();
				}
			}
		}

		return 0;
	}
}
