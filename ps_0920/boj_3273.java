/*
쌍의 갯수를 구해야하는데 불연속이다

1초 -> java 기준 1억 연산 이내
1 <= n <= 100000
그래서 BruteForce는 절대로 안 된 다
왜 why? --> 최악의 연산횟수가 (n*(n-1))/2 라서
만약 겹치는 쌍이었으면 더 심했다 n^2이다

그렇다면 불연속으로 쌍의 갯수를 구하는 거니 Two_Pointer가 있겠네
Two pointer의 경우 불연속이라면 ★정렬★이 필수다

그렇다면 최악의 연산횟수를 계산해보자
Arrays.sort(arr) -> N Log_{2}^{N} -> 100000 * 약 20

two_pointer -> O(N) -> 100,000

도합 최악의 연산횟수는 2,000,000 + 100,000
그러면 충분히 시간안에 통과가 되겠다
그러므로 Two_Pointer를 사용한다.
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	static int N;
	static String[] s_arr;
	static int[] arr;
	static int x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s_arr = br.readLine().split(" ");
		x = Integer.parseInt(br.readLine());
		
		pair_cnt();
	}
	
	
	static void pair_cnt() {
		arr = new int[s_arr.length];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s_arr[i]);
		}
		
		// two pointer (discontinuity)
		Arrays.sort(arr);
		
		int s = 0;
		int e = N-1;
		int cnt = 0;
		while (s < e) {
			if (arr[s] + arr[e] == x) {
				cnt++;
			}
			

			if (arr[s] + arr[e] <= x) {
				s++;
			}
			else if (arr[s] + arr[e] > x) {
				e--;
			}
			
		}
		System.out.println(cnt);
		
		
	}
	
}
