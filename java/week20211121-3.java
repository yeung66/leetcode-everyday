import java.util.*;

// unsolved
class RangeFreqQuery {
    private Map<Integer, List<Integer>> valIdx;
    

    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        valIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (valIdx.containsKey(arr[i])) {
                valIdx.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                valIdx.put(arr[i], list);
            }
        }
    }

    public int query(int left, int right, int value) {
        int ans = 0;
        if (valIdx.containsKey(value)) {
            var list = valIdx.get(value);

            int leftIdx = Collections.binarySearch(list, left);
            int rightIdx = Collections.binarySearch(list, right);
            leftIdx = leftIdx < 0 ? - (leftIdx + 1) : leftIdx;
            rightIdx = rightIdx < 0 ? - (rightIdx + 1) - 1: rightIdx;
            ans = rightIdx - leftIdx + 1 > 0 ? rightIdx - leftIdx + 1 : 0;
        }
        
        return ans;
    }

}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr); int param_1 =
 * obj.query(left,right,value);
 */