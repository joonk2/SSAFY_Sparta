import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(w);
		my_calculator(N, w);
	}
	
	
	static void my_calculator(int N, int[] w) {
		int max_val = Integer.MIN_VALUE;
		for (int i = 0; i < w.length; i++) {
			int temp_sum = (N-i) * w[i];
			if (temp_sum > max_val) max_val = temp_sum;
		}
		System.out.println(max_val);
	}
	
	
}