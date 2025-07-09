/*
람다식 표현 (asc)
*/

package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class boj_11651_좌표정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// x,y 좌표를 저장할 배열 new int[N][2];
		int[][] pos = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			pos[i][0] = x;
			pos[i][1] = y;
		}
		
		
		// lambda (asc) based on y
		Arrays.sort(pos, (a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		
		
		
		// res
//		System.out.println(Arrays.deepToString(pos));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(pos[i][0] + " " + pos[i][1] + "\n");
		}
		System.out.println(sb.toString());
	}
}