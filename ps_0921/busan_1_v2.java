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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve();
	}
	
	
	static void solve() {
		boolean[][] visited = new boolean[100 + 1][100 + 1];
		int cnt = 0;
		for (int[] cur_pos : positions) {
			int r = cur_pos[0];
			int c = cur_pos[1];
			if (!visited[r][c]) {
				visited[r][c] = true;
			}
			else if (visited[r][c]) cnt++;
		}
		System.out.println(cnt);
		
		
		
	}
	
}