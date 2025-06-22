package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class boj_9506_약수들의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == -1) {
				break;
			}
			
			String answer = my_changer(N);
			System.out.println(answer);
			
		}
		
	}
	public static String my_changer(int x) {
		List<Integer> lst = new ArrayList<>();
		String res = "";
		int half_x = x/2;
		for (int i = 1; i < half_x + 1; i++) {
			if (x % i == 0) {
				lst.add(i);
			}
		}
//		System.out.println(lst);
		int sum = 0;
		for (int i : lst) {
			sum += i;
		}
//		System.out.println(sum);
		
		if (sum != x) {
			res = x + " is NOT perfect.";
		}
		else {
			res += x + " = ";
			for (int i : lst) {
				if (i == half_x) {
					res += i;
				}
				else {
					res += i + " + " ;
				}
			}
		}
		
		return res;
	}
	
	
}