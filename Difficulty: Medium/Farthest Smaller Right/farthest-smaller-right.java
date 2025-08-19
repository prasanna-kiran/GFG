class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1, res = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (suffixMin[mid] < arr[i]) {
                    res = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans.add(res == -1 ? -1 : res);
        }
        return ans;
    }
}