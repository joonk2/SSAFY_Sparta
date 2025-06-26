package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_2512_예산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] budget_arr = br.readLine().split(" ");
		int[] budgets = str_to_int(budget_arr);
		long total_budget = Long.parseLong(br.readLine());
		
		int res = parametric_search(budgets, total_budget);
		System.out.println(res);
		
		
		
	}
	
	public static int parametric_search(int[] budgets, long total_budget) {
		int left = 1;
		int right = upperBound(budgets);
		int the_maximum_out_of_budget = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
//			System.out.println("mid -->" + mid);
			
			
			if (can_increase_budget(mid, budgets, total_budget)) {
				the_maximum_out_of_budget = mid;
				left = mid + 1;
			}
			else if (!can_increase_budget(mid, budgets, total_budget)) {
				right = mid - 1;
			}
		}
		
		return the_maximum_out_of_budget;
	}
	
	
	public static boolean can_increase_budget(int mid, int[] budgets, long total_budget) {
		long temp_total_budgets = 0;
		for (int i : budgets) {
			if (i > mid) {
				i = mid;
			}
			temp_total_budgets += i;
		}
//		System.out.println("temp_total_budgets -->" + temp_total_budgets);
		return temp_total_budgets <= total_budget;
	}
	
	
	
	
	
	public static int[] str_to_int(String[] arr) {
		int[] budgets = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			budgets[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(budgets);
		return budgets;
	} 
	
	
	public static int upperBound(int[] budgets) {
		int max = 0;
		for (int i : budgets) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	
	
	
}