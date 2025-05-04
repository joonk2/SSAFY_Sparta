package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;


public class boj_1138_한줄로서기기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		
		List<Integer> line = new ArrayList<>();
		
		for (int i = N-1; i >= 0; i--) {
			int cur_idx = Integer.parseInt(arr[i]);
			line.add(cur_idx, i+1);
		}

//		System.out.println(line);

		StringBuilder sb = new StringBuilder();
		for (int i : line) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
		
	}
}