// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int num : arr) {
            if (num >= 0)
                pos.add(num);
            else
                neg.add(num);
        }
        arr.clear();
        int i = 0, j = 0;
        boolean turnPos = true;

        while (i < pos.size() && j < neg.size()) {
            if (turnPos) {
                arr.add(pos.get(i++));
            } else {
                arr.add(neg.get(j++));
            }
            turnPos = !turnPos;
        }
        while (i < pos.size())
            arr.add(pos.get(i++));
        while (j < neg.size())
            arr.add(neg.get(j++));
    }
}
