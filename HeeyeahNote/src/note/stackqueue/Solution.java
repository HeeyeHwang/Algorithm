package note.stackqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

	/*
	 * 수평 직선에 높이가 서로 다른 탑 N대를 세웠습니다. 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다. 발사한 신호는
	 * 신호를 보낸 탑보다 높은 탑에서만 수신합니다. 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.
	 * 
	 * 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 그러면, 탑은 다음과 같이 신호를
	 * 주고받습니다. 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 높이가 7인 네 번째 탑의 신호는
	 * 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 높이가 9인 두 번째 탑과
	 * 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.
	 * 
	 * 송신 탑(높이) 수신 탑(높이) 5(4) 4(7) 4(7) 2(9) 3(5) 2(9) 2(9) - 1(6) - 맨 왼쪽부터 순서대로
	 * 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return
	 * 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한 사항 heights는 길이 2 이상 100 이하인 정수 배열입니다. 모든 탑의 높이는 1 이상 100 이하입니다. 신호를
	 * 수신하는 탑이 없으면 0으로 표시합니다.
	 * 
	 * 입출력 예 heights return [6,9,5,7,4] [0,0,2,2,4] [3,9,9,3,5,7,2]
	 * [0,0,0,3,3,3,6] [1,5,3,6,7,6,5] [0,0,2,0,0,5,6]
	 */
	public int[] p1_top_heeye(int[] heights) {
		int[] answer = new int[heights.length];

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> basket = new Stack<Integer>();

		// stack setting
		for (int i = 0; i < heights.length; i++) {
			stack.push(heights[i]);
		}

		for (int i = heights.length - 1; i > 0; i--) {

			int standard = stack.pop();
			int ele = 0;
			// System.out.println("i : " + i +
			// "--------------------------------");
			// System.out.println("stnd : " + standard);

			for (int j = 0; j <= i - 1; j++) {
				ele = stack.pop();

				// System.out.println("ele : " + ele);

				if (standard < ele) {
					answer[i] = i - j;
					stack.push(ele);
					while (!basket.isEmpty()) {
						stack.push(basket.pop());
					}
					break;
				} else {
					basket.push(ele);
					// System.out.println("basket"+Arrays.toString(basket.toArray()));
				}
			}

			if (stack.isEmpty()) {
				while (!basket.isEmpty()) {
					stack.push(basket.pop());
				}
			}

			// System.out.println("stack"+Arrays.toString(stack.toArray()));
			// System.out.println("answer"+Arrays.toString(answer));
		}

		return answer;
	}

	public int[] p1_top_other(int[] heights) {
		int[] answer = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}

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
