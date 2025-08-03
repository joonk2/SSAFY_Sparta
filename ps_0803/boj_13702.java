package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class boj_13702_이상한술집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[] beers = new int[N];
		for (int i = 0; i < N; i++) {
			beers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(beers);
		
		long res = parametric_search(K, beers);
		System.out.print(res);
		
		
	}
	
	
	public static long parametric_search(int K, int[] beers) {
		long answer = 0;
		long left = 1;
		long right = beers[beers.length-1];
		
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for (int i : beers) {
				cnt += (i / mid);
			}
			
			if (cnt >= K) {
				answer = mid;
				left = mid + 1;
			}
			else if (cnt < K) {
				right = mid - 1;
			}
			
			
		}
		
		return answer;
		
	}
	
	
}