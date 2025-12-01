import java.util.ArrayList;

public class Solution {
    static class Node {
        int[] child = new int[]{-1, -1};
        int count = 0;
    }

    private ArrayList<Node> trie;
    private int m;
    private int K;

    private void insert(int x) {
        int node = 0;
        trie.get(node).count++;
        for (int i = m - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (trie.get(node).child[b] == -1) {
                trie.get(node).child[b] = trie.size();
                trie.add(new Node());
            }
            node = trie.get(node).child[b];
            trie.get(node).count++;
        }
    }

    private int countLess(int x) {
        int node = 0;
        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (node == -1) break;
            int xb = (x >> i) & 1;
            int kb = (K >> i) & 1;
            if (kb == 1) {
                int same = trie.get(node).child[xb];
                if (same != -1) res += trie.get(same).count;
                node = trie.get(node).child[xb ^ 1];
            } else {
                node = trie.get(node).child[xb];
            }
        }
        return res;
    }

    public int cntPairs(int[] arr, int k) {
        if (arr == null || arr.length < 2) return 0;
        this.K = k;
        int maxVal = k;
        for (int v : arr) if (v > maxVal) maxVal = v;
        m = 0;
        while ((1 << m) <= maxVal) m++;
        trie = new ArrayList<>();
        trie.add(new Node());
        long ans = 0L;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) ans += countLess(arr[i]);
            insert(arr[i]);
        }
        return (int) ans;
    }
}



