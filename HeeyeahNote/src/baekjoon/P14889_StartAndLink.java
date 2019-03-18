package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO not yet solved XP
 * @author heeye
 */
public class P14889_StartAndLink {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		
		dashboard = new int[n][n];
		check = new boolean[n];
		
		for(int i = 0 ; i < n ; i ++) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			for(int j = 0 ; j <n ; j++) {
				dashboard[i][j] = Integer.parseInt(arr[j]);
			}
		}
//		System.out.println(" n : " +n);
		new P14889_StartAndLink().dfs(0, 0);
		
		System.out.println(answer);
		
		sc.close();
	}
	
	private static int[][] dashboard;
	private static boolean[] check;
	private static int n;
	private static int answer = Integer.MAX_VALUE;
	
	public void dfs(int index, int count) {
		
//		System.out.printf("%s , index %d, count %d \n", Arrays.toString(check), index, count);
		
		if(count == n/2) {
//			System.out.println("start");
			List<Integer> startTeam = new ArrayList<Integer>();
			List<Integer> linkTeam = new ArrayList<Integer>();
			for(int i = 0 ; i < n ; i++) {
				if(check[i]) {
					startTeam.add(i);
				} else {
					linkTeam.add(i);
				}
			}
	
//			System.out.println("start : " +startTeam);
//			System.out.println("link : " + linkTeam);
			int startSkill = 0;
			int linkSkill = 0;
			for(int i = 0 ; i < n/2 ; i++) {
				for(int j = i+1 ; j < n/2 ; j++) {
					
					int si = startTeam.get(i), sj = startTeam.get(j);
					int li = linkTeam.get(i), lj = linkTeam.get(j);
					
					startSkill += dashboard[si][sj] + dashboard[sj][si];
					linkSkill += dashboard[li][lj] + dashboard[lj][li];
				}
			}
//			System.out.println("sv "+startSkill);
//			System.out.println("lv "+linkSkill);
			answer = Math.min(answer, Math.abs(startSkill - linkSkill));
//			System.out.println(answer);
			
			return;
		}
		
		for(int i = index + 1 ; i < n ; i++	 ) {
			
			if(!check[i]) {
				check[i] = true;
				dfs(i, count + 1);
				check[i] = false;
				
			}
		}
		
	}
}
