package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class StockPrice {

	public int[] solution(int[] prices) {
        
		int[] answer = new int[prices.length];

		LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0 ; i < prices.length ; i++) {
        	queue.offer(prices[i]);
        }

        int idx = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        while(!queue.isEmpty()) {
        	
        	int curr = queue.poll();
        	if(queue.isEmpty()) {
        		break;
        	}
        	
        	int time = 1;
        	while(!queue.isEmpty() && curr <= queue.peek()) {
        		stack.push(queue.poll());
        		time++;
        	}
        	
        	if(queue.isEmpty()) {
        		answer[idx] = time -1;
        	} else {
        		answer[idx] = time;
        	}
        	idx++;

        	while(!stack.isEmpty()) {
        		queue.push(stack.pop());
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] prices = new int[] {498,501,470,489};
		int[] result = new StockPrice().solution(prices);
		System.out.println(Arrays.toString(result));
	}
}
