package study._2017.live.coding._171209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deque {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> deque = new ArrayList<Integer>();
		int commandCnt = sc.nextInt();
		String command;
		sc.nextLine();
		for(int i = 0 ; i < commandCnt ; i++) {
			command = sc.nextLine();
			deque(command, deque);
		}
		sc.close();
	}
	
	private static void deque(String command, List<Integer> deque) {
		
		if(command.startsWith("push")) {
			String[] pushArr = command.split(" ");
			int pushNumber = Integer.parseInt(pushArr[1]);
			
			switch (pushArr[0]) {
			case "push_front":
				deque.add(0, pushNumber);
				break;
			case "push_back":
				deque.add(pushNumber);
				break;
			default:
				break;
			}
		}
		
		switch (command) {
		case "pop_front":
			
			if(deque.isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(deque.get(0));
				deque.remove(0);
			}
			break;

		case "pop_back":
		
			if(deque.isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(deque.get(deque.size()-1));
				deque.remove(deque.size()-1);
			}
			break;

		case "size":
			System.out.println(deque.size());
			break;

		case "empty":
			if(deque.isEmpty()) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			break;
		case "front":
			if(deque.isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(deque.get(0));
			}
			break;
		case "back":
			if(deque.isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(deque.get(deque.size()-1));
			}
			break;

		default:
			break;
		}
		
	}
}
