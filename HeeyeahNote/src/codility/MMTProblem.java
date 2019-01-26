package codility;

import java.util.Stack;

public class MMTProblem {

	public static void main(String[] args) {
		String str = "SMS messages are really great";
		int rslt = new MMTProblem().solution(str, 12);
		System.out.println(rslt);
	}
	
	public int solution(String str, int k) {
	
		String[] strArr = str.split(" ");
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = strArr.length -1 ; i >= 0 ; i--) {
			stack.push(strArr[i].length());
		}
		
		// 3 8 3 6 13
		int count = 0;
		int totalLength = 0;
		while(!stack.isEmpty()) {
			
			int currLength = stack.pop();
			
			if(currLength > k) {
				return -1;
			}
			
			if(totalLength == 0) {
				totalLength = currLength;
			} else {
				totalLength += currLength + 1;
			}
			
			if(totalLength > k) {
				stack.push(currLength);
				count++;
				totalLength = 0;
			} 
		}
		
		if(totalLength <= k) {
			count++;
		}
		
		return count;
	}
}
