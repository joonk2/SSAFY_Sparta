import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] C = new int[N];
		for (int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(C);
		what_is_the_min_price(N, C);
	}
	
	
	
	static void what_is_the_min_price(int N, int[] C) {
		long sum = 0;
		int cnt = 0;
		for (int i = N-1; i >= 0; i --) {
			sum += (long) C[i];
			cnt++;
			if (cnt == 3) {
				sum -= C[i];
				cnt = 0;
			}
		}
		System.out.println(sum);
	}
	
	
}