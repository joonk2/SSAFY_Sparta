package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class boj_킹퀸룩비숍나이트폰_3003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] chess_piss = br.readLine().split(" ");
		
		
		int[] chess_piss_int = new int[chess_piss.length];
		int[] original_piss = new int[]{1,1,2,2,2,8};
		
		int[] res = new int[original_piss.length];
		
		for (int i = 0; i < chess_piss_int.length; i++) {
			chess_piss_int[i] = Integer.parseInt(chess_piss[i]);
			
			// case 1. 같을 때
			if (chess_piss_int[i] == original_piss[i]) {
				res[i] = chess_piss_int[i] - original_piss[i];
			}
			
			// case 2. 다를 때
			if (chess_piss_int[i] != original_piss[i]) {
				// 2-1. 입력값이 정석 패보다 클때
				if (chess_piss_int[i] > original_piss[i]) {
					res[i] = original_piss[i] - chess_piss_int[i];
				}
				// 2-2. 정석패가 입력값보다 클때
				if (original_piss[i] > chess_piss_int[i]) {
					res[i] = original_piss[i] - chess_piss_int[i];
				}
			}
			
		}
		
		// 출력
//		System.out.println(Arrays.toString(res));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i < res.length-1) {
				sb.append(res[i] + " ");
			}
			if (i == res.length-1) {
				sb.append(res[i]);	
			}
		}
		System.out.println(sb);
		
	}
}