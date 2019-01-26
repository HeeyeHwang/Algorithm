package programmers.greedy;

import java.util.Arrays;

public class IntermittentCamera {

	/*
	  
	  겹치는 구간에서 카메라를 설치하는 spot은 그 구간 중에서도 제일 오른쪽이기 때문에
	  도착점을 기준으로 오름차순 정렬을 해서 단속카메라를 설치할 지점을 계산하면 된다.

	 */
	public int solution(int[][] routes) {
		int answer = 0;

		// stream 자주 써보기.
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

		int min = Integer.MIN_VALUE;
		for(int i = 0 ; i <routes.length ; i++) {
			
			if(min < routes[i][0]) {
				min = routes[i][1];
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[][] routes = new int[][] { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		int rslt = new IntermittentCamera().solution(routes);
		System.out.println(rslt);
	}
}
