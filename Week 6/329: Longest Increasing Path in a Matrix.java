class Solution {
    int[][] memo;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxPath = 0;
        memo = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }

    public int dfs(int[][] matrix, int i, int j) {
        // Return cached result
        if (memo[i][j] != 0) return memo[i][j];

        int maxLen = 1;
        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, x, y));
            }
        }
        // Store result in memo table
        memo[i][j] = maxLen;
        return maxLen;
    }
}
