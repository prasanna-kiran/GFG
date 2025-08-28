class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0, zeros = 0, maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) zeros++;
            while (zeros > k) {
                if (arr[left] == 0) zeros--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
