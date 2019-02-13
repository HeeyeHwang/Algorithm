package programmers.brute.force.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBaseball {

	public int solution(int[][] baseball) {
		
		List<String> listOfTotalCase = new ArrayList<String>();
		
		for(int i = 1 ; i < 10 ; i++) {
			for(int j = 1 ; j < 10 ; j++) {
				for(int k = 1 ; k < 10 ; k++) {
					if(i != j && j != k && k != i) {
						listOfTotalCase.add(String.valueOf(i*100 + j*10 + k));
					}
				}
			}
		}
		
		Set<String> listOfPossibleCase = new HashSet<String>();

		for(String eachCase : listOfTotalCase) {

			boolean isFailure = false;
			for(int i = 0 ; i <baseball.length ;i++) {
				
				String round = String.valueOf(baseball[i][0]);
				int strike = baseball[i][1];
				int ball = baseball[i][2];
				
				int strikeCase = getPossibleStrike(round, eachCase);
				int ballCase = getPossibleBall(round, eachCase) - strikeCase;
				
				if(strikeCase != strike || ballCase != ball) {
					isFailure = true;
				}
			}
			
			if(!isFailure) {
				listOfPossibleCase.add(eachCase);
			}
		}
		
		return listOfPossibleCase.size();
	}
	
	int getPossibleStrike(String round, String possibeCase) {
		
		int cnt = 0;
		for(int i = 0 ; i < possibeCase.length() ; i++) {
			cnt = (round.charAt(i) == possibeCase.charAt(i)) ? cnt + 1 : cnt;
		}
		
		return cnt;
	}
	
	int getPossibleBall(String round, String possibeCase) {
		
		int cnt = 0;
		for(int i = 0 ; i < possibeCase.length() ; i++) {
			cnt = (possibeCase.contains(round.charAt(i)+"")) ? cnt + 1 : cnt;
		}
		
		return cnt;
	}
	
	

	public static void main(String[] args) {
		int[][] input = new int[][] { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		int rslt = new NumberBaseball().solution(input);
		System.out.println(rslt);
		


	}
}
