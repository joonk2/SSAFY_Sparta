/*
[아이디어]
중복되지 않은 값을 boolean[] 배열에 저장하고 전부 true일 경우 확인 종료


[코드 개요]
- Int형으로 값을 입력받고 그 후에 current_N을 통해 String으로 전환하자.  
- 만약에 값이 없다면 
*/


package ps_0306;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

//import java.util.HashSet;

public class swea_1288_새로운_불면증_치료법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 0~9까지의 중복되지 않는 숫자를 저장할 boolean 배열 선언
			boolean[] check = new boolean[10];
			
			
			int i = 1;
			while (true) {
				// current_N으로 조건 만족할 때까지 계속 확인
				int current_N = (N*i);
				// 각 자릿수 하나씩 쪼개주기 위해 String으로 전환
				String str_N = String.valueOf(current_N);
				
				for (int k = 0; k < str_N.length(); k++) {
					// 현재 숫자 추출후, 만약 false라면 true로 전환
					// (기본적으로 boolean 배열 선언시 자동으로 모든 값이 false로 할당되어 만들어짐)
					int digit = str_N.charAt(k) - '0';
					if (!check[digit]) {
						check[digit] = true;
					}
					
				}
				
				// 만약에 중간에 하나라도 체크 안되면 이 10개확인 for문을 바로 중단
				boolean all_checked = true;
				for (int x = 0; x < 10; x++) {
					if(!check[x]) {
						all_checked = false;
						break;
					}
				}
				
				// ---------- 만약 다 true라면 이제 볼일 다끝났으니 while문을 break------------
				if(all_checked == true) {
					break;
				}
				
				
				// 원하는 값이 안나왔다면 i++를 통해 값을 키우자
				i++;
				
			}
			
			// res
			System.out.println("#" + tc + " " + (N*i) );
			
			
			
			
			
		}
		
		
		
		
		
	}
}
