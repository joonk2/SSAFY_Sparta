package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2292_벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(1);
		}
		else {
			int i = 1;
			int start = 1;
			int end = 7;
			while (true) {
				if ( start < N && N <= end) {
					i++;
					break;
				}
				else {
					start += (6*i);
					i++;
					end += (6*i);
				}
			}
			System.out.println(i);
			
		}
	}
}