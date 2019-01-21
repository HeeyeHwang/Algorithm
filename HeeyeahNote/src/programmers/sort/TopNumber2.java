package programmers.sort;

import java.util.Arrays;

public class TopNumber2 {

	public static void main(String[] args) {

		int[] numbers = new int[] { 3, 34, 30, 5, 9 };
		String rslt = new TopNumber().solution(numbers);
		System.out.println(rslt);
	}

	public String solution(int[] numbers) {

		String[] numStr = new String[numbers.length];
		
		for(int i = 0 ; i <numbers.length ; i++) {
			numStr[i] = String.valueOf(numbers[i]);
		}
		
		
		Arrays.sort(numStr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
		
		StringBuilder sb = new StringBuilder();
		if(numStr[0].equals("0")) {
			return "0";
		} else {
			
			for(String number : numStr) {
				sb.append(number);
			}
		}
		
		return sb.toString();
	}
}
