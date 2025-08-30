/*
BruteForce && bitmasking
*/

package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;


public class swea_4012_요리사_v1 {
    static int T;
    static int N;
    static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T+1; tc++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];

            for (int r = 0; r < N; r++) {
                String[] cols = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    S[r][c] = Integer.parseInt(cols[c]);
                }
            }
            int answer = find_min_diff();
            System.out.println("#" + tc + " " + answer);

        }
    }



    static int find_min_diff() {
        int min_diff = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1<<N); mask++) {
            if (Integer.bitCount(mask) == N/2) {
                List<Integer> food_A = new ArrayList<>();
                List<Integer> food_B = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    if ( (mask & (1<<i) ) != 0 ) {
                        food_A.add(i);
                    }
                    else if ( (mask & (1<<i) ) == 0 ) {
                        food_B.add(i);
                    }
                }
                min_diff = Math.min(min_diff, check_diff(food_A, food_B));
            }
        }
        return min_diff;
    }



    static int check_diff(List<Integer> food_A, List<Integer> food_B) {
        int sum_A = 0;
        int sum_B = 0;

        for (int i : food_A) {
            for (int j : food_A) {
                sum_A += S[i][j];
            }
        }

        for (int i : food_B) {
            for (int j : food_B) {
                sum_B += S[i][j];
            }
        }

        int res = 0;
        res = Math.abs(sum_A - sum_B);
        return res;
    }






}