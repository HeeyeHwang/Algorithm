package study._2017.mine._171216;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * SW Expert Academy
 * 1228, 1229, 1230 암호문
 */
public class Cryptogram {
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		int cryptNum;
		String[] cryptArray;
		List<String> cryptList;
		for(int i = 0 ; i < 10 ; i++) {
			List<Integer> original = new LinkedList<Integer>();
			num = sc.nextInt();
			sc.nextLine();
			String[] line = sc.nextLine().split(" ");
			for(int j = 0 ; j < num ; j++) {
				original.add(Integer.parseInt(line[j]));
			}
			cryptNum = sc.nextInt();
			sc.nextLine();
			cryptArray = sc.nextLine().split(" ");
			cryptList = Arrays.asList(cryptArray);
			
//			cryptogram1(num, original, cryptNum, cryptList, i+1);
//			cryptogram2(num, original, cryptNum, cryptList, i+1);
			cryptogram3(num, original, cryptNum, cryptList, i+1);
		}
		
		sc.close();
	}
	
	private static void cryptogram1(int num, List<Integer> original, int cryptNum, List<String> cryptList, int testcase) {
			
			Iterator<String> cryptIt = cryptList.iterator();
			
			while(cryptIt.hasNext()) {
				String element = cryptIt.next();
				int x, y, add;
				if("I".equals(element)) {
					x = Integer.parseInt(cryptIt.next());
					y = Integer.parseInt(cryptIt.next());
					
					for(int i = x ; i < y + x ; i++) {
						add = Integer.parseInt(cryptIt.next());
						original.add(i, add);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < 10 ; i++) {
				sb.append(original.get(i)).append(" ");
			}
			
			System.out.println("#" + testcase + " " + sb.toString().trim());
		}

	private static void cryptogram2(int num, List<Integer> original, int cryptNum, List<String> cryptList, int testcase) {
		
		Iterator<String> cryptIt = cryptList.iterator();
		
		while(cryptIt.hasNext()) {
			String element = cryptIt.next();
			int x, y, add;
			if("I".equals(element)) {
				x = Integer.parseInt(cryptIt.next());
				y = Integer.parseInt(cryptIt.next());
				
				for(int i = x ; i < y + x ; i++) {
					add = Integer.parseInt(cryptIt.next());
					original.add(i, add);
				}
			} else if("D".equals(element)) {
				x = Integer.parseInt(cryptIt.next());
				y = Integer.parseInt(cryptIt.next());
				
				for(int i = 0 ; i < y ; i++) {
					original.remove(x);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 10 ; i++) {
			sb.append(original.get(i)).append(" ");
		}
		
		System.out.println("#" + testcase + " " + sb.toString().trim());
	}
	
	private static void cryptogram3(int num, List<Integer> original, int cryptNum, List<String> cryptList, int testcase) {
		
		Iterator<String> cryptIt = cryptList.iterator();
		
		while(cryptIt.hasNext()) {
			String element = cryptIt.next();
			int x, y, add;
			if("I".equals(element)) {
				x = Integer.parseInt(cryptIt.next());
				y = Integer.parseInt(cryptIt.next());
				
				for(int i = x ; i < y + x ; i++) {
					add = Integer.parseInt(cryptIt.next());
					original.add(i, add);
				}
			} else if("D".equals(element)) {
				x = Integer.parseInt(cryptIt.next());
				y = Integer.parseInt(cryptIt.next());
				
				for(int i = 0 ; i < y ; i++) {
					original.remove(x); // warn
				}
			} else if("A".equals(element)) {
				x = Integer.parseInt(cryptIt.next());
				for(int i = 0 ; i < x ; i++) {
					add = Integer.parseInt(cryptIt.next());
					original.add(add);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 10 ; i++) {
			sb.append(original.get(i)).append(" ");
		}
		
		System.out.println("#" + testcase + " " + sb.toString().trim());
	}
}
