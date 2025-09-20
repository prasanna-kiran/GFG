import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (i < n && j < m) {
            // Skip duplicates in a[]
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicates in b[]
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                res.add(a[i++]);
            } else if (a[i] > b[j]) {
                res.add(b[j++]);
            } else { // equal
                res.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements from a[]
        while (i < n) {
            if (i == 0 || a[i] != a[i - 1]) res.add(a[i]);
            i++;
        }

        // Add remaining elements from b[]
        while (j < m) {
            if (j == 0 || b[j] != b[j - 1]) res.add(b[j]);
            j++;
        }

        return res;
    }
}
