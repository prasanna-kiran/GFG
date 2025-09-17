class Solution {
    static String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); 
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(currStr);
                k = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(currStr);
                }
                currStr = decoded;
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[b2[ca]]")); // bcacabcacabcaca
        System.out.println(decodeString("3[ab]"));     // ababab
    }
}
