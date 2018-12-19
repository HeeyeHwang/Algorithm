package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P10866_Deque_array {

	/**
	 * 
	 * 15 push_back 1 push_front 2 front back size empty pop_front pop_back
	 * pop_front size empty pop_back push_front 3 empty front
	 * 
	 * 
	 * @param args
	 */

	public static int[] repo = new int[10000];
	public static int repoSize = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		String[] commands = new String[n];
		for (int i = 0; i < n; i++) {
			commands[i] = sc.nextLine();
		}

		commandDeque(n, commands);
		sc.close();
	}

	private static void commandDeque(int n, String[] commands) {
		
		for(int i = 0 ; i<n ; i++) {
		
			String command = commands[i];
			
			if(command.startsWith("push")) {
				
				int target = Integer.parseInt(command.split(" ")[1]);
				
				if(command.contains("front")) {
					push_front(target);
				} else {
					push_back(target);
				}
				
//				System.out.printf("push : %d : %s\n", target, Arrays.toString(repo));
				continue;
			}
			
			switch (command) {
			case "pop_front":
				System.out.println(pop_front());
				break;
				
			case "pop_back":
				System.out.println(pop_back());
				break;
				
			case "size":
				System.out.println(size());
				break;
				
			case "empty":
				System.out.println(empty());
				break;
				
			case "front":
				System.out.println(front());
				break;
				
			case "back":
				System.out.println(back());
				break;
				

			default:
				break;
			}
//		System.out.printf("    :: size %d, front %d    ::", repoSize, repo[0]);	
		}
	}

	private static void push_front(int n) {

		if (repoSize > 0) {
			for (int i = repoSize; i >0 ; i--) {
				repo[i] = repo[i-1];
			}
		}
		
		repo[0] = n;
		repoSize++;
	}

	private static void push_back(int n) {
		repo[repoSize] = n;
		repoSize++;
	}
	
	private static int pop_front() {
		if(repoSize == 0) {
			return -1;
		}
		
		int pop = repo[0];
		
		for(int i = 0 ; i <repoSize-1 ; i++) {
			repo[i] = repo[i+1];
		}
		
		repoSize--;
		return pop;
	}
	
	private static int pop_back() {

		if(repoSize  == 0) {
			return -1;
		}
		
		int pop = repo[repoSize -1];
		
		repoSize--;
		return pop;
	}
	
	private static int size() {
		return repoSize;
	}
	
	private static int empty() {
		if(repoSize > 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	private static int front() {
		if (repoSize > 0) {
			return repo[0];
		} else {
			return -1;
		}
	}
	
	private static int back() {
		if(repoSize > 0) {
			return repo[repoSize-1];
		} else {
			return -1;
		}
	}
}
