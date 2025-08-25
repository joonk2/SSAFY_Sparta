package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_1026_보물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] A_lst = br.readLine().split(" ");
		String[] B_lst = br.readLine().split(" ");
		int res = find_min_val(N, A_lst, B_lst);
		System.out.println(res);
	}
	
	
	
	
	public static int find_min_val(int N, String[] A_lst, String[] B_lst) {
		int answer = 0;
		
		int[] A_arr = new int[N];
		int[] B_arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			A_arr[i] = Integer.parseInt(A_lst[i]);
		}
		for (int i = 0; i < N; i++) {
			B_arr[i] = Integer.parseInt(B_lst[i]);
		}
		
		
		// BubbleSort (asc)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				if (A_arr[j] > A_arr[j+1]) {
					int temp = A_arr[j+1];
					A_arr[j+1] = A_arr[j];
					A_arr[j] = temp;
				}
			}
		}
		
		// BubbleSort (desc)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				if (B_arr[j] < B_arr[j+1]) {
					int temp = B_arr[j];
					B_arr[j] = B_arr[j+1];
					B_arr[j+1] = temp;
				}
			}
		}

		// answer
		for (int i = 0; i < N; i++) {
			answer += (A_arr[i] * B_arr[i]);
		}

		return answer;
	}
	
}