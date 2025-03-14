/*
[idea]
--------------- dfs -----------------
of course you have to check condition first.
if (x == K) then count; return;
and right next, then if depth ends, return; --> if (idx == N)


*/

package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class swea_2817_부분수열의합_dfs {
	static int N, K, cnt;
	static int[] num_lst;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			N = Integer.parseInt(arr[0]);
			K = Integer.parseInt(arr[1]);
			
			String[] num_arr = br.readLine().split(" ");
			num_lst = new int[N];
			for (int i = 0; i < N; i++) {
				num_lst[i] = Integer.parseInt(num_arr[i]);
			}
			
			
			cnt = 0;
			dfs(0,0);
			System.out.println("#" + tc + " " + cnt);
			
//			 ------------  debug  -------------
//			System.out.println(Arrays.toString(num_lst));
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	public static void dfs(int idx, int cum_sum) {
		if (cum_sum == K) {
			cnt++;
			return;
		}
		
		
		if (idx == N) {
			return;
		}
		
		
		// selected
		dfs(idx+1, cum_sum + num_lst[idx]);
		
		// not selected
		dfs(idx+1, cum_sum);
		
		
	}
	
	
	
	
}