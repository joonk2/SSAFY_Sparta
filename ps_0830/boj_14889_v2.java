/*
DFS && 백트랙킹
*/

package boj;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class boj_14889_스타트와링크_v2 {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int min_diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        for (int r = 0; r < N; r++) {
            String[] cols = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                S[r][c] = Integer.parseInt(cols[c]);
            }
        }
        dfs(0, 0);
        System.out.println(min_diff);
    }


    static void dfs(int idx, int cnt) {
        // 조건에 맞으면 계산
        if (cnt == N/2) {
            check_diff();
            return;
        }

        // 가지치기
        if (idx == N) return;

        // 사람 포함
        selected[idx] = true;
        dfs(idx+1, cnt+1);

        // 사람 미포함
        selected[idx] = false;
        dfs(idx+1, cnt);
    }


    static void check_diff() {
        int start_sum = 0;
        int link_sum = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (selected[r] && selected[c]) {
                    start_sum += S[r][c];
                }
                else if (!selected[r] && !selected[c]) {
                    link_sum += S[r][c];
                }
            }
        }
        min_diff = Math.min(min_diff, Math.abs(start_sum - link_sum));
    }


}