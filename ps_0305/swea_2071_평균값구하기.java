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
 
public class swea_2071_평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        // tc
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc < T+1; tc++) {
             
            // 배열 전환 String[] --> int[]
            String[] arr = br.readLine().split(" ");
            int N = 10;
             
            // 각각의 값을 저장하기 위한 sum
            int sum = 0;
            int[] lst = new int[N];
            for (int i = 0; i < N; i++) {
                lst[i] = Integer.parseInt(arr[i]);
                int temp = lst[i];
                 
                // cond --> 각 수는  0이상, 10000이하의 정수
                // 범위에 맞지 않으면 break
                if (temp < 0 || temp > 10000) {
                    break;
                }
                 
                sum += temp;
                 
            }
             
            // 답
            // 문제에서 소수점을 원하기에 N을 실수형으로 전환
            int res = Math.round( sum / (float)N );
             
            // 그냥 출력하면 24.0인데 이 Math.round 모듈을 통해 정수만 출력
            System.out.println("#" + tc + " " + res);
             
             
        }
         
    }
}