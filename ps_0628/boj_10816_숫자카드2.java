package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] N_arr = br.readLine().split(" ");
		int[] my_cards = str_to_int(N_arr);
		Arrays.sort(my_cards);
		
		
		int M = Integer.parseInt(br.readLine());
		String[] M_arr = br.readLine().split(" ");
		int[] given_cards = str_to_int(M_arr);
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M ; i++) {
			int target_num = given_cards[i];
			int upper = upperBound(my_cards, target_num);
			int lower = lowerBound(my_cards, target_num);
			if (i < M-1) {
				sb.append(upper - lower + " ");
			}
			else {
				sb.append(upper - lower);
			}
		}
		System.out.println(sb.toString().trim());
		
	}
	
	public static int upperBound(int[] my_cards, int target_num) {
		int left = 0;
		int right = my_cards.length - 1;
		int res = my_cards.length;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (my_cards[mid] <= target_num) {
				left = mid + 1;
			}
			else if (my_cards[mid] > target_num) {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
	}
	
	
	
	public static int lowerBound(int[] my_cards, int target_num) {
		int left = 0;
		int right = my_cards.length - 1;
		int res = my_cards.length;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (my_cards[mid] < target_num) {
				left = mid + 1;
			}
			else if (my_cards[mid] >= target_num) {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
	}
	
	
	
	
	
	public static int[] str_to_int(String[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		return res;
	}
	
}