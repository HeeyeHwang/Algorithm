package swexpert;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO not yet solved XP
 * @author heeye
 */
public class D0211_Ladder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i ++) {
			
			int testcase = sc.nextInt();
			sc.nextLine();
			
			char[][] ladder = new char[100][100];
			for(int j = 0 ; j < 100 ; j++) {
				ladder[j] = sc.nextLine().toCharArray();
//				System.out.println(Arrays.toString(ladder[j]));
			}
			int answer = getAnswer(ladder);
			
			System.out.printf("#%d %d\n", testcase, answer);
		}
		
		sc.close();
	}
	
	public static int getAnswer(char[][] ladder) {
		

		for(int i = 0 ; i < 100 ; i++) {

			char c = ladder[0][i];
			
			if(c == '0') {
				continue;
			}
			
			
			
			
		}
		
		return 0;
	}
}
