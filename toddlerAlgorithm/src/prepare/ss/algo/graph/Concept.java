package prepare.ss.algo.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Concept {

	/*
	 * [개요] 다익스트라 알고리즘은 어떤 변도 음수 가중치를 갖지 않는 유향 그래프에서 주어진 출발점과 도착점 사이의 최단 경로 문제를 푸는
	 * 알고리즘이다
	 * 
	 * [예시문제] 방향이 있는 그래프에서 꼭지점들을 연결하는 비용이 할당 되었을 때 임의의 꼭지점에서 다른 꼭지점으로 가는 경로들 중에서 비용이
	 * 가장 적게 드는 경로, 즉 두 정점 사이의 최단 경로를 찾아라. 입력 값 첫번째 라인에는 전체 테스트 케이스의 개수가 입력된다. 두번째
	 * 라인에는 정점의 개수, 그리고 시작 정점, 도착 정점이 입력된다. 이때, 정점의 최대 개수는 100이다. 세번째 라인에는 정점을 잇는 간선
	 * 개수(m)가 입력된다. 네번째 라인부터는 연결 된 정점 값 2개와 간선에 할당 된 비용이 m번 들어온다. 이때 간선 방향은 첫번째 입력된
	 * 정점에서 두번째 입력된 정점으로 가는 방향이다.
	 * 
	 * [입력]
	 * 1 // test case 개수 
		7 1 7 // 정점의 개수, 그리고 시작 정점, 도착 정점 
		9 // 간선 개수 
		1 2 4 // 1->2, 비용은 4 
		1 3 2 
		2 4 1 
		2 5 2 
		3 4 7 
		3 6 3 
		4 7 3 
		5 7 1 
		6 7 5
		
	*
	* [출력]
	* #1 7
	*
	*/
	
	static final int N = 100;
	static final int INF = 100000;
	static int[][] map = new int[N+1][N+1];
	static boolean[] visit = new boolean[N+1];
	static int[] dist = new int[N+1];
	static int vertex; //꼭지점
	static int edge; //선
	static int start;
	static int end;
	
	public static void practice() {
		
		int v = 0;
		dist[start] = 0;
		

		for(int j = 1 ; j <= vertex ; j++) {
			int min = INF;
			for(int i = 1 ; i <= vertex ; i++) {
				
				if(!visit[i] && min > dist[i]) {
					min = dist[i]; //****
					v = i;
				}
			}
			
			visit[v] = true;
			
			for(int i = 1 ; i <= edge ; i++) {
				if(dist[i] > dist[v] + map[v][i]) {
					dist[i] = dist[v] + map[v][i];
				}
			}
		}
		
		
		
		
	}

	public static void dijkstra() {
		int v = 0;
		dist[start] = 0; //start 점을 0으로 set
		
		//i에서 j로 가는 경우의 dist 구하는 법???인듯
		for ( int i = 1; i <= vertex ; i++) {
			
			System.out.printf("===== i [%d] =====\n", i);
			
			int min = INF; // 한번도 거치지 않은 vertex의 가중치는 INF. 무한대.
			for(int j = 1 ; j <= vertex ; j++) {
				
				if(!visit[j] && (min > dist[j])) { //방문한 적 없고, j가 가진 최단거리값이 무한대보다 작으면
					System.out.printf("i[%02d] j[%02d] min[%d] dist[%d]=%d \n", i, j, min, j, dist[j]);
					min = dist[j];
					v = j;
				}
			}
			System.out.printf("v : %d \n", v);
			visit[v] = true;
			
			// dist[j] = min(dist[j], dist[v]+adj[j][v])
			for(int j = 1 ; j <= vertex ; j++) { 
				
				System.out.printf("before if.. dist[%d] = %d", j, dist[j]);
				if(dist[j] > dist[v] + map[v][j]) {
					dist[j] = dist[v] + map[v][j];
				}
				
				System.out.printf("***** dist[%d] = %d = %d + %d  \n", j, dist[j], dist[v], map[v][j]);
			}
			
			System.out.printf("visit array - %s \n", Arrays.toString(visit) );
		}
	}
	
	
	/*
	 * 1. start점에서의 최단거리에 있는 점을 저장!
	 * 2. 모든 점을 한번씩 보면서 
	 * 각 점이 가진 최단거리 값 vs 기준점의 최단거리 값 + 기준점과 각 점의 가중치 중 minimum 값 선택해서 
	 * 각 점의 최단거리에 저장
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			vertex = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			edge = sc.nextInt();
			
			for(int i = 1; i <= vertex ; i++) {
			
				dist[i] = INF;
				for(int j = 1 ; j <= vertex ; j++) {
					if(i != j) {
						map[i][j] = INF;
					}
				}
			}
			
			for(int i = 1 ; i <= edge ; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int value = sc.nextInt();
				map[from][to] = value;
			}
			
			dijkstra();
			System.out.printf("#%d %d\n", testCase, dist[end]);
		}
		
		sc.close();
	}
}
