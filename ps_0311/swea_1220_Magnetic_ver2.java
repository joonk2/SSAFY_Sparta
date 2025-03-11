/*
[아이디어]
- 열 우선순회
- 위에서 아래를 검사하는 것
- 아래에서 위로 검사하는 것

[코드 개요]
매상태마다 이전에 이동이 있었는지 확인하기 위해 while문을 시작할 때마다 moved = false로 초기화
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class swea_1220_Magnetic_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
         
        for (int tc = 1; tc < T+1; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
             
            for (int y = 0; y < N; y++) {
                String[] col = br.readLine().split(" ");
                for (int x = 0; x < N; x++) {
                    arr[y][x] = Integer.parseInt(col[x]);
                }
            }
             
            
            
            
            
            
            
            
             
            boolean moved = true;
            while (moved == true) {
              // 기본적으로 false로 초기화 (매상태마다 이전에 이동이 있었는지 확인하기 위해)
            	moved = false;
            	
            	
            	// N극 (1) 이동 (위 --> 아래)
            	// 내가 책상을 위에서 아래로 내려다보고 있을 때의 모양
            	for (int i = N-2; i >= 0; i--) {
            		for (int j = 0; j < N; j++) {
            			if (arr[i][j] == 1 && arr[i+1][j] == 0) {
            				arr[i+1][j] = 1;
            				arr[i][j] = 0;
            				moved = true;
            			}
            		}
             	}
            	
            	
            	
            	// S극(2) 이동 (아래 -> 위로)
            	for (int i = 1; i < N; i++) {
            		for (int j = 0; j < N; j++) {
            			if (arr[i][j] == 2 && arr[i-1][j] == 0) {
            				arr[i-1][j] = 2;
            				arr[i][j] = 0;
            				moved = true;
            			}
            		}
            	}
            		
            		
            		
            	
            }
            
            
            
            
            // 교착상태 계산
            int cnt = 0;
            for (int i = 0; i < N-1; i++) {
            	for (int j = 0; j < N; j++) {
            		if (arr[i][j] == 1 && arr[i+1][j] == 2) {
            			cnt++;
            		}
            	}
            }
            
            
            // res 
            System.out.println("#" + tc + " " + cnt);
            
            
             
            // 디버깅
//          System.out.println(Arrays.deepToString(matrix));
             
            // res
//            System.out.println("#" + tc + " " + cnt);
             
             
         
        }
         
         
         
         
    }
}
