import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int maxFromRight = arr[n - 1]; 
        ans.add(maxFromRight); // rightmost is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                ans.add(maxFromRight);
            }
        }

        Collections.reverse(ans); // reverse to maintain left-to-right order
        return ans;
    }
}
