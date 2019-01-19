package programmers.sort;

import java.util.Arrays;

public class HIndex {

	public int solution(int[] citations) {

        Arrays.sort(citations);
        
        System.out.println(Arrays.toString(citations));
        int total = citations.length;
        int index = 0;
        for(int i = citations.length -1 ; i >= 0 ; i--) {
        	
        	index++;
        	int count = citations[i];
        	
        	System.out.printf("index %d / count %d / rest %d \n",index, count, total-index);
        	
        	if(count <= index ) {
        		if(total - index <= index) {
        			return index;
        		}
        	}
        }
        
        return index;
    }
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {0,0,1,1,1,0,0,0,0};
		int rslt = new HIndex().solution(arr);
		System.out.println(rslt);
	}
}
