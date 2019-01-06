package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DevelopFunction {

	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> answers = new LinkedList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			int progress = progresses[i];
			int speed = speeds[i];
			int time = (int) Math.ceil((100 - progress) / (double) speed);
			
			queue.offer(time);
		}
		

		while(!queue.isEmpty()) {
			
			int curr = queue.poll();
			int cnt = 1;
			while(!queue.isEmpty() && curr >= queue.peek()) {
				queue.poll();
				cnt++;
			}
			
			answers.offer(cnt);
		}
		
		int size = answers.size();
		int[] answer = new int[size];
		
		for(int i = 0 ; i < size ; i++) {
			answer[i] = answers.poll();
		}
		
		return answer;
	}

	public static void main(String[] args) {

		DevelopFunction sol = new DevelopFunction();

//		int[] progresses = new int[] { 93, 30, 55 };
//		int[] speeds = new int[] { 1, 30, 5 };
//		int[] progresses = new int[] { 40, 93, 30, 55, 60, 65 };
//		int[] speeds = new int[] { 60, 1, 30, 5, 10, 7 };
		int[] progresses = new int[] { 93, 30, 55, 60, 40, 65 };
		int[] speeds = new int[] { 1, 30, 5 , 10, 60, 7 };
		int[] rslt = sol.solution(progresses, speeds);
		
		System.out.println(Arrays.toString(rslt));
	}
}
