package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class boj_14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MS = br.readLine().split(" ");
		int M = Integer.parseInt(MS[0]);
		int S = Integer.parseInt(MS[1]);
		
		List<String> target_vals = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			target_vals.add(br.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < S; i++) {
			String temp_val = br.readLine();
			for (int j = 0; j < M; j++) {
				if (temp_val.equals(target_vals.get(j))) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
		
	}
	

	
	
	
}