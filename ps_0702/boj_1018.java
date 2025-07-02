/*
우리가 구할 값은 W와 B중 어느 것을 더 적게 칠할지 횟수의 최소값을 구해야 한다.
우선 여기서 각 좌표를 고정해 8*8만큼 배열 탐색을 하니까

탐색 범위를 잘 조정해주고,
문제를 읽어보면 우리는 r+c가 짝수일때 char들이 동일하고, r+c가 홀수일때 char들이 각각 동일해야한다는 것을 알 수 있다.

(r+c) 가 짝수일때 B나 W로 위치를 고정
(r+c)가 홀수일때 다음과 같이 위치를 변경하자
B --> W
W --> B
*/



package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class boj_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		char[][] board = new char[N][M];
		
		for (int r = 0; r < N; r++) {
			String col = br.readLine();
			for (int c = 0; c < M; c++) {
				board[r][c] = col.charAt(c);
			}
		}
		
		int res = find_min_cnt(N, M, board);
		System.out.println(res);
		
		
	}
	
	
	public static int find_min_cnt(int N, int M, char[][] board) {
		int res = Integer.MAX_VALUE;
		
		for (int r = 0; r < N-7; r++) {
			for (int c = 0; c < M-7; c++) {
				int change_to_W = 0;
				int change_to_B = 0;
				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						char temp = board[r+x][c+y];
						
						if ( (x+y) % 2 == 0 ) {
							if (temp == 'W') change_to_W++;
							if (temp == 'B') change_to_B++;
						}
						else if ( (x+y) % 2 != 0 ) {
							if (temp != 'W') change_to_W++;
							if (temp != 'B') change_to_B++;
						}
					}
				}
				res = Math.min(res, Math.min(change_to_W, change_to_B));
			}
		}
		
		return res;
	}
	
	
}