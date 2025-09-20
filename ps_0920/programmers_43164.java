import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

import java.util.List;
import java.util.LinkedList;


class Solution {
    static Map<String, PriorityQueue<String>> graph;
    static List<String> route;
    
    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        route = new LinkedList<>();
        
        for (String[] t : tickets) {
            String from = t[0];
            String to = t[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).add(to);
        }
        
        
        String start_node = "ICN";
        DFS(start_node);
        
        String[] answer = new String[route.size()];
        for (int i = 0; i < route.size(); i++) {
            answer[i] = route.get(i);
        }
        return answer;
    }
    
    
    
    static void DFS(String cur_node) {
        PriorityQueue<String> pq = graph.get(cur_node);
        while (pq != null && !pq.isEmpty()) {
            String next_node = pq.poll();
            DFS(next_node);
        }
        route.add(0, cur_node);
    }
    
    
    
}