class Solution {
    int maxProduct(int[] arr) {
        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(arr[i], arr[i] * maxProd);
            minProd = Math.min(arr[i], arr[i] * minProd);
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
