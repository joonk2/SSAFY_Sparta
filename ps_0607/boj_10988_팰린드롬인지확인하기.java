package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10988_팰린드롬인지확인하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		boolean res = my_custom_palindrome_checker(word);
		if (res == true) {
			System.out.println(1);
		}
		if (res == false) {
			System.out.println(0);
		}
		
		
		
	}
	
	public static boolean my_custom_palindrome_checker(String str) {
		
		// 1번이라도 틀리면 return false
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		
		// 반복문을 거쳤는데 아무 이상 없으면 return true
		return true;
	}
	
	
}