import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int N;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
    
    
    static int bfs(String begin, String target, String[] words) {
        N = words.length;
        visited = new boolean[N];
        
        Queue<int[]> q = new LinkedList<>();
        
        
        // 최초 1회 알파벳 1개개 다른 단어 q에 삽입
        for (int i = 0; i < N; i++) {
            if (!visited[i] && diff(begin, words[i])) {
                q.add(new int[] {i, 1});
                visited[i] = true;
            }
        }
        
        // 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int dist = cur[1];
            
            // 가지치기
            if (words[idx].equals(target)) {
                return dist;
            }
            
            for (int i = 0; i < N; i++) {
                if (!visited[i] && diff(words[idx], words[i])) {
                    q.add(new int[] {i, dist+1});
                    visited[i] = true;
                }
            }
            
        }
        
        
        return 0;
    }
    
    
    
    static boolean diff(String s1, String s2) {
        int temp_cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                temp_cnt++;
            }
            if (temp_cnt > 1) {
                return false;
            }
        }
        return true;
    }
    
    
}