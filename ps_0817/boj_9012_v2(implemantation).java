package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String round_bracket = br.readLine();
			String res = my_detector(round_bracket);
			System.out.println(res);
		}
	}
	
	
	
	public static String my_detector(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char temp_char = s.charAt(i);
			if (temp_char == '(') cnt++;
			if (temp_char == ')') cnt--;
			if (cnt == -1) return "NO";
		}
		if (cnt == 0) return "YES";
		else return "NO";
	}
	
	
	
	
	
}