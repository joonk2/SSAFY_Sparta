/*
[접근 방식]
- 처음에 delta 탐색도 고민했으나, 이 문제에 적용X
- 대신에 중앙을 기점으로 위, 아래로 확장해나가며 값을 합산해주는 방식으로 적용

[코드 요약]
- 중앙에서 시작하여 값을 위 아래로 확장해나가며 더해주고, 
- 중복되었던 중앙을 2번 더했던 값에서 1번을 차감시켜줌. 
*/

package ps_0306;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class swea_2805_농작물_수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		
		// test case만큼 반복
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 2차원배열 int[][] farm 선언 
			int[][] farm = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				String col = br.readLine();
				for (int x = 0; x < N; x++) {
					farm[y][x] = col.charAt(x) - '0';
				}
			}
			
			

			// 합, 시작점, 위로가는 방향, 아래로 가는 방향
			int sum = 0;
			int start = (N/2);
			int roof = 0;
			int bottom = 0;
			
			
			// 위로 올라가는 값
			while (start-roof > -1 && start+bottom < N) {
				for (int y = (N/2)-roof; y < (N/2)-roof + 1; y++) {
					for (int x = 0 + roof; x < N - roof; x++) {
						sum += farm[y][x];
					}
				}
				roof++;
				
				
				// 아래로 내려가는 값
				for (int y = (N/2)+bottom; y < (N/2) + bottom+1; y++) {
					for (int x = 0 + bottom; x < N-bottom; x++) {
						sum += farm[y][x];
					}
				}
				bottom++;
				
				
			}
			
			
			// 중복값 제거
			// (중앙이 2번 더해졌기 때문)
			for (int y = (N/2); y < (N/2) + 1; y++) {
				for (int x = 0; x < N; x++) {
					sum -= farm[y][x];
				}
			}
			
			
			// res
			System.out.println("#" + tc + " " + sum);
			
//			디버깅
//			System.out.print(Arrays.deepToString(farm));
			
			
			
		}
		
	}
}
