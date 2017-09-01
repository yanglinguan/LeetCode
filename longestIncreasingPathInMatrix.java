class Solution {
    private int n;
    private int m;
    
    private int[][] dp;
    
    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int cur = matrix[i][j];
        int max = 1;
        int x = 0; 
        if (i > 0 && cur < matrix[i - 1][j]) {
            x = 1 + dfs(matrix, i - 1, j, dp);
            max = max > x ? max : x;
        }
        if (i < n - 1 && cur < matrix[i+1][j]) {
            x = 1 + dfs(matrix, i + 1, j, dp);
            max = max > x ? max : x;
        }
        if (j > 0 && cur < matrix[i][j - 1]) {
            x = 1 + dfs(matrix, i, j - 1, dp);
            max = max > x ? max : x;
        }
        if (j < m - 1 && cur < matrix[i][j + 1]) {
            x = 1 + dfs(matrix, i, j + 1, dp);
            max = max > x ? max : x;
        }
        
        dp[i][j] = max;
        
        return max;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        if(n == 0) return 0;
        m = matrix[0].length;
        dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int x = dfs(matrix, i, j, dp);
                max = max > x? max: x;
            }
        }
        return max;
    }
}
