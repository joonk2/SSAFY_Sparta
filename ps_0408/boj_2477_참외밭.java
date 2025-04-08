/*
[idea]
first, starting point is y_1 which is box[0] and next one is x_1, which is box[1]
and y_2, which is box[2], x_2 which is box[3] blah blah.
there's a pattern, that idx 3, 4 are always the least x and y
so take (x times y) away from the longest square meter.
*/


package samsung01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int yellow_melon = Integer.parseInt(br.readLine());
		int[] x = new int[6];
		int[] y = new int[6];
		int[] box = new int[6];
		for (int i = 0; i < 6; i++) {
			String[] arr = br.readLine().split(" ");
			int direction = Integer.parseInt(arr[0]);
			int point = Integer.parseInt(arr[1]);
			if (direction == 4 || direction == 3) {
				y[i] = point;
			}
			else if (direction == 2 || direction == 1) {
				x[i] = point;
			}
			box[i] = point;
			
		}
		// y_val (max)
		int max_y = -99;
		int max_y_idx = 0;
		for (int i = 0; i < y.length; i++) {
			if (y[i] != 0) {
				if (y[i] > max_y) {
					max_y = y[i];
					max_y_idx = i;
				}
			}
		}
		
		// x_val (max)
		int max_x = -99;
		int max_x_idx = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0) {
				if (x[i] > max_x) {
					max_x = x[i];
					max_x_idx = i;
				}
			}
		}
		
		// min (y_val, x_val)
		int i = 0;
		int min_val = 0;
		min_val += ( (box[(max_y_idx+3)%6])  * (box[(max_x_idx+3) % 6]) );
//		System.out.println(min_val);
		
		
		
//		System.out.println(Arrays.toString(y));
//		System.out.println(Arrays.toString(x));
//		System.out.println(max_y);
//		System.out.println(max_x);
//		System.out.println(min_y);
//		System.out.println(min_x);
		
		int harvest = 0;
		harvest = ( (max_x * max_y) - min_val );
		System.out.println(harvest * yellow_melon);
		
		
	}
}