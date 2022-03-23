class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    int j = stack.pop();
                    ans = Math.max(ans, i - (stack.isEmpty() ? -1 : stack.peek()));
                } else 

                stack.push(i);
            }
        }

        return ans;
    }
}