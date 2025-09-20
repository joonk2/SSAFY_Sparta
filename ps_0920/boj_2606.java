/*
1번부터 감염시켜 고장난 컴퓨터 수를 구하는 문제다.
제한시간 1초 --> java는 연산횟수 1억 이내
정점의 갯수 -> N
간선의 갯수 -> M


----------- 최악의 실행시간 ------------
그래프 생성 -> O(M)
정렬 -> O(M log N)
1차원 DFS -> O(N + M)

그러므로 충분히 1억 이내에 통과한다.
*/


package boj;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// graph
import java.util.ArrayList;

// asc
import java.util.Collections;

// Stack
import java.util.Stack;



public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// allocating size of grpah;
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
		int V = 1;
		DFS(V);
	}
	
	
	
	static void DFS(int start_node) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start_node);
		int cnt = 0;
		
		while (!stack.isEmpty()) {
			int cur_node = stack.pop();
			if (!visited[cur_node]) {
				visited[cur_node] = true;
				cnt++;
//				System.out.println(cur_node);
				
				ArrayList<Integer> neighbors = graph[cur_node];
				for (int i = neighbors.size()-1; i >= 0; i--) {
					int next_node = neighbors.get(i);
					if (!visited[next_node]) {
						stack.push(next_node);
					}
				}
				
				
			}
		}
		System.out.println(--cnt);
		
	}
	
	
	
}