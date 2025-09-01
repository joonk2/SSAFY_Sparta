package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class swea_1949_등산로조성 {
	static int T;
	static int N, K;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max_height;
	static int max_leng;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NK = br.readLine().split(" ");
			N = Integer.parseInt(NK[0]);
			K = Integer.parseInt(NK[1]);
			matrix = new int[N][N];
			visited = new boolean[N][N];
			max_leng = 1;
			max_height = 0;
			
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					matrix[r][c] = Integer.parseInt(cols[c]);
					int cur_height = matrix[r][c];
					if (cur_height > max_height) max_height = cur_height;
				}
			}
			
			
			// answer
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (matrix[r][c] == max_height) {
						visited[r][c] = true;
						dfs(r, c, 1, 1);
						visited[r][c] = false;
					}
				}
			}
			System.out.println("#" + tc + " " + max_leng);
		}
	}
	
	
	
	static void dfs(int r, int c, int cut_used, int cur_leng) {
		for (int d = 0; d < 4; d++) {
			if (max_leng < cur_leng) max_leng = cur_leng;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				if (matrix[r][c] > matrix[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, cut_used, cur_leng+1);
					visited[nr][nc] = false;
				}
				else if (matrix[r][c] <= matrix[nr][nc]) {
					if (cut_used == 1 && matrix[r][c] > matrix[nr][nc] - K) {
						int original = matrix[nr][nc];
						matrix[nr][nc] = matrix[r][c]-1;
						visited[nr][nc] = true;
						dfs(nr, nc, 0, cur_leng+1);
						matrix[nr][nc] = original;
						visited[nr][nc] = false;
					}
				}
			}
		}
	}
	
	
	
	
	
	
}