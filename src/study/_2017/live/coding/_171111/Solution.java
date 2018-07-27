package study._2017.live.coding._171111;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		//A = 0, B = 99

		Scanner sc = new Scanner(System.in);
		
		int testcase, totalLine;
		for(int i = 0 ; i < 1 ; i++) {
			testcase = sc.nextInt();
			totalLine = sc.nextInt();
			
			int[] roadArr1 = new int[100];
			int[] roadArr2 = new int[100];
			
			int start, end;
			for(int j = 0 ; j < totalLine ; j++) {
				start = sc.nextInt();
				end = sc.nextInt();
				System.out.println(String.format("start : %d, end : %d", start, end));
				if(roadArr1[start] == 0 ) {
					roadArr1[start] = end;
				} else {
					roadArr2[start] = end;
				}
			}
			
			roadArr1[99] = roadArr2[99] = 1000;
			System.out.println(Arrays.toString(roadArr1));
			System.out.println(Arrays.toString(roadArr2));
			System.out.println("--------------------------------------------");
			new Solution()._1219_find_path(testcase, roadArr1, roadArr2);
		}
	}
	
	private void _1219_find_path(int testcase, int[] roadArr1, int[] roadArr2) {
		
		int out = 0;

		boolean temp = false;

		int currentNode = 0 ;
		recursive(currentNode, roadArr1, roadArr2);
		
		System.out.println("#" + testcase + " " + out);
	}
	
	private void recursive(int currentNode, int[] roadArr1, int[] roadArr2) {

		System.out.println(String.format("current Node : %d, roadArr1의 값 : %d, roadArr2 의 값 : %d", currentNode, roadArr1[currentNode], roadArr2[currentNode]));
		if(roadArr1[currentNode] > 0) {
			
			if(roadArr1[currentNode] == 1000) {
				System.out.println("길찾음");
			} else {
				recursive(roadArr1[currentNode], roadArr1, roadArr2);
			}
		} else if (roadArr2[currentNode] > 0) {
			
			if(roadArr2[currentNode] == 1000) {
				System.out.println("길찾음!!");
			} else {
				recursive(roadArr2[currentNode], roadArr1, roadArr2);
				
			}
		} else {
			System.out.println("일단 여기는 길이 없음! current node : " + currentNode);
		}
	}
}
