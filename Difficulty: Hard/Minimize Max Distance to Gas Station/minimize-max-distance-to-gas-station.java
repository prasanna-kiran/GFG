class Solution {
    public double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        double low = 0, high = 0;

        for (int i = 1; i < n; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2;
            if (possible(stations, K, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return Math.round(high * 100.0) / 100.0;
    }

    private boolean possible(int[] stations, int K, double mid) {
        int used = 0;
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            used += Math.ceil(gap / mid) - 1;
        }
        return used <= K;
    }
}
