package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int[] dr = {0,1,0,-1, -1,-1,1,1};
	static int[] dc = {1,0,-1,0, -1,1,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		int[][] matrix = new int[R][C];
		for (int r = 0; r < R; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
			}
		}
		lets_find_the_safest_area(R, C, matrix);
	}
	
	
	
	
	static void lets_find_the_safest_area(int R, int C, int[][] matrix) {
		int max_val = Integer.MIN_VALUE;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] == 0) {
					boolean[][] visited = new boolean[R][C];
					int sr  = r;
					int sc = c;
					int sd = 0;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {sr, sc, sd});
					visited[sr][sc] = true;
					while (!q.isEmpty()) {
						int[] cur_pos = q.poll();
						int cr = cur_pos[0];
						int cc = cur_pos[1];
						int cd = cur_pos[2];
						if (matrix[cr][cc] == 1) {
							max_val = Math.max(max_val, cd);
							break;
						}
						
						for (int d = 0; d < 8; d ++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];
							if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
								int nd = cd + 1;
								q.add(new int[] {nr, nc, nd});
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(max_val);
	}
	
	
	
}