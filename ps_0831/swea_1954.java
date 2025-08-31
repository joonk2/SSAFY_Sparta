package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class swea_1954_달팽이숫자 {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int start = 1;

            int r = 0;
            int c = 0;
            int d = 0;

            matrix[r][c] = start;
            start++;

            while (start <= N*N) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && matrix[nr][nc] == 0) {
                    matrix[nr][nc] = start;
                    start++;
                    r = nr;
                    c = nc;
                }
                else {
                    d = (d+1) % 4;
                }
            }


            // res
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    if (j < N-1) {
                        sb.append(matrix[i][j] + " ");
                    }
                    else sb.append(matrix[i][j]);
                }
                System.out.println(sb.toString());
            }

        }

    }
}