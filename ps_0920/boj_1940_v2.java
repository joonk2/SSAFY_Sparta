/*
2초 이내 --> 2억 연산 이내

아이템을 고르는게 겹치면 안된다.

BruteForce 일때의

총 연산 횟수
Arrays.sort() --> N logN (15000*~14)

N(N-1)/2
(15000*14999)/2

도합 220000 + 약 1억 1천~~)
충분히 통과된다.
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	static int N;
	static int M;
	static int[] items;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		items = new int[N];
		
		for (int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(items);
		
		how_many_armors();
	}
	
	
	static void how_many_armors() {
		int cnt = 0;
		boolean[] visited = new boolean[N];
		for (int r = 0; r < N-1; r++) {
			for (int c = r+1; c < N; c++) {
				if (!visited[r] && !visited[c]) {
					if (items[r] + items[c] == M) {
						cnt++;
						visited[r] = true;
						visited[c] = true;
					}
				}
			}
		}
		
		
		System.out.println(cnt);
		
	}
	
	
	
}