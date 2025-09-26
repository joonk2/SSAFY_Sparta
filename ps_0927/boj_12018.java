import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] N_mileage = br.readLine().split(" ");
		int N = Integer.parseInt(N_mileage[0]);
		int mileage = Integer.parseInt(N_mileage[1]);
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			String[] P_L = br.readLine().split(" ");
			String[] score_arr = br.readLine().split(" ");
			int P = Integer.parseInt(P_L[0]);
			int L = Integer.parseInt(P_L[1]);
			int[] score = new int[P];
			for (int j = 0; j < P; j++) {
				score[j] = Integer.parseInt(score_arr[j]);
			}
			Arrays.sort(score);
			
			if (P >= L) {
				arr[i] = score[P-L];
			}
			else if (P < L) {
				arr[i] = 1;
			}
		}
		Arrays.sort(arr);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (mileage - arr[i] >= 0) {
				mileage -= arr[i];
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}