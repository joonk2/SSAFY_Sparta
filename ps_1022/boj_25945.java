/*
9
2 2 3 4 7 9 10 20 30
mod = 87/9

결과값
9, 9, 9, 10, 10, 10, 10, 10, 10

이동한 양
7, 7, 6, 6, 3, 1

계산방법 (절반씩 비교하면 이동한 양을 다 채울 수 있다)
(앞 N-remainder까지 -> mod, 나머지 -> mod+1)
9, 9, 9,
		10, 10, 10, 10, 10, 10
*/


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s_arr = br.readLine().split(" ");
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s_arr[i]);
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		what_is_min_movement(N, sum, arr);
	}
	
	
	
	static void what_is_min_movement(int N, int sum, int[] arr) {
		int cnt = 0;
		
		int mod = (sum / N);
		int remainder = (sum % N);
		
		int[] avg = new int[N];
		
		// arr(avg) 
		for (int i = 0; i < N-remainder; i++) {
			avg[i] = mod;
		}
		for (int i = N-remainder; i < N; i++) {
			avg[i] = mod + 1;
		}
		
		// formula
		for (int i = 0; i < N; i++) {
			int temp = avg[i] - arr[i];
			if (temp < 0) {
				temp = 0;
			}
			cnt += temp;
		}
		
		System.out.println(cnt);
		
		
	}
	
	
}