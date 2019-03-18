package swexpert;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO not yet solved XP
 * @author heeye
 */
public class D0211_Flatten {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			
			int dump = sc.nextInt();

			int[] array = new int[100];
			for(int j = 0 ; j <100 ; j++) {
				array[j] = sc.nextInt();
			}
		
			int rslt = solution(dump, array);
			System.out.printf("#%d %d\n", i+1, rslt);
		}
		
		sc.close();
	}
	
	public static int solution(int count, int[] height) {

		int answer = 0;
		
		Arrays.sort(height);
		
		for(int i = 0 ; i < count ; i++) {
			
			height[99]--;
			height[0]++;
			
			Arrays.sort(height);
		}
		
		answer = height[99] - height[0];
		
		return answer;
	}
}
