package swexpert;

import java.util.Scanner;

public class D0211_NQueen {
	
	static int col[];
	static int n;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			
			n = sc.nextInt();
			ans = 0;
			
			// 0, 1, 2 ... n-1 에 queen을 뒀을 
			for(int j = 0 ; j < n ; j++) {
				col = new int[n];
				col[0] = j; 
				// dfs
				dfs(1);
			}
			
			System.out.printf("#%d %d\n", i+1, ans);
		}
		

		sc.close();
	}
	
	static void dfs(int row) {
		
		// row == n 이라는 건, n개의 행을 다 검사했다라는 뜻.
		if(row == n) {
			ans++;
		} else {
		
			// 0, 1, ... n-1 에 queen을 두는 경우. 이 logic을 타는 건 row 보다 낮은 행의 값들엔 queen이 잘 배치된 상태.
			for(int i = 0 ; i < n ; i++) {
				
				col[row] = i;
				
				// row 행의 i번째 열에 queen을 놔뒀을 때, 이 배치가 가능한가를 따짐. 가능하면 다음 행을 검사 dfs.
				if(isPossible(row)) {
					dfs(row +1);
				} else {
					col[row] = 0;
				}
			}
		}
	}
	
	static boolean isPossible(int row) {
	
		//  
		for(int i = 0 ; i < row ; i++) {
			if(col[i] == col[row] || Math.abs(col[i] - col[row]) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}
}
