package programmers.mock;

import java.util.Arrays;

public class D190126_Mock1 {
	
	/**
	 * 배열의 회전이란 모든 원소를 오른쪽으로 한 칸씩 이동시키고, 마지막 원소는 배열의 맨 앞에 넣는 것을 말합니다.
569815284.94.png
두 배열 arrA와 arrB가 매개변수로 주어질 때, arrA를 회전해 arrB로 만들 수 있으면 true를, 그렇지 않으면 false를 return 하는 solution 함수를 작성해주세요.
제한 조건
arrA는 길이가 1 이상 1,500 이하인 배열입니다.
arrA의 원소는 0 이상 1,500 이하인 정수입니다.
arrB는 길이가 1 이상 1,500 이하인 배열입니다
arrB의 원소는 0 이상 1,500 이하인 정수입니다.
입출력 예
arrA	arrB	return
[7, 8, 10]	[10, 7, 8]	true
[4, 3, 2, 1]	[5, 4, 1, 2]	false
입출력 예 설명
예시 #1
arrA 배열을 한 번 회전하면 arrB와 같아집니다.
예시 #2
arrA 배열은 아무리 회전해도 arrB와 같지 않습니다.
	 * @param arrA
	 * @param arrB
	 * @return
	 */
	 public boolean solution(int[] arrA, int[] arrB) {
	        
	        for(int i = 0 ; i < arrA.length ; i++) {
	        	
	        	// turn!
	        	int temp = arrA[arrA.length -1];
	        	for(int j = arrA.length-1 ; j > 0 ; j--) {
	        		arrA[j] = arrA[j-1];
	        	}
	        	arrA[0] = temp;
	        	
//	        	System.out.println(Arrays.toString(arrA));
	        	if(Arrays.equals(arrA, arrB)) {
	        		return true;
	        	}
	        }
	        
	        return false;
	    }

	
	public static void main(String[] args) {
		
		int[] arrA = new int[] {4, 3, 2, 1};
		int[] arrB = new int[] {5, 4, 1, 2};
		
		boolean rslt = new D190126_Mock1().solution(arrA, arrB);
		System.out.println(rslt);
	}
}
