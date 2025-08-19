package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] generated = new boolean[10001];
		int x = 1;
		self_number(x, generated);
	}
	
	
	
	
	public static void self_number(int N, boolean[] generated) {
		while (N < 10001) {
			int n_1000 = (N / 1000);
			int n_100 = (N - (N / 1000)*1000) / 100;
			int n_10 = (N % 100) / 10;
			int n_1 = N % 10;
			int temp_val = N + n_1000 + n_100 + n_10 + n_1;
			
			if (temp_val > 10000) {
				N++;
				continue;
			}
			
			if (!generated[temp_val]) generated[temp_val] = true;
			N++;
		}
		
		for (int i = 1; i < 10001; i++) {
			if (!generated[i]) System.out.println(i);
		}
		
		

	}
	
	
	
}