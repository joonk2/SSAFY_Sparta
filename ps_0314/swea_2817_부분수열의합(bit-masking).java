/*
[idea]
----- bit masking ------

get the constraint
- except empty_set;
- if temp_subsetSum == K, then count 


[note]
i = 5
j = 2
(1<<j)
101 & 100 --> 100 therefore 100 != 0
*/

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.Arrays;

public class swea_2817_부분수열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			
			String[] num_arr = br.readLine().split(" ");
			int[] num_lst = new int[N];
			for (int i = 0; i < N; i++) {
				num_lst[i] = Integer.parseInt(num_arr[i]);
			}
			
			
			
			// cnt
			int cnt = 0;						
			
			// bit-masking 
			int leng = num_lst.length;
			int subset = (1<<leng);
			
			for (int i = 0; i < subset; i++) {
				// ------------------ except empty_set ---------------------
				// min_sequence_length starts from 1
				// if unfulfilled, then continue
				if (Integer.bitCount(i) < 1) {
					continue;
				}
				
				// check (temp_sum)
				int temp_subsetSum = 0;
				for (int j = 0; j < leng; j++) {
					if ( (i &(1<<j)) != 0 ) {
						temp_subsetSum += num_lst[j];
					}
				}
				
				// if (temp_subsetSum == K) cnt++;
				if (temp_subsetSum == K) {
					cnt++;
				}
				
				
			}
			
			
			
			
			// result (debug)
			System.out.println("#" + tc + " " + cnt);
			
			
			
			
			
		}
		
		
		
		
	}
}