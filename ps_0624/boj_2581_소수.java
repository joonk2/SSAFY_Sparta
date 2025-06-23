package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class boj_2581_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		List<Integer> res = my_detecter(M, N);
		for (int i : res) {
			System.out.println(i);
		}
		
	}
	
	
	public static List<Integer> my_detecter(int x, int y) {
		List<Integer> lst = new ArrayList<>();
		int sum_prime_number = 0;
		int min_prime_number = Integer.MAX_VALUE;
		for (int i = x; i < y+1; i++) {
			int temp_prime_num_cnt = 0;
			for (int j = 1; j < i + 1; j++) {
				if (i % j == 0) {
					temp_prime_num_cnt++;
				}
			}
			if (temp_prime_num_cnt == 2) {
				sum_prime_number += i;
				if (i < min_prime_number) {
					min_prime_number = i;
				}
			}
		}
		if (sum_prime_number == 0) {
			lst.add(-1);
		}
		else {
			lst.add(sum_prime_number);
			lst.add(min_prime_number);
		}
		
		return lst;
	}
	
}