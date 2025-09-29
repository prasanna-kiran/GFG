class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        long ans = Long.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int r = a; r <= n; r++) {
            int left = r - b;
            int right = r - a;
            while (!dq.isEmpty() && dq.peekFirst() < left) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[right]) {
                dq.pollLast();
            }
            dq.addLast(right);
            ans = Math.max(ans, prefix[r] - prefix[dq.peekFirst()]);
        }
        return (int) ans;
    }
}
