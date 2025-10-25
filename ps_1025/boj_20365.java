import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String colors = br.readLine();
		char[] arr = new char[N];
		for (int i = 0; i < N; i++) {
			arr[i] = colors.charAt(i);
		}
		
		
		
		// red -> 0
		// blue -> 1
		char prev_color = arr[0];
		int[] cnt = new int[2];
		if (prev_color == 'R') {
			cnt[0]++;
		}
		else if (prev_color == 'B') {
			cnt[1]++;
		}
		
		
		
		for (int i = 1; i < N; i++) {
			char cur_color = arr[i];
			if (prev_color != cur_color) {
				prev_color = cur_color;
				if (cur_color == 'R') {
					cnt[0]++;
				}
				else if (cur_color == 'B') {
					cnt[1]++;
				}
			}
		}
		
		// red or blue중 더 많이 색칠된게 있다면
		// 전체 배열에 최초 1회 더 많이 색칠된 색깔로 전부 색칠되었다고 가정
		// 그 후 적게 색칠된 숫자만큼 배열에 색칠해주면서 바꾸면 된다
		// ex) RRR BB RRR BB R
		// RRR RR RRR RR R -> RRR vv RRR vv R (3회)

		if (cnt[0] >= cnt[1]) {
			System.out.println(++cnt[1]);
		}
		else if (cnt[0] < cnt[1]) {
			System.out.println(++cnt[0]);
		}
		
		
	}
}