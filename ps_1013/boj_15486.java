import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] t_price = br.readLine().split(" ");
			int t = Integer.parseInt(t_price[0]);
			int price = Integer.parseInt(t_price[1]);
			arr[i][0] = t;
			arr[i][1] = price;
		}
		lets_find_max_profit(N, arr);
	}
	
	
	
	
	static void lets_find_max_profit(int N, int[][] arr) {
		int[] DP = new int[N+1];
		for (int i = 0; i < N; i++) {
			int t = arr[i][0];
			int value = arr[i][1];
			if (i+t <= N) {
				DP[i+t] = Math.max(DP[i+t], DP[i] + value);
			}	
			DP[i+1] = Math.max(DP[i+1], DP[i]);
		}
		System.out.println(DP[N]);
	}

	
	
	
}