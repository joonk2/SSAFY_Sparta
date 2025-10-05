import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int R, C, N;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RCN = br.readLine().split(" ");
		R = Integer.parseInt(RCN[0]);
		C = Integer.parseInt(RCN[1]);
		N = Integer.parseInt(RCN[2]);
		
		char[][] arr = new char[R][C];
		for (int r = 0; r < R; r++) {
			String cols = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = cols.charAt(c);
			}
		}
		
		// full_bomb
		char[][] full_bomb = new char[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				full_bomb[r][c] = 'O';
			}
		}
		
		
		// result
		if (N == 1) {
			lets_print(arr);
		}
		else if (N % 2 == 0) {
			lets_print(full_bomb);
		}
		else if (N % 4 == 3) {
			explode(arr);
			lets_print(arr);
		}
		else if (N >= 5 && (N % 4 == 1)) {
			explode(arr);
			explode(arr);
			lets_print(arr);
		}
	}
	
	
	
	
	
	static void lets_print(char[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(arr[r][c]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	
	
	static char[][] explode(char[][] arr) {
		char[][] full_bomb = new char[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				full_bomb[r][c] = 'O';
			}
		}
		
		
		// explode
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] == 'O') {
					full_bomb[r][c] = '.';
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
							full_bomb[nr][nc] = '.';
						}
					}
				}
			}
		}
		
		
		// transfer full_bomb to arr
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				arr[r][c] = full_bomb[r][c];
			}
		}
		return arr;
	}
	
	
	
}