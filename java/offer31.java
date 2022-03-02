import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for (var i : pushed) {
            stack.add(i);

            while (!stack.empty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }

        return stack.empty();
    }
}