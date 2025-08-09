package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_4948_베르트랑공준 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			int res = is_prime_cnt(n);
			System.out.println(res);
		}
	}
	
	
	
	
	
	
	public static int is_prime_cnt(int n) {
		if (n == 1) return 1;
		if (n == 2) return 1;
		
		int cnt = 0;
		int end = 2*n;
		for (int i = n+1; i < end + 1; i++) {
			if (is_prime(i)) cnt++; 
		}
		return cnt;
	}
	
	
	
	
	
	public static boolean is_prime(int x) {
		if (x < 2) return false;
		if (x == 2) return true;
		if (x % 2 == 0) return false;
		
		int sqrt = (int) Math.sqrt(x);
		for (int i = 3; i < sqrt + 1; i += 2) {
			if (x % i == 0) return false;
		}
		return true;
		
	}
	
	
	
	
	
}