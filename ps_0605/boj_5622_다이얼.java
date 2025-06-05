/*
다이얼을 읽어보면
ABC -> 3
DEF -> 4
...
WXYZ -> 10
라는 규칙을 알 수 있다. 
*/


package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class boj_5622_다이얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dial = br.readLine();
		char[] dial_arr = dial.toCharArray();
		
		// 디버깅
//		System.out.println(Arrays.toString(dial_arr));
		
		
		// 함수 적용
		int[] final_answer = my_custom_changer(dial_arr);
//		System.out.println(Arrays.toString(final_answer));
		
		
		// 정답 출력
		int sum = 0;
		for (int i = 0; i < final_answer.length; i++) {
			sum += final_answer[i];
		}
		System.out.println(sum);
		
	}
	
	
	
	// 함수 (문자를 숫자로 변경)
	// char[] -> int[]
	public static int[] my_custom_changer(char[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (arr[i] == 'A' || arr[i] == 'B' || arr[i] == 'C') {
				res[i] = 3;
			}
			if (arr[i] == 'D' || arr[i] == 'E' || arr[i] == 'F') {
				res[i] = 4;
			}
			if (arr[i] == 'G' || arr[i] == 'H' || arr[i] == 'I') {
				res[i] = 5;
			}
			if (arr[i] == 'J' || arr[i] == 'K' || arr[i] == 'L') {
				res[i] = 6;
			}
			if (arr[i] == 'M' || arr[i] == 'N' || arr[i] == 'O') {
				res[i] = 7;
			}
			if (arr[i] == 'P' || arr[i] == 'Q' || arr[i] == 'R' || arr[i] == 'S') {
				res[i] = 8;
			}
			if (arr[i] == 'T' || arr[i] == 'U' || arr[i] == 'V') {
				res[i] = 9;
			}
			if (arr[i] == 'W' || arr[i] == 'X' || arr[i] == 'Y' || arr[i] == 'Z') {
				res[i] = 10;
			}
		}
		
		
		return res;
	}
}