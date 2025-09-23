import java.util.*;
class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }
}