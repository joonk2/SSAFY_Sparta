/*
[counter testcase]

[input]
5
1 1 1 1 1

[output]
5
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;

public class boj_2491_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] string_seq = br.readLine().split(" ");
		int[] seq = new int[string_seq.length];
		for (int i = 0; i < string_seq.length; i++) {
			seq[i] = Integer.parseInt(string_seq[i]);
		}
		
		int max_increasing_seq_leng = 1;
		int max_decreasing_seq_leng = 1;
		int temp_increasing_seq_leng = 1;
		int temp_decreasing_seq_leng = 1;
		
		for (int i = 0; i < N-1; i++) {
			// check the increasing seq
			if (seq[i] <= seq[i+1]) temp_increasing_seq_leng++;
			else {
				if (temp_increasing_seq_leng > max_increasing_seq_leng) {
					max_increasing_seq_leng = temp_increasing_seq_leng;
				}
				temp_increasing_seq_leng = 1;
			}
			
			
			// check the decreasing seq
			if (seq[i] >= seq[i+1]) temp_decreasing_seq_leng++;
			else {
				if (temp_decreasing_seq_leng > max_decreasing_seq_leng) {
					max_decreasing_seq_leng = temp_decreasing_seq_leng;
				}
				temp_decreasing_seq_leng = 1;
			}
				
				
				
		}
		
		// last check (counter test case 1 1 1 1 1)
		if (temp_increasing_seq_leng > max_increasing_seq_leng) {
			max_increasing_seq_leng = temp_increasing_seq_leng;
		}
		
		if (temp_decreasing_seq_leng > max_decreasing_seq_leng) {
			max_decreasing_seq_leng = temp_decreasing_seq_leng;
		}
		
		
		
//		System.out.println(Arrays.toString(seq));
		int max_leng = 1;
		if (max_increasing_seq_leng >= max_decreasing_seq_leng) {
			max_leng = max_increasing_seq_leng;
		}
		else {
			max_leng = max_decreasing_seq_leng;
		}
		
		
		
		System.out.println(max_leng);
		
		
		
	}
}