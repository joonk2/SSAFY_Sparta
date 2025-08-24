package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            String[] cols = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(cols[c]);
            }
        }

        int[] lst = new int[N*N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                lst[(r%N)*N + c] = map[r][c];
            }
        }
        Arrays.sort(lst);
        System.out.println(lst[((N*N)-1) - (N-1)]);


    }

}