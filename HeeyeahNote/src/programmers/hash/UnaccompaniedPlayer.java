package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UnaccompaniedPlayer {

	/*
	 * 완주하지 못한 선수 문제 설명 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을
	 * 완주하였습니다.
	 * 
	 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질
	 * 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. completion의 길이는
	 * participant의 길이보다 1 작습니다. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 참가자
	 * 중에는 동명이인이 있을 수 있습니다. 입출력 예 participant completion return [leo, kiki,
	 * eden] [eden, kiki] leo [marina, josipa, nikola, vinko, filipa] [josipa,
	 * filipa, marina, nikola] vinko [mislav, stanko, mislav, ana] [stanko, ana,
	 * mislav] mislav 입출력 예 설명 예제 #1 leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지
	 * 못했습니다.
	 * 
	 * 예제 #2 vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
	 * 
	 * 예제 #3 mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
	 * 
	 * 출처
	 * 
	 * Solution.java
	 * 
	 * 1 class Solution { 2 public String solution(String[] participant,
	 * String[] completion) { 3 String answer = ""; 4 return answer; 5 } 6 } 실행
	 * 결과 실행 결과가 여기에 표시됩니다.
	 */
	
	public String unaccompaniedPlayer(String[] participant, String[] completion) {
		
		Map<String, Integer> participantMap = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < participant.length ; i++) {
			
			String key = participant[i];
			if(!participantMap.containsKey(key)) {
				participantMap.put(key, 1);
			} else {
				int cnt = participantMap.get(key);
				participantMap.put(key, cnt+1);
			}
		}
		
		for(int i = 0 ; i < completion.length ; i++) {
			
			String key = completion[i];
			
			if(!participantMap.containsKey(key)) {
				return key;
			} else {
				int cnt = participantMap.get(key);
				if(cnt == 1) {
					participantMap.remove(key);
				} else if(cnt > 1) {
					participantMap.put(key, cnt -1);
				}
			}
		}

		Set<String> lastKey = participantMap.keySet();
		
		Iterator<String> itr = lastKey.iterator();

		return itr.next();
	}
	
	public String hash1(String[] participant, String[] completion) {

		String answer = null;

		for (int i = 0; i < completion.length; i++) {

			for (int j = 0; j < participant.length; j++) {

				if (completion[i] != null && completion[i].equals(participant[j])) {
					participant[j] = null;
					completion[i] = null;
				}
			}
		}

		for (int i = 0; i < participant.length; i++) {
			if (participant[i] != null) {
				answer = participant[i];
			}
		}

		return answer;
	}

	public String hash1_1(String[] participant, String[] completion) {
		String answer = null;

		// System.out.println(Math.pow(2, 17)); = 131072.0

		Arrays.sort(participant);
		Arrays.sort(completion);

		System.out.println(Arrays.toString(participant));
		System.out.println(Arrays.toString(completion));

		int i;
		for (i = 0; i < completion.length; i++) {

			String partici = participant[i];
			String comple = completion[i];

			if (!partici.equals(comple)) {
				answer = partici;
				return answer;
			}
		}
		answer = participant[i];
		return answer;
	}

	

	

	public static void main(String[] args) {

	}
}
