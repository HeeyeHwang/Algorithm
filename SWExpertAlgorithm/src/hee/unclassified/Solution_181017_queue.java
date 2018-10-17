package hee.unclassified;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Pos {
	int x;
	int y;
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_181017_queue {

	/*
	 * 우선순위 Queue
	 * 
	 * FIFO순서가 아니라 우선순위가 높은 순서대로 먼저 나가게 됨
	 * 
	 * 구현는 배열 또는 연결리스트!
	 * 
	 * 우선순위를 비교해서 삽입하고, 삭제는 앞에서부터 삭제!
	 * 
	 * Heap 자료 구조를 사용할 수도 있음.
	 * 
	 */
	
	//[S/W 문제해결 기본] 7일차 - 미로1
	
	
	static char[][] maze;
	static boolean[][] visited;
	static LinkedList<Pos> queue;
	
	public static int maze() {
		
		// char 0 1 2 3 == int 48 49 50 51
		int xIdx = 0;
		int yIdx = 0;
		
		char curr;
		
		int[] xCal = new int[] {1, 0, -1, 0};
		int[] yCal = new int[] {0, -1, 0, 1};
		
		while(!queue.isEmpty()) {

			curr = maze[xIdx][yIdx];

			
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			maze = new char[16][16];
			visited = new boolean[16][16];
			queue = new LinkedList<Pos>();
			int test = sc.nextInt();
			sc.nextLine();
			
			String line;
			char[] arr;
			for(int j = 0 ; j < 16 ; j++) {
				line = sc.nextLine();
				arr = line.toCharArray();
				maze[j] = arr;
			}
			
			System.out.printf("#%d %d\n", test, maze());
		}
		
		sc.close();
	}
	
	
	
	//[S/W 문제해결 기본] 7일차 - 암호생성기
	
	static LinkedList<Integer> _queue;
	
	public static void main_passwordGenerator (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = 0;
		for(int i = 0 ; i < 10 ; i++) {
			
			_queue = new LinkedList<Integer>();
			testcase = sc.nextInt();
			
			for(int j = 0 ; j < 8 ; j++) {
				_queue.add(sc.nextInt());
			}
		
			passwordGenerator();

			System.out.printf("#%d ", i+1);
			for(int j = 0; j < 8 ; j++) {
				if(j == 7) {
					System.out.println(_queue.pop());
				} else {
					System.out.printf("%d ", _queue.pop());
				}
			}
		}
		
		sc.close();
	}
	
	public static void passwordGenerator() {
		
		int cycle = 1;
		while(true) {

			if(cycle > 5) {
				cycle = 1;
			}
			
			int first = _queue.pop();
			int willLast = first - cycle++;
			
			if(willLast <= 0) {
				_queue.addLast(0);
				break;
			} else {
				_queue.addLast(willLast);
			}

		}
	}
	
}
