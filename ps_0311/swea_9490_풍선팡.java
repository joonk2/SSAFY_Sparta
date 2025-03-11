/*
[아이디어]
- 문제에서 한 특정 위치의 꽃가루 갯수만큼 상하좌우로 풍선이 추가로 터지는 것이니 범위 연장을 생각해보자
- 그 범위 연장한 상태에서 풍선을 터뜨려 나올 수 있는 최대값을 구한다
*/

package swea_2025_03_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea_9490_풍선팡 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			
			// N*M 배열 생성
			int[][] matrix = new int[N][M];
			
			// 값 할당
			for (int y = 0; y < N; y++) {
				String[] col = br.readLine().split(" ");
				for (int x = 0; x < M; x++) {
					matrix[y][x] = Integer.parseInt(col[x]);
				}
			}
			
			// delta searching
			int max_sum = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					int temp = matrix[y][x];
					int range = matrix[y][x];
					
					for (int d = 0; d < 4; d++) {
						for (int k = 1; k < range + 1; k++) {
							int ny = (dy[d] * k) + y;
							int nx = (dx[d] * k) + x;
							
							if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
								temp += matrix[ny][nx];
							}
							
						}
					}
					
					
					// renewal max_val
					if (temp > max_sum) {
						max_sum = temp;
					}
					
					
					
				}
			}
			
			
			System.out.println("#" + tc + " " + max_sum);
			
			
			
			
		}
			
			
		
	}
}