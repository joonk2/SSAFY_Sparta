/*
이 문제는 K개 이상의 1인형을 포함해 가장 작은 연속된 인형들의 집합 크기를 구하는 문제다
(연속)

1 <= N <= 100000
완전탐색 쓰면 복잡해지고 시간초과도 나니까 
Two_Pointer를 쓰는게 좋겠다

O(N)
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int N, K;
	static int[] dolls;
	static int min_leng = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		String[] arr = br.readLine().split(" ");
		
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		dolls = new int[N];
		for (int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(arr[i]);
		}
		
		the_smallest_set_size();
	}
	
	
	
	
	static void the_smallest_set_size() {
		int s = 0;
		int e = 0;
		int cnt = 0;
		while (e <= N) {
			if (cnt < K) {
				// 종료조건
				if (e == N) break;
				
				if (dolls[e] == 1) {
					cnt++;
				}
				e++;
			}
			else if (cnt >= K) {
				int cur_leng = e-s;
				min_leng = Math.min(min_leng, cur_leng);
				if (dolls[s] == 1) {
					cnt--;
				}
				s++;
			}
			
			
		}
		if (min_leng < Integer.MAX_VALUE) {
			System.out.println(min_leng);
		}
		else if (min_leng >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		
		
	}
	
	
}