import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int N, M;
	static int max_size = Integer.MIN_VALUE;
	static int[] a;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		String[] s_arr = br.readLine().split(" ");
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(s_arr[i]);
		}
		back_tracking(-1,0,1);
		System.out.println(max_size);
	}
	
	
	
	
	static void back_tracking(int idx, int t, int cur_size) {
		
		// renewal
		max_size = Math.max(cur_size, max_size);
		
		// pruning
		if (idx >= N-1) {
			return;
		}
		
		// pruning
		if (t == M) {
			return;
		}
		
		if (idx + 1 < N) {
			back_tracking(idx+1, t+1, cur_size + a[idx+1]);
		}
		
		if (idx + 2 < N) {
			back_tracking(idx+2, t+1, (cur_size/2) + a[idx+2]);
		}
	}
	
	
}