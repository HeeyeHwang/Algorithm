package study._2017.live.coding._180106;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			sc.nextLine();
			
			StringBuilder sb = new StringBuilder();
			  
			for(int j = 0 ; j < h ; j++) {
				String line = sc.nextLine();
				sb.append(line);
			}

			getBinaryCode(i+1, sb.toString());
		}
		sc.close();
	}
	
	private static void getBinaryCode(int testcase, String target) {


//		System.out.println(target);
		
		int index = 0;
		for(int i = target.length() ; i > 0 ; i--) {
			char ch=target.charAt(i -1);
			
			if(ch == '1') {
				index = i;
				break;
			}
		}

		String finalCode = target.substring(index-56, index);
		
//		System.out.println("finalCode : " + finalCode);

		System.out.println("#" + testcase + " " + verifyCode(finalCode));
	}
	
	private static int verifyCode(String finalCode) {
		
		Map<String, Integer> codeMap = new HashMap<String, Integer>();
		
		codeMap.put("0001101", 0);
		codeMap.put("0011001", 1);
		codeMap.put("0010011", 2);
		codeMap.put("0111101", 3);
		codeMap.put("0100011", 4);
		codeMap.put("0110001", 5);
		codeMap.put("0101111", 6);
		codeMap.put("0111011", 7);
		codeMap.put("0110111", 8);
		codeMap.put("0001011", 9);
		
		int verifyCode = 0;
		int evenSum = 0;
		int oddSum = 0;
		for(int i = 0 ; i < 8 ; i++) {

			String text = finalCode.substring(7*i, 7*i + 7);
			int value = codeMap.get(text);
			
//			System.out.println(String.format("key : %s, value : %d", text, value));
			
			if(i == 7) {
//				System.out.println("verify code : " + value);
				verifyCode = value;
			} else if(i % 2 == 0) {
//				System.out.println("even : " + value);
				oddSum += value;
			} else if(i % 2 == 1) {
//				System.out.println("odd : " + value);
				evenSum += value;
			}
			
		}
		if((oddSum*3 + evenSum + verifyCode) % 10 == 0) {
			return evenSum + oddSum + verifyCode;
		} else {
			return 0;
		}
	}
}
