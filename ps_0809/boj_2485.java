package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class boj_2485_가로수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> tree = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int temp_num = Integer.parseInt(br.readLine());
			tree.add(temp_num);
		}
		
		int res = solution(tree);
		System.out.println(res);
	}
	
	
	
	
	
	public static int solution(List<Integer> tree) {
		Collections.sort(tree);
		int cnt = 0;
		
		int impermanent_gcd_val = tree.get(1) - tree.get(0);
		for (int i = 1; i < tree.size(); i++) {
			int diff = tree.get(i) - tree.get(i-1);
			impermanent_gcd_val = my_custom_gcd(impermanent_gcd_val, diff);
		}
		
		
		for (int i = 0; i < tree.size()-1; i++) {
			int diff = tree.get(i+1) - tree.get(i);
			cnt += (diff / impermanent_gcd_val) -1;
		}
		
		
		return cnt;
	}
	
	
	
	
	
	public static int my_custom_gcd(int x, int y) {
		while (y != 0) {
			int temp = (x % y);
			x = y;
			y = temp;
		}
		return x;
	}
	
	
	
	
}