import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tips = new int[N];
		for (int i = 0; i < N; i++) {
			tips[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tips);
		
		long my_money = 0;
		int rank = 1;
		for (int i = N-1; i >= 0; i--) {
			int cur_tips = tips[i];
			long temp_val = (long) cur_tips - (rank - 1);
			rank++;
			if (temp_val < 0) {
				temp_val = 0;
			}
			my_money += temp_val;
		}
		System.out.println(my_money);
	}
}