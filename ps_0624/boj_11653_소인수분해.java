package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

public class boj_11653_소인수분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println();
		}
		else {
			List<Integer> res = my_prime_factorization(N);
//			System.out.println(res);
			for (int i : res) {
				System.out.println(i);
			}
		}
	}
	public static List<Integer> my_prime_factorization(int X) {
		List<Integer> lst = new ArrayList<>();
		while (X > 1) {
			for (int i = 2; i < X + 1; i++) {
				if (X % i == 0) {
					while (true) {
						lst.add(i);
						X /= i;
						if (X % i != 0) {
							break;
						}
					}
				}
			}
		}
		return lst;
	}
	
}