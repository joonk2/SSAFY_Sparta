package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_12847_꿀아르바이트_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        String[] arr = br.readLine().split(" ");
        long res = what_is_max_profit(nm, arr);
        System.out.println(res);
    }


    public static long what_is_max_profit(String[] nm, String[] arr) {
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] wage_lst = new int[n];
        for (int i = 0; i < n; i++) {
            wage_lst[i] = Integer.parseInt(arr[i]);
        }

        long max_profit = Long.MIN_VALUE;
        long temp_sum = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            temp_sum += wage_lst[end];
            if (end-start + 1 == m) {
                if (temp_sum > max_profit) max_profit = temp_sum;
                temp_sum -= wage_lst[start];
                start++;
            }
            end++;
        }
        return max_profit;
    }




}