package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

//import java.util.Arrays;

public class boj_10157_자리배정 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] CR = br.readLine().split(" ");
		int K = Integer.parseInt(br.readLine());
		
		
		int C = Integer.parseInt(CR[0]);
		int R = Integer.parseInt(CR[1]);
		int[][] map = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		
		int x = R-1;
		int y = 0;
		int d = 0;
		K--;
		visited[x][y] = true;
		
//	--------------- debug --------------------
//		int num = 1;
//		map[x][y] = num;
//		System.out.println(map[x][y]);
//		System.out.println("좌표" + "-->" + " " + x + " " + y);
		
		if (K > R*C) {
			System.out.println(0);
		}
		else {
			while (K > 0) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny]) {
					K--;
					visited[nx][ny] = true;
					x = nx;
					y = ny;
					
//		------------debug-------------------
//					num++;
//					map[x][y] = num;
//					System.out.println(map[x][y]);
//					System.out.println("좌표" + "-->" + " " + x + " " + y);	
				}
				else {
					d = (d+1) % 4;
				}
				


				
			}
			
			
			System.out.println( (y+1) + " " + (R-x) );
		}
		
		
		
// --------------- debug -----------------------		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		
		
		

		
	}
}