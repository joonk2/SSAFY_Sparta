import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] NX = br.readLine().split(" ");
			int N = Integer.parseInt(NX[0]);
			int X = Integer.parseInt(NX[1]);
			String[] arr = br.readLine().split(" ");
			int[] visitors = new int[N];
			int[] cum_sum_arr = new int[N-X+1];
			int cnt = 0;
			int idx = 0;
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(arr[i]);
				if (cnt < X) {
					cum_sum_arr[idx] += num;
					cnt++;
				}
				visitors[i] = num;
			}
			
	
			what_is_the_answer(N, X, visitors, cum_sum_arr);		
		}
		
		
		
		
		static void what_is_the_answer(int N, int X, int[] visitors, int[] cum_sum_arr) {
			int max = cum_sum_arr[0];
			int idx = 0;
			for (int i = X; i < N; i++) {
				int cum_sum = cum_sum_arr[idx] + visitors[i] - visitors[i-X];
				idx++;
				cum_sum_arr[idx] = cum_sum;
				if (cum_sum > max) {
					max = cum_sum;
				}
			}

			
			
			
			// answer
			int cnt = 0;
			if (max <= 0) {
				System.out.println("SAD");
			}
			else if (max > 0) {
				for (int i = 0; i < N-X+1; i++) {
					if (cum_sum_arr[i] == max) {
						cnt++;
					}
				}
				System.out.println(max);
				System.out.println(cnt);
			}
		}
		
		
	}