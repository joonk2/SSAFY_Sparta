package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Stack;

public class boj_9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String round_brackets = br.readLine();
			String res = my_detector(round_brackets);
			System.out.println(res);
		}
	}
	
	
	
	
	
	public static String my_detector(String round_brackets) {
		Stack<Character> my_container = new Stack<>();
		for (int i = 0; i < round_brackets.length(); i++) {
			char temp_char = round_brackets.charAt(i);
			if (temp_char == '(') my_container.push(temp_char);
			if (temp_char == ')') {
				if (my_container.isEmpty()) return "NO";
				if (i == round_brackets.length()-1 && my_container.size() > 1) return "NO";
				if (my_container.peek() == '(') my_container.pop();
			}
			
		}
		if (my_container.size() > 0) return "NO";
		return "YES";
	}
	
	
}