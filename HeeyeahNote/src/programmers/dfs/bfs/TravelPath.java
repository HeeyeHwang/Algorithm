package programmers.dfs.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPath {

	public static void main(String[] args) {
	
		String[][] tickets = new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};//{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[] rslt = new TravelPath().solution(tickets);
		System.out.println(Arrays.toString(rslt));
	}
	
	public String[] solution(String[][] tickets) {
        
		Map<String, List<String>> route = new HashMap<String, List<String>>();
		
		for(int i = 0 ; i < tickets.length ; i++) {
			
			String[] ticket = tickets[i];
			List<String> ticketList;
			if(route.containsKey(ticket[0])) {
				ticketList = route.get(ticket[0]);
				ticketList.add(ticket[1]);
			} else {
				ticketList = new ArrayList<String>();
				ticketList.add(ticket[1]);
				route.put(ticket[0], ticketList);
			}
		}

		
		List<String> answer = new ArrayList<String>();
		String key = null;
		while(!route.isEmpty()) {

			if(answer.isEmpty()) {
				key = "ICN";
				answer.add("ICN");
			}
			
			key = answer.get(answer.size()-1);
			List<String> keyList = route.get(key);
			
			if(keyList.size() > 1) {
				keyList.sort(Comparator.naturalOrder());
				answer.add(keyList.get(0));
				keyList.remove(0);
			} else {
				answer.add(keyList.get(0));
				route.remove(key);
			}
		}

		return answer.stream().toArray(String[]::new);
    }
}
