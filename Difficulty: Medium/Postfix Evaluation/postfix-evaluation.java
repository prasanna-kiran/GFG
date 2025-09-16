class Solution {
    public static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String token : arr) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOp(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private static boolean isOperator(String s) {
        return "+-*/^".contains(s);
    }
    private static int applyOp(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return (int)Math.floorDiv(a, b);
            case "^": return (int)Math.pow(a, b);
        }
        return 0;
    }
    public static void main(String[] args) {
        String[] arr1 = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr1));
        String[] arr2 = {"2", "3", "^", "1", "+"};
        System.out.println(evaluatePostfix(arr2));
    }
}