package programmers.dp;

public class WayToSchool {

	public int solution(int m, int n, int[][] puddles) {

		/*
		  
		  dp는 1,1에서 i,j 지점까지 갈 수 있는 최단 경 수로 정의했다.
		  dp[i][j] = dp[i-1][j] + dp[i][j-1] 이고, puddles일 땐 무조건 dp = 0 이다.
		  처음에 dp 공간을 어떻게 잡을 지와 초기값이 변수였다. 그냥 i, j가 1인 경우에 물웅덩이를 제외하고 다 1로 세팅하면 될 줄 알았는데
		  생각해보니 초기값(i, j = 0이 인덱스)을 0으로 지정하고 dp[1][1] = 1 으로 지정한 후 전체 경우에 대해 dp 점화식을 적용해야 했다.
		  
		 */
		int[][] dp = new int[n + 1][m + 1];

		for (int[] puddle : puddles) {
			dp[puddle[1]][puddle[0]] = -1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1) {
					dp[i][j] = 1;
					continue;
				}
				if (dp[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
			}

		}

		return dp[n][m];
	}

	public static void main(String[] args) {

		int m = 4;
		int n = 3;
		int[][] puddles = new int[][] { { 1, 2 }, { 2, 2 } };
		int rslt = new WayToSchool().solution(m, n, puddles);
		System.out.println(rslt);
	}
}
