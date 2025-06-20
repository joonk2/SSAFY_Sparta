package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// import java.util.Arrays;

public class Solution {
	static int min_val;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] NB = br.readLine().split(" ");
			String[] H_arr = br.readLine().split(" ");
			
			int N = Integer.parseInt(NB[0]);
			int B = Integer.parseInt(NB[1]);
			
			int[] H = new int[N];
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(H_arr[i]);
			}
			
			int subset_cnt = 1 << N;
			min_val = Integer.MAX_VALUE;
			for (int i = 0; i < subset_cnt; i++) {
				int sum = 0;
				
				for (int j = 0; j < N; j++) {
					if ( (i & (1 <<j)) != 0 ) {
						sum += H[j];
					} 
				}
				if (sum >= B) {
					min_val = Math.min(min_val, sum-B);
				}
			}
			
			
			
			System.out.println("#" + tc + " " + min_val);
			
			
			
		}
		
		
		
		
		
	}
}