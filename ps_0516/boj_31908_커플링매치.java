package boj;

import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;


// import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class boj_31908_커플링매치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] name = new String[N];
		String[] ring = new String[N];
		
		for (int i = 0; i < N; i++) {
			String[] words = br.readLine().split(" ");
			String s1 = words[0];
			String s2 = words[1];
			
			name[i] = s1;
			ring[i] = s2;
		}
		
		
		Map<String, Integer> ring_cnt = new HashMap<>();
		for (int i = 0; i < N; i++) {
			
			// 반지가 '-'가 아니면 해시맵에 계속 넣고, 키값이 있다면 그걸 넣고 중복되면 ++로 갱신
			if (!ring[i].equals("-")) {
				ring_cnt.put(ring[i], ring_cnt.getOrDefault(ring[i], 0)+1);
			}
		}
//		System.out.println(ring_cnt);
		
		boolean[] visited = new boolean[N];
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			// map.get(i)==2인 것만 추출할거니까, 해시맵에 키가 없을때랑, 2가 아닐때 그냥 지나친다
			if (!ring_cnt.containsKey(ring[i]) || ring_cnt.get(ring[i]) != 2) continue;
			
			
			for (int j = i+1; j < N; j++) {
				if (!visited[j] && ring[i].equals(ring[j])) {
					visited[i] = true;
					visited[j] = true;
					lst.add(name[i] + " " + name[j]);
					break;
				}
			}
		}
		
		System.out.println(lst.size());
		for (String s : lst) {
			System.out.println(s);
		}
			
		
		
		
		
		
		
		
	}
}