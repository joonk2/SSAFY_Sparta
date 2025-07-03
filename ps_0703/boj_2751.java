/*
Counting Sort
O(N+K)

boj_2751_수정렬하기2
시간복잡도 최대 연산시간 30,000,001 
*/


package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] input_arr= new int[N];
		int[] counting_arr = new int[2000000 + 1];
		for (int i = 0; i < N; i++) {
			input_arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] output_arr = counting_sort(input_arr, counting_arr);
		
		StringBuilder sb = new StringBuilder();
		for (int i : output_arr) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);
		
	}
	
	
	public static int[] counting_sort(int[] input_arr, int[] counting_arr) {
		int N = input_arr.length;
		int[] output_arr = new int[N];
		
		// counting_arr
		for (int i = 0; i < N; i++) {
			counting_arr[input_arr[i] + 1000000]++;
		}
		
		// cum-sum
		for (int i = 1; i < counting_arr.length; i++) {
			counting_arr[i] += counting_arr[i-1];
		}
		
		
		// res
		for (int i = N-1; i >= 0; i--) {
			int val = input_arr[i];
			int idx = counting_arr[val + 1000000]-1;
			output_arr[idx] = val;
			counting_arr[val + 1000000]--;
		}
		
		return output_arr;
	}
	
	
	
}