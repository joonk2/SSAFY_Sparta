/*
programmers_택배상자꺼내기

조심할 점
- 아래에서 무조건 (왼 -> 오) 방향으로 가게 하려면 행의 갯수가 홀짝 상관없이 되도록 해야함
- 엣지케이스를 생각하자. n보다 크면 이제 0 으로 채워지는데 나중에 갯수를 셀때 0은 세면 안된다
*/


package programmers;


class Solution {
    public static int solution(int n, int w, int num) {
        int row = (int) Math.ceil( (double) n/w );
        int start = 1;
        int r = row-1;
        int[][] matrix = new int[row][w];

        while (start <= n) {
            if ( (row-1 - r) % 2 == 0 ) {
                for (int c = 0; c < w; c++) {
                    if (start > n) break;
                    matrix[r][c] = start;
                    start++;
                }
            }
            else if ( (row-1 - r) % 2 == 1 ) {
                for (int c = w-1; c >= 0; c--) {
                    if (start > n) break;
                    matrix[r][c] = start;
                    start++;
                }
            }
            r--;
        }


        int required_cnt = 0;
        for (int j = 0; j < w; j++) {
            int temp_cnt = 0;
            for (int i = 0; i < row; i++) {
                int temp_val = matrix[i][j];
                if (temp_val > 0) temp_cnt++;
                if (temp_val == num) {
                    required_cnt = temp_cnt;
                    break;
                }
            }
            if (required_cnt > 0) break;
        }
        return required_cnt;
    }
}