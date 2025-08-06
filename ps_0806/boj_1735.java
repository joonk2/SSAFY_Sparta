package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_1735_분수합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A1_B1 = br.readLine().split(" ");
		String[] A2_B2 = br.readLine().split(" ");
		
		int A1 = Integer.parseInt(A1_B1[0]);
		int B1 = Integer.parseInt(A1_B1[1]);
		int A2 = Integer.parseInt(A2_B2[0]);
		int B2 = Integer.parseInt(A2_B2[1]);
		
		int bottom = lcm(B1, B2);
		int top = ((bottom/B1)*A1) + ((bottom/B2)*A2);
		int final_gcd = gcd(top, bottom);
		
		System.out.println( (top/final_gcd) + " " + (bottom/final_gcd) );
		
	}
	
	
	
	public static int lcm(int x, int y) {
		return (x*y) / gcd(x, y);
	}
	
	
	
	public static int gcd(int x, int y) {
		while (y != 0) {
			int temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}
	
	
	
	
}