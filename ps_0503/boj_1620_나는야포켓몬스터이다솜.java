package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Map;
import java.util.HashMap;

public class boj_1620_나는야포켓몬스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		int leng = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		
		
		Map<Integer, String> idx_to_poc = new HashMap<>();
		Map<String, Integer> poc_to_idx = new HashMap<>();
		for (int i = 1; i < leng + 1; i++) {
			String pocketmon = br.readLine();
			idx_to_poc.put(i, pocketmon);
			poc_to_idx.put(pocketmon, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			String x = br.readLine();
			if (isNumeric(x)) {
				int num = Integer.parseInt(x);
				sb.append(idx_to_poc.get(num) + "\n");
			}
			else {
				sb.append(poc_to_idx.get(x) + "\n");
			}
		}
		System.out.println(sb);
		
		
//		System.out.println(idx_to_poc);
//		System.out.println(poc_to_idx);
		
	}
	
	public static boolean isNumeric(String str) {
		return str.matches("\\d+");
	}
}