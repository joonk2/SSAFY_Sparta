/*
no Duplication nums_arr + Binary_Search 
*/

package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class boj_18870_좌표압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input_string_arr = br.readLine().split(" ");
		int[] target_nums = new int[input_string_arr.length];
		
		for (int i = 0; i < target_nums.length; i++) {
			target_nums[i] = Integer.parseInt(input_string_arr[i]);
		}
		
		int[] unique_nums = clone_and_sorted_and_noDuplication(target_nums);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int idx = binary_search(unique_nums, target_nums[i]);
			if (i < N-1) {
				sb.append(idx + " ");
			}
			else {
				sb.append(idx);
			}
		}
		System.out.println(sb.toString());
		
		
	}
	
	
	
	
	public static int[] clone_and_sorted_and_noDuplication(int[] arr) {
		int[] cloned = arr.clone();
		Arrays.sort(cloned);
		int[] unique_nums = Arrays.stream(cloned).distinct().toArray();
		return unique_nums;
	}
	
	
	
	
	public static int binary_search(int[] unique_nums, int target_num) {
		int left = 0;
		int right = unique_nums.length-1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (unique_nums[mid] == target_num) {
				return mid;
			}
			if (unique_nums[mid] > target_num) {
				right = mid - 1;
			}
			else if (unique_nums[mid] <= target_num) {
				left = mid + 1;
			} 
		}
		
		
		return -1;
	}
	
	
	
}