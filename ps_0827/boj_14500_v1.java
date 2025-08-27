/*
모양에 해당하는 인접블록을 4개 더하며 최댓값을 갱신
*/

package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_14500_테트로미노_v1 {
    static int N, M;
    static int[][] matrix;

    static int[][][] tetrominos = {
            // L
            { {0,0}, {0,-1}, {-1,0}, {-2,0} },
            { {0,0}, {0,1}, {-1,0}, {-2,0} },
            { {0,0}, {0,1}, {1,0}, {2,0} },
            { {0,0}, {0,-1}, {1,0}, {2,0} },

            // ㄱ
            { {0,0}, {0,1}, {0,2}, {1,0} },
            { {0,0}, {-1,0}, {0,1}, {0,2} },
            { {0,0}, {1,0}, {0,-1}, {0,-2} },
            { {0,0}, {-1,0}, {0,-1}, {0,-2} },

            // ㅡ
            { {0,0}, {0,1}, {0,2}, {0,3} },

            // ㅣ
            { {0,0}, {1,0}, {2,0}, {3,0} },

            // ㅁ
            { {0,0}, {0,1}, {1,0}, {1,1} },

            // 번개
            { {0,0}, {0,-1}, {-1,-1}, {-1,-2} },
            { {0,0}, {0,1}, {-1,1}, {-1,2} },
            { {0,0}, {1,0}, {1,-1}, {2,-1} },
            { {0,0}, {1,0}, {1,1}, {2,1} },

            // ㅜ
            { {0,0}, {0,-1}, {0,-2}, {-1,-1} },
            { {0,0}, {-1,0}, {-2,0}, {-1,1} },
            { {0,0}, {0,1}, {0,2}, {1,1} },
            { {0,0}, {1,0}, {2,0}, {1,-1} },
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        matrix = new int[N][M];
        for (int r = 0; r < N; r++) {
            String[] cols = br.readLine().split(" ");
            for (int c = 0; c < M; c++) {
                matrix[r][c] = Integer.parseInt(cols[c]);
            }
        }

        int res = what_is_max_val(matrix);
        System.out.println(res);
    }


    public static int what_is_max_val(int[][] matrix) {
        int max_val = Integer.MIN_VALUE;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int temp_val = check(r, c);
                if (temp_val > max_val) max_val = temp_val;
            }
        }
        return max_val;
    }



    public static int check(int r, int c) {
        int ans = 0;
        for (int[][] shape : tetrominos) {
            int temp_sum = 0;
            for (int[] pos : shape) {
                int dr = pos[0];
                int dc = pos[1];
                int nr = r + dr;
                int nc = c + dc;

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    temp_sum += matrix[nr][nc];
                }
                else {
                    temp_sum = 0;
                    break;
                }
            }
            if (temp_sum > ans) ans = temp_sum;
        }
        return ans;
    }






}