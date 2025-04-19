package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class swea_16208_풍선팡 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] row_col = br.readLine().split(" ");
			int row = Integer.parseInt(row_col[0]);
			int col = Integer.parseInt(row_col[1]);
			
			int[][] map = new int[row][col];
			for (int r = 0; r < row; r++) {
				String[] string_col = br.readLine().split(" ");
				for (int c = 0; c < col; c++) {
					map[r][c] = Integer.parseInt(string_col[c]);
				}
			}
			
			
			
			int max_sum = Integer.MIN_VALUE;
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					int temp_sum = map[r][c];
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (0 <= nr && nr < row && 0 <= nc && nc < col) {
							temp_sum += map[nr][nc];
						}
						
					}
					if (temp_sum > max_sum) max_sum = temp_sum;
					
				}
			}
			
			
//			System.out.println(Arrays.deepToString(map));
			System.out.println("#" + tc + " " + max_sum);
			
			
		}
		
		
		
	}
}