class Solution {
    int m, n;
    int[][] grid;
    int[][][] memo;

    int solve(int r, int c, int d) {
        if (memo[r][c][d] != -2)
            return memo[r][c][d];

        int nr = r;
        int nc = c;

        if (d == 0)
            nc++;
        else
            nr++;

        if (nr >= m || nc >= n)
            return memo[r][c][d] = -1;

        if (grid[nr][nc] == 1)
            return memo[r][c][d] = solve(nr, nc, 1 - d);

        return memo[r][c][d] = nr * n + nc;
    }

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int MOD = 1000000007;

        memo = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0)
                    continue;

                for (int d = 0; d < 2; d++) {

                    int pos = solve(i, j, d);

                    if (pos == -1)
                        continue;

                    int x = pos / n;
                    int y = pos % n;

                    dp[x][y] = (int)(
                        (dp[x][y] + (long)dp[i][j]) % MOD
                    );
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}