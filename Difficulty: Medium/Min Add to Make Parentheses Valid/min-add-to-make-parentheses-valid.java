class Solution {
    public int minParentheses(String s) {
        int open = 0, add = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }
        return add + open;
    }
}
