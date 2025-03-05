/*
[코드 개요]
이 문제는 입출력을 잘 읽어보아야 한다.   왜??
--> 2개의 각 수열 길이를  N, M 이라 할때
N > M 그리고 M > N 인 경우가 있기 때문 
 
*/
package swea_2025_03_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
//import java.util.Arrays;
 
public class swea_1959_두개의숫자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        // tc
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            // String[] 배열로  입력을 받아서 나눔
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
             
             
            // String[] A, B 배열 입력
            String[] A_arr = br.readLine().split(" ");
            String[] B_arr = br.readLine().split(" ");
             
            // 각  N, M 크기만큼 int[] A, B 생성  
            int[] A = new int[N];
            int[] B = new int[M];
             
            // int[] A에  N번만큼  A_arr의 값 할당
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(A_arr[i]);
            }
             
            // int[] B에 M번만큼 B_arr의 값 할당
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(B_arr[i]);
            }
             
             
             
            // 값 저장
            int max_sum = 0;
             
             
             
            // N > M 인 경우
            if (N > M) {
                for (int i = 0; i < N-M+1; i++) {
                    int temp_sum = 0;
                    for (int j = 0; j < M; j++) {
                        temp_sum += (A[i+j] * B[j]);
                    }
                     
                    // N > M 일때 최대값 갱신 후 비교
                    if (temp_sum > max_sum) {
                        max_sum = temp_sum;
                    }
                     
                     
                }
            }
             
             
            // M > N 인 경우
            if (M > N) {
                for (int i = 0; i < M-N+1; i++) {
                    int temp_sum = 0;
                    for (int j = 0; j < N; j++) {
                        temp_sum += (A[j] * B[i+j]);
                    }
                     
                    // M > N 일때 최대값 갱신 후 비교
                    if (temp_sum > max_sum) {
                        max_sum = temp_sum;
                    }
                     
                     
                }
            }
                 
             
             
                 
 
             
             
             
            System.out.println("#" + tc + " " + max_sum);
             
             
             
//          // int[] A, B 디버깅
//          System.out.println(Arrays.toString(A));
//          System.out.println(Arrays.toString(B));
             
             
             
             
        }
         
         
    }
}