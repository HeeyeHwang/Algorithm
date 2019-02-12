package budapest.codility;

public class Lesson1 {
	public int solution(int N) {
		
		String binaryStr = Integer.toBinaryString(N);
		
		int maxGap = 0;
		int count = 0;
		
		for(char c : binaryStr.toCharArray()) {
			
			if(c == '1') {
				
				if(maxGap < count) {
					maxGap = count;
				}
				
				count = 0;
			} else {
				count++;
			}
		}

		return maxGap;
	}
	
	public static void main(String[] args) {
		
		Lesson1 lesson = new Lesson1();

		
		System.out.println(lesson.solution(1041));
		System.out.println(lesson.solution(9));
		System.out.println(lesson.solution(529));
		System.out.println(lesson.solution(15));
		System.out.println(lesson.solution(32));
		
		
		
	}
}
