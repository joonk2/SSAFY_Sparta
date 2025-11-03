import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// circular_arr
		int min_dist = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int idx = i;
			int temp_sum = 0;
			for (int j = 0; j < N; j++) {
				temp_sum += (j * arr[(j+idx) % N]);
			}
			min_dist = Math.min(min_dist, temp_sum);
		}
		
		// res
		System.out.println(min_dist);
	}
}