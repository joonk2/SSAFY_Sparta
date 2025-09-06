package boj;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;



public class boj_17070_파이프옮기기1 {
	static int N;
	static int[][] matrix;
	static int[] dr = {0,1,1};
	static int[] dc = {1,0,1};
	static int total_cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
			}
		}
		dfs(0, 1, 0);
		System.out.println(total_cnt);
	}
	
	
	
	
	
	
	static void dfs(int r, int c, int direction) {
		
		// 최대깊이 도달시 종료
		if (r == N-1 && c == N-1) {
			total_cnt++;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			// 3가지 경우
			// 1. 가로일 때, 가로 or 대각선
			// 2. 세로일 때, 세로 or 대각선
			// 3. 대각선일 때, 가로 or 세로 or 대각선
			if ( (direction == 0 && (d == 0 || d == 2) ) || (direction == 1 && (d == 1 || d == 2) ) || (direction == 2 && (d == 0 || d == 1 || d == 2) ) ) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && matrix[nr][nc] == 0) {
					if (d == 0) {
						dfs(nr, nc, 0);
					}
					else if (d == 1) {
						dfs(nr, nc, 1);
					}
					else if (d == 2) {
						if (matrix[r+1][c] == 0 && matrix[r][c+1] == 0) {
							dfs(nr, nc, 2);
						}
					}
				}
			}
		}
	}
	
	
	
	
}