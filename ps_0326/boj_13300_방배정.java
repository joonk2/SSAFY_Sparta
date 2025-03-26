/*
[idea]
make 2 different room
[][] --> [gender : girl(0) or boy(1)][grade : 1 ~ 6]
we dont count if there's no one in the room
so let's set a range (a person(min) to K(max))

if the arrays value exceed K, then devide by mod and remainder per boy and girl
--> cnt += (mod + remainder)
else: just cnt++
*/

package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Solution {
	static int[][] room = new int[2][7];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		for (int i = 0; i < N; i++) {
			String[] gender_grade = br.readLine().split(" ");
			int gender = Integer.parseInt(gender_grade[0]);
			int grade = Integer.parseInt(gender_grade[1]);
			
			room[gender][grade]++;
		}
		
//		int girl = 0;
//		int boy = 1;
		int cnt = 0;
		for (int i = 1; i < 6+1; i++) {
			for (int gender = 0; gender < 1+1; gender++) {
				if (room[gender][i] >= 1) {
					cnt += ( (room[gender][i])/K );
					if ( (room[gender][i] % K) >= 1 ) {
						cnt++;
					}
				}

			}
			
		}
//			if (room[girl][i] >= 1 && room[girl][i] <= K) {
//				cnt++;
//			}
//			else if (room[girl][i] > K) {
//				int g_mod = (room[girl][i] / K);
//				int g_remainder = (room[girl][i] % K);
//				cnt += (g_mod + g_remainder);
//			}
//			
//			if (room[boy][i] >= 1 && room[boy][i] <= K) {
//				cnt++;
//			}
//			else if (room[boy][i] > K) {
//				int b_mod = (room[boy][i] / K);
//				int b_remainder = (room[boy][i] % K);
//				cnt += (b_mod + b_remainder);
//			}
			

		
		System.out.println(cnt);
//		System.out.println(Arrays.deepToString(room));
		
		
		
	}
	
}