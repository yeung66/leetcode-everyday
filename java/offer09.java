import java.util.Stack;

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.size() == 0) {
            return -1;
        }

        int ans = stack1.pop();
        while (!stack1.empty()) {
            stack2.push(ans);
            ans = stack1.pop();
        }

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        return ans;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */