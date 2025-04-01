//package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
		for (int r = 0; r < 5; r++) {
			String[] col = br.readLine().split(" ");
			for (int c = 0; c < 5; c++) {
				bingo[r][c] = Integer.parseInt(col[c]);
			}
		}
		
		
		// check
		int cnt = 0;
		int[][] num_arr = new int[5][5];
		for (int r = 0; r < 5; r++) {
			String[] col = br.readLine().split(" ");
			for (int c = 0; c < 5; c++) {
				num_arr[r][c] = Integer.parseInt(col[c]);
				int cur_num = num_arr[r][c];
				
				
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 5; x++) {
						if (cur_num == bingo[y][x]) {
							bingo[y][x] = 0;
							cnt++;
						}
					}
				}
				
				
				int cnt_row = 0;
				int cnt_col = 0;
				int cnt_diag_left = 0;
				int cnt_diag_right = 0;
				
				// row check
				for (int y = 0; y < 5; y++) {
					int temp_row_cnt = 0;
					for (int x = 0; x < 5; x++) {
						if (bingo[y][x] == 0) {
							temp_row_cnt++;
						}
					}
					if (temp_row_cnt == 5) {
						cnt_row++;
					}
				}
				
				
				
				// break
				if (cnt_row + cnt_col + cnt_diag_left + cnt_diag_right >= 3) {
					System.out.println(cnt);
					return;
				}
				
				
				// col check
				for (int y = 0; y < 5; y++) {
					int temp_col_cnt = 0;
					for (int x = 0; x < 5; x++) {
						if (bingo[x][y] == 0) {
							temp_col_cnt++;
						}
					}
					if (temp_col_cnt == 5) {
						cnt_col++;
					}
				}
				
				
				
				// break
				if (cnt_row + cnt_col + cnt_diag_left + cnt_diag_right >= 3) {
					System.out.println(cnt);
					return;
				}
				
				
				// diag_left
				int temp_diag_left_cnt = 0;
				for (int y = 0; y < 5; y++) {
					if (bingo[y][y] == 0) {
						temp_diag_left_cnt++;
					}
					if (temp_diag_left_cnt == 5) {
						cnt_diag_left++;
					}
				}
				
				
				// break
				if (cnt_row + cnt_col + cnt_diag_left + cnt_diag_right >= 3) {
					System.out.println(cnt);
					return;
				}
				
				
				// diag_right
				int temp_diag_right_cnt = 0;
				for (int y = 0; y < 5; y++) {
					if (bingo[y][4-y] == 0) {
						temp_diag_right_cnt++;
					}
					if (temp_diag_right_cnt == 5) {
						cnt_diag_right++;
					}
				}
				
				
				// break
				
				if (cnt_row + cnt_col + cnt_diag_left + cnt_diag_right >= 3) {
					System.out.println(cnt);
					return;
				}
				
				
				
			}
		}
				
		
		

		
		
		
//		System.out.println(Arrays.deepToString(bingo));
		
		
	}
}