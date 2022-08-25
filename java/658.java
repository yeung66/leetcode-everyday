import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = Arrays.binarySearch(arr, x);
        if (idx < 0) {
            idx = - (idx + 1);
        }

        int l = idx - 1, r = idx; 
        Deque<Integer> ansQueue = new LinkedList<>();

        while (k > 0 && l > 0 && r < 0) {
            if (arr[r] - x < x - arr[l]) {
                ansQueue.addLast(arr[r]);
                r++;
            } else {
                ansQueue.addFirst(arr[l]);
                l--;
            }
            k--;
        }

        while (k>0&&l>0) {
            ansQueue.addFirst(arr[l]);
            l--;
            k--;
        }

        while (k>0&&r<n) {
            ansQueue.addLast(arr[r]);
            r++;
            k--;
        }

        return ansQueue.stream().collect(Collectors.toList());
    }
}