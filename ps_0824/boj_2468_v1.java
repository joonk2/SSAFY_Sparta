package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// DFS
import java.util.Stack;



public class boj_2468_안전지대_v1 {
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] matrix;
    static int max_val = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int r = 0; r < N; r++) {
            String[] cols = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                matrix[r][c] = Integer.parseInt(cols[c]);
                if (matrix[r][c] > max_val) max_val = matrix[r][c];
            }
        }
        DFS();
    }




    public static void DFS() {
        int max_cnt = 0;
        for (int height = 0; height < max_val + 1; height++) {
            visited = new boolean[N][N];
            int temp_cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c] && matrix[r][c] > height) {
                        visited[r][c] = true;
                        int lets_see = safe_area_cnt(r, c, height);
                        temp_cnt++;
                    }
                }
            }
            if (temp_cnt > max_cnt) max_cnt = temp_cnt;
        }
        System.out.println(max_cnt);
    }




    public static int safe_area_cnt(int r, int c, int height) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {r, c});

        int cnt = 1;
        while (!stack.isEmpty()) {
            int[] cur_pos = stack.pop();
            int cur_r = cur_pos[0];
            int cur_c = cur_pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = cur_r + dr[d];
                int nc = cur_c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visited[nr][nc] && matrix[nr][nc] > height) {
                        stack.push(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


}