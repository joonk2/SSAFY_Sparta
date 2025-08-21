package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// graph
import java.util.ArrayList;

// asc
import java.util.Collections;

// BFS
import java.util.Queue;
import java.util.LinkedList;



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
		visited = new boolean[N+1];
		int V = 1;
		BFS(V);
	}
	
	
	
	
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			if (!visited[node]) visited[node] = true;
			cnt++;
			
//			System.out.print(node + " ");
			
			// neighbor
			ArrayList<Integer> neighbor = graph[node];
			
			for (int i = 0; i < neighbor.size(); i++) {
				int next = neighbor.get(i);
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		System.out.println(--cnt);
		
	}
	
	
	
	
}