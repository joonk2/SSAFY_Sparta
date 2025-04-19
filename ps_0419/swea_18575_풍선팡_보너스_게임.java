package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class swea_18575_풍선팡_보너스_게임 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				String[] col = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(col[c]);
				}
			}
				
			
			int max_sum = Integer.MIN_VALUE;
			int min_sum = Integer.MAX_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int temp_sum = map[r][c];
					for (int k = 1; k < N; k++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + (dr[d]*k);
							int nc = c + (dc[d]*k);
							
							if (0 <= nr && nr < N && 0 <= nc && nc < N) {
								temp_sum += map[nr][nc];
							}
							
						}
					}
					if (temp_sum > max_sum) max_sum = temp_sum;
					if (temp_sum < min_sum) min_sum = temp_sum;
				}

				
			

			}
			
//			System.out.println(Arrays.deepToString(map));
//			System.out.println("#" + tc + " " + max_sum);
//			System.out.println("#" + tc + " " + min_sum);
			int res = max_sum - min_sum;
			System.out.println("#" + tc + " " + res);

		}
		
		
		
	}
}