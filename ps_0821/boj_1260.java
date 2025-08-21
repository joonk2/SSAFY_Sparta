package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// graph
import java.util.ArrayList;

// asc
import java.util.Collections;

// DFS
import java.util.Stack;
import java.util.List;

// BFS
import java.util.Queue;
import java.util.LinkedList;


public class boj_1260_DFS와BFS {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMV = br.readLine().split(" ");
		int N = Integer.parseInt(NMV[0]);
		int M = Integer.parseInt(NMV[1]);
		int V = Integer.parseInt(NMV[2]);
		
		// allocating size of graph
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
		visited = new boolean[N+1];
		DFS(V);
		
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(V);
	}
	
	
	
	public static void DFS(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) visited[node] = true;
			else if (visited[node]) continue;
			System.out.print(node + " ");
			
			// neighbor
			List<Integer> neighbors = graph[node];
			for (int i = graph[node].size()-1; i >= 0; i--) {
				int next = graph[node].get(i);
				if (!visited[next]) stack.push(next);
			}
			
			
		}
		
		
	}
	
	
	
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			
			for (int next : graph[node]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
	}
	
	
	
	
	
	
}