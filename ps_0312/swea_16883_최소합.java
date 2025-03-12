/*
[입력 값]
3
3
1 2 3
2 3 4
3 4 5
4
2 4 1 3
1 1 7 1
9 1 7 10
5 7 2 4
5
6 7 1 10 2
10 2 7 5 9
9 3 2 9 6
1 6 8 2 9
8 3 8 2 1


[출력 값]
#1 15
#2 18
#3 33
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;


public class Solution {
	static int[][] matrix;
	static int N;
	
	public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      
      for (int tc = 1; tc < T+1; tc++) {
    	  N = Integer.parseInt(br.readLine());
    	  matrix = new int[N][N];
    	  
    	  for (int y = 0; y < N; y++) {
    		  String[] col = br.readLine().split(" ");
    		  for (int x = 0; x < N; x++) {
    			  matrix[y][x] = Integer.parseInt(col[x]);
    		  }
    	  }
    	  
    	  int res = find_MinVal(0,0);
    	  System.out.println("#" + tc + " " + res);
    	  
    	  
    	  
      }
      
	  
      
	  
	  
  }

  
	
	public static int find_MinVal(int y, int x) {
		if (y == N-1 && x == N-1) {
			return matrix[y][x];
		}
		
		int right = Integer.MAX_VALUE;
		if (x+1 < N) {
			right = find_MinVal(y, x+1);
		}
		
		
		int down = Integer.MAX_VALUE;
		if (y+1 < N) {
			down = find_MinVal(y+1, x);
		}
		
		return matrix[y][x] + Math.min(right, down);
		
	}
	
	
	
  
}

















def go(s1, s2, num_sum):
    global min_sum
     
    num_sum += matrix[s1][s2]
     
    if s1 == N-1 and s2 == N-1:
        if min_sum > num_sum:
            min_sum = num_sum
        return
     
    if 0 <= s1+1 < N and 0 <= s2 < N:
        go(s1+1, s2, num_sum)
         
    if 0 <= s1 < N and 0 <= s2+1 < N:
        go(s1, s2+1, num_sum)
 
T = int(input())
 
for tc in range(1, T+1):
    N = int(input())
    matrix = [list(map(int, input().split())) for _ in range(N)]
     
    min_sum = float("inf")
     
    go(0, 0, 0)
     
    print(f'#{tc} {min_sum}')