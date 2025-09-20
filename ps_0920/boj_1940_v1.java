/*
JAVA 2초 --> 2억 연산 횟수 이내 
  
1 <= N <= 15000
2개(불연속)의 아이템을 합쳐 갑옷을 만든다
--> BruteForce 쓰면 시간초과난다

two pointer 쓰자
참고로 이건 정렬상태가 기본이다.
O(N)

최악의 실행시간은 다음과 같겠군
Arrays.sort(N)  N logN  -> 15000 * ~14 (약 210000)
N -> 15000

210000 + 15000번
*/


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
		int s = 0;
		int e = N-1;
		
		while (s < e) {
			if (items[s] + items[e] == M) {
				cnt++;
			}
			
			
			if (items[s] + items[e] < M) {
				s++;
			}
			else if (items[s] + items[e] >= M) {
				e--;
			}
			
			
		}
		System.out.println(cnt);
		
	}
	
	
	
}