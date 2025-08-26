package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_15565_귀여운라이언 {
	static int N, K;
	static int left;
	static int cnt_K;
	static int min_leng, temp_leng;
	static int[] dolls;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String[] NK = br.readLine().split(" ");
		String[] dolls_arr = br.readLine().split(" ");
		int res = min_cnt(NK, dolls_arr);
		System.out.println(res);
	}
	
	
	
	public static int min_cnt(String[] NK, String[] dolls_arr) {
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		temp_leng = 1000001;
		min_leng = -1;
		dolls = new int[N];
		for (int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(dolls_arr[i]);
		}
		
		left = 0;
		cnt_K = 0;
		for (int right = 0; right < N; right++) {
			if (dolls[right] == 1) cnt_K++;
			while (cnt_K >= K) {
				temp_leng = Math.min(right - left + 1, temp_leng);
				if (dolls[left] == 1) cnt_K--;
				left++;
			}
			
		}
		
		
		if (temp_leng < 1000001) {
			min_leng = temp_leng;
		}
		return min_leng;
	}
	
	
	
}