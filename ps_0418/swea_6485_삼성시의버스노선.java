package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// import java.util.Arrays;

public class swea_6485_삼성시의버스노선 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] bus_route = new int[5001];
			for (int i = 0; i < N; i++) {
				String[] AB = br.readLine().split(" ");
				int A = Integer.parseInt(AB[0]);
				int B = Integer.parseInt(AB[1]);
				
				for (int k = A; k < B+1; k++) {
					bus_route[k]++;
				}
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			int P = Integer.parseInt(br.readLine());
			for (int i = 1; i < P+1; i++) {
				int C = Integer.parseInt(br.readLine());
				sb.append(bus_route[C] + " ");
			}
			
			
			System.out.println(sb);
			
			
		}
		
		
		
		
	}
}