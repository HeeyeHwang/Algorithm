package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

	public static void main(String[] args) {
	
		int[] scoville = new int[] {0,0,2};
		int K = 3;
		int rslt = new MoreSpicy().solution(scoville, K);
		System.out.println("rslt "+rslt);
	}
	
	public int solution(int[] scoville, int K) {
		
		int answer = 0;
		
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i < scoville.length ; i++) {
			queue.offer(scoville[i]);
		}

		while(!queue.isEmpty()) {
			
			if(queue.peek() >= K) {
				return answer;
			}

			if(queue.size() == 1) {
				if(queue.peek() >= K) {
					return answer;
				} else {
					return -1;
				}
			}
			
			int min = queue.poll();
			int min2 = queue.poll();
			int val = min + 2*min2;
			
			queue.offer(val);
			answer++;
		}
		
		return answer;
	}
	
	public int solution_bak(int[] scoville, int K) {
		
		int answer = 0;
		int point = 0;
		Arrays.sort(scoville);
		
		while(point < scoville.length) {
			
			System.out.printf("====point [%02d]===================================\n", point);
			System.out.println(Arrays.toString(Arrays.copyOf(scoville, 10)));
			if(scoville[point] >= K) {
				return answer;
			}
			
			int val = scoville[point] + scoville[point +1] * 2;
			scoville[++point] = val;

			answer++;
			
			System.out.println("====after value=================================");
			System.out.println(Arrays.toString(Arrays.copyOf(scoville, 10)));
			int currPoint = point;
			while(true) {
				System.out.println("--------------------");
				System.out.println("curr : " +currPoint);
				int leftPoint = currPoint*2;
				int rightPoint = currPoint*2 +1; // left<right 되어있음

				int curr = scoville[point];

				if(leftPoint < scoville.length && curr > scoville[leftPoint]) {
					System.out.println("bigger than left");
					int temp = curr;
					scoville[currPoint] = scoville[leftPoint];
					scoville[leftPoint] = temp;
					currPoint = leftPoint;
				} else if (rightPoint < scoville.length && curr > scoville[rightPoint]) {
					System.out.println("bigger than right");
					int temp = curr;
					scoville[currPoint] = scoville[rightPoint];
					scoville[rightPoint] = temp;
					currPoint = rightPoint;
				} else {
					System.out.println("stop");
					break;
				}
			}
			
		}
		
		
		return answer;
	}
}
