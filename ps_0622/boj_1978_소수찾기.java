package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class boj_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] nums_arr = br.readLine().split(" ");
		int res = my_detecter(N, nums_arr);
		System.out.println(res);
	}
	
	public static int my_detecter(int x, String[] arr) {
		int cnt = 0;
		int[] lst = new int[arr.length];
		for (int i = 0; i < x; i++) {
			lst[i] = Integer.parseInt(arr[i]);
		}
//		System.out.println(Arrays.toString(lst));
		for (int i = 0; i < lst.length; i++) {
			int temp_num = lst[i];
			if (lst[i] == 1) continue;
			int temp_cnt = 0;
			for (int j = 1; j < lst[i]+1; j++) {
				if (lst[i] % j == 0) {
					temp_cnt++;
				}
			}
			if (temp_cnt == 2) cnt++;
		}
		return cnt;
	}
	
}