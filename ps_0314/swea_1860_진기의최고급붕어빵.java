/*
[idea]
- make the order asc;
- think time(t1, t2) as number of person.
- cur_bread = (cur_time / cookingTime) * number of bread
- finally compare if person can't eat cur_bread then 'impossible'
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


import java.util.Arrays;

public class swea_1860_진기의최고급붕어빵 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] NMK = br.readLine().split(" ");
			int N = Integer.parseInt(NMK[0]);
			int M = Integer.parseInt(NMK[1]);
			int K = Integer.parseInt(NMK[2]);
			
			String[] time_arr = br.readLine().split(" ");
			int[] time = new int[time_arr.length];
			for (int i = 0; i < time_arr.length; i++) {
				time[i] = Integer.parseInt(time_arr[i]);
			}
				
			
			// asc;
			Arrays.sort(time);	
			
			
			// change time[0] && time[1] to person1, and person2
			boolean IsPossible = true;
			for (int i = 0; i < N; i++) {
				int cur_time = time[i];
				int bread = (cur_time / M) * K;
				int person = i+1;
				
				if (person > bread) {
					IsPossible = false;
					break;
				}

			}
			
			// res
			if (IsPossible) {
				System.out.println("#" + tc + " " + "Possible");
			}
			else {
				System.out.println("#" + tc + " " + "Impossible");
			}
		
			
			
			
		}
		
		
		
		
	}
}