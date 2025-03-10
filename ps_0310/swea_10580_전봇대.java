/*
[접근 방식]
한 범위 안에 들어오면 cnt++

- 입력을 다르게 생각해보자
ex)
1 
3
5 5
1 10
7 7

[코드 개요]
int 배열 lst
List<int[]> int_ArrayList = new ArrayList<>();
*/


package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class swea_10580_전봇대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 단일 객체
//			List<Integer> ArrayList = new ArrayList<>();
			
			// int 배열 lst
			List<int[]> int_ArrayList = new ArrayList<>();
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split(" ");
				int start = Integer.parseInt(arr[0]);
				int end = Integer.parseInt(arr[1]);
				
				
				for (int[] pair : int_ArrayList) {
					int a = pair[0];
					int b = pair[1];
					
					if ( (start > a && b > end) || (start < a && b < end) ) {
						cnt++;
					}
				}
				
				// 초기값으로 아무 것도 없으면 여기서 start, end 추가하고 시작
				// 이후로 N회 까지 반복해 추가
				int_ArrayList.add(new int[] {start, end});
			}
			
			// res
			System.out.println("#" + tc + " " + cnt);
		
		
		}
	}
}