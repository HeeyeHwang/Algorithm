package swexpert;

import java.util.Scanner;
import java.util.stream.Stream;


/**
 * TODO not yet solved XP
 * @author heeye
 */
public class D0218_2048game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		sc.nextLine();

		for(int i = 0 ; i < testcase ; i++) {
			String[] direct = sc.nextLine().split(" ");
			int n = Integer.parseInt(direct[0]);
			String dir = direct[1];
			
			int[][] table = new int[n][n];
			
			for(int j = 0 ; j < n ; j ++) {
				
				table[j] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
			}
		
			solution(i+1, n, dir, table);
		}
		
		sc.close();
	}
	
	public static void solution(int testcase, int n, String dir, int[][] table) {

		int[][] rslt = new int[n][n];

		switch (dir) {
		case "right":
			
			break;
		case "left":
			
			break;
		case "up":
			
			for(int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {

					
					
				}
			}
			
			break;
		case "down":
			
			break;

		default:
			break;
		}
		
		
		// print result
		System.out.println("#"+ testcase);
		for(int i = 0 ; i < n ; i++) {
			String line = "";
			for(int j = 0 ; j <n ; j++) {
				line += rslt[i][j] + " ";
			}
			System.out.println(line.trim());
		}
	}
}
