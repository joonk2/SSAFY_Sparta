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
 
 
[아이디어]
양쪽 동전 값을 체크하기 위함으로 만약 비교할 게 없다면 기존 찾아보단 idx++; 

*/
package swea_2025_03_07;

Problem제출이력정답
코드 보기
 고준환_1351493
제출일 : 2025-03-07 20:45
JAVA
언어
26,880 kb
메모리
105 ms
실행시간
1,796
코드길이
Pass
결과
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
*
[후기]
- BufferedReader
- IOException
- InputStreamReader
- split(" ")

 
 
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
               
               // satrtIDx, summer_pd R
              int startIdx = i-1;
              int x = 1;
               
              while (x <= j) {            
                  int leftIdx = startIdx - x;
                  int rightIdx = startIdx + x;
                   
                
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
