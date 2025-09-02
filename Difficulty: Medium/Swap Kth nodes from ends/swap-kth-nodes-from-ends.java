/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return head;
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (k > n) return head;
        if (2 * k - 1 == n) return head;
        Node x = head, xPrev = null;
        for (int i = 1; i < k; i++) {
            xPrev = x;
            x = x.next;
        }
        Node y = head, yPrev = null;
        for (int i = 1; i < n - k + 1; i++) {
            yPrev = y;
            y = y.next;
        }
        if (xPrev != null) xPrev.next = y;
        if (yPrev != null) yPrev.next = x;
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;
        if (k == 1) head = y;
        if (k == n) head = x;
        return head;
    }
}
