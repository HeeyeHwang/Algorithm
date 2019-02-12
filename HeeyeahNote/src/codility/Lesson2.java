package budapest.codility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lesson2 {
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
	 
	 public static void main(String[] args) {
		
		 Lesson2 lesson = new Lesson2();
		 
		 int[] A = new int[] {9, 3, 9 ,3,9,7,9};
		 int rslt = lesson.solution(A);
		 System.out.println(rslt);
	}
}
