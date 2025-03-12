/*
[이 문제에서 했던 실수]
- 행순회
- 열 순회 
 
각각의 2중 반복문을 작성할때 범위 작성 실수를 해서 test case 4/10만 맞았었다.
열 순회 부분에서 범위를 y < N으로 둔 탓이었다. 
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
//import java.util.Arrays;
 
public class swea_9489_고대유적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc < T+1; tc++) {
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
             
            int[][] matrix = new int[N][M];
            for (int y = 0; y < N; y++) {
                String[] col = br.readLine().split(" ");
                for (int x = 0; x < M; x++) {
                    matrix[y][x] = Integer.parseInt(col[x]);
                }
            }
            
            
            // max_leng
            int max_leng = 0;
            
            // priority check based on row
            // 범위 확인 잘 할것!
            for (int y = 0; y < N; y++) {
                int temp_leng_row = 0;
                for (int x = 0; x < M; x++) {
                	int temp_r = matrix[y][x];
                	
                	
                	// row
                	if (temp_r != 0) {
                		temp_leng_row++;
                		max_leng = Math.max(temp_leng_row, max_leng);
                	}
                	else {
                		temp_leng_row = 0;
                	}
    	
                }
            }
            
            
            // priority check based on col
            // 범위 확인 잘 할것!
            for (int y = 0; y < M; y++) {
            	int temp_leng_col = 0;
            	for (int x = 0; x < N; x++) {
            		int temp_c = matrix[x][y];
            		
            		if (temp_c != 0) {
            			temp_leng_col++;
            			max_leng = Math.max(temp_leng_col, max_leng);
            		}
            		else {
            			temp_leng_col = 0;
            		}
            		
            	}
            }
            
            
            
            
                 
     
             
             
             
            System.out.println("#" + tc + " " + max_leng);
             
             
             
//          System.out.println(Arrays.deepToString(matrix));

            
            
            
            
            
        }
             
             
         
         
    }
}
