package study._2017.live.coding._171202;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekQueue {

	private static int signQueue(List<Integer> queue, String command) {
		
		int result = 0;
		if(command.startsWith("push")) {
			int push = Integer.parseInt(command.split(" ")[1]);
			queue.add(push);
			return -221;
		}
		
		switch (command) {
		case "pop":
			
			if(queue.isEmpty()) {
				result = -1;
			} else {
				result = queue.get(0);
				queue.remove(0);
			}
			
			break;
		case "size":
			result = queue.size();
			break;
		case "empty":
			if(queue.isEmpty()) {
				result = 1;
			} else {
				result = 0;
			}
			break;
		case "front":
			if(queue.isEmpty()) {
				result = -1;
			} else {
				result = queue.get(0);
			}
			break;
		case "back":
			if(queue.isEmpty()) {
				result = -1;
			} else {
				result = queue.get(queue.size()-1);
			}
			break;
		default:
			break;
		}
		
		return result;
	}
	
	public static void main(String[] args) {

		
		List<Integer> queue = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		int commandCnt = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i < commandCnt ; i++) {
			String command = sc.nextLine();
			int result =signQueue(queue, command);
			
			if(result != -221) {
				System.out.println(result);
			}
		}
	}
}
