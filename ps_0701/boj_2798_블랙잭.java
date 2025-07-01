/*
- 3장이 중복이 되지 않는 완전탐색을 생각해보자
- 3중 반복문이라, 시간복잡도 --> O(N^3) 
*/

package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class boj_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		String[] arr = br.readLine().split(" ");
		int[] int_arr = str_to_int(arr);
		
		int target_val = Integer.MIN_VALUE;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i != j && j != k && k != i) {
						target_val = (int_arr[i] + int_arr[j] + int_arr[k]);
						if (target_val <= M) {
							res = Math.max(target_val, res);
						}
					}
				}
			}
		}
		System.out.println(res);
		
	}
	
	
	public static int[] str_to_int(String[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(res);
		return res;
	}
	
	
}