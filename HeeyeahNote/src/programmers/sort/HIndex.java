package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HIndex {

	public int solution(int[] citations) {

		List<Integer> citationsList = new ArrayList<Integer>();

		for(int citation : citations) {
			citationsList.add(citation);
		}
		
		Collections.sort(citationsList, Comparator.reverseOrder());
		
		System.out.println(citationsList);

		
        
        int total = citations.length;
        int index = 0;
        for(int i = citations.length -1 ; i >= 0 ; i--) {
        	
        	index++;
        	int count = citations[i];
        	
        	System.out.printf("index %d / count %d / rest %d \n",index, count, total-index);
        	
        	if(count >= index ) {
        		if(total - index <= index) {
        			return index;
        		}
        	}
        }
        
        return index;
    }
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {3, 0, 6, 1, 5};
		int rslt = new HIndex().solution(arr);
		System.out.println(rslt);
	}
}
