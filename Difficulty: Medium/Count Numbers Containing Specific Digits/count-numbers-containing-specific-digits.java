class Solution {
    public int countValid(int n, int[] arr) {
        boolean[] hasDigit = new boolean[10];
        for (int d : arr) hasDigit[d] = true;

        int total = (int)Math.pow(10, n) - (int)Math.pow(10, n - 1);
        int exclude = countWithoutDigits(n, hasDigit);

        return total - exclude;
    }

    private int countWithoutDigits(int n, boolean[] hasDigit) {
        int[] digits = new int[n];
        int pos = 0;
        for (int i = n - 1; i >= 0; i--) digits[pos++] = 9;

        int[][][] dp = new int[n + 1][2][2];
        for (int[][] layer : dp)
            for (int[] row : layer) java.util.Arrays.fill(row, -1);

        return dfs(0, true, false, digits, hasDigit, dp);
    }

    private int dfs(int i, boolean tight, boolean started, int[] digits, boolean[] hasDigit, int[][][] dp) {
        if (i == digits.length) return started ? 1 : 0;
        if (dp[i][tight ? 1 : 0][started ? 1 : 0] != -1)
            return dp[i][tight ? 1 : 0][started ? 1 : 0];

        int limit = tight ? digits[i] : 9;
        int res = 0;

        for (int d = 0; d <= limit; d++) {
            if (hasDigit[d]) continue; // skip if digit is in forbidden list
            if (d == 0 && !started) continue; // leading zero is not allowed for n-digit numbers
            res += dfs(i + 1, tight && (d == limit), started || d != 0, digits, hasDigit, dp);
        }

        dp[i][tight ? 1 : 0][started ? 1 : 0] = res;
        return res;
    }
}
