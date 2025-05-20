package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_2525_오븐시계 {
	static int minute;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");
		int A = Integer.parseInt(AB[0]);
		int B = Integer.parseInt(AB[1]);
		int C = Integer.parseInt(br.readLine());
		
		minute = B+C;
		
		// minute < 60
		if (minute < 60) {
			System.out.println(A + " " + minute);
		} 
		
		// minute > 60
		else if (minute >= 60) {
			A += (minute/60);
			minute = (minute%60);
			
			// 00시부터
			if (A > 23) {
				A-=24;
				System.out.println(A + " " + minute);
			}
			
			// 00시 이전이면
			else if (A < 24) {
				System.out.println(A + " " + minute);
			}
			
		}
		
		
		
		
	}
}