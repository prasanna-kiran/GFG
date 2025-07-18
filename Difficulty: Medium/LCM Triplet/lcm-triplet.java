class Solution {
    int lcmTriplets(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;
        long res;
        if (n % 2 != 0) {
            res = (long) n * (n - 1) * (n - 2);
        } else {
            if (gcd(n, n - 3) == 1) {
                res = (long) n * (n - 1) * (n - 3);
            } else {
                res = (long) (n - 1) * (n - 2) * (n - 3);
            }
        }
        return (int) res;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}