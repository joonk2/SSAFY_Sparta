package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2164_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = card_checker(N);
		System.out.println(res);
	}
	

	
	public static int card_checker(int N) {
		int[] my_deck = new int[N*2];		
		for (int i = 0; i < N; i++) {
			my_deck[i] = i+1;
		}
		
		int start = 0;
		int end = N-1;
		while (start < end) {
			++start;
			my_deck[++end] = my_deck[start];
			start++;
		}
		
		return my_deck[start];
	}
	
	
	
}