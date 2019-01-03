package programmers.stackqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

	

	/*
	 * 문제 설명 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
	 * 
	 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은
	 * 앞에 있는 기능이 배포될 때 함께 배포됩니다.
	 * 
	 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열
	 * speeds가 주어질 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
	 * 
	 * 제한 사항 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다. 작업 진도는 100 미만의
	 * 자연수입니다. 작업 속도는 100 이하의 자연수입니다. 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
	 * 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다. 입출력 예 progresses
	 * speeds return [93,30,55] [1,30,5] [2,1]
	 */
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = null;
		
		int day = 1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0 ; i < progresses.length ; i++) {
			
			progresses[i] = progresses[i] + day*speeds[i];
			
			System.out.println("day " + day	+ "의 progress : " + progresses[i]);
			
			if(progresses[i] >= 100) {
				
				if(list.isEmpty()) {
					list.add(1);
				} else {
					int temp = list.removeLast() + 1;
					list.addLast(temp);
				}
				
				continue;
			}
			
			while(progresses[i] <=100) {
				day++;
				progresses[i] = progresses[i] + speeds[i];
			}

			System.out.println("day " + day	+ "만에 성공!");
			list.add(1);
			System.out.println(list);
		}
		
		answer = new int[list.size()];
		for(int i = 0 ; i <answer.length ; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
		
		
	}

	public static void main(String[] args) {

		Solution sol = new Solution();

		int[] progresses = new int[] { 93, 30, 55 };
		int[] speeds = new int[] { 1, 30, 5 };
		sol.solution(progresses, speeds);
	}
}
