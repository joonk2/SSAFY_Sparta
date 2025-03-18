/*
[idea]
이 문제는 행 A,B,C 열 1,2,3 을 적고 각 행과 열이 겹치지 않게
일을 1인당 1개씩 골라주면 된다


1
3
13 0 50
12 70 90
25 60 100 

#1 9.100000
*/

package im;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class Solution {
    static double[][] work;
    static int N;
    static double max_val;
    static boolean[] visited;
    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc < T+1; tc++) {
            N = Integer.parseInt(br.readLine());
            work = new double[N][N];
            visited = new boolean[N];
            
            for (int r = 0; r < N; r++) {
                String[] col = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    work[r][c] = Integer.parseInt(col[c]) / 100.0;
                }
            }
            
            max_val = 0;
            find_max_val(0, 1.0);
            
            sb.append(String.format("#%d %.6f\n", tc, max_val * 100));
            
            
//            System.out.println(Arrays.deepToString(work));
            
            
        }
        System.out.println(sb);
        
        
        
// --------------------Solution--------------------------        
    }    
    
    
    
    
    public static void find_max_val(int row, double prob) {
        // 종료 (모든 직원에게 방 배정 완료시)
        if (row >= N) {
            max_val = Math.max(max_val, prob);
            return;
        }
        
        
        // 현재 확률이 max_Val 보다 낮아질 간으성이 있으면 가지치기
        if (prob <= max_val) {
        	return;
        }
        
        for (int i = 0; i < N; i++) {
        	if (!visited[i]) {
        		visited[i] = true;
        		find_max_val(row + 1, prob * work[row][i]);
        		visited[i] = false;
        	}
        }
        
        
        
        
    }
    
    
    
    
    
}