package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;

public class boj_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String words = br.readLine().toUpperCase();
//		System.out.println(words);
		
		int[] alphabet_cnt_dict = new int[26];
		
		for (int i = 0; i < words.length(); i++) {
			char ch = words.charAt(i);
			alphabet_cnt_dict[ch-'A']++;
		}
//		System.out.println(Arrays.toString(alphabet_cnt_dict));
		
		int max_idx = -1;
		char res = '?';
		for (int i = 0; i < 26; i++) {
			if (alphabet_cnt_dict[i] > max_idx) {
				max_idx = alphabet_cnt_dict[i];
				
				// 알파벳 value를 idx(i+'A')만큼 이동
				res = (char) (i + 'A');
//				System.out.println(res);
			}
			else if (alphabet_cnt_dict[i] == max_idx) {
				res = '?';
			}
		}
		System.out.println(res);
		
	}
}