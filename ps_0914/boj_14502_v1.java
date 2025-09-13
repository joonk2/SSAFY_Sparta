/*
3 <= N, M <= 8
2 <= virus <= 10
wall >= 3

입력으로 최악의 실행시간은 다음과 같겠다
8 8
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0


위 좌표중 안전지역인 0들을 empty_area 라는 ArrayList에 넣으면 다음과 같겠다

{
	{0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {0,6},
	{1,0}, {1,1}, {1,2}, {1,3}, {1,4}, {1,5}, {1,6}, {1,7},
	{2,0}, {2,1}, {2,2}, {2,3}, {2,4}, {2,5}, {2,6}, {2,7},
	{3,0}, {3,1}, {3,2}, {3,3}, {3,4}, {3,5}, {3,6}, {3,7},
	{4,0}, {4,1}, {4,2}, {4,3}, {4,4}, {4,5}, {4,6}, {4,7},
	{5,0}, {5,1}, {5,2}, {5,3}, {5,4}, {5,5}, {5,6}, {5,7},
	{6,0}, {6,1}, {6,2}, {6,3}, {6,4}, {6,5}, {6,6}, {6,7},
	{7,0}, {7,1}, {7,2}, {7,3}, {7,4}, {7,5}, {7,6}, {7,7},
}

2초 이내라 2억 번의 연산까지 괜찮기에 0을 리스트에 넣고 완전탐색으로 돌리면
62 * 61 * 60 * 4
이건 2억 이내에 가능하다
*/



package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;



public class boj_14502_연구소_v1 {
	static int N, M;
	static int[][] matrix;
	static int[][] test_matrix;
	static boolean[][] visited;
	static int max_safe_area = Integer.MIN_VALUE;
	static List<int[]> empty_area;
	static List<int[]> virus;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		matrix = new int[N][M];
		empty_area = new ArrayList<>();
		virus = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
				if (matrix[r][c] == 0) empty_area.add(new int[] {r, c});
				if (matrix[r][c] == 2) virus.add(new int[] {r, c});
			}
		}
		what_is_the_maximum_cnt();
	}
	

	
	
	
	
	static void what_is_the_maximum_cnt() {
		for (int i = 0; i < empty_area.size()-2; i++) {
			for (int j = i+1; j < empty_area.size()-1; j++) {
				for (int k = j+1; k < empty_area.size(); k++) {
					
					// clone
					test_matrix = new int[N][M];
					for (int r = 0; r < N; r++) {
						test_matrix[r] = matrix[r].clone();
					}
					
					// wall
					test_matrix[empty_area.get(i)[0]][empty_area.get(i)[1]] = 1;
					test_matrix[empty_area.get(j)[0]][empty_area.get(j)[1]] = 1;
					test_matrix[empty_area.get(k)[0]][empty_area.get(k)[1]] = 1;
					
					// virus_spread
					virus_spread();
					
					// counting_safe_area
					counting_safe_area();
				}
			}
		}
		System.out.println(max_safe_area);
	}

	
	

	
	static void virus_spread() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M];
		for (int[] v : virus) {
			int virus_r = v[0];
			int virus_c = v[1];
			q.add(new int[] {virus_r, virus_c});
			visited[virus_r][virus_c] = true;
			
			while (!q.isEmpty()) {
				int[] cur_pos = q.poll();
				int cur_r = cur_pos[0];
				int cur_c = cur_pos[1];
				for (int d = 0; d < 4; d++) {
					int nr = cur_r + dr[d];
					int nc = cur_c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (!visited[nr][nc] && test_matrix[nr][nc] == 0) {
							test_matrix[nr][nc] = 2;
							q.add(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	
	
	

	
	
	static void counting_safe_area() {
		int temp_cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M ;c++) {
				int cur_val = test_matrix[r][c];
				if (cur_val == 0) temp_cnt++;
			}
		}
		max_safe_area = Math.max(temp_cnt, max_safe_area);
	}
	
	
	
}