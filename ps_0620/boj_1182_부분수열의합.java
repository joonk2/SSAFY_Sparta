package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;

public class boj_1182_부분수열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NS = br.readLine().split(" ");
		String[] num_seq = br.readLine().split(" ");
		
		int N = Integer.parseInt(NS[0]);
		int S = Integer.parseInt(NS[1]);
		
		int[] seq = new int[num_seq.length];
//		System.out.println(num_seq.length);
		
		for (int i = 0; i < num_seq.length; i++) {
			seq[i] = Integer.parseInt(num_seq[i]);
		}
//		System.out.println(Arrays.toString(seq));
		
		int subset_cnt = 1 << N;
//		System.out.println(subset_cnt);
		
		int cnt = 0;
		for (int i = 1; i < subset_cnt; i++) {
			int temp_sum = 0;
			for (int j = 0; j < N; j++) {
				if ( (i & (1<<j) ) != 0 ) {
					temp_sum += seq[j];
				}
			}
			if (temp_sum == S) cnt++;
		}
		
		
		System.out.println(cnt);
		
	}
}
