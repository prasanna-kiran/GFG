class Solution {
    public int countTriangles(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {4, 6, 3, 7};
        System.out.println(sol.countTriangles(arr1));
        int[] arr2 = {10, 21, 22, 100, 101, 200, 300};
        System.out.println(sol.countTriangles(arr2));
        int[] arr3 = {1, 2, 3};
        System.out.println(sol.countTriangles(arr3));
    }
}