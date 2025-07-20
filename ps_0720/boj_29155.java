package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_29155_개발자지망생구름이의취업뽀개기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] p1_p2_p3_p4_p5 = br.readLine().split(" ");
		int p1 = Integer.parseInt(p1_p2_p3_p4_p5[0]);
		int p2 = Integer.parseInt(p1_p2_p3_p4_p5[1]);
		int p3 = Integer.parseInt(p1_p2_p3_p4_p5[2]);
		int p4 = Integer.parseInt(p1_p2_p3_p4_p5[3]);
		int p5 = Integer.parseInt(p1_p2_p3_p4_p5[4]);
		
		int[][] coding_test = new int[6][301];
		for (int i = 0; i < N; i++) {
			String[] level_time = br.readLine().split(" ");
			int level = Integer.parseInt(level_time[0]);
			int time = Integer.parseInt(level_time[1]);
			coding_test[level][time]++;
		}
		
		int res = min_time_searching(p1, p2, p3, p4, p5, coding_test);
		System.out.println(res);		
	}
	
	
	public static int min_time_searching(int p1, int p2, int p3, int p4, int p5, int[][] arr) {
		int sum = 0;
		int[] p = {0, p1, p2, p3, p4, p5};
		int[] stop = new int[6];
		
		for (int i = 1; i < 6; i++) {
			int j = 1;
			int prev_j = -1;
			int cur_j = j;
			while (j < 301 && stop[i] < p[i]) {
				if (arr[i][j] > 0) {
					arr[i][j]--;
					stop[i]++;
					sum += j;
				
					if (prev_j != -1) {
						int dif = (cur_j - prev_j);
						sum += dif;
					}
					prev_j = cur_j;
					
				}
				else {
					j++;
					cur_j = j;
				}
				
				
				
			}
			
			if (i < 5 && stop[i] == p[i]) {
				sum += 60;
			}
			
		}
		
		return sum;
	}
	
}