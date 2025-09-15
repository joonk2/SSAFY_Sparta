package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class boj_11660_구간합구하기5 {
	static int N, M;
	static int[][] A, S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		A = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(cols[c]);
			}
		}
		

		// prefix_sum
		S = new int[N][N];
		for (int r = 0; r < N; r++) {
			S[r][0] = A[r][0];
			for (int c = 1; c < N; c++) {
				S[r][c] = S[r][c-1] + A[r][c];
			}
		}
		

		
		for (int i = 0; i < M; i++) {
			String[] x1_y1_x2_y2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(x1_y1_x2_y2[0]);
			int y1 = Integer.parseInt(x1_y1_x2_y2[1]);
			int x2 = Integer.parseInt(x1_y1_x2_y2[2]);
			int y2 = Integer.parseInt(x1_y1_x2_y2[3]);
			x1 = x1-1;
			y1 = y1-1;
			x2 = x2-1;
			y2 = y2-1;
			
			int sum = 0;
			if (y1-1 < 0) {
				for (int j = x1; j < x2 + 1 ; j++) {
					sum += S[j][y2];
				}
			}
			else if (y1-1 >= 0) {
				for (int j = x1; j < x2 + 1; j++) {
					sum += (S[j][y2] - S[j][y1-1]);
				}
			}
			System.out.println(sum);
		}
		
		
		
		
		
		
		
	}
}