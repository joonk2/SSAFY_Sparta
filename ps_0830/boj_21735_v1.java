/*
백트랙킹
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class boj_21735_눈덩이굴리기_v1 {
    static int N, M;
    static int max_size = Integer.MIN_VALUE;
    static int[] snowball_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        snowball_arr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            snowball_arr[i] = Integer.parseInt(arr[i-1]);
        }

        dfs(0, 0, 1);
        System.out.println(max_size);
    }



    static void dfs(int idx, int time, int cur_size) {

        // 최대 시간 or 최대 깊이 도달시 --> 최대 크기 갱신하고 종료
        if (time == M || idx == N+1) {
            max_size = Math.max(max_size, cur_size);
            return;
        }

        // 눈덩이 최대크기 상시 갱신
        max_size = Math.max(max_size, cur_size);

        // 1칸 굴리기
        if (idx + 1 < N+1) {
            dfs(idx+1, time+1, cur_size + snowball_arr[idx+1]);
        }

        // 2칸 굴리기
        if (idx + 2 < N+1) {
            dfs(idx+2, time+1, (cur_size / 2) + snowball_arr[idx+2]);
        }

    }



}