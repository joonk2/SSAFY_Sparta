import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[times.length-1]*n;
        long res = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (higher_than_n(mid, times, n)) {
                res = mid;
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return res;
    }
    
    
    static boolean higher_than_n(long mid, int[] times, int n) {
        long cnt = 0;
        for (int i = 0; i < times.length; i++) {
            cnt += (mid / times[i]);
        }
        if (cnt >= n) {
            return true;
        }
        
        return false;
    }
    
}