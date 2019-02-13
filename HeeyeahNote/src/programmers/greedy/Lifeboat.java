package programmers.greedy;

import java.util.Arrays;

public class Lifeboat {

	public int solution(int[] people, int limit) {
        
		/*
		 
		 구명보트를 제일 적게 사용하면서 다 태울 수 있는 방법은, 몸무게가 작은사람과 큰사람을 같이 태워서 보내는 것이다.
		 그러려면 배열을 정렬해서, 제일 몸무게가 작은 사람과 큰 사람을 하나씩 매칭시켜가며 보트에 태워보낸다.
		 작은 사람과 큰 사람의 무게를 합했는데 limit이 넘어버린다면, 그 큰 사람은 어느 누구와 매칭되도 못타기때문에 혼자 태워 보낸다.
		 문제 풀면서 간과했던 중요한 조건 중 하나가 2명만 탈 수 있다는 것인데, 2명이기 때문에 max와 min의 조합으로 생각해서 풀 수 있는 것 같다.
		 만약 2명이라는 제약 조건이 없었으면, limit를 최대한 맞추기 위해 경우의 수를 생각해야 했을 것이다. (그게 내가 삽질한 포인트기도 하다.) 
		  
		 */

		
		Arrays.sort(people);

		int start = 0;
		int end = people.length -1;
		
		for(; start < end ; end--) {
			
			if(people[start] + people[end] <= limit) {
				start++;
			}
		}
		
		return people.length - start; // people.length 에서 start	를 빼야, 혼자 가든 최소몸무게랑 같이 가든 하는 사람이었을 것이다.
    }
	
	public static void main(String[] args) {
		int[] people = new int[] {70, 80, 50,50};
		int limit = 100;
		int rslt = new Lifeboat().solution(people, limit);
		System.out.println(rslt);
	}
}
