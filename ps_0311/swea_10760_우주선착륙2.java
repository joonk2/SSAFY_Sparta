/*
[아이디어]
- 8방향을 돌아보며 4방향 이상일때부터 내려갈 수 있는 공간있다면 그걸 가산하여 몇개인지 반환.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
	// delta
	// up,down, left, right,    diag(왼위, 오른위, 왼아래, 오른아래)
    static int[] dy = {-1, 1, 0, 0,     -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1,     -1, 1, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]); 
            int M = Integer.parseInt(arr[1]); 
            
            int[][] matrix = new int[N][M];
            for (int y = 0; y < N; y++) {
                String[] col = br.readLine().split(" ");
                for (int x = 0; x < M; x++) {
                    matrix[y][x] = Integer.parseInt(col[x]);
                }
            }
            
            int max_cnt = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    int temp = matrix[y][x];
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int ny = dy[d] + y;
                        int nx = dx[d] + x;
                        
                        // 경계를 벗어나지 않으면
                        if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                            // 현재 값보다 작은 값이 있으면 카운트 증가
                            if (temp > matrix[ny][nx]) {
                                cnt++;
                            }
                        }
                    }
                    
                    // 값 4개 이상시 최신화
                    if (cnt >= 4) {
                        max_cnt++;
                    }
                    
                    
                }
            }
            System.out.println("#" + tc + " " + max_cnt);
        }
    }
}
