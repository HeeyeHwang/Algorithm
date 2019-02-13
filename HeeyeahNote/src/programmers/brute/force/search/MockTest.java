package programmers.brute.force.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {

	public int[] solution(int[] answers) {
		int[] answer = new int[answers.length];
		
		// 1 2 3 4 5
		// 2 1 2 3 2 4 2 5
		// 3 3 1 1 2 2 4 4 5 5
		int[] one = new int[] {1, 2, 3, 4, 5};
		int[] two = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] scores = new int[3];
		
		for(int i = 0 ; i < answer.length ; i++) {
			int el = answers[i];
			
			int oneAns = one[i % one.length];
			int twoAns = two[i % two.length];
			int threeAns = three[i % three.length];
			
			if(oneAns == el) {
				scores[0]++;
			}
			if(twoAns == el) {
				scores[1]++;
			}
			if(threeAns == el) {
				scores[2]++;
			}
		}
		
		int maxValue = Math.max(scores[0], Math.max(scores[1], scores[2]));
		
		List<Integer> list = new ArrayList<Integer>();

		for(int i = 0 ; i < scores.length ; i++) {
			
			if(maxValue == scores[i]) {
				list.add(i+1);
			}
		}
		
		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}

	public static void main(String[] args) {
		int[] answers = new int[] {1,3,2,4,2};
		int[] result = new MockTest().solution(answers);
		System.out.println(Arrays.toString(result));
	}
}
