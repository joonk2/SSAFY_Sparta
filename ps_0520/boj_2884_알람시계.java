package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_2884_알람시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] HM = br.readLine().split(" ");
		int H = Integer.parseInt(HM[0]);
		int M = Integer.parseInt(HM[1]);
		
		// (M >= 45)
		if (M >= 45) {
			M -= 45;
			System.out.println(H + " " + M);
		}
		else if (M < 45) {
			H--;
			M += 60;
			M -= 45;
			if (H < 0) {
				H = 23;
			}
			
			System.out.println(H + " " + M);
			
		}
		
		
		
	}
}