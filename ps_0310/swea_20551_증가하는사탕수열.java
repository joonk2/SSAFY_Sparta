/*
[아이디어]
- 총 3가지 경우를 가진다.
- 1. 한큐에 오름차순이 완성되었을 때
				// 1 2 3
				 
- 2. 한큐에 오름차순이 불가능 할 때

				// 3 2 1
				// 3 1 2
				// 1 1 3 
				
- 3. 차감을 통해 오름차순을 만들 수 있을 때
				// 3, 2, 3
				// 6, 5, 4
				// 3, 3, 3

[코드 개요]
- 이미 입력값에서 한큐에 조건을 만족하면 continue로 넘어간다.
- 순증가 형태를 만들 수 없을때 -1을 반환후 contiue로 넘어간다
- 그 외의 경우는 C >= 3일때 오름차순 형태를 만들면 break
- 그렇지 않으면 계속 A >= B 그리고  B >= C일때 1개씩 빼주고 cnt++
*/

package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class swea_20551_증가하는사탕수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			int C = Integer.parseInt(arr[2]);
//			System.out.println(A);
//			System.out.println(B);
//			System.out.println(C);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			
			int cnt = 0;

			// 한큐에 조건 만족
			if (A < B && B < C) {
				sb.append(0);
				System.out.println(sb);
				continue;
			}
			
			// 순증가 불가
			if (C <= 2 || B <= 1) {
				sb.append(-1);
				System.out.println(sb);
				continue;
			}
			
			// 최소 갯수 구하기
			while (C >= 3) {
				
				// break
				if (A < B && B < C) {
					break;
				}
				
				// 3, 2, 3
				// 6, 5, 4
				// 3, 3, 3
				if (A >= B) {
					A--;
					cnt++;
				}
				
				if (B >= C) {
					B--;
					cnt++;
				}
			}
			
			sb.append(cnt);
			
			// res
			System.out.println(sb);
			

			
			
		}
		
		
		
	}
}