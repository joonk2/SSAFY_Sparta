package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		int[] res = prime_interval(MN);
		
		for (int i : res) {
			if (i > 0) {
				System.out.println(i);
			}
		}
		
	}
	
	
	public static int[] prime_interval(String[] MN) {
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		int[] box = new int[1000001];
		
		if (N == 2) {
			box[0] = 2;
		}
		else {
			for (int i = M; i < N+1; i++) {
				if (is_prime(i)) {
					box[i] = i;
				}
			}
		}
		return box;
		
	
	}
	
	
	
	
	public static boolean is_prime(int x) {
		if (x == 1) return false;
		if (x == 2) return true;
		if (x % 2 == 0) return false;
		
		int sqrt = (int) Math.sqrt(x);
		for (int i = 3; i < sqrt + 1; i += 2) {
			if (x % i == 0) return false;
		}
		return true;
	}
	
	
	
	
}