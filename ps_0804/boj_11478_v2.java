package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

public class boj_11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		Set<String> res = my_solution(word);
		System.out.print(res.size());
	}
	
	
	

	public static Set<String> my_solution(String word) {
		Set<String> answer = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			for (int j = i+1; j < word.length()+1; j++) {
				answer.add(my_custom_substring(word, i, j));
			}
		}
		return answer;
		
	} 
	

	
	
	public static String my_custom_substring(String word, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}
	
	
	
}