import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        if (n == 0)
            return new ArrayList<>();

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();
        result.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = arr[i];

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                result.add(current);
            }
        }

        return result;
    }
}
