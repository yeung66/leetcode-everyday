class MyStack {

    public MyStack() {
        queue = new LinkedList<>();
        size = 0;
    }

    Queue<Integer> queue;
    int size;

    
    public void push(int x) {
        queue.offer(x);
        for (int i=0;i<size;i++) {
            queue.offer(queue.poll());
        }
        size++;
    }
    
    public int pop() {
        size--;
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */