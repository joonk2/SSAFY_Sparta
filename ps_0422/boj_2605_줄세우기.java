package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
//import java.util.Collections;

public class boj_2605_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		
		
		
		
//		Integer[] lst = {1,5,7,3,2};
//		Arrays.sort(lst, Collections.reverseOrder());
//		System.out.println(Arrays.toString(lst));

		String[] num_arr = br.readLine().split(" ");
		int[] num_lst = new int[N];
		
		List<Integer> student_lst = new ArrayList<>();
		
		
//		student_lst.add(0,1);
//		student_lst.add(0,2);
//		student_lst.add(1,3);
//		student_lst.add(0,4);
//		student_lst.add(2,5);
		
		
		for (int i = 0; i < num_arr.length; i++) {
			num_lst[i] = Integer.parseInt(num_arr[i]);
			student_lst.add(i-num_lst[i], i+1);
		}
		
		
//		System.out.println(student_lst);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(student_lst.get(i));
			if (i < N-1) {
				sb.append(" ");
			}
		}
		
		
		
		System.out.println(sb);
		
	}
}