package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class boj_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().toUpperCase();
//		System.out.println(word);
		
		int[] cnt = new int[26];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			cnt[ch-'A']++;
		}
//		System.out.println(Arrays.toString(cnt));
		
		
		
		int max_val = -99999;
		char res = '?';
		for (int i = 0 ; i < 26; i++) {
			if (cnt[i] > max_val) {
				max_val = cnt[i];
				res = (char) (i + 'A');
			}
			else if (cnt[i] == max_val) {
				res = '?';
			}
		}
		
		System.out.println(res);
		
		
//		System.out.println((char)(3 + 'A'));
//		System.out.println((char)(4 + 'A'));
//		System.out.println((char)(5 + 'A'));

		
	}
}