package programmers.greedy;

public class JoyStick {

	public int solution(String name) {

		/*
		 
		  알파벳을 바꾸는 건, 두 알파벳의 gap을 구하고 gap과 26-gap의 최소값을 선택해서 더하면 된다.
		  문제는 이동할 때의 최소 경로인데, 시작은 항상 첫번째 포인트에서 해야 한다.
		  첫번째 커서에서 최소로 움직이려면 제일 마지막부분의 문자열과 첫글자를 제외한 첫부분의 문자열에 AAAA와 같은 연결된 A문자열이 어느쪽이 더 짧은가 이다.
		  어차피 문자열 중간에 A가 있어봤자 그 뒤에 변경해야 할 알파벳이 있으면 커서를 움직여야하기 때문에 시작을 어느방향으로 할 지만 결정하면 된다.
		  그래서 start와 end count를 세서, 답을 구했는데 조 --- 금 풀이가 더러운 것 같다:)
		  
		 */
		
		int answer = 0;
        
		// change alphabet
		for(char c : name.toCharArray()) {
        	int gap = c - 'A';
        	int minGap = Math.min(gap, 26 - gap);
        	answer += minGap;
		}

		name = name.substring(1);
		int startCnt = 0;
		for(char c : name.toCharArray()) {
			if(c != 'A') {
				break;
			} else {
				startCnt++;
			}
		}
		
		int endCnt = 0;
		name = new StringBuilder(name).reverse().toString();
		for(char c : name.toCharArray()) {
			if(c != 'A') {
				break;
			} else {
				endCnt++;
			}
		}
		
		if(startCnt == 0 && endCnt == 0) {
			answer += name.length() ;
		} else if(startCnt == endCnt && startCnt == name.length()) {
			//skip
		} else {
			answer += name.length() - Math.max(startCnt, endCnt);
		}
		
        return answer;
    }
	public static void main(String[] args) {
	
		String name = "JEROEN";
		int rslt = new JoyStick().solution(name);
		System.out.println(rslt);
	}
}
