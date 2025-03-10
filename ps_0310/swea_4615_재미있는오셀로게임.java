/*
[아이디어] 
- 중앙좌표를 기준으로 다음 좌표를 0이 아닐때까지 움직이다가 0을 만나면 중단하고, 
- 같은색 돌을 만나면 정지하여 한 좌표만 제외하고 전부 색깔 변환.
*/

package swea_2025_03_10;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// import java.util.Arrays;

public class swea_4615_재미있는오셀로게임 {
	static int[] dy = {-1,1,0,0,   -1, -1, 1, 1};
	static int[] dx = {0,0,-1,1,   1, -1, 1, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			// first setting --> 0;
			int[][] matrix = new int[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					matrix[y][x] = 0;
				}
			}
			
			
			// setting -> middle value
			int line = N-1;
			matrix[(line/2)][(line/2)] = 2;
			matrix[(line/2)][(line/2) + 1] = 1;
			matrix[(line/2) + 1][(line/2)] = 1;
			matrix[(line/2) + 1][(line/2) + 1] = 2;

			
			
			for (int i = 0; i < M; i++) {
				String[] y_x_ChessPiece = br.readLine().split(" ");
				int y = Integer.parseInt(y_x_ChessPiece[0]);
				int x = Integer.parseInt(y_x_ChessPiece[1]);
				int color = Integer.parseInt(y_x_ChessPiece[2]);
				
				
				// idx-1;
				y--;
				x--;
				
				matrix[y][x] = color;
				int temp = matrix[y][x];
				
				
				// 8방향 탐색
				for (int d = 0; d < 8; d++) {
					int ny = dy[d] + y;
					int nx = dx[d] + x;
					boolean canFlip = false;
					
					// 범위를 벗어나지 않고, 다음 방향이 색깔일 떄 
					while (ny >= 0 && ny < N && nx >= 0 && nx < N && matrix[ny][nx] != 0) {
						
						// 다음 방향이 빈칸이면 못 뒤집는다
						if (matrix[ny][nx] == 0) {
							break;
						}
						
						// 같은색 돌을 만나면 멈춤 --> 종료
						if (matrix[ny][nx] == color) {
							canFlip = true;
							break;
						}
						
						ny += dy[d];
						nx += dx[d];
					
					
					
					}
					
					
					// 뒤집을 수 있다면 다시 탐색하여 돌을 뒤집음
					if (canFlip == true) {
						int pre_x = x + dx[d];
						int pre_y = y + dy[d];
						
						while ( !(pre_x == nx && pre_y == ny) ) {
							matrix[pre_y][pre_x] = color;
							pre_x += dx[d];
							pre_y += dy[d];
						}
						
					}
					


					
					
				}
				
			}
			
			
			
			
			
			
			// res
			int black = 0;
			int white = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (matrix[y][x] == 1) {
						black++;
					}
					else if (matrix[y][x] == 2) {
						white++;
					}
				}
			}
			
			
//			System.out.println(Arrays.deepToString(matrix));
			System.out.println("#" + tc + " " + black + " " + white);
			
			
			
		}
		
		
		
	}
}