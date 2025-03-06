/*
[코드 개요] 
- base(밑) 를 내림차순으로 {11, 7, 5, 3 2} 를 활용해 N이 가장 작은 밑인 2보다 크거나 같을까지 무한 나눗셈  
- 지수는 초기값으로 0으로 전부 선언

*/

package ps_0306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea_1945_간단한소인수분해 {
	// base(밑) 고정으로 선언
	static int[] base = {11, 7, 5, 3, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			// 지수
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			
			// ------ 가장 작은 밑이 2니까 2가 될때까지 무한 나눗셈 ------
			while(N >= 2) {
				
				// 11로 나눌 떄 나머지가 0이면, 나누어진다는 뜻이니 N /= 11
				// 나눠지면 11의 지수를 1개 증가시켜야하니 e++
				if (N % base[0] == 0) {
					N /= base[0];
					e++;
				}
				
				// 7로 나눌때 나머지가 0이면, 나누어진다는 뜻이니 N /= 7
				// 나눠지면 7의 지수를 1개 증가시켜야 하니 d++
				else if (N % base[1] == 0) {
					N /= base[1];
					d++;
				}
				
				// 5로 나눌 때 나머지가 0이면, 나누어진다는 뜻이니 N /= 5
				// 나눠지면 5의 지수를 1개 증가시켜야 하니 c++
				else if (N % base[2] == 0) {
					N /= base[2];
					c++;
				}
				
				
				// 3으로 나눌 때 나머지가 0이면, 나누어진다는 뜻이니 N /= 3
				// 나눠지면 3의 지수를 1개 증가시켜야하니 b++
				else if (N % base[3] == 0) {
					N /= base[3];
					b++;
				}
				
				
				// 4로 나눌 때 나머지가 0이면, 나누어진다는 뜻이니 N /= 2
				// 나눠지면 2의 지수를 1개 증가시켜야하니 a++
				else if (N % base[4] ==0) {
					N /= base[4];
					a++;
				}
				
				
			}
			
			
			
			// 출력을 위한 StringBuilder
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " " + a + " " + b + " "+ c + " " + d + " " + e);
			System.out.println(sb);
			
			
			
		}
		
		
	}
}
