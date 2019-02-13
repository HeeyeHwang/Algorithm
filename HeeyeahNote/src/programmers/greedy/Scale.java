package programmers.greedy;

import java.util.Arrays;

public class Scale {

	public int solution(int[] weight) {
        
		int answer = 1;
       
        Arrays.sort(weight);

        for(int el : weight) {
        	
        	if(answer < el) {
        		break;
        	}
        	answer += el;
        }
        
       
        return answer;
    }
	public static void main(String[] args) {
	
		int[] weight = new int[] {3, 1, 6, 2, 7, 30, 1};
		int rslt = new Scale().solution(weight);
		System.out.println(rslt);
	}
}
