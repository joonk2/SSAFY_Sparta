/*
해당문제는 java로 풀면 1초라서 1억 연산 이내가 되야한다.
나는 두번째에 성공했는데, 첫번째에서는 2중 for문을 사용했어서 최악의 연산시간은 다음과 같았다
100,000 + 1 + (99,999) + (100,000 * 1000) 
1억이 넘기에 당연히 시간초과했다.

2번째에서는 O(N+M) 이 되도록 조정했다.
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_11659_구간합구하기4 {
	static int N, M;
	static String[] arr;
	static int[] A, S;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		arr = br.readLine().split(" ");
		A = new int[N];
		S = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(arr[i]);
		}
		
		// prefix_sum
		S[0] = A[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];
		}
		
		// res
		for (int i = 0; i < M; i++) {
			String[] start_end = br.readLine().split(" ");
			int start = Integer.parseInt(start_end[0]);
			int end = Integer.parseInt(start_end[1]);
			start = start-1;
			if (start - 1 < 0) {
				System.out.println(S[end-1]);
			}
			else if (start -1 >= 0) {
				System.out.println(S[end-1] - S[start-1]);
			}
			
		}
		
		
		
	}
}