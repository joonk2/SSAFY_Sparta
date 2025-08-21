package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// graph
import java.util.ArrayList;

// DFS
import java.util.Stack;
import java.util.List;

// asc
import java.util.Collections;


public class boj_2606_바이러스 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// allocating the size of graph
		graph = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// asc
		for (int i = 1; i < N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		
		// res
		int V = 1;
		visited = new boolean[N+1];
		DFS(V);
	}
	
	
	
	
	public static void DFS(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		int cnt = 0;
		while (!stack.isEmpty()) {
			int node = stack.pop();
			
			
			if (!visited[node]) visited[node] = true;
			else if (visited[node]) continue;
//			System.out.print(node + " ");
			cnt++;
			
			// neighbors
			List<Integer> neighbor = graph[node];
			for (int i = neighbor.size()-1; i >= 0; i--) {
				int next = neighbor.get(i);
				if (!visited[next]) {
					stack.push(next);
				}
			}
		}
		System.out.println(--cnt);
		
	}
	
	
	
}