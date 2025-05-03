package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;
public class swea_1954_달팽이 {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			int r = 0;
			int c = 0;
			
			int num = 1;
			map[r][c] = num;
			visited[r][c] = true;
			int d = 0;
			
//			// debug	
//			System.out.println(num);
//			System.out.println(map[r][c]);
//			System.out.println("좌표  -->" + " " + r + " " + c);
			
			
			while (N*N > num) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
					num++;
					map[nr][nc] = num;
					visited[nr][nc] = true;
					r = nr;
					c = nc;
					
//					// debug	
//					System.out.println(num);
//					System.out.println(map[r][c]);
//					System.out.println("좌표  -->" + " " + r + " " + c);
					
				}
				else {
					d = (d+1)%4;
				}

				
				
			}
			
			
			
			
//	-----------  debug -------------
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + "\n");
			
			for (int i = 0 ; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]);
					if (j != N-1) sb.append(" ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
				
			
			
		}
		
		
	}
}