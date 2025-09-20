// User function Template for Java

import java.util.*;

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }
        int ans = -1;
        for (int i = 0; i < k; i++) {
            ans = minHeap.poll();
        }
        return ans;
    }
}
