package swea_2025_03_07;

/*
[아이디어]
- int[] stone 배열을 만들어 값 변경 진행

[코드 요약] 
- 기준값을 temp로 설정해, 바꿀 구간의 값들을 전부 temp로 변경
- 만약 현재 배회중인 요소랑 stone이라는 lst-1이랑 같다면 종료, 왜냐하면 범위를 벗어나면 안되기 때문

*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
/*
[후기]
- BufferedReader
- IOException
- InputStreamReader
- split(" ")
- StringTokenizer
- StringBuilder
 
 
사용 불가능했음
 
그 대신에 표준 입출력인 Scanner 사용 권장
 
*/
 
import java.util.Scanner;
//import java.util.Arrays;
 
public class Solution {
  public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
       
      for (int tc = 1; tc < T+1; tc++) {
          int N = sc.nextInt();
          int M = sc.nextInt();
           
          int[] stone_lst = new int[N];
          for (int i = 0; i < N; i++) {
              stone_lst[i] = sc.nextInt();
          }
           
           
          for (int k = 0; k < M; k++) {
              int i = sc.nextInt();
              int j = sc.nextInt();
               
               
              int startIdx = i-1;
              int x = 1;
               
              
              // x가 탐색을 할때,앞영에 lstIdx, RightIdx 사용하여 조건문에서 실행되는 동안 lr_idx == rl_idx ++==
              
              
              while (x <= j) {            
                  int leftIdx = startIdx - x;
                  int rightIdx = startIdx + x;
                   
                  
                  // 범위를 넘어가면 종료
                  
                  if (leftIdx < 0 || rightIdx > N-1) {
                      break;
                  }
                   
                  if (stone_lst[leftIdx] == stone_lst[rightIdx]) {
                      stone_lst[leftIdx] = 1 - stone_lst[leftIdx];
                      stone_lst[rightIdx] = 1 - stone_lst[rightIdx];
                  }
                   
                  x++;
              }
                   
          }
           
          System.out.print("#" + tc + " ");
           
          for (int i : stone_lst) {
              System.out.print(i + " ");
          }
          System.out.println();
//          System.out.println(Arrays.toString(stone_lst));
           
           
      }
       
       
       
       
  }
}
