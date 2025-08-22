package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// BFS
import java.util.Queue;
import java.util.LinkedList;

// answer
import java.util.ArrayList;
import java.util.Collections;






public class boj_2667_단지번호붙이기 {
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		matrix = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String col = br.readLine();
			for (int c = 0; c < N; c++) {
				matrix[r][c] = col.charAt(c) - '0';
			}
		}
		BFS();
	}
	
	
	
	public static void BFS() {
		ArrayList<Integer> answer_lst = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (matrix[r][c] == 1 && !visited[r][c]) {
					int cnt = house_cnt(r, c);
					answer_lst.add(cnt);
				}
			}
		}
		Collections.sort(answer_lst, Collections.reverseOrder());
		System.out.println(answer_lst.size());
		
		for (int i = answer_lst.size()-1; i >= 0; i--) {
			int temp_val = answer_lst.get(i);
			System.out.println(temp_val);
		}
		
	}
	
	
	
	
	public static int house_cnt(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] cur_pos = q.poll();
			int cur_r = cur_pos[0];
			int cur_c = cur_pos[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (matrix[nr][nc] == 1 && !visited[nr][nc]) {
						q.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
			
		}
		return cnt;
	}
	
	
	
	
	
	
	
}