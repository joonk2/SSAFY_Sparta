package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
 
public class swea_1949_등산로조성 {
    static int N, K;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max_height;
    static int max_leng;
     
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            String[] NK = br.readLine().split(" ");
            N = Integer.parseInt(NK[0]);
            K = Integer.parseInt(NK[1]);
             
            matrix = new int[N][N];
            visited = new boolean[N][N];
            max_height = 0;
            max_leng = 1;
             
            for (int r = 0; r < N; r++) {
                String[] cols = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = Integer.parseInt(cols[c]);
                    int cur_height = matrix[r][c];
                    if (cur_height > max_height) max_height = cur_height;
                }
            }
             
 
            // answer
            // dfs 방문을 진행하고, 방문 초기화 왜?? -->  다른 경로에서 해당 좌표를 방문할 수도 있으니까
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (matrix[r][c] == max_height) {
                        visited[r][c] = true;
                        dfs(r, c, 1, 1);
                        visited[r][c] = false;
                    }
                }
            }
            System.out.println("#" + tc + " " + max_leng);
        }
    }
     
     
     
     
    static void dfs(int r, int c, int whether_cut_used, int cur_leng) {
        for (int d = 0; d < 4; d++) {
            if (cur_leng > max_leng) max_leng = cur_leng;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                // 조건
                // 1. cur_height > next_height
                // 2. cur_height <= next_height
                    // 2-1. 자를 수 있고 && cur_height > next_height - K 
                 
                if (matrix[r][c] > matrix[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, whether_cut_used, cur_leng + 1);
                    visited[nr][nc] = false;
                }
                else if (matrix[r][c] <= matrix[nr][nc]) {
                    if (whether_cut_used == 1 && matrix[r][c] > matrix[nr][nc] - K) {
                        int backup = matrix[nr][nc];
                        matrix[nr][nc] = matrix[r][c] - 1;
                        visited[nr][nc] = true;
                        dfs(nr, nc, 0, cur_leng + 1);
                        matrix[nr][nc] = backup;
                        visited[nr][nc] = false;
                    }
                }
            }
        }
    }
     
     
     
     
     
     
     
     
}