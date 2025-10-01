/*
-------------- 반성할 점 --------------
항상 복잡한 테스트 케이스도 생각하자

5 5 x
OOOOO
.O...
.....
...O.
.O...
*/


package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	static int R, C, N;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] R_C_N = br.readLine().split(" ");
		R = Integer.parseInt(R_C_N[0]);
		C = Integer.parseInt(R_C_N[1]);
		N = Integer.parseInt(R_C_N[2]);
		
		char[][] arr = new char[R][C];
		for (int r = 0; r < R; r++) {
			String cols = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = cols.charAt(c);
			}
		}
		
		char[][] full_bomb = new char[R][C];
		for (int r = 0; r < R; r++) {
			Arrays.fill(full_bomb[r], 'O');
		}
		
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
		else if (N >= 5 && (N % 4) == 1) {
			explode(arr);
			explode(arr);
			lets_print(arr);
		}
	}
	
	
	static void lets_print(char[][] my_arr) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(my_arr[r][c]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	
	static void full_bomb(char[][] char_arr) {
		char[][] full_bomb = new char[R][C];
		for (int r = 0; r < R; r++) {
			Arrays.fill(full_bomb[r], 'O');
		}
	}
	
	
	static char[][] explode(char[][] my_arr) {
		char[][] full_bomb = new char[R][C];
		for (int r = 0; r < R; r++) Arrays.fill(full_bomb[r], 'O');
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (my_arr[r][c] == 'O') {
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
		
		// renewal
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				my_arr[r][c] = full_bomb[r][c];
			}
		}
		return my_arr;
	}
	
	
	
}