/*
현재 순회중인 좌표를 temp_sum에 더한 상태로 N*M 횟수만큼 탐색 시작
모양에 해당하는 인접블록을 3개 더하며 최댓값을 갱신
*/

package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_14500_테트로미노_v2 {
    static int N, M;
    static int[][] matrix;

    static int[][][] tetrominos = {
            // L
            { {0,-1}, {-1,0}, {-2,0} },
            { {0,1}, {-1,0}, {-2,0} },
            { {0,1}, {1,0}, {2,0} },
            { {0,-1}, {1,0}, {2,0} },

            // ㄱ
            { {0,1}, {0,2}, {1,0} },
            { {-1,0}, {0,1}, {0,2} },
            { {1,0}, {0,-1}, {0,-2} },
            { {-1,0}, {0,-1}, {0,-2} },

            // ㅡ
            { {0,1}, {0,2}, {0,3} },

            // ㅣ
            { {1,0}, {2,0}, {3,0} },

            // ㅁ
            { {0,1}, {1,0}, {1,1} },

            // 번개
            { {0,-1}, {-1,-1}, {-1,-2} },
            { {0,1}, {-1,1}, {-1,2} },
            { {1,0}, {1,-1}, {2,-1} },
            { {1,0}, {1,1}, {2,1} },

            // ㅜ
            { {0,-1}, {0,-2}, {-1,-1} },
            { {-1,0}, {-2,0}, {-1,1} },
            { {0,1}, {0,2}, {1,1} },
            { {1,0}, {2,0}, {1,-1} },
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
        max_sum();
    }




    public static void max_sum() {
        int max_val = Integer.MIN_VALUE;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int temp_val = check(r, c);
                if (temp_val > max_val) max_val = temp_val;
            }
        }
        System.out.println(max_val);
    }


    public static int check(int r, int c) {
        int max_sum = matrix[r][c];
        for (int[][] shape : tetrominos) {
            int temp_val = matrix[r][c];
            for (int[] pos : shape) {
                int dr = pos[0];
                int dc = pos[1];
                int nr = dr + r;
                int nc = dc + c;
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    temp_val += matrix[nr][nc];
                }
                else {
                    break;
                }
            }
            if (temp_val > max_sum) max_sum = temp_val;
        }
        return max_sum;
    }


}