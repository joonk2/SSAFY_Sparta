package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2839_설탕배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = find_solution(N);
		System.out.println(res);
	}
	
	
	public static int find_solution(int N) {
		int res = -1;
		int temp_val = Integer.MAX_VALUE;
		int sugar_5kg = 5;
		int sugar_3kg = 3;
		
		for (int x = 0; x < 5001; x++) {
			for (int y = 0; y < 5001; y++) {
				if ( (sugar_5kg * x) + (sugar_3kg * y) == N) {
					temp_val = Math.min(temp_val, x+y);
				}
			}
		}
		if (temp_val < Integer.MAX_VALUE) {
			res = temp_val;
		}
		
		return res;
	}
	
}