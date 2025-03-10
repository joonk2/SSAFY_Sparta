/*
[아이디어]
- 1이상의 특정 인덱스를 특정 범위만큼 배열 인덱스의 값으로 줘야해서,
N+1 크기의 배열을 만들고 고정 값을 인덱스별로 할당해주었다
*/

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// import java.util.Arrays;

public class swea_5789_현주의상자바꾸기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int Q = Integer.parseInt(arr[1]);
			
			
			int[] box = new int[N+1];
			
			
			
			for (int i = 1; i < Q+1; i++) {
				String[] LR = br.readLine().split(" ");
				int L = Integer.parseInt(LR[0]);
				int R = Integer.parseInt(LR[1]);
				
				for (int x = L; x < R+1; x++) {
					box[x] = i;
				}
				
				
				
				
			}
			
			
			System.out.println(Arrays.toString(box));
			
			
			
		}
		
		
	}
}