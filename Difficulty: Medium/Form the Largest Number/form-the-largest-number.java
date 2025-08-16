import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        // Convert numbers to strings
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Sort using custom comparator
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        // If largest number is "0", then all numbers are 0
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Build final result
        StringBuilder result = new StringBuilder();
        for (String s : strArr) {
            result.append(s);
        }

        return result.toString();
    }
}
