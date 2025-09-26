class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;

        k %= n;
        if (k == 0) return;

        List<Integer> list = new ArrayList<>(dq);
        dq.clear();

        if (type == 1) { 
            for (int i = n - k; i < n; i++) dq.addLast(list.get(i));
            for (int i = 0; i < n - k; i++) dq.addLast(list.get(i));
        } else { 
            for (int i = k; i < n; i++) dq.addLast(list.get(i));
            for (int i = 0; i < k; i++) dq.addLast(list.get(i));
        }
    }

    public static void main(String[] args) {
        Deque<Integer> dq1 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        rotateDeque(dq1, 1, 2);
        System.out.println(dq1);

        Deque<Integer> dq2 = new ArrayDeque<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateDeque(dq2, 2, 3);
        System.out.println(dq2);
    }
}
