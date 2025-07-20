/*
lambda 사용 
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words_dict = new String[N];
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			words_dict[i] = word;
		}
		
		String[] res = lambda_sort(words_dict);
		
		StringBuilder sb = new StringBuilder();
		sb.append(res[0] + "\n");
		for (int i = 1; i < res.length; i++) {
			if (!res[i].equals(res[i-1])) {
				sb.append(res[i] + "\n");
			}
		}
		System.out.print(sb);		
	}
	
	public static String[] lambda_sort(String[] arr) {
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		
		return arr;
	}
	
}