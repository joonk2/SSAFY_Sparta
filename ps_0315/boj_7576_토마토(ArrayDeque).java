/*
[idea]
------ bfs (ArrayDeque) ------------
if algorithm seems Stack, Queue, Deque --> then just choose ArrayDeque;


- start putting a tomato into queue first.
- while q isnt empty, keep searching.
- if 0 is left, that means because of empty space, you couldn't infect all of them, so return -1; 
- finally, day--; because you need to except the first day;
*/

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
//import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayDeque;

public class boj_7576_토마토 {
	static int M, N;
	static int[][] matrix;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		M = Integer.parseInt(MN[0]);
		N = Integer.parseInt(MN[1]);
		
		matrix = new int[N][M];
		for (int r = 0; r < N; r++) {
			String[] col = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(col[c]);
			}
		}
		
		
		// bfs
		bfs();
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// this means not able to expand to the end
				// because of the empty space, can not move further from that point
				if (matrix[r][c] == 0) {
					System.out.println(-1);
					return;
				}
				
				if (matrix[r][c] > cnt) {
					cnt = matrix[r][c];
				}
				
			}
		}
		
		// except the first day to start
		cnt--;
		System.out.println(cnt);
		
		
//		System.out.println(Arrays.deepToString(matrix));
		
		
	}
	
	
	
	
	public static void bfs() {
//		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> q = new ArrayDeque<>();
		
		// searching startPoint and putting it in q
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (matrix[r][c] == 1) {
					q.add(new int[] {r, c});
				}
			}
		}
		
		// searching
		while (!q.isEmpty()) {
			int[] cur_rc = q.poll();
			int cur_r = cur_rc[0];
			int cur_c = cur_rc[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];
				
				if (nr >=0 && nr < N && nc >= 0 && nc < M && matrix[nr][nc] == 0) {
					matrix[nr][nc] = matrix[cur_r][cur_c] + 1;
					q.add(new int[] {nr, nc});
				}
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}