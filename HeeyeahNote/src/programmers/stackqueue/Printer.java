package programmers.stackqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Printer {

	public static void main(String[] args) {
		int[] priorities = new int[] {1, 1, 9, 1, 1, 1};
		int location = 0;
		int rslt = new Printer().solution(priorities, location);
		System.out.printf("result : %d", rslt);
	}
	
	public int solution(int[] priorities, int location) {
		
		int orderedLoc = 1;
		LinkedList<Node> queue = new LinkedList<Node>();
		Map<Integer, Node> orderedMap = new HashMap<Integer, Node>();
		
		
		for(int i = 0 ; i < priorities.length ; i++) {
			queue.add(new Node(i, priorities[i]));
		}

		
		while(!queue.isEmpty()) {
			
			Node first = queue.pop();
			
			if(!queue.isEmpty()) {
				boolean flag = false;
				for(int i = 0; i < queue.size() ; i++) {
					Node compareNode = queue.get(i);
					if(compareNode.getPriority() > first.getPriority()) {
						queue.add(first);
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					first.setOrderLoc(orderedLoc++);
					orderedMap.put(first.getLoc(), first);
				}
			} 
			
			// last node
			else {
				first.setOrderLoc(orderedLoc++);
				orderedMap.put(first.getLoc(), first);
			}

		}
		
		return orderedMap.get(location).getOrderLoc();
	}
}

class Node {
	
	private int loc;
	private int priority;
	private int orderLoc;

	public Node(int loc, int priority) {
		this.loc = loc;
		this.priority = priority;
	}
	public int getLoc() {
		return loc;
	}
	public int getPriority() {
		return priority;
	}
	public int getOrderLoc() {
		return orderLoc;
	}
	public void setOrderLoc(int orderLoc) {
		this.orderLoc = orderLoc;
	}
}
