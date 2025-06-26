/*
나무 최대 길이 10억,
나무 최대갯수 100만

자른 나무길이합은 10^15 --> long
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		String[] tree_height_arr = br.readLine().split(" ");
		int[] tree_height = str_to_int(tree_height_arr);
		
		int res = parametric_search(N, M, tree_height);
		System.out.println(res);
	}
	
	public static int parametric_search(int N, int M, int[] tree_height) {
		int max_height = 0;
		int left = 1;
		int right = upperBound(tree_height);
		while (left <= right) {
			int mid = (left + right) / 2;
			if (canCut(mid, M, tree_height)) {
				max_height = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return max_height;
	}
	
	
	public static boolean canCut(int mid, int M, int[] tree_height) {
		long temp_sum = 0;
		for (int i : tree_height) {
			temp_sum += Math.max(0, i-mid);
		}
		return temp_sum >= M;
	}
	
	
	
	public static int[] str_to_int(String[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(res);
		return res;
	}
	
	public static int upperBound(int[] int_arr) {
		int max = 0;
		for (int i : int_arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	
}