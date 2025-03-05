/*
3
3 17 1 39 8 41 2 32 99 2
22 8 5 123 7 2 63 7 3 46
6 63 2 3 58 76 21 33 8 1    
*/
package swea_2025_03_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class swea_2072_홀수만더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        // tc 갯수
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc < T+1; tc++) {
            // 배열 교체  -->    String[] -> int[] 
            String[] arr = br.readLine().split(" ");
            int[] lst = new int[arr.length];
             
            // 홀수 값을 바로 sum에 더하자
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                lst[i] = Integer.parseInt(arr[i]);
                if ( (lst[i] % 2) == 1) {
                    sum += lst[i];
                }
            }
             
            System.out.println("#" + tc + " " + sum);
        }
         
         
         
    }
}
