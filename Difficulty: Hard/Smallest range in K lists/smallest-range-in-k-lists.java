//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Element implements Comparable<Element> {
        int value, row, col;

        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Element other) {
            return this.value - other.value;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.offer(new Element(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (minHeap.size() == k) {
            Element curr = minHeap.poll();
            int min = curr.value;

            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            if (curr.col + 1 < n) {
                int nextVal = arr[curr.row][curr.col + 1];
                minHeap.offer(new Element(nextVal, curr.row, curr.col + 1));
                max = Math.max(max, nextVal);
            } else {
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(rangeStart);
        result.add(rangeEnd);
        return result;
    }
}
