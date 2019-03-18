package programmers.heap;

/**
 * TODO not yet solved XP
 * @author heeye
 */
public class DiskController {

	public int solution(int[][] jobs) {
			
		/*
		 * 1. 작업시간이 짧은 것부터 먼저 와야 함.
		 * 2. 우선순위 큐를 설정할 때, process 시작 순으로 정렬, 같은 시간이면 소요시간이 작은 걸로 .
		 * 3. 현재 시간+ 시작시간 을 기준으로.
		 */

		
		
		
		return 0;
	}

	public static void main(String[] args) {

		int[][] jobs = new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		int rslt = new DiskController().solution(jobs);
		System.out.println(rslt);
	}
}
