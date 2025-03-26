/*
1. seq 최소 길이 2부터 시작
2. StringBuilder를 2개 선언해 최대길이일때 max_seq = sb 저장해주자
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


//import java.util.Arrays;


public class boj_2635_수이어가기 {
	static StringBuilder sb;
	static StringBuilder max_seq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max_seq = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int max_leng = 0;
		for (int i = N; i >= 0; i--) {
			sb = new StringBuilder();
			sb.append(N + " " + i + " ");
			
			int temp_leng = 2;
			
			int a = N;
			int b = i;

			
			while(b >= 0) {
				int next = (a-b);
				if (next < 0) {
					break;
				}
				sb.append(next + " ");
				temp_leng++;
				
				a = b;
				b = next;
				
			}
			
			// comparison
			if (temp_leng > max_leng) {
				max_leng = temp_leng;
				max_seq = sb;
			}
			
			
			
		}
		
		System.out.println(max_leng);
		System.out.println(max_seq);
	
	
	
	}
}