package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Set;
import java.util.HashSet;

import java.util.List;
import java.util.ArrayList;

public class boj_1269_대칭차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");
		String[] A_arr = br.readLine().split(" ");
		String[] B_arr = br.readLine().split(" ");
		
		List<Integer> res = calculator(AB, A_arr, B_arr);
		System.out.print(res.size());

		
		
	}
	
	public static List<Integer> calculator(String[] AB, String[] A_arr, String[] B_arr) {
		int A = Integer.parseInt(AB[0]);
		int B = Integer.parseInt(AB[1]);
		Set<Integer> A_set = new HashSet<>();
		Set<Integer> B_set = new HashSet<>();
		
		List<Integer> lst = new ArrayList<>();
		
		for (int i = 0; i < A; i++) {
			int temp_val = Integer.parseInt(A_arr[i]);
			A_set.add(temp_val);
		}
		
		for (int i = 0; i < B; i++) {
			int temp_val = Integer.parseInt(B_arr[i]);
			B_set.add(temp_val);
		}
	
		
		for (Integer num : A_set) {
			if (!B_set.contains(num)) {
				lst.add(num);
			}
		}
		
		for (Integer num : B_set) {
			if (!A_set.contains(num)) {
				lst.add(num);
			}
		}
		
		
		return lst;
	}
	
	
}