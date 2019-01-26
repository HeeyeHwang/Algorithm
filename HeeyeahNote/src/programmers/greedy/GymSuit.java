package programmers.greedy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GymSuit {

	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        
        
        for(int i = 0 ; i < reserve.length ; i++) {
        	
        	if(lostSet.contains(reserve[i])) {
        		lostSet.remove(reserve[i]);
        		continue;
        	}
        	
        	if(lostSet.contains(reserve[i] + 1)) {
        		lostSet.remove(reserve[i] + 1);
        		continue;
        	}
        	
        	if(lostSet.contains(reserve[i] - 1)) {
        		lostSet.remove(reserve[i] - 1);
        		continue;
        	}
        }
        
        answer = n - lostSet.size();
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int n = 5;
		int[] lost = new int[] {2, 3, 4};
		int[] reserve = new int[] {3, 4, 5};
		int rslt = new GymSuit().solution(n, lost, reserve);
		System.out.println(rslt);
	}
}
