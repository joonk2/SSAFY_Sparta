/*
Counting Sort
O(N+K)


boj_1427
N <= 1000000000 
숫자 0 ~ 9까지 필요하기에 정렬할 최대 자리수는 10이다
시간복잡도 최대 연산시간 O(10 + 10)


test case 
4133
-->
1334
*/


package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		int[] output_arr = counting_sort(nums);
		
		StringBuilder sb = new StringBuilder();
		for (int i = output_arr.length-1; i >= 0; i--) {
			sb.append(output_arr[i]);
		}
		System.out.print(sb.toString());
	}
	
	public static int[] counting_sort(String nums) {
		int max_counting_arr_size = 10;
		
		int[] input_arr = new int[nums.length()];
		int[] counting_arr = new int[max_counting_arr_size];
		int[] output_arr = new int[nums.length()];
		
		// input_arr
		for (int i = 0; i < nums.length(); i++) {
			input_arr[i] = nums.charAt(i)-'0';
		}
		
		// counting_arr
		for (int i = 0; i < input_arr.length; i++) {
			counting_arr[input_arr[i]]++;
		}
		
		// cum_sum
		for (int i = 1; i < counting_arr.length; i++) {
			counting_arr[i] += counting_arr[i-1];
		}
		
		// res
		int X = output_arr.length;
		for (int i = X-1; i >= 0; i--) {
			int val = input_arr[i];
			int idx = counting_arr[val]-1;
			output_arr[idx] = val;
			counting_arr[val]--;
		}
		
		return output_arr;
	}
	
}