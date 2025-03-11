package swea_2025_03_11;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class swea_16268_풍선팡2 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			
			// array (N*M) 
			int[][] matrix = new int[N][M];
			
			// to input value into matrix
			for (int y = 0; y < N; y++) {
				String[] col = br.readLine().split(" ");
				for (int x = 0; x < M; x++) {
					matrix[y][x] = Integer.parseInt(col[x]);
				}
			}
			
			
			// searching max_val
			int max_val = Integer.MIN_VALUE;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					int temp_sum = matrix[y][x];
					
					for (int d = 0; d < 4; d++) {
						int ny = dy[d] + y;
						int nx = dx[d] + x;
						
						// while문을 사용하지 않는 이유는 해당좌표 기준으로 상,하,좌,우 만 확인하면 되기에 전체 델타 탐색할 필요가 없다
						if (ny >=0 && ny < N && nx >= 0 && nx < M) {
							temp_sum += matrix[ny][nx];
						}
						
					}
					
					// renewal - max_val
					if (temp_sum > max_val) {
						max_val = temp_sum;
					}
					
					
					
				}
				

				
				
			}
							
			System.out.println("#" + tc + " " + max_val);
			
			// debug
//			System.out.println(Arrays.deepToString(matrix));
		}
		
	}
}