class Solution {
    public ArrayList<Integer> asciirange(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> firstIndex = new HashMap<>();
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!firstIndex.containsKey(c)) {
                firstIndex.put(c, i);
            }
            lastIndex.put(c, i);
        }
        for (char c : firstIndex.keySet()) {
            int start = firstIndex.get(c);
            int end = lastIndex.get(c);
            if (start != end) {
                int sum = 0;
                for (int i = start + 1; i < end; i++) {
                    sum += (int) s.charAt(i);
                }
                if (sum != 0) {
                    result.add(sum);
                }
            }
        }
        return result;
    }
}