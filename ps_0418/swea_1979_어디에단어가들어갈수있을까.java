package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;

public class swea_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NK = br.readLine().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);
			
			int[][] map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] col = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(col[c]);
				}
			}
			

			int total_r = 0;
			int total_c = 0;
			
			for (int r = 0; r < N; r++) {
				int temp_r_cnt = 0;
				int temp_c_cnt = 0;
				for (int c = 0; c < N; c++) {
					
					// row check
					if (map[r][c] == 0) {
						if (temp_r_cnt == K) {
							total_r++;
						}
						temp_r_cnt = 0;
					}
					else if (map[r][c] == 1) {
						temp_r_cnt++;
					}
					
					
					// col check
					if (map[c][r] == 0) {
						if (temp_c_cnt == K) {
							total_c++;
						}
						temp_c_cnt = 0;
					}
					else if (map[c][r] == 1) {
						temp_c_cnt++;
					}
				
					
					
				}
				
				// last check (2 individual cases)
				if (temp_r_cnt == K) total_r++;
				if (temp_c_cnt == K) total_c++;
				
			}
			
			
//			System.out.println(total_r);
//			System.out.println(total_c);
			int total_cnt = (total_r + total_c);
			System.out.println("#" + tc + " " + total_cnt);
		
			
		
			
		
//			System.out.println(Arrays.deepToString(map));
			
			
		}
			
			
			
		
	}
}