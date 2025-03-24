/*
3
10
0011001110
10
0000100001
10
0111001111 


#1 3
#2 1
#3 4
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.Arrays;

public class swea_9386_연속한1의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String seq_arr = br.readLine();
			int[] seq = new int[seq_arr.length()];
			
			for (int i = 0; i < N; i++) {
				seq[i] = seq_arr.charAt(i)-'0';
			}
			
			
			int max_cnt_1 = 0;
			for (int i = 0; i < N; i++) {
				int temp_cnt_1 = 0;
				for (int j = i; j < N; j++) {
					if (seq[j] == 1) {
						temp_cnt_1++;
					}
					else {
						break;
					}
				}
				
				if (temp_cnt_1 > max_cnt_1) {
					max_cnt_1 = temp_cnt_1;
				}
				
			}
			
			
//			System.out.println(Arrays.toString(seq));
			System.out.println("#" + tc + " " + max_cnt_1);
			
			
			
			
			
		}
		
		
		
	}
}