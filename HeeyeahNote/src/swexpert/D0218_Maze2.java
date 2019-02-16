package swexpert;

import java.util.Scanner;

public class D0218_Maze2 {

	/*
	 * DFS
	 * 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		D0218_Maze2 mazeInst = new D0218_Maze2();
		for (int i = 0; i < 10; i++) {

			int n = sc.nextInt();

			sc.nextLine();

			int[][] maze = new int[100][100];
			for (int j = 0; j < 100; j++) {
				maze[j] = sc.nextLine().chars().map(value -> value - '0').toArray();
			}

			int rslt = mazeInst.solution(n, maze);
			System.out.printf("#%d %d\n", i + 1, rslt);
		}

		sc.close();
	}

	boolean[][] check;
	// 아래 오 위 왼
	int[] x = { 0, 1, 0, -1 };
	int[] y = { 1, 0, -1, 0 };
	int[][] maze;
	boolean flag;
	
	public int solution(int n, int[][] maze) {
		this.flag = false;
		this.maze = maze;
		check = new boolean[100][100];
		goMaze(1, 1);
		
		if(flag) {
			return 1;
		} else {
			return 0;
		}
	}

	
	public void goMaze(int currX, int currY) {

		for (int i = 0; i < 4; i++) {

			int nextX = currX + x[i];
			int nextY = currY + y[i];

			int val = maze[nextX][nextY];

			if (val == 0 && !check[nextX][nextY]) {
				check[nextX][nextY] = true;
				goMaze(nextX, nextY);
			} else if (val == 3) {
				flag = true;
			}
		}
	}
}
