/*
2초라서 java로 2억번 연산 이내에 해결되야한다.

1 <= N <= 10000000
BruteForce는 불가능하다.

그렇다면 O*N)인 two_pointer는 가능하지 않을까?

최악의 실행시간은
10000000

2000만이라 충분히 2억 연산안에 실행된다.
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_2018_수들의합5 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		case_number();
	}
	
	static void case_number() {
		int cnt = 0;
		int sum = 0;
		int s = 1;
		int e = 1;
		
		while (s <= N) {
			if (sum == N) {
				cnt++;
			}
			
			
			if (sum < N) {
				sum += e;
				e++;
			}
			else if (sum >= N) {
				sum -= s;
				s++;
			}
			
		}
		System.out.println(cnt);
	}
	
	
	
}