/*
- 순서쌍 중복검사를 하지 않으려면 절반만 확인하자 
- 에라토스테네스의 체
*/

package boj;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class boj_17103_골드바흐파티션 {
	public static int max_size = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] is_prime = sieve_of_eratosthenes(max_size);
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int res = partition_cnt(N, is_prime);
			System.out.println(res);
		}
	}
	
	
	
	
	
	public static boolean[] sieve_of_eratosthenes(int x) {
		boolean[] is_prime = new boolean[x+1];
		Arrays.fill(is_prime, true);
		
		for (int i = 2; i*i < x+1; i++) {
			if (is_prime[i]) {
				for (int j = i*i; j < x+1; j += i) {
					is_prime[j] = false;
				}
			}
		}
		return is_prime;
	}
	
	
	
	
	
	public static int partition_cnt(int N, boolean[] is_prime) {
		int cnt = 0;
		for (int i = 2; i < (N/2) + 1; i++) {
			if (is_prime[i] && is_prime[N-i]) cnt++;
		}
		return cnt;
	}
	
	
	
	
	
	
	
}