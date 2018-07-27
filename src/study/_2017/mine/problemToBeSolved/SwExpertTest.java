package study._2017.mine.problemToBeSolved;

import java.util.Scanner;

public class SwExpertTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			
			int sum = 0;
			for(int j= 0; j < 10 ; j++) {
				sum += sc.nextInt();
			}
			
			int avg = sum / 10;
			System.out.println("#"+(i+1)+" "+avg);
		}
		
		sc.close();
	}
}
