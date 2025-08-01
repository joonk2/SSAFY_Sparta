package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.HashSet;
import java.util.Set;


public class boj_14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MS = br.readLine().split(" ");
		int M = Integer.parseInt(MS[0]);
		int S = Integer.parseInt(MS[1]);
		
		Set<String> targetSet = new HashSet<>();
		
		for (int i = 0; i < M; i++) {
			targetSet.add(br.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < S; i++) {
			String temp_val = br.readLine();
			if (targetSet.contains(temp_val)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	

	
	
	
}