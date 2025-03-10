/*
[아이디어]
특정 target을 찾으면 check = true로 변경후 반복문을 종료한다.

*/

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea_12004_구구단1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int target = Integer.parseInt(br.readLine());
			
			// 확인용
			boolean check = false;
			
			// 구구단
			for (int i = 1; i < 9 + 1; i++) {
				for (int j = 1; j < 9 + 1; j++) {
					int temp = (i * j);
					if (temp == target) {
						check = true;
						break;
					}
					
					
				}
			}
			
			
			
			// res
			if (check == false) {
				System.out.println("#" + tc + " " + "No");
			}
			else {
				System.out.println("#" + tc + " " + "Yes");
			}
			
			
			
			
			
		}
		
		
	}
}