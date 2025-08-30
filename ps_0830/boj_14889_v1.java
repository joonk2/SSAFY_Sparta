/*
BruteForce && bit_mask
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;


public class boj_14889_스타트와링크_v1 {
    static int N;
    static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int r = 0; r < N; r++) {
            String[] cols = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                S[r][c] = Integer.parseInt(cols[c]);
            }
        }
        find_min_diff();
    }


    static void find_min_diff() {
        int min_diff = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1<<N); mask++) {
            if (Integer.bitCount(mask) == N/2) {
                List<Integer> start = new ArrayList<>();
                List<Integer> link = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    if ( (mask & (1<<i)) != 0 ) {
                        start.add(i);
                    }
                    else link.add(i);
                }
                min_diff = Math.min(min_diff, diff(start, link));
            }
        }
        System.out.println(min_diff);
    }




    static int diff(List<Integer> start, List<Integer> link) {
        int res = 0;
        int start_sum = 0;
        int link_sum = 0;

        for (int i : start) {
            for (int j : start) {
                start_sum += S[i][j];
            }
        }

        for (int i : link) {
            for (int j : link) {
                link_sum += S[i][j];
            }
        }

        res = Math.abs(start_sum - link_sum);
        return res;
    }




}