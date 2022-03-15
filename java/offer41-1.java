import java.util.*;

class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((i1, i2) -> i2 - i1);
    }

    Queue<Integer> A;
    Queue<Integer> B;
    
    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.offer(num);
            A.offer(B.poll());
        } else {
            A.offer(num);
            B.offer(A.poll());
        }
    }
    
    public double findMedian() {
        return A.size() == B.size() ? (double) (A.peek() + B.peek()) / 2 : A.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */