package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_24313_알고리즘수업_점근적표기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a1_a0 = br.readLine().split(" ");
		
		int a1 = Integer.parseInt(a1_a0[0]);
		int a0 = Integer.parseInt(a1_a0[1]);
		
		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());
		
		int res = f(a1, a0, c, n0);
		System.out.println(res);
		
	}
	
	public static int f(int a1, int a0, int c, int n0) {
		int res = -1;
		if ( a1 <= c && ((a1*n0) + a0 <= c * n0) ) {
			res = 1;
		}
		else {
			res = 0;
		}
		return res;
	}
	
	
}