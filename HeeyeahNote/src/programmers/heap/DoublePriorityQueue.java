package programmers.heap;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO not yet solved XP
 * @author heeye
 */
public class DoublePriorityQueue {

	public static void main(String[] args) {

		String[] operations = new String[] {"I 16", "D 1"};
		int[] rslt = new DoublePriorityQueue().solution(operations);
		System.out.println(Arrays.toString(rslt));
	}
	
	public int[] solution(String[] operations) {
        
		/**
		 * 
		 * 얘로 풀어볼 것
		 * linkedlist + sort반복
		 *
		 */
		Deque<Integer> dq = new LinkedList<Integer>();
		
		
		int[] answer = {};
        
        
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
	
        for(int i = 0 ; i < operations.length ; i++) {
        	
        	String[] arr = operations[i].split(" ");
        	
        	if(arr[0] == "I") {
        		queue.offer(Integer.parseInt(arr[1]));
        	} else if (arr[0] == "D") {
        		if(!queue.isEmpty()) {
        			
        			if(arr[1] == "1") {
        				queue.poll();
        			} else if(arr[1] == "-1") {
        			}
        			
        		}
        	}
        	
        }
        
        return answer;
    }
	
}
