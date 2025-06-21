package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1193_분수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		String res = fraction(X);
		System.out.println(res);
	}
	
	public static String fraction(int X) {
		int line = 1;
		String answer = "";
		int top = 0;
		int bottom = 0;
		
		
		while (X > line) {
			X -= line;
			line++;
		}
		
		if (line % 2 == 1) {
			top = line - X + 1;
			bottom = X;
		}
		else if (line % 2 == 0) {
			top = X;
			bottom = line - X + 1;
		}
		
		answer = top + "/" + bottom;
		
		return answer;
	}
	
	
}