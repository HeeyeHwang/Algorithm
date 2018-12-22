package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P9996_missKorea {

	/**
	 * 3
a*d
abcd
anestonestod
facebook
	 * @param args
	 */
	static String pattern;
	static String[] lines;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		pattern = sc.nextLine();
		lines = new String[n];
		for(int i = 0 ; i < n ; i++) {
			lines[i] = sc.nextLine();
		}

		missKorea2();
		
		sc.close();
	}
	
	private static void missKorea2() {
		
		String[] patternSplit = pattern.split("\\*");
		
		String first = patternSplit[0];
		String last = patternSplit[1];
		
		for(int i = 0 ; i < lines.length ; i++) {
			String line = lines[i];
			
			if(line.startsWith(first)) {
				
				line = line.substring(first.length());
				if(line.endsWith(last)) {
					System.out.println("DA");
				} else {
					System.out.println("NE");
				}
			} else {
				System.out.println("NE");
			}
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	private static void missKorea() {
		
		String[] patternSplit = pattern.split("\\*");
		
		String first = patternSplit[0];
		String last = patternSplit[1];
		for(int i = 0 ; i < lines.length ; i++) {
			String line = lines[i];
			
			
			
			if(line.startsWith(first) && line.endsWith(last)) {
				System.out.println("DA");
			} else {
				System.out.println("NE");         
			}
		}
	}
	
}
