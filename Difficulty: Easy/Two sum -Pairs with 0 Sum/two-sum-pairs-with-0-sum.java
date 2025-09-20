// User function Template for Java

import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr); // sort first
        int n = arr.length;
        int left = 0, right = n - 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                res.add(pair);

                int leftVal = arr[left];
                int rightVal = arr[right];

                // skip duplicates
                while (left < right && arr[left] == leftVal) left++;
                while (left < right && arr[right] == rightVal) right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}

