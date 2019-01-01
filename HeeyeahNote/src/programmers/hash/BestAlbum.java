package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

	
public class BestAlbum {

//	public static void main(String[] args) {
//		String[] genres = new String[] {"classic", "pop", "classic","classic","pop"};
//		int[] plays = new int[]	{500, 600, 150, 800, 2500};
//		new BestAlbum().solution(genres, plays);
//	}
	
	public int[] solution(String[] genres, int[] plays) {
	
		Map<String, List<Song>> genresMap = new HashMap<String, List<Song>>();
		Map<String, Integer> genresSum = new HashMap<String, Integer>();
		NavigableMap<Integer, String> tops = new TreeMap<Integer, String>();
		for(int i = 0 ; i < genres.length ; i++) {
			String genre = genres[i];
			int playCount = plays[i];
			
			if(!genresMap.containsKey(genre)) {
				genresMap.put(genre, new ArrayList<Song>());
				genresSum.put(genre, 0);
			}
			genresMap.get(genre).add(new Song(playCount, i));
			genresSum.put(genre, genresSum.get(genre) + playCount);
		}

		//revers
		for(String genre : genresSum.keySet()) {
			tops.put(genresSum.get(genre), genre);
		}
		
		List<Integer> rsltList = new ArrayList<Integer>();
		for(int playCount : tops.descendingKeySet()) {
			
			String genre = tops.get(playCount);
			List<Song> songs = genresMap.get(genre);

			makeAlbum(songs, rsltList);
		}

		int[] answer = new int[rsltList.size()];
		for(int i = 0 ; i < rsltList.size() ; i++) {
			answer[i] = rsltList.get(i);
		}
		
//		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	private void makeAlbum(List<Song> songs, List<Integer> album) {
		
		if(songs.size() == 1) {
			album.add(songs.get(0).getOrgNo());
			return;
		}
		
		Collections.sort(songs);

//		System.out.println("-----------------------------");
//		System.out.println(songs.toString());
		album.add(songs.get(0).getOrgNo());
		album.add(songs.get(1).getOrgNo());
	}
}

class Song implements Comparable<Song>{
	private int playCount;
	private int orgNo;
	
	public Song(int playCount, int orgNo) {
		this.playCount = playCount;
		this.orgNo = orgNo;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public int getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(int orgNo) {
		this.orgNo = orgNo;
	}
	@Override
	public int compareTo(Song o) {
		if(this.playCount < o.getPlayCount()) {
			return 1;
		} else if (this.playCount > o.getPlayCount()) {
			return -1;
		} else {
			if(this.orgNo < o.getOrgNo()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
//	@Override
//	public String toString() {
//		return "Song [playCount=" + playCount + ", orgNo=" + orgNo + "]";
//	}
}