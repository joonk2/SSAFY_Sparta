class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;

        int R = board.length;
        int C = board[0].length;
        
        int[][] DP = new int[R+1][C+1];
        for (int r = 1; r < R+1; r++) {
            for (int c = 1; c < C+1; c++) {
                DP[r][c] = board[r-1][c-1];
            }
        }
        
        // recursive_formula
        int max_val = Integer.MIN_VALUE;
        for (int r = 1; r < R+1; r++) {
            for (int c = 1; c < C+1; c++) {
                if (DP[r][c] == 1) {
                    DP[r][c] = Math.min(DP[r][c-1], Math.min(DP[r-1][c-1], DP[r-1][c]))+1;
                    max_val = Math.max(DP[r][c], max_val);
                }
            }
        }
        
        answer = max_val * max_val;
        return answer;
    }
}