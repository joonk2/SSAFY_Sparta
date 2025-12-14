/*
그리디 
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	static char[] block;
	static int[] numbers;
	static int N;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			String num_arr = br.readLine();
			block = br.readLine().toCharArray();
			numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = num_arr.charAt(i) - '0';
			}
			
			
			lets_find_maximum_bomb();			
		}
		
		
		
	}
	
	
	
	
	
	static void lets_find_maximum_bomb() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// 1. 지뢰일 때 놓을 수 있는지 검사
			if (block[i] == '*') {
				for (int j = i-1; j <= i+1; j++) {
					if (j >= 0 && j < N) {
						numbers[j]--;
					}
				}
				cnt++;
			}
			// 2-1. 지뢰가 아닐 때 놓을 수 있는지 검사
			else if (block[i] == '#') {
				boolean flag = true;
				for (int j = i-1; j <= i+1; j++) {
					if (j >= 0 && j < N && numbers[j] <= 0) {
						flag = false;
						break;
					}
				}
				// 2-2. 유효성 검사
				if (flag) {
					for (int j = i-1; j <= i+1; j++) {
						if (j >= 0 && j < N) {
							numbers[j]--;
						}
					}
					block[i] = '*';
					cnt++;
				}
			}
		}
		// 3. 출력
		System.out.println(cnt);	
	}
	
	
	
	
	
}