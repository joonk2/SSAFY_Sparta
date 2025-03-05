package swea_2025_03_05;


import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.Arrays;

public class swea_1983_조교의성적매기기 {
	static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		// tese case 만큼 반복
		for (int tc = 1; tc < T+1; tc++) {
			// String[] 으로 N, K 입력후 분리
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			
			// 점수를 저장할 실수 double[] 배열 
			double[] score = new double[N];
			
			// N만큼 반복
			for (int i = 0; i < N; i++) {
				// String[] 으로 score_lst 입력받고 분리
				String[] score_lst = br.readLine().split(" ");
				int mid_term = Integer.parseInt(score_lst[0]);
				int final_term = Integer.parseInt(score_lst[1]);
				int assignment = Integer.parseInt(score_lst[2]);
				score[i] = (mid_term * 0.35) + (final_term * 0.45) + (assignment * 0.2);	
			}
			
			
			// 미리 내림차순 정렬 전에 idx랑 score[idx] 만들어 놓음
			int idx = K-1;
			double target = score[idx];
			
			
			
			// BubbleSort (desc)
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					if (score[j] > score[i]) {
						double temp = score[i];
						score[i] = score[j];
						score[j] = temp;
					}
				}
			}
			
			// res
			// 답을 입력받기 위한 빈 String
			String res = "";
			for (int i = 0; i < N; i++) {
				
				// 만약 현재 i값이 target이랑 같다면 몫으로 나누고 값 할당
				if (score[i] == target) {
					res = grade[i / (N/10)];
					break;
				}
			}
			
			
			System.out.println("#" + tc + " " + res);
//			System.out.println(Arrays.toString(score));

			
			
		}
		
		
	}
}
