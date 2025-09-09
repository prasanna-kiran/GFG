import java.util.*;
class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();
        int sum = 0;
        java.util.function.Consumer<Integer> add = (num) -> {
            int oldFreq = freq.getOrDefault(num, 0);
            int newFreq = oldFreq + 1;
            freq.put(num, newFreq);
            if (oldFreq > 0) {
                TreeSet<Integer> oldSet = freqMap.get(oldFreq);
                oldSet.remove(num);
                if (oldSet.isEmpty()) freqMap.remove(oldFreq);
            }
            freqMap.computeIfAbsent(newFreq, x -> new TreeSet<>()).add(num);
        };
        java.util.function.Consumer<Integer> remove = (num) -> {
            int oldFreq = freq.get(num);
            int newFreq = oldFreq - 1;
            TreeSet<Integer> oldSet = freqMap.get(oldFreq);
            oldSet.remove(num);
            if (oldSet.isEmpty()) freqMap.remove(oldFreq);
            if (newFreq > 0) {
                freq.put(num, newFreq);
                freqMap.computeIfAbsent(newFreq, x -> new TreeSet<>()).add(num);
            } else {
                freq.remove(num);
            }
        };
        for (int i = 0; i < k; i++) add.accept(arr[i]);
        sum += freqMap.lastEntry().getValue().first();
        for (int i = k; i < n; i++) {
            add.accept(arr[i]);
            remove.accept(arr[i - k]);
            sum += freqMap.lastEntry().getValue().first();
        }
        return sum;
    }
}
