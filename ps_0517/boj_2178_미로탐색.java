package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Queue;
import java.util.LinkedList;

//import java.util.Arrays;

public class boj_2178_미로탐색 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] maze = new int[N][M];
		for (int r = 0; r < N; r++) {
			String col = br.readLine();
			for (int c = 0; c < M; c++) {
				maze[r][c] = col.charAt(c)-'0';
			}
		}
				
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(maze[i]));
//		}
		
		boolean[][] visited = new boolean[N][M];
		int[][] dist = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		// 초기값 설정 (출발 지점은 [0][0]에서 출발하며 항상 1이다)
		visited[0][0] = true;
		dist[0][0] = 1;
		q.add(new int[]{0,0});
		
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		
		// 탐색
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int r = pos[0];
			int c = pos[1];
			
			// 4방향
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 범위를 벗어나면 지나치자
				if (nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
				
				// 다음 좌표가 1이고, 미방문하였다면 --> 방문표시, 누적거리 추가, q에 대입
				if (maze[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dist[nr][nc] = dist[r][c] + 1;
					q.add(new int[] {nr,nc});
				}
			}
		}
		
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		System.out.println(dist[N-1][M-1]);
		
		
		
	}
}