package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		int[] box = new int[N];
		for (int i = 0; i < N; i++) {
			box[i] = Integer.parseInt(br.readLine());
		}
		
		int res = min_change_cnt(K, box);
		System.out.println(res);
	}
	
	
	
	public static int min_change_cnt(int K, int[] box) {
		
		// bubble Sort (desc)
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box.length-1-i; j++) {
				if (box[j] < box[j+1]) {
					int temp = box[j];
					box[j] = box[j+1];
					box[j+1] = temp; 
				}
			}
		}
		int cnt = 0;
		for (int i : box) {
			if (K / i > 0) {
				cnt += (K / i);
				K %= i;
			}
		}
		return cnt;
	}
	
	
	
}