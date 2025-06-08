package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2941_크로아티아_알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String words = br.readLine();
		int res = word_cnt_checker(words);
		System.out.println(res);
	}
	
	
	
	
	
	public static int word_cnt_checker(String str) {
		int cnt = 0;
		int i = 0;
		while (i < str.length()) {
			char ch = str.charAt(i);
			// 앞자리가 c고, 2자리를 셀만큼 idx의 길이가 되고, 2번째가 '=' 혹은 '-' 일때
			if (ch == 'c' && i+1 < str.length() && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-') ) {
				cnt++;
				i += 2;
			}
			else if (ch == 'd') {
				if (i+2 < str.length() && (str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') ) {
//					System.out.println(ch+""+str.charAt(i+1)+""+str.charAt(i+2));
					cnt++;
					i += 3;	
				}
				else if (i+1 < str.length() && (str.charAt(i+1) == '-') ) {
//					System.out.println(ch+""+str.charAt(i+1));
					cnt++;
					i += 2;
				}
				else {
//					System.out.println(ch);
					cnt++;
					i++;
				}
			}
			else if (ch == 'l' && i+1 < str.length() && str.charAt(i+1) == 'j' ) {
//				System.out.println(ch+""+str.charAt(i+1));
				cnt++;
				i += 2;
			}
			else if (ch == 'n' && i+1 < str.length() && str.charAt(i+1) == 'j') {
//				System.out.println(ch+""+str.charAt(i+1));
				cnt++;
				i += 2;
				
			}
			else if (ch == 's' && i+1 < str.length() && str.charAt(i+1) == '=' ) {
//				System.out.println(ch+""+str.charAt(i+1));
				cnt++;
				i += 2;
			}
			else if (ch == 'z' && i+1 < str.length() && str.charAt(i+1) == '=' ) {
//				System.out.println(ch+""+str.charAt(i+1));
				cnt++;
				i += 2;
			}
			
			// 알파벳에 없는 나머지 경우
			else {
//				System.out.println(ch);
				cnt++;
				i++;
			}

		}
		
		
		return cnt;
	}
	
	
	
	
}