package study.code.ground;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P001_PickANumber {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int t = sc.nextInt();
			sc.nextLine();
			String[] array = sc.nextLine().split(" ");
			
			countNumber(i+1, t, array);
		}
		
		sc.close();
	}
	
	
	private static void countNumber(int testcase, int t, String[] array) {

		Set<String> set = new HashSet<String>();
		
		for(String number : array) {
			
			if(set.contains(number)) {
				set.remove(number);
			} else {
				set.add(number);
			}
		}

		int init = 0;
		int result = 0;
		boolean first = true;
		for (String string : set) {
			
			int num = Integer.parseInt(string);
			if(first) {
				result = init^num;
				first = false;
				continue;
			}
			
			result=result^num;
		}
		
		System.out.println("Case #" + testcase);
		System.out.println(result);
	}
}
