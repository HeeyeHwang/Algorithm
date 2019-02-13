package programmers.dp;

import java.util.Arrays;
import java.util.OptionalInt;

public class IntegerTriangle {

	public int solution(int[][] triangle) {
		
		int answer = 0;

		int[] dp = new int[triangle.length];

		for (int i = 0; i < triangle.length; i++) {

			int[] floor = triangle[i];
			int[] beforeDp = Arrays.copyOf(dp, dp.length);
			
			for (int j = 1; j < i; j++) {
				dp[j] = Math.max(beforeDp[j-1], beforeDp[j]) + floor[j];
			}
			
			dp[0] = beforeDp[0] + floor[0];
			if(i > 0) {
				dp[i] = beforeDp[i-1] + floor[i];
			}
		}
		
		OptionalInt optionalAnswer = Arrays.stream(dp).max();
		
		if(optionalAnswer.isPresent()) {
			answer = optionalAnswer.getAsInt();
		}

		return answer;
	}

	public static void main(String[] args) {

		int[][] triangle = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int rslt = new IntegerTriangle().solution(triangle);
		System.out.println(rslt);
	}
}
