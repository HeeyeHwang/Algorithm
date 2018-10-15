package note.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

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

	public boolean hash2(String[] phoneBook) {

		Arrays.sort(phoneBook);

		System.out.println(Arrays.toString(phoneBook));
		String stnd;
		for (int i = 0; i < phoneBook.length; i++) {
			stnd = phoneBook[i];

			for (int j = i + 1; j < phoneBook.length; j++) {

				if (phoneBook[j].startsWith(stnd)) {
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
	 * 
	 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로
	 * 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
	 * 
	 * 종류 이름 얼굴 동그란 안경, 검정 선글라스 상의 파란색 티셔츠 하의 청바지 겉옷 긴 코트 스파이가 가진 의상들이 담긴 2차원 배열
	 * clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다. 스파이가 가진 의상의 수는 0개 이상 30개
	 * 이하입니다. 같은 이름을 가진 의상은 존재하지 않습니다. clothes의 모든 원소는 문자열로 이루어져 있습니다. 모든 문자열의
	 * 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다. 스파이는 하루에 최소 한 개의 의상은
	 * 입습니다.
	 */
	public int hash3(String[][] clothes) {

	
		
		return 0;
	}

	public static void main(String[] args) {

	}
}
