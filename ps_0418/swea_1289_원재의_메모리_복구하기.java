package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;

public class swea_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String bit_arr = br.readLine();
			int[] bit = new int[bit_arr.length()];
			
			for (int i = 0; i < bit_arr.length(); i++) {
				bit[i] = bit_arr.charAt(i)-'0';
			}
			
			int cnt = 0;
			boolean stop = false;
			for (int i = 0; i < bit.length; i++) {
				if (bit[i] == 1) {
					cnt++;
					for (int j = i; j < bit.length; j++) {
						bit[j] = 1-bit[j];
					}
				}
				
				int temp_check = 0;
				for (int k = 0; k < bit.length; k++) {
					if (bit[k] == 0) {
						temp_check++;
					}
				}
				
				if (temp_check == bit.length) {
					stop = true;
				}
				
			}
			
			System.out.println("#" + tc + " " + cnt);
//			System.out.println(Arrays.toString(bit));
			
			
			
		}
		
		
	}
}