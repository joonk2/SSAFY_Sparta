/*
[아이디어]
- Brute-Force (완전탐색)으로 진행

[코드 개요]
- 우선 속도 개선을 위해 String[] 배열에서 바로 작성을 진행하지 않고 int[] 배열에 옮겨준 후 진행하였다
-  첫 시작점부터 하나하나 살펴보며 0인 경우 지나치며 startIdx++
-  1인경우 cnt++을 해주고 값들을 바로 변경 
*/



package ps_0306;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;


public class swea_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			// bit 선언후에 int[] 배열에 값을 할당
			String bit = br.readLine();
			int[] bit_lst = new int[bit.length()];
			
			// 이어진 String은 하나씩 쪼개서 int[]에 할당하려면 charAt() -'0'
			// 위와 같은 아스키코드 뺄셈 형식을 해줘야 가능하다.
			for (int i = 0; i < bit.length(); i++) {
				bit_lst[i] = bit.charAt(i) - '0';
			}

			
			// 첫 시작인덱스 변수 0
			// 원래대로 돌리기 위한 cnt 변수 선언
			int startIdx = 0;
			int cnt = 0;
			
			// 시작 인덱스가 전체 길이보다 작을동안 반복한다.
			while (startIdx < bit_lst.length) {
				int cnt_0 = 0;
				for (int k = 0; k < bit_lst.length; k++) {
					if (bit_lst[k] == 0) {
						cnt_0++;
					}
				}
				
				
				// ------------- bit_lst의 길이만큼 0이 완성되면 그 즉시 완성된 것이기에 중단한다 --------
				if (cnt_0 == bit_lst.length) {
					break;
				}
				
				
				
				// bit_lst의 길이만큼 0이 완성되지 않았을 때, 현재 인덱스가 0이라면
				// 바로 다음 인덱스로 넘어가기 위해 idx++ 진행
				if (bit_lst[startIdx] == 0) {
					startIdx++;
				}
				
				// 만약에 bit의 현재 인덱스가 1이라면 범위(해당 인덱스 ~ 끝지점)
				// 까지 값 변경 진행하고 그 횟수를 저장
				else {
					for (int k = startIdx; k < bit_lst.length; k++) {
						bit_lst[k] = 1 - bit_lst[k];
					}
					cnt++;
				}
				
				
			}
			
			
			
			// 디버깅
//			System.out.println(Arrays.toString(bit_lst));
			System.out.println("#" + tc + " " + cnt);
			
			
			
		}
		
		
	}
}
