package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9095_123더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			int res = MY_DP(n, dp);
			System.out.println(res);
		}
	}
	
	
	
	
	
	
	public static int MY_DP(int x, int[] dp) {
		if (x == 1) return 1;
		if (x == 2) return 2;
		if (x == 3) return 4;
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < x+1; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		return dp[x];
	}
	
	
	
	
}