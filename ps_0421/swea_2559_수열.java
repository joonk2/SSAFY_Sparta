package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;

public class swea_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		String[] string_arr = br.readLine().split(" ");
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(string_arr[i]);
		}
		
		
		int max_continuous_sum = Integer.MIN_VALUE;
		for (int i = 0; i < N-K+1; i++) {
			int temp_continuous_sum = 0;
			for (int j = i; j < K+i; j++) {
				temp_continuous_sum += arr[j];
			}
			
			if (temp_continuous_sum > max_continuous_sum) max_continuous_sum = temp_continuous_sum; 
			
		}
		
//		System.out.println(Arrays.toString(arr));
		System.out.println(max_continuous_sum);
		
		
	}
}