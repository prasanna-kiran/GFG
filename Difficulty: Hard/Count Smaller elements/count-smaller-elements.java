// User function Template for Java

import java.util.*;

class Solution {
    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        // 1. Coordinate compression: map unique numbers to 1..size
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

        // 2. BIT/Fenwick Tree
        int size = rank.size();
        int[] bit = new int[size + 2];

        for (int i = n - 1; i >= 0; i--) {
            int idx = rank.get(arr[i]);
            res[i] = query(bit, idx - 1); // count of smaller elements
            update(bit, idx, 1);          // add current element
        }

        return res;
    }

    // query sum of elements <= idx
    private int query(int[] bit, int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    // update BIT at idx by val
    private void update(int[] bit, int idx, int val) {
        while (idx < bit.length) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }
}

