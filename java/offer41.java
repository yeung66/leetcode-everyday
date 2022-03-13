import java.util.*;

class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<>();
    }

    List<Integer> nums;
    
    public void addNum(int num) {
        if (nums.size() == 0) nums.add(num);
        else {
            int pos = Collections.binarySearch(nums, num);
            if (pos < 0) pos = - (pos + 1);
            nums.add(pos, num);
        }
    }
    
    public double findMedian() {
        if (nums.size() % 2 == 1) return nums.get(nums.size() / 2);
        else return (double) (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 -1)) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */