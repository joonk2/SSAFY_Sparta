package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String N = br.readLine();
			int res = my_calculator(N);
			System.out.println("#" + tc + " " + res);
		}
		
		
		
		
	}
	public static int my_calculator(String nums) {
		int cnt_10 = 0;
		boolean[] check = new boolean[10];
		int fixed_num = Integer.parseInt(nums);
		int k = 1;
		
		while (cnt_10 < 10) {
			for (int i = 0; i < nums.length(); i++) {
				int temp_num = nums.charAt(i)-'0';
//				System.out.println("ㅋㅋ"+ " " + temp_num);
				if (!check[temp_num]) {
					check[temp_num] = true;
					cnt_10++;
				}
			}
			
			// 중간 점검
			if (cnt_10 == 10) break;
			k++;
			int n = Integer.parseInt(nums);
			n = (fixed_num * k);
			nums = Integer.toString(n);
//			System.out.println("이것은 nums -->" + nums);
			
			
		}
		int res = Integer.parseInt(nums);
		
		return res;
	}
	
}