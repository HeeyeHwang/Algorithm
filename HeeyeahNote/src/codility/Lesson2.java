package codility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lesson2 {
	
	//OddOccurrencesInArray
	 public int solution(int[] A) {

		 Set<Integer> set = new HashSet<Integer>();
		 
		 for(int a : A) {
		
			 if(set.contains(a)) {
				 set.remove(a);
			 } else {
				 set.add(a);
			 }
		 }

		 Iterator<Integer> itr = set.iterator();
		 
		 return itr.next();
	 }
	 
	 
	 //CyclicRotation
	 public int[] solution(int[] A, int K) {
		 
		 if(A.length == 0 || A == null) {
			 return A;
		 }
		 
		 int length = A.length;
		 int rotate = K % length;
		 int[] result = new int[length];
		 
		 for(int i = 0 ; i < length ; i++) {
			 int index = (i+rotate) % length;
			 result[index] = A[i];
		 }
		 
		 return result;
	 }
	 
	 public static void main(String[] args) {
		
		 Lesson2 lesson = new Lesson2();
		 
		 int[] A = new int[] {3,8,9,7,6};
		 int[] rsltArr = lesson.solution(A, 4);
		 
	}
}
