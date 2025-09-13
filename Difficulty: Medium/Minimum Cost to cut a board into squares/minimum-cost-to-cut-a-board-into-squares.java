import java.util.*;

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        int i = x.length - 1; 
        int j = y.length - 1; 
        int horizontalSegments = 1;
        int verticalSegments = 1;
        int totalCost = 0;

        while (i >= 0 && j >= 0) {
            if (x[i] >= y[j]) {
                totalCost += x[i] * horizontalSegments;
                verticalSegments++;
                i--;
            } else {
                totalCost += y[j] * verticalSegments;
                horizontalSegments++;
                j--;
            }
        }

        while (i >= 0) {
            totalCost += x[i] * horizontalSegments;
            verticalSegments++;
            i--;
        }

        while (j >= 0) {
            totalCost += y[j] * verticalSegments;
            horizontalSegments++;
            j--;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n1 = 4, m1 = 6;
        int[] x1 = {2, 1, 3, 1, 4};
        int[] y1 = {4, 1, 2};
        System.out.println(minCost(n1, m1, x1, y1)); // 42

        int n2 = 4, m2 = 4;
        int[] x2 = {1, 1, 1};
        int[] y2 = {1, 1, 1};
        System.out.println(minCost(n2, m2, x2, y2)); // 15
    }
}

