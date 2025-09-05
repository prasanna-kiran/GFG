/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public static Node segregate(Node head) {
        int count[] = {0, 0, 0};  // count[0], count[1], count[2]
        Node ptr = head;

        // Count the number of 0's, 1's and 2's
        while (ptr != null) {
            count[ptr.data]++;
            ptr = ptr.next;
        }

        int i = 0;
        ptr = head;

        // Update the linked list
        while (ptr != null) {
            if (count[i] == 0)
                i++;
            else {
                ptr.data = i;
                count[i]--;
                ptr = ptr.next;
            }
        }
        return head;
    }
}