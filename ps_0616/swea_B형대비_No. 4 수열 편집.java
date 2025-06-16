package swea;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NML = br.readLine().split(" ");
			int M = Integer.parseInt(NML[1]);
			int L = Integer.parseInt(NML[2]);
			
			ArrayList<Integer> lst = new ArrayList<>();
			String[] nums = br.readLine().split(" ");
			for (int i = 0; i < nums.length; i++) {
				lst.add(Integer.parseInt(nums[i]));
			}
//			System.out.println(lst);
			
			for (int i = 0; i < M; i++) {
				String[] commands = br.readLine().split(" ");
				if (commands[0].equals("I")) {
					int idx = Integer.parseInt(commands[1]);
					int val = Integer.parseInt(commands[2]);
					lst.add(idx, val);
				}
				else if (commands[0].equals("D")) {
					int idx = Integer.parseInt(commands[1]);
					lst.remove(idx);
				}
				else if (commands[0].equals("C")) {
					int idx = Integer.parseInt(commands[1]);
					int val = Integer.parseInt(commands[2]);
					lst.set(idx, val);
				}
			} 
			
			
			int res = -1;
			if (lst.size() < L) {
				System.out.println("#" + tc + " " + res);
			}
			else {
				System.out.println("#" + tc + " " + lst.get(L));
			}
			
		
			
			
			
		}
		
		
		
		
		
		
		
		
	}
}