/*
첫 시작은 r, c, d -> 0,0,0 에서 시작하여 2가지 경우로 탐색한다
첫 번째 : 그 자리에서 회전만 했을 때
두 번째 : 직진 방향 탐색

회전할 때마다 횟수가 1개씩 늘어나기에,
현위치에서 회전만 수행한 최소거리 좌표[r][c][nd] > cnt + 1 라면 [r][c][nd] = cnt + 1

직진방향 탐색을 위해 for (int d = 0; d < 4; d++)은 쓰지 않는다
--> 왜냐하면 직진은 cnt++이 아니니까
범위 조건에 위배되지않고, 해당 좌표[nr][nc][d] > cnt 라면 [nr][nc][d] = cnt

매번 사과좌표에 도달할 때마다, 총 회전수에 회전한 횟수를 더해주며, 시작행을 er, 시작열을 ec, 시작위치를 당시 마지막 d로 갱신
*/





import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int T;
	static int N;
	static int[][] matrix;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int max_apple_size;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			
			max_apple_size = 0;
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					matrix[r][c] = Integer.parseInt(cols[c]);
					int cur_val = matrix[r][c];
					if (cur_val > max_apple_size) max_apple_size = cur_val;
				}
			}
			
			int[][] apple_pos = new int[max_apple_size + 1][2];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cur_val = matrix[r][c];
					if (cur_val > 0) {
						apple_pos[cur_val][0] = r;
						apple_pos[cur_val][1] = c;
					}
				}
 			}
			
			int cr = 0;
			int cc = 0;
			int cd = 0;
			int total_rotation_cnt = 0;
			for (int i = 1; i < max_apple_size + 1; i++) {
				int[] res = bfs(cr, cc, cd, apple_pos[i][0], apple_pos[i][1]);
				total_rotation_cnt += res[0];
				cr = apple_pos[i][0];
				cc = apple_pos[i][1];
				cd = res[1];
			}
			System.out.println("#" + tc + " " + total_rotation_cnt);
		}
	}
	
	
	
	
	static int[] bfs(int sr, int sc, int sd, int er, int ec) {
		Queue<int[]> q = new LinkedList<>();
		
		// bfs 방문마다 최소거리 좌표 항상 초기화
		int[][][] min_rot = new int[N][N][4];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				Arrays.fill(min_rot[r][c], Integer.MAX_VALUE);
			}
		}
		
		min_rot[sr][sc][sd] = 0;
		q.offer(new int[] {sr, sc, sd});
		
		while (!q.isEmpty()) {
			int[] cur_pos = q.poll();
			int r = cur_pos[0];
			int c = cur_pos[1];
			int d = cur_pos[2];
			int cnt = min_rot[r][c][d];
			
			// 큐에서 원소를 빼다가 도달하면 반환하고 종료
			if (r == er && c == ec) {
				return new int[] {cnt, d};
			}
			
			// 회전
			int nd = (d+1) % 4;
			if (min_rot[r][c][nd] > cnt + 1) {
				min_rot[r][c][nd] = cnt + 1;
				q.offer(new int[] {r, c, nd});
			}
			
			// 직진
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (min_rot[nr][nc][d] > cnt) {
					min_rot[nr][nc][d] = cnt;
					q.offer(new int[] {nr, nc, d});
				}
			}
		}
		// 값을 못찾으면 --> 최댓값, 당시 방향 반환
		return new int[] {Integer.MAX_VALUE, sd};
	}
	
	
	
	
}