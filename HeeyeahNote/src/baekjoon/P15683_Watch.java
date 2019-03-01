package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15683_Watch {

	static int answer = Integer.MAX_VALUE;
	static int n, m;
	static int[][] map;
	static List<CCTVStrct> cctvs = new ArrayList<CCTVStrct>();
	static int[] rotation = new int[] { 0, 4, 2, 4, 4, 1 }; // 1번카메라는 단방향이기 때문에 케이스가 4개, 2번은 선이라서 2가지, 이런식으로 생각했을 떄 3번은 4번, 4번은 4번, 5번은 1번만 rotation을 돌면 된다.

	
	/**
	 * 
	 * 이 문제는 brute-force (완전탐색) 알고리즘을 사용하는 문제이다.
	 * n, m의 최대값이 8이기 때문에 가능하다.
	 * 먼저 map을 읽으면서 cctv의 위치정보와 타입을 저장해둔다. (cctvs)
	 * 
	 * dfs 로는 cctv를 하나씩 들어가, 개수만큼 봤을 떄 사각지대 값을 계산해 min값을 저장한다.
	 * ***dfs 로직에는 cctv의 rotation 카운트 수만큼, dir을 바꿔가며 eyesight를 체크해야 한다.*** 
	 * 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				map[i][j] = sc.nextInt();

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTVStrct(i, j, map[i][j]));
				}
			}
		}

		dfs(0);
		
		System.out.println(answer);
		sc.close();
	}

	static void dfs(int cctvIndex) {

		if (cctvIndex == cctvs.size()) {

			int cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0)
						cnt++;
				}
			}

			if (answer > cnt) {
				answer = cnt;
			}

			return;
		}

		// logic	
		int[][] backupMap;
		
		CCTVStrct cctv = cctvs.get(cctvIndex);
		
		for(int dir = 0 ; dir < rotation[cctv.type] ; dir++) {
			
			backupMap = copyMap(map);
			
			switch (cctv.type) {
			case 1:
				checkEyesight(dir, cctv);
				break;

			case 2:
				checkEyesight(dir, cctv);
				checkEyesight(dir+2, cctv);
				break;

			case 3:
				checkEyesight(dir, cctv);
				checkEyesight(dir+1, cctv);
				break;

			case 4:
				checkEyesight(dir, cctv);
				checkEyesight(dir+1, cctv);
				checkEyesight(dir+2, cctv);
				break;

			case 5:
				checkEyesight(dir, cctv);
				checkEyesight(dir+1, cctv);
				checkEyesight(dir+2, cctv);
				checkEyesight(dir+3, cctv);
				break;

			default:
				break;
			}
			
			dfs(cctvIndex + 1);
			
			// return init set!
			map = copyMap(backupMap);
		}
		
		
	}
	

	/**
	 * dir
	 * 0 : ->
	 * 1 : ^
	 * 2 : <-
	 * 3 : _
	 */
	static void checkEyesight(int dir, CCTVStrct cctv) {
		
		int row = cctv.row;
		int col = cctv.col;
		dir = dir % 4;
		switch (dir) {
		case 0:
			for(int i = col + 1 ; i < m ; i++) {
				if(map[row][i] == 6) break;
				map[row][i] = -1;
			}
			break;
		case 1:
			for(int i = row -1 ; i > -1 ; i--) {
				if(map[i][col] == 6) break;
				map[i][col] = -1;
			}
			break;
		case 2:
			for(int i = col - 1 ; i > -1 ; i--) {
				if(map[row][i] == 6) break;
				map[row][i] = -1;
			}
			break;
		case 3:
			for(int i = row + 1; i < n ; i++) {
				if(map[i][col] == 6) break;
				map[i][col] = -1;
			}
			break;

		default:
			break;
		}
	}
	
	static int[][] copyMap(int[][] original) {
		
		int[][] backupMap = new int[n][m];
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				backupMap[i][j] = original[i][j];
			}
		}
		
		return backupMap;
	}
}

class CCTVStrct {
	int row;
	int col;
	int type;

	public CCTVStrct(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
	}
}