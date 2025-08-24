class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        if (n < m * k) {
            return -1;
        }
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int day : arr) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(arr, k, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canMakeBouquets(int[] arr, int k, int m, int day) {
        int bouquets = 0;
        int consecutive = 0;
        for (int d : arr) {
            if (d <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        return bouquets >= m;
    }
}