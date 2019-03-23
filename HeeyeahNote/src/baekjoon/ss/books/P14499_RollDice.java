package baekjoon.ss.books;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P14499_RollDice {
	
	
	private final int FRONT = 1;
	private final int TOP = 2;
	private final int SIDE = 3;
	
	private final int DIRECT_RIGHT = 1;
	private final int DIRECT_LEFT = 2;
	private final int DIRECT_TOP = 3;
	private final int DIRECT_BOTTOM = 4;
	
	private final int[] xDir = {0, 1, 0 , -1}; // right, down, left, up
	private final int[] yDir = {1, 0, -1 , 0};
	
	private static int currX = 0;
	private static int currY = 0;
	
	private static int[][] nmMap = null;
	private static int[] directions = null;
	private static int n = 0;
	private static int m = 0;
	
	
	/*
	 * 2 2 0 0 16
0 2
3 4
4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2 

예외처리만 하면 될듯. 소스정리좀 하
	 */
	public static void main(String[] args) {
		
		P14499_RollDice algorithm = new P14499_RollDice();
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		currX = sc.nextInt();
		currY = sc.nextInt();
		int k = sc.nextInt();

		nmMap = new int[n][m];
		directions = new int[k];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				nmMap[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i <k ; i++) {
			directions[i] = sc.nextInt();
		}
//		System.out.println("=============================");
//		for(int i = 0 ; i < n ; i++) {
//			System.out.println(Arrays.toString(nmMap[i]));
//		}
//		System.out.println(Arrays.toString(directions));
//		System.out.println("=============================");
		algorithm.solve();
		
		sc.close();
	}
	
	private Map<Integer, Integer> dicePosition = new HashMap<Integer, Integer>();
	
	public void solve() {
		
		// set variable
		int[] diceNumber = new int[6];
		dicePosition.put(FRONT, 5);
		dicePosition.put(TOP, 1);
		dicePosition.put(SIDE, 3);
	
		for(int direction : directions) {
			
			boolean isPossible = whereIsDice(direction);
			if(!isPossible) {
				continue;
			}
			
			rollDiceToDirection(direction);
			
//			System.out.printf("=== %d =======================\n", direction);
//			for(int i = 0 ; i < nmMap.length ; i++) {
//				System.out.println(Arrays.toString(nmMap[i]));
//			}
//			System.out.printf("currX %d, currY %d, front %d, top %d, side %d\n", currX, currY,dicePosition.get(FRONT), dicePosition.get(TOP), dicePosition.get(SIDE));
//			System.out.println("=============================");
			
			
			// set dice && nm-map
			int mapNumber = nmMap[currX][currY];
			if(mapNumber == 0) {
				nmMap[currX][currY] = diceNumber[7-dicePosition.get(TOP) -1];
			} else {
				nmMap[currX][currY] = 0;
				diceNumber[7-dicePosition.get(TOP) -1] = mapNumber;
			}
			
			System.out.println(diceNumber[dicePosition.get(TOP)-1]);
		}
	}
	
	public boolean whereIsDice(int direction) {
		
		int nextX = 0;
		int nextY = 0;
		
		switch (direction) {
		case DIRECT_RIGHT:
			nextX = currX + xDir[0];
			nextY = currY + yDir[0];
			break;

		case DIRECT_LEFT:
			nextX = currX + xDir[2];
			nextY = currY + yDir[2];

			break;

		case DIRECT_TOP:
			nextX = currX + xDir[3];
			nextY = currY + yDir[3];

			break;
		case DIRECT_BOTTOM:
			nextX = currX + xDir[1];
			nextY = currY + yDir[1];

			break;

		default:
			break;
		}
		
		if(nextX < n && nextX >= 0 && nextY < m && nextY >= 0) {
			currX = nextX;
			currY = nextY;
			return true;
		} else {
			return false;
		}
	}
	
	public void rollDiceToDirection(int n) {

		int front = dicePosition.get(FRONT);
		int top = dicePosition.get(TOP);
		int side = dicePosition.get(SIDE);
		
		switch (n) {
		case DIRECT_RIGHT:
			dicePosition.put(TOP, 7-side);
			dicePosition.put(SIDE, top);
			break;

		case DIRECT_LEFT:
			dicePosition.put(TOP, side);
			dicePosition.put(SIDE, 7-top);
			break;

		case DIRECT_TOP:
			dicePosition.put(FRONT, 7-top);
			dicePosition.put(TOP, front);
			break;
		case DIRECT_BOTTOM:
			dicePosition.put(FRONT, top);
			dicePosition.put(TOP, 7-front);
			break;

		default:
			break;
		}
	}
}
