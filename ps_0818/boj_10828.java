package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class boj_10828_스택 {
	static int[] stack = new int[10001];
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			my_stack(s);
		}
	}
	
	
	
	public static void my_stack(String commands) {
		if (commands.startsWith("push")) {
			int num = Integer.parseInt(commands.split(" ")[1]);
			stack[idx] = num;
			++idx;
		}
		else if (commands.equals("pop")) {
			if (idx == 0) System.out.println(-1);
			else {
				--idx;
				System.out.println(stack[idx]);
			}
		}
		else if (commands.equals("size")) System.out.println(idx);
		else if (commands.equals("top")) {
			if (idx == 0) System.out.println(-1);
			else System.out.println(stack[idx-1]);
		}
		else if (commands.equals("empty")) {
			if (idx == 0) System.out.println(1);
			else System.out.println(0);
		} 
	
	
	}
	
	
	
	
	
}