/*
1 <= n,m <= 100

완전탐색시 최악의 실행시간
bfs 탐색 -> 100 * 100 * 4
q 삽입, 삭제 -> 10000 + 10000

도합 60000번

그러므로 완전탐색을 사용해도 괜찮다
*/


class Solution {
    static int answer;
    static int N;
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    static void dfs(int idx, int val, int target, int[] numbers) {
        
        // pruning
        if (idx == N && val == target) {
            answer++;
            return;
        }
        else if (idx == N) {
            return;
        }
        
        dfs(idx+1, val + numbers[idx], target, numbers);
        dfs(idx+1, val - numbers[idx], target, numbers);
    }
    
    
    
}