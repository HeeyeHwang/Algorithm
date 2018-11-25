package programmers.dp;

import java.util.Arrays;

public class TileOrnaments {
	public long solution(int N) {
        long answer = 0;
        
        long[] dp = new long[N];
        
        for(int i = 0 ; i < N ; i++) {
        	
        	if( i < 2) {
        		dp[i] = 1;
        	} else {
        		dp[i] = dp[i-1]  + dp[i-2];
        	}
        }
        
        if( N == 1) {
        	answer = 4;
        } else if ( N == 2) {
        	answer = 6;
        } else if ( N == 3) {
        	answer = 10;
        } else {
        	answer = 3*dp[N-1] + 2*(dp[N-2] + dp[N-3]) + dp[N-4];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		long rslt = new TileOrnaments().solution(6);
		
		System.out.println(rslt);
	}
}
