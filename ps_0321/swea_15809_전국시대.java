import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
//import java.util.Set;
//import java.util.HashSet;


public class swea_15809_전국시대 {
	static int[] parents, troops;
//	static Set<Integer> HS = new HashSet<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		troops = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			troops[i] = Integer.parseInt(br.readLine());
		}
			
			
		make_set(N);
		
		// O : 1 --> P Q 동맹
		// O : 2 --> P Q 전쟁
		for (int i = 0; i < M; i++) {
			String[] OPQ = br.readLine().split(" ");
			int O = Integer.parseInt(OPQ[0]);
			int P = Integer.parseInt(OPQ[1]);
			int Q = Integer.parseInt(OPQ[2]);
			
			if (O == 1) {
				union(P,Q);
			};
			if (O == 2) {
				battle(P, Q);
			}

			
			
			
		}
		
		// asc;
		Arrays.sort(troops);
		
		StringBuilder sb = new StringBuilder();
		int left_countries_cnt = 0;
		for (int t : troops) {
			if (t > 0) {
				left_countries_cnt++;
				sb.append(t + " ");
			}
		}
		
//		System.out.println(Arrays.toString(troops));
//		
//		System.out.println("parents -- >" + Arrays.toString(parents));
		
		// res
		System.out.println(left_countries_cnt + "\n" + sb);
		
		
	}
	
	// make_set
	public static void make_set(int x) {
		parents = new int[x+1];
		for (int i = 1; i < x+1; i++) {
			parents[i] = i;
		}	
	}
	
	// find_set
	public static int find_set(int k) {
		if (parents[k] != k) {
			parents[k] = find_set(parents[k]);
		}
		return parents[k];
	}
	
	// union
	public static void union(int a, int b) {
		int boss_a = find_set(a);
		int boss_b = find_set(b);
		
		if (boss_a == boss_b) {
			return;
		}
		
		
		// comparison
		if (troops[boss_a] >= troops[boss_b]) {
			troops[boss_a] += troops[boss_b];
			troops[boss_b] = 0;
			parents[boss_b] = boss_a;
		}
		else if (troops[boss_a] < troops[boss_b]) {
			troops[boss_b] += troops[boss_a];
			troops[boss_a] = 0;
			parents[boss_a] = boss_b;
		}
		
		
	}
	
	
	
	
	// battle
	public static void battle(int a, int b) {
		int boss_a = find_set(a);
		int boss_b = find_set(b);
		
		if (boss_a == boss_b) {
			return;
		}
		
		if (troops[boss_a] == troops[boss_b]) {
			troops[boss_a] = 0;
			troops[boss_b] = troops[boss_a];
		}
		else if (troops[boss_a] > troops[boss_b]) {
			troops[boss_a] -= troops[boss_b];
			troops[boss_b] = 0;
			parents[boss_b] = boss_a;
		}
		else if (troops[boss_a] < troops[boss_b]) {
			troops[boss_b] -= troops[boss_a];
			troops[boss_a] = 0;
			parents[boss_a] = boss_b;
		}
	}
	
	
	
	
}