package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

import java.util.List;
import java.util.ArrayList;

import java.util.Collections;

public class boj_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		Set<String> hs = new HashSet<>();
		
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			hs.add(name);
		}
		
		List<String> name_lst = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (hs.contains(name)) {
				name_lst.add(name);
			}
		}
		
		Collections.sort(name_lst);
		
		
		StringBuilder sb = new StringBuilder();
		int cnt = name_lst.size();
		System.out.print(cnt + "\n");
		for (String i : name_lst) {
			System.out.print(i + "\n");
		}
		
	}
	
}