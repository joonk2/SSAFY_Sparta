package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_12847_꿀아르바이트 {
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
        int[] int_arr = new int[n];
        for (int i = 0; i < n; i++) {
            int_arr[i] = Integer.parseInt(arr[i]);
        }

        long max_profit = Long.MIN_VALUE;
        long temp_sum = 0;
        for (int start = 0; start < n; start++) {
            temp_sum += int_arr[start];
            if (start >= m-1) {
                if (temp_sum > max_profit) {
                    max_profit = temp_sum;
                }
                temp_sum -= int_arr[start - (m-1)];
            }
        }
        return max_profit;
    }




}