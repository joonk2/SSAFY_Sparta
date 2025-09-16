/*
최악의 실행시간은 

1. 배열 만들기 연산 횟수
(1024 + 1)^2
 
2. 1차 누적합 연산 횟수
(1024 + 1)^2

2. 2차 누적합 연산 횟수
(1024 + 1)^2

마지막으로 결과 출력 연산 횟수
100,000

최악의 실행시간은 결과적으로 (3N^2 + M)

시간복잡도는 O(N^2 + M)
*/


package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class boj_11660_구간합구하기5_v2 {
	static int N, M;
	static int[][] S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		S = new int[N+1][N+1];
		for (int r = 1; r < N+1; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 1; c < N+1; c++) {
				S[r][c] = Integer.parseInt(cols[c-1]);
			}
		}
		
		// 2 steps of prefix_sum are required
		
		// prefix_sum (first step)
		for (int r = 1; r < N+1; r++) {
			for (int c = 2; c < N+1; c++) {
				S[r][c] = S[r][c-1] + S[r][c];
			}
		}
		
		// prefix_sum (second step)
		for (int r = 1; r < N+1; r++) {
			for (int c = 2; c < N+1; c++) {
				S[c][r] = S[c-1][r] + S[c][r];
			}
		}
		
		
		// res
		for (int i = 0; i < M; i++) {
			String[] x1_y1_x2_y2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(x1_y1_x2_y2[0]);
			int y1 = Integer.parseInt(x1_y1_x2_y2[1]);
			int x2 = Integer.parseInt(x1_y1_x2_y2[2]);
			int y2 = Integer.parseInt(x1_y1_x2_y2[3]);
			
			x1 = x1-1;
			y1 = y1-1;
			
			int answer = S[x2][y2] + S[x1][y1] - S[x2][y1] - S[x1][y2];
			System.out.println(answer);
		}
		
		
	}
}
