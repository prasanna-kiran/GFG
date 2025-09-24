import java.util.*;

class SpecialQueue {
    private Deque<Integer> q;
    private Deque<Integer> minQ;
    private Deque<Integer> maxQ;

    public SpecialQueue() {
        q = new ArrayDeque<>();
        minQ = new ArrayDeque<>();
        maxQ = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        q.offer(x);
        while (!minQ.isEmpty() && minQ.peekLast() > x) {
            minQ.pollLast();
        }
        minQ.offer(x);
        while (!maxQ.isEmpty() && maxQ.peekLast() < x) {
            maxQ.pollLast();
        }
        maxQ.offer(x);
    }

    public void dequeue() {
        if (q.isEmpty()) return;
        int removed = q.poll();
        if (!minQ.isEmpty() && minQ.peekFirst() == removed) {
            minQ.pollFirst();
        }
        if (!maxQ.isEmpty() && maxQ.peekFirst() == removed) {
            maxQ.pollFirst();
        }
    }

    public int getFront() {
        return q.peek();
    }

    public int getMin() {
        return minQ.peekFirst();
    }

    public int getMax() {
        return maxQ.peekFirst();
    }
}
