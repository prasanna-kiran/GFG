class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        
        // If students are more than books, not possible
        if (k > n) return -1;
        
        int low = 0, high = 0;
        
        for (int pages : arr) {
            low = Math.max(low, pages); // Minimum possible max = max single book
            high += pages;             // Maximum possible max = sum of all books
        }
        
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, n, k, mid)) {
                result = mid; // store possible answer
                high = mid - 1; // try for smaller max
            } else {
                low = mid + 1; // increase limit
            }
        }
        
        return result;
    }
    
    // Check if possible to allocate books so that max pages <= mid
    private boolean isPossible(int[] arr, int n, int k, int mid) {
        int studentsRequired = 1;
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (currentSum + arr[i] > mid) {
                studentsRequired++;
                currentSum = arr[i];
                
                if (studentsRequired > k) return false;
            } else {
                currentSum += arr[i];
            }
        }
        return true;
    }
}