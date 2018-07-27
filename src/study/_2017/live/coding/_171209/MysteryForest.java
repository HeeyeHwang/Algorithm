package study._2017.live.coding._171209;

import java.util.Scanner;

/**
 * 3142. 영준이와 신비한 뿔의 숲
 * @author Hee
 *
 */
public class MysteryForest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			mysteryForest(i+1, n, m);
		}
		sc.close();
	}
	
	private static void mysteryForest(int testcase, int n, int m) {

		int unicorn = 0; //x
		int twinHorn = 0; //y
		
		// x + 2y = n, x + y = m
		// y = n - m, x = m - n + m = 2m - n
		
		unicorn = 2 * m - n;
		twinHorn = n - m;

		System.out.println(String.format("#%d %d %d", testcase, unicorn, twinHorn));
	}
}
