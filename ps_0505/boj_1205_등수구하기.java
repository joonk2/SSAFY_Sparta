package boj;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class boj_1205_등수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first_line = br.readLine().split(" ");
		int N = Integer.parseInt(first_line[0]);
		int new_score = Integer.parseInt(first_line[1]);
		int p = Integer.parseInt(first_line[2]);
		
		List<Integer> score_box = new ArrayList<>();
		
		if (N > 0) {
			String[] second_line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				score_box.add(Integer.parseInt(second_line[i]));
			}
		}
//		System.out.println(score_box);
		
		int rank = 1;
		int res = -1;
		for (int i = 0; i < N; i++) {
			int cur_score = score_box.get(i);
			if (cur_score > new_score) {
				rank++;
			}
			else {
				break;
			}
		}
		
		
		if (score_box.size() == p && new_score <= score_box.get(p-1)) {
			System.out.println(res);
		}
		else {
			System.out.println(rank);
		}
		
		
		
	}
}