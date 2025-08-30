/*
DFS && back_tracking
*/

package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class swea_4012_요리사_v2 {
    static int T;
    static int N;
    static int[][] S;
    static boolean[] checked;
    static int min_diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            checked = new boolean[N];
            min_diff = Integer.MAX_VALUE;

            for (int r = 0; r < N; r++) {
                String[] cols = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    S[r][c] = Integer.parseInt(cols[c]);
                }
            }
            dfs(0, 0);
            System.out.println("#" + tc + " " + min_diff);
        }
    }



    static void dfs(int idx, int cnt) {

        // 조건에 맞으면 계산 진행
        if (cnt == N/2) {
            check_diff();
            return;
        }

        // 최대 깊이 도달시 가지치기
        if (idx == N) return;

        // 음식 포함하고 찾기
        checked[idx] = true;
        dfs(idx+1, cnt+1);

        // 음식 미포함하고 찾기
        checked[idx] = false;
        dfs(idx+1, cnt);
    }



    static void check_diff() {
        int temp_diff = 0;
        int sum_A = 0;
        int sum_B = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (checked[r] && checked[c]) {
                    sum_A += S[r][c];
                }
                else if (!checked[r] && !checked[c]) {
                    sum_B += S[r][c];
                }
            }
        }
        temp_diff = Math.abs(sum_A - sum_B);
        min_diff = Math.min(min_diff, temp_diff);
    }


}