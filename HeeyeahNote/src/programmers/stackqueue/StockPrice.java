package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class StockPrice {

	public int[] solution(int[] prices) {
        
		int[] answer = new int[prices.length];

		// queue에 입력
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
        		stack.push(queue.poll()); // 현재 값보다 큰 값이 나올 때까지 큐에서 poll해서 stack에 push, while문에 empty체크는 while돌다가 다 뽑을 수도 있어서 추가
        		time++;
        	}
        	
        	if(queue.isEmpty()) {
        		answer[idx] = time -1;
        	} else {
        		answer[idx] = time;
        	}
        	idx++;

        	while(!stack.isEmpty()) {
        		queue.push(stack.pop()); // stack에 넣어놨던 값들을 다시 꺼내서 queue에 push
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
