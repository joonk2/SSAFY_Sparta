package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class boj_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] p = br.readLine().split(" ");
		int res = min_time_sum(p);
		System.out.println(res);
	}
	
	
	
	
	
	public static int min_time_sum(String[] arr) {
		int answer = 0;
		int[] int_arr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int_arr[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(int_arr);
		
		for (int i = 1; i < int_arr.length; i++) {
			int_arr[i] = int_arr[i] + int_arr[i-1];
		}
		for (int i = 0; i < int_arr.length; i++) {
			answer += int_arr[i];
		}
		return answer;
	}
	
	
	
	
	
	
	
}