package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage { // 위장
	

	/**
	 * 
	 * @param clothes
	 * @return
	 */
	public int solution(String[][] clothes) {
        
        Map<String, Integer> clothesMap = new HashMap<String, Integer>();
        
        for(int i = 0 ; i < clothes.length ; i++) {
        	
        	String[] row = clothes[i];
        	String key = row[1];
        	
        	if(!clothesMap.containsKey(key)) {
        		clothesMap.put(key, 1);
        	} else {
        		clothesMap.put(key, clothesMap.get(key) +1);
        	}
        }

        int rslt = 1;
        
        for(String key : clothesMap.keySet()) {
        	rslt = rslt * (clothesMap.get(key) +1);
        }
       
        
        return rslt-1;
    }
}
