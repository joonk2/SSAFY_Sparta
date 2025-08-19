package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class boj_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] box = new int[N];
		int temp_idx = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				box[temp_idx] = num;
				temp_idx++;
			}
			else if (num == 0) {
				box[temp_idx-1] = 0;
				--temp_idx;
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += box[i];
		}
		System.out.println(sum);
	}
}