/*
----------- 조건 -----------
1 <= positions.length <= 100,000
각 좌표는 X, Y
1 <= X,Y <= 100;
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main {
	static int[][] positions = {
			{1,2}, {1,2}, {2,1}, {4,3}, {4, 3}, {4, 3}
	};
	
	static int min_x = Integer.MAX_VALUE;
	static int min_y = Integer.MAX_VALUE;
	static int max_x = Integer.MIN_VALUE;
	static int max_y = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve();
	}
	
	
	static void solve() {
		for (int[] cur_pos : positions) {
			int r = cur_pos[0];
			int c = cur_pos[1];
			if (r < min_x) min_x = r;
			if (c < min_y) min_y = c;
			if (r > max_x) max_x = r;
			if (c > max_y) max_y = c;
		}
		
		int[][] student_book = new int[max_x + 1][max_y+1];
		for (int[] cur_pos : positions) {
			int r = cur_pos[0];
			int c = cur_pos[1];
			student_book[r][c]++;
		}
		
		int cnt = 0;
		for (int r = min_x; r < max_x + 1; r++) {
			for (int c = min_y; c < max_y + 1; c++) {
				int cur_val = student_book[r][c];
				if (cur_val > 1) {
					cnt += (cur_val-1);
				}
			}
		}
		System.out.println(cnt);
		
	}
	
}