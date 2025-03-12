/*
[constraint]
--> max N --> 1 million (1,000,000)
--> value --> 10,000
so, maximun value should be 10 billion.


* int (4 byte) = (32 bit) --> [-2^{31}-1  ~  2^31 -1]    -2147483648 ~ 2147483647
* long (8 byte) = (64 bit) --> [-2^{63}-1  ~  2^63 -1]    -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
int --> 2.1 billion (빅뱅 전의 메이플 최대 메소)


[idea]
take away max_val and lst[i] from the end, if new max_val found, renew it.
as you already saw the memo above, you must use `long` not int.



[test case]
tc-1) 
sum += (6-6) + (7-7) + (10-10)

tc-2)
sum += (9-5) += (9-3)

tc-3) 
sum += (2-1) + (3-1) + (3-1)
*/



package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class swea_1859_백만장자프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			long[] lst = new long[arr.length];
			
			for (int i = 0; i < N; i++) {
				lst[i] = Long.parseLong(arr[i]);
			}
			
			
			// initializing value;
			long max_val = 0;
			long max_profit = 0;
			
			// to find max_val & max_profit
			for (int i = 0; i < N; i++) {
				if (lst[N-1-i] > max_val) {
					max_val = lst[N-1-i];
				}
				
				max_profit += (max_val - lst[N-1-i]);
				
			}
			
				
			
			
//			System.out.println(Arrays.toString(lst));
			System.out.println("#" + tc + " " + max_profit);
			 
			
		}
		
		
		
		
	}
}