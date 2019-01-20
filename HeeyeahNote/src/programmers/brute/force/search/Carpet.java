package programmers.brute.force.search;

import java.util.Arrays;

public class Carpet {

	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		
		int sum = 2 + (brown/2);
		int complex = brown + red;
		int hori = 0;
		int verti = 0;
		for(hori = 3 ; hori < sum ; hori++) {
			
			verti = sum - hori;
			
			if(hori*verti == complex) {
				break;
			}
		}
		
		if(hori > verti) {
			answer[0] = hori;
			answer[1] = verti;
		} else {
			answer[0] = verti;
			answer[1] = hori;
						
		}
		
		return answer;
	}

	public static void main(String[] args) {

		int brown = 24;
		int red = 24;
		int[] rslt = new Carpet().solution(brown, red);
		System.out.println(Arrays.toString(rslt));
	}
}
