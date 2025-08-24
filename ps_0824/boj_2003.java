// two pointer

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        String[] arr = br.readLine().split(" ");

        int res = number_of_cases(NM, arr);
        System.out.println(res);
    }



    public static int number_of_cases(String[] NM, String[] arr) {
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] box = new int[N];
        for (int i = 0; i < box.length; i++) {
            box[i] = Integer.parseInt(arr[i]);
        }

        int cnt = 0;
        int start = 0;
        int end = 0;
        int temp_sum = 0;
        while (true) {
            if (temp_sum >= M) {
                if (temp_sum == M) {
                    cnt++;
                }
                temp_sum -= box[start];
                start++;
            }
            else {
                if (end == N) break;
                temp_sum += box[end];
                end++;
            }
        }
        return cnt;
    }



}