package baekjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class P3190_Snake {
	
	/**
	 * 6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // box size
		int k = sc.nextInt(); // apple count
		sc.nextLine();
		String[] apples = new String[k];
		for(int i = 0 ; i < k ; i++) {
			apples[i] = sc.nextLine();
		}
		
		int l = sc.nextInt();
		sc.nextLine();
		String[] directions = new String[l];
		for(int i = 0 ; i <l ; i++) {
			directions[i] = sc.nextLine();
		}
		
		whenStopTheSnake(n, apples, directions);
		sc.close();
	}
	
	private static void whenStopTheSnake(int n, String[] apples, String[] directions) {
		
		Map<String, Loc> appleMap = new HashMap<String, Loc>();
		for(int i = 0 ; i < apples.length ; i++) {
			String[] arr = apples[i].split(" ");
			appleMap.put(arr[0]+arr[1], new Loc(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
		}
		
		Map<Integer, String> directMap = new HashMap<Integer, String>();
		for(int i = 0 ; i < directions.length ; i++) {
			String[] arr = directions[i].split(" ");
			directMap.put(Integer.parseInt(arr[0]), arr[1]);
		}
		
//		System.out.println(appleMap);
//		System.out.println(directMap);
		
		LinkedList<Loc> snake = new LinkedList<Loc>();
		int x = 1;
		int y = 1;
		snake.push(new Loc(x, y));
		int seconds = 0;
		int turn = 0;
		
		while(true) {
			seconds++;
			
//			System.out.println("seconds : " +seconds);
			// next seconds, define x & y
			if(directMap.containsKey(seconds-1)) {
				String flag2 = directMap.get(seconds-1);
				
//				System.out.println(" turn ~ " + flag2);
				if(flag2.equals("D")) {
					turn++;
				} else {
					turn--;
				}
			}
			
			if(turn % 4 == 0) {
				y++; //right
			} else if (turn % 4 == 1) {
				x++; // down
			} else if (turn % 4 == 2) {
				y--; // left
			} else if (turn % 4 == 3) {
				x--; // up
			}
			
			if(x > n || x < 1 || y > n || y < 1) {
//				System.out.println(" break ! : " +seconds);
				break;
			}
			
			boolean flag = false;
			for(int i = 0 ; i < snake.size() ; i++) {
				if(x == snake.get(i).getX() && y == snake.get(i).getY()) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
//				System.out.println("break!!!!");
				break;
			}
			
			
			snake.push(new Loc(x, y));
			
			
			if(appleMap.containsKey(x+""+y)) {
				appleMap.remove(x+""+y);
			} else {
				snake.removeLast();
			}
			
//			System.out.printf("seconds %d | turn %d | x %d | y %d\n", seconds, turn, x, y);
//			for(int i = 0 ; i < snake.size() ; i++) {
//				System.out.printf("%s",snake.get(i).toString());
//			}
//			System.out.println("");
		}
		
		System.out.println(seconds);
	}
}

class Loc {
	private int x;
	private int y;
	
	public Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
          
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Loc [x=" + x + ", y=" + y + "]";
	}
}
