package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// import java.util.Arrays;

public class swea_12712_파리퇴치3 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[] dr_diag = {-1,-1,1,1};
	static int[] dc_diag = {-1,1,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			int[][] map = new int[N][N];
			
			
			for (int r = 0; r < N; r++) {
				String[] col = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(col[c]);
				}
			}
			
			
			int max_sum = 0;
			int max_sum_diag = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int temp_sum = map[r][c];
					int temp_sum_diag = map[r][c];
					for (int k = 1; k < M; k++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + (dr[d]*k);
							int nc = c + (dc[d]*k);
							int nr_diag = r + (dr_diag[d]*k);
							int nc_diag = c + (dc_diag[d]*k);
							
							if (0 <= nr && nr < N && 0 <= nc && nc < N) {
								temp_sum += map[nr][nc];
							}
							
							if (0 <= nr_diag && nr_diag < N && 0 <= nc_diag && nc_diag < N) {
								temp_sum_diag += map[nr_diag][nc_diag];
							}
							
							
							
						}
					}
					
					if (temp_sum > max_sum) max_sum = temp_sum;
					if (temp_sum_diag > max_sum_diag) max_sum_diag = temp_sum_diag;
					
					
				}
			}
	
			
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			if (max_sum >= max_sum_diag) {
				System.out.println("#" + tc + " " + max_sum); 
			}
			else {
				System.out.println("#" + tc + " " + max_sum_diag);
			}
			
			
			
		}
		
		
	}
	
}