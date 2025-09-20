import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        answer = what_is_max_profit(k, m, score);
        return answer;
    }


    static int what_is_max_profit(int k, int m, int[] score) {
        int T = score.length / m;
        int res = 0;
        int N = score.length-1;
        int min_idx = N-m+1;
        while (T > 0) {
            res += (score[min_idx] * m);
            N -= m;
            min_idx -= m;
            T--;
        }
        return res;
    }


}
