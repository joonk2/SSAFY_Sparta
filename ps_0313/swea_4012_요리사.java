package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.Arrays;

public class swea_4012_요리사 {
	static boolean[] visited;
	static int[][] matrix;
	static int N, min_diff; 
	
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
			
			visited = new boolean[N];
			min_diff = Integer.MAX_VALUE;;
			dfs(0,0);
			System.out.println("#" + tc + " " + min_diff);
			
//			System.out.println(Arrays.deepToString(matrix));
			
			
			
		}
			
			
			
		
	}
	
	
	// calculating Synergy
	public static void calculateSynergy() {
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (visited[i] && visited[j]) {
					sumA += (matrix[i][j] + matrix[j][i]);
				}
				else if (!visited[i] && !visited[j]) {
					sumB += (matrix[i][j] + matrix[j][i]);
				}
				
				
			}
			
		}
		min_diff = Math.min(min_diff, Math.abs(sumA - sumB));
		
		
		
		
	}
	
	
	
	
	
	
	
	
	// dfs
	static void dfs(int idx, int cnt) {
		if (cnt == (N/2)) {
			calculateSynergy();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i+1, cnt+1);
				
				// 백트랙킹 (원상 복구)
				visited[i] = false;
			}
		}
		
		
		
		
	}
	
	
	
	
	
}