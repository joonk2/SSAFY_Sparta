import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s_arr = br.readLine().split(" ");
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(s_arr[i]);
		}
		Arrays.sort(arr);
		
		what_is_min_val(arr, N);
	}
	
	
	static void what_is_min_val(long[] arr, int N) {
		long res = 0;
		if (N % 2 == 0) {
			long min_val = Long.MIN_VALUE;
			for (int i = 0; i < arr.length/2; i++) {
				long temp_val = arr[i] + arr[N-1-i];
				min_val = Math.max(min_val, temp_val);
				res = min_val;
			}
		}
		else if (N % 2 == 1) {
			long min_val = Long.MIN_VALUE;
			for (int i = 0; i < (arr.length-1)/2; i++) {
				long temp_val = arr[i] + arr[N-2-i];
				min_val = Math.max(min_val, temp_val);
			}
			min_val = Math.max(min_val, arr[N-1]);
			res = min_val;
		}
		
		System.out.println(res);
	}
	
	
}