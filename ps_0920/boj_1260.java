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

// test
import java.util.Arrays;


public class Main {
	// graph
	static ArrayList<Integer>[] graph;
	// visited
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
		
		visited = new boolean[N+1];
		DFS(V);
		
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(V);
	}
	
	
	
	
	static void DFS(int start_node) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start_node);
		
		while (!stack.isEmpty()) {
			int cur_node = stack.pop();
			if (!visited[cur_node]) {
				visited[cur_node] = true;
				System.out.print(cur_node + " ");
				
				ArrayList<Integer> neighbors = graph[cur_node];
				for (int i = neighbors.size()-1; i >= 0; i--) {
					int next_node = neighbors.get(i);
					if(!visited[next_node]) {
						stack.push(next_node);
					}
				}
				
			}
		}
		
	}
	
	
	
	
	static void BFS(int start_node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start_node);
		visited[start_node] = true;
		
		while (!q.isEmpty()) {
			int cur_node = q.poll();
			System.out.print(cur_node + " ");
			
			ArrayList<Integer> neighbors = graph[cur_node];
			for (int next_node : neighbors) {
				if (!visited[next_node]) {
					visited[next_node] = true;
					q.offer(next_node);
				}
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
}