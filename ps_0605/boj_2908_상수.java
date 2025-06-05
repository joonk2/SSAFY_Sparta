package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// import java.util.Arrays;

public class boj_2908_상수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] two_nums = br.readLine().split(" ");
		
		String first_num = two_nums[0];
		String second_num = two_nums[1];
		
		// String -> char[]
		// "734" -> ['7', '3', '4']
		char[] first_num_arr = first_num.toCharArray();
		char[] second_num_arr = second_num.toCharArray();
		
		// 디버깅
//		System.out.println(Arrays.toString(first_num_arr));
//		System.out.println(Arrays.toString(second_num_arr));

		
		// 거꾸로 뒤집는 함수 적용
		my_reverse(first_num_arr);
		my_reverse(second_num_arr);
		
		// 디버깅
//		System.out.println(first_num_arr);
//		System.out.println(second_num_arr);
		
		
		// char -> String 그 이후 int 형으로 새로 할당
		int reversed_first_num = Integer.parseInt(new String(first_num_arr));
		int reversed_second_num = Integer.parseInt(new String(second_num_arr));
		
		// 결과
		int res = 0;
		if (reversed_first_num > reversed_second_num) {
			res = reversed_first_num;
		}
		else {
			res = reversed_second_num;
		}
		System.out.println(res);
		
		
	}
	
	
	
	
	
	
	
	
	// 거꾸로 뒤집는 함수 
	public static void my_reverse(char[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
}