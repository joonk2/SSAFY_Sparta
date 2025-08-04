package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_1934_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			int res = my_custom_lcd(A, B);
			System.out.println(res);
		}
	}
	
	
	
	
	public static int my_custom_lcd(int x, int y) {
		return (x * y) / my_custom_gcd(x, y);
	}
	
	
	
	
	public static int my_custom_gcd(int x, int y) {
		while (y != 0) {
			int temp = (x%y);
			x = y;
			y = temp;
		}
		return x;
	}
	
	
}