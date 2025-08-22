package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// DFS (stack)
import java.util.Stack;

// answer
// import java.util.ArrayList;


public class boj_1012_유기농배추_v1 {
    static int T, M, N, K;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T+1; tc++) {
            String[] MNK = br.readLine().split(" ");
            M = Integer.parseInt(MNK[0]);
            N = Integer.parseInt(MNK[1]);
            K = Integer.parseInt(MNK[2]);

            matrix = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                String[] rc = br.readLine().split(" ");
                int c = Integer.parseInt(rc[0]);
                int r = Integer.parseInt(rc[1]);
                matrix[r][c] = 1;
            }
            DFS();
        }
    }




    public static void DFS() {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (matrix[r][c] == 1 && !visited[r][c]) {
                    worm_cnt(r, c);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }





    public static int worm_cnt(int r, int c) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {r, c});
        visited[r][c] = true;
        int cnt = 1;
        while (!stack.isEmpty()) {
            int[] cur_pos = stack.pop();
            int cur_r = cur_pos[0];
            int cur_c = cur_pos[1];

            for (int d = 0; d < 4; d++) {
                int nr = cur_r + dr[d];
                int nc = cur_c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (matrix[nr][nc] == 1 && !visited[nr][nc]) {
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