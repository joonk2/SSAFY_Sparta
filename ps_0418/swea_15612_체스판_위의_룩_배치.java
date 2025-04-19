package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class swea_15612_체스판_위의_룩_배치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc < T+1; tc++) {
			
			char[][] map = new char[8][8];
			for (int r = 0; r < 8; r++) {
				String col = br.readLine();
				for (int c = 0; c < 8; c++) {
					map[r][c] = col.charAt(c);
				}
			}
			
			// cond-1. should be 8 rooks
			// cond-2. no same col, no same row
			
			boolean warning_r = false;
			boolean warning_c = false;
			int total_r_check_8 = 0;
			int total_c_check_8 = 0;
			for (int r = 0; r < 8 ; r++) {
				int temp_r_cnt = 0;
				int temp_c_cnt = 0;
				for (int c = 0; c < 8; c++) {
					
					// row check
					char row_ch = map[r][c];
					if (row_ch == 'O') {
						temp_r_cnt++;
						total_r_check_8++;
					}
					
					// col check
					char col_ch = map[c][r];
					if (col_ch == 'O') {
						temp_c_cnt++;
						total_c_check_8++;
					}
					
					
					
					// last check
					if (temp_r_cnt == 2) {
						warning_r = true;
						break;
					} 
					
					if (temp_c_cnt == 2) {
						warning_c = true;
						break;
					}
				
					
					
				}
				
				// final_check
				if (warning_r == true) {
					break;
				}
				
				if (warning_c == true) {
					break;
				}
				
			}
			
			
			// result (4 cases)
			int r8 = total_r_check_8;
			int c8 = total_c_check_8;
			if (r8 == 8 && c8 == 8 && warning_r == false && warning_c == false) {
				System.out.println("#" + tc + " " + "yes");
			}
			else {
				System.out.println("#" + tc + " " + "no");
			}
			
			
//			System.out.println(Arrays.deepToString(map));
			
			
			
		}
		
		
		
	}
}