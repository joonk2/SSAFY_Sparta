/*
[아이디어]
2가지 경우를 생각해보자
- 다음 원소를 포함하며 탐색
- 다음 원소를 포함하지 않으며 탐색
 
*/

package swea_2025_03_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea_5215_햄버거다이어트 {
	static int N, L, max_score;
	static int[] T, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC+1; tc++) {
			String[] arr = br.readLine().split(" ");
			N = Integer.parseInt(arr[0]);
			L = Integer.parseInt(arr[1]);
			
			T = new int[N];
			K = new int[N];
			for (int i = 0; i < N; i++) {
				String[] lst = br.readLine().split(" ");
				T[i] = Integer.parseInt(lst[0]);
				K[i] = Integer.parseInt(lst[1]);
			}
			
			
			max_score = 0;
			dfs(0,0,0);
			
			
			System.out.println("#" + tc + " " + max_score);
			
			
			
		}
	
	
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	public static void dfs(int idx, int cur_score, int cur_cal) {		
		// cur_cal 이 1000 초과시 종료
		if (cur_cal > L) {
			return;
		}

		
		// 최댓값 갱신
		max_score = Math.max(max_score, cur_score);
		
		
		// 인덱스를 다 찾고 범위 밖을 넘어가는순간부터 종료
		if (idx == N) {
			return;
		}
		
		
		
		// 원소를 포함하며 탐색
		dfs(idx+1, cur_score + T[idx], cur_cal + K[idx]);
		
		// 원소를 포함하지 않고 탐색
		dfs(idx+1, cur_score, cur_cal);
		
		
		
	}
	
	
	
	
}