package baekjoon;

import java.util.Scanner;

public class P9663_NQueen {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		solution();
		System.out.println(answer);
		sc.close();
	}

	static int[] col;
	static int answer;
	static int n;
	public static void solution() {
		
		/*
		 *  N Queen 셋팅
		 *  퀸이 있다는 배열을 설정해줘야 하는데, n*n이라고 생각하기 쉽지만 n으로도 가능.
		 *  col이라는 array가 존재한다고 가정하면, i인덱스의 val값은 i번째 row에 val번째 col에 퀸이 있다는 말!
		 *  
		 *  1. col[0] 에 0부터 n-1까지 퀸을 놓는다고 가정 (초기화값)
		 *  2. dfs로 row 1부터 n-1까지 검색 - 퀸 놓는게 가능한지?
		 *  3. 가능한것 검사는 0부터 row까지의 퀸 배치로 결정.
		 *  4. n-1 row까지 퀸을 놓는 게 가능하면, ans++ 
		 *  
		 */
		answer = 0;
		col = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			
			col[0] = i;
			dfs(1);
		}
		
	}
	
	public static void dfs(int row) {
		
		if(row == n) {
			answer++;
		} else {
			
			for(int i = 0 ; i < n ; i++) {
				
				col[row] = i;
				if(isPossible(row)) {
					dfs(row+1);
				} else {
					col[row] = 0; // 굳이 안해줘도?
				}
			}
		}
	}
	
	public static boolean isPossible(int row) {
		
		for(int i = 0 ; i <row ; i++) {
			if(col[i] == col[row] || (Math.abs(i-row)) == Math.abs(col[i] - col[row])) {
				return false;
			}
		}
		
		return true;
	}
}
