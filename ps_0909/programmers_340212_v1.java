class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        answer = binary_search(diffs, times, limit);
        return answer;
    }
    
    static int binary_search(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        int N = diffs.length;
        int res = 0;
        for (int i : diffs) {
            if (i > max) max = i;
        }
        
        while (min <= max) {
            int level = (min + max) / 2;
            long total_sum = 0;
            long temp_sum = 0;
            for (int i = 0; i < N; i++) {
                if (diffs[i] > level) {
                    int wrong_cnt = (diffs[i] - level);
                    if (i > 0) {
                        temp_sum = (times[i-1] + times[i]) * wrong_cnt + times[i];
                    }
                    else if (i <= 0) {
                        temp_sum = times[i] * (wrong_cnt + 1);
                    }
                }
                else if (diffs[i] <= level) {
                    temp_sum = times[i];
                }
                total_sum += temp_sum;
                
                // 가지치기
                if (total_sum > limit) break;
            }
            
            if (total_sum <= limit) {
                res = level;
                max = level - 1;
            }
            else if (total_sum > limit) {
                min = level +1;
            } 
        
        }
        return res;
    }
    
    
}